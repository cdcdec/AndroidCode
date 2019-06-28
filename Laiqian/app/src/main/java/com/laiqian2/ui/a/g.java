package com.laiqian.ui.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class g<entity extends g.b> extends aq<entity> {
  private List<entity>[] dzk = new ArrayList[1];
  
  private boolean dzl;
  
  @Nullable
  private HashSet<Long> dzm;
  
  @Nullable
  private c<entity> dzn;
  
  public g(Context paramContext, List<entity> paramList, aq.a<entity> parama) {
    super(paramContext, parama);
    this.dzk[0] = paramList;
    this.dzl = false;
  }
  
  public g(Context paramContext, List<entity>[] paramArrayOfList, aq.a<entity> parama) {
    super(paramContext, parama);
    this.dzl = false;
  }
  
  public g(FragmentActivity paramFragmentActivity, List<entity> paramList, @NonNull c<entity> paramc) {
    super(paramFragmentActivity, null);
    this.dzk[0] = paramList;
    this.dzl = true;
    this.dzn = paramc;
    this.dzm = new HashSet();
    ((TextView)this.dAA).setText(R.string.pos_product_dialog_sure);
    this.dAA.setOnClickListener(new h(this));
  }
  
  public void a(List<entity>[] paramArrayOfList) { this.dzk = paramArrayOfList; }
  
  protected boolean a(entity paramentity) {
    if (this.dzl && this.dzm != null) {
      if (this.dzm.contains(Long.valueOf(paramentity.AR()))) {
        this.dzm.remove(Long.valueOf(paramentity.AR()));
      } else {
        this.dzm.add(Long.valueOf(paramentity.AR()));
      } 
      this.dAv.notifyDataSetChanged();
      return true;
    } 
    return super.aS(paramentity);
  }
  
  public void l(long[] paramArrayOfLong) {
    if (this.dzm != null) {
      this.dzm.clear();
      int i = paramArrayOfLong.length;
      for (byte b = 0; b < i; b++) {
        long l = paramArrayOfLong[b];
        this.dzm.add(Long.valueOf(l));
      } 
    } 
    show();
  }
  
  protected aq<entity>.b yd() { return new a(this, null); }
  
  private class a extends aq<entity>.b {
    private a(g this$0) { super(this$0); }
    
    protected long dI(int param1Int) { return kO(param1Int).AR(); }
    
    protected CharSequence dJ(int param1Int) { return kO(param1Int).AT(); }
    
    protected CharSequence dK(int param1Int) { return kO(param1Int).AS(); }
    
    public int getCount() { return g.d(this.dzo)[this.dzo.dAy].size(); }
    
    protected boolean kN(int param1Int) { return (g.c(this.dzo) && g.b(this.dzo) != null) ? g.b(this.dzo).contains(Long.valueOf(dI(param1Int))) : super.kN(param1Int); }
    
    public entity kO(int param1Int) { return (entity)(g.b)g.d(this.dzo)[this.dzo.dAy].get(param1Int); }
  }
  
  class g {}
  
  public static interface c<T> {
    void a(aq param1aq, ArrayList<T> param1ArrayList);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */