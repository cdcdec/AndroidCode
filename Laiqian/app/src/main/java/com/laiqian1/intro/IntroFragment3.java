package com.laiqian.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.squareup.a.ab;
import com.squareup.a.x;

public class IntroFragment3 extends Fragment {
  String aXe;
  
  int aXf;
  
  String aXg;
  
  int drawable;
  
  String title;
  
  public void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (getArguments() != null && getArguments().size() != 0) {
      this.drawable = getArguments().getInt("drawable");
      this.title = getArguments().getString("title");
      this.aXe = getArguments().getString("desc");
      this.aXf = getArguments().getInt("qrcode");
      this.aXg = getArguments().getString("qrcode_label");
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(R.layout.fragment_intro3, null);
    TextView textView1 = (TextView)view.findViewById(R.id.tv_title);
    TextView textView2 = (TextView)view.findViewById(R.id.tv_desc);
    ImageView imageView1 = (ImageView)view.findViewById(R.id.iv);
    ImageView imageView2 = (ImageView)view.findViewById(R.id.iv_qrcode);
    TextView textView3 = (TextView)view.findViewById(R.id.tv_qrcode);
    textView1.setText(this.title);
    textView2.setText(this.aXe);
    ab.cx(getActivity()).mF(this.drawable).a(x.dUA, new x[] { x.dUz }).aAE().c(imageView1);
    if (this.aXf != 0)
      ab.cx(getActivity()).mF(this.aXf).a(x.dUA, new x[] { x.dUz }).aAE().c(imageView2); 
    textView3.setText(this.aXg);
    return view;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\IntroFragment3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */