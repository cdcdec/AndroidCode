package com.laiqian.auth;

import org.json.JSONObject;

class x implements Runnable {
  x(w paramw, JSONObject paramJSONObject) {}
  
  public void run() { // Byte code:
    //   0: getstatic com/laiqian/pos/industry/b.url : Ljava/lang/String;
    //   3: aload_0
    //   4: getfield aDV : Lcom/laiqian/auth/w;
    //   7: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   10: invokestatic b : (Lcom/laiqian/auth/CreateEmployeeDialog;)Landroid/content/Context;
    //   13: bipush #20
    //   15: aconst_null
    //   16: aconst_null
    //   17: aload_0
    //   18: getfield aDU : Lorg/json/JSONObject;
    //   21: invokestatic a : (Ljava/lang/String;Landroid/content/Context;ILjava/lang/String;Ljava/lang/Object;Lorg/json/JSONObject;)Ljava/lang/String;
    //   24: astore #6
    //   26: aload #6
    //   28: invokestatic decode : (Ljava/lang/String;)Ljava/lang/String;
    //   31: astore #7
    //   33: aload_0
    //   34: getfield aDV : Lcom/laiqian/auth/w;
    //   37: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   40: invokestatic g : (Lcom/laiqian/auth/CreateEmployeeDialog;)Lcom/laiqian/ui/a/bb;
    //   43: invokevirtual dismiss : ()V
    //   46: iconst_0
    //   47: istore #4
    //   49: iconst_0
    //   50: istore #5
    //   52: iconst_0
    //   53: istore_1
    //   54: iload #4
    //   56: istore_2
    //   57: iload #5
    //   59: istore_3
    //   60: new org/json/JSONObject
    //   63: dup
    //   64: aload #7
    //   66: invokespecial <init> : (Ljava/lang/String;)V
    //   69: astore #7
    //   71: iload #4
    //   73: istore_2
    //   74: iload #5
    //   76: istore_3
    //   77: aload #7
    //   79: ldc 'result'
    //   81: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   84: astore #8
    //   86: iload #4
    //   88: istore_2
    //   89: iload #5
    //   91: istore_3
    //   92: aload #8
    //   94: ldc 'TRUE'
    //   96: invokevirtual equals : (Ljava/lang/Object;)Z
    //   99: ifne -> 428
    //   102: iload #4
    //   104: istore_2
    //   105: iload #5
    //   107: istore_3
    //   108: aload #8
    //   110: ldc 'true'
    //   112: invokevirtual equals : (Ljava/lang/Object;)Z
    //   115: ifeq -> 121
    //   118: goto -> 428
    //   121: iload_1
    //   122: ifeq -> 309
    //   125: iload_1
    //   126: istore_2
    //   127: iload_1
    //   128: istore_3
    //   129: new org/json/JSONObject
    //   132: dup
    //   133: aload #7
    //   135: ldc 'data'
    //   137: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   140: invokespecial <init> : (Ljava/lang/String;)V
    //   143: astore #7
    //   145: iload_1
    //   146: istore_2
    //   147: iload_1
    //   148: istore_3
    //   149: new com/laiqian/auth/cj
    //   152: dup
    //   153: aload_0
    //   154: getfield aDV : Lcom/laiqian/auth/w;
    //   157: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   160: invokestatic b : (Lcom/laiqian/auth/CreateEmployeeDialog;)Landroid/content/Context;
    //   163: invokespecial <init> : (Landroid/content/Context;)V
    //   166: aload #7
    //   168: ldc 'T_USER'
    //   170: invokevirtual c : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   173: ifeq -> 264
    //   176: iload_1
    //   177: istore_2
    //   178: iload_1
    //   179: istore #4
    //   181: iload_1
    //   182: istore_3
    //   183: aload_0
    //   184: getfield aDV : Lcom/laiqian/auth/w;
    //   187: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   190: getfield aDL : Landroid/os/Handler;
    //   193: ifnull -> 381
    //   196: iload_1
    //   197: istore_2
    //   198: iload_1
    //   199: istore_3
    //   200: new android/os/Message
    //   203: dup
    //   204: invokespecial <init> : ()V
    //   207: astore #8
    //   209: iload_1
    //   210: istore_2
    //   211: iload_1
    //   212: istore_3
    //   213: aload #8
    //   215: iconst_1
    //   216: putfield what : I
    //   219: iload_1
    //   220: istore_2
    //   221: iload_1
    //   222: istore_3
    //   223: aload #8
    //   225: aload #7
    //   227: ldc 'sUserPhone'
    //   229: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   232: invokevirtual toString : ()Ljava/lang/String;
    //   235: putfield obj : Ljava/lang/Object;
    //   238: iload_1
    //   239: istore_2
    //   240: iload_1
    //   241: istore_3
    //   242: aload_0
    //   243: getfield aDV : Lcom/laiqian/auth/w;
    //   246: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   249: getfield aDL : Landroid/os/Handler;
    //   252: aload #8
    //   254: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   257: pop
    //   258: iload_1
    //   259: istore #4
    //   261: goto -> 381
    //   264: iload_1
    //   265: istore_2
    //   266: iload_1
    //   267: istore #4
    //   269: iload_1
    //   270: istore_3
    //   271: aload_0
    //   272: getfield aDV : Lcom/laiqian/auth/w;
    //   275: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   278: getfield aDL : Landroid/os/Handler;
    //   281: ifnull -> 381
    //   284: iload_1
    //   285: istore_2
    //   286: iload_1
    //   287: istore_3
    //   288: aload_0
    //   289: getfield aDV : Lcom/laiqian/auth/w;
    //   292: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   295: getfield aDL : Landroid/os/Handler;
    //   298: iconst_4
    //   299: invokevirtual sendEmptyMessage : (I)Z
    //   302: pop
    //   303: iload_1
    //   304: istore #4
    //   306: goto -> 381
    //   309: iload_1
    //   310: istore_2
    //   311: iload_1
    //   312: istore #4
    //   314: iload_1
    //   315: istore_3
    //   316: aload #7
    //   318: ldc 'data'
    //   320: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   323: invokevirtual toString : ()Ljava/lang/String;
    //   326: ldc '1'
    //   328: invokevirtual equals : (Ljava/lang/Object;)Z
    //   331: ifeq -> 381
    //   334: iload_1
    //   335: istore_2
    //   336: iload_1
    //   337: istore_3
    //   338: aload_0
    //   339: getfield aDV : Lcom/laiqian/auth/w;
    //   342: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   345: getfield aDL : Landroid/os/Handler;
    //   348: ifnull -> 370
    //   351: iload_1
    //   352: istore_2
    //   353: iload_1
    //   354: istore_3
    //   355: aload_0
    //   356: getfield aDV : Lcom/laiqian/auth/w;
    //   359: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   362: getfield aDL : Landroid/os/Handler;
    //   365: iconst_3
    //   366: invokevirtual sendEmptyMessage : (I)Z
    //   369: pop
    //   370: return
    //   371: astore #7
    //   373: aload #7
    //   375: invokestatic e : (Ljava/lang/Throwable;)V
    //   378: iload_2
    //   379: istore #4
    //   381: iload #4
    //   383: ifne -> 414
    //   386: aload_0
    //   387: getfield aDV : Lcom/laiqian/auth/w;
    //   390: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   393: getfield aDL : Landroid/os/Handler;
    //   396: ifnull -> 414
    //   399: aload_0
    //   400: getfield aDV : Lcom/laiqian/auth/w;
    //   403: getfield aDT : Lcom/laiqian/auth/CreateEmployeeDialog;
    //   406: getfield aDL : Landroid/os/Handler;
    //   409: iconst_2
    //   410: invokevirtual sendEmptyMessage : (I)Z
    //   413: pop
    //   414: aload #6
    //   416: invokestatic an : (Ljava/lang/Object;)V
    //   419: return
    //   420: astore #7
    //   422: iload_3
    //   423: istore #4
    //   425: goto -> 381
    //   428: iconst_1
    //   429: istore_1
    //   430: goto -> 121
    // Exception table:
    //   from	to	target	type
    //   60	71	420	org/json/JSONException
    //   60	71	371	java/lang/Exception
    //   77	86	420	org/json/JSONException
    //   77	86	371	java/lang/Exception
    //   92	102	420	org/json/JSONException
    //   92	102	371	java/lang/Exception
    //   108	118	420	org/json/JSONException
    //   108	118	371	java/lang/Exception
    //   129	145	420	org/json/JSONException
    //   129	145	371	java/lang/Exception
    //   149	176	420	org/json/JSONException
    //   149	176	371	java/lang/Exception
    //   183	196	420	org/json/JSONException
    //   183	196	371	java/lang/Exception
    //   200	209	420	org/json/JSONException
    //   200	209	371	java/lang/Exception
    //   213	219	420	org/json/JSONException
    //   213	219	371	java/lang/Exception
    //   223	238	420	org/json/JSONException
    //   223	238	371	java/lang/Exception
    //   242	258	420	org/json/JSONException
    //   242	258	371	java/lang/Exception
    //   271	284	420	org/json/JSONException
    //   271	284	371	java/lang/Exception
    //   288	303	420	org/json/JSONException
    //   288	303	371	java/lang/Exception
    //   316	334	420	org/json/JSONException
    //   316	334	371	java/lang/Exception
    //   338	351	420	org/json/JSONException
    //   338	351	371	java/lang/Exception
    //   355	370	420	org/json/JSONException
    //   355	370	371	java/lang/Exception }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */