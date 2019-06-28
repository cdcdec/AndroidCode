package com.laiqian.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.keybord.a;
import com.laiqian.util.bg;
import com.laiqian.util.cm;

public class af extends d {
  private EditText dAl;
  
  private Button dAm;
  
  private Button dAn;
  
  private Context mContext;
  
  public af(Context paramContext) {
    super(paramContext, R.layout.dialog_queuing_machine);
    getWindow().setSoftInputMode(2);
    this.mContext = paramContext;
    initView();
    JZ();
  }
  
  private void JZ() {
    this.dAm.setOnClickListener(new ag(this));
    this.dAn.setOnClickListener(new ah(this));
  }
  
  private void arq() {
    String str = this.dAl.getText().toString().trim();
    this.dAl.setTag(str);
    if (!TextUtils.isEmpty(str))
      cm.cm(this.mContext).sh(str); 
  }
  
  private void initView() {
    this.dAl = (EditText)this.mView.findViewById(R.id.ed_queuing_machine);
    this.dAn = (Button)this.mView.findViewById(R.id.cancel);
    this.dAm = (Button)this.mView.findViewById(R.id.call);
    a.r(getWindow());
    this.dAl.setOnEditorActionListener(new ai(this));
  }
  
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
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\ui\a\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */