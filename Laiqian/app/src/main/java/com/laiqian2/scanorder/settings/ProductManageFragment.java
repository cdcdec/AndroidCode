package com.laiqian.scanorder.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductManageFragment extends FragmentRoot {
  a djr;
  
  private ArrayList<n> aoP() {
    ArrayList arrayList = new ArrayList();
    try {
      if (a.AZ().Cn() == null)
        return new ArrayList(); 
      jSONException = new JSONArray(a.AZ().Cn());
      if (jSONException == null)
        return new ArrayList(); 
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return arrayList;
    } 
    byte b;
    for (b = 0; b < jSONException.length(); b++)
      arrayList.add(n.s(new JSONObject(String.valueOf(jSONException.get(b))))); 
    return arrayList;
  }
  
  private void setListeners() {
    ((RelativeLayout)this.djr.djt.getView()).setOnClickListener(new aj(this));
    ((RelativeLayout)this.djr.dju.getView()).setOnClickListener(new ak(this));
  }
  
  private void setupViews() {
    ((TextView)this.djr.djt.cAO.getView()).setText(getString(R.string.product_display_setting));
    ((TextView)this.djr.djt.dwP.getView()).setText(getString(R.string.picture_and_hot_product));
    ((RelativeLayout)this.djr.djt.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((TextView)this.djr.dju.cAO.getView()).setText(getString(R.string.additional_fees_setting));
    ((RelativeLayout)this.djr.dju.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    ArrayList arrayList = aoP();
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0; b < arrayList.size(); b++) {
      if (!b) {
        stringBuffer.append(((n)arrayList.get(b)).getName());
      } else {
        stringBuffer.append("，");
        stringBuffer.append(((n)arrayList.get(b)).getName());
      } 
    } 
    ((TextView)this.djr.dju.dwP.getView()).setText(stringBuffer.toString());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ArrayList arrayList = aoP();
    StringBuffer stringBuffer = new StringBuffer();
    for (paramInt1 = 0; paramInt1 < arrayList.size(); paramInt1++) {
      if (paramInt1 == 0) {
        stringBuffer.append(((n)arrayList.get(paramInt1)).getName());
      } else {
        stringBuffer.append("，");
        stringBuffer.append(((n)arrayList.get(paramInt1)).getName());
      } 
    } 
    ((TextView)this.djr.dju.dwP.getView()).setText(stringBuffer.toString());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.djr = a.s(this);
    setupViews();
    setListeners();
    return this.djr.getView();
  }
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.fragment_product_manage;
    
    public e djt = new e(R.id.layout_product_manage);
    
    public e dju = new e(R.id.layout_additional_fees);
    
    public a(int param1Int, View param1View) { super(param1Int); }
    
    public static a s(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(aCt, null);
      if (view == null)
        throw new IllegalStateException("view cannot be null, inflate error"); 
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\ProductManageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */