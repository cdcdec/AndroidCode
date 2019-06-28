package com.laiqian.main.module.settlement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.jakewharton.b.b;
import com.jakewharton.b.c;
import com.laiqian.auth.au;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.entity.c;
import com.laiqian.entity.v;
import com.laiqian.main.b.b;
import com.laiqian.main.b.c;
import com.laiqian.main.dl;
import com.laiqian.main.module.settlement.pay.a;
import com.laiqian.main.module.settlement.pay.b;
import com.laiqian.main.module.settlement.pay.v;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.pos.AliPayPreorderDetail;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.print.dualscreen.o;
import com.laiqian.rx.util.a;
import com.laiqian.util.bd;
import io.reactivex.a.a;
import io.reactivex.h;
import io.reactivex.h.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ag {
  private static final String TAG;
  
  public b<c> bdL;
  
  public b<Double> beS;
  
  public b<Double> beT;
  
  public b<Double> beU;
  
  public b<Integer> beb;
  
  public b<TableEntity> beg;
  
  public b<Boolean> bei = (this.bnh = (this.beg = (this.bng = b.ak(Long.valueOf(0L))).ak(TableEntity.bZK)).ak(Long.valueOf(0L))).ak(Boolean.FALSE);
  
  public b<PendingFullOrderDetail> bej;
  
  a blP;
  
  public dl blR;
  
  public b<Boolean> bmA;
  
  public b<Boolean> bmB;
  
  public b<aq> bmC;
  
  public b<Boolean> bmD;
  
  public b<Boolean> bmE;
  
  public b<Boolean> bmF;
  
  public b<Double> bmG;
  
  public b<Double> bmH;
  
  public b<Boolean> bmI;
  
  public b<Boolean> bmJ;
  
  public b<Double> bmK;
  
  public b<Boolean> bmL;
  
  public b<Boolean> bmM;
  
  public b<Boolean> bmN;
  
  public b<Integer> bmO;
  
  public b<Boolean> bmP;
  
  public b<Boolean> bmQ = (this.bmP = (this.bmO = (this.bmN = (this.bmM = (this.bmL = (this.bmK = (this.bmJ = (this.bmI = (this.bmH = (this.bmG = (this.bmF = (this.bmE = (this.bmD = (this.bdL = (this.bmC = (this.bmB = (this.bmA = (this.bmz = (this.bmy = (this.bmx = (this.beU = (this.beT = (this.beS = b.ak(Double.valueOf(0.0D))).ak(Double.valueOf(100.0D))).ak(Double.valueOf(0.0D))).ak(Double.valueOf(0.0D))).ak(Double.valueOf(0.0D))).ak(Double.valueOf(0.0D))).ak(Boolean.FALSE)).ak(Boolean.TRUE)).ak(aq.aWG)).ak(c.aRx)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Double.valueOf(0.0D))).ak(Double.valueOf(0.0D))).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Double.valueOf(0.0D))).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Integer.valueOf(10001))).ak(Boolean.FALSE)).ak(Boolean.FALSE);
  
  public a<Integer> bmR = a.aoI();
  
  public b<Double> bmS;
  
  public final a bmT;
  
  public b<Boolean> bmU;
  
  public b<Boolean> bmV;
  
  public b<Boolean> bmW;
  
  public b<Boolean> bmX;
  
  public b<Boolean> bmY;
  
  public b<Boolean> bmZ;
  
  public b<Double> bmx;
  
  public b<Double> bmy;
  
  public b<Double> bmz;
  
  public b<Boolean> bna;
  
  public b<PendingFullOrderDetail.a> bnb;
  
  public b<AliPayPreorderDetail> bnc;
  
  public b<Boolean> bnd;
  
  public b<String> bne = (this.bnd = (this.bnc = (this.bej = (this.bnb = (this.bna = (this.bmZ = (this.bmY = (this.bmX = (this.bmW = (this.bmV = (this.bmU = (this.bmS = b.ak(Double.valueOf(0.0D))).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.TRUE)).ak(Boolean.FALSE)).wJ()).wJ()).wJ()).ak(Boolean.FALSE)).wJ();
  
  public c<Object> bnf = c.wO();
  
  public b<Long> bng;
  
  public b<Long> bnh;
  
  public b<String> bni;
  
  public b<String> bnj;
  
  public Context mContext;
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("@emery++");
    stringBuilder.append(ag.class.getSimpleName());
    TAG = stringBuilder.toString();
  }
  
  ag(dl paramdl, Context paramContext) {
    boolean bool = false;
    this.bnj = (this.bni = (this.beb = b.ak(Integer.valueOf(0))).ak("")).ak("");
    this.mContext = paramContext;
    this.blR = paramdl;
    Ot();
    this.blP = new a();
    this.bmC = paramdl.bdM;
    this.beT.accept(paramdl.bea.beT.getValue());
    this.beS.accept(paramdl.bea.beS.getValue());
    this.beU.accept(paramdl.bea.beU.getValue());
    b b1 = this.bmB;
    if (((Integer)paramdl.bdS.getValue()).intValue() != 4)
      bool = true; 
    b1.accept(Boolean.valueOf(bool));
    this.bdL = paramdl.bdL;
    paramdl.beb.b(this.beb);
    this.beg = paramdl.beg;
    this.bei = paramdl.bei;
    this.bnj = paramdl.beh;
    this.bej = paramdl.bej;
    this.bmT = new a(this, this.mContext);
    this.bnf.b(new ah(this));
    this.blP.b(h.a(this.beg, this.beb, new ai(this)).b(this.bni));
    this.blP.b(h.a(this.beb, this.bnj, new at(this)).b(this.bng));
    this.blP.b(h.a(this.bmB, this.blR.bea.beO, new ay(this)).b(new ax(this)));
    this.blP.b(this.bnb.d(new az(this)).aJh().b(this.bnd));
    this.blP.b(this.bmT.bnC.bnT.d(new ba(this)).aJh().b(this.bna));
    this.blP.b(this.bmT.bnn.b(new bb(this)));
    this.blP.b(h.a(this.bmy, this.bmx, new bc(this)).aJh().b(this.bmN));
    this.blP.b(h.a(this.bmC, this.bmB, this.bmN, new bd(this)).b(this.bmM));
    this.blP.b(h.a(this.bmM, this.bmC, this.bmN, this.bmB, new aj(this)).b(this.beT));
    this.blP.b(h.a(this.bmy, this.beT, this.bmx, new ak(this)).aJh().b(this.beU));
    this.blP.b(h.a(this.beU, this.bmy, this.bmx, this.bmA, new al(this)).d(new a.e()).aJh().b(this.beT));
    this.blP.b(h.a(this.bmC, this.bmD, this.bmB, new an(this)).b(new am(this)));
    this.blP.b(h.a(this.beU, this.bmE, this.bmC, new ao(this)).aJh().b(this.bmH));
    this.blP.b(h.a(this.bmH, this.beU, this.bmI, this.bmE, new ap(this)).aJh().b(this.bmG));
    this.blP.b(h.a(this.bmG, this.bmC, this.bmB, new aq(this)).b(this.bmP));
    this.blP.b(this.bmK.aJh().b(this.bmz));
    this.blP.b(h.a(this.bmC, this.bmG, new ar(this)).b(this.bmQ));
    this.blP.b(h.a(this.bmT.bnm, this.bmG, new as(this)).aJh().b(this.bmR));
    h.a(this.bmF, this.bmG, this.beU, new au(this)).aJh().b(this.bmz);
    this.blP.b(h.a(this.bmT.bnG, this.bmT.bnm, this.bmT.bnr, this.bmz, this.bmG, this.bmy, this.bmT.bnt, new av(this)).aJh().b(this.bnc));
    this.blP.b(h.a(this.bmT.bnG, this.bnc, this.bmT.bnm, this.bmT.bnr, this.bmz, new aw(this)).aJk());
  }
  
  private List<Integer> Os() {
    ArrayList arrayList = new ArrayList();
    arrayList.add(Integer.valueOf(10));
    arrayList.add(Integer.valueOf(20));
    arrayList.add(Integer.valueOf(50));
    arrayList.add(Integer.valueOf(100));
    return arrayList;
  }
  
  private void a(boolean paramBoolean, o paramo, c paramc, b paramb) {
    if (paramo != null) {
      if (paramc.aTe == 5L || (paramb != null && paramb.aTx == 5L)) {
        paramo.afP().fN(paramBoolean);
        return;
      } 
      if (paramc.aTe == 1L || (paramb != null && paramb.aTx == 1L)) {
        paramo.afP().fM(paramBoolean);
        return;
      } 
      if (!paramBoolean) {
        paramo.afP().fM(false);
        return;
      } 
    } 
  }
  
  private b obtainPayTypeItemByPayTypeItemView(c paramc, double paramDouble) { return new b(paramc.aTv, paramDouble, paramc.aKu.getText().toString(), paramc.aTe); }
  
  public void Ot() {
    boolean bool;
    this.bmD.accept(Boolean.valueOf(a.AZ().BB()));
    this.bmI.accept(Boolean.valueOf(a.AZ().BK()));
    b b1 = this.bmZ;
    if (a.AZ().Bc() || a.AZ().Bk()) {
      bool = true;
    } else {
      bool = false;
    } 
    b1.accept(Boolean.valueOf(bool));
  }
  
  public class a {
    public b<Boolean> bnA;
    
    public final a bnB;
    
    public final b bnC;
    
    public b<Boolean> bnD;
    
    public b<Boolean> bnE;
    
    public b<AliPayPreorderDetail> bnF = (this.bnE = (this.bnD = (this.bnA = (this.bnz = (this.bny = b.wJ()).ak(v.aTf)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(AliPayPreorderDetail.ceT);
    
    public a<a> bnG = a.aKk();
    
    public b<c> bnm;
    
    public b<c> bnn = (this.bnm = b.ak(c.bpu)).ak(c.bpu);
    
    public a<c> bno = a.aoI();
    
    public b<c> bnp = b.wJ();
    
    public a<b> bnq = a.aoI();
    
    public b<b> bnr;
    
    public b<b> bns;
    
    public b<Double> bnt;
    
    public b<Boolean> bnu = (this.bnt = (this.bns = (this.bnr = b.ak(b.boG)).ak(b.boG)).ak(Double.valueOf(0.0D))).ak(Boolean.FALSE);
    
    public a<v> bnv = a.aoI();
    
    public Map<Integer, c> bnw = new HashMap();
    
    public a<v> bnx = a.aoI();
    
    public b<v> bny;
    
    public b<v> bnz;
    
    public Context mContext;
    
    public a(ag this$0, Context param1Context) {
      this.mContext = param1Context;
      this.bnB = new a(this, this.mContext);
      this.bnC = new b(this, this.mContext);
      Log.i(ag.Ou(), "========PayTypeFragmentVM======初始化 ");
      this$0.blP.b(h.a(this$0.bmF, this$0.bmE, this$0.bmH, this$0.bmz, this$0.beT, new be(this)).aJk());
      this$0.blP.b(this.bnx.a(new bg(this, this$0)).b(new bf(this, this$0)));
      this$0.blP.b(h.a(this.bnv, this.bnx, new bh(this, this$0)).b(this.bnq));
      this$0.blP.b(h.a(this.bnm, this.bns, new bi(this, this$0)).b(this.bnu));
      this$0.blP.b(h.a(this.bnu, this.bnq, new bk(this, this$0)).a(new bj(this, this$0)).b(this.bnr));
      this$0.blP.b(this.bnm.d(new bl(this, this$0)).b(this.bnA));
    }
    
    private b b(v param1v) {
      int j = a.AZ().Bo();
      int i = 2131626887;
      byte b3 = 0;
      byte b2 = 0;
      boolean bool = true;
      if (j == 0) {
        b2 = b3;
      } else {
        if (j == 1) {
          b2 = 1;
        } else {
          i = 2131626884;
        } 
        bool = false;
      } 
      b b1 = obtainPayTypeItemByPayTypeEntity(param1v);
      b1.bpq = b2;
      b1.bpr = bool;
      b1.aTc = i;
      return b1;
    }
    
    private b c(v param1v) {
      int j = a.AZ().Bq();
      boolean bool1 = true;
      int i = 2131626887;
      boolean bool2 = false;
      if (j != 8)
        if (j == 5) {
          bool1 = false;
          bool2 = true;
        } else {
          i = 2131626884;
          bool1 = false;
        }  
      b b1 = obtainPayTypeItemByPayTypeEntity(param1v);
      b1.bpq = bool2;
      b1.bpr = bool1;
      b1.aTc = i;
      return b1;
    }
    
    private boolean fd(int param1Int) { return (param1Int == 10007 || param1Int == 10009); }
    
    private b obtainPayTypeItemByPayTypeEntity(v param1v) {
      long l;
      int i = param1v.aSX;
      String str = param1v.name;
      if (param1v.FQ()) {
        l = param1v.aSW;
      } else {
        l = 0L;
      } 
      return new b(i, 0.0D, str, l);
    }
    
    private <T> void safeAddListItem(List<T> param1List, T param1T) {
      if (param1List != null && param1T != null)
        param1List.add(param1T); 
    }
    
    public class a {
      private Context mContext;
      
      a(ag.a this$0, Context param2Context) {
        this.mContext = param2Context;
        h.a(new bm(this, this$0)).b(this$0.bnx);
      }
    }
    
    public class b {
      public final b<Double> bnM;
      
      public b<au> bnN;
      
      public b<Boolean> bnO;
      
      public b<v> bnP;
      
      public b<Boolean> bnQ;
      
      public b<Boolean> bnR;
      
      public b<Boolean> bnS;
      
      public b<Boolean> bnT;
      
      public b<cy> bnU = (this.bnT = (this.bnS = (this.bnR = (this.bnQ = (this.bnP = (this.bnO = (this.bnN = (this.bnM = b.ak(Double.valueOf(0.0D))).ak(au.aEu)).ak(Boolean.FALSE)).ak(v.boY)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(cy.bos);
      
      private Context mContext;
      
      b(ag.a this$0, Context param2Context) {
        this.mContext = param2Context;
        this$0.bnl.blP.b(h.a(new bn(this, this$0)).aJh().b(this.bnT));
        this$0.bnl.blP.b(h.a(this.bnT, this$0.bnl.bmC, new bp(this, this$0)).aJh().b(this.bnS));
        this$0.bnl.blP.b(h.a(this$0.bnl.bmU, this$0.bnl.bmV, this$0.bnl.bmW, this$0.bnl.bdL, new bq(this, this$0)).aJh().b(this.bnQ));
        this$0.bnl.blP.b(h.a(this.bnQ, this.bnS, this$0.bnr, this.bnP, this$0.bnl.beT, this$0.bnl.beU, this$0.bnm, new br(this, this$0)).aJh().b(this.bnU));
        this$0.bnl.blP.b(this.bnU.d(new bs(this, this$0)).aJh().b(this.bnR));
        this$0.bnl.blP.b(h.a(new bt(this, this$0)).aJh().b(this.bnN));
        this$0.bnl.blP.b(h.a(this.bnN, this$0.bnl.bmC, this$0.bnl.beT, this$0.bnl.bmz, this.bnM, new bv(this, this$0)).a(new bu(this, this$0)).b(this.bnP));
        this$0.bnl.blP.b(this$0.bnm.d(new bw(this, this$0)).aJh().b(this$0.bnD));
        this$0.bnl.blP.b(this$0.bnr.d(new bo(this, this$0)).aJh().b(this$0.bnE));
      }
      
      @NonNull
      private cy a(Integer param2Integer, Boolean param2Boolean1, Boolean param2Boolean2, b param2b, v param2v, Double param2Double1, Double param2Double2, c param2c) {
        cy cy = new cy();
        if (param2Boolean1.booleanValue()) {
          cy.dw(true);
          return cy;
        } 
        if (param2Boolean2.booleanValue() && !bd.bH(this.mContext)) {
          cy.dx(true);
          return cy;
        } 
        if (param2Double1.doubleValue() > 300.0D || param2Double1.doubleValue() <= 0.0D) {
          cy.dy(true);
          return cy;
        } 
        if (param2Double2.doubleValue() == 0.0D) {
          cy.dz(true);
          return cy;
        } 
        if (!param2v.Pd()) {
          cy.dv(true);
          return cy;
        } 
        b b1 = param2b.OT();
        if (b1 != null) {
          if ((isSecondPayEqualsQRCodePay(b1) || b1.bpq) && (isFirstPayTypeEqualsQRPay(param2c) || isFirstPayEqualsBarcodePay(param2c))) {
            cy.dt(true);
            return cy;
          } 
          if ((isSecondPayEqualsQRCodePay(b1) || b1.bpq || isFirstPayTypeEqualsQRPay(param2c) || isFirstPayEqualsBarcodePay(param2c)) && param2c.aTv == 10014) {
            cy.du(true);
            return cy;
          } 
        } 
        return cy;
      }
      
      private boolean isFirstPayEqualsBarcodePay(c param2c) { return param2c.bpq; }
      
      private boolean isFirstPayTypeEqualsQRPay(c param2c) { return param2c.bpr; }
      
      private boolean isSecondPayEqualsQRCodePay(b param2b) { return (param2b != null && param2b.bpr); }
    }
  }
  
  public class a {
    private Context mContext;
    
    a(ag this$0, Context param1Context) {
      this.mContext = param1Context;
      h.a(new bm(this, this$0)).b(this$0.bnx);
    }
  }
  
  public class b {
    public final b<Double> bnM;
    
    public b<au> bnN;
    
    public b<Boolean> bnO;
    
    public b<v> bnP;
    
    public b<Boolean> bnQ;
    
    public b<Boolean> bnR;
    
    public b<Boolean> bnS;
    
    public b<Boolean> bnT;
    
    public b<cy> bnU = (this.bnT = (this.bnS = (this.bnR = (this.bnQ = (this.bnP = (this.bnO = (this.bnN = (this.bnM = b.ak(Double.valueOf(0.0D))).ak(au.aEu)).ak(Boolean.FALSE)).ak(v.boY)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(cy.bos);
    
    private Context mContext;
    
    b(ag this$0, Context param1Context) {
      this.mContext = param1Context;
      this$0.bnl.blP.b(h.a(new bn(this, this$0)).aJh().b(this.bnT));
      this$0.bnl.blP.b(h.a(this.bnT, this$0.bnl.bmC, new bp(this, this$0)).aJh().b(this.bnS));
      this$0.bnl.blP.b(h.a(this$0.bnl.bmU, this$0.bnl.bmV, this$0.bnl.bmW, this$0.bnl.bdL, new bq(this, this$0)).aJh().b(this.bnQ));
      this$0.bnl.blP.b(h.a(this.bnQ, this.bnS, this$0.bnr, this.bnP, this$0.bnl.beT, this$0.bnl.beU, this$0.bnm, new br(this, this$0)).aJh().b(this.bnU));
      this$0.bnl.blP.b(this.bnU.d(new bs(this, this$0)).aJh().b(this.bnR));
      this$0.bnl.blP.b(h.a(new bt(this, this$0)).aJh().b(this.bnN));
      this$0.bnl.blP.b(h.a(this.bnN, this$0.bnl.bmC, this$0.bnl.beT, this$0.bnl.bmz, this.bnM, new bv(this, this$0)).a(new bu(this, this$0)).b(this.bnP));
      this$0.bnl.blP.b(this$0.bnm.d(new bw(this, this$0)).aJh().b(this$0.bnD));
      this$0.bnl.blP.b(this$0.bnr.d(new bo(this, this$0)).aJh().b(this$0.bnE));
    }
    
    @NonNull
    private cy a(Integer param1Integer, Boolean param1Boolean1, Boolean param1Boolean2, b param1b, v param1v, Double param1Double1, Double param1Double2, c param1c) {
      cy cy = new cy();
      if (param1Boolean1.booleanValue()) {
        cy.dw(true);
        return cy;
      } 
      if (param1Boolean2.booleanValue() && !bd.bH(this.mContext)) {
        cy.dx(true);
        return cy;
      } 
      if (param1Double1.doubleValue() > 300.0D || param1Double1.doubleValue() <= 0.0D) {
        cy.dy(true);
        return cy;
      } 
      if (param1Double2.doubleValue() == 0.0D) {
        cy.dz(true);
        return cy;
      } 
      if (!param1v.Pd()) {
        cy.dv(true);
        return cy;
      } 
      b b1 = param1b.OT();
      if (b1 != null) {
        if ((isSecondPayEqualsQRCodePay(b1) || b1.bpq) && (isFirstPayTypeEqualsQRPay(param1c) || isFirstPayEqualsBarcodePay(param1c))) {
          cy.dt(true);
          return cy;
        } 
        if ((isSecondPayEqualsQRCodePay(b1) || b1.bpq || isFirstPayTypeEqualsQRPay(param1c) || isFirstPayEqualsBarcodePay(param1c)) && param1c.aTv == 10014) {
          cy.du(true);
          return cy;
        } 
      } 
      return cy;
    }
    
    private boolean isFirstPayEqualsBarcodePay(c param1c) { return param1c.bpq; }
    
    private boolean isFirstPayTypeEqualsQRPay(c param1c) { return param1c.bpr; }
    
    private boolean isSecondPayEqualsQRCodePay(b param1b) { return (param1b != null && param1b.bpr); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */