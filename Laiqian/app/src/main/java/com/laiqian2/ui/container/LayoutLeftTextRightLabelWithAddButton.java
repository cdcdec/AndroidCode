package com.laiqian.ui.container;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.infrastructure.R;

public class LayoutLeftTextRightLabelWithAddButton extends FrameLayout {
  private TextView dxl;
  
  private ImageView dxq;
  
  private TextView dxr;
  
  private a dxs;
  
  private View dxt;
  
  private Context mContext;
  
  public LayoutLeftTextRightLabelWithAddButton(@NonNull Context paramContext) { this(paramContext, null); }
  
  public LayoutLeftTextRightLabelWithAddButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public LayoutLeftTextRightLabelWithAddButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initView();
    o(paramAttributeSet);
  }
  
  private void initView() {
    LayoutInflater.from(this.mContext).inflate(R.layout.layout_left_text_right_label_with_add_button, this);
    this.dxl = (TextView)findViewById(R.id.item_layout_tv_left);
    this.dxq = (ImageView)findViewById(R.id.item_layout_tv_right);
    this.dxr = (TextView)findViewById(R.id.item_layout_tv_center);
    View view = findViewById(R.id.item_layout_iv_right);
    this.dxt = findViewById(R.id.item_center_tv_bg);
    view.setOnClickListener(new p(this));
    this.dxq.setOnClickListener(new t(this));
    this.dxt.setOnClickListener(new u(this));
  }
  
  private void o(AttributeSet paramAttributeSet) {
    TypedArray typedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LayoutContainer);
    oW(typedArray.getString(R.styleable.LayoutContainer_left_text));
    r(typedArray.getString(R.styleable.LayoutContainer_center_text));
    typedArray.recycle();
  }
  
  private void oW(String paramString) { this.dxl.setText(paramString); }
  
  private void r(CharSequence paramCharSequence) { this.dxr.setText(paramCharSequence); }
  
  public void a(a parama) { this.dxs = parama; }
  
  public void aqV() {
    this.dxt.setVisibility(8);
    if (this.dxs != null)
      this.dxs.d(new Pair(Double.valueOf(0.0D), Double.valueOf(0.0D))); 
  }
  
  public static interface a {
    void d(Pair<Double, Double> param1Pair);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\LayoutLeftTextRightLabelWithAddButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */