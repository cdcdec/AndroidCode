package com.cdc.myprinter;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class ScanCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);
    }

    /**
     * 处理扫描设备的输入事件
     * @param event
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        toolScanner.analysisKeyEvent(event);
        return true;
    }

    /**
     * 扫码设备事件解析
     * @param event
     */
    public void analysisKeyEvent(KeyEvent event) {

        int keyCode = event.getKeyCode();


        //字母大小写判断
        checkLetterStatus(event);

        if (event.getAction() == KeyEvent.ACTION_DOWN) {

            char aChar = getInputCode(event);

            if (aChar != 0) {
                mStringBufferResult.append(aChar);
            }

            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                //若为回车键，直接返回
                mHandler.removeCallbacks(mScanningFishedRunnable);
                mHandler.post(mScanningFishedRunnable);
            } else {
                //延迟post，若500ms内，有其他事件
                mHandler.removeCallbacks(mScanningFishedRunnable);
                mHandler.postDelayed(mScanningFishedRunnable, MESSAGE_DELAY);
            }

        }
    }

    /**
     * shift键检查
     * @param event
     */
    private void checkLetterStatus(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT || keyCode == KeyEvent.KEYCODE_SHIFT_LEFT) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                //按着shift键，表示大写
                mCaps = true;
            } else {
                //松开shift键，表示小写
                mCaps = false;
            }
        }
    }

    //获取扫描内容
    private char getInputCode(KeyEvent event) {

        int keyCode = event.getKeyCode();

        char aChar;

        if (keyCode >= KeyEvent.KEYCODE_A && keyCode <= KeyEvent.KEYCODE_Z) {
            //字母
            aChar = (char) ((mCaps ? 'A' : 'a') + keyCode - KeyEvent.KEYCODE_A);
        } else if (keyCode >= KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9) {
            //数字
            aChar = (char) ('0' + keyCode - KeyEvent.KEYCODE_0);
        } else {
            //其他符号
            switch (keyCode) {
                case KeyEvent.KEYCODE_PERIOD:
                    aChar = '.';
                    break;
                case KeyEvent.KEYCODE_MINUS:
                    aChar = mCaps ? '_' : '-';
                    break;
                case KeyEvent.KEYCODE_SLASH:
                    aChar = '/';
                    break;
                case KeyEvent.KEYCODE_BACKSLASH:
                    aChar = mCaps ? '|' : '\\';
                    break;
                default:
                    aChar = 0;
                    break;
            }
        }

        return aChar;

    }
    StringBuffer mStringBufferResult=new StringBuffer();
    //接口回调
    public interface OnScanSuccessListener {
        void onScanSuccess(String barcode);
    }

    /**
     * 返回扫码成功后的结果
     */
    private void performScanSuccess() {
        String barcode = mStringBufferResult.toString();
        if (mOnScanSuccessListener != null)
            mOnScanSuccessListener.onScanSuccess(barcode);
        mStringBufferResult.setLength(0);
    }

    private Handler mHandler;

    public  ToolScanner(OnScanSuccessListener onScanSuccessListener) {
        mOnScanSuccessListener = onScanSuccessListener ;
        mStringBufferResult = new StringBuffer();
        mHandler = new Handler();
        mScanningFishedRunnable = new Runnable() {
            @Override
            public void run() {
                performScanSuccess();
            }
        };
    }
}
