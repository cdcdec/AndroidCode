package com.laiqian.report.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.u;
import com.laiqian.entity.v;
import com.laiqian.print.model.PrintContent;
import com.laiqian.rx.util.a;
import io.reactivex.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class b extends u implements i, j {
  public static final String bHV;
  
  public static final int[] bOf = { 
      -2140854, -22444, -9843340, -9325331, -3566125, -10497569, -12503, -1213011, -7085675, -3878029, 
      -12341009, -222653, -492420 };
  
  public static final String bzY;
  
  private Double aEK;
  
  private String aJZ;
  
  private long bSc;
  
  private ArrayList<a> bjv;
  
  private ArrayList<a> cZC;
  
  private String cZG;
  
  private String cZH;
  
  private String cZI;
  
  private String cZJ;
  
  private String cZK;
  
  private boolean cZL;
  
  private boolean cZM;
  
  private String cZN;
  
  private final int[] cZO = { 
      -2140854, -22444, -5139752, -5384986, -1943775, -610776, -931034, -790491, -7413473, -13376490, 
      -14293059, -14559257, -14827544, -15163928, -15366424, -15569689, -8439576, -5424664, -3130647, -1625671 };
  
  @Nullable
  private a cZP;
  
  @Nullable
  private a cZQ;
  
  private int cZR = 1;
  
  private SQLiteDatabase cZS;
  
  private List<String> cZT;
  
  private t cZU;
  
  private double[] cZV = new double[3];
  
  private double cZW;
  
  private a<u> cZX = a.aoI();
  
  private a cZY = new a();
  
  private long mStartTime;
  
  static  {
    bHV = CrashApplication.zv().getString(2131627794);
    bzY = CrashApplication.zv().getString(2131627793);
  }
  
  public b(Context paramContext) { super(paramContext); }
  
  @NonNull
  private a a(Long paramLong, String paramString, Double paramDouble) { return (paramLong.longValue() == 10001L) ? new a(paramLong.longValue(), this.mContext.getString(2131627780), paramDouble.doubleValue(), 2131230946, jH(this.bjv.size())) : ((paramLong.longValue() == 10012L) ? new a(paramLong.longValue(), this.mContext.getString(2131627818), paramDouble.doubleValue(), 2131231992, jH(this.bjv.size())) : ((paramLong.longValue() == 10006L) ? new a(paramLong.longValue(), this.mContext.getString(2131627815), paramDouble.doubleValue(), 2131231254, jH(this.bjv.size())) : ((paramLong.longValue() == 10009L) ? new a(paramLong.longValue(), this.mContext.getString(2131627819), paramDouble.doubleValue(), 2131231995, -10565014) : ((paramLong.longValue() == 10007L) ? new a(paramLong.longValue(), this.mContext.getString(2131627779), paramDouble.doubleValue(), 2131230832, -10508568) : ((paramLong.longValue() == 10011L) ? new a(paramLong.longValue(), this.mContext.getString(2131627358), paramDouble.doubleValue(), 2131231334, jH(this.bjv.size())) : ((paramLong.longValue() == 10008L) ? new a(paramLong.longValue(), this.mContext.getString(2131627357), paramDouble.doubleValue(), 2131231334, jH(this.bjv.size())) : ((paramLong.longValue() == 10010L) ? new a(paramLong.longValue(), this.mContext.getString(2131627359), paramDouble.doubleValue(), 2131231334, jH(this.bjv.size())) : ((paramLong.longValue() == 10014L) ? new a(paramLong.longValue(), this.mContext.getString(2131627327), paramDouble.doubleValue(), 2131231334, jH(this.bjv.size())) : new a(paramLong.longValue(), paramString, paramDouble.doubleValue(), 2131231334, jH(this.bjv.size())))))))))); }
  
  private List<Pair<String, Double>> a(Long paramLong, a parama, boolean paramBoolean) {
    arrayList = new ArrayList();
    if (this.cZT != null) {
      if (this.cZS == null)
        return arrayList; 
      StringBuilder stringBuilder = new StringBuilder("SELECT SUM(TOTAL_AMOUNT),SUM(SALE_AMOUNT),SUM(REFOUND_AMOUNT),ACCOUNT_ID,ACCOUNT_NAME,ORDER_TYPE,ORDER_TYPE_NAME from (");
      for (b1 = 0; b1 < this.cZT.size(); b1++) {
        String str1;
        String str2 = (String)this.cZT.get(b1);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("SELECT SUM(");
        stringBuilder1.append(this.cZG);
        stringBuilder1.append(") TOTAL_AMOUNT,\n  SUM(");
        stringBuilder1.append(this.cZH);
        stringBuilder1.append(") SALE_AMOUNT,\n      SUM(");
        stringBuilder1.append(this.cZI);
        stringBuilder1.append(") REFOUND_AMOUNT,\n      CASE WHEN T.nAccountID = 10013 THEN T_ACCOUNT._id ELSE T.nAccountID END ACCOUNT_ID,\n      T_ACCOUNT.sAccountName ACCOUNT_NAME,\n      T.nSpareField2 ORDER_TYPE ,\n       CASE T.nSpareField2\n            WHEN 0 THEN '");
        stringBuilder1.append(this.mContext.getString(2131628058));
        stringBuilder1.append("'\n            WHEN 1 THEN '");
        stringBuilder1.append(this.mContext.getString(2131629985));
        stringBuilder1.append("'\n            WHEN 2 THEN '");
        stringBuilder1.append(this.mContext.getString(2131627171));
        stringBuilder1.append("'\n            WHEN 3 THEN '");
        stringBuilder1.append(this.mContext.getString(2131627171));
        stringBuilder1.append("'\n            WHEN 5 THEN '");
        stringBuilder1.append(this.mContext.getString(2131628360));
        stringBuilder1.append("'\n            WHEN 6 THEN '");
        stringBuilder1.append(this.mContext.getString(2131628780));
        stringBuilder1.append("'\n            WHEN 7 THEN '");
        stringBuilder1.append(this.mContext.getString(2131626882));
        stringBuilder1.append("'\n            WHEN 8 THEN '");
        stringBuilder1.append(this.mContext.getString(2131625100));
        stringBuilder1.append("'\n            WHEN 9 THEN '");
        stringBuilder1.append(this.mContext.getString(2131626893));
        stringBuilder1.append("'\n            WHEN 14 THEN '");
        stringBuilder1.append(this.mContext.getString(2131629536));
        stringBuilder1.append("'\n            WHEN 15 THEN '");
        stringBuilder1.append(this.mContext.getString(2131626780));
        stringBuilder1.append("'\n       END ORDER_TYPE_NAME\n      FROM ((\n                    SELECT\n                            sText,\n                            nAccountID,\n                            nSpareField1,\n                            nSpareField2,\n                            fAccountAmount,\n                            nMoneyDirection,\n                            nUserID        \n                    FROM ");
        stringBuilder1.append(str2);
        stringBuilder1.append(".T_ACCOUNTDOC\n                    WHERE (nDeletionFlag ISNULL OR nDeletionFlag != 1)\n                    AND nDateTime >= ");
        stringBuilder1.append(this.cZU.ane());
        stringBuilder1.append("\n                    AND nDateTime <= ");
        stringBuilder1.append(this.cZU.anf());
        stringBuilder1.append("\n                    AND nShopID = ");
        stringBuilder1.append(VC());
        stringBuilder1.append("\n");
        if (this.cZU.ang() > 0L) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("  AND nUserID = ");
          stringBuilder2.append(this.cZU.ang());
          str1 = stringBuilder2.toString();
        } else {
          String str;
          str1 = "";
        } 
        stringBuilder1.append(str1);
        stringBuilder1.append("                    ) T_ACCOUNTDOC\n                    LEFT JOIN (\n                            SELECT  fChargeAmount,\n                            sText,\n                            nChargeType,\n                            nBPartnerID\n                    FROM ");
        stringBuilder1.append(str2);
        stringBuilder1.append(".T_BPARTNER_CHARGEDOC\n                    WHERE (sSpareField1 ISNULL OR sSpareField1 != 1)\n                    AND (nChargeType = 370005 OR nChargeType ISNULL ) GROUP BY sText\n                       ) T_BPARTNER_CHARGEDOC\n                    ON T_ACCOUNTDOC.sText = T_BPARTNER_CHARGEDOC.sText) T\n      LEFT JOIN T_ACCOUNT\n      ON CASE WHEN T.nAccountID =10013 THEN T_ACCOUNT._id = T.nSpareField1 ELSE T_ACCOUNT.nAccountID = T.nAccountID END ");
        if (paramBoolean) {
          str1 = "";
        } else {
          null = new StringBuilder();
          null.append("WHERE ACCOUNT_ID = ");
          null.append(paramLong);
          null.append("\n");
          str1 = null.toString();
        } 
        stringBuilder1.append(str1);
        stringBuilder1.append(this.cZJ);
        stringBuilder1.append("  GROUP BY  ");
        if (paramBoolean) {
          str1 = "";
        } else {
          str1 = "CASE WHEN T.nAccountID = 10013 THEN T.nSpareField1 ELSE T.nAccountID END,";
        } 
        stringBuilder1.append(str1);
        stringBuilder1.append("ORDER_TYPE --HAVING SALE_AMOUNT!=0\n");
        stringBuilder.append(stringBuilder1.toString());
        if (b1 != this.cZT.size() - 1) {
          stringBuilder.append(" UNION ALL ");
        } else {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(" ) GROUP BY ");
          if (paramBoolean) {
            str1 = "";
          } else {
            str1 = "ACCOUNT_ID,";
          } 
          stringBuilder1.append(str1);
          stringBuilder1.append("ORDER_TYPE");
          stringBuilder.append(stringBuilder1.toString());
        } 
      } 
      try {
        cursor = this.cZS.rawQuery(stringBuilder.toString(), new String[0]);
      } finally {
        paramLong = null;
      } 
    } else {
      return arrayList;
    } 
    if (parama != null)
      parama.close(); 
    throw paramLong;
  }
  
  private void a(a parama) {
    if (parama != null) {
      parama.amp();
      if (parama.cZk != 0.0D)
        this.bjv.add(parama); 
    } 
  }
  
  @NonNull
  private StringBuilder amB() {
    StringBuilder stringBuilder = new StringBuilder("SELECT SUM(CHARGE_AMOUNT),ACCOUNT_ID,ACCOUNT_NAME,SUM(CHARGE_COUNT) FROM(");
    for (byte b1 = 0; b1 < this.cZT.size(); b1++) {
      String str = (String)this.cZT.get(b1);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("SELECT\n  CHARGE_AMOUNT,\n  ACCOUNT_ID,\n  T_ACCOUNT.sAccountName ACCOUNT_NAME,\nCHARGE_COUNT FROM (SELECT SUM(fReceived) CHARGE_AMOUNT,\n              CASE WHEN nSpareField2=10013 THEN nSpareField3 ELSE nSpareField2 END ACCOUNT_ID,COUNT(*) CHARGE_COUNT\n       FROM ");
      stringBuilder1.append(str);
      stringBuilder1.append(".T_BPARTNER_CHARGEDOC\n       WHERE nChargeType in (370004,370010)       AND nShopID = ");
      stringBuilder1.append(VC());
      stringBuilder1.append("       AND (");
      stringBuilder1.append(str);
      stringBuilder1.append(".T_BPARTNER_CHARGEDOC.sSpareField1 ISNULL OR ");
      stringBuilder1.append(str);
      stringBuilder1.append(".T_BPARTNER_CHARGEDOC.sSpareField1 != 1)       AND nDateTime >= ");
      stringBuilder1.append(this.cZU.ane());
      stringBuilder1.append("       AND nDateTime <= ");
      stringBuilder1.append(this.cZU.anf());
      if (this.cZU.ang() > 0L) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("       AND nUserID = ");
        stringBuilder2.append(this.cZU.ang());
        String str1 = stringBuilder2.toString();
      } else {
        str = "";
      } 
      stringBuilder1.append(str);
      stringBuilder1.append("       GROUP BY ACCOUNT_ID\n     ) T\n  LEFT JOIN T_ACCOUNT\n    ON CASE WHEN T_ACCOUNT.nAccountID =10013 THEN T_ACCOUNT._id = T.ACCOUNT_ID\n       ELSE T_ACCOUNT.nAccountID = T.ACCOUNT_ID END");
      stringBuilder.append(stringBuilder1.toString());
      if (b1 != this.cZT.size() - 1) {
        stringBuilder.append(" UNION ALL ");
      } else {
        stringBuilder.append(") GROUP BY ACCOUNT_ID");
      } 
    } 
    return stringBuilder;
  }
  
  @Size
  private double[] amu() { return this.cZV; }
  
  private List<a> gA(boolean paramBoolean) { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #7
    //   9: aload_0
    //   10: getfield cZT : Ljava/util/List;
    //   13: ifnull -> 270
    //   16: aload_0
    //   17: getfield cZS : Landroid/database/sqlite/SQLiteDatabase;
    //   20: ifnonnull -> 26
    //   23: aload #7
    //   25: areturn
    //   26: aload_0
    //   27: invokespecial amB : ()Ljava/lang/StringBuilder;
    //   30: astore #8
    //   32: aload_0
    //   33: getfield cZS : Landroid/database/sqlite/SQLiteDatabase;
    //   36: aload #8
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: iconst_0
    //   42: anewarray java/lang/String
    //   45: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore #8
    //   50: dconst_0
    //   51: dstore_2
    //   52: iconst_0
    //   53: istore #4
    //   55: aload #8
    //   57: ifnull -> 207
    //   60: aload #8
    //   62: invokeinterface moveToNext : ()Z
    //   67: ifeq -> 207
    //   70: aload #8
    //   72: iconst_0
    //   73: invokeinterface getDouble : (I)D
    //   78: invokestatic valueOf : (D)Ljava/lang/Double;
    //   81: astore #9
    //   83: dload_2
    //   84: aload #9
    //   86: invokevirtual doubleValue : ()D
    //   89: dadd
    //   90: dstore_2
    //   91: aload #8
    //   93: iconst_1
    //   94: invokeinterface getLong : (I)J
    //   99: lstore #5
    //   101: aload #8
    //   103: iconst_2
    //   104: invokeinterface getString : (I)Ljava/lang/String;
    //   109: astore #10
    //   111: iload #4
    //   113: aload #8
    //   115: iconst_3
    //   116: invokeinterface getInt : (I)I
    //   121: iadd
    //   122: istore #4
    //   124: aload_0
    //   125: lload #5
    //   127: invokestatic valueOf : (J)Ljava/lang/Long;
    //   130: aload #10
    //   132: aload #9
    //   134: invokespecial a : (Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;)Lcom/laiqian/report/models/a;
    //   137: astore #10
    //   139: iload_1
    //   140: ifeq -> 159
    //   143: aload_0
    //   144: getfield cZX : Lcom/laiqian/rx/util/a;
    //   147: invokevirtual clear : ()V
    //   150: aload_0
    //   151: aload #10
    //   153: invokespecial a : (Lcom/laiqian/report/models/a;)V
    //   156: goto -> 55
    //   159: aload #10
    //   161: aload_0
    //   162: getfield mContext : Landroid/content/Context;
    //   165: ldc_w 2131624776
    //   168: invokevirtual getString : (I)Ljava/lang/String;
    //   171: aload_0
    //   172: getfield mContext : Landroid/content/Context;
    //   175: ldc_w 2131628486
    //   178: invokevirtual getString : (I)Ljava/lang/String;
    //   181: aload #9
    //   183: invokevirtual doubleValue : ()D
    //   186: iconst_0
    //   187: invokestatic gb : (I)I
    //   190: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;DI)Lcom/laiqian/report/models/a;
    //   193: pop
    //   194: aload #7
    //   196: aload #10
    //   198: invokeinterface add : (Ljava/lang/Object;)Z
    //   203: pop
    //   204: goto -> 55
    //   207: aload #8
    //   209: invokeinterface close : ()V
    //   214: aload_0
    //   215: iconst_3
    //   216: newarray double
    //   218: dup
    //   219: iconst_0
    //   220: iload #4
    //   222: i2d
    //   223: dastore
    //   224: dup
    //   225: iconst_1
    //   226: dconst_0
    //   227: dastore
    //   228: dup
    //   229: iconst_2
    //   230: dload_2
    //   231: dastore
    //   232: putfield cZV : [D
    //   235: aload #8
    //   237: ifnull -> 247
    //   240: aload #8
    //   242: invokeinterface close : ()V
    //   247: aload #7
    //   249: areturn
    //   250: astore #7
    //   252: aconst_null
    //   253: astore #8
    //   255: aload #8
    //   257: ifnull -> 267
    //   260: aload #8
    //   262: invokeinterface close : ()V
    //   267: aload #7
    //   269: athrow
    //   270: aload #7
    //   272: areturn
    //   273: astore #7
    //   275: goto -> 255
    // Exception table:
    //   from	to	target	type
    //   32	50	250	finally
    //   60	139	273	finally
    //   143	156	273	finally
    //   159	204	273	finally
    //   207	235	273	finally }
  
  private void gB(boolean paramBoolean) {
    if (this.cZT != null) {
      if (this.cZS == null)
        return; 
      StringBuilder stringBuilder = new StringBuilder("SELECT SUM(TOTAL_AMOUNT),SUM(SALE_AMOUNT),SUM(REFOUND_AMOUNT),ACCOUNT_ID,ACCOUNT_NAME from (");
      for (b1 = 0; b1 < this.cZT.size(); b1++) {
        String str1;
        String str2 = (String)this.cZT.get(b1);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("SELECT SUM(");
        stringBuilder1.append(this.cZG);
        stringBuilder1.append(") TOTAL_AMOUNT,\n       SUM(");
        stringBuilder1.append(this.cZH);
        stringBuilder1.append(") SALE_AMOUNT,\n       SUM(");
        stringBuilder1.append(this.cZI);
        stringBuilder1.append(") REFOUND_AMOUNT,\n       CASE WHEN T.nAccountID = 10013 THEN T_ACCOUNT._id ELSE T.nAccountID END ACCOUNT_ID,\n       T_ACCOUNT.sAccountName ACCOUNT_NAME,\n       T.nSpareField2 ORDER_TYPE\nFROM ((\n                    SELECT\n                            sText,\n                            nAccountID,\n                            nSpareField1,\n                            nSpareField2,\n                            fAccountAmount,\n                            nMoneyDirection,\n                            nUserID        \n                    FROM ");
        stringBuilder1.append(str2);
        stringBuilder1.append(".T_ACCOUNTDOC\n                    WHERE (nDeletionFlag ISNULL OR nDeletionFlag != 1)\n                    AND nDateTime >= ");
        stringBuilder1.append(this.cZU.ane());
        stringBuilder1.append("\n                    AND nDateTime <= ");
        stringBuilder1.append(this.cZU.anf());
        stringBuilder1.append("\n                    AND nShopID = ");
        stringBuilder1.append(VC());
        stringBuilder1.append("\n");
        if (this.cZU.ang() > 0L) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("  AND nUserID = ");
          stringBuilder2.append(this.cZU.ang());
          str1 = stringBuilder2.toString();
        } else {
          str1 = "";
        } 
        stringBuilder1.append(str1);
        stringBuilder1.append("                    ) T_ACCOUNTDOC\n                    LEFT JOIN (\n                            SELECT  fChargeAmount,\n                            sText,\n                            nChargeType,\n                            nBPartnerID\n                    FROM ");
        stringBuilder1.append(str2);
        stringBuilder1.append(".T_BPARTNER_CHARGEDOC\n                    WHERE (sSpareField1 ISNULL OR sSpareField1 != 1)\n                    AND (nChargeType = 370005 OR nChargeType ISNULL ) GROUP BY sText -- 为了保证记录只有一条，因为T_ACCOUNTDOC 有所有的支付记录\n                       ) T_BPARTNER_CHARGEDOC\n                    ON T_ACCOUNTDOC.sText = T_BPARTNER_CHARGEDOC.sText     ) T\n  LEFT JOIN T_ACCOUNT\n    ON CASE WHEN T.nAccountID =10013 THEN T_ACCOUNT._id = T.nSpareField1 ELSE T_ACCOUNT.nAccountID = T.nAccountID END\nWHERE 1=1");
        stringBuilder1.append(this.cZJ);
        stringBuilder1.append("\nGROUP BY  CASE WHEN T.nAccountID = 10013 THEN T.nSpareField1 ELSE T.nAccountID END --HAVING SALE_AMOUNT!=0 \n");
        stringBuilder.append(stringBuilder1.toString());
        if (b1 != this.cZT.size() - 1) {
          stringBuilder.append(" union all ");
        } else {
          stringBuilder.append(")GROUP BY  ACCOUNT_ID");
        } 
      } 
      try {
        this.cZW = 0.0D;
        cursor = this.cZS.rawQuery(stringBuilder.toString(), new String[0]);
        while (true) {
          if (cursor != null)
            try {
              if (cursor.moveToNext()) {
                Long long = Long.valueOf(cursor.getLong(3));
                null = cursor.getString(4);
                Double double1;
                Double double3;
                Double double2 = (double1 = (double3 = Double.valueOf(cursor.getDouble(0))).valueOf(cursor.getDouble(1))).valueOf(cursor.getDouble(2));
                if (this.cZU.and() != 0 || this.cZU.anc() != 0 || long.longValue() != 10006L)
                  this.cZW += double3.doubleValue(); 
                a a1 = a(long, null, double3);
                if (!paramBoolean) {
                  a(long, a1, false);
                } else {
                  if (double1.doubleValue() != 0.0D) {
                    a1.a(null, this.mContext.getString(2131627810), double1.doubleValue(), 0);
                    if (long.longValue() == 10006L) {
                      a1.c("fSaleMemberAmount", double1.doubleValue());
                    } else if (long.longValue() == 10008L) {
                      a1.c("fSpareField2", double1.doubleValue());
                    } else if (long.longValue() == 10007L) {
                      a1.c("fSpareField1", double1.doubleValue());
                    } else if (long.longValue() == 10010L) {
                      a1.c("fSpareField3", double1.doubleValue());
                    } else if (long.longValue() == 10011L) {
                      a1.c("fSpareField4", double1.doubleValue());
                    } else {
                      a1.c("fSaleCashAmount", double1.doubleValue());
                    } 
                  } 
                  if (double2.doubleValue() != 0.0D) {
                    a1.a(null, this.mContext.getString(2131627782), -double2.doubleValue(), 0);
                    if (a1.amm() == 10006L) {
                      a1.c("fSaleReturnMemberAmount", double2.doubleValue());
                    } else {
                      a1.c("fSaleReturnCashAmount", double2.doubleValue());
                    } 
                  } 
                  a1.cZr = true;
                } 
                a(a1);
                continue;
              } 
            } finally {
              Long long;
            }  
          return;
        } 
      } finally {
        stringBuilder = null;
        if (stringBuilder != null)
          stringBuilder.close(); 
      } 
    } 
  }
  
  public static int gb(int paramInt) { return bOf[paramInt % bOf.length]; }
  
  protected double[] AW() { return this.cZM ? amu() : amv(); }
  
  @NonNull
  public String AX() { return this.mContext.getString(2131627778); }
  
  public PrintContent.a a(long paramLong1, long paramLong2, ArrayList<HashMap<String, String>> paramArrayList) { return null; }
  
  @Nullable
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      double d;
      ArrayList arrayList1 = new ArrayList();
      if (this.cZR == 1) {
        str1 = this.mContext.getString(2131628408);
        d = this.daq[1];
      } else {
        str1 = this.mContext.getString(2131627795);
        d = this.daq[2];
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.mContext.getString(2131627778));
      stringBuilder2.append("_");
      stringBuilder2.append(str1);
      b(paramLong1, paramLong2, stringBuilder2.toString());
      arrayList1.add(new s.a(this.mContext.getString(2131627862), y(paramLong1, paramLong2)));
      arrayList1.add(new s.a(this.mContext.getString(2131627864), paramString1));
      ArrayList arrayList2 = new ArrayList();
      String str3 = this.mContext.getString(2131627797);
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(this.daq[0]);
      stringBuilder3.append("");
      arrayList2.add(new s.a(str3, stringBuilder3.toString()));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(d);
      stringBuilder1.append("");
      arrayList2.add(new s.a(str1, stringBuilder1.toString()));
      String str1 = bHV;
      String str2 = bzY;
      String str4 = bzY;
      return a(new s(this.mContext.getString(2131627778), this.mContext.getString(2131627778), arrayList1, arrayList2, paramArrayList, null, new String[] { str1, str2 }, new String[] { str4 }));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {
    this.cZU = paramt;
    this.daq = null;
    this.cZP = null;
    this.cZQ = null;
    this.bjv = null;
    this.aEK = null;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" t.nDateTime>=");
    this.mStartTime = paramt.ane();
    stringBuilder1.append(paramt.ane());
    stringBuilder1.append(" and t.nDateTime<=");
    this.bSc = paramt.anf();
    long l1 = this.mStartTime;
    long l2 = this.bSc;
    boolean bool = false;
    if (l1 > l2) {
      Toast.makeText(RootApplication.zv(), 2131629643, 0);
      return;
    } 
    if (!b.h(this.mStartTime, this.bSc)) {
      Toast.makeText(RootApplication.zv(), 2131629643, 0);
      return;
    } 
    stringBuilder1.append(paramt.anf());
    if (paramt.ang() > 0L) {
      stringBuilder1.append(" and t.nUserID=");
      stringBuilder1.append(paramt.ang());
    } 
    stringBuilder1.append(" and t.nShopID=");
    stringBuilder1.append(VC());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(stringBuilder1.toString());
    stringBuilder2.append(" and (t.sSpareField1 is null or t.sSpareField1!=1)");
    this.cZN = stringBuilder2.toString();
    stringBuilder1.append(" and (t.nDeletionFlag is null or t.nDeletionFlag!=1)");
    if (paramt.and() == 0 || paramt.and() == 1) {
      this.cZM = false;
      if (paramt.and() == 1)
        bool = true; 
      this.cZL = bool;
      if (paramt.anc() == 1) {
        this.cZK = " and t.nBPartnerID != 0 ";
        this.cZG = "CASE WHEN T.nBPartnerID NOTNULL THEN T.fAccountAmount*T.nMoneyDirection  END";
        this.cZH = "CASE WHEN T.nBPartnerID NOTNULL THEN T.fAccountAmount*(T.nMoneyDirection>0) END";
        this.cZI = "CASE WHEN T.nBPartnerID NOTNULL THEN T.fAccountAmount*(T.nMoneyDirection<0) END";
      } else if (paramt.anc() == 2) {
        this.cZK = " and t.nBPartnerID = 0 ";
        this.cZG = "CASE WHEN T.nBPartnerID ISNULL THEN T.fAccountAmount*T.nMoneyDirection END";
        this.cZH = "CASE WHEN T.nBPartnerID ISNULL THEN T.fAccountAmount*(T.nMoneyDirection>0)END";
        this.cZI = "CASE WHEN T.nBPartnerID ISNULL THEN T.fAccountAmount*(T.nMoneyDirection<0) END";
      } else {
        this.cZK = " and 1=1 ";
        this.cZG = "T.fAccountAmount*T.nMoneyDirection";
        this.cZH = "T.fAccountAmount*(T.nMoneyDirection>0)";
        this.cZI = "T.fAccountAmount*(T.nMoneyDirection<0)";
      } 
    } else {
      this.cZM = true;
    } 
    if (TextUtils.isEmpty(paramt.yq())) {
      this.cZJ = "";
    } else {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(" AND ORDER_TYPE = ");
      stringBuilder2.append(paramt.yq());
      stringBuilder2.append(" ");
      this.cZJ = stringBuilder2.toString();
    } 
    this.aJZ = stringBuilder1.toString();
    this.aOE = b.S(this.mStartTime);
    this.startYear = b.U(this.mStartTime);
    this.aOF = b.S(this.bSc);
    this.endYear = b.U(this.bSc);
    try {
      this.cZS = r(this.mStartTime, this.bSc);
      this.cZT = b.g(this.mStartTime, this.bSc);
      return;
    } catch (Exception paramt) {
      a.e(paramt);
      return;
    } 
  }
  
  public List<Pair<String, Double>> amA() { return a(Long.valueOf(0L), null, true); }
  
  public List<u> amC() {
    ArrayList arrayList = new ArrayList();
    arrayList.add(new u(-1L, this.mContext.getString(2131628072)));
    this.cZY.b(this.cZX.a(c.beq).b(new d(this, arrayList)));
    return arrayList;
  }
  
  @Nullable
  public ArrayList<a> amD() { return this.bjv; }
  
  public ArrayList<a> amE() { return this.cZC; }
  
  public double amr() {
    if (this.aEK == null) {
      null = new StringBuilder();
      null.append("select sum(case when t.nStcokDirection=300002 then t.fAmount else -t.fAmount end) from t_productdoc t where t.nProductTransacType=100067 and ");
      null.append(this.aJZ);
      str = null.toString();
      try {
        Cursor cursor = Vq().rawQuery(str, null);
      } catch (Exception str) {
        a.e(str);
        str = null;
      } 
      str.moveToNext();
      this.aEK = Double.valueOf(str.getDouble(0));
      str.close();
    } 
    return this.aEK.doubleValue();
  }
  
  @Size
  public double[] amv() {
    int m;
    if (this.cZT == null || this.cZS == null)
      return null; 
    StringBuilder stringBuilder2 = new StringBuilder("select sum(sum0),sum(sum1) from (");
    if (this.cZU.anc() == 1) {
      str = " t.nBPartnerID !=0 and";
    } else if (this.cZU.anc() == 2) {
      str = " t.nBPartnerID ==0 and";
    } else {
      String str;
      str = "";
    } 
    int k;
    for (k = 0; k < this.cZT.size(); k++) {
      String str = (String)this.cZT.get(k);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select sum(case when nSpareField3=2 then 0  when nProductTransacType=100001 then nProductQty when nProductTransacType=100015 then -nProductQty else 0 end) as sum0,sum(case when nStcokDirection=300002 then fReceived else -fReceived end) as sum1 from ");
      stringBuilder.append(str);
      stringBuilder.append(".t_productdoc t where ");
      stringBuilder.append(str);
      stringBuilder.append(" nProductTransacType in(100001,100015,100045,100060) and ");
      stringBuilder.append(this.aJZ);
      stringBuilder2.append(stringBuilder.toString());
      if (k != this.cZT.size() - 1) {
        stringBuilder2.append(" union all ");
      } else {
        stringBuilder2.append(")");
      } 
    } 
    null = new StringBuilder();
    null.append(getClass().getSimpleName());
    null.append("querySumValue sql--");
    null.append(stringBuilder2.toString());
    b.ct(null.toString());
    null = this.cZS.rawQuery(stringBuilder2.toString(), new String[0]);
    null.moveToFirst();
    double d3 = null.getDouble(0);
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("总数量-->");
    stringBuilder2.append(d3);
    b.ct(stringBuilder2.toString());
    double d1 = this.cZW;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("销售总额-->");
    stringBuilder2.append(d1);
    b.ct(stringBuilder2.toString());
    null.close();
    StringBuilder stringBuilder1 = new StringBuilder("SELECT distinct sOrderNo FROM(");
    for (k = 0; k < this.cZT.size(); k++) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("select distinct sOrderNo\nfrom ");
      stringBuilder2.append((String)this.cZT.get(k));
      stringBuilder2.append(".t_productdoc t\nwhere t.nProductTransacType in(100001,100015,100045,100060,100066,100068) and \n");
      stringBuilder2.append(this.aJZ);
      stringBuilder2.append("");
      stringBuilder1.append(stringBuilder2.toString());
      if (k != this.cZT.size() - 1) {
        stringBuilder1.append(" union ");
      } else {
        stringBuilder1.append(") ");
      } 
    } 
    Cursor cursor = this.cZS.rawQuery(stringBuilder1.toString(), new String[0]);
    int n = cursor.getCount();
    if (this.cZU.anc() != 0) {
      stringBuilder2 = new StringBuilder();
      for (k = 0; k < this.cZT.size(); k++) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT DISTINCT sText FROM ");
        stringBuilder.append((String)this.cZT.get(k));
        stringBuilder.append(".T_BPARTNER_CHARGEDOC WHERE sText NOTNULL AND nDateTime >=");
        stringBuilder.append(this.cZU.ane());
        stringBuilder.append(" AND nDateTime <= ");
        stringBuilder.append(this.cZU.anf());
        stringBuilder.append(" AND (sSpareField1 ISNULL OR sSpareField1 != 1)  AND sText notnull\n AND sText != '' \n AND nShopID = ");
        stringBuilder.append(VC());
        stringBuilder2.append(stringBuilder.toString());
        if (k != this.cZT.size() - 1)
          stringBuilder2.append(" union "); 
      } 
      Cursor cursor1 = this.cZS.rawQuery(stringBuilder2.toString(), new String[0]);
      if (cursor1 != null) {
        k = cursor1.getCount();
      } else {
        k = 0;
      } 
      cursor1.close();
    } else {
      k = 0;
    } 
    if (this.cZU.anc() == 1) {
      m = k;
    } else {
      m = n;
      if (this.cZU.anc() == 2)
        m = n - k; 
    } 
    cursor.close();
    if (this.cZQ != null)
      double d = this.cZQ.cZk; 
    if (this.cZP != null)
      double d = this.cZP.cZk; 
    double d2 = d1;
    if (!this.cZM) {
      d2 = d1;
      if (!this.cZL) {
        null = amB();
        Cursor cursor1 = this.cZS.rawQuery(null.toString(), new String[0]);
        while (cursor1 != null && cursor1.moveToNext())
          d1 += cursor1.getDouble(0); 
        cursor1.close();
        d2 = d1;
      } 
    } 
    this.cZV = new double[] { d3, m, d2 };
    return this.cZV;
  }
  
  public double[] amw() { return super.amw(); }
  
  public boolean amx() { return (this.cZP != null || this.cZQ != null); }
  
  public ArrayList<a> amy() { return gz(false); }
  
  public List<Pair<String, Double>> amz() {
    ArrayList arrayList = new ArrayList();
    if (this.cZS != null) {
      if (this.cZT == null)
        return arrayList; 
      null = new StringBuilder();
      null.append("SELECT SUM(VIP_RECHARGE) - SUM(ifnull(GIFT_AMOUNT,0)) '");
      null.append(this.mContext.getString(2131630431));
      null.append("',SUM(GIFT_AMOUNT) '");
      null.append(this.mContext.getString(2131625720));
      null.append("',SUM(CONSUMPTION_AMOUNT) '");
      null.append(this.mContext.getString(2131625721));
      null.append("', --SUM(POINT_DEBUCTION) '");
      null.append(this.mContext.getString(2131625744));
      null.append("',\nSUM(AMOUNT_ADJUST) '");
      null.append(this.mContext.getString(2131628481));
      null.append("' FROM(");
      StringBuilder stringBuilder = new StringBuilder(null.toString());
      byte b1;
      for (b1 = 0; b1 < this.cZT.size(); b1++) {
        String str = (String)this.cZT.get(b1);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("SELECT\n  sum(CASE\n      WHEN nChargeType = 370004 AND nSpareField5 = 1 THEN -fChargeAmount --撤销充值\n      WHEN nChargeType = 370004 AND (nSpareField5 = 0 OR nSpareField5 ISNULL) THEN fChargeAmount  ELSE 0 END ) VIP_RECHARGE,  sum(CASE WHEN fReceived != fChargeAmount AND nChargeType=370004 THEN abs(fChargeAmount - fReceived) ELSE 0 END ) GIFT_AMOUNT,\n  abs(sum(CASE WHEN nChargeType = 370005 THEN fChargeAmount ELSE 0 END )) CONSUMPTION_AMOUNT,\n--  sum(CASE WHEN nChargeType = 370008 AND nSpareField1 < 0  THEN fChargeAmount --销售使用了积分抵扣\n--      WHEN nChargeType = 370008 AND nSpareField5 > 0 THEN -fChargeAmount --有退货撤销积分抵扣\n--     ELSE 0 END ) POINT_DEBUCTION,\nsum(case when nChargeType = 370007 then fChargeAmount ELSE 0 end ) AMOUNT_ADJUST  --充值调额\n FROM ");
        stringBuilder1.append(str);
        stringBuilder1.append(".T_BPARTNER_CHARGEDOC\nWHERE\n(sSpareField1 ISNULL OR sSpareField1 != 1)\nAND nDateTime >= ");
        stringBuilder1.append(this.cZU.ane());
        stringBuilder1.append("\nAND nDateTime <= ");
        stringBuilder1.append(this.cZU.anf());
        stringBuilder1.append("\nAND nShopID = ");
        stringBuilder1.append(VC());
        stringBuilder1.append("\n");
        if (this.cZU.ang() > 0L) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("  AND nUserID = ");
          stringBuilder2.append(this.cZU.ang());
          String str1 = stringBuilder2.toString();
        } else {
          str = "";
        } 
        stringBuilder1.append(str);
        stringBuilder.append(stringBuilder1.toString());
        if (b1 != this.cZT.size() - 1) {
          stringBuilder.append(" UNION ALL ");
        } else {
          stringBuilder.append(")");
        } 
      } 
      Cursor cursor = this.cZS.rawQuery(stringBuilder.toString(), new String[0]);
      while (cursor != null) {
        try {
          if (cursor.moveToNext()) {
            int k = cursor.getColumnCount();
            for (b1 = 0; b1 < k; b1++)
              arrayList.add(new Pair(cursor.getColumnName(b1), Double.valueOf(cursor.getDouble(b1)))); 
            continue;
          } 
          break;
        } finally {
          if (cursor != null)
            cursor.close(); 
        } 
      } 
      if (cursor != null)
        cursor.close(); 
      return arrayList;
    } 
    return arrayList;
  }
  
  public ArrayList<HashMap<String, String>> aw(ArrayList<a> paramArrayList) {
    ArrayList arrayList = new ArrayList();
    for (a a1 : paramArrayList) {
      HashMap hashMap = new HashMap();
      hashMap.put(bHV, a1.Yx);
      hashMap.put(bzY, a1.cZl);
      arrayList.add(hashMap);
    } 
    return arrayList;
  }
  
  public void clear() { this.cZY.clear(); }
  
  public ArrayList<a> gz(boolean paramBoolean) {
    this.bjv = new ArrayList();
    this.cZC = new ArrayList();
    if (this.cZM) {
      gA(true);
    } else {
      gB(paramBoolean);
    } 
    return this.bjv;
  }
  
  public int jH(int paramInt) { return this.cZO[paramInt % this.cZO.length]; }
  
  public void jI(int paramInt) {
    this.cZR = paramInt;
    if (paramInt == 1) {
      if (this.cZQ != null && this.bjv.indexOf(this.cZQ) != -1)
        this.bjv.remove(this.cZQ); 
      if (this.cZP != null && this.bjv.indexOf(this.cZP) == -1) {
        this.bjv.add(0, this.cZP);
        return;
      } 
    } else if (paramInt == 2) {
      if (this.cZP != null && this.bjv.indexOf(this.cZP) != -1)
        this.bjv.remove(this.cZP); 
      if (this.cZQ != null && this.bjv.indexOf(this.cZQ) == -1)
        this.bjv.add(0, this.cZQ); 
    } 
  }
  
  @Deprecated
  public ArrayList<HashMap<String, String>> zJ() { return null; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */