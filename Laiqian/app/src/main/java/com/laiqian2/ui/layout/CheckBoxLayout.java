package com.laiqian.ui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ImageCheckBox;

public class CheckBoxLayout extends RelativeLayout {
  private TextView dBP;
  
  private ImageCheckBox dBQ;
  
  protected int layout = R.layout.checkbox_layout;
  
  public CheckBoxLayout(Context paramContext) { super(paramContext); }
  
  public CheckBoxLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    RC();
    View.inflate(paramContext, this.layout, this);
    this.dBP = (TextView)findViewById(R.id.tvLable);
    this.dBQ = (ImageCheckBox)findViewById(R.id.cb);
    this.dBQ.setClickable(true);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CheckBoxLayout);
    int k = typedArray.getIndexCount();
    byte b = 0;
    int i = 0;
    int j = 0;
    while (b < k) {
      int m;
      int n = typedArray.getIndex(b);
      if (n == R.styleable.CheckBoxLayout_text) {
        String str = typedArray.getString(R.styleable.CheckBoxLayout_text);
        this.dBP.setText(str);
        m = i;
      } else if (n == R.styleable.CheckBoxLayout_textColor) {
        m = typedArray.getColor(R.styleable.CheckBoxLayout_textColor, -1);
        this.dBP.setTextColor(m);
        m = i;
      } else if (n == R.styleable.CheckBoxLayout_textSize) {
        m = typedArray.getDimensionPixelSize(R.styleable.CheckBoxLayout_textSize, 16);
        this.dBP.setTextSize(0, m);
        m = i;
      } else if (n == R.styleable.CheckBoxLayout_rightImageDrawable) {
        Drawable drawable = typedArray.getDrawable(R.styleable.CheckBoxLayout_rightImageDrawable);
        this.dBQ.setBackground(drawable);
        m = i;
      } else if (n == R.styleable.CheckBoxLayout_drawableWidth) {
        m = typedArray.getDimensionPixelSize(R.styleable.CheckBoxLayout_drawableWidth, 0);
      } else {
        m = i;
        if (n == R.styleable.CheckBoxLayout_drawableHeight) {
          j = typedArray.getDimensionPixelSize(R.styleable.CheckBoxLayout_drawableHeight, 0);
          m = i;
        } 
      } 
      b++;
      i = m;
    } 
    if (i > 0 && j > 0) {
      ViewGroup.LayoutParams layoutParams = this.dBQ.getLayoutParams();
      layoutParams.width = i;
      layoutParams.height = j;
      this.dBQ.setLayoutParams(layoutParams);
    } 
    typedArray.recycle();
  }
  
  protected void RC() {}
  
  public void a(View.OnClickListener paramOnClickListener) { this.dBQ.setOnClickListener(new a(this)); }
  
  public void a(ImageCheckBox.a parama) { this.dBQ.a(parama); }
  
  public ImageCheckBox arK() { return this.dBQ; }
  
  public boolean isChecked() { return this.dBQ.isChecked(); }
  
  public boolean performClick() {
    this.dBQ.performClick();
    return super.performClick();
  }
  
  public void setChecked(boolean paramBoolean) { this.dBQ.setChecked(paramBoolean); }
  
  public void setClickable(boolean paramBoolean) {
    this.dBQ.setClickable(paramBoolean);
    super.setClickable(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean) { this.dBQ.setEnabled(paramBoolean); }
  
  public void setText(CharSequence paramCharSequence) { this.dBP.setText(paramCharSequence); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\layout\CheckBoxLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */