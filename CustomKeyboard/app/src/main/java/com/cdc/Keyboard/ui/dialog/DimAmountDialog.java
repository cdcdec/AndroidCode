package com.cdc.keyboard.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DimAmountDialog extends Dialog {

    public DimAmountDialog(@NonNull Context context) {
        this(context,0);
    }

    public DimAmountDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setDimAmout(0.3F);
    }

    protected DimAmountDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public void setDimAmout(float paramFloat) {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.dimAmount = paramFloat;
        getWindow().setAttributes(layoutParams);
    }
}
