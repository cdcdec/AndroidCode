package com.laiqian.report.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.models.al;
import com.laiqian.print.model.e;
import com.laiqian.report.models.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.n;
import java.util.HashMap;

public class ShiftDetails extends ActivityRoot {
  private a.a aEz;
  
  protected final int dgb = 99;
  
  protected final int dgc = 98;
  
  protected final int dge = 97;
  
  private View dgh;
  
  private View dgi;
  
  private View dgj;
  
  protected boolean dgk;
  
  protected Handler handler = new ce(this);
  
  private View aR(String paramString1, String paramString2) {
    View view = View.inflate(this, 2131428005, null);
    ((TextView)view.findViewById(2131297452)).setText(paramString1);
    ((TextView)view.findViewById(2131299967)).setText(paramString2);
    return view;
  }
  
  private void aab() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield dgk : Z
    //   7: new java/util/ArrayList
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore_1
    //   15: aload_0
    //   16: getfield aEz : Lcom/laiqian/report/models/a$a;
    //   19: invokevirtual amt : ()V
    //   22: goto -> 30
    //   25: astore_2
    //   26: aload_2
    //   27: invokestatic e : (Ljava/lang/Throwable;)V
    //   30: aload_0
    //   31: getfield dgk : Z
    //   34: ifne -> 50
    //   37: aload_0
    //   38: getfield handler : Landroid/os/Handler;
    //   41: bipush #97
    //   43: invokevirtual sendEmptyMessage : (I)Z
    //   46: pop
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: new com/laiqian/report/ui/ShiftDetails$a
    //   53: dup
    //   54: aload_0
    //   55: aload_1
    //   56: invokeinterface size : ()I
    //   61: invokespecial <init> : (Lcom/laiqian/report/ui/ShiftDetails;I)V
    //   64: astore_2
    //   65: aload_1
    //   66: invokeinterface iterator : ()Ljava/util/Iterator;
    //   71: astore_3
    //   72: aload_3
    //   73: invokeinterface hasNext : ()Z
    //   78: ifeq -> 97
    //   81: aload_3
    //   82: invokeinterface next : ()Ljava/lang/Object;
    //   87: checkcast com/laiqian/print/model/e
    //   90: aload_2
    //   91: invokevirtual a : (Lcom/laiqian/print/model/e$a;)V
    //   94: goto -> 72
    //   97: getstatic com/laiqian/print/model/g.cGS : Lcom/laiqian/print/model/g;
    //   100: aload_1
    //   101: invokevirtual o : (Ljava/util/Collection;)V
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	107	finally
    //   15	22	25	java/lang/Exception
    //   15	22	107	finally
    //   26	30	107	finally
    //   30	47	107	finally
    //   50	72	107	finally
    //   72	94	107	finally
    //   97	104	107	finally }
  
  private void aoy() {
    ViewGroup viewGroup = (ViewGroup)findViewById(2131296353);
    if (this.aEz.cZt == null)
      return; 
    for (byte b = 0; b < this.aEz.cZt.size(); b++) {
      a a1 = (a)this.aEz.cZt.get(b);
      if (a1.cZn != 10006L)
        viewGroup.addView(aR(a1.Yx, a1.cZl)); 
    } 
    if (!n.bc(this.aEz.amr()))
      viewGroup.addView(aR("Total CashFlow", n.a(Double.valueOf(this.aEz.amr()), true, true))); 
  }
  
  private void aoz() {
    ((TextView)findViewById(2131299932)).setText(this.aEz.userName);
    ((TextView)findViewById(2131296459)).setText(this.aEz.aRB);
    ((TextView)findViewById(2131296934)).setText(this.aEz.aRD);
    ((TextView)findViewById(2131297269)).setText(this.aEz.cZA);
  }
  
  protected void AC() {
    this.dgh = View.inflate(this, 2131427997, getTitleRightCustomize());
    View view = this.dgh.findViewById(2131298484);
    this.dgi = view.findViewById(2131298489);
    this.dgj = this.dgh.findViewById(2131298490);
    view.setOnClickListener(new cc(this));
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131428004);
    setTitleTextViewHideRightView(2131627964);
    addTitleBottomShadow();
    long l = getIntent().getLongExtra("shiftEndTime", 0L);
    if (l <= 0L) {
      finish();
      return;
    } 
    al al = new al(this);
    HashMap hashMap = al.bB(l);
    al.close();
    if (hashMap == null) {
      n.a(this, "错误");
      finish();
      return;
    } 
    this.aEz = new a.a(((Long)hashMap.get("nUserID")).longValue(), ((Long)hashMap.get("nShiftBeginTime")).longValue(), ((Long)hashMap.get("nShiftEndTime")).longValue(), (String)hashMap.get("fImprest"));
    aoy();
    aoz();
    AC();
  }
  
  private class a implements e.a {
    int dgT;
    
    int dgU;
    
    public a(ShiftDetails this$0, int param1Int) { this.dgT = param1Int; }
    
    public void a(e param1e, int param1Int) {
      if (param1e.agu()) {
        this.dgU++;
        if (this.dgU >= this.dgT)
          this.dhh.handler.sendEmptyMessage(99); 
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ShiftDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */