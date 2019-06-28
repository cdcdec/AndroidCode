package com.laiqian.main.module.settlement.pay;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.v;
import com.laiqian.main.b.c;
import com.laiqian.main.module.settlement.a;
import com.laiqian.main.module.settlement.ag;
import com.laiqian.member.select.PosSelectVipDialog;
import com.laiqian.member.select.r;
import com.laiqian.member.select.y;
import com.laiqian.rx.util.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.m;
import com.laiqian.util.n;
import io.reactivex.a.a;
import io.reactivex.h;
import io.reactivex.h.a;
import java.util.ArrayList;
import java.util.List;

public class PosActivitySettlementDialogPayTypeFragment extends Fragment {
  private a blP;
  
  ag blQ;
  
  private b boH;
  
  private a boI;
  
  View boJ;
  
  private PosSelectVipDialog OU() {
    r r;
    if (CrashApplication.getLaiqianPreferenceManager().Wq()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(CrashApplication.getLaiqianPreferenceManager().Wq());
      stringBuilder.append("");
      Log.e("getBusinessMode", stringBuilder.toString());
      r = new y((ActivityRoot)getActivity());
    } else {
      null = new StringBuilder();
      null.append(CrashApplication.getLaiqianPreferenceManager().Wq());
      null.append("");
      Log.e("getBusinessMode", null.toString());
      r = new r((ActivityRoot)getActivity());
    } 
    r.a(new i(this));
    return r;
  }
  
  private void a(c paramc, List<v> paramList, v paramv) {
    if (paramc == null) {
      n.println("没有其他支付");
      return;
    } 
    if (paramList.size() == 1) {
      v v1 = (v)paramList.get(0);
      if (paramc == null) {
        n.println("其他支付的按钮View=null，这里不会进来");
        return;
      } 
      if (v1.FQ()) {
        paramc.a(v1.aTa, v1.name, v1.aSW);
        return;
      } 
      paramc.a(v1.aSX, v1.aTb, v1.name, 0L, 2131626884, getActivity().getString(2131627266));
      return;
    } 
    if (v.a(paramv)) {
      paramc.a(10013, 2131231336, getActivity().getString(2131626893), 0L, 2131626884, "");
      return;
    } 
    if (paramv.FQ()) {
      paramc.a(paramv.aTa, paramv.name, paramv.aSW);
      return;
    } 
    paramc.a(paramv.aSX, paramv.aTb, paramv.name, 0L, 2131626884, getActivity().getString(2131627266));
  }
  
  public static PosActivitySettlementDialogPayTypeFragment h(Bundle paramBundle) {
    PosActivitySettlementDialogPayTypeFragment posActivitySettlementDialogPayTypeFragment = new PosActivitySettlementDialogPayTypeFragment();
    posActivitySettlementDialogPayTypeFragment.setArguments(paramBundle);
    return posActivitySettlementDialogPayTypeFragment;
  }
  
  public void b(ag paramag) { this.blQ = paramag; }
  
  public void onCreate(@Nullable Bundle paramBundle) { super.onCreate(paramBundle); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) { return this.boJ; }
  
  public void onStop() {
    super.onStop();
    this.blP.clear();
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.blP = new a();
    this.boI = new a(getView(), getActivity());
    this.boH = new b(getActivity());
    a a1 = a.R(a.a(this.boI));
    this.blP.b(h.a(this.blQ.bmT.bnv, this.blQ.bmT.bnx, a1, this.blQ.bmB, new c(this)).b(this.blQ.bmT.bno));
    this.blP.b(h.a(this.blQ.bmT.bno, this.blQ.bmT.bnv, new k(this)).b(new j(this)));
    this.blP.b(this.boI.OY().d(new m(this)).b(new l(this)));
    this.blP.b(h.a(this.blQ.bmT.bnn, this.blQ.bmT.bno, this.blQ.bmT.bnx, this.blQ.bmC, new n(this)).b(this.blQ.bmT.bnm));
    this.blP.b(h.a(this.blQ.bmT.bnm, this.blQ.bmT.bnq, new q(this)).b(this.blQ.bmT.bns));
    this.blP.b(h.a(this.blQ.bmB, this.blQ.bmT.bno, this.blQ.bmT.bnx, this.blQ.bmT.bnz, new r(this)).b(this.blQ.bmT.bnp));
    this.blP.b(this.blQ.bmT.bnx.aJh().b(new s(this)));
    this.blP.b(this.boH.OY().b(this.blQ.bmT.bnz));
    this.blP.b(this.blQ.bmT.bnp.a(new a.a()).b(new d(this)));
    this.blP.b(h.a(this.blQ.bmC, this.blQ.bmT.bnC.bnT, new e(this)).aJk());
    this.blP.b(h.a(this.blQ.bmT.bnp, this.blQ.bmT.bnz, new h(this)).a(new g(this)).a(new f(this)).b(this.blQ.bmT.bnn));
  }
  
  public void setView(View paramView) { this.boJ = paramView; }
  
  static class a {
    a<c> aAq = a.aKk();
    
    View blX;
    
    private List<c> boN;
    
    ViewGroup boO;
    
    ViewGroup boP;
    
    ImageView boQ;
    
    private View.OnClickListener clickPayTypeItem = new t(this);
    
    Context mContext;
    
    RelativeLayout pay_type_setting_l;
    
    a(View param1View, Context param1Context) {
      this.blX = param1View;
      this.mContext = param1Context;
      this.boN = new ArrayList();
      this.boQ = (ImageView)param1View.findViewById(2131298372);
      this.pay_type_setting_l = (RelativeLayout)param1View.findViewById(2131298373);
      this.boO = (ViewGroup)param1View.findViewById(2131298367);
      a(this.boN, this.boO, 0);
      this.boP = (ViewGroup)param1View.findViewById(2131298368);
      a(this.boN, this.boP, 1);
      this.boQ.setOnClickListener(new m.c(this.mContext, com.laiqian.pos.PayTypeSettingActivity.class));
    }
    
    private void a(List<c> param1List, ViewGroup param1ViewGroup, int param1Int) {
      byte b;
      for (b = 0; b < param1ViewGroup.getChildCount(); b++) {
        View view = param1ViewGroup.getChildAt(b);
        if (b == 0 || param1Int == 0) {
          ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
          if (b == 0)
            marginLayoutParams.leftMargin = 0; 
          if (param1Int == 0)
            marginLayoutParams.topMargin = 0; 
        } 
        TextView textView1 = (TextView)view.findViewById(2131297257);
        TextView textView2 = (TextView)view.findViewById(2131298198);
        view.setVisibility(0);
        param1List.add(new c(view, textView1, textView2, this.clickPayTypeItem));
      } 
    }
    
    public void OW() {
      this.pay_type_setting_l.setVisibility(0);
      this.boO.setVisibility(0);
      this.boP.setVisibility(0);
    }
    
    public void OX() {
      this.pay_type_setting_l.setVisibility(8);
      this.boO.setVisibility(8);
      this.boP.setVisibility(8);
    }
    
    public h<c> OY() { return this.aAq; }
  }
  
  static class b {
    a<View> boS;
    
    final a<v> boT = a.aKk();
    
    private View.OnClickListener clickOtherPayTypeItem = new u(this);
    
    private Context mContext;
    
    ViewGroup otherPayViewGroup;
    
    PopupWindow otherPayWindow;
    
    b(Context param1Context) {
      this.mContext = param1Context;
      this.boS = a.aoI();
      this.otherPayViewGroup = (ViewGroup)LayoutInflater.from(param1Context).inflate(2131427836, null);
      this.otherPayWindow = new PopupWindow(this.otherPayViewGroup, -2, -2, true);
      this.otherPayWindow.setBackgroundDrawable(new ColorDrawable(false));
      this.otherPayWindow.setAnimationStyle(2131689689);
      this.otherPayWindow.setOutsideTouchable(true);
    }
    
    public h<v> OY() { return this.boT; }
    
    public PopupWindow OZ() { return this.otherPayWindow; }
    
    public List<View> Pa() { return this.boS.aoL(); }
    
    public void t(List<v> param1List) {
      this.otherPayViewGroup.removeAllViews();
      this.boS.clear();
      int i = param1List.size();
      View view = null;
      for (byte b1 = 0; b1 < i; b1++) {
        LinearLayout linearLayout;
        if (b1 % 7 == 0) {
          if (b1) {
            view = new View(this.mContext);
            view.setBackgroundColor(this.mContext.getResources().getColor(2131099824));
            this.otherPayViewGroup.addView(view, 1, -1);
          } 
          linearLayout = new LinearLayout(this.mContext);
          linearLayout.setOrientation(1);
          this.otherPayViewGroup.addView(linearLayout);
        } 
        View view1 = LayoutInflater.from(this.mContext).inflate(2131427837, null);
        if (linearLayout == null) {
          n.println("设置其他支付的子项时出错，这里不会进来");
          return;
        } 
        v v = (v)param1List.get(b1);
        ((TextView)view1.findViewById(2131298198)).setText(v.name);
        TextView textView = (TextView)view1.findViewById(2131297257);
        if (v.FQ()) {
          textView.setTextColor(-1);
          String str = new GradientDrawable();
          str.setShape(1);
          str.setColor(v.aTa);
          textView.setBackgroundDrawable(str);
          if (v.name.isEmpty()) {
            String str1 = " ";
          } else {
            str = String.valueOf(v.name.charAt(0));
          } 
          textView.setText(str);
        } else {
          textView.setBackgroundResource(v.aTb);
        } 
        view1.setTag(v);
        this.boS.add(view1);
        view1.setOnClickListener(this.clickOtherPayTypeItem);
        linearLayout.addView(view1);
      } 
    }
  }
  
  class c implements View.OnClickListener {
    private PopupWindow boV;
    
    public c(PosActivitySettlementDialogPayTypeFragment this$0, PopupWindow param1PopupWindow) { this.boV = param1PopupWindow; }
    
    public void onClick(View param1View) {
      Rect rect = new Rect();
      param1View.getGlobalVisibleRect(rect);
      int i = rect.right;
      int j = rect.top;
      this.boV.showAtLocation(param1View, 0, i + 5, j - 11);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\PosActivitySettlementDialogPayTypeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */