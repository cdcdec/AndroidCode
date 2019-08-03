package com.example.netsdk_demo;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;

public class AudioRecordManager {

    private static AudioRecordManager instance;

    boolean isRecording = false; //true表示正在录音

    AudioRecord audioRecord=null;

    int bufferSize=0;//最小缓冲区大小

    int sampleRateInHz = 8000;//采样率

    int channelConfig = AudioFormat.CHANNEL_IN_MONO; //单声道

    int audioFormat = AudioFormat.ENCODING_PCM_16BIT; //量化位数

    String TAG="AudioRecordManager";

    private AudioRecordManager(){
        //计算最小缓冲区
        bufferSize = AudioRecord.getMinBufferSize(sampleRateInHz,channelConfig, audioFormat);
        bufferSize= bufferSize>320?320:bufferSize;
        audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,sampleRateInHz,channelConfig, audioFormat, bufferSize);//创建AudioRecorder对象
    }

    public static AudioRecordManager getInstance(){
        if(instance==null){
            synchronized (AudioRecordManager.class){
                if(instance==null){
                    instance = new AudioRecordManager();
                }
            }
        }
        return instance;
    }

    /**
     * 开始音频采集
     * @param onAudioRecordListener
     */
    public void startRecording(OnAudioRecordListener onAudioRecordListener) {
        setOnAudioRecordListener(onAudioRecordListener);

        if(audioRecord==null){
            audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,sampleRateInHz,channelConfig, audioFormat, bufferSize);//创建AudioRecorder对象
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                isRecording = true;
                try {
                    byte[] buffer = new byte[bufferSize];
                    audioRecord.startRecording();//开始录音
                    while (isRecording) {
                        int bufferReadResult = audioRecord.read(buffer,0,bufferSize);
                        if(getOnAudioRecordListener()!=null){
                            getOnAudioRecordListener().onVoiceRecord(buffer,bufferReadResult);
                        }
                    }
                    audioRecord.stop();//停止录音
                } catch (Throwable t) {
                    Log.e(TAG, "Recording Failed");
                }
            }
        }).start();
    }

    /**
     * 停止音频采集
     */
    public void stopRecording() {
        isRecording = false;
        setOnAudioRecordListener(null);
    }

    public void onDestroy(){
        audioRecord.release();
        audioRecord = null;
    }

    public interface OnAudioRecordListener{

        /**
         * 采集到的音频信息数据回调到上层，通过IdeaVideoView 传送到设备端
         * @param data
         */
        void onVoiceRecord(byte[] data,int size);

    }

    private OnAudioRecordListener onAudioRecordListener;

    public OnAudioRecordListener getOnAudioRecordListener() {
        return onAudioRecordListener;
    }

    public void setOnAudioRecordListener(OnAudioRecordListener onAudioRecordListener) {
        this.onAudioRecordListener = onAudioRecordListener;
    }
}