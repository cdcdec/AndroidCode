# 代码设置TextView的drawable

```

Drawable drawable= ContextCompat.getDrawable(context,R.drawable.drawable)
/// 这一步必须要做,否则不会显示.
drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
drawable.setCompoundDrawablePadding(int pad)
myTextview.setCompoundDrawables(drawable,null,null,null);

```





