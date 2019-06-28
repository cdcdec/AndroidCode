package com.laiqian.backup;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;
import io.reactivex.g.a;

class c implements AdapterView.OnItemClickListener {
  c(BackUpRootActivity paramBackUpRootActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    f f;
    switch (paramInt) {
      default:
        return;
      case 2:
        if (!bd.bH(this.aHq))
          return; 
        if (BackUpRootActivity.g(this.aHq) == null)
          BackUpRootActivity.a(this.aHq, new bb(this.aHq)); 
        BackUpRootActivity.g(this.aHq).show();
        f = new f(this);
        a.aKh().r(f);
        return;
      case 1:
        if (BackUpRootActivity.e(this.aHq).equals("150001")) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.aHq.aHg);
          stringBuilder.append("/");
          stringBuilder.append(this.aHq.aHf);
          if (ag.bE(stringBuilder.toString())) {
            Toast.makeText(this.aHq.getBaseContext(), this.aHq.getString(2131624345), 0).show();
            BackUpRootActivity.f(this.aHq);
          } else {
            Toast.makeText(this.aHq.getBaseContext(), this.aHq.getString(2131624344), 0).show();
          } 
        } else {
          Toast.makeText(this.aHq.getBaseContext(), this.aHq.getString(2131624349), 0).show();
        } 
        BackUpRootActivity.b(this.aHq).dismiss();
        return;
      case 0:
        break;
    } 
    if (this.aHq.aCz == null) {
      d d = new d(this);
      this.aHq.aCz = new r(this.aHq, d);
      this.aHq.aCz.setTitle(this.aHq.getString(2131624382));
      this.aHq.aCz.s(this.aHq.getString(2131624381));
    } 
    this.aHq.aCz.show();
    BackUpRootActivity.b(this.aHq).dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */