package com.laiqian.print;

import android.os.Bundle;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.print.b.b;
import com.laiqian.print.model.PrintContent;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.s;

public class PrintDebugPreviewFragment extends FragmentRoot {
  a cCv;
  
  private void a(PrintContent paramPrintContent, int paramInt) {
    Spannable spannable = o.a(getActivity(), paramPrintContent, paramInt);
    this.cCv.cCw.setText(spannable);
  }
  
  private PrintContent aeo() {
    b b = new b();
    b.n(new int[] { 1, 32 });
    b.o(new int[] { 2, 0 });
    b.n(new int[] { 1, 12, 32 });
    b.o(new int[] { 2, 1, 0 });
    b.x(new String[] { "123456", "123456" });
    b.x(new String[] { "123456", "123456", "123456" });
    return b.afV();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.cCv = a.f(paramLayoutInflater);
    a(aeo(), 58);
    return this.cCv.aQG;
  }
  
  public static class a {
    public View aQG;
    
    public TextView cCw;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cCw = (TextView)s.z(param1View, 2131299642);
    }
    
    public static a f(LayoutInflater param1LayoutInflater) { return new a(param1LayoutInflater.inflate(2131427602, null)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\PrintDebugPreviewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */