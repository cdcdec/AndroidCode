# kotlin 集合

## map集合

```
//正确
var clsMap=mutableMapOf<Int,Class<*>>()

//错误
var clsMap2:MutableMap<Int,Class<*>>=mutableMapOf<Int,Class<*>>()



```

## list集合

```
//创建一个空的集合
val mutableList = mutableListOf<Kolory>()
val mutableList : MutableList<Kolory> = arrayListOf()
val mutableList : MutableList<Kolory> = ArrayList()
```

