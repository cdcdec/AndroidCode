package com.laiqian.pos.features;

import android.view.View;
import android.widget.TextView;
import com.laiqian.ui.a.ab;
import com.laiqian.util.bd;

class y implements View.OnClickListener {
  y(ScanOrderExportFragment paramScanOrderExportFragment, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView) {
    String str = this.cjV.getText().toString().trim();
    if (str.length() == 0) {
      this.cjW.setText(2131627848);
      return;
    } 
    if (!bd.bH(this.cjQ.getActivity())) {
      this.cjW.setText(2131627849);
      return;
    } 
    this.cjW.setText(null);
    ab.N(this.cjQ.getActivity());
    if (this.cjQ.isAdded()) {
      ScanOrderExportFragment scanOrderExportFragment = this.cjQ;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(this.cjT.getText().toString());
      (new ScanOrderExportFragment.a(scanOrderExportFragment, stringBuilder.toString(), this.cjR, this.cjS, null)).start();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */