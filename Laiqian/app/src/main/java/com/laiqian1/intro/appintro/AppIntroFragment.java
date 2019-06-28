package com.laiqian.intro.appintro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;

public class AppIntroFragment extends Fragment {
  private int aXx;
  
  private int aXy;
  
  private int bgColor;
  
  private String description;
  
  private int drawable;
  
  private String title;
  
  public void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (getArguments() != null && getArguments().size() != 0) {
      this.drawable = getArguments().getInt("drawable");
      this.title = getArguments().getString("title");
      this.description = getArguments().getString("desc");
      this.bgColor = getArguments().getInt("bg_color");
      boolean bool = getArguments().containsKey("title_color");
      byte b = 0;
      if (bool) {
        i = getArguments().getInt("title_color");
      } else {
        i = 0;
      } 
      this.aXx = i;
      int i = b;
      if (getArguments().containsKey("desc_color"))
        i = getArguments().getInt("desc_color"); 
      this.aXy = i;
    } 
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(R.layout.fragment_intro, paramViewGroup, false);
    TextView textView1 = (TextView)view.findViewById(R.id.title);
    TextView textView2 = (TextView)view.findViewById(R.id.description);
    ImageView imageView = (ImageView)view.findViewById(R.id.image);
    LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.main);
    textView1.setText(this.title);
    if (this.aXx != 0)
      textView1.setTextColor(this.aXx); 
    textView2.setText(this.description);
    if (this.aXy != 0)
      textView2.setTextColor(this.aXy); 
    imageView.setImageDrawable(k.getDrawable(getActivity(), this.drawable));
    linearLayout.setBackgroundColor(this.bgColor);
    return view;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\appintro\AppIntroFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */