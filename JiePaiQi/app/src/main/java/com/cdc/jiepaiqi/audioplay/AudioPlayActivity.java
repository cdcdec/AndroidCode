package com.cdc.jiepaiqi.audioplay;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.cdc.jiepaiqi.R;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.List;
public class AudioPlayActivity extends AppCompatActivity implements ServiceConnection, MetronomeService.TickListener {

    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_play);
        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnFastPlay1 = findViewById(R.id.btnFastPlay1);
        Button btnFastPlay2 = findViewById(R.id.btnFastPlay2);
        Button btnFastPlay3 = findViewById(R.id.btnFastPlay3);
        Click click = new Click();
        btnPlay.setOnClickListener(click);
        btnFastPlay1.setOnClickListener(click);
        btnFastPlay2.setOnClickListener(click);
        btnFastPlay3.setOnClickListener(click);

        initView();
        loadData();


        //重置
        player.reset();
    }

    private boolean isBound;
    private MetronomeService service;

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MetronomeService.LocalBinder binder = (MetronomeService.LocalBinder) iBinder;
        service = binder.getService();
        service.setTickListener(this);
        isBound = true;

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        isBound = false;
    }

    @Override
    public void onStartTicks() {
//开始播放了
    }

    @Override
    public void onBpmChanged(int bpm) {
        if (isBound()) {

        }
    }

    private boolean isBound() {
        return isBound && service != null;
    }

    @Override
    public void onStopTicks() {
//停止播放了
    }

    class Click implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.btnPlay:

                    play();

                    break;
                case R.id.btnFastPlay1:
                    jiePaiMethod1();
                    break;

                case R.id.btnFastPlay2:
                    jiePaiMethod2();
                    break;

                case R.id.btnFastPlay3:
                    jiePaiMethod3();
                    break;
            }
        }
    }

    int soundId = -1;

    int streamId = 0;

    private void initSoundPool() {
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

        soundId = soundPool.load(context, R.raw.beep, 1);
        Log.e("soundPool", "soundId=" + soundPool);

    }


    private void jiePaiMethod1() {
        if (soundPool != null) {
            soundPool.release();
        }
        initSoundPool();
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                streamId = soundPool.play(soundId, 1.0f, 1.0f, 0, -1, 0.5f);
            }
        });
    }

    private void jiePaiMethod2() {
        if (soundPool != null) {
            soundPool.release();
        }
        initSoundPool();
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                streamId = soundPool.play(soundId, 1.0f, 1.0f, 0, -1, 1.0f);
            }
        });
    }

    private void jiePaiMethod3() {
        if (soundPool != null) {
            soundPool.release();
        }
        initSoundPool();
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                streamId = soundPool.play(soundId, 1.0f, 1.0f, 0, -1, 2.0f);
            }
        });
    }


    public void number(Context ctx) {
        MediaPlayer player;
        try {
            final AssetFileDescriptor afd = ctx.getResources().openRawResourceFd(R.raw.a_0);
            final FileDescriptor fileDescriptor = afd.getFileDescriptor();
            player = new MediaPlayer();
            player.setDataSource(fileDescriptor, afd.getStartOffset(),
                    afd.getLength());
            player.prepare();
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    mp.release();
                }

            });
            player.setLooping(true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    int[] wav1 = {R.raw.a_0, R.raw.a_1, R.raw.a_2};

    private Context context;

    private List<Music> musics;


    //声明 MediaPla
    private MediaPlayer player;
    // 记录的暂停时的播放位置
    private int pausePosition;
    // 当前播放的歌曲的索引
    private int currentMusicIndex;

    private void initView() {
        player = new MediaPlayer();
        context = AudioPlayActivity.this;
        player.setOnCompletionListener(new InnerOnCompletionListener());

    }

    private void loadData() {
        // 获取歌曲列表
        musics = new MusicData().getMusicData();


    }

    //播放音乐
    private void play() {
        //重置
        player.reset();
        try {
            final AssetFileDescriptor afd = context.getResources().openRawResourceFd(musics.get(currentMusicIndex).getPath());
            final FileDescriptor fileDescriptor = afd.getFileDescriptor();
            //设置音乐文件来源
            player.setDataSource(fileDescriptor, afd.getStartOffset(),
                    afd.getLength());
            //准备（缓冲文件）
            player.prepare();
            //将进度设置到“音乐进度”
            player.seekTo(pausePosition);
            //获取音乐进度
            player.getCurrentPosition();
            //播放开始
            player.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private final class InnerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            next();

        }
    }

    //播放下一曲（与上一曲类似）
    private void next() {
        currentMusicIndex++;
        if (currentMusicIndex >= musics.size()) {
            //Toast.makeText(context, "已经是最后一首了", Toast.LENGTH_SHORT).show();
            currentMusicIndex = 0;
            play();
        } else {
            pausePosition = 0;
            play();
        }
    }


    public void fastPlay(Context ctx) {
        MediaPlayer player;
        try {
            final AssetFileDescriptor afd = ctx.getResources().openRawResourceFd(wav1[0]);
            final FileDescriptor fileDescriptor = afd.getFileDescriptor();
            player = new MediaPlayer();
            player.setDataSource(fileDescriptor, afd.getStartOffset(),
                    afd.getLength());
            player.prepare();
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub

                    mp.release();
                }

            });
            player.setLooping(false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            if (player.isPlaying()) {
                player.pause();
            }
            player.release();
        }

        if (soundPool != null) {
            soundPool.release();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
