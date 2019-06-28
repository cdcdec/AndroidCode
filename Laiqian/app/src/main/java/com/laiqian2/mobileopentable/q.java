package com.laiqian.mobileopentable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.laiqian.opentable.R;

class q extends BaseAdapter {
  q(o paramo, CharSequence[] paramArrayOfCharSequence) {}
  
  public int getCount() { return this.bMS.length; }
  
  public Object getItem(int paramInt) { return this.bMS[paramInt]; }
  
  public long getItemId(int paramInt) { return paramInt; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    paramView = LayoutInflater.from(o.a(this.bMR)).inflate(R.layout.mobile_plain_text_item, paramViewGroup, false);
    ((TextView)paramView).setText(this.bMS[paramInt]);
    return paramView;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */