package com.laiqian.ui.edittext;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.b.a;
import java.lang.reflect.Method;

public class EditText extends EditText {
  private Handler handler;
  
  private InputMethodManager imm;
  
  private boolean isUseLqKeyBoard = false;
  
  private a keyBoard;
  
  public EditText(Context paramContext) { this(paramContext, null); }
  
  public EditText(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public EditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet != null)
      this.isUseLqKeyBoard = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MyEditText).getBoolean(R.styleable.MyEditText_lqkeyBoard, false); 
  }
  
  public static boolean closeLqKeyBoardOnDemand(EditText paramEditText) {
    if (paramEditText.isLqKeyBoardShowing()) {
      paramEditText.closeLqKeyBoard();
      return true;
    } 
    return false;
  }
  
  private void initKeyboard() {
    View view1;
    View view2 = getRootView();
    View view3 = ViewGroup.inflate(getContext(), R.layout.fill_scrolview, null);
    ViewGroup viewGroup = (ViewGroup)view2;
    byte b = 1;
    while (true) {
      view1 = view2;
      if (b < viewGroup.getChildCount()) {
        view1 = viewGroup.getChildAt(b);
        if (view1 instanceof android.widget.ScrollView)
          break; 
        b++;
        continue;
      } 
      break;
    } 
    ((ViewGroup)((ViewGroup)view1).getChildAt(0)).addView(view3);
    view1.invalidate();
    this.keyBoard = new a(getContext(), this, view3);
    this.keyBoard.show();
    if (this.handler != null)
      this.keyBoard.setHandler(this.handler); 
  }
  
  protected void closeLqKeyBoard() {
    if (this.keyBoard != null)
      this.keyBoard.dismiss(); 
  }
  
  public void hasFocused() {
    if (this.keyBoard == null) {
      initKeyboard();
      this.keyBoard.show();
    } 
  }
  
  protected boolean isLqKeyBoardShowing() { return (this.keyBoard != null) ? this.keyBoard.isShow() : 0; }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    if (!paramBoolean && this.keyBoard != null)
      this.keyBoard.dismiss(); 
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() != 1)
      return true; 
    showLqKeyBoard();
    return true;
  }
  
  public boolean performClick() {
    showLqKeyBoard();
    return super.performClick();
  }
  
  public void setHandler(Handler paramHandler) { this.handler = paramHandler; }
  
  protected void showLqKeyBoard() {
    setFocusableInTouchMode(true);
    setFocusable(true);
    requestFocus();
    this.imm = (InputMethodManager)getContext().getSystemService("input_method");
    if (this.imm.isActive())
      this.imm.hideSoftInputFromWindow(((Activity)getContext()).getCurrentFocus().getWindowToken(), 2); 
    if (this.isUseLqKeyBoard) {
      if (Build.VERSION.SDK_INT <= 10) {
        setInputType(0);
        selectAll();
      } else {
        ((Activity)getContext()).getWindow().setSoftInputMode(3);
        try {
          Method method = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { boolean.class });
          method.setAccessible(true);
          method.invoke(this, new Object[] { Boolean.valueOf(false) });
        } catch (Exception exception) {
          a.e(exception);
        } 
      } 
      if (this.keyBoard != null) {
        if (this.keyBoard.isShow())
          return; 
        this.keyBoard.init();
        this.keyBoard.show();
        return;
      } 
      initKeyboard();
      return;
    } 
    this.imm.toggleSoftInput(0, 2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\edittext\EditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */