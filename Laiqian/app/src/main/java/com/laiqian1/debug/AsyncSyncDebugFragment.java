package com.laiqian.debug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.google.a.a.a.a.a.a;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.a;
import com.laiqian.sync.a.f;
import com.laiqian.sync.c.a;
import com.orhanobut.logger.d;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncSyncDebugFragment extends Fragment {
  a aQm;
  
  ExecutorService adJ = null;
  
  private void start() {
    this.adJ = Executors.newFixedThreadPool(1);
    for (byte b = 0; b < 1; b++)
      this.adJ.submit(new b(a.dob)); 
    this.aQm.aQp.setText("Stop");
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131427580, null);
    this.aQm = new a(view);
    this.aQm.aQp.setOnClickListener(new a(this));
    return view;
  }
  
  static final class a {
    RelativeLayout aQo;
    
    Button aQp;
    
    a(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.aQp = (Button)param1View.findViewById(2131296652);
    }
    
    static a a(LayoutInflater param1LayoutInflater) { return new a(param1LayoutInflater.inflate(2131427580, null)); }
  }
  
  private static class b implements Runnable {
    private a aQq;
    
    public b(a param1a) { this.aQq = param1a; }
    
    public void run() {
      for (byte b1 = 0; b1 < 'ᎈ'; b1++) {
        try {
          this.aQq.a(a.aOD, System.currentTimeMillis(), Arrays.asList(a.dpn.split(",")));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("requesting index: ");
          stringBuilder.append(b1);
          d.d(stringBuilder.toString(), new Object[0]);
        } catch (f f) {
          a.e(f);
        } 
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\debug\AsyncSyncDebugFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */