package com.laiqian.product;

import android.view.View;
import android.widget.AdapterView;

class dh implements AdapterView.OnItemClickListener {
  dh(ProductList paramProductList) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) { // Byte code:
    //   0: aload_1
    //   1: iload_3
    //   2: invokevirtual getItemAtPosition : (I)Ljava/lang/Object;
    //   5: checkcast java/util/HashMap
    //   8: astore_1
    //   9: iconst_1
    //   10: istore #7
    //   12: aload_1
    //   13: ifnonnull -> 75
    //   16: iload_3
    //   17: aload_0
    //   18: getfield cRN : Lcom/laiqian/product/ProductList;
    //   21: invokestatic a : (Lcom/laiqian/product/ProductList;)Lcom/laiqian/product/ProductList$b;
    //   24: invokevirtual YO : ()I
    //   27: if_icmpne -> 69
    //   30: aload_0
    //   31: getfield cRN : Lcom/laiqian/product/ProductList;
    //   34: aconst_null
    //   35: invokestatic b : (Lcom/laiqian/product/ProductList;Ljava/lang/String;)Ljava/lang/String;
    //   38: pop
    //   39: aload_0
    //   40: getfield cRN : Lcom/laiqian/product/ProductList;
    //   43: aconst_null
    //   44: invokestatic a : (Lcom/laiqian/product/ProductList;Ljava/lang/String;)Ljava/lang/String;
    //   47: pop
    //   48: aload_0
    //   49: getfield cRN : Lcom/laiqian/product/ProductList;
    //   52: iconst_0
    //   53: invokestatic b : (Lcom/laiqian/product/ProductList;Z)Z
    //   56: pop
    //   57: aload_0
    //   58: getfield cRN : Lcom/laiqian/product/ProductList;
    //   61: iconst_0
    //   62: invokestatic b : (Lcom/laiqian/product/ProductList;I)I
    //   65: pop
    //   66: goto -> 137
    //   69: iconst_0
    //   70: istore #6
    //   72: goto -> 140
    //   75: aload_0
    //   76: getfield cRN : Lcom/laiqian/product/ProductList;
    //   79: aload_1
    //   80: ldc 'id'
    //   82: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   85: checkcast java/lang/String
    //   88: invokestatic b : (Lcom/laiqian/product/ProductList;Ljava/lang/String;)Ljava/lang/String;
    //   91: pop
    //   92: aload_0
    //   93: getfield cRN : Lcom/laiqian/product/ProductList;
    //   96: aload_1
    //   97: ldc 'name'
    //   99: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast java/lang/String
    //   105: invokestatic a : (Lcom/laiqian/product/ProductList;Ljava/lang/String;)Ljava/lang/String;
    //   108: pop
    //   109: aload_0
    //   110: getfield cRN : Lcom/laiqian/product/ProductList;
    //   113: aload_0
    //   114: getfield cRN : Lcom/laiqian/product/ProductList;
    //   117: invokestatic a : (Lcom/laiqian/product/ProductList;)Lcom/laiqian/product/ProductList$b;
    //   120: aload_1
    //   121: invokevirtual Q : (Ljava/util/HashMap;)Z
    //   124: invokestatic b : (Lcom/laiqian/product/ProductList;Z)Z
    //   127: pop
    //   128: aload_0
    //   129: getfield cRN : Lcom/laiqian/product/ProductList;
    //   132: iload_3
    //   133: invokestatic b : (Lcom/laiqian/product/ProductList;I)I
    //   136: pop
    //   137: iconst_1
    //   138: istore #6
    //   140: iload #6
    //   142: ifeq -> 239
    //   145: aload_0
    //   146: getfield cRN : Lcom/laiqian/product/ProductList;
    //   149: iconst_0
    //   150: invokestatic a : (Lcom/laiqian/product/ProductList;Z)V
    //   153: aload_0
    //   154: getfield cRN : Lcom/laiqian/product/ProductList;
    //   157: aload_0
    //   158: getfield cRN : Lcom/laiqian/product/ProductList;
    //   161: invokestatic d : (Lcom/laiqian/product/ProductList;)Z
    //   164: iconst_1
    //   165: ixor
    //   166: aload_0
    //   167: getfield cRN : Lcom/laiqian/product/ProductList;
    //   170: invokestatic d : (Lcom/laiqian/product/ProductList;)Z
    //   173: invokestatic a : (Lcom/laiqian/product/ProductList;ZZ)V
    //   176: aload_0
    //   177: getfield cRN : Lcom/laiqian/product/ProductList;
    //   180: astore_1
    //   181: iload_3
    //   182: aload_0
    //   183: getfield cRN : Lcom/laiqian/product/ProductList;
    //   186: invokestatic a : (Lcom/laiqian/product/ProductList;)Lcom/laiqian/product/ProductList$b;
    //   189: invokevirtual YP : ()Ljava/util/ArrayList;
    //   192: invokevirtual size : ()I
    //   195: aload_0
    //   196: getfield cRN : Lcom/laiqian/product/ProductList;
    //   199: invokestatic a : (Lcom/laiqian/product/ProductList;)Lcom/laiqian/product/ProductList$b;
    //   202: invokevirtual YO : ()I
    //   205: iadd
    //   206: if_icmple -> 212
    //   209: goto -> 215
    //   212: iconst_0
    //   213: istore #7
    //   215: aload_1
    //   216: iload #7
    //   218: invokestatic c : (Lcom/laiqian/product/ProductList;Z)Z
    //   221: pop
    //   222: aload_0
    //   223: getfield cRN : Lcom/laiqian/product/ProductList;
    //   226: invokestatic e : (Lcom/laiqian/product/ProductList;)V
    //   229: aload_0
    //   230: getfield cRN : Lcom/laiqian/product/ProductList;
    //   233: invokestatic c : (Lcom/laiqian/product/ProductList;)Lcom/laiqian/product/ProductList$a;
    //   236: invokevirtual YQ : ()V
    //   239: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */