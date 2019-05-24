NestedScrollView子布局的高度与android:fillViewport属性

android:fillViewport:Defines whether the scrollview should stretch its content to fill the viewport. 定义scrollview是否应拉伸其内容以填充视口.设置为true时，允许其子布局充满屏幕，默认是false.

```
例如：android.support.v4.widget.NestedScrollView的子布局是：android.support.constraint.ConstraintLayout，默认情况下android:fillViewport=“false”,导致ConstraintLayout没有高度，那么在ConstraintLayout使用app:layout_constraintBottom_toBottomOf="parent"使ConstraintLayout的一个控件居于底部也不起作用了。


```
