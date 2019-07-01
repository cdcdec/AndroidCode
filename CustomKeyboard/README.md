# 自定义键盘

https://github.com/futabooo/Markey

https://github.com/AnkitDroidGit/Android-Custom-Keyboard


KeyboardView
KeyboardView 一个用于呈现虚拟键盘的 view，同时处理着每一个键盘所对应的点击、触摸等事件。

Keyboard 的样式是以 XML 文件的形式存在的，由多个 Row 和 Key 组成，我们可以直接在 XML 定义键盘的行、键、以及键大小


Keyboard 表示整个键盘， Row 表示其中一行，Key 表示某一个具体按键

android:keyWidth="10.000002%p"　键的默认宽度，以像素为单位或显示宽度的百分比。％后缀总是表示基本大小的百分比;可选的％p后缀提供相对于某个父容器的大小.

单位可以是sp,dp,px,in,mm.

android:keyHeight="50dp"　　　　　表示每一个键的高度

android:horizontalGap="1.0px"表示行间距

android:verticalGap="1.0px"表示列间距


//收银机屏幕信息

{
density:1.3312501,
densityDpi:213,
widthPixels:1280, heightPixels:736,
widthDpi:962.0023, heightDpi:553.36383,
ststusHeightPix:32, statusHeightDp:24,
orientation:"横屏", systemVersion:"6.0.1",
systemModel:"S1", deviceBrand:"Allwinner",
facturer:"Allwinner", product:"tulip_zf101s",
sdkLevel:23
}
