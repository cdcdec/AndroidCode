# 数据类构造函数和val

If we want to make the class read-only (no setters), we need to use `val`

如果data class中使用val,则没有setter方法，只有get方法。其它都和使用var的行为一致

## 只有一个构造函数

```
data class User(
    var name:String,
    var age:Int,
    var area:String
)
//User的构造函数只有一个，即带有三个参数的   在java中调用也是一样的
var u1=User("cdc",20,"漯河")
println(u1.age)//get方法  20
u1.age=30//set方法
println(u1.age)//get方法  30
```

## 有多个构造函数 :(有默认值的属性个数+1)个构造函数         各个属性都有默认值

```
data class User2(
    var name:String="c",
    var age:Int=10,
    var area:String="lh"
)

var u2=User2()
var u3=User2("c")
var u4=User2("d",87,"zk")
var u5=User2("c",90)


此时在kotlin中调用是User2有4个构造函数，但是在java中调用时只有两个构造函数：一个没有参数，一个包含全部参数
User2 user22=new User2("cdc",20,"ly");
User2 user23=new User2();

如果将User2改成如下的形式，则在java中也可以调用4个构造函数  和在kotlin中的行为一致
data class User2 @JvmOverloads constructor(
    var name:String="c",
    var age:Int=10,
    var area:String="lh"
)
```

## 有多个构造函数 :(有默认值的属性个数+1)个构造函数        部分属性有默认值

```
data class User3(
    var name:String,
    var age:Int=10,
    var area:String="lh"
)

var u2=User3() //没有这个构造函数
var u3=User3("c")
var u4=User3("d",87,"zk")
var u5=User3("c",90)


此时在kotlin中调用是User2有4个构造函数，但是在java中调用时只有1个构造函数：包含全部参数
User3 user3=new User3("cdc",20,"ly");

如果将User3改成如下的形式，则在java中也可以调用3个构造函数  和在kotlin中的行为一致
data class User3 @JvmOverloads constructor(
    var name:String,
    var age:Int=10,
    var area:String="lh"
)
```
