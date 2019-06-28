package com.laiqian.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.ui.FragmentRoot;

public class SettingPrinterFragment extends FragmentRoot {
  private TextView dmG;
  
  private TextView dmH;
  
  private TextView dmI;
  
  private TextView dmJ;
  
  private TextView dmK;
  
  private TextView dmL;
  
  private TextView dmM;
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view1 = paramLayoutInflater.inflate(2131428034, null);
    View view2 = view1.findViewById(2131298497);
    view2.findViewById(2131298496).setOnClickListener(new by(getActivity(), com.laiqian.print.PrinterSettingsActivity.class, null));
    view2.findViewById(2131299927).setOnClickListener(new by(getActivity(), com.laiqian.print.usage.receipt.ReceiptPreviewActivity.class, null));
    view2.findViewById(2131299928).setOnClickListener(new by(getActivity(), com.laiqian.print.usage.tag.TagPreviewActivity.class, null));
    view2.findViewById(2131299926).setOnClickListener(new by(getActivity(), com.laiqian.print.usage.kitchen.KitchenPreviewActivity.class, null));
    view2.findViewById(2131299925).setOnClickListener(new by(getActivity(), com.laiqian.print.usage.delivery.DeliveryPreviewActivity.class, null));
    view2.findViewById(2131296676).setOnClickListener(new by(getActivity(), com.laiqian.print.cardreader.CardReaderSearchActivity.class, null));
    view2.findViewById(2131296886).setOnClickListener(new by(getActivity(), com.laiqian.pos.hardware.CustomerDisplaySettingActivity.class, null));
    view2.findViewById(2131298895).setOnClickListener(new by(getActivity(), com.laiqian.print.dualscreen.DualScreenSettingsActivity.class, null));
    view2.findViewById(2131300031).setOnClickListener(new by(getActivity(), WeighSettingActivity.class));
    view2.findViewById(2131298654).setOnClickListener(new by(getActivity(), QueuingMachineSettingActivity.class));
    if (!a.zR().Ab())
      view2.findViewById(2131299925).setVisibility(8); 
    this.dmG = (TextView)view1.findViewById(2131297115);
    this.dmH = (TextView)view1.findViewById(2131297133);
    this.dmI = (TextView)view1.findViewById(2131297134);
    this.dmJ = (TextView)view1.findViewById(2131297132);
    this.dmK = (TextView)view1.findViewById(2131297080);
    this.dmL = (TextView)view1.findViewById(2131297088);
    this.dmM = (TextView)view1.findViewById(2131297121);
    return view1;
  }
  
  public void onStart() {
    super.onStart();
    this.dmG.setVisibility(8);
    this.dmH.setVisibility(8);
    this.dmI.setVisibility(8);
    this.dmJ.setVisibility(8);
    this.dmK.setVisibility(8);
    this.dmL.setVisibility(8);
    this.dmM.setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingPrinterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */