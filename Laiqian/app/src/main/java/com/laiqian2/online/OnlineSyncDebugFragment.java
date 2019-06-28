package com.laiqian.online;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.models.d;
import com.laiqian.models.j;
import com.laiqian.models.x;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.s;
import com.laiqian.util.av;
import org.json.JSONException;

public class OnlineSyncDebugFragment extends FragmentRoot {
  a bXJ;
  
  OnlineSyncRequest bXK;
  
  private OnlineSyncRequest Xf() throws Exception {
    OnlineSyncRequest.a a1 = new OnlineSyncRequest.a();
    new av(getActivity());
    a1.iM("20150825163");
    a1.iN("e10adc3949ba59abbe56e057f20f883e");
    a1.bV(629L);
    x x = new x(getActivity());
    a1.a(x.gV("XS-1313-20160412113130567"), 1);
    x.close();
    d d = new d(getActivity());
    a1.a(d.gV("XS-1313-20160412113130567"), 1);
    d.close();
    j j = new j(getActivity());
    a1.a(j.gV("XS-1313-20160412113130567"), 1);
    j.close();
    return a1.Xj();
  }
  
  private void setListeners() { this.bXJ.bEK.setOnClickListener(new c(this)); }
  
  private void setupViews() {
    try {
      this.bXJ.bJv.setText(this.bXK.IX());
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      TextView textView = this.bXJ.bJv;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("error: ");
      stringBuilder.append(jSONException.getMessage());
      textView.setText(stringBuilder.toString());
      return;
    } 
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.bXJ = new a(paramLayoutInflater.inflate(a.aCt, null));
    try {
      this.bXK = Xf();
    } catch (Exception paramLayoutInflater) {
      a.e(paramLayoutInflater);
    } 
    setupViews();
    setListeners();
    return this.bXJ.aQG;
  }
  
  private static class a {
    public static final int aCt = R.layout.fragment_online_sync_debug;
    
    public View aQG;
    
    public Button bEK;
    
    public TextView bJv;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.bJv = (TextView)s.z(param1View, R.id.tv);
      this.bEK = (Button)s.z(param1View, R.id.btn_send);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\online\OnlineSyncDebugFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */