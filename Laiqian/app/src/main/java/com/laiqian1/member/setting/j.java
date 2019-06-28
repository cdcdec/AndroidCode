package com.laiqian.member.setting;

import android.content.Context;
import android.os.AsyncTask;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.g;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.container.aa;
import com.laiqian.vip.R;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.h;
import io.reactivex.i;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

public class j implements aa {
  Queue<Integer> bBA;
  
  private g bBx;
  
  private g bBy;
  
  private m bBz;
  
  private Context mContext;
  
  public j(Context paramContext, g paramg1, g paramg2, m paramm, @NotNull BlockingQueue<Integer> paramBlockingQueue) {
    this.mContext = paramContext;
    this.bBy = paramg1;
    this.bBx = paramg2;
    this.bBz = paramm;
    this.bBA = paramBlockingQueue;
  }
  
  public boolean Az() { return false; }
  
  public void a(aa paramaa) { save(); }
  
  public void delete() { h.a(new k(this)).d(a.aKh()).c(a.aJo()).b(new l(this)); }
  
  public void fU(String paramString) { this.bBz.fU(paramString); }
  
  public void save() { (new a(this, this.bBx)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private g bBC;
    
    a(j this$0, g param1g) { this.bBC = param1g; }
    
    protected void b(Boolean param1Boolean) throws Exception {
      if (param1Boolean.booleanValue()) {
        this.bBD.fU(j.a(this.bBD).getString(R.string.save_success));
        j.b(this.bBD).close();
        return;
      } 
      this.bBD.fU(j.a(this.bBD).getString(R.string.save_settings_failed));
      j.b(this.bBD).Rr();
    }
    
    protected Boolean g(Void... param1VarArgs) { return RootApplication.getLaiqianPreferenceManager().avl() ? Boolean.valueOf(bc.RH().b(j.a(this.bBD), this.bBC, this.bBD.bBA)) : Boolean.valueOf(bc.RH().a(j.a(this.bBD), this.bBC, this.bBD.bBA)); }
    
    protected void onPreExecute() {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */