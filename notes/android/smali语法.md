# smali语法

```
.method public closeActivity(Landroid/view/View;)V
    .locals 0

    .line 423
    invoke-virtual {p0}, Lcom/laiqian/ui/ActivityRoot;->onBackPressed()V

    return-void
.end method
```

###  内部类

MemberClasses表明这是个内部类


```
# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/laiqian/ui/a/d$a;
    }
.end annotation


# instance fields
.field private afterShowDialog:Lcom/laiqian/ui/a/d$a;


上面这个annotations和instance fields表明这个smali文件(d)中有一个变量：
private a afterShowDialog;
这个a是个内部类。



```


