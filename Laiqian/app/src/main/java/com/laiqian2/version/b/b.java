package com.laiqian.version.b;

import android.content.Context;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.util.av;
import com.laiqian.version.a.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class b extends BaseAdapter {
  private List<c> dIW = new ArrayList();
  
  private List<c> dIX = new ArrayList();
  
  private Context dIY;
  
  private int dIZ = 2;
  
  private int dJa = 0;
  
  private String dJb;
  
  private boolean dJc = true;
  
  String dJd;
  
  private View.OnClickListener dJe = new c(this);
  
  String username;
  
  public b(Context paramContext, List<c> paramList, String paramString1, String paramString2) { this(paramContext, paramList, paramString1, paramString2, false); }
  
  public b(Context paramContext, List<c> paramList, String paramString1, String paramString2, boolean paramBoolean) {
    if (!paramBoolean) {
      this.dIY = paramContext;
      if (paramList != null && paramList.size() <= 2) {
        this.dIW.addAll(paramList);
      } else if (paramList != null) {
        this.dIW.addAll(paramList.subList(0, 2));
        this.dIX.addAll(paramList.subList(2, paramList.size()));
      } 
      this.username = (new av(paramContext)).Ea();
      this.dJd = paramString1;
    } else {
      this.dIY = paramContext;
      this.dIW.addAll(paramList);
      this.username = (new av(paramContext)).Ea();
      this.dJd = paramString1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("what: ");
      stringBuilder.append(this.dIW.size());
      Log.e("bbcd", stringBuilder.toString());
    } 
    this.dJb = paramString2;
  }
  
  public String axb() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.dIZ);
    return stringBuilder.toString();
  }
  
  public void axc() {
    if (this.dIX.size() <= 5) {
      this.dIW.addAll(this.dIX);
      this.dIX.clear();
    } else {
      this.dIW.addAll(this.dIX.subList(0, 5));
      this.dIX = this.dIX.subList(5, this.dIX.size());
    } 
    notifyDataSetChanged();
  }
  
  public int axd() { return this.dIX.size(); }
  
  public int axe() { return this.dJa - this.dIW.size(); }
  
  public int getCount() { return this.dIW.size(); }
  
  public Object getItem(int paramInt) { return this.dIW.get(paramInt); }
  
  public long getItemId(int paramInt) { return paramInt; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    SpannableString spannableString;
    a a;
    if (paramView == null) {
      paramView = LayoutInflater.from(this.dIY).inflate(R.layout.version_reply_item, null);
      a = a.dy(paramView);
    } else {
      a = (a)paramView.getTag();
    } 
    c c = (c)this.dIW.get(paramInt);
    if (c.user.equals(this.dJd) || c.user.equals("customer")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.dJd.substring(0, 3));
      stringBuilder1.append("****");
      stringBuilder1.append(this.dJd.substring(7, this.dJd.length()));
      stringBuilder1.append(" : ");
      spannableString = new SpannableString(stringBuilder1.toString());
    } else {
      spannableString = new SpannableString("客服 : ");
    } 
    a.aKu.setText(spannableString);
    String str2 = (new SimpleDateFormat("yyyy-MM-dd  HH:mm")).format(new Date(Long.parseLong(c.ciB)));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(Calendar.getInstance().get(1));
    String str1 = str2;
    if (str2.startsWith(stringBuilder.toString()))
      str1 = str2.substring(5, str2.length()); 
    a.dJh.setText(str1);
    str1 = g.sm(c.acL);
    a.dJg.setText(str1);
    a.dJi.setOnClickListener(this.dJe);
    if (paramInt == getCount() - 1 && this.username.equals(this.dJd) && this.dJc) {
      a.dJi.setVisibility(0);
    } else {
      a.dJi.setVisibility(4);
    } 
    paramView.setTag(a);
    return paramView;
  }
  
  public void h(List<c> paramList, int paramInt) {
    this.dIX.addAll(paramList);
    if (this.dIZ == paramInt) {
      this.dIZ++;
      return;
    } 
    this.dIZ = paramInt;
  }
  
  public void hZ(boolean paramBoolean) { this.dJc = paramBoolean; }
  
  public void mo(int paramInt) { this.dJa = paramInt; }
  
  private static class a {
    TextView aKu;
    
    TextView dJg;
    
    TextView dJh;
    
    View dJi;
    
    public a(TextView param1TextView1, TextView param1TextView2, TextView param1TextView3, View param1View) {
      this.aKu = param1TextView1;
      this.dJg = param1TextView2;
      this.dJh = param1TextView3;
      this.dJi = param1View;
    }
    
    public static a dy(View param1View) { return new a((TextView)param1View.findViewById(R.id.username), (TextView)param1View.findViewById(R.id.reply), (TextView)param1View.findViewById(R.id.datetime), param1View.findViewById(R.id.doReply)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */