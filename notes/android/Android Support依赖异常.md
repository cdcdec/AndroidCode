Android Support依赖异常

在app的build.gradle中增加以下代码:
```
  configurations.all {
        resolutionStrategy.eachDependency { DependencyResolveDetails details ->
            def requested = details.requested
            if (requested.group == 'com.android.support') {
                if (!requested.name.startsWith("multidex")) {
                    details.useVersion '28.0.0'
                }
            }
        }
    }

```
然后rebuild一下。原理就是通过遍历所有依赖，并修改指定库的版本号。
