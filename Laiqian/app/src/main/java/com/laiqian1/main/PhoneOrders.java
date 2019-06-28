package com.laiqian.main;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.aa;
import com.laiqian.entity.ao;
import com.laiqian.entity.aq;
import com.laiqian.entity.c;
import com.laiqian.entity.z;
import com.laiqian.member.report.MemberChargeDetailRecord;
import com.laiqian.models.l;
import com.laiqian.opentable.common.b;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.industry.b;
import com.laiqian.pos.model.a;
import com.laiqian.product.a.a;
import com.laiqian.product.a.d;
import com.laiqian.product.models.a;
import com.laiqian.product.models.h;
import com.laiqian.product.models.p;
import com.laiqian.takeaway.v;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class PhoneOrders {
  public static final int SCAN_ORDER_COMMIT_TYPE = 2;
  
  private int actualPerson = 0;
  
  private a attributeRuleSetting;
  
  private int belongID = 0;
  
  private String billNumber;
  
  private int commitType;
  
  private double deliverAmount;
  
  private double deliverBaseAmount;
  
  private String deliverTaxName;
  
  private double discount;
  
  private double discountAmount;
  
  private String discountMessage;
  
  private double dishwareAmount;
  
  public double dishwareBaseAmount;
  
  public String dishwareTaxName;
  
  private String headerText;
  
  public boolean isSaleOrder;
  
  private int is_takeaway;
  
  private ActivityRoot mActivity;
  
  private v mCallBack;
  
  private Context mContext;
  
  private PendingFullOrderDetail order;
  
  private long orderDateTime;
  
  private String orderNo;
  
  private ArrayList<z> payTypeItems;
  
  private List<aa> productData;
  
  private double recevied;
  
  private String sRefNo;
  
  private double serviceChargeAmount;
  
  private String serviceTaxName;
  
  di settlementRunnable;
  
  private long tableID = 0L;
  
  public TakeOrderEntity takeOrderEntity;
  
  private HashMap<Long, p> taxOfSettement;
  
  private double totalAmount = -1.0D;
  
  public PhoneOrders(Context paramContext, TakeOrderEntity paramTakeOrderEntity, int paramInt, ArrayList<z> paramArrayList, boolean paramBoolean, String paramString, v paramv) {
    this.mContext = paramContext;
    this.mCallBack = paramv;
    if (!TextUtils.isEmpty(paramTakeOrderEntity.xq())) {
      str = paramTakeOrderEntity.xq();
    } else {
      str = PosActivitySettlementModel.a(true, new Date());
    } 
    this.orderNo = str;
    this.commitType = paramInt;
    this.payTypeItems = paramArrayList;
    this.isSaleOrder = paramBoolean;
    this.headerText = paramString;
    this.sRefNo = paramTakeOrderEntity.getId();
    this.takeOrderEntity = paramTakeOrderEntity;
    this.productData = new ArrayList(paramTakeOrderEntity.bbT);
    putMeal2List(this.productData);
    this.deliverAmount = paramTakeOrderEntity.IB();
    this.dishwareAmount = paramTakeOrderEntity.IA();
    this.serviceChargeAmount = paramTakeOrderEntity.aVC;
    this.dishwareBaseAmount = paramTakeOrderEntity.dishwareBaseAmount;
    this.deliverBaseAmount = paramTakeOrderEntity.deliverBaseAmount;
    this.dishwareTaxName = paramTakeOrderEntity.dishwareTaxName;
    this.deliverTaxName = paramTakeOrderEntity.deliverTaxName;
    this.serviceTaxName = paramTakeOrderEntity.serviceTaxName;
    this.billNumber = paramTakeOrderEntity.II();
    this.discountMessage = paramTakeOrderEntity.Iz();
    this.discountAmount = by.parseDouble(paramTakeOrderEntity.Iy());
    this.taxOfSettement = paramTakeOrderEntity.Lz();
    this.discount = (paramTakeOrderEntity.aVz - paramTakeOrderEntity.Iw() - by.parseDouble(paramTakeOrderEntity.Iy())) / paramTakeOrderEntity.aVz * 100.0D;
  }
  
  public PhoneOrders(Context paramContext, PendingFullOrderDetail paramPendingFullOrderDetail, int paramInt, ArrayList<z> paramArrayList, v paramv) {
    this.mContext = paramContext;
    this.mCallBack = paramv;
    if (paramInt == 2) {
      this.orderNo = paramPendingFullOrderDetail.bXb.orderNo;
    } else {
      this.orderNo = PosActivitySettlementModel.a(true, new Date());
    } 
    this.recevied = 0.0D;
    this.order = paramPendingFullOrderDetail;
    this.commitType = paramInt;
    this.payTypeItems = paramArrayList;
    this.is_takeaway = (int)paramPendingFullOrderDetail.bXb.aVN;
    if (this.mContext.getResources().getBoolean(2131034121)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramPendingFullOrderDetail.bXb.ceX);
      stringBuilder.append("");
      d = 100.0D - by.parseDouble(stringBuilder.toString());
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramPendingFullOrderDetail.bXb.ceX);
      stringBuilder.append("");
      d = by.parseDouble(stringBuilder.toString());
    } 
    this.discount = d;
    this.productData = new ArrayList();
    this.isSaleOrder = true;
    setProductData(paramPendingFullOrderDetail);
  }
  
  public PhoneOrders(ActivityRoot paramActivityRoot, PendingFullOrderDetail paramPendingFullOrderDetail, int paramInt, ArrayList<z> paramArrayList, v paramv) {
    this.mActivity = paramActivityRoot;
    this.mContext = paramActivityRoot;
    this.mCallBack = paramv;
    if (paramInt == 2) {
      this.orderNo = paramPendingFullOrderDetail.bXb.orderNo;
    } else {
      this.orderNo = PosActivitySettlementModel.a(true, new Date());
    } 
    this.recevied = 0.0D;
    this.order = paramPendingFullOrderDetail;
    this.commitType = paramInt;
    this.payTypeItems = paramArrayList;
    this.is_takeaway = (int)paramPendingFullOrderDetail.bXb.aVN;
    if (this.mActivity.getResources().getBoolean(2131034121)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramPendingFullOrderDetail.bXb.ceX);
      stringBuilder.append("");
      d = 100.0D - by.parseDouble(stringBuilder.toString());
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramPendingFullOrderDetail.bXb.ceX);
      stringBuilder.append("");
      d = by.parseDouble(stringBuilder.toString());
    } 
    this.discount = d;
    this.productData = new ArrayList();
    this.isSaleOrder = true;
    setProductData(paramPendingFullOrderDetail);
    this.attributeRuleSetting = (new d()).a(new d.a()).akm();
  }
  
  private aa convert(PendingFullOrderDetail.d paramd) {
    aa aa = new aa(new h(paramd.id, paramd.name, paramd.cpm, paramd.cpn, 0.0D, 600001, paramd.cpq, "", paramd.cpu, "", (int)paramd.cpx, 0.0D), this.attributeRuleSetting);
    this.recevied += paramd.cpn * paramd.cpo;
    if (paramd.cpl != null)
      aa.aq(paramd.cpl.longValue()); 
    aa.t(paramd.aTF);
    aa.u(paramd.aTG);
    aa.o(paramd.aTR);
    aa.az(paramd.bbX);
    aa.ar(paramd.aTO);
    aa.cS(paramd.aTP);
    aa.q(paramd.cpo);
    aa.cV(true);
    aa.GD();
    return aa;
  }
  
  private String getUserID() {
    av av = new av(this.mContext);
    String str = av.atm();
    av.close();
    return str;
  }
  
  private void putMeal2List(List<aa> paramList) {
    ArrayList arrayList = new ArrayList();
    byte b;
    for (b = 0; b < paramList.size(); b++) {
      aa aa = (aa)paramList.get(b);
      aa.q(aa.akF());
      boolean bool = aa instanceof ao;
      if (bool) {
        arrayList.add((ao)aa);
      } else {
        arrayList.add(aa);
      } 
      if (((aa)paramList.get(b)).akM() == 2 && bool) {
        null = (ao)aa;
        ArrayList arrayList1 = null.IU().akq();
        double d = null.akF();
        Iterator iterator = arrayList1.iterator();
        while (iterator.hasNext()) {
          aa aa1 = new aa((h)iterator.next(), aa.Gq());
          aa1.q(d);
          arrayList.add(aa1);
        } 
      } 
    } 
    paramList.clear();
    paramList.addAll(arrayList);
  }
  
  private void setSettementEntity(bb parambb) {
    if (this.orderDateTime > 0L)
      parambb.az(this.orderDateTime); 
    parambb.discount = this.discount;
    parambb.headerText = this.headerText;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.tableID);
    stringBuilder.append("");
    parambb.bbQ = stringBuilder.toString();
    parambb.sRefNo = this.sRefNo;
    parambb.deliverAmount = this.deliverAmount;
    parambb.dishwareAmount = this.dishwareAmount;
    parambb.dishwareBaseAmount = this.dishwareBaseAmount;
    parambb.deliverBaseAmount = this.deliverBaseAmount;
    parambb.dishwareTaxName = this.dishwareTaxName;
    parambb.deliverTaxName = this.deliverTaxName;
    parambb.cb(this.serviceTaxName);
    parambb.Y(this.serviceChargeAmount);
    parambb.billNumber = this.billNumber;
    parambb.discountAmount = this.discountAmount;
    parambb.discountMessage = this.discountMessage;
    parambb.m(this.taxOfSettement);
  }
  
  public void addProductToSelectedList(h paramh) {
    aa aa;
    if (paramh instanceof aa) {
      aa = (aa)paramh;
    } else {
      aa = new aa(paramh, this.attributeRuleSetting);
    } 
    this.productData.add(aa);
    aa.GJ();
    aa.GI();
    if (paramh instanceof a) {
      ArrayList arrayList = ((a)paramh).akq();
      if (arrayList != null)
        for (h h1 : arrayList)
          this.productData.add(new aa(h1, this.attributeRuleSetting));  
    } 
  }
  
  public PhoneOrders setActualPerson(int paramInt) {
    this.actualPerson = paramInt;
    return this;
  }
  
  public PhoneOrders setBelongID(int paramInt) {
    this.belongID = paramInt;
    return this;
  }
  
  public PhoneOrders setOrderDateTime(long paramLong) {
    this.orderDateTime = paramLong;
    return this;
  }
  
  public void setProductData(PendingFullOrderDetail paramPendingFullOrderDetail) {
    Iterator iterator2 = paramPendingFullOrderDetail.coy.iterator();
    while (iterator2.hasNext())
      addProductToSelectedList(convert((PendingFullOrderDetail.d)iterator2.next())); 
    Iterator iterator1 = paramPendingFullOrderDetail.coz.iterator();
    while (iterator1.hasNext()) {
      iterator2 = ((PendingFullOrderDetail.c)iterator1.next()).cpg.iterator();
      while (iterator2.hasNext())
        addProductToSelectedList(convert((PendingFullOrderDetail.d)iterator2.next())); 
    } 
  }
  
  public PhoneOrders setTableID(long paramLong) {
    this.tableID = paramLong;
    return this;
  }
  
  public PhoneOrders setTotalAmount(double paramDouble) {
    this.totalAmount = paramDouble;
    return this;
  }
  
  public void startOrderAsyncTask() { (new a(this, null)).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Integer> {
    aq vipEntity;
    
    private a(PhoneOrders this$0) {}
    
    protected Integer e(Void... param1VarArgs) {
      if (this.baw.order != null && this.baw.order.bXb.coO > 0L) {
        av av = new av(this.baw.mContext);
        if (av.Wq()) {
          StringBuilder stringBuilder1;
          if (this.baw.belongID != 0) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(this.baw.belongID);
          } else {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(this.baw.order.bXb.bJc);
          } 
          stringBuilder1.append("");
          String str = stringBuilder1.toString();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.baw.order.bXb.coO);
          stringBuilder2.append("");
          this.vipEntity = MemberChargeDetailRecord.I(stringBuilder2.toString(), str);
        } else {
          l l = new l(this.baw.mContext);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.baw.order.bXb.coO);
          stringBuilder.append("");
          this.vipEntity = l.hq(stringBuilder.toString());
          l.close();
        } 
        av.close();
      } else if (this.baw.takeOrderEntity != null && (this.baw.takeOrderEntity.getVipEntity()).aSW > 0L) {
        av av = new av(this.baw.mContext);
        if (av.Wq()) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append((this.baw.takeOrderEntity.getVipEntity()).aWC);
          stringBuilder1.append("");
          String str = stringBuilder1.toString();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append((this.baw.takeOrderEntity.getVipEntity()).aSW);
          stringBuilder2.append("");
          this.vipEntity = MemberChargeDetailRecord.I(stringBuilder2.toString(), str);
        } else {
          l l = new l(this.baw.mContext);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append((this.baw.takeOrderEntity.getVipEntity()).aSW);
          stringBuilder.append("");
          this.vipEntity = l.hq(stringBuilder.toString());
          l.close();
        } 
        this.baw.takeOrderEntity.setVipEntity(this.vipEntity);
        av.close();
      } 
      return null;
    }
    
    protected void e(Integer param1Integer) {
      Log.i("onClick", "onPostExecute 生成记录。。。。");
      super.onPostExecute(param1Integer);
      bb bb = new bb(this.baw.isSaleOrder, this.baw.productData, this.baw.recevied, 100.0D);
      bb.orderNo = this.baw.orderNo;
      if (this.baw.commitType == 0) {
        bb.bcg = this.baw.order.bXb.coO;
        bb.discount = this.baw.discount;
        l l = new l(this.baw.mContext);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.baw.order.bXb.coO);
        stringBuilder.append("");
        c c = l.hq(stringBuilder.toString());
        l.close();
        bb.vipEntity = c;
        if (this.baw.is_takeaway == 0) {
          bb.bcf = 5L;
          bb.bci = String.valueOf(this.baw.order.bXb.coR);
        } else if (this.baw.is_takeaway == 1) {
          bb.bcf = 6L;
        } 
      } else if (1 == this.baw.commitType) {
        bb.bcf = 7L;
        if (this.baw.orderDateTime > 0L)
          bb.az(this.baw.orderDateTime); 
        try {
          bb.bcg = this.baw.order.bXb.coO;
          bb.discount = this.baw.order.bXb.ceX.doubleValue();
          bb.vipEntity = this.vipEntity;
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.baw.tableID);
          stringBuilder1.append("");
          bb.bbQ = stringBuilder1.toString();
          bb.bbR = Long.valueOf(this.baw.tableID);
          a1 = new a(CrashApplication.zv());
          null = a1.kA(this.baw.order.bXb.orderNo);
          a1.close();
          int i = this.baw.actualPerson;
          str1 = null;
          if (by.isNull(null)) {
            StringBuilder stringBuilder1;
            a a1;
            String str1;
            null = new StringBuilder();
            null.append(this.baw.getUserID());
            null.append("");
            str1 = null.toString();
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.baw.order.bXb.aEI);
          stringBuilder.append("");
          bb.bch = b.a(i, str1, stringBuilder.toString(), this.baw.order.bXb.coE.getTime());
          String str = b.a(this.baw.mContext, null, Long.valueOf(this.baw.tableID), true);
          if (this.baw.order.bXb.coM == 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str.bZc);
            stringBuilder.append("-");
            stringBuilder.append(str.bTe);
            str = stringBuilder.toString();
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str.bZc);
            stringBuilder.append("-");
            stringBuilder.append(str.bTe);
            stringBuilder.append(".");
            stringBuilder.append(RootApplication.zv().getString(2131626009));
            stringBuilder.append(this.baw.order.bXb.coM);
            str = stringBuilder.toString();
          } 
          bb.openTableName = str;
        } catch (Exception param1Integer) {
          a.e(param1Integer);
        } 
      } else if (-1 == this.baw.commitType) {
        bb.bcf = 1L;
        if (this.baw.takeOrderEntity != null && (this.baw.takeOrderEntity.getVipEntity()).aSW > 0L) {
          bb.bbV = false;
          bb.vipEntity = this.baw.takeOrderEntity.getVipEntity();
          bb.bcg = (this.baw.takeOrderEntity.getVipEntity()).aSW;
        } 
        this.baw.setSettementEntity(bb);
      } else if (-2 == this.baw.commitType) {
        bb.bcf = 2L;
        if (this.baw.takeOrderEntity != null && (this.baw.takeOrderEntity.getVipEntity()).aSW > 0L) {
          bb.bbV = false;
          bb.vipEntity = this.baw.takeOrderEntity.getVipEntity();
          bb.bcg = (this.baw.takeOrderEntity.getVipEntity()).aSW;
        } 
        this.baw.setSettementEntity(bb);
      } else if (-3 == this.baw.commitType) {
        bb.bcf = 3L;
        if (this.baw.takeOrderEntity != null && (this.baw.takeOrderEntity.getVipEntity()).aSW > 0L) {
          bb.bbV = false;
          bb.vipEntity = this.baw.takeOrderEntity.getVipEntity();
          bb.bcg = (this.baw.takeOrderEntity.getVipEntity()).aSW;
        } 
        this.baw.setSettementEntity(bb);
      } else if (2 == this.baw.commitType) {
        bb.bcf = 14L;
        bb.bbV = false;
        if (this.baw.orderDateTime > 0L)
          bb.az(this.baw.orderDateTime); 
        try {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.baw.tableID);
          stringBuilder1.append("");
          bb.bbQ = stringBuilder1.toString();
          bb.bbR = Long.valueOf(this.baw.tableID);
          bb.vipEntity = this.vipEntity;
          bb.bcg = this.baw.order.bXb.coO;
          a a2 = new a(CrashApplication.zv());
          String str2 = a2.kA(this.baw.order.bXb.orderNo);
          a2.close();
          int i = this.baw.actualPerson;
          String str1 = str2;
          if (by.isNull(str2)) {
            null = new StringBuilder();
            null.append(this.baw.getUserID());
            null.append("");
            str1 = null.toString();
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.baw.order.bXb.aEI);
          stringBuilder2.append("");
          bb.bch = b.a(i, str1, stringBuilder2.toString(), this.baw.order.bXb.coE.getTime());
          b.a a1 = b.a(this.baw.mContext, null, Long.valueOf(this.baw.tableID), true);
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(a1.bZc);
          stringBuilder2.append("-");
          stringBuilder2.append(a1.bTe);
          bb.openTableName = stringBuilder2.toString();
        } catch (Exception param1Integer) {
          a.e(param1Integer);
        } 
      } 
      for (z z : this.baw.payTypeItems)
        bb.bbS.add(z); 
      bb.bbY = this.baw.totalAmount;
      posActivitySettlementModel = new PosActivitySettlementModel(this.baw.mContext);
      try {
        posActivitySettlementModel.beginTransaction();
        String str = posActivitySettlementModel.f(bb);
        if (str != null) {
          n.o(str);
          return;
        } 
        posActivitySettlementModel.setTransactionSuccessful();
        (new a(this, bb.orderNo, null)).start();
        if (this.baw.commitType == 0)
          (new b(this, bb.orderNo, null)).start(); 
        posActivitySettlementModel.endTransaction();
        posActivitySettlementModel.close();
        if (this.baw.mCallBack != null) {
          if (this.baw.order != null && this.baw.order.bXb != null) {
            if (this.baw.commitType == 0 || 1 == this.baw.commitType) {
              this.baw.mCallBack.a(this.baw.order.bXb.orderNo, bb);
            } else if (this.baw.commitType == 2) {
              this.baw.settlementRunnable = new di(this.baw.mContext, bb, false, new f(this));
              this.baw.settlementRunnable.setDeletedPendingOrder(PendingFullOrderDetail.coB);
              this.baw.settlementRunnable.k(bb);
              this.baw.mCallBack.a(this.baw.order.bXb.orderNo, bb);
            } else {
              this.baw.mCallBack.a(this.baw.order.bXb.orderNo, bb);
            } 
            RootApplication.zv().getApplicationContext().sendBroadcast(new Intent("pos_activity_change_data_product"));
            return;
          } 
          this.baw.mCallBack.a("", null);
          return;
        } 
      } catch (JSONException posActivitySettlementModel) {
        a.e(posActivitySettlementModel);
      } finally {}
    }
    
    private class a extends Thread {
      private String orderNo;
      
      private a(PhoneOrders.a this$0, String param2String) { this.orderNo = param2String; }
      
      public void run() {
        super.run();
        PosActivitySettlementModel.eQ(this.orderNo);
      }
    }
    
    private class b extends Thread {
      private String orderNo;
      
      private b(PhoneOrders.a this$0, String param2String) { this.orderNo = param2String; }
      
      public void run() {
        super.run();
        try {
          JSONObject jSONObject = new JSONObject();
          jSONObject.put("shop_id", CrashApplication.getLaiqianPreferenceManager().Tx());
          jSONObject.put("out_trade_id", this.orderNo);
          bd.d(b.crT, bd.u(jSONObject));
          return;
        } catch (Exception exception) {
          a.e(exception);
          return;
        } 
      }
    }
  }
  
  private class a extends Thread {
    private String orderNo;
    
    private a(PhoneOrders this$0, String param1String) { this.orderNo = param1String; }
    
    public void run() {
      super.run();
      PosActivitySettlementModel.eQ(this.orderNo);
    }
  }
  
  private class b extends Thread {
    private String orderNo;
    
    private b(PhoneOrders this$0, String param1String) { this.orderNo = param1String; }
    
    public void run() {
      super.run();
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("shop_id", CrashApplication.getLaiqianPreferenceManager().Tx());
        jSONObject.put("out_trade_id", this.orderNo);
        bd.d(b.crT, bd.u(jSONObject));
        return;
      } catch (Exception exception) {
        a.e(exception);
        return;
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\PhoneOrders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */