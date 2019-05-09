Android使用java8语言功能

> https://developer.android.com/studio/write/java8-support?hl=zh-CN

依赖okhttp后，项目编译报错:

```

Error: Static interface methods are only supported starting with Android N (--min-api 24): okhttp3.Request okhttp3.Authenticator.lambda$static$0(okhttp3.Route, okhttp3.Response)
```

要开始使用受支持的 Java 8 语言功能，请[更新 Android 插件](https://developer.android.com/studio/releases/gradle-plugin.html?hl=zh-CN#updating-plugin)到 `3.0.0`（或更高版本）。 然后，针对使用（包括在源代码中或通过依赖项使用）Java 8 语言功能的每个模块，在其 `build.gradle` 文件中添加以下代码：

```
android {
  ...
  // Configure only for each module that uses Java 8
  // language features (either in its source code or
  // through dependencies).
  compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
  }
}
```



