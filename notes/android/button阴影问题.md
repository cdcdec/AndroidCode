# button阴影问题

在[Android](http://lib.csdn.net/base/android) 5.0以后的版本中，定义一个button时，系统自动会加一个阴影的效果，去掉阴影效果 ，可以通过以下的方法:

```
//方法1：
<Button
android:id="@+id/button_send"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/button_send"
android:onClick="sendMessage"
style="?android:attr/borderlessButtonStyle" />

//方法2：

<Button
android:id="@+id/button_send"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/button_send"
android:onClick="sendMessage"
android:stateListAnimator="@null"/>

//方法3：  给button的style加一个parent
<Button  
style="@style/Button_List_Style"  
android:text="测试按钮" />

<style name="Button_List_Style" parent="@style/Widget.AppCompat.Button.Borderless">  
        <item name="android:minWidth">100dp</item>  
        <item name="android:minHeight">30dp</item>  
        <item name="android:layout_width">wrap_content</item>  
        <item name="android:layout_height">wrap_content</item>  
        <item name="android:background">@drawable/btn_black_border_list</item>  
        <item name="android:textSize">@dimen/text_size_small</item>  
        <item name="android:textColor">@color/color_black</item>  
</style>  





```



