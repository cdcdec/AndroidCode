package com.laiqian.promotion.ui.datePicker;

import android.widget.TextView;
import com.laiqian.promotion.R;
import com.laiqian.ui.a.a;
import com.laiqian.util.n;

class d implements a.a {
  d(a.b paramb) {}
  
  public boolean a(TextView paramTextView, String paramString, long paramLong) {
    if (paramTextView.getTag(R.id.dateDialogTag) != null) {
      long l2;
      long l1;
      if (paramTextView == (TextView[])paramTextView.getTag(R.id.dateDialogTag)[false]) {
        l1 = ((Long)(TextView[])paramTextView.getTag(R.id.dateDialogTag)[1].getTag()).longValue();
        l2 = paramLong;
      } else if (paramTextView == (TextView[])paramTextView.getTag(R.id.dateDialogTag)[true]) {
        l2 = ((Long)(TextView[])paramTextView.getTag(R.id.dateDialogTag)[0].getTag()).longValue();
        l1 = paramLong;
      } else {
        return false;
      } 
      if (l1 < l2) {
        n.w(a.b(this.cXl.cXj), R.string.pos_report_time_custom_error);
        return true;
      } 
    } 
    return false;
  }
  
  public void b(TextView paramTextView, String paramString, long paramLong) {
    if (paramTextView.getTag(R.id.dateDialogTag) != null) {
      if (paramTextView == (TextView[])paramTextView.getTag(R.id.dateDialogTag)[false]) {
        a.c(this.cXl.cXj).aa(paramLong);
        a.c(this.cXl.cXj).cP(paramString);
      } else if (paramTextView == (TextView[])paramTextView.getTag(R.id.dateDialogTag)[true]) {
        a.c(this.cXl.cXj).ab(paramLong);
        a.c(this.cXl.cXj).cQ(paramString);
      } 
    } else {
      a.c(this.cXl.cXj).ac(paramLong);
      a.c(this.cXl.cXj).cR(paramString);
    } 
    paramTextView.setText(paramString);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\datePicker\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */