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
    private KeyboardView keyboardViewLeft;   //dBg
    private KeyboardView keyboardViewRight;  //dBh
    private LinearLayout keyboardViewLin;    //dBl

    private KeyboardView keyboardViewSymbolLeft;//dBj
    private KeyboardView keyboardViewSymbolRight;//dBk
    private LinearLayout keyboardViewSymbolLin;//dBn


    private LinearLayout keyboardViewNumberLin;//dBm
    private KeyboardView keyboardViewNumber;//dBi


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
        this.keyboardViewLeft = (KeyboardView) view.findViewById(R.id.keyboardViewLeft);
        this.keyboardViewRight = (KeyboardView) view.findViewById(R.id.keyboardViewRight);
        this.keyboardViewLin = view.findViewById(R.id.keyboardViewLin);

        this.keyboardViewSymbolLeft = (KeyboardView) view.findViewById(R.id.keyboardViewSymbolLeft);
        this.keyboardViewSymbolRight = (KeyboardView) view.findViewById(R.id.keyboardViewSymbolRight);
        this.keyboardViewSymbolLin = view.findViewById(R.id.keyboardViewSymbolLin);

        this.keyboardViewNumber = view.findViewById(R.id.keyboardViewNumber);
        this.keyboardViewNumberLin = view.findViewById(R.id.keyboardViewNumberLin);
        addView(view);
    }

    public KeyboardView getKeyboardViewLeft() {
        return keyboardViewLeft;
    }

    public KeyboardView getKeyboardViewRight() {
        return keyboardViewRight;
    }



    public KeyboardView getKeyboardViewSymbolLeft() {
        return keyboardViewSymbolLeft;
    }

    public KeyboardView getKeyboardViewSymbolRight() {
        return keyboardViewSymbolRight;
    }

    public LinearLayout getKeyboardViewLin() {
        return keyboardViewLin;
    }

    public LinearLayout getKeyboardViewSymbolLin() {
        return keyboardViewSymbolLin;
    }

    public LinearLayout getKeyboardViewNumberLin() {
        return keyboardViewNumberLin;
    }

    public KeyboardView getKeyboardViewNumber() {
        return keyboardViewNumber;
    }
}
