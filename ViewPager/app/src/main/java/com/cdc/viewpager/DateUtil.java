package com.cdc.viewpager;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DateUtil {

    public static List<Uri> getListUri(Context context){
        List<Uri> uriList=new ArrayList<>();
        String path1="android.resource://" + context.getPackageName() + "/" + R.raw.video1;
        path1="http://flv3.bn.netease.com/videolib3/1709/20/TItLA5448/SD/TItLA5448-mobile.mp4";

        uriList.add(Uri.parse(path1));
        String path2="android.resource://" + context.getPackageName() + "/" + R.raw.image1;
        Log.e("123","path2============="+path2+"==================");
        uriList.add(Uri.parse(path2));
        String path3="android.resource://" + context.getPackageName() + "/" + R.raw.image2;
        Log.e("123","path3============="+path3+"==================");
        uriList.add(Uri.parse(path3));
        String path4="android.resource://" + context.getPackageName() + "/" + R.raw.image3;
        Log.e("123","path4============="+path4+"==================");
        uriList.add(Uri.parse(path4));
        String path5="android.resource://" + context.getPackageName() + "/" + R.raw.image4;
        Log.e("123","path5============="+path5+"==================");
        uriList.add(Uri.parse(path5));
        return uriList;
    }
}
