# NestedScrollView  嵌套 ViewPager 不能上下滑动

## 重写ScrollView

MyNestedScrollView和CustomScrollView都可以，都是通过将左右滑动传递到子View的方法实现。
MyNestedScrollView通过重写onInterceptTouchEvent方法，在MotionEvent.ACTION_MOVE时,左右滑动时返回false;

## 重写ViewPager和MyPagerAdapter,根据Fragment的内容动态计算ViewPager的高度。



## 原生的ViewPager的高度使用wrap_content时，不可见。使用以下的自定义ViewPager可以在使用wrap_content时可见，但是其高度会和最高的那个Fragment的高度一致，不会动态变化。

```
public class EnhancedWrapContentViewPager extends ViewPager{

public EnhancedWrapContentViewPager (Context context) {
    super(context);
}

public EnhancedWrapContentViewPager (Context context, AttributeSet attrs) {
    super(context, attrs);
}

@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int mode = MeasureSpec.getMode(heightMeasureSpec);
    // Unspecified means that the ViewPager is in a ScrollView WRAP_CONTENT.
    // At Most means that the ViewPager is not in a ScrollView WRAP_CONTENT.
    if (mode == MeasureSpec.UNSPECIFIED || mode == MeasureSpec.AT_MOST) {
        // super has to be called in the beginning so the child views can be initialized.
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int childMeasuredHeight = child.getMeasuredHeight();
            if (childMeasuredHeight > height) {
                height = childMeasuredHeight;
            }
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
    }
    // super has to be called again so the new specs are treated as exact measurements
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
}
}
```