package com.cdc.toasty;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import styleabletoast.StyleableToast;

public class ToastSyleActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{

    String toastMsg = "Hello World!";
    int redColor = Color.parseColor("#FF5A5F");

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Button bt9;
    private Button bt10;
    private Button bt11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_syle);

        initView();
    }

    private void initView(){

        bt1=findViewById(R.id.b1);
        bt1.setOnClickListener(this);
        bt1.setOnLongClickListener(this);

        bt2=findViewById(R.id.b2);
        bt2.setOnClickListener(this);
        bt2.setOnLongClickListener(this);

        bt3=findViewById(R.id.b3);
        bt3.setOnClickListener(this);
        bt3.setOnLongClickListener(this);

        bt4=findViewById(R.id.b4);
        bt4.setOnClickListener(this);
        bt4.setOnLongClickListener(this);

        bt5=findViewById(R.id.b5);
        bt5.setOnClickListener(this);
        bt5.setOnLongClickListener(this);

        bt6=findViewById(R.id.b6);
        bt6.setOnClickListener(this);
        bt6.setOnLongClickListener(this);

        bt7=findViewById(R.id.b7);
        bt7.setOnClickListener(this);
        bt7.setOnLongClickListener(this);

        bt8=findViewById(R.id.b8);
        bt8.setOnClickListener(this);
        bt8.setOnLongClickListener(this);

        bt9=findViewById(R.id.b9);
        bt9.setOnClickListener(this);
        bt9.setOnLongClickListener(this);

        bt10=findViewById(R.id.b10);
        bt10.setOnClickListener(this);
        bt10.setOnLongClickListener(this);

        bt11=findViewById(R.id.b11);
        bt11.setOnClickListener(this);

    }




    public void coloredBackground(View view) {
        new StyleableToast.Builder(this)
                .text(toastMsg)
                .backgroundColor(redColor)
                .show();
    }


    public boolean coloredBackgroundStyle(View view) {
        StyleableToast.makeText(this, toastMsg+"==="+toastMsg, R.style.ColoredBackground).show();
        return true;
    }

    //--------------------------------------------------


    public void coloredText(View view) {
        new StyleableToast.Builder(this)
                .text(toastMsg)
                .textColor(redColor)
                .show();
    }


    public boolean coloredTextStyle(View view) {
        StyleableToast.makeText(this, toastMsg, R.style.ColoredText).show();
        return true;
    }

    //--------------------------------------------------


    public void coloredBoldText(View view) {
        new StyleableToast.Builder(this)
                .text(toastMsg)
                .textColor(redColor)
                .textBold()
                .show();
    }


    public boolean coloredBoldTextStyle(View view) {
        StyleableToast.makeText(this, toastMsg, R.style.ColoredBoldText).show();
        return true;
    }


    //--------------------------------------------------


    public void customFont(View view) {
        new StyleableToast.Builder(this)
                .text(toastMsg)
                .font(R.font.dosis)
                .show();
    }



    public boolean customFontStyle(View view) {
        StyleableToast.makeText(this, toastMsg, R.style.CustomFont).show();
        return true;
    }

    //--------------------------------------------------


    public void cornerRadius5dp(View view) {
        new StyleableToast.Builder(this)
                .text(toastMsg)
                .cornerRadius(5)
                .show();
    }


    public boolean cornerRadius5dpStyle(View view) {
        StyleableToast.makeText(this, toastMsg, R.style.CornerRadius5Dp).show();
        return true;
    }

    //--------------------------------------------------



    public void iconStart(View view) {
        new StyleableToast.Builder(this)
                .text(toastMsg)
                .iconStart(R.drawable.ic_autorenew_black_24dp)
                .show();
    }


    public boolean iconStartStyle(View view) {
        StyleableToast.makeText(this, toastMsg, R.style.IconStart).show();
        return true;
    }

    //--------------------------------------------------


    public void iconEnd(View view) {
        new StyleableToast.Builder(this)
                .text(toastMsg)
                .iconEnd(R.drawable.ic_autorenew_black_24dp)
                .show();
    }



    public boolean iconEndStyle(View view) {
        StyleableToast.makeText(this, toastMsg, R.style.IconEnd).show();
        return true;
    }


    //--------------------------------------------------


    public void iconStartEnd(View view) {
        new StyleableToast.Builder(this)
                .text(toastMsg)
                .iconStart(R.drawable.ic_autorenew_black_24dp)
                .iconEnd(R.drawable.ic_autorenew_black_24dp)
                .show();
    }



    public boolean iconStartEndStyle(View view) {
        StyleableToast.makeText(this, toastMsg, R.style.IconStartEnd).show();
        return true;
    }

    //--------------------------------------------------



    public void coloredStroke(View view) {
        new StyleableToast.Builder(this)
                .text(toastMsg)
                .stroke(2, redColor)
                .show();
    }


    public boolean coloredStrokeStyle(View view) {
        StyleableToast.makeText(this, toastMsg, R.style.ColoredStroke).show();
        return true;
    }


    //--------------------------------------------------


    public void allStyles(View view) {
        new StyleableToast.Builder(this)
                .text(toastMsg)
                .stroke(2, Color.CYAN)
                .backgroundColor(Color.BLACK)
                .solidBackground()
                .textColor(Color.YELLOW)
                .textBold()
                .font(R.font.dosis)
                .iconStart(R.drawable.ic_autorenew_black_24dp)
                .iconEnd(R.drawable.ic_autorenew_black_24dp)
                .cornerRadius(12)
                .textSize(18)
                .gravity(Gravity.BOTTOM)
                .length(100)
                .show();
    }



    public boolean allStylesStyles(View view) {
        StyleableToast.makeText(this, toastMsg, R.style.AllStyles).show();
        return true;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.b1){
            coloredBackground(null);
        }else if(id==R.id.b2){
            coloredText(null);
        }else if(id==R.id.b3){
            coloredBoldText(null);
        }else if(id==R.id.b4){
            customFont(null);
        }else if(id==R.id.b5){
            cornerRadius5dp(null);
        }else if(id==R.id.b6){
            iconStart(null);
        }else if(id==R.id.b7){
            iconEnd(null);
        }else if(id==R.id.b8){
            iconStartEnd(null);
        }else if(id==R.id.b9){
            coloredStroke(null);
        }else if(id==R.id.b10){
            allStyles(null);
        }else if(id==R.id.b11){
            showBottom();
        }
    }



    private void showBottom(){
        Toast toast=Toast.makeText(this,"====",Toast.LENGTH_LONG);
        toast.setText(toastMsg+"==");
        toast.setGravity(Gravity.BOTTOM,0,0);

        //view.getLocationOnScreen(location);//获取在整个屏幕内的绝对坐标
        toast.show();
        View  view=toast.getView();
        int[] location = new int[2] ;
        view.getLocationInWindow(location); //获取在当前窗口内的绝对坐标
        Log.e("123",view.getWidth()+"==="+location[1]+"==");
        Log.e("123",toast.getXOffset()+"==="+toast.getYOffset()+"==");//0  128


    }



    @Override
    public boolean onLongClick(View v) {
        int id=v.getId();
        if(id==R.id.b1){
            coloredBackgroundStyle(null);
        }else if(id==R.id.b2){
            coloredTextStyle(null);
        }else if(id==R.id.b3){
            coloredBoldTextStyle(null);
        }else if(id==R.id.b4){
            customFontStyle(null);
        }else if(id==R.id.b5){
            cornerRadius5dpStyle(null);
        }else if(id==R.id.b6){
            iconStartStyle(null);
        }else if(id==R.id.b7){
            iconEndStyle(null);
        }else if(id==R.id.b8){
            iconStartEndStyle(null);
        }else if(id==R.id.b9){
            coloredStrokeStyle(null);
        }else if(id==R.id.b10){
            allStylesStyles(null);
        }

        return false;
    }
}
