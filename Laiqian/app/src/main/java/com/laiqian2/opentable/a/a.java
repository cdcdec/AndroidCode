package com.laiqian.opentable.a;

import android.content.Context;
import android.database.Cursor;
import com.laiqian.models.as;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.t;
import com.laiqian.util.by;
import java.util.ArrayList;

public class a extends as {
  public a(Context paramContext) {
    super(paramContext);
    gk(5);
  }
  
  private boolean h(String paramString, long paramLong) {
    if (paramString == null)
      return false; 
    if (paramLong > 0L) {
      j(paramString, paramLong);
    } else {
      ii(paramString);
    } 
    Cursor cursor = VM();
    if (cursor == null)
      return true; 
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
  }
  
  public boolean O(long paramLong) {
    String str;
    bF(paramLong);
    am(this.bSR, this.bSU);
    boolean bool = delete();
    if (bool) {
      str = this.mContext.getString(R.string.pos_opentable_area_delete_success);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("");
      str = String.format(stringBuilder.toString(), new Object[] { hQ("sFieldName") });
    } else {
      str = this.mContext.getString(R.string.prodcut_type_delete_fail);
    } 
    hP(str);
    return bool;
  }
  
  protected boolean QL() {
    boolean bool;
    if (UA()) {
      bool = Wc();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getString(R.string.pos_area_name_title));
      stringBuilder.append(" ");
      stringBuilder.append(VZ());
      stringBuilder.append(" ");
      stringBuilder.append(this.mContext.getString(R.string.ud_createMsg2));
      hP(stringBuilder.toString());
    } else {
      bool = false;
    } 
    UD();
    return bool;
  }
  
  protected boolean UA() {
    if (h(Wa(), -1L)) {
      hP(this.mContext.getString(R.string.pos_product_exit));
      return false;
    } 
    return true;
  }
  
  protected boolean UB() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  public ArrayList<a> Xo() {
    ArrayList arrayList = new ArrayList();
    hY("_id,sFieldName");
    ia(" sDefaultValue desc ");
    null = new StringBuilder();
    null.append(" nFieldType=82 and sIsActive='Y' and nShopID=");
    null.append(VC());
    hZ(null.toString());
    Cursor cursor = VM();
    while (cursor.moveToNext())
      arrayList.add(new a(by.parseLong(cursor.getString(0)), cursor.getString(1))); 
    cursor.close();
    return arrayList;
  }
  
  public boolean bl(long paramLong) {
    bE(paramLong);
    boolean bool2 = UB();
    boolean bool1 = false;
    if (bool2) {
      String str;
      if (h(Wa(), paramLong)) {
        hP(this.mContext.getString(R.string.pos_product_exit));
        return false;
      } 
      bE(paramLong);
      bool1 = update();
      if (bool1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mContext.getString(R.string.pos_area_name_title));
        stringBuilder.append(" ");
        stringBuilder.append(VZ());
        stringBuilder.append(" ");
        stringBuilder.append(this.mContext.getString(R.string.ud_updateMsg2));
        str = stringBuilder.toString();
      } else {
        null = new StringBuilder();
        null.append(this.mContext.getString(R.string.pos_area_name_title));
        null.append(" ");
        null.append(VZ());
        null.append(" ");
        null.append(this.mContext.getString(R.string.ud_updateMsg3));
        str = null.toString();
      } 
      hP(str);
    } 
    UE();
    return bool1;
  }
  
  public a iR(String paramString) {
    hY("_id,sFieldName");
    ia(" sDefaultValue desc ");
    null = new StringBuilder();
    null.append(" nFieldType=82 and sIsActive='Y' and nShopID=");
    null.append(VC());
    null.append(" and _id=");
    null.append(paramString);
    hZ(null.toString());
    Cursor cursor = VM();
    if (cursor.moveToFirst()) {
      a a1 = new a(by.parseLong(cursor.getString(0)), cursor.getString(1));
    } else {
      paramString = null;
    } 
    cursor.close();
    return paramString;
  }
  
  public boolean iS(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    String str = stringBuilder.toString();
    am("_id", str);
    am("sFieldName", paramString);
    am("sFieldValue", str);
    am("nFieldType", "82");
    am("nStringID", "1");
    return QL();
  }
  
  public boolean t(long paramLong, String paramString) {
    am("sFieldName", paramString);
    return bl(paramLong);
  }
  
  public static class a extends Thread {
    private t.f bMK;
    
    private int bTo;
    
    private String bYu;
    
    private Context mContext;
    
    public a(Context param1Context, String param1String, int param1Int, t.f param1f) {
      this.mContext = param1Context;
      this.bYu = param1String;
      this.bTo = param1Int;
      this.bMK = param1f;
    }
    
    public void run() { // Byte code:
      //   0: aload_0
      //   1: invokespecial run : ()V
      //   4: new com/laiqian/online/OnlineSyncRequest$a
      //   7: dup
      //   8: invokespecial <init> : ()V
      //   11: astore_1
      //   12: new com/laiqian/models/at
      //   15: dup
      //   16: aload_0
      //   17: getfield mContext : Landroid/content/Context;
      //   20: invokespecial <init> : (Landroid/content/Context;)V
      //   23: astore_3
      //   24: goto -> 34
      //   27: astore_2
      //   28: aload_2
      //   29: invokestatic e : (Ljava/lang/Throwable;)V
      //   32: aconst_null
      //   33: astore_3
      //   34: aload_1
      //   35: aload_3
      //   36: aload_0
      //   37: getfield bYu : Ljava/lang/String;
      //   40: invokevirtual gZ : (Ljava/lang/String;)Ljava/util/ArrayList;
      //   43: aload_0
      //   44: getfield bTo : I
      //   47: invokevirtual a : (Ljava/util/Collection;I)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   50: pop
      //   51: aload_1
      //   52: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   55: invokevirtual Ea : ()Ljava/lang/String;
      //   58: invokevirtual iM : (Ljava/lang/String;)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   61: pop
      //   62: aload_1
      //   63: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   66: invokevirtual atr : ()Ljava/lang/String;
      //   69: invokevirtual iN : (Ljava/lang/String;)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   72: pop
      //   73: aload_1
      //   74: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   77: invokevirtual Tx : ()Ljava/lang/String;
      //   80: invokestatic parseLong : (Ljava/lang/String;)J
      //   83: invokevirtual bV : (J)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   86: pop
      //   87: getstatic com/laiqian/online/f.bXQ : Lcom/laiqian/online/f;
      //   90: astore_2
      //   91: aload_2
      //   92: aload_1
      //   93: invokevirtual Xj : ()Lcom/laiqian/online/OnlineSyncRequest;
      //   96: invokevirtual b : (Lcom/laiqian/online/OnlineSyncRequest;)Lcom/laiqian/online/h;
      //   99: astore_2
      //   100: aload_2
      //   101: astore_1
      //   102: aload_2
      //   103: getfield bXV : Z
      //   106: ifeq -> 129
      //   109: aload_2
      //   110: astore_1
      //   111: ldc '实时同步成功'
      //   113: invokestatic println : (Ljava/lang/Object;)V
      //   116: aload_2
      //   117: astore_1
      //   118: aload_3
      //   119: aload_0
      //   120: getfield bYu : Ljava/lang/String;
      //   123: invokevirtual ip : (Ljava/lang/String;)V
      //   126: goto -> 172
      //   129: aload_2
      //   130: astore_1
      //   131: new java/lang/StringBuilder
      //   134: dup
      //   135: invokespecial <init> : ()V
      //   138: astore #4
      //   140: aload_2
      //   141: astore_1
      //   142: aload #4
      //   144: ldc '实时同步失败'
      //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   149: pop
      //   150: aload_2
      //   151: astore_1
      //   152: aload #4
      //   154: aload_2
      //   155: getfield message : Ljava/lang/String;
      //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   161: pop
      //   162: aload_2
      //   163: astore_1
      //   164: aload #4
      //   166: invokevirtual toString : ()Ljava/lang/String;
      //   169: invokestatic println : (Ljava/lang/Object;)V
      //   172: aload_3
      //   173: invokevirtual close : ()V
      //   176: aload_2
      //   177: ifnonnull -> 191
      //   180: aload_0
      //   181: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   184: iconst_0
      //   185: invokeinterface dp : (Z)V
      //   190: return
      //   191: aload_0
      //   192: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   195: aload_2
      //   196: getfield bXV : Z
      //   199: invokeinterface dp : (Z)V
      //   204: return
      //   205: aload_1
      //   206: invokestatic e : (Ljava/lang/Throwable;)V
      //   209: return
      //   210: astore #4
      //   212: goto -> 225
      //   215: astore_2
      //   216: aconst_null
      //   217: astore_1
      //   218: goto -> 348
      //   221: astore #4
      //   223: aconst_null
      //   224: astore_2
      //   225: aload_2
      //   226: astore_1
      //   227: invokestatic awP : ()Lcom/laiqian/util/logger/h;
      //   230: pop
      //   231: aload_2
      //   232: astore_1
      //   233: new com/laiqian/util/logger/d
      //   236: dup
      //   237: ldc com/laiqian/opentable/a/a
      //   239: invokevirtual getSimpleName : ()Ljava/lang/String;
      //   242: ldc 'onlineSync'
      //   244: ldc '请求实时同步失败--'
      //   246: aload #4
      //   248: invokevirtual getMessage : ()Ljava/lang/String;
      //   251: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   254: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
      //   257: getstatic com/laiqian/util/logger/h$b.dHD : Lcom/laiqian/util/logger/h$b;
      //   260: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
      //   263: aload_2
      //   264: astore_1
      //   265: new java/lang/StringBuilder
      //   268: dup
      //   269: invokespecial <init> : ()V
      //   272: astore #5
      //   274: aload_2
      //   275: astore_1
      //   276: aload #5
      //   278: ldc '请求实时同步失败'
      //   280: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   283: pop
      //   284: aload_2
      //   285: astore_1
      //   286: aload #5
      //   288: aload #4
      //   290: invokevirtual getMessage : ()Ljava/lang/String;
      //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   296: pop
      //   297: aload_2
      //   298: astore_1
      //   299: aload #5
      //   301: invokevirtual toString : ()Ljava/lang/String;
      //   304: invokestatic println : (Ljava/lang/Object;)V
      //   307: aload_2
      //   308: astore_1
      //   309: aload #4
      //   311: invokestatic e : (Ljava/lang/Throwable;)V
      //   314: aload_3
      //   315: invokevirtual close : ()V
      //   318: aload_2
      //   319: ifnonnull -> 333
      //   322: aload_0
      //   323: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   326: iconst_0
      //   327: invokeinterface dp : (Z)V
      //   332: return
      //   333: aload_0
      //   334: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   337: aload_2
      //   338: getfield bXV : Z
      //   341: invokeinterface dp : (Z)V
      //   346: return
      //   347: astore_2
      //   348: aload_3
      //   349: invokevirtual close : ()V
      //   352: aload_1
      //   353: ifnonnull -> 369
      //   356: aload_0
      //   357: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   360: iconst_0
      //   361: invokeinterface dp : (Z)V
      //   366: goto -> 389
      //   369: aload_0
      //   370: getfield bMK : Lcom/laiqian/opentable/common/t$f;
      //   373: aload_1
      //   374: getfield bXV : Z
      //   377: invokeinterface dp : (Z)V
      //   382: goto -> 389
      //   385: aload_1
      //   386: invokestatic e : (Ljava/lang/Throwable;)V
      //   389: aload_2
      //   390: athrow
      //   391: astore_1
      //   392: goto -> 205
      //   395: astore_1
      //   396: goto -> 385
      // Exception table:
      //   from	to	target	type
      //   12	24	27	java/lang/Exception
      //   91	100	221	java/lang/Exception
      //   91	100	215	finally
      //   102	109	210	java/lang/Exception
      //   102	109	347	finally
      //   111	116	210	java/lang/Exception
      //   111	116	347	finally
      //   118	126	210	java/lang/Exception
      //   118	126	347	finally
      //   131	140	210	java/lang/Exception
      //   131	140	347	finally
      //   142	150	210	java/lang/Exception
      //   142	150	347	finally
      //   152	162	210	java/lang/Exception
      //   152	162	347	finally
      //   164	172	210	java/lang/Exception
      //   164	172	347	finally
      //   180	190	391	com/laiqian/opentable/common/m
      //   191	204	391	com/laiqian/opentable/common/m
      //   227	231	347	finally
      //   233	263	347	finally
      //   265	274	347	finally
      //   276	284	347	finally
      //   286	297	347	finally
      //   299	307	347	finally
      //   309	314	347	finally
      //   322	332	391	com/laiqian/opentable/common/m
      //   333	346	391	com/laiqian/opentable/common/m
      //   356	366	395	com/laiqian/opentable/common/m
      //   369	382	395	com/laiqian/opentable/common/m }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */