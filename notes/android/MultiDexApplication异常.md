AndroidX依赖异常

Didn't find class “androidx.core.content.FileProvider”:

```

Your Application class (App.class, for instance, if you use it) should extend from MultiDexApplication class:

public class BaseApplication extends MultiDexApplication {}

or if you don't use Application class check your manifest:

<?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.example.android.multidex.myapplication">
        <application
            ...
            android:name="android.support.multidex.MultiDexApplication">
            ...
        </application>
    </manifest>

```