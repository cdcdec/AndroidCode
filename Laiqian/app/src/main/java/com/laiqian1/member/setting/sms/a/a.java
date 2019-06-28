package com.laiqian.member.setting.sms.a;

import com.laiqian.member.setting.sms.j;
import com.laiqian.vip.R;
import java.util.ArrayList;
import java.util.List;

public class a {
  List<j> bHc = new ArrayList();
  
  public a() {
    this.bHc.clear();
    SV();
  }
  
  private void a(int paramInt1, double paramDouble1, int paramInt2, double paramDouble2, int paramInt3) {
    j j = new j();
    j.price = paramInt1;
    j.bGH = paramDouble1;
    j.quantity = paramInt2;
    j.bGI = paramDouble2;
    j.bGJ = paramInt3;
    this.bHc.add(j);
  }
  
  public List<j> SU() { return this.bHc; }
  
  void SV() {
    a(88, 88.8D, 888, 0.099D, -1);
    a(188, 218.0D, 2188, 0.085D, R.drawable.ic_recommend);
    a(288, 338.0D, 3388, 0.084D, -1);
    a(388, 478.0D, 4788, 0.081D, -1);
    a(588, 738.0D, 7388, 0.079D, R.drawable.ic_practical);
    a(988, 1247.0D, 12588, 0.078D, -1);
    a(1888, 2395.0D, 24188, 0.078D, -1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */