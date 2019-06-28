package com.laiqian.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.container.l;
import com.laiqian.util.an;
import com.laiqian.util.av;

public class SettingAboutFragment extends FragmentRoot {
  private av cFo;
  
  private TextView dlg;
  
  private TextView dlh;
  
  private TextView dli;
  
  private TextView dlj;
  
  private TextView dlk;
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view1 = paramLayoutInflater.inflate(2131428020, null);
    View view2 = view1.findViewById(2131296299);
    view2.findViewById(2131296701).setOnClickListener(new by(getActivity(), com.laiqian.milestone.about_laiqian.class, null));
    view2.findViewById(2131299907).setOnClickListener(new by(getActivity(), com.laiqian.version.UpgradeActivity.class, "100016"));
    view2.findViewById(2131297037).setOnClickListener(new by(getActivity(), com.laiqian.milestone.inputFeedback.class, null));
    view2.findViewById(2131298718).setOnClickListener(new by(getActivity(), com.laiqian.repair.SelfRepairMain.class, null));
    view2.findViewById(2131297287).setOnClickListener(new by(getActivity(), com.laiqian.print.type.net.ChangeNetPrinterIpActivity.class, null));
    view2.findViewById(2131299139).setOnClickListener(new by(getActivity(), com.laiqian.backup.BackUpSystemHaltedActivity.class, ""));
    l l = new l(2131297520);
    l.S(view2.findViewById(l.getId()));
    this.dlg = (TextView)view1.findViewById(2131297082);
    this.dlh = (TextView)view1.findViewById(2131297131);
    this.dli = (TextView)view1.findViewById(2131297090);
    this.dlj = (TextView)view1.findViewById(2131297119);
    this.dlk = (TextView)view1.findViewById(2131297091);
    ((TextView)l.cAO.getView()).setText(2131629613);
    ((CheckBox)l.dwV.getView()).setChecked(CrashApplication.getLaiqianPreferenceManager().avJ());
    ((CheckBox)l.dwV.getView()).setOnCheckedChangeListener(new as(this));
    return view1;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.cFo.close();
  }
  
  public void onStart() {
    super.onStart();
    if (this.cFo == null)
      this.cFo = new av(getActivity()); 
    if (this.cFo.auA()) {
      an.a("100016", ao.dll);
    } else {
      an.a("100016", ap.dll);
    } 
    an.a("100014", new aq(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingAboutFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */