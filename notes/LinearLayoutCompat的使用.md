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

