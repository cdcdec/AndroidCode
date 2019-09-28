package com.cdc.paypassword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cdc.paypassword.widget.PayPasswordView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Main3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.payBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPayPasswordDialog();
            }
        });
    }
    private void openPayPasswordDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        final PayPasswordView payPasswordView = new PayPasswordView(this);
        payPasswordView.setCallBack(new PayPasswordView.CallBack() {
            @Override
            public void getPassWord(String password) {
                Toast.makeText(payPasswordView.getContext(), "你输入的密码是：" + password, Toast.LENGTH_SHORT).show();

                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(payPasswordView);
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        bottomSheetDialog.show();


    }
}
