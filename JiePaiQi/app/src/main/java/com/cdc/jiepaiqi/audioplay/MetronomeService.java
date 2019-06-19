package com.cdc.jiepaiqi.audioplay;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import com.cdc.jiepaiqi.R;

public class MetronomeService extends Service implements Runnable {
    private final static String TAG = "MetronomeService";
    public static final String PREF_INTERVAL = "interval";

    public static final String ACTION_START = "james.metronome.ACTION_START";
    public static final String ACTION_PAUSE = "james.metronome.ACTION_PAUSE";

    public static final String EXTRA_BPM = "james.metronome.EXTRA_BPM";
    private final IBinder binder = new LocalBinder();
    private SharedPreferences prefs;
    private int bpm;
    private long interval;

    private SoundPool soundPool;
    private Handler handler;
    private int soundId = -1;
    private boolean isPlaying;
    private TickListener listener;




    @Override
    public void run() {
        if (isPlaying) {
            handler.postDelayed(this, interval);
            if (soundId != -1)
                soundPool.play(soundId, 1, 1, 0, 0,  1.5f);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(new AudioAttributes.Builder()
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build())
                    .build();
        } else {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }
        soundId=soundPool.load(this, R.raw.a_0, 1);
        interval = prefs.getLong(PREF_INTERVAL, 500);

        handler = new Handler();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            switch (intent.getAction()) {
                case ACTION_START:
                    Log.e(TAG, "onStartCommand,ACTION_START,bpm=" + bpm);
                    setBpm(intent.getIntExtra(EXTRA_BPM, bpm));
                    pause();
                    play();
                    break;
                case ACTION_PAUSE:
                    Log.e(TAG, "onStartCommand,ACTION_PAUSE");
                    pause();
                    break;
            }
        }
        return START_STICKY;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
        interval = toInterval(bpm);
        prefs.edit().putLong(PREF_INTERVAL, interval).apply();
        if (listener != null)
            listener.onBpmChanged(bpm);
    }

    private static int toBpm(long interval) {
        return (int) (60000 / interval);
    }

    private static long toInterval(int bpm) {
        return (long) 60000 / bpm;
    }
    public void setTickListener(TickListener listener) {
        this.listener = listener;
    }


    public void play() {
        handler.post(this);
        isPlaying = true;
        Intent intent = new Intent(this, MetronomeService.class);
        intent.setAction(ACTION_PAUSE);
        if (listener != null) {
            listener.onStartTicks();
        }
    }

    public void pause() {
        handler.removeCallbacks(this);
        isPlaying = false;
        if (listener != null) {
            listener.onStopTicks();
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }


    public int getBpm() {
        return bpm;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        listener = null;
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(this);
        super.onDestroy();
    }

    public class LocalBinder extends Binder {
        public MetronomeService getService() {
            return MetronomeService.this;
        }
    }


    public interface TickListener {
        void onStartTicks();
        void onBpmChanged(int bpm);
        void onStopTicks();
    }

}
