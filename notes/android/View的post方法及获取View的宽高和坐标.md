# View的post方法及获取View的宽高和坐标

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

## 3. 获取View的坐标

```
//int[] position1 = new int[2]; 
val position1 = IntArray(2)
view1.post{
		//此坐标是相对当前activity而言.若是普通activity,
		//则y坐标为可见的状态栏高度+可见的标题栏高度+ 
		//view左上角到标题栏底部的距离.
        view1.getLocationInWindow(position1)
        //getLocationOnScreen相对于整个屏幕而言的
        //view1.getLocationOnScreen(position1)
        Log.e("123","getLocationInWindow1:" + position1[0] + "," + position1[1])//0,72
        Log.e("123","view1.height=:" + view1.height+",view1.width="+view1.width)//180,1080
}

//构建一个Rect用来"套"这个view.此Rect的坐标是相对当前activity而言
//若是普通activity,则Rect的top为可见的状态栏高度+可见的标题栏高度+Rect左上角到标题栏底部的距离
val viewRect = Rect()
view1.post{
     view1.getGlobalVisibleRect(viewRect)
     Log.e("123","getLocationInWindow1:"+"top="+viewRect.top) 
}

//此种方法不能获取坐标值  仅能通过这个Rect得到View的宽度和高度
val viewRect = Rect()
view1.post{
     view1.getLocalVisibleRect(viewRect)
     Log.e("123",viewRect.height() + "," + viewRect.width()+",top="+viewRect.top)//top=0
}
```



