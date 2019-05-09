AndroidX依赖异常

如果项目中有的库依赖了AndroidX，而有的库没有依赖AndroidX,则会报下面的错误:

```

Manifest merger failed : Attribute application@appComponentFactory value=(android.support.v4.app.CoreComponentFactory) from [com.android.support:support-compat:28.0.0] AndroidManifest.xml:22:18-91
	is also present at [androidx.core:core:1.1.0-alpha01] AndroidManifest.xml:22:18-86 value=(androidx.core.app.CoreComponentFactory).
	Suggestion: add 'tools:replace="android:appComponentFactory"' to <application> element at AndroidManifest.xml:35:5-251:19 to override.

```

One app should use either AndroidX or old Android Support libraries. That's why you faced this issue.

> 一个应用程序应该使用AndroidX或旧的Android支持库。这就是你遇到这个问题的原因。

