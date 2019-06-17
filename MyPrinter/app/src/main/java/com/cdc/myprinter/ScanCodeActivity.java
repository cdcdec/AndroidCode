package com.cdc.myprinter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class ScanCodeActivity extends AppCompatActivity {

    private final static String TAG="ScanCodeActivity";

    //private EditText qrEditText;
    private TextView qrEditText;
    private TextView deleteTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);

        initView();
        initEvent();



    }



    private void initEvent() {
        deleteTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                qrEditText.setText("");
            }
        });
    }

    private void initView() {
        qrEditText = (TextView) findViewById(R.id.qrEditText);
        deleteTextView = (TextView) findViewById(R.id.deleteTextView);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    String barcode ="";
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(event.getAction()==KeyEvent.ACTION_DOWN){
            Log.e(TAG,"dispatchKeyEvent: "+event.toString());
            char pressedKey = (char) event.getUnicodeChar();
            barcode += pressedKey;
        }
        if (event.getAction()==KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            Toast.makeText(getApplicationContext(),
                    "barcode--->>>" + barcode, Toast.LENGTH_LONG)
                    .show();

            qrEditText.setText(barcode);
            barcode="";
        }
        return super.dispatchKeyEvent(event);
    }
}
