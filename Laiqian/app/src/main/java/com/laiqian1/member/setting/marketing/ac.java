package com.laiqian.member.setting.marketing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;
import com.laiqian.vip.R;

public class ac extends d implements TextWatcher, View.OnClickListener {
  private String aVs = "";
  
  private a bFj;
  
  private final EditText bFk;
  
  private final TextView bFl;
  
  private final TextView bFm;
  
  private final TextView bFn;
  
  private SpannableStringBuilder bFo;
  
  private int bFp;
  
  private final Context mContext;
  
  public ac(ActivityRoot paramActivityRoot, int paramInt) {
    super(paramActivityRoot, R.layout.dialog_edit_sms);
    setPositionTop();
    this.mContext = paramActivityRoot;
    this.bFl = (TextView)this.mView.findViewById(R.id.tv_sms_content_length);
    this.bFk = (EditText)this.mView.findViewById(R.id.ed_sms_content);
    this.bFm = (TextView)this.mView.findViewById(R.id.tv_canal);
    this.bFn = (TextView)this.mView.findViewById(R.id.tv_sure);
    if (paramInt == 0) {
      a(ga(this.mContext.getString(R.string.vip_marketing_sms_content_template)));
    } else if (paramInt == 1) {
      a(ga(this.mContext.getString(R.string.vip_birthday_wishes_sms_content_template)));
    } 
    Ek();
  }
  
  private void Ek() {
    this.bFk.addTextChangedListener(this);
    this.bFl.setOnClickListener(this);
    this.bFm.setOnClickListener(this);
    this.bFn.setOnClickListener(this);
  }
  
  private SpannableStringBuilder Sw() { return this.bFo; }
  
  @Nullable
  private SpannableStringBuilder Sx() { return Sw(); }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder) { this.bFo = paramSpannableStringBuilder; }
  
  @NonNull
  private SpannableStringBuilder ga(String paramString) {
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(paramString);
    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.pos_text_brown)), 0, paramString.length(), 33);
    return spannableStringBuilder;
  }
  
  public void a(a parama) { this.bFj = parama; }
  
  public void afterTextChanged(Editable paramEditable) {
    String str = this.bFk.getText().toString().trim();
    TextView textView = this.bFl;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str.length());
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    SpannableStringBuilder spannableStringBuilder = ga(str);
    a(spannableStringBuilder);
    spannableStringBuilder.toString().length();
    this.bFj.g(Sw().toString(), str.length());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) { Sx(); }
  
  public void fU(int paramInt) { this.bFp = paramInt; }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.tv_canal) {
      cancel();
      return;
    } 
    if (i == R.id.tv_sure)
      cancel(); 
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void show() {
    this.bFk.requestFocus();
    SpannableStringBuilder spannableStringBuilder = Sx();
    this.bFk.setText(spannableStringBuilder);
    this.bFk.selectAll();
    super.show();
  }
  
  public static interface a {
    void g(String param1String, int param1Int);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */