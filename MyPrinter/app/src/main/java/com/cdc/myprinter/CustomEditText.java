package com.cdc.myprinter;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;

public class CustomEditText extends android.support.v7.widget.AppCompatEditText{
    private ScanCodeListener codeListener;
    private StringBuffer buffer = new StringBuffer();

    public CustomEditText(Context context) {
        super(context);
        init();
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private int preKeyCode = -1;

    private void init() {
        setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    Log.d("ooo", "Code:" + keyCode + ", display int:" + (int) event.getDisplayLabel() + ", char:" + event.getDisplayLabel());

                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        String str = buffer.toString();
                        buffer.setLength(0);
                        preKeyCode = -1;
                        if (codeListener != null) {
                            codeListener.handleCode(str);
                        }
                    } else if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT || keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT) {
                        preKeyCode = KeyEvent.KEYCODE_SHIFT_RIGHT;
                    } else {
                        if (preKeyCode == KeyEvent.KEYCODE_SHIFT_RIGHT) {
                            String shiftChar = SHIFT_KEY_MAP.get(keyCode);
                            if (shiftChar != null) {
                                buffer.append(shiftChar);
                            }
                        } else {
                            char label = event.getDisplayLabel();
                            if (label != 0) {
                                buffer.append(toLowCase(label));
                            }
                        }
                        preKeyCode = -1;
                    }
                }
                return true;
            }
        });
    }

    private char toLowCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            c += 32;
            return c;
        }
        return c;
    }

    public void setScanCodeListener(ScanCodeListener codeListener) {
        this.codeListener = codeListener;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        boolean value = super.dispatchKeyEventPreIme(event);
        return value;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
    }

    @Override
    public void setOnKeyListener(OnKeyListener l) {
        super.setOnKeyListener(l);
    }

    public interface ScanCodeListener {
        void handleCode(String code);
    }

    static SparseArray<String> SHIFT_KEY_MAP = new SparseArray<>();

    static {

        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_GRAVE, "~");

        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_0, ")");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_1, "!");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_2, "@");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_3, "#");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_4, "$");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_5, "%");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_6, "^");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_7, "&");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_8, "*");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_9, ")");

        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_MINUS, "_");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_EQUALS, "+");

        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_LEFT_BRACKET, "{");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_RIGHT_BRACKET, "}");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_BACKSLASH, "|");

        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_SEMICOLON, ":");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_APOSTROPHE, "\"");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_COMMA, "<");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_PERIOD, ">");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_SLASH, "?");

        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_A, "A");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_B, "B");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_C, "C");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_D, "D");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_E, "E");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_F, "F");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_G, "G");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_H, "H");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_I, "I");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_J, "J");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_K, "K");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_L, "L");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_M, "M");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_N, "N");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_O, "O");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_P, "P");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_Q, "Q");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_R, "R");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_S, "S");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_T, "T");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_U, "U");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_V, "V");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_W, "W");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_X, "X");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_Y, "Y");
        SHIFT_KEY_MAP.put(KeyEvent.KEYCODE_Z, "Z");
    }
}
