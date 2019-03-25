package com.cdc.androidcode.libraries.okhttp;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cdc.androidcode.R;
import com.cdc.androidcode.utils.BarUtils;
import com.cdc.androidcode.utils.ConvertUtils;

public class BottomDialogScroll {
    private Dialog dialog;
    private View view;
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private void init(Context context) {
        dialog = new Dialog(context, R.style.BottomDialog);
        view = LayoutInflater.from(context).inflate(R.layout.dialog_content_scroll, null);
        dialog.setContentView(view);
        TextView title = view.findViewById(R.id.dialogTitle);
        title.setText(getTitle());
        TextView content = view.findViewById(R.id.dialogContent);
        content.setText(getContent());
    }

    private Context context;

    public BottomDialogScroll(Context context) {
        this.context = context;

    }



    public void show() {
        init(context);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        params.width = context.getResources().getDisplayMetrics().widthPixels - ConvertUtils.dp2px(16f);
        params.height =context.getResources().getDisplayMetrics().heightPixels - BarUtils.getActionBarHeight() - BarUtils.getStatusBarHeight() - ConvertUtils.dp2px(8f);
        params.bottomMargin = ConvertUtils.dp2px(8f);
        view.setLayoutParams(params);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        dialog.show();
    }


}
