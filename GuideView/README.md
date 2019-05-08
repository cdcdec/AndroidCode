# GuideView
##  Android新手引导库GuideView  Sample

最最轻量级的新手引导库，能够快速为任何一个View创建一个遮罩层，支持单个页面，多个引导提示，支持为高亮区域设置不同的图形，支持引导动画，方便扩展,良好支持fragment。https://github.com/binIoter/GuideView

## 使用

### 1. 遮罩层布局  实现Component接口

```
public class SimpleComponent implements Component{
  @Override public View getView(LayoutInflater inflater) {
 	//遮罩层的布局  引用布局文件
    LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.layer_frends, null);
    ll.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(view.getContext(), "引导层被点击了", Toast.LENGTH_SHORT).show();
      }
    });
    //也可以直接new出来一个
    ==============================直接new出来一个===============================================
    LinearLayout ll = new LinearLayout(inflater.getContext());
    LinearLayout.LayoutParams param =
        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
    ll.setOrientation(LinearLayout.VERTICAL);
    ll.setLayoutParams(param);
    TextView textView = new TextView(inflater.getContext());
    textView.setText(R.string.nearby);
    textView.setTextColor(inflater.getContext().getResources().getColor(R.color.color_white));
    textView.setTextSize(20);
    ImageView imageView = new ImageView(inflater.getContext());
    imageView.setImageResource(R.mipmap.arrow);
    ll.removeAllViews();
    ll.addView(textView);
    ll.addView(imageView);
    ll.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(view.getContext(), "引导层被点击了", Toast.LENGTH_SHORT).show();
      }
    });
    ==============================直接new出来一个===============================================
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
```

## 2. 创建遮罩层

```
public void showGuideView(){
    GuideBuilder builder = new GuideBuilder();
    //设置目标view
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
```

## 3. 调用

```
//view是目标view  在view的post方法中调用  保证了此方法会在目标view加载后调用
view.post(new Runnable() {
      @Override public void run() {
        showGuideView();
      }
    });
```

## 4.  注意

在ListView中调用时

```
//在adapter中,在第一个View之后显示此遮罩层
@Override public View getView(int i, View view, ViewGroup viewGroup) {
      ViewHolder holder;
      if (view == null) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item, viewGroup, false);
        holder = new ViewHolder();
        holder.btn = (Button) view.findViewById(R.id.btn);
        view.setTag(holder);
      } else {
        holder = (ViewHolder) view.getTag();
      }
      holder.btn.setText(arrayList.get(i));
      if (i == 0 && showTimes == 0) {
        final View finalView = view;
        view.post(new Runnable() {
          @Override public void run() {
            showGuideView(finalView);
          }
        });
      }
      return view;
    }
```











