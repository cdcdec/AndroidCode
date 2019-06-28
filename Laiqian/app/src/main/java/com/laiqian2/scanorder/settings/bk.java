package com.laiqian.scanorder.settings;

import android.view.View;
import android.widget.TextView;
import com.laiqian.scan_order_module.R;
import com.laiqian.ui.a.ab;
import com.laiqian.util.bd;

class bk implements View.OnClickListener {
  bk(TableCodeExportFragment paramTableCodeExportFragment, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3) {}
  
  public void onClick(View paramView) {
    String str = this.cjV.getText().toString().trim();
    if (str.length() == 0) {
      this.cjW.setText(R.string.pos_report_export_mail_no_input);
      return;
    } 
    if (!bd.bH(this.djJ.getActivity())) {
      this.cjW.setText(R.string.pos_report_export_mail_no_network);
      return;
    } 
    this.cjW.setText(null);
    ab.N(this.djJ.getActivity());
    TableCodeExportFragment tableCodeExportFragment = this.djJ;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(this.cjT.getText().toString());
    (new TableCodeExportFragment.a(tableCodeExportFragment, stringBuilder.toString(), null)).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */