# android版微信的不死之谜

新建一个android工程，将 applicationId设置为 "com.tencent.mm"。此applicationId为微信的.

然后创建一个空的service服务，在MainActivity启动的时候将service启动。先将手机上已有的微信app卸载掉，然后再将测试的工程安装到手机，打开应用。此时正常情况下服务已经被开启。将所有的程序都清理掉，这是看正在运行的程序，发现这个测试app仍在运行。



而且在华为CHE_TL00上面安装测试工程的时候  会提示签名不一致  app可能已被修改  安装后显示的图标是微信的图标  不是这个测试app的图标.



vivoX5ProV 安装后显示的图标是微信的图标  不是这个测试app的图标.但是杀掉后，在真正运行的程序里面也不存在了。com.tencent.mm默认是允许在后台高耗电运行。



