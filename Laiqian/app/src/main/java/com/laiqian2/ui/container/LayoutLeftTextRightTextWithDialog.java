package com.laiqian.ui.container;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.w;
import org.jetbrains.annotations.NotNull;

public class LayoutLeftTextRightTextWithDialog extends FrameLayout {
  private w bDL;
  
  private View blX;
  
  private TextView dxA;
  
  private String[] dxB;
  
  private TextView dxl;
  
  private Context mContext;
  
  private Dialog mDialog;
  
  public LayoutLeftTextRightTextWithDialog(@NonNull Context paramContext) { this(paramContext, null); }
  
  public LayoutLeftTextRightTextWithDialog(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public LayoutLeftTextRightTextWithDialog(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initView();
    n(paramAttributeSet);
  }
  
  private void Ek() { setOnClickListener(new a(this, null)); }
  
  private int aqX() {
    if (this.dxB != null && this.dxB.length > 0)
      for (byte b = 0; b < this.dxB.length; b++) {
        if (this.dxB[b].equals(this.dxA.getText().toString()))
          return b; 
      }  
    return -1;
  }
  
  private void initView() {
    this.blX = LayoutInflater.from(this.mContext).inflate(R.layout.layout_left_text_right_text_with_dialog, this);
    this.dxl = (TextView)this.blX.findViewById(R.id.item_layout_tv_left);
    this.dxA = (TextView)this.blX.findViewById(R.id.item_layout_tv_right);
  }
  
  private void n(AttributeSet paramAttributeSet) {
    TypedArray typedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LayoutContainer);
    oW(typedArray.getString(R.styleable.LayoutContainer_left_text));
    oX(typedArray.getString(R.styleable.LayoutContainer_right_text));
    typedArray.recycle();
  }
  
  public void a(@NotNull String[] paramArrayOfString, @Nullable b paramb) {
    this.dxB = paramArrayOfString;
    if (paramArrayOfString != null) {
      if (paramArrayOfString.length < 0)
        return; 
      if (paramArrayOfString.length == 1) {
        this.dxA.setTextColor(getResources().getColor(R.color.label_text_color));
        this.dxA.setText(paramArrayOfString[0]);
        return;
      } 
      Ek();
      if (this.bDL == null)
        this.bDL = new w(this.mContext, paramArrayOfString, new v(this, paramArrayOfString, paramb)); 
      return;
    } 
  }
  
  public int aaL() { return aqX(); }
  
  public void kI(int paramInt) { this.dxA.setText(paramInt); }
  
  public void oW(String paramString) { this.dxl.setText(paramString); }
  
  public void oX(String paramString) { this.dxA.setText(paramString); }
  
  private class a implements View.OnClickListener {
    private a(LayoutLeftTextRightTextWithDialog this$0) {}
    
    public void onClick(View param1View) {
      if (LayoutLeftTextRightTextWithDialog.c(this.dxE) != null)
        LayoutLeftTextRightTextWithDialog.c(this.dxE).show(); 
      if (LayoutLeftTextRightTextWithDialog.a(this.dxE) != null && LayoutLeftTextRightTextWithDialog.d(this.dxE) != null) {
        LayoutLeftTextRightTextWithDialog.a(this.dxE).gn(LayoutLeftTextRightTextWithDialog.e(this.dxE));
        LayoutLeftTextRightTextWithDialog.a(this.dxE).show();
      } 
    }
  }
  
  public static interface b {
    void h(int param1Int, String param1String);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\LayoutLeftTextRightTextWithDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */