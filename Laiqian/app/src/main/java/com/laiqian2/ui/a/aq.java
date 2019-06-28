package com.laiqian.ui.a;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.infrastructure.R;

public abstract class aq<V> extends f {
  protected View dAA;
  
  private boolean dAB = true;
  
  private int dAC = 19;
  
  b dAv;
  
  @Nullable
  private final a<V> dAw;
  
  private long dAx;
  
  protected int dAy;
  
  @Nullable
  private TextView dAz;
  
  private boolean dzy = true;
  
  private Context mActivity;
  
  private Object object;
  
  private ListView wV;
  
  protected aq(Context paramContext, @Nullable a<V> parama) {
    super(paramContext, R.style.pos_dialog);
    this.mActivity = paramContext;
    this.dAw = parama;
    this.dAy = 0;
    setContentView(R.layout.select_dialog);
    B(0.3F);
    this.wV = (ListView)findViewById(R.id.body);
    this.wV.setOnItemClickListener(new ar(this));
    this.dAv = yd();
    this.dAA = findViewById(R.id.cancel);
    this.dAA.setOnClickListener(new as(this));
  }
  
  public void B(float paramFloat) {
    if (paramFloat > 0.0F && paramFloat <= 1.0F) {
      DisplayMetrics displayMetrics = this.mActivity.getResources().getDisplayMetrics();
      (getWindow().getAttributes()).width = (int)(displayMetrics.widthPixels * paramFloat);
    } 
  }
  
  protected boolean aS(V paramV) { return false; }
  
  public void aT(Object paramObject) {
    this.object = paramObject;
    dn(-1L);
    show();
  }
  
  @Nullable
  public V arr() {
    for (byte b1 = 0; b1 < this.dAv.getCount(); b1++) {
      if (this.dAx == this.dAv.dI(b1))
        return (V)this.dAv.getItem(b1); 
    } 
    return null;
  }
  
  public void b(TextView paramTextView, int paramInt) {
    this.dAz = paramTextView;
    if (this.dAz != null && paramInt >= 0 && paramInt < this.dAv.getCount())
      kR(paramInt); 
  }
  
  public void cancel() { super.cancel(); }
  
  public aq dn(long paramLong) {
    if (this.dAz != null) {
      for (byte b1 = 0; b1 < this.dAv.getCount(); b1++) {
        if (paramLong == this.dAv.dI(b1)) {
          kR(b1);
          return this;
        } 
      } 
      this.dAx = -1L;
      return this;
    } 
    this.dAx = paramLong;
    return this;
  }
  
  public <T> T getObject() { return (T)this.object; }
  
  public void hf(boolean paramBoolean) { this.dzy = paramBoolean; }
  
  public void hg(boolean paramBoolean) { this.dAB = paramBoolean; }
  
  public void kR(int paramInt) {
    this.dAx = this.dAv.dI(paramInt);
    if (this.dAz != null) {
      this.dAz.setText(this.dAv.dJ(paramInt));
      this.dAz.setTag(Long.valueOf(this.dAx));
    } 
  }
  
  public void kS(int paramInt) { this.dAy = paramInt; }
  
  @Nullable
  public V kT(int paramInt) { return (paramInt < this.dAv.getCount()) ? (V)this.dAv.getItem(paramInt) : null; }
  
  public void setTitle(@StringRes int paramInt) { setTitle(this.mActivity.getText(paramInt)); }
  
  public void setTitle(CharSequence paramCharSequence) { ((TextView)findViewById(R.id.title)).setText(paramCharSequence); }
  
  public void show() {
    if (this.dAz != null) {
      Object object1 = this.dAz.getTag();
      if (object1 != null && object1 instanceof Number) {
        this.dAx = ((Number)object1).longValue();
      } else {
        this.dAx = 0L;
      } 
    } 
    if (this.wV.getAdapter() == null) {
      this.wV.setAdapter(this.dAv);
    } else {
      this.dAv.notifyDataSetChanged();
    } 
    super.show();
  }
  
  protected abstract b yd();
  
  public static interface a<T> {
    void a(aq param1aq, int param1Int, T param1T);
  }
  
  protected abstract class b extends BaseAdapter {
    protected b(aq this$0) {}
    
    protected abstract long dI(int param1Int);
    
    protected abstract CharSequence dJ(int param1Int);
    
    protected abstract CharSequence dK(int param1Int);
    
    public abstract V getItem(int param1Int);
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      byte b1;
      a a;
      if (param1View == null) {
        param1View = View.inflate(aq.d(this.dAD), R.layout.select_dialog_item, null);
        a = new a(this, param1View.findViewById(R.id.line), (TextView)param1View.findViewById(R.id.text), param1View.findViewById(R.id.selected), null);
        param1View.setTag(a);
      } else {
        a = (a)param1View.getTag();
      } 
      View view = a.cfR;
      boolean bool = aq.e(this.dAD);
      byte b2 = 8;
      if (bool) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      view.setVisibility(b1);
      view = a.dfD;
      if (param1Int == 0) {
        b1 = b2;
      } else {
        b1 = 0;
      } 
      view.setVisibility(b1);
      a.cfR.setSelected(kN(param1Int));
      a.dAE.setText(dK(param1Int));
      a.dAE.setGravity(aq.f(this.dAD));
      return param1View;
    }
    
    protected boolean kN(int param1Int) { return (dI(param1Int) == aq.g(this.dAD)); }
    
    private class a {
      View cfR;
      
      TextView dAE;
      
      View dfD;
      
      private a(aq.b this$0, View param2View1, TextView param2TextView, View param2View2) {
        this.dfD = param2View1;
        this.dAE = param2TextView;
        this.cfR = param2View2;
      }
    }
  }
  
  private class a {
    View cfR;
    
    TextView dAE;
    
    View dfD;
    
    private a(aq this$0, View param1View1, TextView param1TextView, View param1View2) {
      this.dfD = param1View1;
      this.dAE = param1TextView;
      this.cfR = param1View2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */