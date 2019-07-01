package com.cdc.test3;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.cdc.Keyboard.KeyBoardLinearLayout;
import com.cdc.Keyboard.KeyBoardUtil;
import com.cdc.Keyboard.KeyBoardUtil2;
import com.cdc.Keyboard.R;

public class Test3Activity extends AppCompatActivity implements View.OnTouchListener, View.OnFocusChangeListener {

    private KeyBoardLinearLayout keyBoardLinearLayout;

    private EditText nameEditText, passWordEditText;
    private KeyBoardUtil keyBoardUtil;
    private KeyBoardUtil2 keyBoardUtil2;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

        keyBoardLinearLayout = findViewById(R.id.myKeyBoard);

        keyBoardLinearLayout.getLetterLin().setVisibility(View.GONE);
        keyBoardLinearLayout.getSymbolLin().setVisibility(View.GONE);

        nameEditText = findViewById(R.id.l_userPhone);
        passWordEditText = findViewById(R.id.l_password);



        keyBoardUtil = new KeyBoardUtil(keyBoardLinearLayout.getNumberKv(), nameEditText);
        int type = nameEditText.getInputType();
        nameEditText.setInputType(type);
        nameEditText.setSelection(nameEditText.getText().toString().length());


        keyBoardUtil2 = new KeyBoardUtil2(keyBoardLinearLayout.getLeftKv(), keyBoardLinearLayout.getRightKv(), passWordEditText);
        int type2 = passWordEditText.getInputType();
        passWordEditText.setInputType(type2);
        passWordEditText.setSelection(passWordEditText.getText().toString().length());


        nameEditText.setOnTouchListener(this);
        passWordEditText.setOnTouchListener(this);

        nameEditText.setOnFocusChangeListener(this);
        passWordEditText.setOnFocusChangeListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.l_userPhone:
                if (nameEditText.hasFocus()) {
                    keyBoardLinearLayout.getNumberLin().setVisibility(View.VISIBLE);
                    keyBoardLinearLayout.getLetterLin().setVisibility(View.GONE);
                    keyBoardUtil.showKeyboard();
                } else {
                    keyBoardUtil.hideKeyboard();
                }
                break;

            case R.id.l_password:
                if (passWordEditText.hasFocus()) {

                    keyBoardLinearLayout.getLetterLin().setVisibility(View.VISIBLE);
                    keyBoardLinearLayout.getNumberLin().setVisibility(View.GONE);
                    keyBoardUtil2.showKeyboard();
                    keyBoardUtil.hideKeyboard();
                } else {
                    keyBoardUtil2.hideKeyboard();
                    keyBoardUtil.showKeyboard();
                }
                break;
        }
        return false;
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id = v.getId();
        switch (id) {
            case R.id.l_userPhone:
                if (nameEditText.hasFocus()) {
                    int type = nameEditText.getInputType();
                    keyBoardLinearLayout.getNumberLin().setVisibility(View.VISIBLE);
                    keyBoardLinearLayout.getLetterLin().setVisibility(View.GONE);
                    nameEditText.setInputType(type);
                    nameEditText.setSelection(nameEditText.getText().toString().length());
                    keyBoardUtil.showKeyboard();
                } else {
                    keyBoardUtil.hideKeyboard();
                }
                break;

            case R.id.l_password:
                if (passWordEditText.hasFocus()) {
                    int type = passWordEditText.getInputType();
                    keyBoardLinearLayout.getLetterLin().setVisibility(View.VISIBLE);
                    keyBoardLinearLayout.getNumberLin().setVisibility(View.GONE);
                    passWordEditText.setInputType(type);
                    passWordEditText.setSelection(passWordEditText.getText().toString().length());
                    keyBoardUtil2.showKeyboard();
                    keyBoardUtil.hideKeyboard();
                } else {
                    keyBoardUtil2.hideKeyboard();
                    keyBoardUtil.showKeyboard();
                }
                break;
        }
    }

}
