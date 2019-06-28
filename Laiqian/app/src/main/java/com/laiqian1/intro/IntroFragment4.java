package com.laiqian.intro;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.infrastructure.R;

public class IntroFragment4 extends Fragment {
  String aXe;
  
  int aXf;
  
  int drawable;
  
  String title;
  
  public void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (getArguments() != null && getArguments().size() != 0) {
      this.drawable = getArguments().getInt("drawable");
      this.title = getArguments().getString("title");
      this.aXe = getArguments().getString("desc");
      this.aXf = getArguments().getInt("qrcode");
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(R.layout.fragment_intro4, null);
    TextView textView1 = (TextView)view.findViewById(R.id.tv_title);
    TextView textView2 = (TextView)view.findViewById(R.id.tv_desc);
    ImageView imageView1 = (ImageView)view.findViewById(R.id.iv);
    ImageView imageView2 = (ImageView)view.findViewById(R.id.iv_qrcode);
    textView1.setText(this.title);
    textView2.setText(this.aXe);
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inPreferredConfig = Bitmap.Config.RGB_565;
    imageView1.setImageBitmap(BitmapFactory.decodeResource(getResources(), this.drawable, options));
    imageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);
    if (this.aXf != 0)
      imageView2.setImageResource(this.aXf); 
    return view;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\IntroFragment4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */