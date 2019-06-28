package com.laiqian.pos.industry.weiorder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.ui.a.w;
import com.laiqian.util.av;

public class QRCodeSetting extends Fragment {
  private w csD;
  
  private TextView csE;
  
  private LinearLayout csF;
  
  private int[] csG;
  
  private String[] csH;
  
  private String abc() {
    byte b2;
    av av = new av(getActivity());
    long l = av.auf();
    av.close();
    boolean bool = false;
    byte b1 = 0;
    while (true) {
      b2 = bool;
      if (b1 < this.csG.length) {
        if (l == this.csG[b1]) {
          b2 = b1;
          break;
        } 
        b1++;
        continue;
      } 
      break;
    } 
    return this.csH[b2];
  }
  
  private void cD(View paramView) {
    this.csF = (LinearLayout)paramView.findViewById(2131298992);
    this.csE = (TextView)paramView.findViewById(2131299824);
  }
  
  private void xa() { this.csF.setOnClickListener(new l(this)); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131428090, null);
    cD(view);
    xa();
    return view;
  }
  
  public void onStart() {
    super.onStart();
    if (this.csG == null)
      this.csG = new int[] { 10, 20, 30 }; 
    if (this.csH == null) {
      this.csH = new String[this.csG.length];
      for (byte b = 0; b < this.csG.length; b++) {
        String[] arrayOfString = this.csH;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.csG[b]);
        stringBuilder.append("s");
        arrayOfString[b] = stringBuilder.toString();
      } 
    } 
    this.csE.setText(abc());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\QRCodeSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */