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

public class IntroFragment2 extends Fragment {
  String aXe;
  
  int drawable;
  
  String title;
  
  public static IntroFragment2 b(String paramString1, String paramString2, int paramInt) {
    IntroFragment2 introFragment2 = new IntroFragment2();
    Bundle bundle = new Bundle();
    bundle.putString("title", paramString1);
    bundle.putString("desc", paramString2);
    bundle.putInt("drawable", paramInt);
    introFragment2.setArguments(bundle);
    return introFragment2;
  }
  
  public void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (getArguments() != null && getArguments().size() != 0) {
      this.drawable = getArguments().getInt("drawable");
      this.title = getArguments().getString("title");
      this.aXe = getArguments().getString("desc");
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(R.layout.fragment_intro2, null);
    TextView textView1 = (TextView)view.findViewById(R.id.tv_title);
    TextView textView2 = (TextView)view.findViewById(R.id.tv_desc);
    ImageView imageView = (ImageView)view.findViewById(R.id.iv);
    textView1.setText(this.title);
    textView2.setText(this.aXe);
    ab.cx(getActivity()).mF(this.drawable).a(x.dUA, new x[] { x.dUz }).aAE().c(imageView);
    return view;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\IntroFragment2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */