#  ImageViewScaleType设置

设置的方式包括：

1. 在layout xml中定义Android:scaleType="CENTER"
2. 或在代码中调用imageView.setScaleType(ImageView.ScaleType.CENTER);
======================================================= 各个值的区别: 1).ImageView.ScaleType.CENTER:按图片的原来size居中显示，当图片长/宽超过View的长/宽，则截取图片的居中部分显示,此时图片会显示不全;

2).ImageView.ScaleType.CENTER_CROP:按比例扩大图片的size居中显示，使得图片长(宽)等于或大于View的长(宽),此时图片可能会显示不全 ;

3).ImageView.ScaleType.CENTER_INSIDE:将图片的内容完整居中显示，通过按比例缩小或原来的size使得图片长/宽等于或小于View的长/宽 ;

4).ImageView.ScaleType.FIT_CENTER:把图片按比例扩大/缩小到View的宽度，居中显示.默认的图片显示方式;

5).ImageView.ScaleType.FIT_XY:不按比例缩放图片，目标是把图片塞满整个View;

FIT_START,FIT_END并不是适应宽度也不是适应高度，而是适应长的那条边。 FIT_START:图片可能居左也可能居上; FIT_END:图片可能居右可能居下;










