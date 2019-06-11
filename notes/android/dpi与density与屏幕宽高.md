#  dpi与density与屏幕宽高

像素密度是屏幕上单位面积内的像素数，称为 dpi（每英寸的点数）。 它与分辨率不同，分辨率是屏幕上像素的总数。


密度无关像素:在指定尺寸时，请务必使用 dp 或 sp 单位。dp 是一种密度无关像素，对应于 160 dpi 下像素的物理尺寸。 sp 是相同的基本单位，但它会按用户首选的文本尺寸进行缩放（属于缩放无关像素）.


* xxxhdpi   4.0
* xxhdpi    3.0
* xhdpi：  2.0
* hdpi：  1.5
* mdpi： 1.0（基准）
* ldpi：   0.75

```
//Metrics 指标  度量；  Display：显示
var dm:DisplayMetrics=DisplayMetrics()
windowManager.defaultDisplay.getMetrics(dm)
Log.e("123","densit=" +dm.density)//3.0
Log.e("123","densityDpi=" +dm.densityDpi)//480
Log.e("123","widthPixels=" +dm.widthPixels)//1080
Log.e("123","heightPixels=" +dm.heightPixels)//1920

widthDp:widthPx/density+0.5
heightDp:heightPx/density+0.5

widthPx=widthDp*density+0.5
heightPx=heightDp*density+0.5
```




