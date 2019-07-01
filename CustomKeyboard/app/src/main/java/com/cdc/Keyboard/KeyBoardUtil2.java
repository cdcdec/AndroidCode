package com.cdc.Keyboard;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class KeyBoardUtil2 {
    private KeyboardView keyboardViewLeft;
    private KeyboardView keyboardViewRight;
    private EditText editText;
    private Keyboard k1Left;// 自定义键盘
    private Keyboard k1Right;// 自定义键盘

    public KeyBoardUtil2(KeyboardView keyboardViewLeft, KeyboardView keyboardViewRight, EditText editText) {
        //setInputType为InputType.TYPE_NULL   不然会弹出系统键盘
        editText.setInputType(InputType.TYPE_NULL);
        k1Left = new Keyboard(editText.getContext(), R.xml.qr_letter);
        k1Right = new Keyboard(editText.getContext(), R.xml.qr_only_number);
        this.keyboardViewLeft = keyboardViewLeft;
        this.keyboardViewRight = keyboardViewRight;
        this.editText = editText;
        this.keyboardViewLeft.setOnKeyboardActionListener(listener);
        this.keyboardViewLeft.setKeyboard(k1Left);
        this.keyboardViewLeft.setEnabled(true);
        this.keyboardViewLeft.setPreviewEnabled(false);


        this.keyboardViewRight.setOnKeyboardActionListener(listener);
        this.keyboardViewRight.setKeyboard(k1Right);
        this.keyboardViewRight.setEnabled(true);
        this.keyboardViewRight.setPreviewEnabled(false);
    }

    private KeyboardView.OnKeyboardActionListener listener = new KeyboardView.OnKeyboardActionListener() {

        @Override
        public void swipeUp() {
        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeLeft() {
        }

        @Override
        public void swipeDown() {
        }

        @Override
        public void onText(CharSequence text) {
        }

        @Override
        public void onRelease(int primaryCode) {
        }

        @Override
        public void onPress(int primaryCode) {
        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            Editable editable = editText.getText();
            Log.e("code", primaryCode + "===");
            int start = editText.getSelectionStart();
            switch (primaryCode) {
                case Keyboard.KEYCODE_DELETE:
                    if (editable != null && editable.length() > 0) {
                        if (start > 0) {
                            editable.delete(start - 1, start);
                        }
                    }
                    break;
                case Keyboard.KEYCODE_CANCEL:
                    keyboardViewLeft.setVisibility(View.GONE);
                    keyboardViewRight.setVisibility(View.GONE);
                    break;

                case -9:


                    break;
                default:
                    editable.insert(start, Character.toString((char) primaryCode));
                    break;
            }
        }
    };

    // Activity中获取焦点时调用，显示出键盘
    public void showKeyboard() {
        int visibility = keyboardViewLeft.getVisibility();
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
            keyboardViewLeft.setVisibility(View.VISIBLE);
            keyboardViewRight.setVisibility(View.VISIBLE);
        }
    }

    // 隐藏键盘
    public void hideKeyboard() {
        int visibility = keyboardViewLeft.getVisibility();
        if (visibility == View.VISIBLE || visibility == View.INVISIBLE) {
            keyboardViewLeft.setVisibility(View.GONE);
            keyboardViewRight.setVisibility(View.GONE);
        }
    }
}
