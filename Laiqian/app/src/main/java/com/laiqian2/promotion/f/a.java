package com.laiqian.promotion.f;

import android.content.Context;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.DateSelectEntity;
import com.laiqian.entity.ac;
import com.laiqian.entity.ae;
import com.laiqian.entity.ag;
import com.laiqian.entity.ak;
import com.laiqian.entity.w;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.promotion.R;
import com.laiqian.util.av;
import com.laiqian.util.n;
import com.laiqian.util.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
  public static ac a(String paramString, Context paramContext, int paramInt) {
    null = t.a(t.dFf, 100);
    DateSelectEntity.a a1 = (new DateSelectEntity.a()).ep(0).cU(null).af(t.lu(100)).d(new StringBuilder("1000000000000000000000000000000")).c(new StringBuilder("0000000")).ad(System.currentTimeMillis());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(System.currentTimeMillis());
    stringBuilder1.append("");
    DateSelectEntity dateSelectEntity = a1.cS(t.b(stringBuilder1.toString(), t.dFc)).ae(t.lu(100)).cT(null).EE();
    av av = new av(paramContext);
    null = new StringBuilder();
    null.append(av.Tx());
    null.append(111);
    w w = null.toString();
    av.close();
    if (RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(w);
      stringBuilder.append("002");
      w = new w(n.parseLong(stringBuilder.toString()), paramContext.getString(R.string.pos_people_type_ordinary_customers));
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(w);
      stringBuilder.append("003");
      w = new w(n.parseLong(stringBuilder.toString()), paramContext.getString(R.string.pos_people_type_not_limit));
    } 
    ag ag = (new ag.a()).eC(0).d(new long[0]).HE();
    ae ae = (new ae.a()).b(new long[0]).Hx();
    ac.a a2 = new ac.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append(paramContext.getString(R.string.pos_promotion_activity));
    return a2.dl(stringBuilder2.toString()).b(w).b(ag).b(ae).dm(paramContext.getString(R.string.pos_people_type_not_limit)).r(new ArrayList()).b(dateSelectEntity).ex(0).ey(paramInt).Hq();
  }
  
  public static String a(DateSelectEntity paramDateSelectEntity, Context paramContext) {
    String str = "";
    if (paramDateSelectEntity.Ev() == 0)
      return paramContext.getString(R.string.date_setting_type_not_limit); 
    if (paramDateSelectEntity.Ev() == 1)
      return String.format("%s %s %s", new Object[] { paramDateSelectEntity.Ex(), paramContext.getString(R.string.pos_date_end), paramDateSelectEntity.Ez() }); 
    if (paramDateSelectEntity.Ev() == 2)
      return String.format("%s %s~%s", new Object[] { paramContext.getString(R.string.date_dialog_type_every_day_title), paramDateSelectEntity.Ex(), paramDateSelectEntity.Ez() }); 
    if (paramDateSelectEntity.Ev() == 3) {
      StringBuilder stringBuilder = new StringBuilder();
      String[] arrayOfString = paramContext.getResources().getStringArray(R.array.date_week_text);
      for (byte b = 0; b < arrayOfString.length; b++) {
        if ('1' == paramDateSelectEntity.EC().charAt(b)) {
          stringBuilder.append("、");
          stringBuilder.append(arrayOfString[b]);
        } 
      } 
      stringBuilder.replace(0, 1, "");
      return String.format("%s %s %s~%s", new Object[] { paramContext.getString(R.string.date_dialog_type_weekly_title), stringBuilder.toString(), paramDateSelectEntity.Ex(), paramDateSelectEntity.Ez() });
    } 
    if (paramDateSelectEntity.Ev() == 4) {
      String str1 = "1";
      char[] arrayOfChar = paramDateSelectEntity.ED().toString().toCharArray();
      byte b = 0;
      while (true) {
        str = str1;
        if (b < arrayOfChar.length) {
          if (arrayOfChar[b] == '1') {
            str = String.valueOf(b + true);
            break;
          } 
          b++;
          continue;
        } 
        break;
      } 
      str = String.format("%s %s %s %s~%s", new Object[] { paramContext.getString(R.string.date_dialog_type_per_month_title), str, paramContext.getString(R.string.pos_date_month_day), paramDateSelectEntity.Ex(), paramDateSelectEntity.Ez() });
    } 
    return str;
  }
  
  public static boolean a(ArrayList<ProductTypeEntity> paramArrayList1, ArrayList<ProductTypeEntity> paramArrayList2, ArrayList<ProductTypeEntity> paramArrayList3, ArrayList<ProductTypeEntity> paramArrayList4) {
    if (paramArrayList1 != null) {
      int k;
      if (paramArrayList2 == null)
        return false; 
      int i = paramArrayList1.size();
      int j = paramArrayList2.size();
      if (i == 0 && j == 0)
        return false; 
      Iterator iterator = paramArrayList1.iterator();
      byte b = 0;
      while (true) {
        k = b;
        if (iterator.hasNext()) {
          ProductTypeEntity productTypeEntity = (ProductTypeEntity)iterator.next();
          if (paramArrayList3 != null && paramArrayList2.size() == 0) {
            paramArrayList3.addAll(paramArrayList1);
            k = 1;
            break;
          } 
          Iterator iterator1 = paramArrayList2.iterator();
          i = 0;
          while (iterator1.hasNext()) {
            ProductTypeEntity productTypeEntity1 = (ProductTypeEntity)iterator1.next();
            j = i + 1;
            if (productTypeEntity.AR() == productTypeEntity1.AR())
              break; 
            i = j;
            if (j == paramArrayList2.size()) {
              if (paramArrayList3 != null)
                paramArrayList3.add(productTypeEntity); 
              b = 1;
              i = j;
            } 
          } 
          continue;
        } 
        break;
      } 
      for (ProductTypeEntity productTypeEntity : paramArrayList2) {
        if (paramArrayList4 != null && paramArrayList1.size() == 0) {
          paramArrayList4.addAll(paramArrayList2);
          return true;
        } 
        Iterator iterator1 = paramArrayList1.iterator();
        b = k;
        i = 0;
        while (iterator1.hasNext()) {
          ProductTypeEntity productTypeEntity1 = (ProductTypeEntity)iterator1.next();
          j = i + 1;
          if (productTypeEntity1.AR() == productTypeEntity.AR())
            break; 
          i = j;
          if (j == paramArrayList1.size()) {
            if (paramArrayList4 != null)
              paramArrayList4.add(productTypeEntity); 
            b = 1;
            i = j;
          } 
        } 
        k = b;
      } 
      return k;
    } 
    return false;
  }
  
  public static boolean a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, List<Long> paramList1, List<Long> paramList2, List<Long> paramList3) {
    if (paramArrayOfLong1 != null) {
      if (paramArrayOfLong2 == null)
        return false; 
      int j = paramArrayOfLong1.length;
      int i = paramArrayOfLong2.length;
      int k = paramArrayOfLong2.length;
      byte b = 0;
      boolean bool = false;
      while (b < k) {
        long l = paramArrayOfLong2[b];
        if (j == 0) {
          paramList2.add(Long.valueOf(l));
          bool = true;
        } else {
          byte b1;
          for (b1 = 0; b1 < paramArrayOfLong1.length; b1++) {
            if (l == paramArrayOfLong1[b1]) {
              paramList3.add(Long.valueOf(l));
              break;
            } 
            if (b1 == j - 1) {
              paramList2.add(Long.valueOf(l));
              bool = true;
            } 
          } 
        } 
        b++;
      } 
      j = paramArrayOfLong1.length;
      for (b = 0; b < j; b++) {
        long l = paramArrayOfLong1[b];
        if (i == 0) {
          paramList1.add(Long.valueOf(l));
          bool = true;
        } else {
          byte b1;
          for (b1 = 0; b1 < paramArrayOfLong2.length && l != paramArrayOfLong2[b1]; b1++) {
            if (b1 == i - 1) {
              paramList1.add(Long.valueOf(l));
              bool = true;
            } 
          } 
        } 
      } 
      return bool;
    } 
    return false;
  }
  
  public static List<ak> bt(Context paramContext) { // Byte code:
    //   0: aload_0
    //   1: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   4: ldc_w 'promotions.json'
    //   7: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: ldc_w java/util/List
    //   16: iconst_1
    //   17: anewarray java/lang/reflect/Type
    //   20: dup
    //   21: iconst_0
    //   22: ldc_w com/laiqian/entity/ak
    //   25: aastore
    //   26: invokestatic a : (Ljava/lang/reflect/Type;[Ljava/lang/reflect/Type;)Ljava/lang/reflect/ParameterizedType;
    //   29: astore_2
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: invokestatic v : (Ljava/io/InputStream;)Lc/z;
    //   36: invokestatic c : (Lc/z;)Lc/h;
    //   39: invokestatic b : (Lc/h;)Lcom/squareup/moshi/aa;
    //   42: astore_3
    //   43: aload_1
    //   44: astore_0
    //   45: aload_3
    //   46: iconst_1
    //   47: invokevirtual setLenient : (Z)V
    //   50: aload_1
    //   51: astore_0
    //   52: getstatic com/laiqian/i/d.aXE : Lcom/squareup/moshi/am;
    //   55: aload_2
    //   56: invokevirtual u : (Ljava/lang/reflect/Type;)Lcom/squareup/moshi/t;
    //   59: aload_3
    //   60: invokevirtual b : (Lcom/squareup/moshi/aa;)Ljava/lang/Object;
    //   63: checkcast java/util/List
    //   66: astore_2
    //   67: aload_1
    //   68: ifnull -> 82
    //   71: aload_1
    //   72: invokevirtual close : ()V
    //   75: aload_2
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: invokestatic e : (Ljava/lang/Throwable;)V
    //   82: aload_2
    //   83: areturn
    //   84: astore_2
    //   85: goto -> 97
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_1
    //   91: goto -> 135
    //   94: astore_2
    //   95: aconst_null
    //   96: astore_1
    //   97: aload_1
    //   98: astore_0
    //   99: aload_2
    //   100: invokestatic e : (Ljava/lang/Throwable;)V
    //   103: aload_1
    //   104: astore_0
    //   105: new java/util/ArrayList
    //   108: dup
    //   109: invokespecial <init> : ()V
    //   112: astore_2
    //   113: aload_1
    //   114: ifnull -> 128
    //   117: aload_1
    //   118: invokevirtual close : ()V
    //   121: aload_2
    //   122: areturn
    //   123: astore_0
    //   124: aload_0
    //   125: invokestatic e : (Ljava/lang/Throwable;)V
    //   128: aload_2
    //   129: areturn
    //   130: astore_2
    //   131: aload_0
    //   132: astore_1
    //   133: aload_2
    //   134: astore_0
    //   135: aload_1
    //   136: ifnull -> 151
    //   139: aload_1
    //   140: invokevirtual close : ()V
    //   143: goto -> 151
    //   146: astore_1
    //   147: aload_1
    //   148: invokestatic e : (Ljava/lang/Throwable;)V
    //   151: aload_0
    //   152: athrow
    // Exception table:
    //   from	to	target	type
    //   0	11	94	java/lang/Exception
    //   0	11	88	finally
    //   13	30	84	java/lang/Exception
    //   13	30	130	finally
    //   32	43	84	java/lang/Exception
    //   32	43	130	finally
    //   45	50	84	java/lang/Exception
    //   45	50	130	finally
    //   52	67	84	java/lang/Exception
    //   52	67	130	finally
    //   71	75	77	java/io/IOException
    //   99	103	130	finally
    //   105	113	130	finally
    //   117	121	123	java/io/IOException
    //   139	143	146	java/io/IOException }
  
  public static boolean e(DateSelectEntity paramDateSelectEntity) {
    int i = paramDateSelectEntity.Ev();
    long l = System.currentTimeMillis();
    if (i == 0)
      return true; 
    if (2 == i || 3 == i || 4 == i)
      l = t.asH(); 
    if (l >= paramDateSelectEntity.Ew()) {
      if (l > paramDateSelectEntity.Ey())
        return false; 
      if (4 == i) {
        String str1;
        String str2 = "1";
        char[] arrayOfChar = paramDateSelectEntity.ED().toString().toCharArray();
        byte b = 0;
        while (true) {
          str1 = str2;
          if (b < arrayOfChar.length) {
            if (arrayOfChar[b] == '1') {
              str1 = String.valueOf(b + true);
              break;
            } 
            b++;
            continue;
          } 
          break;
        } 
        if (!t.asJ().equals(str1))
          return false; 
      } 
      return !(3 == i && '1' != paramDateSelectEntity.EC().charAt(t.asK() - 1));
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */