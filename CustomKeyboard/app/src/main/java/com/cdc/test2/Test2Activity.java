package com.cdc.test2;

import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.cdc.Keyboard.R;
import com.dilusense.customkeyboard.*;
import com.dilusense.customkeyboard.utils.IPUtils;
import com.dilusense.customkeyboard.utils.IdentityUtils;

public class Test2Activity extends AppCompatActivity {

    private EditText et_1;
    private EditText et_2;
    private EditText et_3;
    private EditText et_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        initView();
        KeyboardIdentity keyboardIdentity = new KeyboardIdentity(this);
        KeyboardUtils.bindEditTextEvent(keyboardIdentity, et_1);
//        KeyboardIP keyboardIP = new KeyboardIP(this);
//        KeyboardUtils.bindEditTextEvent(keyboardIP, et_2);
//        KeyboardNumber keyboardNumber = new KeyboardNumber(this);
//        KeyboardUtils.bindEditTextEvent(keyboardNumber, et_3);
//        KeyboardNumber keyboardNumberRandom = new KeyboardNumber(this, true, false);
//        KeyboardUtils.bindEditTextEvent(keyboardNumberRandom, et_4);
//        keyboardIdentity.setOnOkClick(new BaseKeyboard.OnOkClick() {
//            @Override
//            public void onOkClick() {
//                IdentityUtils identityUtils = new IdentityUtils();
//                if (!identityUtils.isValidatedAllIdcard(et_1.getText().toString())) {
//                    Toast.makeText(getApplicationContext(), "输入的身份证号不合法", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        keyboardIP.setOnOkClick(new BaseKeyboard.OnOkClick() {
//            @Override
//            public void onOkClick() {
//                if (!IPUtils.isValidatedIPPort(et_2.getText().toString())) {
//                    Toast.makeText(getApplicationContext(), "输入的IP不合法", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    private void initView(){
        et_1=findViewById(R.id.et_1);
        et_2=findViewById(R.id.et_2);
        et_3=findViewById(R.id.et_3);
        et_4=findViewById(R.id.et_4);
    }
}
