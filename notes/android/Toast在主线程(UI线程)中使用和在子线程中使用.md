# Toast在主线程(UI线程)中使用和在子线程中使用

## 1. 如果直接在子线程中使用会报下面的错误：


```
Can't create handler inside thread that has not called Looper.prepare()

new Thread() {
      @Override
     public void run() {
       Toast.makeText(SampleActivity.this, "Child Thread", Toast.LENGTH_SHORT).show();
    }
}.start();
```

在子线程中使用时应通过以下的方法:

```
new Thread() {
      @Override
     public void run() {
       Looper.prepare();
       Toast.makeText(SampleActivity.this, "Child Thread", Toast.LENGTH_SHORT).show();
       Looper.loop();
    }
}.start();
```

也可以通过以下的方法使用:

```
public class ToastTool {
    static Handler mainHandler = new Handler(Looper.getMainLooper());
    static Toast toast;
    @SuppressLint("ShowToast")
    public static void init(Context context) {
        toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    public static void show (final String msg) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                toast.setText(msg);
                toast.show();
            }
        });
    }
}

//调用
ToastTool.init(this);
   new Thread() {
     @Override
     public void run() {
       ToastTool.show("子线程");
    }
  }.start();
```



## 2. 在主线程中直接使用

