package com.cdc.keyboard.ui.keybord;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.cdc.keyboard.R;

public class KeyBoardLinearLayout extends LinearLayout {
    private Context context;
    private KeyboardView dBg;

    private KeyboardView dBh;

    private KeyboardView dBi;

    private KeyboardView dBj;

    private KeyboardView dBk;

    private LinearLayout dBl;

    private LinearLayout dBm;

    private LinearLayout dBn;



    public KeyBoardLinearLayout(Context context) {
        super(context);
        this.context = context;
        initData();

    }

    public KeyBoardLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initData();
    }

    public KeyBoardLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initData();
    }


    private void initData() {
        View view = LayoutInflater.from(this.context).inflate(R.layout.pos_keyboard_view, null);
        this.dBj = (KeyboardView)view.findViewById(R.id.keyboard_view_symbol_left);
        this.dBk = (KeyboardView)view.findViewById(R.id.keyboard_view_symbol_right);
        this.dBg = (KeyboardView)view.findViewById(R.id.keyboard_view_left);
        this.dBh = (KeyboardView)view.findViewById(R.id.keyboard_view_right);
        this.dBg = (KeyboardView)view.findViewById(R.id.keyboard_view_left);
        this.dBi = (KeyboardView)view.findViewById(R.id.keyboard_view_number);
        this.dBl = (LinearLayout)view.findViewById(R.id.keyboard_lay_letter);
        this.dBm = (LinearLayout)view.findViewById(R.id.keyboard_lay_number);
        this.dBn = (LinearLayout)view.findViewById(R.id.keyboard_lay_symbol);
        addView(view);
    }
}
