package com.laiqian.promotion.d;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.laiqian.entity.DateSelectEntity;
import com.laiqian.entity.ac;
import com.laiqian.entity.ae;
import com.laiqian.entity.ag;
import com.laiqian.entity.ak;
import com.laiqian.entity.g;
import com.laiqian.entity.w;
import com.laiqian.models.at;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.promotion.R;
import com.laiqian.promotion.c.a;
import com.laiqian.promotion.e.a;
import com.laiqian.promotion.e.a.a;
import com.laiqian.promotion.f.a;
import com.laiqian.promotion.g.b;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.g;
import com.laiqian.util.av;
import com.laiqian.util.n;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
  private static final String TAG = "a";
  
  private long aRP;
  
  private b cVD;
  
  private int cVE;
  
  private a cVF;
  
  private g<w> cVG;
  
  private ac cVH;
  
  private ac cVI;
  
  private ak cVJ;
  
  private b cVK;
  
  private boolean cVL;
  
  private boolean cVM;
  
  private ActivityRoot cgM;
  
  static  {
  
  }
  
  public a(ActivityRoot paramActivityRoot, b paramb, int paramInt) {
    this.cgM = paramActivityRoot;
    this.cVD = paramb;
    this.cVE = paramInt;
    this.cVF = new a(paramActivityRoot);
  }
  
  private boolean alA() {
    if (this.cVI.Hj().Hs() <= 0.0D) {
      n.eP(R.string.pos_promotion_buy_num_must_than_zero);
      return false;
    } 
    return true;
  }
  
  private boolean alB() {
    boolean bool2;
    boolean bool1;
    if (this.cVI.Hh() <= 0.0D) {
      n.eP(R.string.pos_promotio_recharge_amount_than_zero);
      return false;
    } 
    a a1 = new a(this.cgM);
    boolean bool = a1.a(this.cVM, this.cVI);
    a1.close();
    if (bool) {
      String str = this.cgM.getString(R.string.pos_promotion_recharge_amount_exist);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.cVI.Hh());
      stringBuilder.append("");
      n.o(String.format(str, new Object[] { stringBuilder.toString() }));
      return false;
    } 
    if (this.cVI.Hp() > 0.0D) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.cVI.Hj() != null) {
      bool2 = TextUtils.isEmpty(this.cVI.Hj().Hu()) ^ true;
    } else {
      bool2 = false;
    } 
    if (!bool1 && !bool2) {
      n.eP(R.string.pos_promotion_select_at_least_select_one_gift);
      return false;
    } 
    return !(bool2 && !alC());
  }
  
  private boolean alC() {
    ae ae = this.cVI.Hj();
    if (TextUtils.isEmpty(ae.Hu())) {
      n.eP(R.string.pos_please_select_product);
      return false;
    } 
    if (ae.Ht() <= 0.0D) {
      n.eP(R.string.pos_promotion_gift_num_must_than_zero);
      return false;
    } 
    if (this.cVI.Ho() <= 0.0D) {
      n.eP(R.string.pos_promotion_gift_total_num_must_than_zero);
      return false;
    } 
    if (ae.Ht() > this.cVI.Ho()) {
      n.eP(R.string.pos_promotion_gift_total_num_not_than_gift_num_must);
      return false;
    } 
    if (this.cVI.Ho() % ae.Ht() != 0.0D) {
      n.eP(R.string.pos_promotion_gift_total_num_gift_num_must_integer_times);
      return false;
    } 
    return true;
  }
  
  private boolean alD() {
    if (this.cVI.Hi() <= 0.0D) {
      n.eP(R.string.pos_promotion_deduct_amount_must_than_zero);
      return false;
    } 
    if (this.cVI.Hi() > this.cVI.Hk()) {
      n.eP(R.string.pos_promotion_deduct_amount_not_than_buy_amount);
      return false;
    } 
    return true;
  }
  
  private boolean alE() {
    if (this.cVI.Hk() <= 0.0D) {
      n.eP(R.string.pos_promotion_buy_amount_must_than_zero);
      return false;
    } 
    return true;
  }
  
  private boolean alF() {
    if (this.cVI.FI() <= 0.0D || this.cVI.FI() >= 100.0D) {
      n.eP(R.string.pos_promotion_discount_between_0_and_100);
      return false;
    } 
    return true;
  }
  
  private void alu() {
    ArrayList arrayList = new ArrayList();
    null = this.cgM.getResources().getStringArray(R.array.people_type);
    null = new av(this.cgM);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(null.Tx());
    stringBuilder1.append(111);
    String str1 = stringBuilder1.toString();
    null.close();
    String[] arrayOfString = new String[3];
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str1);
    stringBuilder3.append("003");
    String str2 = stringBuilder3.toString();
    byte b1 = 0;
    arrayOfString[0] = str2;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append("002");
    arrayOfString[1] = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append("001");
    arrayOfString[2] = stringBuilder2.toString();
    while (b1 < arrayOfString.length) {
      arrayList.add(new w(n.parseLong(arrayOfString[b1]), null[b1]));
      b1++;
    } 
    for (g g1 : (new at(this.cgM)).RJ())
      arrayList.add(new w(g1.getId(), g1.EV())); 
    this.cVG = new g(this.cgM, arrayList, new b(this));
  }
  
  private void alw() {
    if (this.cVI.Hn() == null) {
      ag ag = (new ag.a()).HE();
      this.cVI.a(ag);
    } 
  }
  
  private void alx() {
    if (this.cVI.Hj() == null) {
      ae ae = (new ae.a()).Hx();
      this.cVI.a(ae);
    } 
  }
  
  private boolean aly() {
    ag ag = this.cVI.Hn();
    if (ag.HB() == 0) {
      if (ag.Hz() <= 0.0D || ag.Hz() >= 100.0D) {
        n.eP(R.string.pos_promotion_discount_between_0_and_100);
        return false;
      } 
    } else {
      double d = ag.HA();
      if (!this.cVF.a(ag.Hy(), d)) {
        n.eP(R.string.pos_promotion_discount_price_must_not_than_product_sale_price);
        return false;
      } 
    } 
    return true;
  }
  
  private boolean alz() {
    if (TextUtils.isEmpty(this.cVI.Hn().HC())) {
      n.eP(R.string.pos_please_select_product);
      return false;
    } 
    return true;
  }
  
  public boolean Az() {
    if (alr()) {
      this.cVI.cX(a.a(this.cVH.He(), this.cVI.He(), null, null));
      return this.cVI.equals(this.cVH) ^ true;
    } 
    return false;
  }
  
  public void a(DateSelectEntity paramDateSelectEntity) { this.cVI.a(paramDateSelectEntity); }
  
  public void a(b paramb) { this.cVK = paramb; }
  
  public void a(long[] paramArrayOfLong, String paramString) {
    alw();
    this.cVI.Hn().dp(paramString);
    this.cVI.Hn().c(paramArrayOfLong);
  }
  
  public void a(long[] paramArrayOfLong, String paramString, int paramInt) {
    alx();
    this.cVI.Hj().ez(paramInt);
    this.cVI.Hj().dn(paramString);
    this.cVI.Hj().a(paramArrayOfLong);
  }
  
  public boolean alr() { return this.cVL; }
  
  public boolean als() {
    List list = a.bt(this.cgM);
    if (list.size() == 0) {
      this.cVD.nd(this.cgM.getString(R.string.pos_promotion_create_init_view_error));
      return false;
    } 
    this.cVJ = (ak)list.get(this.cVE - 1);
    this.cVD.b(this.cVJ);
    return true;
  }
  
  public void alt() {
    if (this.cVG == null)
      alu(); 
    this.cVG.show();
  }
  
  @DebugLog
  public void alv() {
    boolean bool;
    byte b1;
    ArrayList arrayList = this.cVF.a(this.cVE, this.cVJ);
    if (this.aRP != -1L) {
      Iterator iterator = arrayList.iterator();
      byte b2 = 0;
      while (true) {
        b1 = b2;
        if (iterator.hasNext()) {
          if (((ac)iterator.next()).getID() == this.aRP) {
            b1 = b2;
            break;
          } 
          b2++;
          continue;
        } 
        break;
      } 
    } else {
      b1 = 0;
    } 
    if (arrayList.size() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.cVL = bool;
    if (this.cVL) {
      b((ac)arrayList.get(b1));
      this.cVD.f(arrayList, b1);
      this.cVD.c((ac)arrayList.get(b1));
      this.cVD.gw(false);
      this.cVD.gx(true);
      return;
    } 
    this.cVD.gw(true);
    this.cVD.gx(false);
  }
  
  public void b(long paramLong, int paramInt, boolean paramBoolean) { (new a(this, paramLong, paramInt, null)).execute(new Boolean[] { Boolean.valueOf(paramBoolean) }); }
  
  public void b(ac paramac) {
    this.cVI = paramac;
    this.cVH = this.cVI.a(this.cVI);
  }
  
  public void dd(long paramLong) {
    if (this.cVG == null)
      alu(); 
    this.cVG.dn(paramLong);
  }
  
  public void de(long paramLong) { this.aRP = paramLong; }
  
  public void eB(int paramInt) {
    alw();
    this.cVI.Hn().eB(paramInt);
  }
  
  public void g(long paramLong, int paramInt) {
    if (this.cVF.O(paramLong)) {
      this.cVD.nd(this.cgM.getString(R.string.pos_promotion_delete_success));
      this.cVD.jC(paramInt);
      return;
    } 
    this.cVD.nd(this.cgM.getString(R.string.pos_promotion_delete_fail));
  }
  
  public void gu(boolean paramBoolean) { this.cVL = paramBoolean; }
  
  public void i(ArrayList<ProductTypeEntity> paramArrayList, String paramString) {
    this.cVI.q(paramArrayList);
    this.cVI.dk(paramString);
  }
  
  public void mQ(String paramString) { this.cVI.setName(paramString); }
  
  public void mR(String paramString) { this.cVI.v(n.u(paramString)); }
  
  public void mS(String paramString) { this.cVI.z(n.u(paramString)); }
  
  public void mT(String paramString) { this.cVI.A(n.u(paramString)); }
  
  public void mU(String paramString) {
    alw();
    this.cVI.Hn().Q(n.u(paramString));
  }
  
  public void mV(String paramString) {
    alw();
    this.cVI.Hn().R(n.u(paramString));
  }
  
  public void mW(String paramString) { this.cVI.x(n.u(paramString)); }
  
  public void mX(String paramString) {
    alx();
    this.cVI.Hj().N(n.u(paramString));
  }
  
  public void mY(String paramString) {
    alx();
    this.cVI.Hj().M(n.u(paramString));
  }
  
  public void mZ(String paramString) {
    alx();
    this.cVI.B(n.u(paramString));
  }
  
  public void na(String paramString) {
    ac ac1 = a.a(paramString, this.cgM, this.cVE);
    b(ac1);
    this.cVD.alW();
    this.cVD.a(0, ac1);
    this.cVD.c(ac1);
  }
  
  public void nb(String paramString) { this.cVI.C(n.u(paramString)); }
  
  public void nc(String paramString) { this.cVI.w(n.u(paramString)); }
  
  public void p(double paramDouble) { this.cVI.p(paramDouble); }
  
  public void save() {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("save: ");
    stringBuilder.append(this.cVI.toString());
    Log.e(str, stringBuilder.toString());
    if (this.cVI.getState() == 0) {
      this.cVM = false;
      (new c(this, null)).execute(new Boolean[0]);
      return;
    } 
    this.cVM = true;
    (new c(this, null)).execute(new Boolean[0]);
  }
  
  private class a extends AsyncTask<Boolean, Void, Boolean> {
    private long aRP;
    
    boolean cVO = false;
    
    private int position;
    
    private a(a this$0, long param1Long, int param1Int) {
      this.aRP = param1Long;
      this.position = param1Int;
    }
    
    protected void b(Boolean param1Boolean) {
      if (param1Boolean.booleanValue()) {
        byte b;
        ac ac = a.a(this.cVN);
        if (!this.cVO) {
          b = 1;
        } else {
          b = 2;
        } 
        ac.setState(b);
        a.a(this.cVN, a.a(this.cVN).a(a.a(this.cVN)));
        a.b(this.cVN).jB(this.position);
        a.b(this.cVN).nd(a.d(this.cVN).getString(R.string.pos_promotion_operation_success));
        return;
      } 
      a.b(this.cVN).nd(a.d(this.cVN).getString(R.string.pos_promotion_operation_fail));
    }
    
    protected Boolean c(Boolean... param1VarArgs) {
      boolean bool;
      this.cVO = param1VarArgs[0].booleanValue();
      if (this.cVO) {
        bool = a.c(this.cVN).cU(this.aRP);
      } else {
        bool = a.c(this.cVN).cV(this.aRP);
      } 
      return Boolean.valueOf(bool);
    }
  }
  
  public static interface b {
    void alG();
    
    void onSuccess();
  }
  
  private class c extends AsyncTask<Boolean, Void, Boolean> {
    boolean bBY = false;
    
    private c(a this$0) {}
    
    private boolean SI() {
      if (TextUtils.isEmpty(a.a(this.cVN).getName())) {
        n.eP(R.string.pos_promotion_name_not_null);
        return false;
      } 
      a a1 = new a(a.d(this.cVN));
      boolean bool = a1.b(a.e(this.cVN), a.a(this.cVN));
      a1.close();
      if (bool) {
        n.eP(R.string.pos_promotionName_exist);
        return false;
      } 
      return (a.f(this.cVN).HP() && !a.g(this.cVN)) ? false : ((a.f(this.cVN).Ia() && !a.h(this.cVN)) ? false : ((a.f(this.cVN).HN() && a.i(this.cVN) != 5 && !a.j(this.cVN)) ? false : ((a.f(this.cVN).HZ() && !a.k(this.cVN)) ? false : ((a.f(this.cVN).Ib() && !a.l(this.cVN)) ? false : ((a.f(this.cVN).Ic() && !a.m(this.cVN)) ? false : ((a.f(this.cVN).Ie() && !a.n(this.cVN)) ? false : (!(a.f(this.cVN).If() && !a.o(this.cVN)))))))));
    }
    
    protected void b(Boolean param1Boolean) {
      a.b(this.cVN).RA();
      if (this.bBY) {
        if (param1Boolean.booleanValue()) {
          boolean bool1 = a.e(this.cVN);
          boolean bool = false;
          if (!bool1) {
            a.a(this.cVN).setState(1);
            a.b(this.cVN).jB(0);
            a.b(this.cVN).alX();
            a.b(this.cVN).nd(a.d(this.cVN).getString(R.string.pos_promotion_create_save_success));
          } else {
            if (a.a(this.cVN).Hc().EA() <= System.currentTimeMillis())
              bool = true; 
            if (bool) {
              a.a(this.cVN).setState(3);
            } else if (a.p(this.cVN).getState() == 3) {
              a.a(this.cVN).setState(1);
            } 
            a.e(a.a(this.cVN).Hc());
            a.b(this.cVN).alY();
            a.b(this.cVN).nd(a.d(this.cVN).getString(R.string.pos_promotion_create_update_success));
          } 
          a.a(this.cVN, a.a(this.cVN).a(a.a(this.cVN)));
          if (a.q(this.cVN) != null) {
            a.q(this.cVN).onSuccess();
            return;
          } 
        } else {
          String str;
          b b = a.b(this.cVN);
          if (a.e(this.cVN)) {
            str = a.d(this.cVN).getString(R.string.pos_promotion_create_update_failed);
          } else {
            str = a.d(this.cVN).getString(R.string.pos_promotion_create_save_failed);
          } 
          b.nd(str);
          if (a.q(this.cVN) != null) {
            a.q(this.cVN).alG();
            return;
          } 
        } 
      } else if (a.q(this.cVN) != null) {
        a.q(this.cVN).alG();
      } 
    }
    
    protected Boolean c(Boolean... param1VarArgs) {
      if (this.bBY) {
        if (!a.e(this.cVN)) {
          a.a(this.cVN).at(System.currentTimeMillis());
          return Boolean.valueOf(a.c(this.cVN).a(a.a(this.cVN), a.f(this.cVN)));
        } 
        return Boolean.valueOf(a.c(this.cVN).a(a.a(this.cVN), a.p(this.cVN), a.f(this.cVN)));
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      a.b(this.cVN).Rz();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */