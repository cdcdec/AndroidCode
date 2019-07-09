package com.cdc.keyboard.ui.keybord;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.cdc.keyboard.R;
import com.cdc.keyboard.util.SoundPlayer;
import java.util.List;
//f.smali  g.smali
public class KeyboardUtil implements KeyboardView.OnKeyboardActionListener {
    private KeyBoardLinearLayout keyBoardLinearLayout;
    private EditText[] editTexts;
    private KeyboardView qrLetterLeftView; //dBg
    private KeyboardView qrLetterRightView;//dBh
    private KeyboardView qrSymbolLeftView;//dBj
    private KeyboardView qrSymbolRightView;//dBk
    private KeyboardView qrOnlyNumberView;//dBi


    private Keyboard qrLetter;
    private Keyboard qrNumber;
    private Keyboard qrOnlyNumber;
    private Keyboard qrSymbol;

    private Drawable capitalDrawable = null;
    private Drawable capitalLowercase = null;


    private LinearLayout keyboardViewLin;  //dBl  letter父布局

    private LinearLayout keyboardViewNumberLin;  //dBm  number父布局

    private LinearLayout keyboardViewSymbolLin;  //dBn  sysbol父布局

    private SoundPlayer soundPlayer = null;

    private boolean qrSymbolBoolean = false;//dBK

    //a
    public void setSoundPlayer(SoundPlayer soundPlayer) {
        this.soundPlayer = soundPlayer;
    }


    public KeyboardUtil(Activity paramActivity, EditText[] paramArrayOfEditText, KeyBoardLinearLayout paramKeyBoardLinearLayout) {
        this.keyBoardLinearLayout = paramKeyBoardLinearLayout;
        this.editTexts = paramArrayOfEditText;
        this.qrLetter = new Keyboard(paramActivity, R.xml.qr_letter);
        this.qrNumber = new Keyboard(paramActivity, R.xml.qr_number);
        this.qrOnlyNumber = new Keyboard(paramActivity, R.xml.qr_only_number);
        this.qrSymbol = new Keyboard(paramActivity, R.xml.qr_symbol);

        this.qrLetterLeftView = paramKeyBoardLinearLayout.getKeyboardViewLeft();
        this.qrLetterRightView = paramKeyBoardLinearLayout.getKeyboardViewRight();
        this.qrSymbolLeftView = paramKeyBoardLinearLayout.getKeyboardViewSymbolLeft();
        this.qrSymbolRightView = paramKeyBoardLinearLayout.getKeyboardViewSymbolRight();
        this.qrOnlyNumberView = paramKeyBoardLinearLayout.getKeyboardViewNumber();
        this.keyboardViewLin = paramKeyBoardLinearLayout.getKeyboardViewLin();
        this.keyboardViewNumberLin = paramKeyBoardLinearLayout.getKeyboardViewNumberLin();
        this.keyboardViewSymbolLin = paramKeyBoardLinearLayout.getKeyboardViewSymbolLin();


        this.capitalDrawable = paramActivity.getResources().getDrawable(R.drawable.keyboard_capital);
        this.capitalLowercase = paramActivity.getResources().getDrawable(R.drawable.keyboard_lowercase);


        this.qrLetterLeftView.setPreviewEnabled(false);
        this.qrLetterRightView.setPreviewEnabled(false);
        this.qrSymbolLeftView.setPreviewEnabled(false);
        this.qrSymbolRightView.setPreviewEnabled(false);
        this.qrOnlyNumberView.setPreviewEnabled(false);

        this.qrLetterLeftView.setKeyboard(this.qrLetter);
        this.qrLetterRightView.setKeyboard(this.qrNumber);
        this.qrSymbolLeftView.setKeyboard(this.qrSymbol);
        this.qrSymbolRightView.setKeyboard(this.qrNumber);
        this.qrOnlyNumberView.setKeyboard(this.qrOnlyNumber);


        this.qrLetterLeftView.setOnKeyboardActionListener(this);
        this.qrLetterRightView.setOnKeyboardActionListener(this);
        this.qrSymbolLeftView.setOnKeyboardActionListener(this);
        this.qrSymbolRightView.setOnKeyboardActionListener(this);
        this.qrOnlyNumberView.setOnKeyboardActionListener(this);


    }

    //arI
    public EditText getEditText() {
        for (EditText editText : this.editTexts) {
            if (editText.isFocused())
                return editText;
        }
        return null;
    }

    private boolean lowerCase(String paramString) {
        return ("abcdefghijklmnopqrstuvwxyz".indexOf(paramString.toLowerCase()) > -1);
    }

    private void arH() {
        List<Keyboard.Key> list = this.qrLetter.getKeys();
        Log.e("123",qrSymbolBoolean+"=qrSymbolBoolean");
        if (this.qrSymbolBoolean) {
            this.qrSymbolBoolean = false;
            for (Keyboard.Key key : list) {
                if (key.label != null && lowerCase(key.label.toString())) {
                    key.label = key.label.toString().toLowerCase();
                    key.codes[0] = key.codes[0] + 32;
                    continue;
                }
                if (key.codes[0] == -1)
                    key.icon = this.capitalLowercase;
            }
        } else {
            this.qrSymbolBoolean = true;
            for (Keyboard.Key key : list) {
                if (key.label != null && lowerCase(key.label.toString())) {
                    key.label = key.label.toString().toUpperCase();
                    Log.e("123", "key.label.toString().toUpperCase()="+key.label.toString().toUpperCase());
                    key.codes[0] = key.codes[0] - 32;
                    continue;
                }
                if (key.codes[0] == -1)
                    key.icon = this.capitalDrawable;
            }
        }
    }

    private void hj(boolean paramBoolean) {
        if (paramBoolean) {
            if (this.keyboardViewLin.getVisibility() == View.VISIBLE) {
                this.keyboardViewLin.setVisibility(View.GONE);
            }
            this.keyboardViewSymbolLin.setVisibility(View.VISIBLE);
            return;
        }
        if (this.keyboardViewNumberLin.getVisibility() == View.GONE) {
            this.keyboardViewLin.setVisibility(View.VISIBLE);
        }
        this.keyboardViewSymbolLin.setVisibility(View.GONE);
    }

    public void arJ() {
        this.keyboardViewLin.setVisibility(View.GONE);
        this.keyboardViewNumberLin.setVisibility(View.GONE);
        this.keyboardViewSymbolLin.setVisibility(View.GONE);
    }

    public void i(ViewGroup.LayoutParams paramLayoutParams) {
        if (paramLayoutParams != null) {
            this.qrLetterLeftView.setLayoutParams(paramLayoutParams);
        }
    }

    public void j(ViewGroup.LayoutParams paramLayoutParams) {
        if (paramLayoutParams != null)
            this.qrOnlyNumberView.setLayoutParams(paramLayoutParams);
    }

    private void arG() { this.qrLetterLeftView.setKeyboard(this.qrLetterLeftView.getKeyboard()); }

    public void kY(int paramInt) {
        this.keyboardViewSymbolLin.setVisibility(View.GONE);
        if (getEditText() == null)
            return;
        if (paramInt == 2 || paramInt == 3) {
            this.keyboardViewLin.setVisibility(View.GONE);
            this.keyboardViewNumberLin.setVisibility(View.VISIBLE);
            return;
        }
        this.keyboardViewLin.setVisibility(View.VISIBLE);
        this.keyboardViewNumberLin.setVisibility(View.GONE);
        if (this.qrSymbolBoolean) {
            arH();
            arG();
            return;
        }
    }

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int paramInt, int[] keyCodes) {
        EditText editText = this.getEditText();
        if (editText == null)
            return;
        editText.playSoundEffect(0);
        Editable editable = editText.getText();
        int i = editText.getSelectionStart();
        int j = editable.length();
        if(paramInt==-9){//符号
            if(keyboardViewSymbolLin.getVisibility()==View.GONE){
                qrSymbolBoolean=true;
                hj(true);
            }else{
                qrSymbolBoolean=false;
                hj(false);
            }
            return;
        }
        if (paramInt == -3) {
            this.arJ();
            return;
        }
        if (paramInt == -5) {//退格
            if (editable != null && j > 0) {
                if (i > 0) {
                    editable.delete(i - 1, i);
                    return;
                }
                if (i == 0 && editText.getSelectionEnd() == j) {
                    editable.delete(0, j);
                    return;
                }
            }
        } else {
            if (paramInt == -1) {//大小写
                arH();
                arG();
                return;
            }
            if (i == 0 && j > 0 && editText.getSelectionEnd() == j)
                editable.delete(0, j);
            editable.insert(i, Character.toString((char)paramInt));
//            if (f.a(this.dBO).getVisibility() == 0)
//                f.a(this.dBO, false);
        }







    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }


}

//2
//
// "KeyboardController.java"  a.smali  b.smali  c.smali

//"KeyboardManage.java"  d.smali   e.smali

//KeyboardUtil.java  f.smali  g.smali






