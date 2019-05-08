package com.demo.aty;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.blog.www.guideview.Guide;
import com.blog.www.guideview.GuideBuilder;
import com.demo.component.SimpleComponent;
import com.demo.guide.R;
//遮罩整个activity
public class FullActivity extends Activity {

  private Button header_imgbtn;

  private LinearLayout ll_line;
  Guide guide;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_guide_view);
    header_imgbtn = (Button) findViewById(R.id.header_imgbtn);
    ll_line = (LinearLayout) findViewById(R.id.ll_line);

    header_imgbtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(FullActivity.this, "show", Toast.LENGTH_SHORT).show();
      }
    });
   /* header_imgbtn.post(new Runnable() {
      @Override public void run() {
        Log.e("123",header_imgbtn.getHeight()+"");
        showGuideView();
      }
    });*/

  ll_line.post(new Runnable() {
      @Override
      public void run() {
        showGuideView();
      }
    });
  }

  public void showGuideView() {
    GuideBuilder builder = new GuideBuilder();
    builder.setTargetView(ll_line)
        .setAlpha(150)
        .setHighTargetCorner(20)
        .setHighTargetPadding(10)
        .setOverlayTarget(false)
        .setOutsideTouchable(false);
    builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
      @Override public void onShown() {
        Toast.makeText(header_imgbtn.getContext(), "引导层被点击了1", Toast.LENGTH_SHORT).show();
      }

      @Override public void onDismiss() {
        Toast.makeText(header_imgbtn.getContext(), "引导层被点击了2", Toast.LENGTH_SHORT).show();
      }
    });

    builder.addComponent(new SimpleComponent());
    guide = builder.createGuide();
    guide.setShouldCheckLocInWindow(true);
    guide.show(this);
  }
}