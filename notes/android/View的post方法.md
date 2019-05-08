# View的post方法

##  1. 获取控件的宽高

```
view.post(new Runnable() {
            @Override
            public void run() {
                 showToast("" + view.getHeight());
            }
        });

```

## 2. View.postDelayed() 方法来防止一段时间内多次点击 view 而频繁触发点击事件

```
 view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view.setEnabled(false);

                //进行其他操作

                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        view.setEnabled(true);
                    }
                }, 500);//500ms内只能点击一次
            }
        });
```



