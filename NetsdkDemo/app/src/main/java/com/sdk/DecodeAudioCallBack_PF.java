package com.sdk;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.util.Log;

class MyAudioTrack {

    int mFrequency;                                        // 采样率

    int mChannel;                                        // 声道

    int mSampBit;                                        // 采样精度

    AudioTrack mAudioTrack;

    public MyAudioTrack(int frequency, int channel, int sampbit){
        mFrequency = frequency;
        mChannel = channel;
        mSampBit = sampbit;
    }

    public void init(){
        if (mAudioTrack != null){
            release();
        }

        int minBufSize = AudioTrack.getMinBufferSize(mFrequency,
                mChannel,
                mSampBit);


        mAudioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                mFrequency,
                mChannel,
                mSampBit,
                minBufSize,
                AudioTrack.MODE_STREAM);




        mAudioTrack.play();
    }
    public void release(){
        if (mAudioTrack != null){
            mAudioTrack.stop();
            mAudioTrack.release();
            mAudioTrack = null;
        }
    }

    public void playAudioTrack(byte []data, int offset, int length){
        if (data == null || data.length == 0){
            return ;
        }

        try {
            mAudioTrack.write(data, offset, length);
        } catch (Exception e) {
            // TODO: handle exception
            Log.i("MyAudioTrack", "catch exception...");
        }
    }

    public int getPrimePlaySize(){
        int minBufSize = AudioTrack.getMinBufferSize(mFrequency,
                mChannel,
                mSampBit);

        return minBufSize * 2;
    }
}

public class DecodeAudioCallBack_PF {

    MyAudioTrack audioTrack = null;

    public DecodeAudioCallBack_PF()
    {
        audioTrack = new MyAudioTrack(8000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
        audioTrack.init();
    }

    public void release()
    {
        audioTrack.release();
        audioTrack = null;
    }
    /*
     * Callback function to receive Audio Data
     * @param  lpVoiceComHandle     Voice Handle
     * @param  voiceData           	Audio data pointer
     * @param  length          		Audio data length
     * @param  u32WaveFormat     	Format of decoded audio
     * @note*/
    public void DecodeAudioDataCallBack(int lpVoiceComHandle, byte[] voiceData, int length, int u32WaveFormat) {

        if( audioTrack != null && null != voiceData && length > 0)
        {
            audioTrack.playAudioTrack(voiceData,0,length);
        }
    }
}