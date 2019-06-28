package com.laiqian.ui.container;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;

public class LayoutLeftTextRightTextWithArrow extends FrameLayout {
  private TextView dxl;
  
  private TextView dxz;
  
  private Context mContext;
  
  public LayoutLeftTextRightTextWithArrow(@NonNull Context paramContext) { this(paramContext, null); }
  
  public LayoutLeftTextRightTextWithArrow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public LayoutLeftTextRightTextWithArrow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initView();
    o(paramAttributeSet);
  }
  
  private void initView() {
    LayoutInflater.from(this.mContext).inflate(R.layout.layout_left_text_right_text_with_arrow, this);
    this.dxl = (TextView)findViewById(R.id.item_layout_tv_left);
    this.dxz = (TextView)findViewById(R.id.item_layout_tv_center);
  }
  
  private void o(AttributeSet paramAttributeSet) {
    TypedArray typedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LayoutContainer);
    oW(typedArray.getString(R.styleable.LayoutContainer_left_text));
    oX(typedArray.getString(R.styleable.LayoutContainer_right_text));
    typedArray.recycle();
  }
  
  public TextView aqW() { return this.dxz; }
  
  public void oW(String paramString) { this.dxl.setText(paramString); }
  
  public void oX(String paramString) { this.dxz.setText(paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\LayoutLeftTextRightTextWithArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */