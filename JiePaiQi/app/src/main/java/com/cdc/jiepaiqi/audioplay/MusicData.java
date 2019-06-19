package com.cdc.jiepaiqi.audioplay;

import com.cdc.jiepaiqi.R;

import java.util.ArrayList;
import java.util.List;

public class MusicData {
    public List<Music> getMusicData(){
        List<Music> musicList=new ArrayList<>();

        Music music1=new Music();
        music1.setName("a_0");
        music1.setPath(R.raw.beep);

        Music music2=new Music();
        music2.setName("a_1");
        music2.setPath(R.raw.a_1);

        Music music3=new Music();
        music3.setName("a_2");
        music3.setPath(R.raw.a_2);

        Music music4=new Music();
        music4.setName("a_e1");
        music4.setPath(R.raw.a_e1);


        Music music5=new Music();
        music5.setName("a_e2");
        music5.setPath(R.raw.a_e2);


        Music music6=new Music();
        music6.setName("a_e3");
        music6.setPath(R.raw.a_e3);



        musicList.add(music1);
        musicList.add(music2);
        musicList.add(music3);
        musicList.add(music4);
        musicList.add(music5);
        musicList.add(music6);

        return musicList;
    }
}
