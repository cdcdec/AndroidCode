package com.laiqian.version.b;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.version.a.d;
import com.laiqian.version.c.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d extends BaseAdapter {
  private Context dIY;
  
  private int dJa = 0;
  
  private String dJb;
  
  private List<d> dJj = new ArrayList();
  
  private List<d> dJk = new ArrayList();
  
  private int dJl = 2;
  
  private a dJm;
  
  private Map<Integer, b> dJn = new HashMap();
  
  public d(Context paramContext, List<d> paramList, a parama, String paramString, int paramInt) {
    this.dIY = paramContext;
    if (paramList != null && paramList.size() <= 3) {
      this.dJj.addAll(paramList);
    } else if (this.dJj != null) {
      this.dJj.addAll(paramList.subList(0, 3));
      this.dJk.addAll(paramList.subList(3, paramList.size()));
    } 
    this.dJm = parama;
    this.dJb = paramString;
    this.dJl = paramInt + 1;
  }
  
  private void a(int paramInt, d paramd, ListView paramListView, String paramString) {
    b b;
    paramListView.setVisibility(0);
    if (this.dJn.get(Integer.valueOf(paramInt)) == null) {
      b = new b(this.dIY, paramd.dIF, paramString, this.dJb, false);
      this.dJn.put(Integer.valueOf(paramInt), b);
    } else {
      b = (b)this.dJn.get(Integer.valueOf(paramInt));
    } 
    b.hZ(false);
    b.mo(paramd.dIE);
    if (paramd.dIF != null && (paramd.dIE > 2 || paramd.dIF.size() > 2)) {
      View view = LayoutInflater.from(this.dIY).inflate(R.layout.version_reply_footer, null);
      FrameLayout frameLayout = new FrameLayout(this.dIY);
      frameLayout.addView(view);
      TextView textView = (TextView)view.findViewById(R.id.footerText);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("");
      stringBuilder2.append(paramd.dID);
      textView.setTag(stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("展开");
      stringBuilder1.append(b.axe());
      stringBuilder1.append("条回复");
      textView.setText(stringBuilder1.toString());
      textView.setOnClickListener(new e(this, b, paramInt, view, paramListView, frameLayout));
      if (b.axe() > 0)
        paramListView.addFooterView(frameLayout); 
      paramListView.setAdapter(b);
      return;
    } 
    paramListView.setAdapter(b);
  }
  
  public String axb() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.dJl);
    return stringBuilder.toString();
  }
  
  public void axc() {
    if (this.dJk.size() <= 5) {
      this.dJj.addAll(this.dJk);
      this.dJk.clear();
    } else {
      this.dJj.addAll(this.dJk.subList(0, 5));
      this.dJk = this.dJk.subList(5, this.dJk.size());
    } 
    notifyDataSetChanged();
  }
  
  public int axd() { return this.dJk.size(); }
  
  public int axe() { return this.dJa - this.dJj.size(); }
  
  public int getCount() { return this.dJj.size(); }
  
  public Object getItem(int paramInt) { return this.dJj.get(paramInt); }
  
  public long getItemId(int paramInt) { return paramInt; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view = LayoutInflater.from(this.dIY).inflate(R.layout.version_topic_item, null);
    a a1 = a.dz(view);
    d d1 = (d)this.dJj.get(paramInt);
    String str1 = d1.dIA;
    null = new StringBuilder();
    null.append(str1.substring(0, 3));
    null.append("****");
    null.append(str1.substring(7, str1.length()));
    null.append(" : ");
    str1 = null.toString();
    a1.dJu.setText(str1);
    str1 = g.sm(d1.dIB);
    null = new SpannableString(str1);
    null.setSpan(new ForegroundColorSpan(this.dIY.getResources().getColor(R.color.member_list_item_max)), 0, str1.length(), 33);
    a1.dJu.append(null);
    if (d1.dIC == null) {
      a1.dJv.setRating(5.0F);
    } else {
      a1.dJv.setRating(Float.parseFloat(d1.dIC));
    } 
    String str2 = (new SimpleDateFormat("yyyy-MM-dd  HH:mm")).format(new Date(Long.parseLong(d1.ciB)));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(Calendar.getInstance().get(1));
    str1 = str2;
    if (str2.startsWith(stringBuilder.toString()))
      str1 = str2.substring(5, str2.length()); 
    a1.dJh.setText(str1);
    if (d1.dIF != null && d1.dIF.size() > 0) {
      a(paramInt, d1, a1.dJw, d1.dIA);
    } else {
      a1.dJw.setAdapter(null);
    } 
    view.setTag(a1);
    return view;
  }
  
  public void i(List<d> paramList, int paramInt) {
    this.dJk.addAll(paramList);
    this.dJl = paramInt + 1;
  }
  
  public void mo(int paramInt) { this.dJa = paramInt; }
  
  public void mp(int paramInt) {
    d d1 = (d)this.dJj.get(paramInt);
    this.dJj.remove(paramInt);
    this.dJj.add(paramInt, d1);
  }
  
  private static class a {
    TextView dJh;
    
    TextView dJu;
    
    RatingBar dJv;
    
    ListView dJw;
    
    public a(TextView param1TextView1, TextView param1TextView2, RatingBar param1RatingBar, ListView param1ListView) {
      this.dJu = param1TextView1;
      this.dJh = param1TextView2;
      this.dJv = param1RatingBar;
      this.dJw = param1ListView;
    }
    
    public static a dz(View param1View) { return new a((TextView)param1View.findViewById(R.id.topic), (TextView)param1View.findViewById(R.id.datetime), (RatingBar)param1View.findViewById(R.id.rating), (ListView)param1View.findViewById(R.id.replies)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */