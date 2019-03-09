# shape

```
<?xml version="1.0" encoding="utf-8"?>
<shape
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape=["rectangle" | "oval" | "line" | "ring"] >
    <corners
        android:radius="integer"
        android:topLeftRadius="integer"
        android:topRightRadius="integer"
        android:bottomLeftRadius="integer"
        android:bottomRightRadius="integer" />
    <gradient
        android:angle="integer"
        android:centerX="integer"
        android:centerY="integer"
        android:centerColor="integer"
        android:endColor="color"
        android:gradientRadius="integer"
        android:startColor="color"
        android:type=["linear" | "radial" | "sweep"]
        android:useLevel=["true" | "false"] />
    <padding
        android:left="integer"
        android:top="integer"
        android:right="integer"
        android:bottom="integer" />
    <size
        android:width="integer"
        android:height="integer" />
    <solid
        android:color="color" />
    <stroke
        android:width="integer"
        android:color="color"
        android:dashWidth="integer"
        android:dashGap="integer" />
</shape>

```
1. 从 android:shape=["rectangle" | "oval" | "line" | "ring"]
这里可以看出，shape可以画四种图形，分别是：矩形（rectangle）、椭圆（oval）、线（line）、圆环（ring）。


2. solid：填充颜色
3. corners：圆角大小。
4. android:radius：表示4个角的圆角大小；
    还可以分别设置四个角的，使用下面四个属性：
    android:topLeftRadius、android:topRightRadius、
    android:bottomLeftRadius、android:bottomRightRadius
    分别表示：左上、右上、左下、右下。

5. padding：设置内边距。

6. stroke
   android:width：边框大小
   android:color：边框颜色
   android:dashGap：虚线间距宽度
   android:dashWidth：虚线宽度


7. gradient：
   android:startColor：渐变起始颜色
   android:endColor：渐变结束颜色
   android:angle：渐变角度：0:左到右;90:下到上;180:右到左;270:上到下

   android:centerX：表示渐变的X轴起始位置，范围0-1，0.5表示圆心。
   android:centerY：表示渐变的Y轴起始位置，范围0-1，0.5表示圆心。
   android:type：渐变类型，有三种
   分别是：
   linear 线性渐变，默认的渐变类型
   radial 放射渐变，设置该项时，android:gradientRadius也必须设置
   sweep 扫描性渐变
   

8.


