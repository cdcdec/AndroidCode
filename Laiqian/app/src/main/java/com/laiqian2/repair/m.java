package com.laiqian.repair;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.w;
import com.laiqian.util.n;
import java.util.ArrayList;

class m extends Handler {
  m(SelfRepairMain paramSelfRepairMain) {}
  
  public void handleMessage(Message paramMessage) {
    ArrayList arrayList;
    View view = SelfRepairMain.c(this.cYp);
    byte b = 0;
    view.setVisibility(0);
    SelfRepairMain.d(this.cYp).setVisibility(8);
    int i = paramMessage.what;
    if (i != -1) {
      if (i != 1) {
        if (i != 4) {
          if (i != 6) {
            switch (i) {
              default:
                return;
              case 9:
                if (SelfRepairMain.g(this.cYp).isShowing()) {
                  SelfRepairMain.g(this.cYp).dismiss();
                  return;
                } 
                return;
              case 8:
                break;
            } 
            if (SelfRepairMain.g(this.cYp).isShowing())
              SelfRepairMain.g(this.cYp).dismiss(); 
            (new SelfRepairMain.b(this.cYp, SelfRepairMain.b(this.cYp), null)).start();
            return;
          } 
          if (!SelfRepairMain.g(this.cYp).isShowing()) {
            SelfRepairMain.g(this.cYp).show();
            return;
          } 
        } else {
          this.cYp.bCF.show();
          return;
        } 
      } else {
        arrayList = (ArrayList)paramMessage.obj;
        if (arrayList.size() == 0) {
          n.w(this.cYp, R.string.pos_repair_self_find_no);
          return;
        } 
        if (arrayList.size() == 1) {
          (new b(this.cYp, (e)arrayList.get(0))).ame();
          return;
        } 
        String[] arrayOfString = new String[arrayList.size()];
        while (b < arrayOfString.length) {
          arrayOfString[b] = ((e)arrayList.get(b)).title;
          b++;
        } 
        (new w(this.cYp, arrayOfString, new n(this, arrayList))).show();
        return;
      } 
    } else {
      SelfRepairMain selfRepairMain = this.cYp;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(arrayList.obj);
      stringBuilder.append("");
      n.a(selfRepairMain, stringBuilder.toString());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repair\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */