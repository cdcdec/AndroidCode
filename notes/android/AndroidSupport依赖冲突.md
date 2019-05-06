AndroidSupport依赖冲突

Android Support不同的库依赖了不同的support版本  导致的冲突

解决办法：在app的build.gradle文件的android节点中增加以下内容:

```
    configurations.all {
        resolutionStrategy.eachDependency { DependencyResolveDetails details ->
            def requested = details.requested
            if (requested.group == 'com.android.support') {
                if (!requested.name.startsWith("multidex")) {
                	//support的版本号
                    details.useVersion '28.0.0'
                }
            }
        }
    }

```
