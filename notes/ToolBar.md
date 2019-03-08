# ToolBar

继承自ViewGroup

```
//位置 按下面的顺序  从左到右
app:navigationIcon="@mipmap/logo"
app:logo="@mipmap/ic_update_password"
app:title="主标题"
app:subtitle="副标题"

 <androidx.appcompat.widget.Toolbar
            android:id="@+id/tb_toolbar1"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            app:navigationIcon="@mipmap/logo"
            app:logo="@mipmap/ic_update_password"
            app:title="主标题"
            app:subtitle="副标题"
            android:background="?attr/colorPrimary"
            android:elevation="4dp"
            android:theme="@style/ThemeOverlay.AppCompat.ActionBar"
            app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
    >
        <!--自定义控件-->
        <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="自定义控件"/>
    </androidx.appcompat.widget.Toolbar>
    
    //toolbar_menu1.xml
    
    <?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
            android:id="@+id/action_music"
            android:icon="@mipmap/ic_hint_music"
            android:title="menu_search"
            app:showAsAction="ifRoom"/>
    <item
            android:id="@+id/action_password"
            android:icon="@mipmap/ic_update_password"
            android:title="menu_notifications"
            app:showAsAction="ifRoom"/>
    <item
            android:id="@+id/action_item1"
            android:title="item_01"
            app:showAsAction="never"/>
    <item
            android:id="@+id/action_item2"
            android:title="item_02"
            app:showAsAction="never"/>
</menu>
    
```

1. Activitry的theme使用NoActionBar的,不需要在Activity中使用:setSupportActionBar(toolbar1);

```
		//设置右上角的填充菜单
        toolbar1.inflateMenu(R.menu.toolbar_menu1);
        //右上角的填充菜单的响应事件
        toolbar1.setOnMenuItemClickListener(item -> {
            int menuItemId = item.getItemId();
            if (menuItemId == R.id.action_music) {
					

            } else if (menuItemId == R.id.action_password) {
				

            } else if (menuItemId == R.id.action_item1) {


            } else if (menuItemId == R.id.action_item2) {


            }
            return true;
        });
```

2. Activitry的theme使用NoActionBar的,在Activity中使用:setSupportActionBar(toolbar1);此时右上角的菜单不会出现了.

```
   	重写Activity的方法:右上角的菜单就出现了，但是没有响应事件
   	
    	@Override
       public boolean onCreateOptionsMenu(Menu menu) {
           getMenuInflater().inflate(R.menu.toolbar_menu1, menu);
           return true;
       }
      
      重写Activity的以下方法，可以响应菜单事件以及ToolBar中navigationIcon的事件
      
    	@Override
       public boolean onOptionsItemSelected(MenuItem item) {
           switch (item.getItemId()) {
           //navigationIcon的事件  调用toolbar1.setNavigationOnClickListener()时此方法不调用
               case android.R.id.home:
                   finish();
                   break;
               case R.id.action_music:
                   Toast.makeText(this,"action_music",Toast.LENGTH_SHORT).show();
                   break;
               case R.id.action_password:
                   Toast.makeText(this,"action_password",Toast.LENGTH_SHORT).show();
                   break;
               case R.id.action_item1:
                   Toast.makeText(this,"action_item1",Toast.LENGTH_SHORT).show();
                   break;
               case R.id.action_item2:
                   Toast.makeText(this,"action_item2",Toast.LENGTH_SHORT).show();
                   break;
           }
           return super.onOptionsItemSelected(item);
       }
       
```

3. TooLBar中除了菜单外的响应事件

```
      toolbar1.setNavigationOnClickListener((view)->{
               //navigationIcon的事件
              });
      
              View logoView = getToolbarLogoIcon(toolbar1);
      
              logoView.setOnClickListener((view)->{
             	//logo的事件
              });
      
              TextView tvCustomTitle=toolbar1.findViewById(R.id.customTitle);
      
              tvCustomTitle.setOnClickListener((view)->{
                //自定义View的事件
              });
              
            //获取ToolBar中的logo View
              public  View getToolbarLogoIcon(Toolbar toolbar){
              //check if contentDescription previously was set
              boolean hadContentDescription = android.text.TextUtils.isEmpty(toolbar.getLogoDescription());
              String contentDescription = String.valueOf(!hadContentDescription ? toolbar.getLogoDescription() : "logoContentDescription");
              toolbar.setLogoDescription(contentDescription);
              ArrayList<View> potentialViews = new ArrayList<View>();
              //find the view based on it's content description, set programatically or with android:contentDescription
              toolbar.findViewsWithText(potentialViews,contentDescription, View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
              //Nav icon is always instantiated at this point because calling setLogoDescription ensures its existence
              View logoIcon = null;
              if(potentialViews.size() > 0){
                  logoIcon = potentialViews.get(0);
              }
              //Clear content description if not previously present
              if(hadContentDescription)
                  toolbar.setLogoDescription(null);
              return logoIcon;
          }
```
4. 注意：以下方法不会报错,但是也获取不到相应的响应事件
```
 View view=toolbar1.getChildAt(1);
        view.setClickable(true);
        view.setOnClickListener((v)->{
            Toast.makeText(Toolbar2Activity.this, "view==1====", Toast.LENGTH_SHORT).show();
        });

```
