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
java中写法  直接在某个函数内部写
```
new AsyncTask<Void, Long, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                long time = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                        time += 1000;
                        publishProgress(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            protected void onProgressUpdate(Long... values) {
                super.onProgressUpdate(values);
				 cv_countdownViewTest9.updateShow(values[0]);
            }
        }.execute();


```

kotlin中写法

```
   companion object {
        class MyAsyncTask internal constructor(context: CountDownViewMainActivity) : AsyncTask<Void, Long, Void>() {
            private val activityReference: WeakReference<CountDownViewMainActivity> = WeakReference(context)
            override fun doInBackground(vararg params: Void?): Void {
                var time:Long=0
                while(true){
                    try {
                        Thread.sleep(1000)
                        time += 1000
                        publishProgress(time)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
            override fun onProgressUpdate(vararg values: Long?) {
                super.onProgressUpdate(*values)
                val activity = activityReference.get()
                activity?.cv_countdownViewTest9?.updateShow(values[0]!!)
            }
        }
    }



```



