package com.laiqian.product;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.laiqian.product.models.a;
import com.laiqian.ui.a.d;
import com.laiqian.util.n;
import java.util.ArrayList;

public class eo extends d {
  private TextView aNl;
  
  private a aWm;
  
  private Activity azD;
  
  private final b cTu;
  
  private ViewGroup cTv;
  
  private ArrayList[] cTw;
  
  private int[] cTx;
  
  View.OnClickListener cTy = new er(this);
  
  public eo(Activity paramActivity, b paramb) {
    super(paramActivity, 2131427952);
    (getWindow().getAttributes()).width = (paramActivity.getResources().getDisplayMetrics()).widthPixels;
    ep ep = new ep(this);
    View view2 = this.mView.findViewById(2131299250).findViewById(2131296416);
    view2.setOnClickListener(ep);
    this.aNl = (TextView)view2.findViewById(2131299242);
    this.azD = paramActivity;
    this.cTu = paramb;
    this.cTv = (ViewGroup)this.mView.findViewById(2131298555);
    View view1 = this.mView.findViewById(2131296483);
    view1.findViewById(2131296671).setOnClickListener(ep);
    view1 = view1.findViewById(2131299105);
    view1.setSelected(true);
    view1.setOnClickListener(new eq(this));
  }
  
  private void a(View paramView, TextView paramTextView, int paramInt) {
    if (paramInt < 1) {
      paramView.setSelected(false);
      return;
    } 
    paramView.setSelected(true);
    if (paramInt > 1) {
      paramTextView.setText(n.h(new Object[] { "x", Integer.valueOf(paramInt) }));
      return;
    } 
    paramTextView.setText("");
  }
  
  private void cT(View paramView) {
    a a1 = (a)paramView.getTag();
    a1.cTB.add(paramView);
    a1.cTD++;
    if (a1.cTD < 1)
      a1.cTD = 1; 
    a(paramView, a1.blj, a1.cTD);
  }
  
  public void a(a parama, ArrayList<a.a> paramArrayList) {
    this.aWm = parama;
    this.aNl.setText(parama.cUM);
    this.cTv.removeAllViews();
    ((ScrollView)this.mView.findViewById(2131298556)).smoothScrollTo(0, 0);
    int i = paramArrayList.size();
    this.cTw = new ArrayList[i];
    this.cTx = new int[i];
    byte b1;
    for (b1 = 0; b1 < i; b1++) {
      boolean bool2;
      a.a a1 = (a.a)paramArrayList.get(b1);
      ViewGroup viewGroup = View.inflate(this.azD, 2131427955, null);
      TextView textView = (TextView)viewGroup.findViewById(2131297322);
      int k = a1.cPh.length;
      textView.setText(n.h(new Object[] { Integer.valueOf(k), this.azD.getString(2131626979), Integer.valueOf(a1.cUu) }));
      this.cTv.addView(viewGroup);
      if (a1.cUu >= k && k == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      ArrayList arrayList = new ArrayList();
      this.cTw[b1] = arrayList;
      this.cTx[b1] = a1.cUu;
      viewGroup = null;
      int j = 0;
      boolean bool1 = true;
      int m;
      for (m = 0; m < k; m++) {
        if (viewGroup == null) {
          j = 0;
        } else {
          j = m % viewGroup.getChildCount();
        } 
        if (j == 0) {
          if (viewGroup == null) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          viewGroup = (ViewGroup)View.inflate(this.azD, 2131427953, null);
          this.cTv.addView(viewGroup);
        } 
        View view = viewGroup.getChildAt(j);
        TextView textView1 = (TextView)view.findViewById(2131298563);
        a a2 = new a(this, textView1, (TextView)view.findViewById(2131298576), a1.cPh[m], arrayList, a1.cUu);
        textView1.setText(a1.cPi[m]);
        view.setTag(a2);
        if (bool2) {
          textView.setText(this.azD.getString(2131625693));
          if (k == 1) {
            byte b2;
            for (b2 = 0; b2 < a1.cUu; b2++)
              cT(view); 
          } else if (k == a1.cUu) {
            cT(view);
          } 
        } 
        view.setOnClickListener(this.cTy);
        if (j > 0)
          view.findViewById(2131297756).setVisibility(8); 
        if (!bool1)
          view.findViewById(2131297758).setVisibility(8); 
      } 
      if (viewGroup != null)
        while (++j < viewGroup.getChildCount()) {
          viewGroup.getChildAt(j).setVisibility(4);
          j++;
        }  
    } 
    super.show();
  }
  
  @Deprecated
  public void show() { super.show(); }
  
  class a {
    TextView bjG;
    
    TextView blj;
    
    long cTA;
    
    ArrayList<View> cTB;
    
    int cTC;
    
    int cTD;
    
    public a(eo this$0, TextView param1TextView1, TextView param1TextView2, long param1Long, ArrayList<View> param1ArrayList, int param1Int) {
      this.bjG = param1TextView1;
      this.blj = param1TextView2;
      this.cTA = param1Long;
      this.cTB = param1ArrayList;
      this.cTC = param1Int;
      this.cTD = 0;
    }
  }
  
  public static interface b {
    void a(a param1a);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */