package com.cdc.androidutilcodeexample;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.log.MLog;

public class MainActivity extends AppCompatActivity{
    String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "    package=\"com.cdc.androidutilcodeexample\">\n" +
            "\n" +
            "    <application\n" +
            "        android:name=\".MyApplication\"\n" +
            "        android:allowBackup=\"true\"\n" +
            "        android:icon=\"@mipmap/ic_launcher\"\n" +
            "        android:label=\"@string/app_name\"\n" +
            "        android:roundIcon=\"@mipmap/ic_launcher_round\"\n" +
            "        android:supportsRtl=\"true\"\n" +
            "        android:theme=\"@style/AppTheme\">\n" +
            "        <activity android:name=\".MainActivity\">\n" +
            "            <intent-filter>\n" +
            "                <action android:name=\"android.intent.action.MAIN\" />\n" +
            "\n" +
            "                <category android:name=\"android.intent.category.LAUNCHER\" />\n" +
            "            </intent-filter>\n" +
            "        </activity>\n" +
            "    </application>\n" +
            "\n" +
            "</manifest>";

    String xml2="<?xml version=\"1.0\" encoding=\"utf-8\"?><manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"package=\"com.cdc.androidutilcodeexample\">\n" +
            "<application \n" +
            "android:name=\".MyApplication\"\n" +
            "android:allowBackup=\"true\"\n" +
            "android:icon=\"@mipmap/ic_launcher\"\n" +
            "android:label=\"@string/app_name\"\n" +
            "android:roundIcon=\"@mipmap/ic_launcher_round\"\n" +
            "android:supportsRtl=\"true\"\n" +
            "android:theme=\"@style/AppTheme\">\n" +
            "</application>\n" +
            "</manifest>";

    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


        String a = "[3, 1, 4, 1, 5, 9, 2, 6]";

        MLog.e(this.getCacheDir().getAbsolutePath());


        MLog.eFile("/log/logNew.txt","测试File");


    }

    private void initView(){
        bt1=findViewById(R.id.bt1);
    }

    //https://blog.csdn.net/qq_20212147/article/details/86479634
    //WRITE_EXTERNAL_STORAGE
    private void writeExternalStorage(){
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            Log.e("123","没有获得权限");

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Log.e("123","应当获得权限1");
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                Log.e("123","应当获得权限2");
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            Log.e("123","已获得权限");
        }


    }

private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS=0x01;
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

}
