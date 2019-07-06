package com.cdc.keyboard.ui.keybord;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.cdc.keyboard.R;

public class KeyboardController {
    public static final int layoutRoot = R.layout.layout_keyboard;

    private  ViewOnClickListener viewOnClickListener=new ViewOnClickListener();
    private  ViewLongClickListener viewLongClickListener=new ViewLongClickListener();

    public View keyBoardRoot;
    private Window window;

    public View btnZero;

    public View btnDelete;

    public View btnDot;

    public View btnThree;

    public View btnTwo;

    public View btnOne;

    public View btnSix;

    public View btnFive;

    public View btnFour;

    public View btnNine;

    public View btnEight;

    public View btnSeven;

    public KeyboardController(Window window){
        this.window=window;
        this.keyBoardRoot=window.findViewById(R.id.keyboardRoot);
        this.btnZero=window.findViewById(R.id.btnZero);
        this.btnDelete=window.findViewById(R.id.btnDelete);
        this.btnDot=window.findViewById(R.id.btnDot);
        this.btnThree=window.findViewById(R.id.btnThree);
        this.btnTwo=window.findViewById(R.id.btnTwo);
        this.btnOne=window.findViewById(R.id.btnOne);
        this.btnSix=window.findViewById(R.id.btnSix);
        this.btnFive=window.findViewById(R.id.btnFive);
        this.btnFour=window.findViewById(R.id.btnFour);
        this.btnNine=window.findViewById(R.id.btnNine);
        this.btnEight=window.findViewById(R.id.btnEight);
        this.btnSeven=window.findViewById(R.id.btnSeven);

    }

    private EditText getEditText() {
        View view = this.window.getCurrentFocus();
        return (view != null && view instanceof EditText) ? (EditText) view : null;
    }

    private void c(EditText paramEditText, String paramString) {
        if (paramEditText == null)
            return;
        if (!paramEditText.hasSelection()) {
            int k = paramEditText.getSelectionStart();
            paramEditText.getText().insert(k, paramString);
            return;
        }
        int i = paramEditText.getSelectionStart();
        int j = paramEditText.getSelectionEnd();
        Editable editable = paramEditText.getText();
        editable.replace(i, j, paramString);
        if (i + paramString.length() != 0 && paramString.length() != 0)
            Selection.setSelection(editable, paramEditText.getEditableText().length());
    }

    private void i(EditText paramEditText) {
        if (paramEditText == null)
            return;
        Editable editable = paramEditText.getText();
        if (!paramEditText.hasSelection()) {
            int i = paramEditText.getSelectionStart();
            if (editable.length() >= 1 && i > 0) {
                editable.delete(i - 1, i);
                return;
            }
        } else {
            editable.delete(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
        }
    }

    private void init() {
        this.btnDelete.setOnLongClickListener(this.viewLongClickListener);
        this.btnDelete.setOnClickListener(this.viewOnClickListener);
        this.btnZero.setOnClickListener(this.viewOnClickListener);
        this.btnOne.setOnClickListener(this.viewOnClickListener);
        this.btnTwo.setOnClickListener(this.viewOnClickListener);
        this.btnThree.setOnClickListener(this.viewOnClickListener);
        this.btnFour.setOnClickListener(this.viewOnClickListener);
        this.btnFive.setOnClickListener(this.viewOnClickListener);
        this.btnSix.setOnClickListener(this.viewOnClickListener);
        this.btnSeven.setOnClickListener(this.viewOnClickListener);
        this.btnEight.setOnClickListener(this.viewOnClickListener);
        this.btnNine.setOnClickListener(this.viewOnClickListener);
        this.btnDot.setOnClickListener(this.viewOnClickListener);
    }






    class ViewOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }

    class ViewLongClickListener implements View.OnLongClickListener{

        @Override
        public boolean onLongClick(View v) {

            return false;
        }
    }



}
