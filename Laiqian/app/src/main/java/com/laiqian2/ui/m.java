package com.laiqian.ui;

import android.content.Context;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.f;
import java.util.HashMap;
import java.util.List;

public class m extends f {
  private int aGw;
  
  private Button bEK;
  
  private Window dwn;
  
  private EditText dwo;
  
  private String dwp;
  
  private List<HashMap<String, String>> dwq;
  
  Handler handler = new o(this);
  
  private Context mContext;
  
  public m(Context paramContext, int paramInt1, int paramInt2, int paramInt3, List<HashMap<String, String>> paramList, String paramString) {
    super(paramContext, paramInt1);
    this.mContext = paramContext;
    setContentView(paramInt2);
    this.dwn = getWindow();
    this.aGw = paramInt3;
    this.dwq = paramList;
    this.dwp = paramString;
    xT();
    setCancelable(false);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) { return (paramKeyEvent.getRepeatCount() > 0) ? false : ((paramInt == 4 && paramKeyEvent.getRepeatCount() == 0)); }
  
  public void xT() {
    this.bEK = (Button)this.dwn.findViewById(R.id.btnSend);
    this.dwo = (EditText)this.dwn.findViewById(R.id.et_content);
    this.bEK.setOnClickListener(new n(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */