package com.laiqian.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;

public class DefensiveTextView extends AppCompatTextView {
  public DefensiveTextView(Context paramContext) { super(paramContext); }
  
  public DefensiveTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public DefensiveTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) { super(paramContext, paramAttributeSet, paramInt); }
  
  public void findViewsWithText(ArrayList<View> paramArrayList, CharSequence paramCharSequence, int paramInt) { paramArrayList.remove(this); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\DefensiveTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */