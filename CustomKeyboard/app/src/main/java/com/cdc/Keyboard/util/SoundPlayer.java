package com.cdc.keyboard.util;

import android.media.SoundPool;
//bs.smali
public class SoundPlayer {
    private SoundPool soundPool = new SoundPool(3,3,100);

    public void release() { this.soundPool.release(); }
}
