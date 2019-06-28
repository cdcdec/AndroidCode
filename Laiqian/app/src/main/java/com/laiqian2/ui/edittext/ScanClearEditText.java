package com.laiqian.ui.edittext;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import com.laiqian.infrastructure.R;
import com.laiqian.util.ae;
import com.laiqian.util.n;

public class ScanClearEditText extends EditText implements TextWatcher, View.OnFocusChangeListener, a.a {
  private static final int RIGHT_ICON_TYPE_CLEAR = 0;
  
  private static final int RIGHT_ICON_TYPE_ENTER = 1;
  
  private static final String TAG = "ScanClearEditText";
  
  private Context context;
  
  private boolean hasEnter;
  
  private boolean hasFoucs;
  
  private boolean isVirtualKeyboard;
  
  private Drawable mClearDrawable;
  
  private a mScanGunKeyEventHelper;
  
  private boolean needRequestLayout = false;
  
  private boolean needSyncInput;
  
  private a onEnterListener;
  
  private View.OnFocusChangeListener onFocusChangeListener;
  
  private int rightIconType;
  
  static  {
  
  }
  
  public ScanClearEditText(Context paramContext) { this(paramContext, null); }
  
  public ScanClearEditText(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 16842862);
    this.context = paramContext;
    setSaveFromParentEnabled(false);
    this.mScanGunKeyEventHelper = new a(this);
  }
  
  public ScanClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScanClearEditText, 0, 0);
    try {
      this.hasEnter = typedArray.getBoolean(R.styleable.ScanClearEditText_hasEnter, true);
      this.rightIconType = typedArray.getInteger(R.styleable.ScanClearEditText_rightIconType, 0);
      typedArray.recycle();
      return;
    } finally {
      typedArray.recycle();
    } 
  }
  
  private void analysisInputDevice(KeyEvent paramKeyEvent) {
    InputDevice inputDevice = paramKeyEvent.getDevice();
    if (inputDevice != null) {
      if (Build.VERSION.SDK_INT >= 16)
        this.isVirtualKeyboard = inputDevice.isVirtual(); 
      boolean bool = this.isVirtualKeyboard;
      boolean bool1 = true;
      if (!bool && a.a(inputDevice)) {
        String str = inputDevice.getName();
        bool = bool1;
        if (!str.contains("Keyboard"))
          if (str.contains("KB") && !str.contains("KBW")) {
            bool = bool1;
          } else {
            bool = false;
          }  
        this.needSyncInput = bool;
        return;
      } 
      this.needSyncInput = true;
    } 
  }
  
  private void init(Context paramContext) {
    this.mClearDrawable = getCompoundDrawables()[2];
    if (this.mClearDrawable == null) {
      int i;
      Resources resources = getResources();
      if (this.rightIconType == 1) {
        i = R.drawable.bg_edit_enter;
      } else {
        i = R.drawable.bg_number_clean;
      } 
      this.mClearDrawable = resources.getDrawable(i);
    } 
    this.mClearDrawable.setBounds(0, 0, ae.b(paramContext, 24.0F), ae.b(paramContext, 24.0F));
    setCompoundDrawablePadding(ae.b(paramContext, 10.0F));
    setClearIconVisible(false);
    setOnFocusChangeListener(this);
    addTextChangedListener(this);
  }
  
  public static Animation shakeAnimation(int paramInt) {
    TranslateAnimation translateAnimation = new TranslateAnimation(0.0F, 10.0F, 0.0F, 0.0F);
    translateAnimation.setInterpolator(new CycleInterpolator(paramInt));
    translateAnimation.setDuration(1000L);
    return translateAnimation;
  }
  
  public void addOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener) { this.onFocusChangeListener = paramOnFocusChangeListener; }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    int i = paramKeyEvent.getKeyCode();
    analysisInputDevice(paramKeyEvent);
    if (!this.needSyncInput) {
      this.mScanGunKeyEventHelper.f(paramKeyEvent);
      n.a(this.context, this);
    } 
    boolean bool2 = isKeycodeDelete(i);
    boolean bool1 = true;
    if (bool2 || this.needSyncInput) {
      i = 1;
    } else {
      i = 0;
    } 
    if (!isKeycodeEnter(paramKeyEvent) || this.hasEnter) {
      if (i != 0 && super.dispatchKeyEvent(paramKeyEvent))
        return true; 
      bool1 = false;
    } 
    return bool1;
  }
  
  public void invalidate() {
    if (this.needRequestLayout) {
      super.invalidate();
      Log.d(TAG, "invalidate() called");
    } 
  }
  
  public boolean isFocused() { return super.isFocused(); }
  
  public boolean isKeycodeDelete(int paramInt) { return (paramInt == 67 || paramInt == 112); }
  
  public boolean isKeycodeEnter(KeyEvent paramKeyEvent) {
    boolean bool;
    int i = paramKeyEvent.getKeyCode();
    if (i == 160 || i == 66) {
      bool = true;
    } else {
      bool = false;
    } 
    if ((bool || i == 113) && this.onEnterListener != null && paramKeyEvent.getAction() == 1)
      this.onEnterListener.ars(); 
    return bool;
  }
  
  public void onDelete() {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    this.hasFoucs = paramBoolean;
    if (this.onFocusChangeListener != null)
      this.onFocusChangeListener.onFocusChange(paramView, paramBoolean); 
    boolean bool = false;
    if (paramBoolean) {
      paramBoolean = bool;
      if (getText().length() > 0)
        paramBoolean = true; 
      setClearIconVisible(paramBoolean);
      return;
    } 
    setClearIconVisible(false);
  }
  
  public void onFocusable(boolean paramBoolean) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4); }
  
  public void onScanSuccess(String paramString, boolean paramBoolean) {
    setText(paramString);
    selectAll();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    if (this.hasFoucs) {
      a a1 = this.mScanGunKeyEventHelper;
      paramInt1 = paramCharSequence.length();
      boolean bool1 = false;
      if (paramInt1 == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      a1.hi(bool);
      boolean bool = bool1;
      if (paramCharSequence.length() > 0)
        bool = true; 
      setClearIconVisible(bool);
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 1 && getCompoundDrawables()[2] != null) {
      boolean bool;
      if (paramMotionEvent.getX() > (getWidth() - getTotalPaddingRight()) && paramMotionEvent.getX() < (getWidth() - getPaddingRight())) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool)
        if (this.rightIconType == 0) {
          this.mScanGunKeyEventHelper.hi(true);
          setText("");
        } else if (this.rightIconType == 1 && this.onEnterListener != null) {
          this.onEnterListener.ars();
        }  
    } 
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void requestLayout() {
    if (this.needRequestLayout) {
      super.requestLayout();
      Log.d(TAG, "requestLayout() called");
    } 
  }
  
  protected void setClearIconVisible(boolean paramBoolean) {
    Drawable drawable;
    if (paramBoolean) {
      drawable = this.mClearDrawable;
    } else {
      drawable = null;
    } 
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);
  }
  
  public void setFocusable(boolean paramBoolean) { super.setFocusable(paramBoolean); }
  
  public void setOnEnterListener(a parama) { this.onEnterListener = parama; }
  
  public void setOnKeyListener(View.OnKeyListener paramOnKeyListener) { super.setOnKeyListener(paramOnKeyListener); }
  
  public void setShakeAnimation() { setAnimation(shakeAnimation(5)); }
  
  public static interface a {
    void ars();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\edittext\ScanClearEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */