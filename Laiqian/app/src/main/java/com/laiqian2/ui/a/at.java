package com.laiqian.ui.a;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.keybord.a;
import com.laiqian.util.bg;

public class at extends d {
  private a dAG;
  
  private EditText dAl;
  
  private Button dAm;
  
  private Button dAn;
  
  private Context mContext;
  
  public at(Context paramContext) {
    super(paramContext, R.layout.dialog_base_soft_input);
    getWindow().setSoftInputMode(2);
    this.mContext = paramContext;
    initView();
    JZ();
  }
  
  private void JZ() {
    this.dAm.setOnClickListener(new au(this));
    this.dAn.setOnClickListener(new av(this));
  }
  
  private void initView() {
    this.dAl = (EditText)this.mView.findViewById(R.id.et_input);
    this.dAn = (Button)this.mView.findViewById(R.id.btn_left);
    this.dAm = (Button)this.mView.findViewById(R.id.btn_right);
    a.r(getWindow());
    this.dAl.setOnEditorActionListener(new aw(this));
  }
  
  public void a(a parama) { this.dAG = parama; }
  
  public void kU(int paramInt) { this.dAm.setText(paramInt); }
  
  public void kV(int paramInt) { this.dAn.setText(paramInt); }
  
  public void kW(int paramInt) { this.dAl.setHint(paramInt); }
  
  public void show() {
    EditText editText = this.dAl;
    String str = new StringBuilder();
    str.append(this.dAl.getTag());
    str.append("");
    if (bg.equals(str.toString(), "null")) {
      String str1 = "";
    } else {
      str = new StringBuilder();
      str.append(this.dAl.getTag());
      str.append("");
      str = str.toString();
    } 
    editText.setText(str);
    this.dAl.selectAll();
    super.show();
  }
  
  public static interface a {
    boolean b(View param1View, String param1String);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */