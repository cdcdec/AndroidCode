package com.laiqian.ui.listview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class i extends BaseAdapter {
  private ArrayList<HashMap<String, Object>> dCA;
  
  private int dCB;
  
  private int dCx;
  
  private String[] dCy;
  
  protected int dCz;
  
  private Context mContext;
  
  private int[] mTo;
  
  public int arY() { return this.dCB; }
  
  public int arZ() { return this.dCz; }
  
  public HashMap<String, Object> gN(int paramInt) { return (this.dCA == null) ? null : (HashMap)this.dCA.get(paramInt); }
  
  public int getCount() { return (this.dCA == null) ? 0 : this.dCA.size(); }
  
  public long getItemId(int paramInt) { return paramInt; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    paramView = LayoutInflater.from(this.mContext).inflate(this.dCx, null);
    byte b;
    for (b = 0; b < this.mTo.length; b++) {
      View view = paramView.findViewById(this.mTo[b]);
      if (view instanceof TextView) {
        ((TextView)view).setText((String)((HashMap)this.dCA.get(paramInt)).get(this.dCy[b]));
      } else if (view instanceof ImageView) {
        ((ImageView)view).setImageDrawable((Drawable)((HashMap)this.dCA.get(paramInt)).get(this.dCy[b]));
      } 
    } 
    if (this.dCz != 0) {
      View view = paramView.findViewById(this.dCz);
      if (paramInt == this.dCB) {
        view.setVisibility(0);
        return paramView;
      } 
      view.setVisibility(4);
    } 
    return paramView;
  }
  
  public void li(int paramInt) { this.dCB = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */