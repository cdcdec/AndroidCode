package com.cdc.keyboard.ui.dialog;

import android.content.Context;
import androidx.annotation.NonNull;
import com.cdc.keyboard.R;

public class TopDialog extends DialogRoot{

    public TopDialog(@NonNull Context context) {
        super(context);
    }

    public TopDialog(@NonNull Context context, int themeResId) {
        super(context, R.layout.pos_main_area_dialog);

    }

    public TopDialog(Context context, int paramInt1, int paramInt2) {
        super(context, paramInt1, paramInt2);
    }
}
