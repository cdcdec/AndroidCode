# shape_line

```
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="line">

    <stroke
        android:width="1dp"
         android:color="@color/colorAccent"
         android:dashGap="3dp"
         android:dashWidth="4dp"></stroke>

    <size android:height="3dp"></size>
</shape>

```

线是居中显示的。
android:width：填充颜色的高度
android:dashGap：虚线间距宽度
android:dashWidth：虚线宽度
<size android:height="3dp"></size>：line的高度，size大小必须大于android:width
