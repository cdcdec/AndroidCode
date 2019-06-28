package com.laiqian.setting;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.av;
import com.laiqian.pos.industry.weiorder.fp;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.util.bd;

public class SettingWechatFragment extends FragmentRoot {
  private LinearLayout dlq;
  
  private TextView dlr;
  
  private TextView dmp;
  
  private TextView dmq;
  
  private LinearLayout dmt;
  
  private TextView dmu;
  
  private TextView dmv;
  
  private TextView dnc;
  
  private TextView dnd;
  
  private TextView dne;
  
  private TextView dnf;
  
  private LinearLayout dng;
  
  private LinearLayout dnh;
  
  private LinearLayout dnj;
  
  private TextView dnn;
  
  private TextView dno;
  
  private TextView dnp;
  
  private LinearLayout dnq;
  
  private void aoU() {
    if (getResources().getBoolean(2131034125) && getResources().getBoolean(2131034131))
      this.dnq.setVisibility(0); 
    if (!a.zR().Ab() && !a.zR().Ad()) {
      this.dng.setVisibility(0);
      this.dnj.setVisibility(0);
      this.dnh.setVisibility(0);
    } 
    if (getResources().getBoolean(2131034134) && a.zR().zU())
      this.dmt.setVisibility(0); 
    if (getResources().getBoolean(2131034125) && getResources().getBoolean(2131034130))
      this.dlq.setVisibility(0); 
  }
  
  private void kg(int paramInt) {
    if (!isDetached()) {
      if (getActivity() == null)
        return; 
      switch (paramInt) {
        default:
          return;
        case 2:
          if (this.dnd != null) {
            this.dnd.setVisibility(8);
            return;
          } 
          return;
        case 1:
          if (this.dnd != null) {
            this.dnd.setVisibility(0);
            this.dnd.setText(getString(2131628257));
            return;
          } 
          return;
        case 0:
          break;
      } 
      if (this.dnd != null) {
        this.dnd.setVisibility(0);
        this.dnd.setText(getString(2131628256));
      } 
      return;
    } 
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131428039, null);
    view.findViewById(2131300027).setOnClickListener(new by(getActivity(), com.laiqian.pos.industry.weiorder.WeshopSettingsActivity.class, null));
    this.dnq = (LinearLayout)view.findViewById(2131298431);
    this.dnq.setOnClickListener(new by(getActivity(), com.laiqian.pos.industry.weiorder.TddSetting.class, ""));
    this.dng = (LinearLayout)view.findViewById(2131298121);
    this.dng.setOnClickListener(new by(getActivity(), com.laiqian.meituan.MeituanActivity.class, ""));
    this.dnj = (LinearLayout)view.findViewById(2131298122);
    this.dnj.setOnClickListener(new by(getActivity(), com.laiqian.meituan.TuanGouActivity.class, ""));
    this.dnh = (LinearLayout)view.findViewById(2131296930);
    this.dnh.setOnClickListener(new by(getActivity(), com.laiqian.eleme.ElemeActivity.class, ""));
    if (a.zR().zV()) {
      view.findViewById(2131298459).setVisibility(0);
      view.findViewById(2131298459).setOnClickListener(new by(getActivity(), com.laiqian.takeaway.phone.setting.PhoneOrderActivity.class, ""));
    } 
    view.findViewById(2131298309).setOnClickListener(new by(getActivity(), com.laiqian.ordertool.mealorder.MealOrderActivity.class, null));
    this.dmt = (LinearLayout)view.findViewById(2131298458);
    this.dmt.setOnClickListener(new by(getActivity(), com.laiqian.pos.features.ScanCodeOrderDishesActivity.class, null));
    this.dlq = (LinearLayout)view.findViewById(2131298430);
    this.dlq.setOnClickListener(new by(getActivity(), com.laiqian.pos.features.AliOrderActivity.class, null));
    view.findViewById(2131298451).setOnClickListener(new by(getActivity(), com.laiqian.pos.ProductPictureManagementActivity.class, null));
    this.dmu = (TextView)view.findViewById(2131298308);
    this.dmv = (TextView)view.findViewById(2131298310);
    this.dnd = (TextView)view.findViewById(2131300028);
    aoU();
    this.dnc = (TextView)view.findViewById(2131297104);
    this.dnn = (TextView)view.findViewById(2131297077);
    this.dne = (TextView)view.findViewById(2131297095);
    this.dno = (TextView)view.findViewById(2131297096);
    this.dnf = (TextView)view.findViewById(2131297089);
    this.dmp = (TextView)view.findViewById(2131297106);
    this.dmq = (TextView)view.findViewById(2131297108);
    this.dlr = (TextView)view.findViewById(2131297113);
    this.dnp = (TextView)view.findViewById(2131297111);
    return view;
  }
  
  public void onStart() {
    super.onStart();
    if (a.AZ().Bd()) {
      TextView textView = this.dmu;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getString(2131625687));
      stringBuilder.append(" (");
      stringBuilder.append(getString(2131625681));
      stringBuilder.append(bd.awo());
      stringBuilder.append(")");
      textView.setText(stringBuilder.toString());
      this.dmv.setText(getString(2131625689));
    } else {
      String str;
      this.dmu.setText(getString(2131625687));
      TextView textView = this.dmv;
      if (a.AZ().Bk()) {
        str = "";
      } else {
        str = getString(2131625682);
      } 
      textView.setText(str);
    } 
    if (bd.bH(getActivity())) {
      (new a(this, null)).execute(new Void[0]);
    } else {
      this.dnd.setVisibility(8);
    } 
    this.dnc.setVisibility(8);
    this.dnn.setVisibility(8);
    this.dne.setVisibility(8);
    this.dno.setVisibility(8);
    this.dmp.setVisibility(8);
    this.dmq.setVisibility(8);
    this.dlr.setVisibility(8);
    this.dnp.setVisibility(8);
    this.dnf.setVisibility(8);
  }
  
  private class a extends AsyncTask<Void, Void, Integer> {
    private a(SettingWechatFragment this$0) {}
    
    protected Integer e(Void... param1VarArgs) {
      av av = fp.aX(this.dnr.getActivity()).abZ();
      return (av == null) ? Integer.valueOf(2) : (av.Jm() ? Integer.valueOf(1) : Integer.valueOf(0));
    }
    
    protected void e(Integer param1Integer) { SettingWechatFragment.a(this.dnr, param1Integer.intValue()); }
    
    protected void onPreExecute() {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingWechatFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */