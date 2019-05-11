package com.vector.appupdatedemo.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.vector.appupdatedemo.R;
import com.vector.update_app.utils.AppUpdateUtils;
import com.vector.update_app.utils.DrawableUtil;
import io.reactivex.functions.Consumer;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawableUtil.setTextSolidTheme((Button) findViewById(R.id.btn_java), 2, 60, 0xffedd0be);
        DrawableUtil.setTextSolidTheme((Button) findViewById(R.id.btn_kotlin), 2, 60, 0xffff534d);

        ImageView im = findViewById(R.id.iv);

        im.setImageBitmap(AppUpdateUtils.drawableToBitmap(AppUpdateUtils.getAppIcon(this)));

        getPermission();


    }


    @SuppressLint("CheckResult")
    public void getPermission() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            Toast.makeText(MainActivity.this, "已授权", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "未授权", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void updateJava(View view) {
        startActivity(new Intent(this, JavaActivity.class));
    }

    public void updateKotlin(View view) {
        startActivity(new Intent(this, KotlinActivity.class));
    }



}
