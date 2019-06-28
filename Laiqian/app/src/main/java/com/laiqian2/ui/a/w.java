package com.laiqian.ui.a;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.s;
import com.laiqian.util.ae;
import java.util.HashMap;

public class w<T> extends f {
  private TextView aNl;
  
  int bsN = -1;
  
  private a btm;
  
  private Context context;
  
  private HashMap<String, Integer> czo;
  
  private String[] dzS = new String[0];
  
  private BaseAdapter dzT;
  
  private boolean dzU;
  
  private boolean dzV = false;
  
  private int dzW = 19;
  
  private boolean dzX;
  
  private boolean dzY = false;
  
  private CheckBox dzZ = null;
  
  private Button dzq;
  
  private View dzr;
  
  private View dzs;
  
  private ListView dzt;
  
  private double dzv = 0.3D;
  
  private double dzw = 0.0D;
  
  private int dzx = 0;
  
  private boolean dzy = true;
  
  public Object object;
  
  public w(Context paramContext) { this(paramContext, null, null, true); }
  
  public w(Context paramContext, String[] paramArrayOfString, a parama) { this(paramContext, paramArrayOfString, parama, true); }
  
  public w(Context paramContext, String[] paramArrayOfString, a parama, boolean paramBoolean) {
    super(paramContext, R.style.pos_dialog);
    this.context = paramContext;
    this.dzS = paramArrayOfString;
    this.btm = parama;
    this.dzy = paramBoolean;
    setContentView(R.layout.pos_spinner_dialog_2014088);
    yR();
  }
  
  public w(Context paramContext, String[] paramArrayOfString, a parama, boolean paramBoolean1, boolean paramBoolean2, HashMap<String, Integer> paramHashMap) {
    super(paramContext, R.style.pos_dialog);
    this.context = paramContext;
    this.dzS = paramArrayOfString;
    this.btm = parama;
    this.dzy = paramBoolean1;
    this.dzU = paramBoolean2;
    this.czo = paramHashMap;
    setContentView(R.layout.pos_spinner_dialog_2014088);
    yR();
  }
  
  private void yR() {
    setCancelable(true);
    setCanceledOnTouchOutside(true);
    this.dzt = (ListView)this.dzr.findViewById(R.id.ss_listview);
    this.dzs = this.dzr.findViewById(R.id.lines);
    this.aNl = (TextView)this.dzr.findViewById(R.id.ss_title);
    this.dzq = (Button)this.dzr.findViewById(R.id.ss_cancel);
  }
  
  public void C(String[] paramArrayOfString) { this.dzS = paramArrayOfString; }
  
  public void a(BaseAdapter paramBaseAdapter) { this.dzT = paramBaseAdapter; }
  
  public void a(a parama) { this.btm = parama; }
  
  public void aW(double paramDouble) { this.dzv = paramDouble; }
  
  public View ark() { return this.dzr; }
  
  public void gn(int paramInt) { this.bsN = paramInt; }
  
  public void pb(String paramString) { // Byte code:
    //   0: aload_0
    //   1: getfield dzS : [Ljava/lang/String;
    //   4: ifnull -> 41
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: aload_0
    //   11: getfield dzS : [Ljava/lang/String;
    //   14: arraylength
    //   15: if_icmpge -> 41
    //   18: aload_0
    //   19: getfield dzS : [Ljava/lang/String;
    //   22: iload_2
    //   23: aaload
    //   24: aload_1
    //   25: invokevirtual equals : (Ljava/lang/Object;)Z
    //   28: ifeq -> 34
    //   31: goto -> 43
    //   34: iload_2
    //   35: iconst_1
    //   36: iadd
    //   37: istore_2
    //   38: goto -> 9
    //   41: iconst_0
    //   42: istore_2
    //   43: aload_0
    //   44: iload_2
    //   45: putfield bsN : I
    //   48: return }
  
  public void setContentView(int paramInt) { this.dzr = LayoutInflater.from(this.context).inflate(paramInt, null); }
  
  public void setTitle(String paramString) {
    if (paramString == null) {
      this.aNl.setVisibility(8);
      return;
    } 
    this.aNl.setText(paramString);
  }
  
  public void setWidth(int paramInt) { this.dzx = paramInt; }
  
  public void show() { show(R.layout.pos_spinner_item); }
  
  public void show(int paramInt) {
    if (this.dzT == null || !this.dzX) {
      b b = new b(this, this.context, this.dzS, paramInt);
      b.kQ(this.dzW);
      a(b);
    } 
    setContentView(this.dzr);
    this.dzq.setOnClickListener(new x(this));
    this.dzt.setAdapter(this.dzT);
    this.dzT.notifyDataSetChanged();
    if (this.dzV)
      this.dzq.setVisibility(8); 
    super.show();
    (new s()).dq(this.dzt);
    Display display = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay();
    WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
    if (this.dzw > 0.0D)
      layoutParams.height = (int)(display.getHeight() * this.dzw); 
    if (this.dzv > 0.0D)
      layoutParams.width = (int)(display.getWidth() * this.dzv); 
    if (this.dzx > 0)
      layoutParams.width = this.dzx; 
    this.dzt.setVerticalScrollBarEnabled(false);
    this.dzt.setOnTouchListener(new y(this));
    if (this.dzT.getCount() <= 4) {
      ViewGroup.LayoutParams layoutParams1 = this.dzt.getLayoutParams();
      layoutParams1.width = -1;
      layoutParams1.height = ae.b(this.context, (this.dzT.getCount() * 49));
      this.dzt.setLayoutParams(layoutParams1);
      this.dzt.setVerticalScrollBarEnabled(false);
    } else {
      this.dzs.setVisibility(0);
    } 
    getWindow().setAttributes(layoutParams);
  }
  
  public static interface a {
    void bA(boolean param1Boolean);
    
    void dL(int param1Int);
  }
  
  private class b extends BaseAdapter {
    private int align;
    
    private Context context;
    
    private int dAb;
    
    private String[] dAc = new String[0];
    
    public b(w this$0, Context param1Context, String[] param1ArrayOfString, int param1Int) {
      this.context = param1Context;
      this.dAc = param1ArrayOfString;
      this.dAb = param1Int;
    }
    
    public int getCount() { return this.dAc.length; }
    
    public Object getItem(int param1Int) { return null; }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      byte b1;
      a a;
      View view;
      null = new a(this);
      if (param1View == null) {
        View view1 = LayoutInflater.from(this.context).inflate(this.dAb, null);
        null.dAh = (LinearLayout)view1.findViewById(R.id.spinner_lay);
        null.dAg = (TextView)view1.findViewById(R.id.spinner_text);
        null.dAi = (CheckBox)view1.findViewById(R.id.spinner_radio);
        null.dAj = view1.findViewById(R.id.lines);
        view1.setTag(null);
        null.dAg.setGravity(this.align);
        param1View = view1;
        a = null;
        if (w.e(this.dAa)) {
          null = (LinearLayout.LayoutParams)null.dAg.getLayoutParams();
          null.setMargins(0, 0, 0, 0);
          null.dAg.setLayoutParams(null);
          view = view1;
          a = null;
        } 
      } else {
        a = (a)view.getTag();
      } 
      CheckBox checkBox = a.dAi;
      if (w.e(this.dAa)) {
        b1 = 8;
      } else {
        b1 = 0;
      } 
      checkBox.setVisibility(b1);
      if (this.dAa.bsN >= 0 && this.dAa.bsN == param1Int) {
        w.a(this.dAa, checkBox);
        checkBox.setChecked(true);
      } else {
        checkBox.setChecked(false);
      } 
      if (w.f(this.dAa))
        checkBox.setEnabled(false); 
      if (w.g(this.dAa).length > 4 && param1Int == 0) {
        a.dAj.setVisibility(8);
      } else {
        a.dAj.setVisibility(0);
      } 
      a.dAg.setText(this.dAc[param1Int]);
      if (w.f(this.dAa) && w.h(this.dAa) != null && w.h(this.dAa).containsKey(this.dAc[param1Int]))
        checkBox.setChecked(true); 
      aa aa = new aa(this, checkBox, param1Int);
      a.dAh.setOnClickListener(aa);
      a.dAi.setOnClickListener(aa);
      return view;
    }
    
    public void kQ(int param1Int) { this.align = param1Int; }
    
    public class a {
      TextView dAg;
      
      LinearLayout dAh;
      
      CheckBox dAi;
      
      View dAj;
      
      public a(w.b this$0) {}
    }
  }
  
  public class a {
    TextView dAg;
    
    LinearLayout dAh;
    
    CheckBox dAi;
    
    View dAj;
    
    public a(w this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */