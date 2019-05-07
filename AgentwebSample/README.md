#  AgentwebSample


## 原地址
https://github.com/Justson/AgentWeb  这是官方的sample

## 使用见sample中的AgentWebFragment.java文件



## Failed resolution of: Lcom/alipay/sdk/app/H5PayCallback

在debug下面会出现此提示 与没有引入支付宝的jar包有关，不影响使用

## 下拉刷新和回弹有冲突不能直接使用







## gradle.properties中的全局配置

可以在中增加以下配置:
```
COMPILE_SDK_VERSION=28
BUILD_TOOL_VERSION=28.0.3
SUPPORT_LIB_VERSION=28.0.0
TARGET_SDK_VERSION=28

```
在app的build.gradle中引用上面的配置
```
android {
    compileSdkVersion COMPILE_SDK_VERSION.toInteger()
    buildToolsVersion BUILD_TOOL_VERSION
    defaultConfig {
        applicationId "com.just.agentweb.sample"
        minSdkVersion 19
        targetSdkVersion TARGET_SDK_VERSION.toInteger()
        versionCode 4
        versionName "4.0.3-alpha"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    
    
dependencies{
implementation "com.android.support:appcompatv7:${SUPPORT_LIB_VERSION}"
implementation "com.android.support:design:${SUPPORT_LIB_VERSION}"
}

```

