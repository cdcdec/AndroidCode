#  Activity中的String.xml文件

## 规则

```
%n$ms：代表输出的是字符串，n代表是第几个参数，设置m的值可以在输出之前放置空格 
%n$md：代表输出的是整数，n代表是第几个参数，设置m的值可在输出之前放置空格,在输出之前放置m个0,也可不写m
%n$mf：代表输出的是浮点数，n代表是第几个参数，设置m的值可以控制小数位数，如m=2.2时，输出格式为00.00

```



## 例子

```
 //浮点数   1代表第一位参数，.2代表小数点后有两位小数，f:代表浮点类型
 <string name="logical_density">逻辑密度:%1$.2f</string>
 String.format(resources.getString(R.string.logical_density),getDensity())
 //整型    1代表第一位参数 宽  2：代表第一位参数 高   d:代表整类型
 <string name="width_height">宽:%1$d,高:%2$d</string>
 String.format(resources.getString(R.string.width_height), getWidth(), getHeight())
 
  
 
 
 



```








