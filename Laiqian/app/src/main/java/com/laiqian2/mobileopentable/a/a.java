package com.laiqian.mobileopentable.a;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.opentable.R;

public class a extends Dialog {
  private a bNc;
  
  public a(@NonNull Context paramContext) {
    super(paramContext, R.style.pos_dialog);
    setContentView(R.layout.mobile_list_dialog);
    this.bNc = new a(this, findViewById(R.id.llRoot));
    this.bNc.bNf.setOnClickListener(new b(this));
  }
  
  public a a(AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.bNc.bNe.setOnItemClickListener(paramOnItemClickListener);
    return this;
  }
  
  public a b(ListAdapter paramListAdapter) {
    this.bNc.bNe.setAdapter(paramListAdapter);
    return this;
  }
  
  public a ga(@StringRes int paramInt) {
    this.bNc.tvTitle.setText(paramInt);
    return this;
  }
  
  protected class a {
    View aQG;
    
    ListView bNe;
    
    TextView bNf;
    
    TextView tvTitle;
    
    protected a(a this$0, View param1View) {
      this.aQG = param1View;
      this.tvTitle = (TextView)this.aQG.findViewById(R.id.tvTitle);
      this.bNe = (ListView)this.aQG.findViewById(R.id.lvContent);
      this.bNf = (TextView)this.aQG.findViewById(R.id.tvCancel);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */