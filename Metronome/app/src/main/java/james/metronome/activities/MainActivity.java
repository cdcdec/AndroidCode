package james.metronome.activities;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.aesthetic.AestheticActivity;
import java.util.Locale;
import james.metronome.R;
import james.metronome.services.MetronomeService;
import james.metronome.utils.WhileHeldListener;
import james.metronome.views.EmphasisSwitch;
import james.metronome.views.SeekBar;
import james.metronome.views.TicksView;
public class MainActivity extends AestheticActivity implements  ServiceConnection, MetronomeService.TickListener, EmphasisSwitch.OnCheckedChangeListener, SeekBar.OnProgressChangeListener {
    private boolean isBound;
    private MetronomeService service;
    private ImageView playView;
    /**
     *显示底部BPM 数据
     */
    private TextView bpmView;
    /***
     * 减少BPM 的按钮
     */
    private ImageView lessView;
    /**
     * 增加BPM 的按钮
     */
    private ImageView moreView;
    private TicksView ticksView;
    private SeekBar seekBar;
    private final static String TAG = "MetronomeService";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playView = findViewById(R.id.play);
        bpmView = findViewById(R.id.bpm);
        lessView = findViewById(R.id.less);
        moreView = findViewById(R.id.more);
        ticksView = findViewById(R.id.ticks);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMaxProgress(400);
        if (isBound()) {
            ticksView.setTick(service.getTick());
            seekBar.setProgress(service.getBpm());
            bpmView.setText(String.format(Locale.getDefault(), getString(R.string.bpm), String.valueOf(service.getBpm())));
            playView.setImageResource(service.isPlaying() ? R.drawable.ic_pause : R.drawable.ic_play);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        playView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound()) {
                    if (service.isPlaying()) {
                        service.pause();
                    } else {
                        service.play();
                    }
                }
            }
        });





        moreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound() && service.getBpm() < 400)
                    seekBar.setProgress(service.getBpm() + 1);
            }
        });

        moreView.setOnTouchListener(new WhileHeldListener() {
            @Override
            public void onHeld() {
                if (isBound() && service.getBpm() < 400)
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



    }






    private boolean isBound() {
        return isBound && service != null;
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
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MetronomeService.LocalBinder binder = (MetronomeService.LocalBinder) iBinder;
        service = binder.getService();
        service.setTickListener(this);
        isBound = true;

        if (ticksView != null)
            ticksView.setTick(service.getTick());



        if (seekBar != null)
            seekBar.setProgress(service.getBpm());

        if (bpmView != null)
            bpmView.setText(String.format(Locale.getDefault(), getString(R.string.bpm), String.valueOf(service.getBpm())));

        if (playView != null)
            playView.setImageResource(service.isPlaying() ? R.drawable.ic_pause : R.drawable.ic_play);


    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        isBound = false;
    }

    @Override
    public void onStartTicks() {
        Log.e(TAG, "开始播放了");
        playView.setImageResource(R.drawable.ic_pause);
    }
    @Override
    public void onBpmChanged(int bpm) {
        if (isBound()) {
           // metronomeView.setInterval(service.getInterval());
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



    }

    @Override
    public void onCheckedChanged(EmphasisSwitch emphasisSwitch, boolean b) {

    }

    @Override
    public void onProgressChange(int progress) {
        if (progress > 0 && isBound())
            service.setBpm(progress);
    }




}
