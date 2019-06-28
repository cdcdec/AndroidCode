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
import com.laiqian.entity.av;
import com.laiqian.pos.industry.weiorder.fp;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.util.bd;

public class SettingTakeOutFoodFragment extends FragmentRoot {
  private TextView dnc;
  
  private TextView dnd;
  
  private TextView dne;
  
  private TextView dnf;
  
  private LinearLayout dng;
  
  private LinearLayout dnh;
  
  private boolean dni;
  
  private LinearLayout dnj;
  
  private TextView dnk;
  
  private TextView dnl;
  
  private void aoU() {
    if (!a.zR().Ab() && !a.zR().Ad()) {
      this.dng.setVisibility(0);
      this.dnh.setVisibility(0);
      this.dnj.setVisibility(0);
    } 
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
    View view = paramLayoutInflater.inflate(2131428038, null);
    this.dng = (LinearLayout)view.findViewById(2131298121);
    this.dng.setOnClickListener(new by(getActivity(), com.laiqian.meituan.MeituanActivity.class, null));
    this.dnh = (LinearLayout)view.findViewById(2131296930);
    this.dnh.setOnClickListener(new by(getActivity(), com.laiqian.eleme.ElemeActivity.class, null));
    this.dnj = (LinearLayout)view.findViewById(2131298122);
    this.dnj.setOnClickListener(new by(getActivity(), com.laiqian.meituan.TuanGouActivity.class, null));
    if (a.zR().zV()) {
      view.findViewById(2131298459).setVisibility(0);
      this.dni = true;
      view.findViewById(2131298459).setOnClickListener(new by(getActivity(), com.laiqian.takeaway.phone.setting.PhoneOrderActivity.class, ""));
    } 
    if (a.zR().Af())
      view.findViewById(2131300027).setVisibility(0); 
    view.findViewById(2131300027).setOnClickListener(new by(getActivity(), com.laiqian.pos.industry.weiorder.WeshopSettingsActivity.class, null));
    this.dnd = (TextView)view.findViewById(2131300028);
    this.dnc = (TextView)view.findViewById(2131297104);
    this.dne = (TextView)view.findViewById(2131297095);
    this.dnf = (TextView)view.findViewById(2131297089);
    this.dnk = (TextView)view.findViewById(2131297096);
    this.dnl = (TextView)view.findViewById(2131297076);
    aoU();
    return view;
  }
  
  public void onResume() {
    byte b;
    super.onResume();
    TextView textView = this.dnl;
    if (getLaiqianPreferenceManager().awf()) {
      b = 0;
    } else {
      b = 8;
    } 
    textView.setVisibility(b);
  }
  
  public void onStart() {
    super.onStart();
    if (this.dni)
      if (bd.bH(getActivity())) {
        (new a(this, null)).execute(new Void[0]);
      } else {
        this.dnd.setVisibility(8);
      }  
    this.dne.setVisibility(8);
    this.dnf.setVisibility(8);
    this.dnc.setVisibility(8);
    this.dnk.setVisibility(8);
  }
  
  private class a extends AsyncTask<Void, Void, Integer> {
    private a(SettingTakeOutFoodFragment this$0) {}
    
    protected Integer e(Void... param1VarArgs) {
      av av = fp.aX(this.dnm.getActivity()).abZ();
      return (av == null) ? Integer.valueOf(2) : (av.Jm() ? Integer.valueOf(1) : Integer.valueOf(0));
    }
    
    protected void e(Integer param1Integer) { SettingTakeOutFoodFragment.a(this.dnm, param1Integer.intValue()); }
    
    protected void onPreExecute() {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingTakeOutFoodFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */