package james.metronome.activities;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.widget.Toast;
import james.metronome.R;
import james.metronome.services.MetronomeService;
import james.metronome.utils.ConversionUtils;
import james.metronome.utils.WhileHeldListener;
import james.metronome.views.AppIconView;
import james.metronome.views.EmphasisSwitch;
import james.metronome.views.MetronomeView;
import james.metronome.views.SeekBar;
import james.metronome.views.TicksView;

public class MainActivity extends AppCompatActivity implements TicksView.OnTickChangedListener, ServiceConnection, MetronomeService.TickListener, EmphasisSwitch.OnCheckedChangeListener, SeekBar.OnProgressChangeListener {

    private static final String PREF_BOOKMARKS_LENGTH = "bookmarksLength";
    private static final String PREF_BOOKMARK = "bookmark";

    private boolean isBound;
    private MetronomeService service;

    private AppIconView appIcon;
    private MetronomeView metronomeView;
    private ImageView playView;
    private LinearLayout emphasisLayout;
    private TextView bpmView;
    private ImageView aboutView;
    private ImageView lessView;
    private ImageView moreView;
    private ImageView addEmphasisView;
    private ImageView removeEmphasisView;
    private TicksView ticksView;
    private SeekBar seekBar;


    private int colorAccent=R.color.colorAccent;
    private int textColorPrimary=R.color.textColorPrimary;

    private SharedPreferences prefs;
    private List<Integer> bookmarks;

    private long prevTouchInterval;
    private long prevTouchTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appIcon = findViewById(R.id.appIcon);
        metronomeView = findViewById(R.id.metronome);
        playView = findViewById(R.id.play);
        emphasisLayout = findViewById(R.id.emphasis);
        addEmphasisView = findViewById(R.id.add);
        removeEmphasisView = findViewById(R.id.remove);
        bpmView = findViewById(R.id.bpm);
        lessView = findViewById(R.id.less);
        moreView = findViewById(R.id.more);
        ticksView = findViewById(R.id.ticks);
        aboutView = findViewById(R.id.about);

        seekBar = findViewById(R.id.seekBar);

        seekBar.setMaxProgress(300);

        if (isBound()) {
            ticksView.setTick(service.getTick());
            metronomeView.setInterval(service.getInterval());
            seekBar.setProgress(service.getBpm());
            bpmView.setText(String.format(Locale.getDefault(), getString(R.string.bpm), String.valueOf(service.getBpm())));
            playView.setImageResource(service.isPlaying() ? R.drawable.ic_pause : R.drawable.ic_play);
            emphasisLayout.removeAllViews();
            for (boolean isEmphasis : service.getEmphasisList()) {
                emphasisLayout.addView(getEmphasisSwitch(isEmphasis, false));
            }
        }

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        bookmarks = new ArrayList<>();
        int bookmarksLength = prefs.getInt(PREF_BOOKMARKS_LENGTH, 0);
        for (int i = 0; i < bookmarksLength; i++) {
            bookmarks.add(prefs.getInt(PREF_BOOKMARK + i, -1));
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        playView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound()) {
                    if (service.isPlaying())
                        service.pause();
                    else service.play();
                }
            }
        });

        aboutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"关于页面",Toast.LENGTH_LONG).show();
            }
        });




        addEmphasisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBound()) {
                    if (service.getEmphasisList().size() < 50) {
                        emphasisLayout.addView(getEmphasisSwitch(false, true));

                        List<Boolean> emphasisList = service.getEmphasisList();
                        emphasisList.add(false);
                        service.setEmphasisList(emphasisList);
                    }
                }
            }
        });

        removeEmphasisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBound()) {
                    if (service.getEmphasisList().size() > 2) {
                        List<Boolean> emphasisList = service.getEmphasisList();
                        int position = emphasisList.size() - 1;
                        emphasisList.remove(position);
                        service.setEmphasisList(emphasisList);

                        emphasisLayout.removeViewAt(position);
                    }
                }
            }
        });

        moreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound() && service.getBpm() < 300)
                    seekBar.setProgress(service.getBpm() + 1);
            }
        });

        moreView.setOnTouchListener(new WhileHeldListener() {
            @Override
            public void onHeld() {
                if (isBound() && service.getBpm() < 300)
                    seekBar.setProgress(service.getBpm() + 1);
            }
        });

        lessView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound() && service.getBpm() > 1)
                    seekBar.setProgress(service.getBpm() - 1);
            }
        });

        lessView.setOnTouchListener(new WhileHeldListener() {
            @Override
            public void onHeld() {
                if (isBound() && service.getBpm() > 1)
                    seekBar.setProgress(service.getBpm() - 1);
            }
        });

        seekBar.setOnProgressChangeListener(this);

        ticksView.setListener(this);


        new SplashThread(this).start();
    }











    private boolean isBound() {
        return isBound && service != null;
    }

    @Override
    public void onTickChanged(int tick) {
        if (isBound())
            service.setTick(tick);
    }

    @Override
    public void onAboutViewColorChanged(int color) {
        aboutView.setColorFilter(color);
    }



    private EmphasisSwitch getEmphasisSwitch(boolean isChecked, boolean subscribe) {
        EmphasisSwitch emphasisSwitch = new EmphasisSwitch(this);
        emphasisSwitch.setChecked(isChecked);
        emphasisSwitch.setOnCheckedChangeListener(this);
        emphasisSwitch.setLayoutParams(new LinearLayout.LayoutParams(ConversionUtils.getPixelsFromDp(40), ConversionUtils.getPixelsFromDp(40)));


        return emphasisSwitch;
    }



    @Override
    protected void onStart() {
        Intent intent = new Intent(this, MetronomeService.class);
        startService(intent);
        bindService(intent, this, Context.BIND_AUTO_CREATE);

        super.onStart();
    }

    @Override
    protected void onStop() {
        if (isBound) {
            unbindService(this);
            isBound = false;
        }
        super.onStop();
    }



    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MetronomeService.LocalBinder binder = (MetronomeService.LocalBinder) iBinder;
        service = binder.getService();
        service.setTickListener(this);
        isBound = true;

        if (ticksView != null)
            ticksView.setTick(service.getTick());

        if (metronomeView != null)
            metronomeView.setInterval(service.getInterval());

        if (seekBar != null)
            seekBar.setProgress(service.getBpm());

        if (bpmView != null)
            bpmView.setText(String.format(Locale.getDefault(), getString(R.string.bpm), String.valueOf(service.getBpm())));

        if (playView != null)
            playView.setImageResource(service.isPlaying() ? R.drawable.ic_pause : R.drawable.ic_play);

        if (emphasisLayout != null) {
            emphasisLayout.removeAllViews();
            for (boolean isEmphasis : service.getEmphasisList()) {
                emphasisLayout.addView(getEmphasisSwitch(isEmphasis, true));
            }
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        isBound = false;
    }

    @Override
    public void onStartTicks() {
        playView.setImageResource(R.drawable.ic_pause);
    }

    @Override
    public void onTick(boolean isEmphasis, int index) {
        metronomeView.onTick(isEmphasis);

        for (int i = 0; i < emphasisLayout.getChildCount(); i++) {
            ((EmphasisSwitch) emphasisLayout.getChildAt(i)).setAccented(i == index);
        }
    }

    @Override
    public void onBpmChanged(int bpm) {
        if (isBound()) {
            metronomeView.setInterval(service.getInterval());
            bpmView.setText(String.format(Locale.getDefault(), getString(R.string.bpm), String.valueOf(bpm)));
            if (seekBar.getProgress() != bpm) {
                seekBar.setOnProgressChangeListener(null);
                seekBar.setProgress(bpm);
                seekBar.setOnProgressChangeListener(this);
            }
        }
    }

    @Override
    public void onStopTicks() {
        playView.setImageResource(R.drawable.ic_play);

        for (int i = 0; i < emphasisLayout.getChildCount(); i++) {
            ((EmphasisSwitch) emphasisLayout.getChildAt(i)).setAccented(false);
        }
    }

    @Override
    public void onCheckedChanged(EmphasisSwitch emphasisSwitch, boolean b) {
        if (isBound()) {
            List<Boolean> emphasisList = new ArrayList<>();
            for (int i = 0; i < emphasisLayout.getChildCount(); i++) {
                emphasisList.add(((EmphasisSwitch) emphasisLayout.getChildAt(i)).isChecked());
            }

            service.setEmphasisList(emphasisList);
        }
    }

    @Override
    public void onProgressChange(int progress) {
        if (progress > 0 && isBound())
            service.setBpm(progress);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private class SplashThread extends Thread {

        private WeakReference<MainActivity> activityReference;

        public SplashThread(MainActivity activity) {
            activityReference = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                return;
            }

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    MainActivity activity = activityReference.get();
                    if (activity != null)
                        activity.findViewById(R.id.icon).setVisibility(View.GONE);
                }
            });
        }
    }
}
