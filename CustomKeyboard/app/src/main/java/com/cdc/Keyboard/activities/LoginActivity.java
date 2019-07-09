package com.cdc.keyboard.activities;

import android.graphics.PorterDuff;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ContentLoadingProgressBar;
import com.cdc.keyboard.MainActivity;
import com.cdc.keyboard.R;
import com.cdc.keyboard.basic.RootActivity;
import com.cdc.keyboard.ui.ImageCheckBox;
import com.cdc.keyboard.ui.ProgressBarCircularIndeterminate;
import com.cdc.keyboard.ui.keybord.KeyBoardLinearLayout;
import com.cdc.keyboard.ui.keybord.KeyboardManage;
import com.cdc.keyboard.util.SoundPlayer;

public class LoginActivity extends RootActivity {

    private EditText editTextUserPhone;
    private EditText editTextPassword;
    private KeyBoardLinearLayout loginKeyBoard;
    private KeyboardManage keyboardManage;//aZf

    private SoundPlayer soundPlayer = null;//aZe
    /**
     * 登录按钮
     */
    private TextView tvLogin;//aZR
    private TextView loginReRegisterTv;//重新注册
    private TextView loginResultTv;//登录结果 状态

    private ImageCheckBox icbPassword;//显示隐藏密码

    /**
     *
     * aZQ
     */
    private ContentLoadingProgressBar loginIvProgress;//aZQ

    /**
     * 登录按钮的父布局
     */
    private RelativeLayout loginRel;

    /**
     * 用户手机号
     */
    private String userPhone;
    /**
     * 用户密码
     */
    private String userPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewNoTitle(R.layout.activity_login);

        initView();

        initClick();


    }

    private void initView() {
        tvLogin=findViewById(R.id.tvLogin);
        loginReRegisterTv=findViewById(R.id.loginReRegisterTv);
        editTextUserPhone = findViewById(R.id.editTextUserPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        loginKeyBoard = findViewById(R.id.loginKeyBoard);
        loginRel = findViewById(R.id.loginRel);
        loginIvProgress = findViewById(R.id.loginIvProgress);
        icbPassword = findViewById(R.id.icbPassword);
        loginResultTv = findViewById(R.id.loginResultTv);
        loginResultTv.setVisibility(View.GONE);
        if (soundPlayer == null) {
            soundPlayer = new SoundPlayer();
        }
        keyboardManage = new KeyboardManage(this, new EditText[]{editTextUserPhone, editTextPassword}, loginKeyBoard, soundPlayer);


    }

    private void initClick(){
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goToPage(MainActivity.class);
                loginOnClick();
            }
        });

        loginReRegisterTv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToPage(RegisteredActivity.class);
            }
        });


        editTextUserPhone.setFocusable(true);
        editTextUserPhone.setFocusableInTouchMode(true);

        editTextUserPhone.requestFocus();//获取焦点 光标出现

        icbPassword.setListener(new ImageCheckBox.Listener() {
            @Override
            public void listener(ImageCheckBox param1ImageCheckBox, boolean param1Boolean) {
                if(param1Boolean){
                    //如果选中，显示密码
                    editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    editTextPassword.setSelection(editTextPassword.getText().length());
                }else{
                    //否则隐藏密码
                    editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editTextPassword.setSelection(editTextPassword.getText().length());
                }

            }
        });
    }

    private void loginOnClickView(){
        loginRel.setClickable(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        alphaAnimation.setDuration(500L);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, (tvLogin.getWidth() / 2), (tvLogin.getHeight() / 2));
        scaleAnimation.setDuration(500L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        tvLogin.startAnimation(animationSet);
        tvLogin.setVisibility(View.GONE);
        loginIvProgress.setVisibility(View.VISIBLE);
        loginIvProgress.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(LoginActivity.this,R.color.red_text), PorterDuff.Mode.MULTIPLY);

    }


    private void loginOnClick(){
        loginOnClickView();
        userPhone=editTextUserPhone.getText().toString().trim();
        userPassWord=editTextPassword.getText().toString().trim();
        if (userPhone.equals("") || userPhone.equals("")) {
            loginResultTv.setVisibility(View.VISIBLE);
            loginResultTv.setText(getString(R.string.l_loginAlertInfo));
            hideProgress();
            return;
        }






    }

    private void hideProgress(){
        tvLogin.clearAnimation();
        tvLogin.setVisibility(View.VISIBLE);
        loginIvProgress.setVisibility(View.GONE);
        loginRel.setClickable(true);
    }
}

//smali里面的  com.laiqian.login.view  LoginActivity2.smali
