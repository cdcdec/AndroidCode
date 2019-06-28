package com.laiqian.report.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aa;
import com.laiqian.entity.z;
import com.laiqian.main.bb;
import com.laiqian.main.di;
import com.laiqian.models.f;
import com.laiqian.pos.hardware.b;
import com.laiqian.product.a.a;
import com.laiqian.product.a.d;
import com.laiqian.report.a.b;
import com.laiqian.report.models.l;
import com.laiqian.report.models.o;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.util.ar;
import com.laiqian.util.bd;
import com.laiqian.util.i;
import com.laiqian.util.n;
import com.orhanobut.logger.d;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class OrderDetailsByReturn extends OrderDetailsRoot {
  private Handler aiC = new t(this);
  
  @Nullable
  private i bcT;
  
  private bc bcY;
  
  private final int deA = 66;
  
  private a dew;
  
  private ArrayList<String> dex;
  
  private boolean dey;
  
  boolean dez = false;
  
  private void LL() { g(new s(this)); }
  
  private void anS() {
    for (l l : this.payTypeItemArrayList) {
      if (l.aTv == 10014) {
        if (l.aTy != null) {
          try {
            JSONArray jSONArray = new JSONArray(l.aTy);
            this.dex = new ArrayList();
            for (byte b = 0; b < jSONArray.length(); b++) {
              JSONObject jSONObject = jSONArray.getJSONObject(b);
              this.dex.add(jSONObject.getString("couponCode"));
            } 
            break;
          } catch (Throwable null) {
            a.e(null);
            n.o("异常，数据库中获取团购券失败");
          } 
          return;
        } 
        break;
      } 
    } 
  }
  
  private boolean anT() { return (this.dex != null); }
  
  private boolean anU() {
    if (this.payTypeItemArrayList == null)
      return false; 
    for (l l : this.payTypeItemArrayList) {
      if (l.aTv == 10007 && (l.aTx == 0L || l.aTx == 1L))
        return true; 
      if (l.aTv == 10009 && (l.aTx == 8L || l.aTx == 5L))
        return true; 
    } 
    return false;
  }
  
  private boolean b(z paramz) { return (paramz.aTv == 10007 && (paramz.aTx == 0L || paramz.aTx == 1L)) ? true : ((paramz.aTv == 10009 && (paramz.aTx == 8L || paramz.aTx == 5L))); }
  
  private void g(Runnable paramRunnable) {
    if (!bd.bH(this)) {
      if (this.bcY == null)
        this.bcY = new bc(this); 
      this.bcY.show();
      return;
    } 
    if (this.bcT == null)
      this.bcT = new i(); 
    showWaitingDialog(true);
    this.bcT.post(paramRunnable);
  }
  
  protected void noNetworkOnUseChainMember() {
    String str = getActivity().getString(2131628137);
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
      str = getActivity().getString(2131628132); 
    n.o(str);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (isFinishing())
      return; 
    setTitleTextViewHideRightView(2131628144);
    anS();
    this.dew = new a(this, this);
  }
  
  protected void onDeleteFail() {
    this.dez = false;
    n.eP(2131628126);
  }
  
  protected void onDeleteSuc() {
    super.onDeleteSuc();
    boolean bool1 = anT();
    boolean bool = true;
    if (bool1) {
      if (this.dey) {
        if (bool)
          sendBroadcast(new Intent("action_openbox")); 
        b.ckg.aak().c(Integer.valueOf(0));
        this.dez = false;
        return;
      } 
      Iterator iterator = this.payTypeItemArrayList.iterator();
      while (iterator.hasNext()) {
        if (((l)iterator.next()).aTv == 10001)
          // Byte code: goto -> 97 
      } 
    } else {
      z z = a.a(this.dew, this.productDocEntity.amN());
      if (z != null && z.aTv == 10001) {
        if (bool)
          sendBroadcast(new Intent("action_openbox")); 
        b.ckg.aak().c(Integer.valueOf(0));
        this.dez = false;
        return;
      } 
    } 
    bool = false;
    if (bool)
      sendBroadcast(new Intent("action_openbox")); 
    b.ckg.aak().c(Integer.valueOf(0));
    this.dez = false;
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.bcT != null)
      this.bcT.quit(); 
  }
  
  protected boolean setBottomButton(View paramView, boolean paramBoolean) {
    TextView textView = (TextView)paramView;
    textView.setText(2131628120);
    textView.setTextColor(getResources().getColor(2131099820));
    textView.setBackgroundResource(2131231575);
    textView.setOnClickListener(new r(this));
    return true;
  }
  
  protected void setProductOtherInfo(View paramView, o.a parama) {
    if (this.productDocEntity.amL()) {
      paramView = paramView.findViewById(2131298726);
      boolean bool = anU();
      if (parama.cTp == 100066 || parama.akO() || parama.cTp == 100015 || bool) {
        paramView.setVisibility(4);
        return;
      } 
      if (n.bc(parama.bTj)) {
        paramView.setVisibility(4);
        return;
      } 
      paramView.setVisibility(0);
      paramView.setOnClickListener(new q(this));
      paramView.setTag(parama);
      return;
    } 
  }
  
  class a extends d {
    ProgressBarCircularIndeterminate aNv;
    
    ArrayList<o.a> bbT = new ArrayList();
    
    ViewGroup deD;
    
    ViewGroup deE;
    
    View deF;
    
    EditText deG;
    
    View deH;
    
    @Nullable
    o deI;
    
    private final View deJ;
    
    View deK;
    
    TextView deL;
    
    private r deM;
    
    private boolean deN;
    
    Set<Long> deO;
    
    final int deP;
    
    TextView deh;
    
    @Nullable
    di settlementRunnable;
    
    a(OrderDetailsByReturn this$0, Context param1Context) {
      super(param1Context, 2131428018);
      byte b1 = 0;
      byte b2 = 0;
      this.deN = false;
      this.deO = new HashSet();
      this.deP = -1;
      setPositionTop();
      String str1 = this.mView.findViewById(2131298345);
      this.tvTitle = (TextView)str1.findViewById(2131299242);
      this.deD = (ViewGroup)str1.findViewById(2131298552);
      this.deF = findViewById(2131298650);
      str1 = this.deD.findViewById(2131298729);
      String str2 = this.deD.findViewById(2131297196);
      this.deH = this.deD.findViewById(2131296358);
      this.deh = (TextView)this.deH.findViewById(2131296351);
      this.deJ = this.deD.findViewById(2131296352);
      if (OrderDetailsByReturn.e(this$0)) {
        cV(this.deF);
        cV(str1);
        TextView textView = (TextView)str2.findViewById(2131297201);
        for (b1 = 0; b1 < OrderDetailsByReturn.b(this$0).size(); b1++) {
          if (b1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(",");
            stringBuilder.append((String)OrderDetailsByReturn.b(this$0).get(b1));
            textView.append(stringBuilder.toString());
          } else {
            textView.setText((CharSequence)OrderDetailsByReturn.b(this$0).get(b1));
          } 
        } 
        int i = this$0.payTypeItemArrayList.size();
        for (b1 = b2; b1 < i; b1++) {
          l l = (l)this$0.payTypeItemArrayList.get(b1);
          str1 = n.d(Double.valueOf(l.aJW));
          if (l.aTv == 10014) {
            this.deh.setText(str1);
            if (i == 1) {
              cV(this.deJ);
            } else if (i > 1) {
              ((TextView)this.deH.findViewById(2131296359)).setText(2131627329);
            } 
          } else {
            str2 = l.name;
            ((TextView)this.deJ.findViewById(2131296359)).setText(str2);
            ((TextView)this.deJ.findViewById(2131296351)).setText(str1);
          } 
        } 
      } else {
        cV(str2);
        cV(this.deJ);
        this.deE = (ViewGroup)str1.findViewById(2131298728);
        while (b1 < this.deE.getChildCount()) {
          this.deE.getChildAt(b1).setOnClickListener(new v(this, this$0));
          b1++;
        } 
        this.deG = (EditText)this.deF.findViewById(2131298649);
        this.deG.setFilters(ar.bE(99, 3));
        this.deG.addTextChangedListener(new w(this, this$0));
      } 
      View view = this.mView.findViewById(2131298738);
      this.aNv = (ProgressBarCircularIndeterminate)this.mView.findViewById(2131297346);
      this.deL = (TextView)view.findViewById(2131296672);
      this.deL.setOnClickListener(new x(this, this$0));
      this.deK = view.findViewById(2131299105);
      this.deK.setOnClickListener(new y(this, this$0));
    }
    
    private void a(z param1z, double param1Double) {
      if (!bd.bH(RootApplication.zv())) {
        n.eP(2131626280);
        gD(false);
        return;
      } 
      String str = n.a(false, new Date());
      (new b(this.deB, this.deB.productDocEntity.orderNo, str, param1Double, param1z.aTv, new aa(this, param1z))).execute(new Void[0]);
      this.deB.dez = true;
    }
    
    private boolean a(l param1l) { return (param1l.aTv == 10006); }
    
    @Nullable
    private z aV(double param1Double) {
      z z;
      byte b = 0;
      while (true) {
        if (b < this.deE.getChildCount()) {
          View view = this.deE.getChildAt(b);
          if (view.isSelected()) {
            z z1 = (z)view.getTag();
            break;
          } 
          b++;
          continue;
        } 
        z = null;
        break;
      } 
      return (z != null) ? new z(z, param1Double) : null;
    }
    
    private void anV() {
      if (this.deB.dez) {
        n.eP(2131628129);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("repeat return goods=");
      stringBuilder.append(this.deB.dez);
      d.b(stringBuilder.toString(), new Object[0]);
      if (anZ()) {
        anW();
        return;
      } 
      if (!this.deB.productDocEntity.amV()) {
        anX();
        return;
      } 
      anY();
    }
    
    private void anW() {
      z z = aV(this.deB.productDocEntity.amN());
      if (!OrderDetailsByReturn.a(this.deB, z)) {
        aoc();
        return;
      } 
      this.deB.showWaitingDialog(true);
      double d1 = n.u(this.deh.getText());
      if (d1 == 0.0D) {
        n.eP(2131628136);
        return;
      } 
      a(z, d1);
    }
    
    private void anX() {
      z z = aV(this.deB.productDocEntity.amN());
      if (!OrderDetailsByReturn.a(this.deB, z)) {
        aoc();
        return;
      } 
      this.deB.showWaitingDialog(true);
      a(z, this.deB.productDocEntity.amN());
    }
    
    private void anY() {
      z z = aV(this.deB.productDocEntity.amN());
      if (z == null) {
        n.eP(2131627154);
        return;
      } 
      if (z.aTv == 10001) {
        this.deB.isUserCashReturn = true;
      } else {
        this.deB.isUserCashReturn = false;
      } 
      if (OrderDetailsByReturn.e(this.deB)) {
        OrderDetailsByReturn.d(this.deB);
        this.deB.dez = true;
        return;
      } 
      if (!OrderDetailsByReturn.a(this.deB, z)) {
        this.deB.dez = true;
        this.deB.returnFull(z);
        return;
      } 
      gD(true);
      a(z, this.deB.productDocEntity.amN());
    }
    
    private boolean anZ() { return (this.deI == null); }
    
    private r aoa() {
      z z = aV(this.deB.productDocEntity.amN());
      if (this.deM == null) {
        this.deM = new r(this.deB, new af(this, z));
        this.deM.t(this.deB.getString(2131625069));
        this.deM.oZ(this.deB.getString(2131625067));
        this.deM.s(this.deB.getString(2131625066));
      } 
      return this.deM;
    }
    
    private void aob() {
      int j;
      ArrayList arrayList = new ArrayList();
      HashSet hashSet = new HashSet();
      Iterator iterator = this.deB.payTypeItemArrayList.iterator();
      int i = 0;
      while (true) {
        j = i;
        if (iterator.hasNext()) {
          l l1 = (l)iterator.next();
          long l = b(l1);
          boolean bool = a(l1);
          String str = jR(l1.aTv);
          j = i;
          if (l1.daH) {
            j = ++i;
            if (i >= 2) {
              j = i;
              if (bool) {
                arrayList.clear();
                j = i;
                break;
              } 
            } 
          } 
          i = j;
          if (l != -1L) {
            long l2;
            if (l1.aTv == 10013) {
              l2 = l;
            } else {
              l2 = l1.aTv;
            } 
            i = j;
            if (!hashSet.contains(Long.valueOf(l2))) {
              hashSet.add(Long.valueOf(l2));
              i = l1.aTv;
              if (str == null)
                str = l1.name; 
              arrayList.add(new z(i, 0.0D, str, l));
              i = j;
            } 
          } 
          continue;
        } 
        break;
      } 
      arrayList.add(0, new z('✑', 0.0D, this.deB.getString(2131628049), 0L));
      byte b = 0;
      for (i = 0; b < this.deE.getChildCount(); i = k) {
        int k;
        View view = this.deE.getChildAt(b);
        if (b < arrayList.size()) {
          z z = (z)arrayList.get(b);
          view.setVisibility(0);
          view.setTag(z);
          ((TextView)view.findViewById(2131298198)).setText(z.name);
          TextView textView = (TextView)view.findViewById(2131297257);
          textView.setText("");
          k = z.aTv;
          if (k != 10001) {
            if (k != 10013) {
              switch (k) {
                case 10011:
                  textView.setBackgroundResource(2131230865);
                  break;
                case 10010:
                  textView.setBackgroundResource(2131230880);
                  break;
                case 10009:
                  textView.setBackgroundResource(2131230893);
                  break;
                case 10008:
                  textView.setBackgroundResource(2131230863);
                  break;
                case 10007:
                  textView.setBackgroundResource(2131230855);
                  break;
                case 10006:
                  textView.setBackgroundResource(2131230876);
                  break;
              } 
            } else {
              String str;
              textView.setBackgroundResource(2131231523);
              textView.setTextColor(f.gb(i));
              if (z.name.isEmpty()) {
                str = " ";
              } else {
                str = String.valueOf(z.name.charAt(0));
              } 
              textView.setText(str);
              i++;
            } 
          } else {
            textView.setBackgroundResource(2131230860);
          } 
          k = i;
          if (this.deB.isMultiplePayTypes()) {
            k = i;
            if (OrderDetailsByReturn.a(this.deB, z)) {
              view.setVisibility(4);
              k = i;
            } 
          } 
        } else {
          view.setVisibility(4);
          k = i;
        } 
        b++;
      } 
      if (j == 1 && arrayList.size() == 2) {
        cz(this.deE.getChildAt(1));
        return;
      } 
      cz(this.deE.getChildAt(0));
    }
    
    private void aoc() {
      boolean bool;
      if (this.settlementRunnable != null)
        return; 
      if (this.deB.isUseOnlineMember()) {
        if (!bd.bH(this.deB)) {
          this.deB.noNetworkOnUseChainMember();
          return;
        } 
        if (this.deB.bpartnerDocEntity == null) {
          n.eP(2131628123);
          return;
        } 
      } 
      ArrayList arrayList = new ArrayList();
      a a1 = (new d()).a(new d.a()).akm();
      Iterator iterator = this.bbT.iterator();
      double d1 = 0.0D;
      while (true) {
        boolean bool1 = iterator.hasNext();
        bool = false;
        if (bool1) {
          o.a a2 = (o.a)iterator.next();
          if (a2.cTp != 100001)
            continue; 
          aa aa = new aa(a2, a1, true);
          if (!anZ()) {
            if (n.bc(a2.bTj))
              continue; 
            aa.q(a2.bTj);
          } else {
            double d2 = n.u(this.deG.getText());
            if (d2 == 0.0D) {
              n.eP(2131628136);
              return;
            } 
            aa.q(d2);
          } 
          aa.j(false, true);
          d1 += aa.GJ();
          aa.aTS = a2.aTS;
          arrayList.add(aa);
          continue;
        } 
        break;
      } 
      bb bb = new bb(false, arrayList, d1, 100.0D);
      bb.bcp = 2;
      bb.orderNo = this.deB.productDocEntity.orderNo;
      bb.vipEntity = this.deB.bpartnerDocEntity;
      bb.bbQ = this.deB.productDocEntity.coJ;
      bb.az(System.currentTimeMillis());
      bb.bcf = this.deB.productDocEntity.orderSource;
      bb.billNumber = this.deB.productDocEntity.billNumber;
      bb.bch = this.deB.productDocEntity.bch;
      bb.openTableName = this.deB.productDocEntity.openTableName;
      bb.Y(this.deB.productDocEntity.cpa);
      z z = aV(d1);
      if (z == null) {
        n.o("异常，没有选中支付方式");
        return;
      } 
      if (z.aTv == 10001)
        bool = true; 
      bb.bbS.add(z);
      bb.bbY = d1;
      if (this.settlementRunnable != null)
        return; 
      this.settlementRunnable = new di(this.deB, bb, bool, new ag(this));
      if (this.deB.isUseOnlineMember()) {
        executeSettlementOfChainMember();
        return;
      } 
      this.deB.showWaitingDialog(true);
      this.settlementRunnable.run();
    }
    
    private long b(l param1l) {
      int i = param1l.aTv;
      long l1 = 0L;
      if (i != 10001) {
        if (i != 10009) {
          if (i != 10013) {
            switch (i) {
              default:
                return 0L;
              case 10007:
                return param1l.aTx;
              case 10006:
                break;
            } 
          } else {
            return param1l.aTx;
          } 
        } else {
          return param1l.aTx;
        } 
      } else {
        l1 = -1L;
      } 
      return l1;
    }
    
    private void cV(View param1View) {
      ViewParent viewParent = param1View.getParent();
      if (viewParent != null)
        ((ViewGroup)viewParent).removeView(param1View); 
    }
    
    private void cz(View param1View) {
      for (byte b = 0; b < this.deE.getChildCount(); b++) {
        boolean bool;
        View view = this.deE.getChildAt(b);
        if (view == param1View) {
          bool = true;
        } else {
          bool = false;
        } 
        view.setSelected(bool);
      } 
    }
    
    private void executeSettlementOfChainMember() {
      this.deB.showWaitingDialog(true);
      a.aKh().r(this.settlementRunnable);
    }
    
    private String jR(int param1Int) { return (param1Int != 10007) ? ((param1Int != 10009) ? null : this.deB.getString(2131627237)) : this.deB.getString(2131627231); }
    
    public void a(o.a param1a) {
      this.bbT.clear();
      this.bbT.add(param1a);
      if (param1a.akN()) {
        ArrayList arrayList = this.deB.productDocEntity.daR;
        int i = arrayList.indexOf(param1a);
        while (true) {
          if (++i < arrayList.size()) {
            o.a a1 = (o.a)arrayList.get(i);
            if (a1.akO()) {
              this.bbT.add(a1);
              continue;
            } 
          } 
          break;
        } 
      } 
      this.deI = null;
      this.tvTitle.setText(param1a.name);
      if (this.deF.getParent() == null)
        this.deD.addView(this.deF, 0); 
      if (this.deD.getChildAt(this.deD.getChildCount() - true) != this.deJ) {
        if (this.deJ.getParent() != null)
          this.deD.removeView(this.deJ); 
        this.deD.addView(this.deJ);
      } 
      this.deG.setText(n.d(Double.valueOf(param1a.bTj)));
      n.j(this.deG);
      aob();
      show();
    }
    
    public void a(o param1o) {
      this.deI = param1o;
      this.bbT.clear();
      this.bbT.addAll(param1o.daR);
      this.tvTitle.setText(2131628120);
      if (!OrderDetailsByReturn.e(this.deB)) {
        this.deh.setText(n.d(Double.valueOf(param1o.amN())));
        if (this.deF.getParent() != null)
          this.deD.removeView(this.deF); 
        if (this.deD.getChildAt(false) != this.deJ) {
          if (this.deJ.getParent() != null)
            this.deD.removeView(this.deJ); 
          this.deD.addView(this.deJ, 0);
        } 
        ViewGroup viewGroup = (ViewGroup)this.deF.getParent();
        if (viewGroup != null)
          viewGroup.removeView(this.deF); 
        aob();
      } 
      show();
    }
    
    public void cancel() {
      super.cancel();
      this.settlementRunnable = null;
    }
    
    public boolean dispatchKeyEvent(KeyEvent param1KeyEvent) { return (param1KeyEvent.getKeyCode() == 4 && this.deN) ? true : super.dispatchKeyEvent(param1KeyEvent); }
    
    protected void gD(boolean param1Boolean) {
      if (param1Boolean) {
        this.deL.setClickable(false);
        this.aNv.setVisibility(0);
        this.deK.setVisibility(8);
        this.deN = true;
        return;
      } 
      this.deL.setClickable(true);
      this.aNv.setVisibility(8);
      this.deK.setVisibility(0);
      this.deN = false;
    }
    
    public void show() {
      super.show();
      this.deB.showWaitingDialog(false);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\OrderDetailsByReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */