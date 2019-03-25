# android反射

通过反射的方法获取某些api，存在兼容性和不安全性的问题：
Accessing internal APIs via reflection is not supported and may not work on all devices or in the future less... (Ctrl+F1)。
> 不支持通过反射访问内部API，并且可能无法在所有设备上或将来使用更少...

Inspection info:Using reflection to access hidden/private Android APIs is not safe;
it will often not work on devices from other vendors,and it may suddenly stop working (if the API is removed) or crash spectacularly (if the API behavior changes,since there are no guarantees for compatibility).
>检查信息：使用反射访问隐藏/私有Android API并不安全;它通常不会在其他供应商的设备上运行，它可能突然停止工作（如果API被移除）或崩溃（如果API行为发生变化，因为无法保证兼容性）。



1.	通过反射的方法获取Application
```
private static Application getApplicationByReflect() {
        try {
            @SuppressLint("PrivateApi")
            Class<?> activityThread = Class.forName("android.app.ActivityThread");
            Object thread activityThread.getMethod("currentActivityThread").invoke(null);
            Object app = activityThread.getMethod("getApplication").invoke(thread);
            if (app == null) {
                throw new NullPointerException("u should init first");
            }
            return (Application) app;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("====出错了====");
    }


```

