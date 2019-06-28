package com.laiqian.ui.container;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;

public class LayoutLeftTextRightEditText extends FrameLayout {
  private TextView dxl;
  
  private int[] dxn = { R.styleable.LayoutContainer_background_resource, R.styleable.LayoutContainer_left_text, R.styleable.LayoutContainer_right_text };
  
  private EditText dxo;
  
  private Context mContext;
  
  public LayoutLeftTextRightEditText(@NonNull Context paramContext) { this(paramContext, null); }
  
  public LayoutLeftTextRightEditText(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public LayoutLeftTextRightEditText(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initView();
    n(paramAttributeSet);
  }
  
  private void initView() {
    LayoutInflater.from(this.mContext).inflate(R.layout.layout_left_text_right_edit_text, this);
    this.dxl = (TextView)findViewById(R.id.item_layout_tv_left);
    this.dxo = (EditText)findViewById(R.id.item_layout_et_right);
  }
  
  private void n(AttributeSet paramAttributeSet) {
    TypedArray typedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LayoutContainer);
    oW(typedArray.getString(R.styleable.LayoutContainer_left_text));
    int i = typedArray.getResourceId(R.styleable.LayoutContainer_right_text, R.string.empty);
    oX(this.mContext.getString(i));
    typedArray.recycle();
  }
  
  public void a(TextWatcher paramTextWatcher) { this.dxo.addTextChangedListener(paramTextWatcher); }
  
  public EditText aqU() { return this.dxo; }
  
  public void oW(String paramString) { this.dxl.setText(paramString); }
  
  public void oX(String paramString) { this.dxo.setText(paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\LayoutLeftTextRightEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */