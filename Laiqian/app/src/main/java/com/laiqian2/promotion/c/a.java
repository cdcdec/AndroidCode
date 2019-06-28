package com.laiqian.promotion.c;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.laiqian.basic.LQKVersion;
import com.laiqian.entity.DateSelectEntity;
import com.laiqian.entity.ac;
import com.laiqian.entity.ae;
import com.laiqian.entity.ag;
import com.laiqian.entity.ak;
import com.laiqian.entity.al;
import com.laiqian.entity.g;
import com.laiqian.entity.h;
import com.laiqian.entity.w;
import com.laiqian.models.ae;
import com.laiqian.models.ag;
import com.laiqian.models.at;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.promotion.R;
import com.laiqian.promotion.f.a;
import com.laiqian.util.n;
import com.laiqian.util.t;
import java.util.ArrayList;
import java.util.List;

public class a extends ag {
  public a(Context paramContext) { super(paramContext); }
  
  private int a(Cursor paramCursor, DateSelectEntity paramDateSelectEntity) {
    byte b;
    if ("Y".equals(paramCursor.getString(11))) {
      b = 1;
    } else {
      b = 2;
    } 
    if (System.currentTimeMillis() > paramDateSelectEntity.EA())
      b = 3; 
    return b;
  }
  
  @NonNull
  private w a(long paramLong, g paramg, String[] paramArrayOfString) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(VC());
    stringBuilder.append(111);
    stringBuilder.append("003");
    if (n.parseLong(stringBuilder.toString()) == paramLong) {
      str = paramArrayOfString[0];
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append(VC());
      stringBuilder.append(111);
      stringBuilder.append("002");
      if (n.parseLong(stringBuilder.toString()) == paramLong) {
        str = paramArrayOfString[1];
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append(VC());
        stringBuilder.append(111);
        stringBuilder.append("001");
        if (n.parseLong(stringBuilder.toString()) == paramLong) {
          str = paramArrayOfString[2];
        } else if (str != null) {
          str = str.EV();
        } else {
          str = "unKnown";
        } 
      } 
    } 
    return new w(paramLong, str);
  }
  
  private w a(g paramg, String[] paramArrayOfString, long paramLong) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(VC());
    stringBuilder2.append(26);
    stringBuilder2.append("006");
    if (n.parseLong(stringBuilder2.toString()) == paramLong) {
      String str;
      if (LQKVersion.zo()) {
        str = paramArrayOfString[0];
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(VC());
        stringBuilder1.append(111);
        stringBuilder1.append("003");
        paramLong = n.parseLong(stringBuilder1.toString());
      } else if (str != null) {
        str = str.EV();
      } else {
        str = "unKnown";
      } 
      return new w(paramLong, str);
    } 
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(VC());
    stringBuilder2.append(26);
    stringBuilder2.append("005");
    if (n.parseLong(stringBuilder2.toString()) == paramLong) {
      String str;
      if (LQKVersion.zo()) {
        StringBuilder stringBuilder;
        str = stringBuilder1[1];
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(VC());
        stringBuilder1.append(111);
        stringBuilder1.append("002");
        paramLong = n.parseLong(stringBuilder1.toString());
      } else if (str != null) {
        String str1 = str.EV();
      } else {
        str = "unKnown";
      } 
      return new w(paramLong, str);
    } 
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(VC());
    stringBuilder2.append(26);
    stringBuilder2.append("004");
    if (n.parseLong(stringBuilder2.toString()) == paramLong) {
      String str;
      if (LQKVersion.zo()) {
        StringBuilder stringBuilder;
        str = stringBuilder1[2];
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(VC());
        stringBuilder1.append(111);
        stringBuilder1.append("001");
        paramLong = n.parseLong(stringBuilder1.toString());
      } else if (str != null) {
        String str1 = str.EV();
      } else {
        str = "unKnown";
      } 
      return new w(paramLong, str);
    } 
    return null;
  }
  
  private boolean a(ac paramac1, ac paramac2, String paramString) {
    ArrayList arrayList3 = new ArrayList();
    ArrayList arrayList4 = new ArrayList();
    ArrayList arrayList1 = paramac1.He();
    ArrayList arrayList2 = paramac2.He();
    boolean bool2 = a.a(arrayList2, arrayList1, arrayList3, arrayList4);
    boolean bool1 = true;
    if (bool2) {
      if (arrayList4.size() != 0 || arrayList1.size() == 0) {
        ae ae = new ae(this.mContext);
        bool1 = ae.g(arrayList4, paramString);
        ae.close();
      } else {
        bool1 = true;
      } 
      if (arrayList2.size() == 0) {
        ae ae = new ae(this.mContext);
        bool2 = ae.hN(paramString);
        ae.close();
      } else {
        ae ae = new ae(this.mContext);
        bool2 = ae.f(arrayList3, paramString);
        ae.close();
      } 
      if (bool1 && bool2)
        return true; 
      bool1 = false;
    } 
    return bool1;
  }
  
  @NonNull
  private DateSelectEntity b(Cursor paramCursor, int paramInt) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = t.dFc;
    if (paramInt != 1)
      stringBuilder2 = t.dFe; 
    DateSelectEntity.a a2 = (new DateSelectEntity.a()).ep(paramInt).ad(paramCursor.getLong(3)).cS(t.a(paramCursor.getLong(3), stringBuilder2)).ae(paramCursor.getLong(4)).cT(t.a(paramCursor.getLong(4), stringBuilder2)).af(paramCursor.getLong(5)).cU(t.a(paramCursor.getLong(5), t.dFf));
    if (paramInt == 4) {
      StringBuilder stringBuilder = new StringBuilder(paramCursor.getString(6));
    } else {
      stringBuilder2 = new StringBuilder();
    } 
    DateSelectEntity.a a1 = a2.d(stringBuilder2);
    if (paramInt == 3) {
      stringBuilder1 = new StringBuilder(paramCursor.getString(6));
    } else {
      stringBuilder1 = new StringBuilder();
    } 
    return a1.c(stringBuilder1).EE();
  }
  
  private boolean b(ac paramac1, ac paramac2, String paramString) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual Hn : ()Lcom/laiqian/entity/ag;
    //   4: astore_1
    //   5: aload_2
    //   6: invokevirtual Hn : ()Lcom/laiqian/entity/ag;
    //   9: astore #10
    //   11: aload_1
    //   12: invokevirtual HD : ()Lcom/laiqian/entity/ag;
    //   15: astore #9
    //   17: new java/util/ArrayList
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore #8
    //   26: new java/util/ArrayList
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: astore #11
    //   35: new java/util/ArrayList
    //   38: dup
    //   39: invokespecial <init> : ()V
    //   42: astore_2
    //   43: aload #10
    //   45: invokevirtual Hy : ()[J
    //   48: aload_1
    //   49: invokevirtual Hy : ()[J
    //   52: aload #8
    //   54: aload #11
    //   56: aload_2
    //   57: invokestatic a : ([J[JLjava/util/List;Ljava/util/List;Ljava/util/List;)Z
    //   60: istore #5
    //   62: iconst_0
    //   63: istore #6
    //   65: iload #5
    //   67: ifeq -> 200
    //   70: aload #11
    //   72: invokeinterface size : ()I
    //   77: ifne -> 97
    //   80: aload_1
    //   81: invokevirtual Hy : ()[J
    //   84: arraylength
    //   85: ifne -> 91
    //   88: goto -> 97
    //   91: iconst_1
    //   92: istore #5
    //   94: goto -> 153
    //   97: aload #9
    //   99: aload #11
    //   101: aload #11
    //   103: invokeinterface size : ()I
    //   108: anewarray java/lang/Long
    //   111: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   116: checkcast [Ljava/lang/Long;
    //   119: invokestatic b : ([Ljava/lang/Long;)[J
    //   122: invokevirtual c : ([J)V
    //   125: new com/laiqian/models/ae
    //   128: dup
    //   129: aload_0
    //   130: getfield mContext : Landroid/content/Context;
    //   133: invokespecial <init> : (Landroid/content/Context;)V
    //   136: astore #10
    //   138: aload #10
    //   140: aload #9
    //   142: aload_3
    //   143: invokevirtual a : (Lcom/laiqian/entity/ag;Ljava/lang/String;)Z
    //   146: istore #5
    //   148: aload #10
    //   150: invokevirtual close : ()V
    //   153: new com/laiqian/models/ae
    //   156: dup
    //   157: aload_0
    //   158: getfield mContext : Landroid/content/Context;
    //   161: invokespecial <init> : (Landroid/content/Context;)V
    //   164: astore #9
    //   166: aload #9
    //   168: aload #8
    //   170: aload_3
    //   171: invokevirtual c : (Ljava/util/List;Ljava/lang/String;)Z
    //   174: istore #7
    //   176: aload #9
    //   178: invokevirtual close : ()V
    //   181: iload #5
    //   183: ifeq -> 194
    //   186: iload #7
    //   188: ifeq -> 194
    //   191: goto -> 200
    //   194: iconst_0
    //   195: istore #4
    //   197: goto -> 203
    //   200: iconst_1
    //   201: istore #4
    //   203: new com/laiqian/models/ae
    //   206: dup
    //   207: aload_0
    //   208: getfield mContext : Landroid/content/Context;
    //   211: invokespecial <init> : (Landroid/content/Context;)V
    //   214: astore #8
    //   216: aload #8
    //   218: aload_2
    //   219: aload_3
    //   220: aload_1
    //   221: invokevirtual a : (Ljava/util/List;Ljava/lang/String;Lcom/laiqian/entity/ag;)Z
    //   224: istore #7
    //   226: aload #8
    //   228: invokevirtual close : ()V
    //   231: iload #6
    //   233: istore #5
    //   235: iload #4
    //   237: ifeq -> 252
    //   240: iload #6
    //   242: istore #5
    //   244: iload #7
    //   246: ifeq -> 252
    //   249: iconst_1
    //   250: istore #5
    //   252: iload #5
    //   254: ireturn }
  
  private w cW(long paramLong) {
    at at = new at(this.mContext);
    g g = at.bI(paramLong);
    at.close();
    String[] arrayOfString = this.mContext.getResources().getStringArray(R.array.people_type);
    w w2 = a(g, arrayOfString, paramLong);
    w w1 = w2;
    if (w2 == null)
      w1 = a(paramLong, g, arrayOfString); 
    return w1;
  }
  
  private ArrayList<ProductTypeEntity> cX(long paramLong) {
    ae ae = new ae(this.mContext);
    ArrayList arrayList = ae.bu(paramLong);
    ae.close();
    return arrayList;
  }
  
  private ag cY(long paramLong) {
    ae ae = new ae(this.mContext);
    ag ag1 = ae.bv(paramLong);
    ae.close();
    return ag1;
  }
  
  private ae cZ(long paramLong) {
    ae ae = new ae(this.mContext);
    ae ae1 = ae.bw(paramLong);
    ae.close();
    return ae1;
  }
  
  public boolean a(boolean paramBoolean, ac paramac) {
    String str;
    String[] arrayOfString;
    StringBuilder stringBuilder = new StringBuilder();
    if (!paramBoolean) {
      str = "fRechargeAmount = ? and nShopID = ?";
    } else {
      str = "fRechargeAmount = ? and nShopID = ? and _id<> ?";
    } 
    stringBuilder.append(str);
    stringBuilder.append(" and  nDeletionFlag<>1 ");
    hO(stringBuilder.toString());
    if (!paramBoolean) {
      String[] arrayOfString1 = new String[2];
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramac.Hh());
      stringBuilder.append("");
      arrayOfString1[0] = stringBuilder.toString();
      arrayOfString1[1] = VC();
      arrayOfString = arrayOfString1;
    } else {
      String[] arrayOfString1 = new String[3];
      stringBuilder = new StringBuilder();
      stringBuilder.append(arrayOfString.Hh());
      stringBuilder.append("");
      arrayOfString1[0] = stringBuilder.toString();
      arrayOfString1[1] = VC();
      stringBuilder = new StringBuilder();
      stringBuilder.append(arrayOfString.getID());
      stringBuilder.append("");
      arrayOfString1[2] = stringBuilder.toString();
      arrayOfString = arrayOfString1;
    } 
    v(arrayOfString);
    return Vl();
  }
  
  public boolean aQ(String paramString1, String paramString2) {
    d("_id=? and nShopID=?", new String[] { paramString1, VC() });
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("");
    am("fGiftTotalNum", stringBuilder.toString());
    return update();
  }
  
  public ArrayList<h> aS(double paramDouble) {
    ArrayList arrayList = new ArrayList();
    hY("_id,nDateType,nStartTime,nEndTime,sDateDay,fGiftAmount,fRechargeAmount,fGiftTotalNum");
    null = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    c(" nPromotionType=? and nShopID=?  and nDeletionFlag<>1 and sIsActive!='N' and fRechargeAmount<=? ", new String[] { "6", null, stringBuilder.toString() });
    ia(" fRechargeAmount  desc ");
    Cursor cursor = VM();
    if (cursor != null) {
      int j = cursor.getColumnIndex("fGiftAmount");
      int i = cursor.getColumnIndex("fGiftTotalNum");
      int k = cursor.getColumnIndex("fRechargeAmount");
      while (cursor.moveToNext()) {
        int m = cursor.getInt(cursor.getColumnIndex("nDateType"));
        long l1 = cursor.getLong(cursor.getColumnIndex("nStartTime"));
        long l2 = cursor.getLong(cursor.getColumnIndex("nEndTime"));
        String str = cursor.getString(cursor.getColumnIndex("sDateDay"));
        if (a.e((new DateSelectEntity.a()).ad(l1).ep(m).ae(l2).d(new StringBuilder(str)).c(new StringBuilder(str)).EE())) {
          double d1 = cursor.getDouble(j);
          double d2 = cursor.getDouble(k);
          double d3 = cursor.getDouble(i);
          l1 = cursor.getLong(cursor.getColumnIndex("_id"));
          ArrayList arrayList1 = (new ae(this.mContext)).bx(l1);
          if (arrayList1.size() > 0) {
            paramDouble = ((al)arrayList1.get(0)).aUz;
          } else {
            paramDouble = 0.0D;
          } 
          if (d3 == 0.0D || d3 < paramDouble)
            arrayList1.clear(); 
          h.a a1 = (new h.a()).m(d1).l(d2).o(d3).n(d1 / d2).h(arrayList1);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(l1);
          stringBuilder1.append("");
          arrayList.add(a1.cX(stringBuilder1.toString()).EX());
        } 
      } 
      cursor.close();
    } 
    return arrayList;
  }
  
  public boolean alq() {
    hY("_id,nDateType,nStartTime,nEndTime,sDateDay");
    int i = 0;
    byte b = 0;
    c(" nPromotionType=? and nShopID=?  and nDeletionFlag<>1 and sIsActive!='N'", new String[] { "6", VC() });
    Cursor cursor = VM();
    if (cursor != null) {
      while (true) {
        i = b;
        if (cursor.moveToNext()) {
          int j = cursor.getInt(cursor.getColumnIndex("nDateType"));
          long l1 = cursor.getLong(cursor.getColumnIndex("nStartTime"));
          long l2 = cursor.getLong(cursor.getColumnIndex("nEndTime"));
          String str = cursor.getString(cursor.getColumnIndex("sDateDay"));
          if (a.e((new DateSelectEntity.a()).ad(l1).ep(j).ae(l2).d(new StringBuilder(str)).c(new StringBuilder(str)).EE())) {
            i = 1;
            break;
          } 
          continue;
        } 
        break;
      } 
      cursor.close();
    } 
    return i;
  }
  
  public ArrayList<ac> b(int paramInt, ak paramak) {
    ArrayList arrayList = new ArrayList();
    hY("_id,sPromotionName,nDateType,nStartTime,nEndTime,nExpireTime,sDateDay,nFitPeople,sPromotionDiscount,fBuyAmount,fBuyQty,sIsActive,fDeductionAmount,nPromotionType,fAddPaidAmount,fGiftTotalNum,fRechargeAmount,fGiftAmount");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    c(" nPromotionType=? and nShopID=?  and nDeletionFlag<>1", new String[] { stringBuilder.toString(), VC() });
    ia(" nOperationTime  desc ");
    Cursor cursor = VM();
    if (cursor != null) {
      while (cursor.moveToNext()) {
        StringBuilder stringBuilder2;
        StringBuilder stringBuilder1;
        paramInt = cursor.getInt(2);
        long l1 = cursor.getLong(7);
        long l2 = cursor.getLong(0);
        DateSelectEntity dateSelectEntity = b(cursor, paramInt);
        paramInt = a(cursor, dateSelectEntity);
        w w = cW(l1);
        int i = cursor.getInt(13);
        boolean bool = paramak.HZ();
        ArrayList arrayList1 = null;
        if (bool) {
          stringBuilder1 = cY(l2);
          stringBuilder = null;
          stringBuilder2 = stringBuilder;
        } else if (paramak.HO()) {
          arrayList1 = cX(l2);
          if (arrayList1.size() != 0) {
            String str = String.format(this.mContext.getString(R.string.pos_promotion_selected_n_product_type), new Object[] { Integer.valueOf(arrayList1.size()) });
          } else {
            String str = this.mContext.getString(R.string.pos_people_type_not_limit);
          } 
          stringBuilder2 = null;
          stringBuilder1 = stringBuilder2;
        } else if (paramak.HT() || paramak.HU()) {
          stringBuilder2 = cZ(l2);
          stringBuilder = null;
          stringBuilder1 = stringBuilder;
        } else {
          stringBuilder = null;
          stringBuilder1 = stringBuilder;
          stringBuilder2 = stringBuilder1;
        } 
        arrayList.add((new ac.a()).au(l2).dl(cursor.getString(1)).b(w).D(cursor.getDouble(8)).K(cursor.getDouble(9)).L(cursor.getDouble(10)).H(cursor.getDouble(12)).ey(i).r(arrayList1).dm(stringBuilder).b(stringBuilder1).E(cursor.getDouble(14)).J(cursor.getDouble(15)).b(stringBuilder2).F(cursor.getDouble(16)).G(cursor.getDouble(17)).ex(paramInt).b(dateSelectEntity).Hq());
      } 
      cursor.close();
    } 
    return arrayList;
  }
  
  public boolean b(ac paramac1, ac paramac2, ak paramak) {
    null = new StringBuilder();
    null.append(paramac1.getID());
    null.append("");
    String str = null.toString();
    DateSelectEntity dateSelectEntity = paramac1.Hc();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(dateSelectEntity.Ev());
    stringBuilder2.append("");
    am("nDateType", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(dateSelectEntity.Ew());
    stringBuilder2.append("");
    am("nStartTime", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(dateSelectEntity.Ey());
    stringBuilder2.append("");
    am("nEndTime", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(dateSelectEntity.EA());
    stringBuilder2.append("");
    am("nExpireTime", stringBuilder2.toString());
    if (dateSelectEntity.Ev() == 3) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(dateSelectEntity.EC());
      stringBuilder2.append("");
      am("sDateDay", stringBuilder2.toString());
    } 
    if (dateSelectEntity.Ev() == 4) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(dateSelectEntity.ED());
      stringBuilder2.append("");
      am("sDateDay", stringBuilder2.toString());
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.getName());
    stringBuilder1.append("");
    am("sPromotionName", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.Hd().AR());
    stringBuilder1.append("");
    am("nFitPeople", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.FI());
    stringBuilder1.append("");
    am("sPromotionDiscount", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.Hk());
    stringBuilder1.append("");
    am("fBuyAmount", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.Hl());
    stringBuilder1.append("");
    am("fBuyQty", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.Hm());
    stringBuilder1.append("");
    am("nPromotionType", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.Hi());
    stringBuilder1.append("");
    am("fDeductionAmount", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.Hg());
    stringBuilder1.append("");
    am("fAddPaidAmount", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.Ho());
    stringBuilder1.append("");
    am("fGiftTotalNum", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.Hh());
    stringBuilder1.append("");
    am("fRechargeAmount", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac1.Hp());
    stringBuilder1.append("");
    am("fGiftAmount", stringBuilder1.toString());
    d("_id=? and nShopID=?", new String[] { str, VC() });
    boolean bool = update();
    null = bool;
    if (bool) {
      if (paramak.HZ())
        return b(paramac1, paramac2, str); 
      if (paramak.HO())
        return a(paramac1, paramac2, str); 
      if (!paramak.HT()) {
        null = bool;
        return paramak.HU() ? c(paramac1, paramac2, str) : null;
      } 
    } else {
      return null;
    } 
    return c(paramac1, paramac2, str);
  }
  
  public boolean b(ac paramac, ak paramak) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramac.getID());
    stringBuilder1.append("");
    String str = stringBuilder1.toString();
    null = paramac.Hc();
    am("_id", str);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(null.Ev());
    stringBuilder3.append("");
    am("nDateType", stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(null.Ew());
    stringBuilder3.append("");
    am("nStartTime", stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(null.Ey());
    stringBuilder3.append("");
    am("nEndTime", stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(null.EA());
    stringBuilder3.append("");
    am("nExpireTime", stringBuilder3.toString());
    if (null.Ev() == 3) {
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append(null.EC());
      stringBuilder3.append("");
      am("sDateDay", stringBuilder3.toString());
    } 
    if (null.Ev() == 4) {
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append(null.ED());
      stringBuilder3.append("");
      am("sDateDay", stringBuilder3.toString());
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(System.currentTimeMillis());
    stringBuilder2.append("");
    am("nDateTime", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.getName());
    stringBuilder2.append("");
    am("sPromotionName", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.Hd().AR());
    stringBuilder2.append("");
    am("nFitPeople", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.FI());
    stringBuilder2.append("");
    am("sPromotionDiscount", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.Hk());
    stringBuilder2.append("");
    am("fBuyAmount", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.Hl());
    stringBuilder2.append("");
    am("fBuyQty", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.Hm());
    stringBuilder2.append("");
    am("nPromotionType", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.Hi());
    stringBuilder2.append("");
    am("fDeductionAmount", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.Hg());
    stringBuilder2.append("");
    am("fAddPaidAmount", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.Ho());
    stringBuilder2.append("");
    am("fGiftTotalNum", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.Hh());
    stringBuilder2.append("");
    am("fRechargeAmount", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramac.Hp());
    stringBuilder2.append("");
    am("fGiftAmount", stringBuilder2.toString());
    boolean bool2 = QL();
    boolean bool1 = bool2;
    if (bool2) {
      ag ag1;
      ae ae;
      if (paramak.HZ()) {
        bool1 = bool2;
        if (paramac.Hn().Hy().length > 0) {
          ae = new ae(this.mContext);
          ag1 = paramac.Hn();
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(paramac.getID());
          stringBuilder2.append("");
          bool1 = ae.a(ag1, stringBuilder2.toString());
          ae.close();
          return bool1;
        } 
      } else {
        if (ae.HO()) {
          ae = new ae(this.mContext);
          bool1 = ae.g(paramac.He(), ag1);
          ae.close();
          return bool1;
        } 
        if (!ae.HT()) {
          bool1 = bool2;
          if (ae.HU())
            bool1 = bool2; 
          return bool1;
        } 
        bool1 = bool2;
      } 
    } 
    return bool1;
  }
  
  public boolean b(boolean paramBoolean, ac paramac) {
    String str;
    String[] arrayOfString;
    StringBuilder stringBuilder = new StringBuilder();
    if (!paramBoolean) {
      str = "sPromotionName = ? and nShopID = ?";
    } else {
      str = "sPromotionName = ? and nShopID = ? and _id<> ?";
    } 
    stringBuilder.append(str);
    stringBuilder.append(" and  nDeletionFlag<>1 ");
    hO(stringBuilder.toString());
    if (!paramBoolean) {
      String[] arrayOfString1 = new String[2];
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramac.getName());
      stringBuilder.append("");
      arrayOfString1[0] = stringBuilder.toString();
      arrayOfString1[1] = VC();
      arrayOfString = arrayOfString1;
    } else {
      String[] arrayOfString1 = new String[3];
      stringBuilder = new StringBuilder();
      stringBuilder.append(arrayOfString.getName());
      stringBuilder.append("");
      arrayOfString1[0] = stringBuilder.toString();
      arrayOfString1[1] = VC();
      stringBuilder = new StringBuilder();
      stringBuilder.append(arrayOfString.getID());
      stringBuilder.append("");
      arrayOfString1[2] = stringBuilder.toString();
      arrayOfString = arrayOfString1;
    } 
    v(arrayOfString);
    return Vl();
  }
  
  public boolean c(ac paramac1, ac paramac2, String paramString) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual Hj : ()Lcom/laiqian/entity/ae;
    //   4: astore #8
    //   6: aload_2
    //   7: invokevirtual Hj : ()Lcom/laiqian/entity/ae;
    //   10: astore_1
    //   11: new java/util/ArrayList
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: astore #10
    //   20: new java/util/ArrayList
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: astore #11
    //   29: new java/util/ArrayList
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore #9
    //   38: iconst_0
    //   39: istore #7
    //   41: aload_1
    //   42: ifnull -> 53
    //   45: aload_1
    //   46: invokevirtual Hr : ()[J
    //   49: astore_1
    //   50: goto -> 57
    //   53: iconst_0
    //   54: newarray long
    //   56: astore_1
    //   57: aload #8
    //   59: ifnull -> 71
    //   62: aload #8
    //   64: invokevirtual Hr : ()[J
    //   67: astore_2
    //   68: goto -> 75
    //   71: iconst_0
    //   72: newarray long
    //   74: astore_2
    //   75: aload_1
    //   76: aload_2
    //   77: aload #10
    //   79: aload #11
    //   81: aload #9
    //   83: invokestatic a : ([J[JLjava/util/List;Ljava/util/List;Ljava/util/List;)Z
    //   86: ifeq -> 216
    //   89: aload #11
    //   91: invokeinterface size : ()I
    //   96: ifne -> 113
    //   99: aload_2
    //   100: arraylength
    //   101: ifne -> 107
    //   104: goto -> 113
    //   107: iconst_1
    //   108: istore #5
    //   110: goto -> 172
    //   113: aload #11
    //   115: aload #11
    //   117: invokeinterface size : ()I
    //   122: anewarray java/lang/Long
    //   125: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   130: checkcast [Ljava/lang/Long;
    //   133: invokestatic b : ([Ljava/lang/Long;)[J
    //   136: astore_2
    //   137: aload #8
    //   139: invokevirtual Hw : ()Lcom/laiqian/entity/ae;
    //   142: astore_1
    //   143: aload_1
    //   144: aload_2
    //   145: invokevirtual a : ([J)V
    //   148: new com/laiqian/models/ae
    //   151: dup
    //   152: aload_0
    //   153: getfield mContext : Landroid/content/Context;
    //   156: invokespecial <init> : (Landroid/content/Context;)V
    //   159: astore_2
    //   160: aload_2
    //   161: aload_1
    //   162: aload_3
    //   163: invokevirtual a : (Lcom/laiqian/entity/ae;Ljava/lang/String;)Z
    //   166: istore #5
    //   168: aload_2
    //   169: invokevirtual close : ()V
    //   172: new com/laiqian/models/ae
    //   175: dup
    //   176: aload_0
    //   177: getfield mContext : Landroid/content/Context;
    //   180: invokespecial <init> : (Landroid/content/Context;)V
    //   183: astore_1
    //   184: aload_1
    //   185: aload #10
    //   187: aload_3
    //   188: invokevirtual c : (Ljava/util/List;Ljava/lang/String;)Z
    //   191: istore #6
    //   193: aload_1
    //   194: invokevirtual close : ()V
    //   197: iload #5
    //   199: ifeq -> 210
    //   202: iload #6
    //   204: ifeq -> 210
    //   207: goto -> 216
    //   210: iconst_0
    //   211: istore #4
    //   213: goto -> 219
    //   216: iconst_1
    //   217: istore #4
    //   219: iload #4
    //   221: ifeq -> 254
    //   224: new com/laiqian/models/ae
    //   227: dup
    //   228: aload_0
    //   229: getfield mContext : Landroid/content/Context;
    //   232: invokespecial <init> : (Landroid/content/Context;)V
    //   235: astore_1
    //   236: aload_1
    //   237: aload #9
    //   239: aload_3
    //   240: aload #8
    //   242: invokevirtual a : (Ljava/util/List;Ljava/lang/String;Lcom/laiqian/entity/ae;)Z
    //   245: istore #5
    //   247: aload_1
    //   248: invokevirtual close : ()V
    //   251: goto -> 257
    //   254: iconst_0
    //   255: istore #5
    //   257: iload #7
    //   259: istore #6
    //   261: iload #4
    //   263: ifeq -> 278
    //   266: iload #7
    //   268: istore #6
    //   270: iload #5
    //   272: ifeq -> 278
    //   275: iconst_1
    //   276: istore #6
    //   278: iload #6
    //   280: ireturn }
  
  public boolean da(long paramLong) {
    am("nDeletionFlag", "1");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("_id=? and nShopID=?", new String[] { stringBuilder.toString(), VC() });
    boolean bool = update();
    if (bool) {
      ae ae = new ae(this.mContext);
      bool = ae.by(paramLong);
      ae.close();
      return bool;
    } 
    return bool;
  }
  
  public boolean db(long paramLong) {
    am("sIsActive", "N");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("_id=? and nShopID=?", new String[] { stringBuilder.toString(), VC() });
    boolean bool = update();
    if (bool) {
      ae ae = new ae(this.mContext);
      bool = ae.bz(paramLong);
      ae.close();
      return bool;
    } 
    return bool;
  }
  
  public boolean dc(long paramLong) {
    am("sIsActive", "Y");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("_id=? and nShopID=?", new String[] { stringBuilder.toString(), VC() });
    boolean bool = update();
    if (bool) {
      ae ae = new ae(this.mContext);
      bool = ae.bA(paramLong);
      ae.close();
      return bool;
    } 
    return bool;
  }
  
  public ArrayList<ac> gt(boolean paramBoolean) {
    String str1;
    List list = a.bt(this.mContext);
    ArrayList arrayList = new ArrayList();
    this.mContext.getResources().getStringArray(R.array.people_type);
    hY("_id,sPromotionName,nDateType,nStartTime,nEndTime,nExpireTime,sDateDay,nFitPeople,sPromotionDiscount,fBuyAmount,fBuyQty,sIsActive,fDeductionAmount,nPromotionType,fAddPaidAmount,fGiftTotalNum,fRechargeAmount,fGiftAmount");
    if (paramBoolean) {
      str1 = " nShopID=?  and nDeletionFlag<>1 and nExpireTime>=? and nPromotionType in (1,2,4) and sIsActive!='N'";
    } else {
      str1 = " nShopID=?  and nDeletionFlag<>1 and nExpireTime>=? and sIsActive!='N'";
    } 
    String str2 = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    c(str1, new String[] { str2, stringBuilder.toString() });
    ia(" nOperationTime  desc ");
    Cursor cursor = VM();
    if (cursor != null) {
      while (true) {
        if (cursor.moveToNext()) {
          int i = cursor.getInt(2);
          long l1 = cursor.getLong(7);
          long l2 = cursor.getLong(0);
          DateSelectEntity dateSelectEntity = b(cursor, i);
          i = a(cursor, dateSelectEntity);
          w w = cW(l1);
          int j = cursor.getInt(13);
          ak ak = (ak)list.get(j - 1);
          if (ak.HZ()) {
            ag ag1 = cY(l2);
          } else {
            String str4;
            String str3;
            if (ak.HO()) {
              ArrayList arrayList1 = cX(l2);
              if (arrayList1.size() != 0) {
                str3 = String.format(this.mContext.getString(R.string.pos_promotion_selected_n_product_type), new Object[] { Integer.valueOf(arrayList1.size()) });
              } else {
                str3 = this.mContext.getString(R.string.pos_people_type_not_limit);
              } 
              str2 = null;
              str4 = null;
            } else {
              if (str3.HT() || str3.HU()) {
                ae ae = cZ(l2);
                str2 = null;
              } else {
                str2 = null;
                str3 = null;
              } 
              stringBuilder = null;
              String str = null;
              str4 = str3;
              str3 = str;
            } 
            arrayList.add((new ac.a()).au(l2).dl(cursor.getString(1)).b(w).D(cursor.getDouble(8)).K(cursor.getDouble(9)).L(cursor.getDouble(10)).H(cursor.getDouble(12)).ey(j).r(stringBuilder).dm(str3).b(str2).E(cursor.getDouble(14)).J(cursor.getDouble(15)).b(str4).F(cursor.getDouble(16)).G(cursor.getDouble(17)).ex(i).b(dateSelectEntity).Hq());
            continue;
          } 
        } else {
          break;
        } 
        str1 = null;
      } 
      cursor.close();
    } 
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */