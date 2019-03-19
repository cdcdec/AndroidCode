# kotlin内部类

```
  //源方法
  adapter.setOnLoadMoreListener(RequestLoadMoreListener,RecyclerView)
  //调用方法1
  adapter.setOnLoadMoreListener(object: BaseQuickAdapter.RequestLoadMoreListener{
            override fun onLoadMoreRequested() {

            }
        },recyclerViewLoveValueRecord)
  //调用方法2 lambda
  adapter.setOnLoadMoreListener({ },recyclerViewLoveValueRecord)
```





