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

##  字符串文件报错

"XXX" is translated here but not found in default locale
原因:在默认的strings.xml里没有这个字段;
```
解决办法:将Value/string.xml中的<resources>改成

<resources xmlns:tools="http://schemas.android.com/tools" tools:ignore="ExtraTranslation">

```

"app_name" is not translated in "en" (English) less... (Ctrl+F1) 
Inspection info:If an application has more than one locale, then all the strings declared in one language should also be translated in all other languages.

```
解决办法 将这个字符串添加上以下内容:
translatable="false"
例如: <string name="app_name" translatable="false">PickerViewDemo</string>

```

## 空格
```
\u0020:代表空格
<string name="number_of_applicants">报名人数\u0020\u0020\u0020\u0020 %1$d  / %2$d</string>

String s=String.format(resources.getString(R.string.number_of_applicants), 20,200)

textView.setText(s);//显示:报名人数  20/200
```



