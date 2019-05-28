package com.lee.cameraorc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.orclibrary.camera.MaskView;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        MaskView maskView=findViewById(R.id.maskView);

        //不起作用  在MaskView里面没有调用
        maskView.setLineColor(R.color.colorAccent);

        int type=maskView.getMaskType();

        Log.e("123456","type="+type);

        maskView.setMaskType(MaskView.MASK_TYPE_ID_CARD_BACK);

        //maskView.setMaskColor(R.color.colorPrimary);
    }
}
