package com.laiqian.print.type;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.print.ac;
import com.laiqian.print.bm;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.model.type.a.f;
import com.laiqian.print.model.type.b.c;
import com.laiqian.print.model.type.c.c;
import com.laiqian.print.model.type.usb.g;
import com.laiqian.print.printtype.PrintTypeSelectionsActivity;
import com.laiqian.print.usage.e;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.h;
import com.laiqian.util.ae;
import com.laiqian.util.bc;
import com.laiqian.util.by;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import me.raid.libserialport.serialport.SerialPortFinder;

public class PrinterEditActivity extends ActivityRoot {
  @Nullable
  private ac cKh = null;
  
  private ac cKi;
  
  private a cKj;
  
  bc<bm> cKk;
  
  private int mode = 1;
  
  aa titleBar;
  
  public static Intent a(Context paramContext, ac paramac) {
    Intent intent = new Intent(paramContext, PrinterEditActivity.class);
    intent.putExtra("mode", 2);
    intent.putExtra("selection", paramac);
    return intent;
  }
  
  public static Intent a(Context paramContext, ac paramac, int paramInt) {
    Intent intent = new Intent(paramContext, PrinterEditActivity.class);
    intent.putExtra("mode", paramInt);
    intent.putExtra("selection", paramac);
    return intent;
  }
  
  private void a(f paramf) {
    a.c c = a.c.q(getLayoutInflater());
    c.cKO.setText("MAC");
    c.cvO.setText(paramf.getMacAddress());
    this.cKj.cKL.addView(c.aQG);
  }
  
  private void a(c paramc) {
    a.b b = a.b.p(getLayoutInflater());
    b.cKO.setText(2131628907);
    b.cKQ.setText(paramc.getAddress());
    b.cKQ.addTextChangedListener(new w(this, paramc));
    this.cKj.cKL.addView(b.aQG);
    b = a.b.p(getLayoutInflater());
    b.cKO.setText(2131628909);
    b.cKQ.setText(String.valueOf(paramc.getPort()));
    b.cKQ.addTextChangedListener(new x(this, paramc));
    this.cKj.cKL.addView(b.aQG);
  }
  
  private void a(c paramc) {
    a.c c1 = a.c.q(getLayoutInflater());
    c1.cKO.setText(2131628942);
    c1.cvO.setText(paramc.getPath());
    c1.aQG.setOnClickListener(new z(this, paramc, c1));
    this.cKj.cKL.addView(c1.aQG);
    c1 = a.c.q(getLayoutInflater());
    c1.cKO.setText(2131626495);
    c1.cvO.setText(String.valueOf(paramc.getBaudrate()));
    c1.aQG.setOnClickListener(new ab(this, paramc, c1));
    this.cKj.cKL.addView(c1.aQG);
  }
  
  private void a(g paramg) {}
  
  private void ahA() {
    if (this.cKi.aex().size() == 0) {
      Toast.makeText(this, getString(2131628923), 0).show();
      return;
    } 
    h(new an(this));
  }
  
  private void ahr() {
    r(this.cKi.aex());
    n(this.cKi.aew());
    o(this.cKi.aew());
  }
  
  private void aht() {
    String[] arrayOfString;
    c c2;
    c c;
    c c1;
    int i;
    byte b;
    Intent intent = getIntent();
    this.mode = intent.getIntExtra("mode", 1);
    null = intent.getSerializableExtra("selection");
    switch (this.mode) {
      default:
        c1 = new StringBuilder();
        c1.append("no such mode: ");
        c1.append(this.mode);
        throw new RuntimeException(c1.toString());
      case 2:
        if (null instanceof ac) {
          this.cKi = new ac((ac)null);
          this.cKh = new ac(this.cKi);
          return;
        } 
        return;
      case 1:
        break;
    } 
    StringBuilder stringBuilder = null;
    this.cKh = null;
    if (null instanceof ac) {
      this.cKi = new ac((ac)null);
      return;
    } 
    switch (c1.getIntExtra("type", -1)) {
      default:
        throw new RuntimeException("no such type");
      case 4:
        arrayOfString = (new SerialPortFinder()).getAllDevicesPath();
        if (arrayOfString.length == 0) {
          Toast.makeText(this, "no serial deivces", 0).show();
          finish();
          return;
        } 
        i = arrayOfString.length;
        b = 0;
        while (true) {
          c1 = stringBuilder;
          if (b < i) {
            String str = arrayOfString[b];
            if (str.contains("ttyS2")) {
              c1 = new c(str, 115200);
              break;
            } 
            b++;
            continue;
          } 
          break;
        } 
        c2 = c1;
        if (c1 == null)
          c2 = new c(arrayOfString[0], 115200); 
        this.cKi = new ac(c2, Collections.emptyList());
        return;
      case 3:
        throw new RuntimeException("bluetooth printer create not supported");
      case 2:
        c = new c("192.168.1.200", '⎌');
        this.cKi = new ac(c, Collections.emptyList());
        return;
      case 1:
        break;
    } 
    throw new RuntimeException("usb printer create not supported");
  }
  
  private void ahw() {
    setResult(3);
    finish();
  }
  
  private void ahx() {
    setResult(0);
    finish();
  }
  
  private void ahy() {
    if (this.cKi.aex().size() == 0) {
      Toast.makeText(this, getString(2131628923), 0).show();
      return;
    } 
    Intent intent = new Intent();
    intent.putExtra("selection", this.cKi);
    setResult(-1, intent);
    finish();
  }
  
  private void ahz() {
    if (this.cKi.aex().size() == 0) {
      Toast.makeText(this, getString(2131628923), 0).show();
      return;
    } 
    h(null);
  }
  
  private String d(bm parambm) {
    switch (ai.bgg[parambm.ordinal()]) {
      default:
        return "";
      case 4:
        return getString(2131629000);
      case 3:
        return getString(2131628982);
      case 2:
        return getString(2131628972);
      case 1:
        break;
    } 
    return getString(2131628996);
  }
  
  private void f(bm parambm) {
    switch (ai.bgg[parambm.ordinal()]) {
      default:
        return;
      case 4:
        a1 = a.a.o(getLayoutInflater());
        a1.cKO.setText(2131629000);
        a1.aQG.setOnClickListener(new t(this));
        this.cKj.cKM.addView(a1.aQG);
        a1 = a.a.o(getLayoutInflater());
        a1.cKO.setText(2131628932);
        a1.aQG.setOnClickListener(new u(this));
        this.cKj.cKM.addView(a1.aQG);
        return;
      case 3:
        a1 = a.a.o(getLayoutInflater());
        a1.cKO.setText(2131628982);
        a1.aQG.setOnClickListener(new q(this));
        this.cKj.cKM.addView(a1.aQG);
        a1 = a.a.o(getLayoutInflater());
        a1.cKO.setText(2131625441);
        a1.aQG.setOnClickListener(new r(this));
        this.cKj.cKM.addView(a1.aQG);
        a1 = a.a.o(getLayoutInflater());
        a1.cKO.setText(2131628889);
        a1.aQG.setOnClickListener(new s(this));
        this.cKj.cKM.addView(a1.aQG);
        return;
      case 2:
        a1 = a.a.o(getLayoutInflater());
        a1.cKO.setText(2131628972);
        a1.aQG.setOnClickListener(new p(this));
        this.cKj.cKM.addView(a1.aQG);
        return;
      case 1:
        break;
    } 
    a.a a1 = a.a.o(getLayoutInflater());
    a1.cKO.setText(2131628996);
    a1.aQG.setOnClickListener(new o(this));
    this.cKj.cKM.addView(a1.aQG);
  }
  
  private void h(@Nullable Runnable paramRunnable) { // Byte code:
    //   0: aload_0
    //   1: getfield cKi : Lcom/laiqian/print/ac;
    //   4: invokevirtual aex : ()Ljava/util/Set;
    //   7: invokeinterface iterator : ()Ljava/util/Iterator;
    //   12: invokeinterface next : ()Ljava/lang/Object;
    //   17: checkcast com/laiqian/print/bm
    //   20: astore_2
    //   21: new java/util/ArrayList
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore #4
    //   30: new com/laiqian/print/printtype/r
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   38: invokespecial <init> : (Landroid/content/Context;)V
    //   41: astore #5
    //   43: getstatic com/laiqian/print/type/ai.bgg : [I
    //   46: aload_2
    //   47: invokevirtual ordinal : ()I
    //   50: iaload
    //   51: tableswitch default -> 462, 1 -> 332, 2 -> 321, 3 -> 278, 4 -> 80
    //   80: ldc_w 'tag_not_specified'
    //   83: astore_2
    //   84: new java/util/Date
    //   87: dup
    //   88: invokestatic currentTimeMillis : ()J
    //   91: invokespecial <init> : (J)V
    //   94: astore #6
    //   96: new com/laiqian/pos/model/orders/b
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: astore_3
    //   104: aload_3
    //   105: aload #6
    //   107: putfield bkf : Ljava/util/Date;
    //   110: aload_3
    //   111: ldc_w '8'
    //   114: putfield coJ : Ljava/lang/String;
    //   117: aload_3
    //   118: ldc2_w 200.0
    //   121: invokestatic valueOf : (D)Ljava/lang/Double;
    //   124: putfield cyH : Ljava/lang/Double;
    //   127: aload_3
    //   128: ldc2_w 200.0
    //   131: invokestatic valueOf : (D)Ljava/lang/Double;
    //   134: putfield cyP : Ljava/lang/Double;
    //   137: new java/util/ArrayList
    //   140: dup
    //   141: invokespecial <init> : ()V
    //   144: astore #6
    //   146: new java/util/HashMap
    //   149: dup
    //   150: invokespecial <init> : ()V
    //   153: astore #7
    //   155: aload_0
    //   156: ldc_w 2131628158
    //   159: invokevirtual getString : (I)Ljava/lang/String;
    //   162: astore #8
    //   164: aload_0
    //   165: ldc_w 2131628157
    //   168: invokevirtual getString : (I)Ljava/lang/String;
    //   171: astore #9
    //   173: aload #7
    //   175: ldc_w 'sProductName'
    //   178: aload #8
    //   180: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: aload #7
    //   186: ldc_w 'taste'
    //   189: aload #9
    //   191: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: pop
    //   195: aload #7
    //   197: ldc_w 'nProductQty'
    //   200: ldc_w '1'
    //   203: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: aload #7
    //   209: ldc_w 'fPrice'
    //   212: ldc_w '20.05'
    //   215: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   218: pop
    //   219: aload #7
    //   221: ldc_w 'fAmount'
    //   224: ldc_w '100'
    //   227: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: pop
    //   231: aload #7
    //   233: ldc_w 'fOriginalPrice'
    //   236: ldc_w '20'
    //   239: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   242: pop
    //   243: aload #7
    //   245: ldc_w 'tableNo'
    //   248: bipush #123
    //   250: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   253: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: aload #6
    //   259: aload #7
    //   261: invokevirtual add : (Ljava/lang/Object;)Z
    //   264: pop
    //   265: aload_3
    //   266: getfield bJf : Ljava/util/ArrayList;
    //   269: aload #6
    //   271: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   274: pop
    //   275: goto -> 340
    //   278: aload_0
    //   279: getfield cKi : Lcom/laiqian/print/ac;
    //   282: ldc_w 'kitchen_port'
    //   285: invokevirtual kS : (Ljava/lang/String;)Lcom/laiqian/print/printtype/j;
    //   288: ifnull -> 463
    //   291: aload_0
    //   292: getfield cKi : Lcom/laiqian/print/ac;
    //   295: ldc_w 'kitchen_port'
    //   298: invokevirtual kS : (Ljava/lang/String;)Lcom/laiqian/print/printtype/j;
    //   301: getfield cCC : I
    //   304: ifle -> 463
    //   307: ldc_w 'kitchen_port'
    //   310: astore_2
    //   311: goto -> 314
    //   314: getstatic com/laiqian/pos/model/orders/b.cyT : Lcom/laiqian/pos/model/orders/b;
    //   317: astore_3
    //   318: goto -> 340
    //   321: ldc_w 'delivery_not_specified'
    //   324: astore_2
    //   325: getstatic com/laiqian/pos/model/orders/b.cyT : Lcom/laiqian/pos/model/orders/b;
    //   328: astore_3
    //   329: goto -> 340
    //   332: ldc_w 'settle_receipt'
    //   335: astore_2
    //   336: getstatic com/laiqian/pos/model/orders/b.cyT : Lcom/laiqian/pos/model/orders/b;
    //   339: astore_3
    //   340: aload #5
    //   342: invokevirtual yz : ()Lcom/laiqian/print/j$a;
    //   345: new com/laiqian/print/j$a$a
    //   348: dup
    //   349: ldc_w com/laiqian/pos/model/orders/b
    //   352: aload_2
    //   353: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/String;)V
    //   356: invokevirtual b : (Lcom/laiqian/b/a/a$a;)Lcom/laiqian/b/a/a$b;
    //   359: checkcast com/laiqian/print/j$a$b
    //   362: getfield cCz : Lcom/laiqian/print/printtype/f;
    //   365: astore #6
    //   367: aload #5
    //   369: invokevirtual yy : ()Lcom/laiqian/print/j$b;
    //   372: new com/laiqian/print/j$b$a
    //   375: dup
    //   376: aload_2
    //   377: aload_0
    //   378: getfield cKi : Lcom/laiqian/print/ac;
    //   381: invokespecial <init> : (Ljava/lang/String;Lcom/laiqian/print/ac;)V
    //   384: invokevirtual b : (Lcom/laiqian/b/a/a$a;)Lcom/laiqian/b/a/a$b;
    //   387: checkcast com/laiqian/print/j$b$b
    //   390: getfield cCB : Lcom/laiqian/print/j$i;
    //   393: astore #7
    //   395: aload #5
    //   397: invokevirtual yA : ()Lcom/laiqian/print/j$f;
    //   400: aload_3
    //   401: aload_2
    //   402: aload #7
    //   404: aload #6
    //   406: invokeinterface a : (Ljava/lang/Object;Ljava/lang/String;Lcom/laiqian/print/j$i;Lcom/laiqian/print/printtype/f;)Ljava/util/List;
    //   411: astore_2
    //   412: goto -> 423
    //   415: astore_2
    //   416: aload_2
    //   417: invokestatic e : (Ljava/lang/Throwable;)V
    //   420: aload #4
    //   422: astore_2
    //   423: getstatic com/laiqian/print/model/g.cGS : Lcom/laiqian/print/model/g;
    //   426: aload_0
    //   427: getfield cKi : Lcom/laiqian/print/ac;
    //   430: invokevirtual aew : ()Lcom/laiqian/print/model/s;
    //   433: invokevirtual f : (Lcom/laiqian/print/model/s;)Lcom/laiqian/print/model/q;
    //   436: aload_2
    //   437: invokevirtual D : (Ljava/util/List;)Lcom/laiqian/print/model/e;
    //   440: astore_2
    //   441: aload_2
    //   442: new com/laiqian/print/type/l
    //   445: dup
    //   446: aload_0
    //   447: aload_1
    //   448: invokespecial <init> : (Lcom/laiqian/print/type/PrinterEditActivity;Ljava/lang/Runnable;)V
    //   451: invokevirtual a : (Lcom/laiqian/print/model/e$a;)V
    //   454: getstatic com/laiqian/print/model/g.cGS : Lcom/laiqian/print/model/g;
    //   457: aload_2
    //   458: invokevirtual print : (Lcom/laiqian/print/model/e;)V
    //   461: return
    //   462: return
    //   463: ldc_w 'kitchen_total'
    //   466: astore_2
    //   467: goto -> 314
    // Exception table:
    //   from	to	target	type
    //   43	80	415	java/lang/Exception
    //   84	275	415	java/lang/Exception
    //   278	307	415	java/lang/Exception
    //   314	318	415	java/lang/Exception
    //   325	329	415	java/lang/Exception
    //   336	340	415	java/lang/Exception
    //   340	412	415	java/lang/Exception }
  
  private String hE(int paramInt) {
    switch (paramInt) {
      default:
        return "Unknown";
      case 4:
        return getString(2131628961);
      case 3:
        return getString(2131628959);
      case 2:
        return getString(2131628960);
      case 1:
        break;
    } 
    return getString(2131628963);
  }
  
  private void n(s params) {
    this.cKj.cKJ.aqP();
    a.b b = a.b.p(getLayoutInflater());
    b.cKO.setText(2131628906);
    b.cKQ.setText(params.getName());
    b.cKQ.addTextChangedListener(new v(this, params));
    this.cKj.cKJ.addView(b.aQG);
    this.cKj.cKL.aqP();
    a.c c = a.c.q(getLayoutInflater());
    c.cKO.setText(2131628957);
    c.cvO.setText(hE(params.getType()));
    this.cKj.cKL.addView(c.aQG);
    switch (params.getType()) {
      default:
        throw new RuntimeException("unknown type");
      case 4:
        a((c)params);
        return;
      case 3:
        a((f)params);
        return;
      case 2:
        a((c)params);
        return;
      case 1:
        break;
    } 
    a((g)params);
  }
  
  private void o(s params) {
    int i;
    this.cKj.cKN.aqP();
    a.c c = a.c.q(getLayoutInflater());
    c.cKO.setText(2131628955);
    TextView textView = c.cvO;
    if (g.cGS.isConnected(params)) {
      i = 2131628883;
    } else {
      i = 2131628888;
    } 
    textView.setText(i);
    ad ad = new ad(this, params, c);
    c.aQG.setOnClickListener(ad);
    ad.onClick(c.aQG);
    this.cKj.cKN.addView(c.aQG);
    a.a a1 = a.a.o(getLayoutInflater());
    a1.cKO.setText(2131628947);
    a1.aQG.setOnClickListener(new ag(this, params));
    this.cKj.cKN.addView(a1.aQG);
    if (params.getType() == 1 || params.getType() == 2) {
      a.a a2 = a.a.o(getLayoutInflater());
      a2.cKO.setText(2131625001);
      a2.aQG.setOnClickListener(new ah(this));
      this.cKj.cKN.addView(a2.aQG);
    } 
  }
  
  private void r(Collection<bm> paramCollection) {
    this.cKj.cKK.aqP();
    this.cKj.cKM.aqP();
    a.c c = a.c.q(getLayoutInflater());
    c.cKO.setText(2131628965);
    c.aQG.setOnClickListener(new ao(this));
    this.cKj.cKK.addView(c.aQG);
    if (paramCollection.size() == 0) {
      c.cvO.setText(2131629003);
    } else {
      ArrayList arrayList = new ArrayList();
      for (bm bm : paramCollection) {
        arrayList.add(d(bm));
        f(bm);
      } 
      c.cvO.setText(by.a("/", arrayList));
    } 
    if (paramCollection.size() != 1 || !paramCollection.contains(bm.cEg)) {
      a.a a1 = a.a.o(getLayoutInflater());
      a1.cKO.setText(2131628946);
      a1.aQG.setOnClickListener(new ar(this));
      this.cKj.cKK.addView(a1.aQG);
    } 
  }
  
  private void setupViews() {
    this.titleBar.brk.setVisibility(8);
    this.titleBar.brj.setText(getString(2131629495));
    this.titleBar.brj.setOnClickListener(new n(this));
    this.titleBar.tvTitle.setText(this.cKi.aew().getName());
    this.titleBar.bri.setOnClickListener(new y(this));
    if (this.mode == 2) {
      this.cKj.cKI.setText(2131628886);
      this.cKj.cKI.setOnClickListener(new aj(this));
      this.cKj.bqY.setText(2131628956);
      this.cKj.bqY.setOnClickListener(new ak(this));
      return;
    } 
    this.cKj.cKI.setVisibility(8);
    this.cKj.bqY.setText(2131628935);
    this.cKj.bqY.setOnClickListener(new al(this));
  }
  
  public static Intent u(Context paramContext, int paramInt) {
    Intent intent = new Intent(paramContext, PrinterEditActivity.class);
    intent.putExtra("mode", 1);
    intent.putExtra("type", paramInt);
    return intent;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    List list;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1) {
      default:
        return;
      case 5:
        if (paramInt2 == -1) {
          list = paramIntent.getSerializableExtra("printerInfo");
          if (list != null) {
            s s;
            list = (s)list;
            this.cKi.c(list);
            return;
          } 
        } 
        return;
      case 4:
        if (paramInt2 == -1) {
          list = KitchenAreaIgnoreActivity.p(list);
          ((e.b)this.cKi.a(bm.cEh)).u(list);
          return;
        } 
        return;
      case 3:
        if (paramInt2 == -1) {
          list = KitchenPrintRangeActivity.q(list);
          ((e.d)this.cKi.a(bm.cEg)).t(list);
          return;
        } 
        return;
      case 2:
        if (paramInt2 == -1) {
          list = KitchenPrintRangeActivity.q(list);
          ((e.b)this.cKi.a(bm.cEh)).t(list);
          return;
        } 
        return;
      case 1:
        break;
    } 
    if (paramInt2 == -1) {
      HashMap hashMap = PrintTypeSelectionsActivity.o(list);
      for (bm null : hashMap.keySet()) {
        ArrayList arrayList = (ArrayList)hashMap.get(null);
        e e = this.cKi.a(null);
        if (e != null) {
          e.aib();
          e.s(arrayList);
        } 
      } 
    } 
  }
  
  public void onBackPressed() {
    if (!this.cKi.equals(this.cKh)) {
      r r = new r(getActivity(), new am(this));
      r.setTitle(getString(2131627735));
      r.s(getString(2131627733));
      r.t(getString(2131627734));
      r.oZ(getString(2131627732));
      r.show();
      return;
    } 
    ahx();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cKj = a.i(getWindow());
    this.titleBar = aa.M(this);
    aht();
    this.cKk = bc.b(Arrays.asList(new bm[] { bm.cEh, bm.cEf, bm.cEg }, ), this.cKi.aex());
    setupViews();
    ahr();
  }
  
  private static final class a {
    Button bqY;
    
    ScrollView cJx;
    
    LinearLayout cKD;
    
    LinearLayout cKE;
    
    LinearLayout cKF;
    
    LinearLayout cKG;
    
    LinearLayout cKH;
    
    Button cKI;
    
    h cKJ;
    
    h cKK;
    
    h cKL;
    
    h cKM;
    
    h cKN;
    
    a(View param1View) {
      this.cJx = (ScrollView)param1View;
      this.cKD = (LinearLayout)param1View.findViewById(2131297607);
      this.cKE = (LinearLayout)param1View.findViewById(2131297715);
      this.cKF = (LinearLayout)param1View.findViewById(2131297637);
      this.cKG = (LinearLayout)param1View.findViewById(2131297716);
      this.cKH = (LinearLayout)param1View.findViewById(2131297638);
      this.cKI = (Button)param1View.findViewById(2131296622);
      this.bqY = (Button)param1View.findViewById(2131296644);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ae.b(param1View.getContext(), 56.0F));
      h.a a1 = (new h.a.a()).kD(2130772052).kE(2130772057).kF(2130772051).kG(2130772055).kH(-1).b(layoutParams).aqQ();
      this.cKJ = new h(this.cKD, a1);
      this.cKK = new h(this.cKE, a1);
      this.cKL = new h(this.cKF, a1);
      this.cKM = new h(this.cKG, a1);
      this.cKN = new h(this.cKH, a1);
    }
    
    static a i(Window param1Window) {
      a a1 = n(LayoutInflater.from(param1Window.getContext()));
      param1Window.setContentView(a1.cJx);
      return a1;
    }
    
    static a n(LayoutInflater param1LayoutInflater) { return new a(param1LayoutInflater.inflate(2131427402, null)); }
    
    public static class a {
      public final View aQG;
      
      public final TextView cKO;
      
      public final ImageView cKP;
      
      public a(View param2View) {
        this.aQG = param2View;
        this.cKO = (TextView)param2View.findViewById(2131297314);
        this.cKP = (ImageView)param2View.findViewById(2131297308);
      }
      
      public static a o(LayoutInflater param2LayoutInflater) { return new a(param2LayoutInflater.inflate(2131427656, null)); }
    }
    
    public static class b {
      public final View aQG;
      
      public final TextView cKO;
      
      public final EditText cKQ;
      
      public b(View param2View) {
        this.aQG = param2View;
        this.cKO = (TextView)param2View.findViewById(2131297314);
        this.cKQ = (EditText)param2View.findViewById(2131297307);
      }
      
      public static b p(LayoutInflater param2LayoutInflater) { return new b(param2LayoutInflater.inflate(2131427670, null)); }
    }
    
    public static class c {
      public final View aQG;
      
      public final TextView cKO;
      
      public final TextView cvO;
      
      public c(View param2View) {
        this.aQG = param2View;
        this.cKO = (TextView)param2View.findViewById(2131297314);
        this.cvO = (TextView)param2View.findViewById(2131297317);
      }
      
      public static c q(LayoutInflater param2LayoutInflater) { return new c(param2LayoutInflater.inflate(2131427671, null)); }
    }
  }
  
  public static class a {
    public final View aQG;
    
    public final TextView cKO;
    
    public final ImageView cKP;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cKO = (TextView)param1View.findViewById(2131297314);
      this.cKP = (ImageView)param1View.findViewById(2131297308);
    }
    
    public static a o(LayoutInflater param1LayoutInflater) { return new a(param1LayoutInflater.inflate(2131427656, null)); }
  }
  
  public static class b {
    public final View aQG;
    
    public final TextView cKO;
    
    public final EditText cKQ;
    
    public b(View param1View) {
      this.aQG = param1View;
      this.cKO = (TextView)param1View.findViewById(2131297314);
      this.cKQ = (EditText)param1View.findViewById(2131297307);
    }
    
    public static b p(LayoutInflater param1LayoutInflater) { return new b(param1LayoutInflater.inflate(2131427670, null)); }
  }
  
  public static class c {
    public final View aQG;
    
    public final TextView cKO;
    
    public final TextView cvO;
    
    public c(View param1View) {
      this.aQG = param1View;
      this.cKO = (TextView)param1View.findViewById(2131297314);
      this.cvO = (TextView)param1View.findViewById(2131297317);
    }
    
    public static c q(LayoutInflater param1LayoutInflater) { return new c(param1LayoutInflater.inflate(2131427671, null)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\PrinterEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */