# kotlin可变参数规则


*  可变参数不必是函数的参数列表中的最后一个
*  用vararg paramName: paramType格式申明一个可变参数
*  和Java一样，在函数体内部，可以以数组的形式使用这个可变参数的形参变量

```
 fun onProgressUpdate(vararg values: Long) {
                cv_countdownViewTest9.updateShow(values[0])
            }
```


## JAVA中可变参数规则
* 可变参数前面可以有其他参数，但是可变参数只能出现在参数列表的最后
* 用...代表可变参数，...位于变量类型和变量名之间
* 调用含有可变参数的方法时，编译器为该可变参数隐式创建一个数组，在方法体中以数组的形式访问可变参数

```
protected void onProgressUpdate(Long... values) {
                super.onProgressUpdate(values);
                cv_countdownViewTest9.updateShow(values[0]);
            }
```









