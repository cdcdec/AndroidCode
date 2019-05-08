package com.demo.component;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.blog.www.guideview.Component;
import com.demo.guide.R;
/**
 * Created by binIoter on 16/6/17.
 */
public class SimpleComponent implements Component{
  @Override public View getView(LayoutInflater inflater) {
    //遮罩层的布局
    LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.layer_frends, null);
    ll.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(view.getContext(), "引导层被点击了", Toast.LENGTH_SHORT).show();
      }
    });
    return ll;
  }
  //相对目标View的锚点  遮罩层在目标view的左边 右边 上边 下边  上面
  @Override public int getAnchor() {
    return Component.ANCHOR_BOTTOM;
  }

  //相对目标View的对齐  FIT_START左对齐 FIT_END右对齐  FIT_CENTER居中对齐
  @Override public int getFitPosition() {
    return Component.FIT_CENTER;
  }

  //相对目标View的X轴位移，在计算锚点和对齐之后。
  @Override public int getXOffset() {
    return 0;
  }

  //相对目标View的Y轴位移，在计算锚点和对齐之后。
  @Override public int getYOffset() {
    return 10;
  }
}
