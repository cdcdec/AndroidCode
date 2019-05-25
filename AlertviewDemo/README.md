# Android-AlertView  弹窗  可以显示在屏幕中间  也可以显示在屏幕的底部，即同时支持AlertView.Style.Alert和AlertView.Style.ActionSheet模式
> https://github.com/saiwu-bigkoo/Android-AlertView


## 用法

```
//AlertView(String title, String msg, String cancel, String[] destructive, String[] others, Context context, Style style,OnItemClickListener onItemClickListener)
new AlertView("标题", "内容", null, new String[]{"确定"}, null, this, AlertView.Style.Alert, this).show();



new AlertView("标题", "内容", "取消", null, null, this, AlertView.Style.ActionSheet, this).setCancelable(true).show();





```

## 自定义布局

```
//拓展窗口
mAlertViewExt = new AlertView("提示", "请完善你的个人资料！", "取消", null, new String[]{"完成"}, this, AlertView.Style.Alert, this);
ViewGroup extView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.alertext_form,null);
etName = (EditText) extView.findViewById(R.id.etName);
etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View view, boolean focus) {
        //输入框出来则往上移动
        boolean isOpen=imm.isActive();
        mAlertViewExt.setMarginBottom(isOpen&&focus ? 120 :0);
        System.out.println(isOpen);
    }
});
mAlertViewExt.addExtView(extView);

mAlertViewExt.show()


```

自定义View只能将标题和下面的按钮之间的布局替换掉，如果想替换整个布局，就不行了。即使把相应的参数设置为null,标题和确定按钮仍然占据相应位置。


## MyAlertView
在AlertView的基础上进行了修改,只用于弹出自定义对话框，可以不受标题和按钮的限制，且点击对话框区域之外的地方，都会关闭这个对话框。

