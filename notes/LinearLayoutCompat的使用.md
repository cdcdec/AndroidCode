# LinearLayoutCompat的使用

LinearLayoutCompat除了拥有LinerLayout原本的属性之外，还可以实现间隔线效果


```
app:divider=”@drawable/line” 设置分隔线
app:dividerPadding 给分隔线设置距离左右边距的距离。
app:showDividers="beginning|middle|end"属性。
beginning，middle，end属性值分别指明将在何处添加分割线。
beginning表示从该LinearLayoutCompat布局的最顶一个子view的顶部开始。
middle表示在此LinearLayoutCompat布局内的子view之间添加。
end表示在此LinearLayoutCompat最后一个子view的底部添加分割线。

none表示不设置间隔线。

```
2. cardElevation

```
app:cardElevation=" " 
阴影大小
在5.0之前的版本中设置了 app:cardElevation=" "后 CardView 会自动留出空间供阴影显示，而5.0之后的版本中没有预留空间.

```

3. cardBackgroundColor
```
设置背景颜色
app:cardBackgroundColor=" "  
android:background=" "设置，是无效的

```
4. padding
```
设置padding
app:contentPadding=" "
app:contentPaddingTop=" "
app:contentPaddingBottom=" "
app:contentPaddingLeft=" "
app:contentPaddingRight=" "

android:padding=" "  设置，是无效的
```
5. android:foreground
```
android:clickable="true"
android:foreground="?android:attr/selectableItemBackground"

如果你给CardView设置了点击事件，就不需要设置android:clickable="true"了
可以通过foreground属性使用系统定义好的RippleDrawable: selectableItemBackground，从而达到在5.0及以上版本系统中实现点击时的涟漪效果（Ripple）.这个涟漪效果在5.0以上版本中才能展示，在低版本上是一个普通的点击变暗的效果

```
6. app:cardUseCompatPadding
```
app:cardUseCompatPadding="true"  
让CardView在不同系统中使用相同的padding值，为阴影预留空间

```

