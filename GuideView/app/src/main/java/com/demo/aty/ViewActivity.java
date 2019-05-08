package com.demo.aty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.blog.www.guideview.Guide;
import com.blog.www.guideview.GuideBuilder;
import com.demo.component.MutiComponent;
import com.demo.guide.R;

/**
 * 创建时间: 2016/08/24 16:58 <br>
 * 作者: zhangbin <br>
 * 描述:
 */
public class ViewActivity extends Activity {
  private LinearLayout ll_nearby, ll_view_group,ll_line;
  private ImageView ivFriend;
  Guide guide;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_guide_view);
    ll_nearby = (LinearLayout) findViewById(R.id.ll_nearby);
    ll_line = (LinearLayout) findViewById(R.id.ll_line);
    ivFriend=findViewById(R.id.ivFriend);
    ll_view_group = (LinearLayout) findViewById(R.id.ll_view_group);
    ll_view_group.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(ViewActivity.this, "show", Toast.LENGTH_SHORT).show();
      }
    });
    ll_nearby.post(new Runnable() {
      @Override public void run() {
        showGuideView();
      }
    });
  }

  public void showGuideView() {
    GuideBuilder builder = new GuideBuilder();
    builder.setTargetView(ivFriend)
        .setFullingViewId(R.id.ll_line)
            //设置蒙板透明度  [0-255] 0 表示完全透明，255表示不透明
        .setAlpha(200)
            //置高亮区域的圆角大小
        .setHighTargetCorner(30)
            //设置高亮区域的padding
        .setHighTargetPadding(10)
            //是否覆盖目标  true 遮罩将会覆盖整个屏幕
        .setOverlayTarget(false)
            //设置遮罩系统是否可点击并处理点击事件 true 遮罩不可点击，处于不可点击状
        .setOutsideTouchable(false);
    builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
      @Override public void onShown() {
        Toast.makeText(ll_nearby.getContext(),"遮罩层显示了",Toast.LENGTH_SHORT).show();
      }

      @Override public void onDismiss() {
        Toast.makeText(ll_nearby.getContext(),"遮罩层消失了",Toast.LENGTH_SHORT).show();
      }
    });
    builder.addComponent(new MutiComponent());
    guide = builder.createGuide();
    guide.setShouldCheckLocInWindow(true);
    guide.show(this);
  }
}
