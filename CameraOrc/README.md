# 身份证拍照

>https://github.com/fanbaoying/FBYIDCardRecognition-Android
>https://github.com/Lee465357793/CameraORC


##  MaskView  继承View

在onSizeChanged里面确定一个矩形区域的大小和位置,然后在onDraw里面绘制出一个圆角矩形，并将身份证上头像或者国徽区域的Drawable绘制上去。

### onSizeChanged(int w, int h, int oldw, int oldh)方法

```
xml布局
android:layout_width="match_parent"
android:layout_height="wrap_content"

```
此时w的值就是整个布局的宽度,h是其占据的高度，默认会充满屏幕。

```
xml布局
android:layout_width="100dp"
android:layout_height="80dp"

```
此时w的值就是100dp对应的像素值,h是80dp对应的像素值。













继承与View和继承与现有控件都是下面的顺序，但是控件的大小是生成之后就固定的，不会再次改变。

onMeasure()→onSizeChanged()→onLayout()→onMeasure()→onLayout()→onDraw()