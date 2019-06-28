package com.laiqian.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import com.laiqian.infrastructure.R;
import com.laiqian.util.ae;
import java.util.List;
import java.util.Map;

public class p extends SimpleAdapter {
  private a dzA;
  
  private int dzB;
  
  private int dzC;
  
  private int dzD;
  
  private LayoutInflater mInflater;
  
  public p(Context paramContext, List<? extends Map<String, ?>> paramList, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) { this(paramContext, paramList, paramInt, paramArrayOfString, paramArrayOfInt, 0, 0); }
  
  public p(Context paramContext, List<? extends Map<String, ?>> paramList, int paramInt1, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2, int paramInt3) {
    super(paramContext, paramList, paramInt1, paramArrayOfString, paramArrayOfInt);
    this.dzB = paramInt1;
    this.dzC = ae.b(paramContext, paramInt2);
    this.dzD = ae.b(paramContext, paramInt3);
    this.mInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.dzA = new a(this, null);
      paramView = this.mInflater.inflate(R.layout.pos_choose_listview_item_wraper, null);
      this.dzA.dzE = (LinearLayout)paramView.findViewById(R.id.pos_choose_listview_wrap);
      this.dzA.dzF = (LinearLayout)paramView.findViewById(R.id.pos_choose_listview_outer);
      View view = this.mInflater.inflate(this.dzB, null);
      this.dzA.dzF.setPadding(this.dzC, this.dzD, this.dzC, this.dzD);
      if (paramInt != 0) {
        View view1 = this.mInflater.inflate(R.layout.choose_dialog_lines, null);
        this.dzA.dzE.addView(view1);
      } 
      this.dzA.dzE.addView(view);
      paramView.setTag(this.dzA);
    } else {
      this.dzA = (a)paramView.getTag();
    } 
    return super.getView(paramInt, paramView, paramViewGroup);
  }
  
  private class a {
    LinearLayout dzE;
    
    LinearLayout dzF;
    
    private a(p this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */