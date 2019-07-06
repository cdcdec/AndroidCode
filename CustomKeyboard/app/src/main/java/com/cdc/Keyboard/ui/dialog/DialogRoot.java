package com.cdc.keyboard.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cdc.keyboard.R;

public class DialogRoot extends DimAmountDialog {
    private Context mContext;
    protected View mView;
    public DialogRoot(@NonNull Context context) {
        super(context);
    }

    public DialogRoot(@NonNull Context context, int themeResId) {
        super(context, R.style.pos_product_dialog);
        this.mContext=context;
        this.mView = LayoutInflater.from(context).inflate(themeResId, null);
        setContentView(this.mView, new ViewGroup.LayoutParams(-1, -1));
        setCanceledOnTouchOutside(true);


    }

    public DialogRoot(Context context, int paramInt1, int paramInt2) {
        super(context, paramInt2);
        this.mContext = context;
        this.mView = View.inflate(mContext, paramInt1, null);
        setContentView(this.mView, new ViewGroup.LayoutParams(-1, -1));
        setCanceledOnTouchOutside(true);
    }


}
