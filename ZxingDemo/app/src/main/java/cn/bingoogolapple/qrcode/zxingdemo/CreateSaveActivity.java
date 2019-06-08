package cn.bingoogolapple.qrcode.zxingdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

import java.lang.ref.WeakReference;

public class CreateSaveActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv1,iv2;
    private Button createBtn,saveBtn,showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_save);

        iv1=findViewById(R.id.iv1);
        iv2=findViewById(R.id.iv2);

        createBtn=findViewById(R.id.createBtn);
        saveBtn=findViewById(R.id.createBtn);
        showBtn=findViewById(R.id.createBtn);

        createBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
        showBtn.setOnClickListener(this);
    }

    private Bitmap bitmapCreate;

    private void createLogo(){
        Bitmap bitmapLogo=BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
        Bitmap bitmap= QRCodeEncoder.syncEncodeQRCode("内容", BGAQRCodeUtil.dp2px(this, 150f), Color.parseColor("#000000"), bitmapLogo);
        bitmapCreate=bitmap;
        myHandler.sendEmptyMessage(msgCreateResult);


    }

    public  final int msgCreate=0;
    public  final int msgCreateResult=1;

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.createBtn:
                myHandler.sendEmptyMessage(msgCreate);
                break;

            case R.id.saveBtn:

                break;

            case R.id.showBtn:



                break;


        }
    }


    private MyHandler myHandler=new MyHandler(this);



    private class MyHandler extends Handler{

        private WeakReference weakReference;

        public MyHandler(CreateSaveActivity activity){
            weakReference=new WeakReference(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(weakReference.get()==null){
                return;
            }
            final CreateSaveActivity activity= (CreateSaveActivity) weakReference.get();
            int w=msg.what;

            if(w==activity.msgCreate){
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        activity.createLogo();
                    }
                });
                thread.start();
            }else if(w==activity.msgCreateResult){
                activity.iv1.setImageBitmap(activity.bitmapCreate);
                BitmapSaveUtil.saveBitmap2file(activity.bitmapCreate, getApplicationContext());
            }
        }
    }
}
