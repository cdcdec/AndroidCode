package com.cdc.keyboard.ui.keybord;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.cdc.keyboard.util.SoundPlayer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KeyboardManage {//d.smali
    final KeyboardUtil keyboardUtil;//dBB

    public KeyboardManage(Activity paramActivity, EditText[] paramArrayOfEditText, KeyBoardLinearLayout paramKeyBoardLinearlayout, SoundPlayer parambs) {
        this(paramActivity, paramArrayOfEditText, paramKeyBoardLinearlayout, parambs, null, null);
    }

    public KeyboardManage(Activity paramActivity, EditText[] paramArrayOfEditText, KeyBoardLinearLayout paramKeyBoardLinearlayout, SoundPlayer parambs, ViewGroup.LayoutParams paramLayoutParams1, ViewGroup.LayoutParams paramLayoutParams2) {
        this.keyboardUtil = new KeyboardUtil(paramActivity, paramArrayOfEditText, paramKeyBoardLinearlayout);
        this.keyboardUtil.setSoundPlayer(parambs);
        this.keyboardUtil.i(paramLayoutParams1);
        this.keyboardUtil.j(paramLayoutParams2);
        int i = paramArrayOfEditText.length;
        byte b;
        for (b = 0; b < i; b++) {
            EditText editText = paramArrayOfEditText[b];
            int j = editText.getInputType();
            a(paramActivity, editText);
            if (this.keyboardUtil.getEditText() == editText)
                this.keyboardUtil.kY(j);
            editText.setOnFocusChangeListener(new E(this, j));
        }
    }


    public void a(Activity paramActivity, EditText paramEditText) {
        paramActivity.getWindow().setSoftInputMode(3);
        int i = Build.VERSION.SDK_INT;
        String str = "";
        if (i >= 16) {
            str = "setShowSoftInputOnFocus";
        } else if (i >= 14) {
            str = "setSoftInputShownOnFocus";
        } else {
            paramActivity = null;
        }
        if (paramActivity == null) {
            paramEditText.setInputType(0);
            return;
        }
        try {
            Method method = EditText.class.getMethod(str, new Class[]{boolean.class});
            method.setAccessible(true);
            method.invoke(paramEditText, new Object[]{Boolean.valueOf(false)});
            return;
        } catch (NoSuchMethodException e) {
            paramEditText.setInputType(0);
            //a.e(paramActivity);
            return;
        } catch (IllegalAccessException e) {
            //a.e(paramActivity);
            return;
        } catch (IllegalArgumentException e) {
            // a.e(paramActivity);
            return;
        } catch (InvocationTargetException e) {
            //a.e(paramActivity);
            return;
        }
    }

    class E implements View.OnFocusChangeListener {

        private KeyboardManage keyboardManage;
        private int paramInt;

        public E(KeyboardManage keyboardManage, int paramInt) {
            this.keyboardManage = keyboardManage;
            this.paramInt = paramInt;
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            keyboardManage.keyboardUtil.kY(paramInt);
        }
    }


}

//d  e  smali


