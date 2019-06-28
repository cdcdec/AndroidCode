package com.laiqian.takeaway;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.aa;
import com.laiqian.entity.ao;
import com.laiqian.entity.ap;
import com.laiqian.entity.v;
import com.laiqian.entity.x;
import com.laiqian.pos.bm;
import com.laiqian.pos.model.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.k;
import com.laiqian.util.av;
import com.laiqian.util.bt;
import com.laiqian.util.by;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class y extends BaseAdapter {
  boolean aWg = false;
  
  private boolean bBoss;
  
  private SimpleDateFormat cJp;
  
  private x drA;
  
  private al.b drE;
  
  private ActivityRoot drT;
  
  private TakeOrderEntity drU;
  
  private SimpleDateFormat drV;
  
  private SimpleDateFormat drW;
  
  private am drX;
  
  private a drY;
  
  private ArrayList<ap> drZ;
  
  private String drp;
  
  private String[] dsa;
  
  boolean dsb = false;
  
  private List<TakeOrderEntity> list = new ArrayList();
  
  private Handler mHandler;
  
  private ListView wV;
  
  public y(ActivityRoot paramActivityRoot, List<TakeOrderEntity> paramList, al.b paramb, ListView paramListView, Handler paramHandler, x paramx) {
    this.drT = paramActivityRoot;
    this.list = paramList;
    this.drE = paramb;
    this.wV = paramListView;
    this.mHandler = paramHandler;
    this.drA = paramx;
    this.drX = new am(paramActivityRoot);
    this.cJp = new SimpleDateFormat(paramActivityRoot.getString(R.string.pos_pos_SimpleDateFormatHHMMSS));
    this.drV = new SimpleDateFormat(paramActivityRoot.getString(R.string.pos_pos_SimpleDateFormatDM));
    this.drW = new SimpleDateFormat(paramActivityRoot.getString(R.string.pos_pos_SimpleDateFormatHHMM));
    this.drY = new a(paramActivityRoot);
    av av = new av(paramActivityRoot);
    String str = av.Tx();
    av.close();
    this.bBoss = "150001".equals(av.atp());
    this.drZ = this.drY.ko(str);
    this.drY.close();
    this.dsa = new String[] { paramActivityRoot.getResources().getString(R.string.consensus), paramActivityRoot.getResources().getString(R.string.beyond_address), paramActivityRoot.getResources().getString(R.string.address_is_not_complete), paramActivityRoot.getResources().getString(R.string.too_many_orders), paramActivityRoot.getResources().getString(R.string.has_been_sold_out) };
  }
  
  private void A(a parama) { parama.dsw.setText(this.drU.getAddress()); }
  
  private void B(a parama) {
    double d = aqt();
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TakeOrderAdapter.getView.getOrderAmount() is:");
    stringBuilder.append(d);
    stringBuilder.append(". 已经减去了折扣的金额.");
    printStream.println(stringBuilder.toString());
    parama.dsr.setText(String.format("%s", new Object[] { n.a(Double.valueOf(d), true, false) }));
  }
  
  private void C(a parama) {
    String str = this.drU.Iu();
    str = this.drX.aY(str, this.drU.getType());
    parama.dss.setText(str);
  }
  
  private long D(a parama) {
    long l = this.drU.getTimestamp();
    parama.dsp.setText(this.drU.In());
    parama.dsq.setText(this.drU.getNumber());
    TextView textView = parama.dsr;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" ");
    stringBuilder.append(n.a(Double.valueOf(this.drU.Iv()), true, false));
    textView.setText(stringBuilder.toString());
    return l * 1000L;
  }
  
  private void E(a parama) {
    String str = this.drU.Is();
    String[] arrayOfString = this.drX.oE(str);
    parama.dso.setText(arrayOfString[0]);
    parama.dso.setBackgroundResource(Integer.parseInt(arrayOfString[1]));
    parama.dso.setTextColor(this.drT.getResources().getColor(Integer.parseInt(arrayOfString[2])));
  }
  
  private void F(a parama) {
    String str = this.drU.getType();
    String[] arrayOfString = this.drX.s(str, this.drU.IF());
    TextView textView = parama.dsm;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(arrayOfString[0]);
    stringBuilder.append(" #");
    stringBuilder.append(this.drU.getSerialNumber());
    textView.setText(stringBuilder.toString());
    parama.dsm.setTextColor(this.drT.getResources().getColor(Integer.parseInt(arrayOfString[1])));
    parama.dsn.setText(this.drU.Ip());
  }
  
  private void G(a parama) {
    parama.dso.setText(R.string.takeout_delivered);
    parama.dso.setBackgroundResource(R.drawable.dotted_line_blue);
    parama.dso.setTextColor(this.drT.getResources().getColor(R.color.text_color_text_blue));
    parama.dsC.setText(this.drU.IG());
    parama.dsG.setText(this.drT.getString(R.string.pos_takeout_finish));
    parama.dsB.setVisibility(0);
  }
  
  @NonNull
  private View.OnClickListener a(int paramInt, TakeOrderEntity paramTakeOrderEntity, String paramString) { return new ad(this, paramTakeOrderEntity, paramString, paramInt); }
  
  @NonNull
  private View.OnClickListener a(TakeOrderEntity paramTakeOrderEntity, String paramString1, String paramString2) { return new af(this, paramString1, paramString2, paramTakeOrderEntity); }
  
  private void a(View paramView, TakeOrderEntity paramTakeOrderEntity) {
    ArrayList arrayList = this.drX.aE(this.drZ);
    ActivityRoot activityRoot = this.drT;
    int j = arrayList.size();
    int i = 5;
    if (j <= 5)
      i = arrayList.size(); 
    k k = new k(activityRoot, '', i * 43);
    k.aF(arrayList);
    k.setOnItemClickListener(new aj(this, paramTakeOrderEntity, k, arrayList));
    k.do(paramView);
  }
  
  private void a(a parama) {
    if (!a.zR().Ab()) {
      parama.dtg.setVisibility(8);
      return;
    } 
    if (this.drU.IM() > 0L || this.drU.IM() == 10001L) {
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("TakeOrderAdapter.getView. second Pay Type is: ");
      stringBuilder.append(this.drU.IM());
      stringBuilder.append(",second Pay Value is:");
      stringBuilder.append(this.drU.IN());
      printStream.println(stringBuilder.toString());
      parama.dtg.setVisibility(0);
      parama.dth.setText(v.ao(this.drU.IM()));
      parama.dti.setText(String.format("%s", new Object[] { n.a(this.drU.aVV, true, false) }));
      return;
    } 
    parama.dtg.setVisibility(8);
  }
  
  private void a(a parama, String paramString) {
    if (this.drU.getType().equals("weixin_eat_in") || this.drU.getType().equals("koubei")) {
      parama.dsz.setVisibility(8);
      return;
    } 
    parama.dsA.setText(paramString);
    parama.dsz.setVisibility(0);
  }
  
  private double aqt() { return this.drU.Iv(); }
  
  private boolean aqu() { return this.drU.Is().equals("delivery"); }
  
  private boolean aqv() { return this.drU.Is().equals("successed"); }
  
  private boolean aqw() { return this.drU.Iu().equals("'JSAPI'"); }
  
  private boolean aqx() { return this.drU.getType().equals("phone_order"); }
  
  @NonNull
  private View.OnClickListener b(TakeOrderEntity paramTakeOrderEntity) { return new ac(this, paramTakeOrderEntity); }
  
  private void b(a parama) {
    if (!a.zR().Ab()) {
      parama.dtd.setVisibility(8);
      return;
    } 
    if (this.drU.IK() > 0L || this.drU.IK() == 10001L) {
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("TakeOrderAdapter.getView.first PayType is: ");
      stringBuilder.append(this.drU.IK());
      stringBuilder.append(",first Pay Value is:");
      stringBuilder.append(this.drU.IL());
      printStream.println(stringBuilder.toString());
      parama.dtd.setVisibility(0);
      parama.dte.setText(v.ao(this.drU.IK()));
      parama.dtf.setText(String.format("%s", new Object[] { n.a(Double.valueOf(this.drU.IL()), true, false) }));
      return;
    } 
    parama.dtd.setVisibility(8);
  }
  
  @NonNull
  private View.OnClickListener c(TakeOrderEntity paramTakeOrderEntity) { return new ae(this, paramTakeOrderEntity); }
  
  private void c(a parama) {
    if (!a.zR().Ab()) {
      parama.dtd.setVisibility(8);
      return;
    } 
    if (this.drU.IK() != 10001L && this.drU.IM() != 10001L) {
      System.out.println("TakeOrderAdapter.getView.Cash Pay Items shows. ");
      parama.dtj.setVisibility(0);
      parama.dtl.setText(v.ao(10001L));
      parama.dtm.setText("0");
      return;
    } 
    System.out.println("TakeOrderAdapter.getView.Cash Pay Items hide. ");
    parama.dtj.setVisibility(8);
  }
  
  private void d(TakeOrderEntity paramTakeOrderEntity) {
    paramTakeOrderEntity.IE();
    try {
      System.out.println("order with delivery name is :");
      a.aKh().r(new z(this, paramTakeOrderEntity));
      return;
    } catch (Exception paramTakeOrderEntity) {
      a.e(paramTakeOrderEntity);
      return;
    } 
  }
  
  private void d(a parama) { parama.dsJ.setVisibility(8); }
  
  private String dm(long paramLong) {
    Object object1;
    long l = System.currentTimeMillis();
    try {
      long l1 = this.cJp.parse(this.drU.In()).getTime();
    } catch (ParseException null) {
      a.e(object1);
      long l1 = 0L;
    } 
    ParseException parseException2 = null;
    try {
      object1 = this.cJp.parse(this.drU.Iq());
      try {
        parseException1 = this.cJp.parse(this.drU.Ir());
        Date date = object1;
      } catch (ParseException null) {}
    } catch (ParseException parseException1) {
      object1 = null;
    } 
    a.e(parseException1);
    Object object2 = object1;
    parseException1 = parseException2;
  }
  
  private void e(TakeOrderEntity paramTakeOrderEntity) {
    Message message = new Message();
    message.obj = Double.valueOf(paramTakeOrderEntity.AO());
    message.what = 8;
    this.mHandler.sendMessage(message);
  }
  
  private void e(a parama) { parama.dsG.setVisibility(0); }
  
  private void f(a parama) {
    String[] arrayOfString = this.drX.oF(this.drU.getType());
    parama.dst.setText(arrayOfString[0]);
  }
  
  private void g(a parama) {
    if (by.isNull(this.drU.getNote())) {
      parama.dsX.setVisibility(8);
      return;
    } 
    parama.dsY.setText(this.drU.getNote());
    parama.dsX.setVisibility(0);
  }
  
  private void h(a parama) { parama.dsI.setVisibility(8); }
  
  private void i(a parama) {
    if (!by.isNull(this.drU.IC())) {
      parama.dsW.setText(this.drU.IC());
      return;
    } 
    parama.dsW.setText("");
  }
  
  private void j(a parama) { parama.dsF.setVisibility(8); }
  
  private void k(a parama) {
    byte b1;
    TextView textView = parama.dsE;
    if (this.drU.Iu().equals("JSAPI")) {
      b1 = 8;
    } else {
      b1 = 0;
    } 
    textView.setVisibility(b1);
  }
  
  private void l(a parama) { parama.dsD.setVisibility(0); }
  
  private void m(a parama) { parama.dsI.setVisibility(0); }
  
  private void n(a parama) { parama.dsE.setVisibility(8); }
  
  private void o(a parama) { parama.dsD.setVisibility(8); }
  
  private void oA(String paramString) {
    a a1 = new a(this.drT);
    a1.kj(paramString);
    a1.close();
    this.drE.ku(0);
  }
  
  private void p(a parama) {
    if ((this.drU.Is().equals("delivered") && !this.drU.Iu().equals("JSAPI")) || (this.drU.Is().equals("delivered") && (this.drU.Iu().equals("koubei") || this.drU.Iu().equals("KOUBEI")))) {
      parama.dsF.setVisibility(0);
      return;
    } 
    parama.dsF.setVisibility(8);
  }
  
  private void q(a parama) {
    if (!this.drT.getResources().getString(R.string.version_name).equals("lqk") && !by.isNull(this.drU.II())) {
      parama.dsV.setVisibility(0);
      parama.dsU.setText(this.drU.II());
      return;
    } 
    parama.dsV.setVisibility(8);
  }
  
  private void r(a parama) {
    ArrayList arrayList = this.drU.bbT;
    parama.dsK.removeAllViews();
    for (aa aa : arrayList) {
      if (aa instanceof ao) {
        bt.a a1 = (ao)aa;
        View view = View.inflate(this.drT, R.layout.takeout_product_item, null);
        if (a1.bTj <= 0.0D) {
          ((TextView)view.findViewById(R.id.ll_takeout_product_price)).setText(R.string.pos_retreat_food);
        } else {
          String str = n.a(Double.valueOf(a1.akI() * Math.abs(a1.bTj)), true, false);
          ((TextView)view.findViewById(R.id.ll_takeout_product_price)).setText(str);
        } 
        ((TextView)view.findViewById(R.id.ll_takeout_product_qty)).setText(String.format("x%s", new Object[] { Double.valueOf(Math.abs(a1.bTj)) }));
        Spanned spanned = a1.IQ();
        if (!TextUtils.isEmpty(spanned)) {
          view.findViewById(R.id.ll_takeorder_mealset_product).setVisibility(0);
          ((TextView)view.findViewById(R.id.takeorder_mealset_product)).setText(spanned);
        } else {
          view.findViewById(R.id.ll_takeorder_mealset_product).setVisibility(8);
        } 
        if (by.isNull(a1.IT())) {
          spanned = a1.name;
        } else {
          spanned = String.format("%s(%s)", new Object[] { a1.name, a1.IT() });
        } 
        if (by.isNull(a1.IS())) {
          a1 = bt.a.mj(this.drT.getResources().getColor(R.color.text_main_black));
          spanned = bt.a("%s", new String[] { spanned }, new bt.a[] { a1 });
        } else {
          String str = a1.IS();
          bt.a a2;
          bt.a a3 = (a2 = bt.a.mj(this.drT.getResources().getColor(R.color.text_main_black))).mj(this.drT.getResources().getColor(R.color.red_color_10500));
          spanned = bt.a("%s%s", new String[] { spanned, str }, new bt.a[] { a2, a3 });
        } 
        ((TextView)view.findViewById(R.id.ll_takeout_product_name)).setText(spanned);
        parama.dsK.addView(view);
      } 
    } 
  }
  
  private void r(String paramString, long paramLong) {
    a a1 = new a(this.drT);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    a1.ay(stringBuilder.toString(), paramString);
    a1.close();
  }
  
  @NonNull
  private View.OnClickListener s(int paramInt, String paramString) { return new ah(this, paramInt, paramString); }
  
  private void s(a parama) {
    if (this.drT.getResources().getString(R.string.version_name).equals("cashcow") && by.parseDouble(this.drU.IJ()) != 0.0D) {
      parama.dsZ.setVisibility(0);
      parama.dta.setText(this.drU.IJ());
      return;
    } 
    parama.dsZ.setVisibility(8);
  }
  
  private void t(a parama) {
    TextView textView;
    double d = this.drU.IB();
    if (d > 0.0D) {
      parama.dsS.setVisibility(0);
      textView = parama.dsT;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(d);
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
      return;
    } 
    textView.dsS.setVisibility(8);
  }
  
  private void u(a parama) {
    TextView textView;
    double d = this.drU.IA();
    if (d > 0.0D) {
      parama.dsQ.setVisibility(0);
      textView = parama.dsR;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(d);
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
      return;
    } 
    textView.dsQ.setVisibility(8);
  }
  
  private void v(a parama) {
    double d = this.drU.Iw();
    if (d > 0.0D) {
      parama.dsO.setVisibility(0);
      parama.dsP.setText(String.format("-%s", new Object[] { bm.c(d, RootApplication.aIQ) }));
      return;
    } 
    parama.dsO.setVisibility(8);
  }
  
  private void w(a parama) {
    ArrayList arrayList1 = am.oG(this.drU.Iy());
    ArrayList arrayList2 = am.oI(this.drU.Iz());
    try {
      if (arrayList1.size() == arrayList2.size() && arrayList1.size() > 0) {
        LinearLayout linearLayout = parama.dsN;
        byte b1 = 0;
        linearLayout.setVisibility(0);
        parama.dsN.removeAllViews();
        while (true) {
          if (b1 < arrayList1.size()) {
            View view = View.inflate(this.drT, R.layout.takeout_full_cut_item, null);
            String str = (TextView)view.findViewById(R.id.tv_takeout_full_cut_message);
            TextView textView = (TextView)view.findViewById(R.id.tv_takeout_full_cut);
            str.setText((CharSequence)arrayList2.get(b1));
            double d = by.parseDouble((String)arrayList1.get(b1));
            StringBuilder stringBuilder = new StringBuilder();
            if (d == 0.0D) {
              String str1 = "";
            } else {
              str = "-";
            } 
            stringBuilder.append(str);
            stringBuilder.append(d);
            textView.setText(stringBuilder.toString());
            parama.dsN.addView(view);
            b1++;
            continue;
          } 
          return;
        } 
      } 
      parama.dsN.setVisibility(8);
      return;
    } catch (Exception exception) {
      parama.dsN.setVisibility(8);
      a.e(exception);
    } 
  }
  
  private void x(a parama) {
    String str = this.drU.ID();
    if (by.parseDouble(str) > 0.0D) {
      parama.dsL.setVisibility(0);
      parama.dsM.setText(n.a(str, true, false));
      return;
    } 
    parama.dsL.setVisibility(8);
  }
  
  private void y(a parama) {
    TextView textView;
    if (this.drU.getType().equals("weixin") || aqx() || this.drU.getType().equals("meituan")) {
      textView = parama.dsx;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.drU.getName());
      stringBuilder.append(" ");
      stringBuilder.append(this.drU.Im());
      textView.setText(stringBuilder.toString());
      return;
    } 
    textView.dsx.setText(this.drU.Im());
    if (TextUtils.isEmpty(this.drU.Im())) {
      textView.dsx.setText(R.string.person_info_null);
      return;
    } 
  }
  
  private void z(a parama) {
    TextView textView;
    if (this.drU.getType().equals("weixin") || this.drU.getType().equals("koubei") || this.drU.getType().equals("weixin_eat_in")) {
      if (this.drU.IO() != 0L) {
        if ((this.drU.getVipEntity()).aSW > 0L) {
          parama.dsy.setVisibility(0);
          textView = parama.dsy;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.drT.getString(R.string.takeaway_vip_label));
          stringBuilder.append((this.drU.getVipEntity()).aTp);
          textView.setText(stringBuilder.toString());
          return;
        } 
        textView.dsy.setVisibility(8);
        return;
      } 
      textView.dsy.setVisibility(8);
      return;
    } 
    textView.dsy.setVisibility(8);
  }
  
  public void T(List<TakeOrderEntity> paramList) {
    this.list = paramList;
    notifyDataSetChanged();
  }
  
  public void U(List<TakeOrderEntity> paramList) {
    this.list.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public TakeOrderEntity a(TakeOrderEntity paramTakeOrderEntity) { // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: aload_0
    //   4: getfield list : Ljava/util/List;
    //   7: invokeinterface size : ()I
    //   12: if_icmpge -> 53
    //   15: aload_0
    //   16: getfield list : Ljava/util/List;
    //   19: iload_2
    //   20: invokeinterface get : (I)Ljava/lang/Object;
    //   25: checkcast com/laiqian/entity/TakeOrderEntity
    //   28: astore_3
    //   29: aload_1
    //   30: invokevirtual getId : ()Ljava/lang/String;
    //   33: aload_3
    //   34: invokevirtual getId : ()Ljava/lang/String;
    //   37: invokevirtual equals : (Ljava/lang/Object;)Z
    //   40: ifeq -> 46
    //   43: goto -> 55
    //   46: iload_2
    //   47: iconst_1
    //   48: iadd
    //   49: istore_2
    //   50: goto -> 2
    //   53: iconst_m1
    //   54: istore_2
    //   55: aload_0
    //   56: getfield list : Ljava/util/List;
    //   59: iload_2
    //   60: invokeinterface get : (I)Ljava/lang/Object;
    //   65: checkcast com/laiqian/entity/TakeOrderEntity
    //   68: areturn }
  
  public void aaQ() {
    this.list.clear();
    notifyDataSetChanged();
  }
  
  public int getCount() { return this.list.size(); }
  
  public long getItemId(int paramInt) { return paramInt; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    a a2;
    a a1;
    if (paramView == null) {
      a2 = View.inflate(this.drT, R.layout.takeout_item, null);
      a1 = new a(this, null);
      a1.dsm = (TextView)a2.findViewById(R.id.tv_takeout_label);
      a1.dsn = (TextView)a2.findViewById(R.id.tv_takeout_shop_name);
      a1.dso = (TextView)a2.findViewById(R.id.tv_takeout_order_state);
      a1.dsp = (TextView)a2.findViewById(R.id.tv_takeout_order_time);
      a1.dsq = (TextView)a2.findViewById(R.id.tv_takeout_order_number);
      a1.dsr = (TextView)a2.findViewById(R.id.tv_takeout_order_amount);
      a1.dss = (TextView)a2.findViewById(R.id.tv_takeout_order_payment);
      a1.dsw = (TextView)a2.findViewById(R.id.tv_takeout_distribution_address);
      a1.dsx = (TextView)a2.findViewById(R.id.tv_takeout_customer_information);
      a1.dsy = (TextView)a2.findViewById(R.id.tv_vip_information);
      a1.dsA = (TextView)a2.findViewById(R.id.tv_takeout_required_time);
      a1.dst = (TextView)a2.findViewById(R.id.tv_takeout_distribution_address_title);
      a1.dsu = (TextView)a2.findViewById(R.id.tv_takeout_customer_information_title);
      a1.dsz = a2.findViewById(R.id.ll_required_time);
      a1.dsv = (TextView)a2.findViewById(R.id.tv_takeout_required_time_title);
      a1.dsD = (TextView)a2.findViewById(R.id.tv_takeout_receive);
      a1.dsE = (TextView)a2.findViewById(R.id.tv_takeout_refuse);
      a1.dsF = (TextView)a2.findViewById(R.id.tv_takeout_return);
      a1.dsG = (TextView)a2.findViewById(R.id.tv_phone_takeout_receive);
      a1.dsH = (TextView)a2.findViewById(R.id.tv_takeout_order_amount_sum);
      a1.dsI = (TextView)a2.findViewById(R.id.tv_takeout_order_print);
      a1.dsJ = (TextView)a2.findViewById(R.id.tv_takeout_order_edit);
      a1.dsK = (LinearLayout)a2.findViewById(R.id.ll_takeout_product);
      a1.dsL = a2.findViewById(R.id.ll_takeout_tax);
      a1.dsM = (TextView)a2.findViewById(R.id.tv_takeout_tax);
      a1.dsN = (LinearLayout)a2.findViewById(R.id.ll_takeout_full_cut);
      a1.dsO = a2.findViewById(R.id.ll_takeout_discount);
      a1.dsP = (TextView)a2.findViewById(R.id.tv_takeout_discount);
      a1.dsQ = a2.findViewById(R.id.ll_takeout_dishware);
      a1.dsR = (TextView)a2.findViewById(R.id.tv_takeout_dishware);
      a1.dsS = a2.findViewById(R.id.ll_takeout_deliver);
      a1.dsT = (TextView)a2.findViewById(R.id.tv_takeout_deliver);
      a1.dsB = a2.findViewById(R.id.ll_takeout_distribution_clerk);
      a1.dsC = (TextView)a2.findViewById(R.id.tv_takeout_distribution_clerk);
      a1.dsU = (TextView)a2.findViewById(R.id.tv_takeout_bill_number);
      a1.dsV = a2.findViewById(R.id.ll_bill_number);
      a1.dsW = (TextView)a2.findViewById(R.id.tv_takeout_sellout);
      a1.dsX = a2.findViewById(R.id.ll_special_requirements);
      a1.dsZ = a2.findViewById(R.id.ll_rounding);
      a1.dsY = (TextView)a2.findViewById(R.id.tv_takeout_special_requirements);
      a1.dta = (TextView)a2.findViewById(R.id.tv_takeout_rounding);
      a1.dtb = (LinearLayout)a2.findViewById(R.id.ll_total_amount);
      a1.dtc = (TextView)a2.findViewById(R.id.tv_takeout_total_amount);
      a1.dtd = (LinearLayout)a2.findViewById(R.id.ll_takeout_first_pay);
      a1.dte = (TextView)a2.findViewById(R.id.tv_takeout_first_pay_title);
      a1.dtf = (TextView)a2.findViewById(R.id.tv_takeout_first_pay_value);
      a1.dtg = (LinearLayout)a2.findViewById(R.id.ll_second_pay);
      a1.dth = (TextView)a2.findViewById(R.id.tv_takeout_second_pay_title);
      a1.dti = (TextView)a2.findViewById(R.id.tv_takeout_second_pay_value);
      a1.dtj = (LinearLayout)a2.findViewById(R.id.ll_cash_pay_bottom_layout);
      a1.dtl = (TextView)a2.findViewById(R.id.tv_takeout_cash_pay_title);
      a1.dtm = (TextView)a2.findViewById(R.id.tv_takeout_cash_pay_value);
      a1.dtd.setVisibility(8);
      a1.dtg.setVisibility(8);
      a1.dtj.setVisibility(8);
      a2.setTag(a1);
    } else {
      a a3 = (a)a1.getTag();
      a2 = a1;
      a1 = a3;
    } 
    null = System.out;
    null = new StringBuilder();
    null.append("TakeOrderAdapter.getview.. Current Position is:");
    null.append(paramInt);
    null.append(".");
    null.println(null.toString());
    this.drU = kv(paramInt);
    F(a1);
    E(a1);
    long l = D(a1);
    B(a1);
    C(a1);
    q(a1);
    A(a1);
    y(a1);
    z(a1);
    a(a1, dm(l));
    g(a1);
    x(a1);
    w(a1);
    v(a1);
    u(a1);
    t(a1);
    s(a1);
    r(a1);
    this.aWg = false;
    if (this.drp.equals("all")) {
      this.aWg = true;
      o(a1);
      n(a1);
      m(a1);
      p(a1);
    } else if (this.drp.equals("pending")) {
      l(a1);
      k(a1);
      m(a1);
      j(a1);
      i(a1);
    } else if (this.drp.equals("refund")) {
      l(a1);
      k(a1);
      h(a1);
      j(a1);
      i(a1);
    } 
    TakeOrderEntity takeOrderEntity = this.drU;
    String str1 = this.drU.getId();
    String str2 = this.drU.getType();
    f(a1);
    a1.dsF.setOnClickListener(new b(this, str1, str2, "wxrefund", takeOrderEntity));
    String str3 = this.drU.getNumber();
    if (this.drU.Is().equals("refunding")) {
      a1.dsE.setOnClickListener(new b(this, str1, str2, "reject", takeOrderEntity));
      a1.dsD.setOnClickListener(new b(this, str1, str2, "agree", takeOrderEntity));
      a1.dsD.setText(this.drT.getString(R.string.takeout_agree));
    } else {
      a1.dsD.setText(this.drT.getString(R.string.takeout_receiver));
      a1.dsD.setOnClickListener(new b(this, str1, str2, "confirm", takeOrderEntity));
      if (aqx()) {
        a1.dsE.setOnClickListener(s(paramInt, str3));
      } else {
        a1.dsE.setOnClickListener(a(takeOrderEntity, str1, str2));
      } 
    } 
    if (aqx() && !aqu() && !aqv() && !aqw()) {
      e(a1);
      if (this.drU.IF() == 0L) {
        if (by.isNull(this.drU.IG())) {
          a1.dsJ.setVisibility(0);
          a1.dsB.setVisibility(8);
          a1.dsG.setText(this.drT.getString(R.string.telephone_delievery));
          a1.dsG.setOnClickListener(c(kv(paramInt)));
        } else {
          a1.dsJ.setVisibility(8);
          a1.dsG.setOnClickListener(new aa(this, str3, paramInt));
          G(a1);
        } 
      } else {
        a1.dsG.setOnClickListener(a(paramInt, takeOrderEntity, str3));
        a1.dsB.setVisibility(8);
        a1.dsG.setText(this.drT.getString(R.string.pos_takeout_finish));
      } 
      o(a1);
    } else if (aqx()) {
      a1.dsG.setVisibility(8);
      o(a1);
    } else {
      a1.dsG.setVisibility(8);
    } 
    a1.dsI.setOnClickListener(new ab(this, paramInt));
    if (aqx()) {
      a1.dsJ.setOnClickListener(b((TakeOrderEntity)this.list.get(paramInt)));
    } else {
      d(a1);
    } 
    a1.dtc.setText(String.format("%s", new Object[] { n.a(Double.valueOf(aqt()), true, false) }));
    b(a1);
    a(a1);
    c(a1);
    return a2;
  }
  
  public void ha(boolean paramBoolean) { this.dsb = paramBoolean; }
  
  public TakeOrderEntity kv(int paramInt) { return (TakeOrderEntity)this.list.get(paramInt); }
  
  public void oz(String paramString) { this.drp = paramString; }
  
  private class a {
    TextView dsA;
    
    View dsB;
    
    TextView dsC;
    
    TextView dsD;
    
    TextView dsE;
    
    TextView dsF;
    
    TextView dsG;
    
    TextView dsH;
    
    TextView dsI;
    
    TextView dsJ;
    
    LinearLayout dsK;
    
    View dsL;
    
    TextView dsM;
    
    LinearLayout dsN;
    
    View dsO;
    
    TextView dsP;
    
    View dsQ;
    
    TextView dsR;
    
    View dsS;
    
    TextView dsT;
    
    TextView dsU;
    
    View dsV;
    
    TextView dsW;
    
    View dsX;
    
    TextView dsY;
    
    View dsZ;
    
    TextView dsm;
    
    TextView dsn;
    
    TextView dso;
    
    TextView dsp;
    
    TextView dsq;
    
    TextView dsr;
    
    TextView dss;
    
    TextView dst;
    
    TextView dsu;
    
    TextView dsv;
    
    TextView dsw;
    
    TextView dsx;
    
    TextView dsy;
    
    View dsz;
    
    TextView dta;
    
    LinearLayout dtb;
    
    TextView dtc;
    
    LinearLayout dtd;
    
    TextView dte;
    
    TextView dtf;
    
    LinearLayout dtg;
    
    TextView dth;
    
    TextView dti;
    
    LinearLayout dtj;
    
    TextView dtl;
    
    TextView dtm;
    
    private a(y this$0) {}
  }
  
  public class b implements View.OnClickListener {
    private String aEO;
    
    private String id;
    
    private String method;
    
    private TakeOrderEntity takeOrderEntity;
    
    public b(y this$0, String param1String1, String param1String2, String param1String3, TakeOrderEntity param1TakeOrderEntity) {
      this.id = param1String1;
      this.aEO = param1String2;
      this.method = param1String3;
      this.takeOrderEntity = param1TakeOrderEntity;
    }
    
    public void onClick(View param1View) {
      if (this.dsf.dsb) {
        Toast.makeText(y.b(this.dsf), y.b(this.dsf).getString(R.string.handler_task), 0).show();
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onClick ............");
      stringBuilder.append(this.dsf.dsb);
      Log.i("TAG", stringBuilder.toString());
      this.dsf.dsb = true;
      y.c(this.dsf).b(this.id, this.aEO, this.method, this.takeOrderEntity, null);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */