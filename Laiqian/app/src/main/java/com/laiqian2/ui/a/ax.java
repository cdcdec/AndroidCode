package com.laiqian.ui.a;

import android.app.Activity;
import android.support.annotation.ArrayRes;

public class ax extends aq<CharSequence> {
  private final CharSequence[][] dAI;
  
  public ax(Activity paramActivity, @ArrayRes int paramInt, aq.a<CharSequence> parama) { this(paramActivity, new CharSequence[][] { paramActivity.getResources().getTextArray(paramInt) }, parama); }
  
  public ax(Activity paramActivity, CharSequence[] paramArrayOfCharSequence, aq.a<CharSequence> parama) { this(paramActivity, new CharSequence[][] { paramArrayOfCharSequence }, parama); }
  
  public ax(Activity paramActivity, CharSequence[][] paramArrayOfCharSequence, aq.a<CharSequence> parama) {
    super(paramActivity, parama);
    this.dAI = paramArrayOfCharSequence;
  }
  
  protected aq<CharSequence>.b yd() { return new a(this, null); }
  
  private class a extends aq<CharSequence>.b {
    private a(ax this$0) { super(this$0); }
    
    protected long dI(int param1Int) { return param1Int; }
    
    protected CharSequence dJ(int param1Int) { return kX(param1Int); }
    
    protected CharSequence dK(int param1Int) { return kX(param1Int); }
    
    public int getCount() { return ax.a(this.dAJ)[this.dAJ.dAy].length; }
    
    public CharSequence kX(int param1Int) { return ax.a(this.dAJ)[this.dAJ.dAy][param1Int]; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */