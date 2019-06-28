package com.laiqian.ui.container;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;

public class LayoutLeftTextRightCheckbox extends FrameLayout {
  private CheckBox dxk;
  
  private TextView dxl;
  
  private CompoundButton.OnCheckedChangeListener dxm;
  
  private int[] dxn = { R.styleable.LayoutContainer_background_resource, R.styleable.LayoutContainer_left_text };
  
  private Context mContext;
  
  public LayoutLeftTextRightCheckbox(@NonNull Context paramContext) { this(paramContext, null); }
  
  public LayoutLeftTextRightCheckbox(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public LayoutLeftTextRightCheckbox(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initView();
    n(paramAttributeSet);
  }
  
  private void initView() {
    LayoutInflater.from(this.mContext).inflate(R.layout.layout_left_text_right_check_box, this);
    this.dxk = (CheckBox)findViewById(R.id.item_layout_cb_right);
    this.dxl = (TextView)findViewById(R.id.item_layout_tv_left);
  }
  
  private void n(AttributeSet paramAttributeSet) {
    TypedArray typedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LayoutContainer);
    int i = typedArray.getResourceId(R.styleable.LayoutContainer_left_text, R.string.empty);
    oW(this.mContext.getString(i));
    typedArray.recycle();
  }
  
  public void oW(String paramString) { this.dxl.setText(paramString); }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) { return true; }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.dxm != null && this.dxk != null) {
      this.dxk.setChecked(this.dxk.isChecked() ^ true);
      this.dxm.onCheckedChanged(this.dxk, this.dxk.isChecked());
    } 
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChecked(boolean paramBoolean) { this.dxk.setChecked(paramBoolean); }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener) { this.dxm = paramOnCheckedChangeListener; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\LayoutLeftTextRightCheckbox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */