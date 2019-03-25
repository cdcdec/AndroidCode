# bitmap xml

```
<?xml version="1.0" encoding="utf-8"?>
<bitmap
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:src="@[package:]drawable/drawable_resource"
    android:antialias=["true" | "false"]
    android:dither=["true" | "false"]
    android:filter=["true" | "false"]
    android:gravity=["top" | "bottom" | "left" | "right" | "center_vertical" |
                      "fill_vertical" | "center_horizontal" | "fill_horizontal" |
                      "center" | "fill" | "clip_vertical" | "clip_horizontal"]
    android:mipMap=["true" | "false"]
    android:tileMode=["disabled" | "clamp" | "repeat" | "mirror"] />

```

1. src：图片的资源ID
2. antialias:是否开启抗锯齿效果，开启后图片将会变得更加平滑.一般设置为true
3. dither:是否开启抖动效果
4. filter：当图片被拉伸或压缩时能平滑过度，保证更好的显示效果。
5. tileMode:平铺效果，其值为disable、clamp、repeat、mirror，disable为默认值。
repeat是在垂直和水平方向上平铺，clamp是把图片四周的像素扩展到周围区域，mirror是在图片的水平和垂直方向实现镜像效果。
6. gravity:当图片的尺寸小于容器的尺寸时，可以通过该属性设置图片的显示位置。当图片<容器时，重心决定了它在容器中的位置。
当设置tileMode属性为enable状态时，gravity属性将被忽略。


XML Bitmap资源实际上就是定义在XML中指向bitmap文件的资源。
其效果就是为drawable目录中原生的bitmap资源提供了一个别名（alias）。
标签 <bitmap>通常会结合state list和layer list一起使用。
例如，可以把<bitmap>作为<item>的子元素。



