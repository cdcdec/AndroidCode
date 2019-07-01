package com.cdc.Keyboard;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

public class KeyBoardLinearLayout extends LinearLayout{

    private Context context;
    private KeyboardView symbolLeftKv;

    private KeyboardView symbolRightKv;

    private KeyboardView leftKv;

    private KeyboardView rightKv;

    private KeyboardView numberKv;

    private LinearLayout letterLin;

    private LinearLayout numberLin;

    private LinearLayout symbolLin;
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
        this.symbolLeftKv = (KeyboardView)view.findViewById(R.id.keyboard_view_symbol_left);
        this.symbolRightKv = (KeyboardView)view.findViewById(R.id.keyboard_view_symbol_right);
        this.leftKv = (KeyboardView)view.findViewById(R.id.keyboardViewLeft);
        this.rightKv = (KeyboardView)view.findViewById(R.id.keyboardViewRight);
        this.numberKv = (KeyboardView)view.findViewById(R.id.keyboard_view_number);
        this.letterLin = (LinearLayout)view.findViewById(R.id.keyboard_lay_letter);
        this.numberLin = (LinearLayout)view.findViewById(R.id.keyboard_lay_number);
        this.symbolLin = (LinearLayout)view.findViewById(R.id.keyboard_lay_symbol);
        addView(view);
    }

    public KeyboardView getSymbolLeftKv() {
        return symbolLeftKv;
    }

    public KeyboardView getSymbolRightKv() {
        return symbolRightKv;
    }

    public KeyboardView getLeftKv() {
        return leftKv;
    }

    public KeyboardView getRightKv() {
        return rightKv;
    }

    public KeyboardView getNumberKv() {
        return numberKv;
    }

    public LinearLayout getLetterLin() {
        return letterLin;
    }

    public LinearLayout getNumberLin() {
        return numberLin;
    }

    public LinearLayout getSymbolLin() {
        return symbolLin;
    }
}
