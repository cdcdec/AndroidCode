package com.cdc;

import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.cdc.okhttp.R;
import com.shape.SuperButton;

public class DialogUtils{
    private static Dialog longMessageDialog;
    public static Dialog longMessageDialog(Context context, String msg) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_long_message, null);// 得到加载view
        ConstraintLayout layout = (ConstraintLayout) v.findViewById(R.id.dialog_long_message_view);// 加载布局
        TextView tvLongMessage = (TextView) v.findViewById(R.id.tvLongMessage);// 提示文字
        SuperButton btnBottomOk = (SuperButton) v.findViewById(R.id.btnBottomOk);// 提示文字
        tvLongMessage.setText(msg);// 设置加载信息
        tvLongMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
        longMessageDialog = new Dialog(context, R.style.MyDialogStyle);// 创建自定义样式dialog
        longMessageDialog.setCancelable(true); // 是否可以按“返回键”消失
        longMessageDialog.setCanceledOnTouchOutside(true); // 点击加载框以外的区域
        longMessageDialog.setContentView(layout, new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));// 设置布局
        /**
         *将显示Dialog的方法封装在这里面
         */
        Window window = longMessageDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.dimAmount=0.4f;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setGravity(Gravity.BOTTOM);
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.PopWindowAnimStyle);
        longMessageDialog.show();
        btnBottomOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                longMessageDialog.dismiss();
            }
        });
        return longMessageDialog;
    }

    public static void closeDialog() {
        if (longMessageDialog != null && longMessageDialog.isShowing()) {
            longMessageDialog.dismiss();
        }
    }
}
