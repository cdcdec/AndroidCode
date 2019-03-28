package com.cdc.androidcode.ui.countdownview
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_count_down_view_main.*
import java.lang.ref.WeakReference
class CountDownViewMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("倒计时")
        setContentView(R.layout.activity_count_down_view_main)
        initView()
    }

    private fun initView(){
        //倒计时1
        cv_countdownViewTest1.tag = "test1"
        var time1:Long=5*60*60*1000
        cv_countdownViewTest1.start(time1)

        //倒计时2
        cv_countdownViewTest2.tag = "test2"
        var time2:Long=30*60*1000
        cv_countdownViewTest2.start(time2)

        //倒计时3
        cv_countdownViewTest3.tag="test3"
        var time3:Long=30*60*1000
        cv_countdownViewTest3.start(time3)


        //倒计时4
        cv_countdownViewTest4.tag="test4"
        var time4:Long=24 * 60 * 60 * 1000
        cv_countdownViewTest4.start(time4)


        //倒计时5
        cv_countdownViewTest5.tag="test5"
        var time5:Long=30*60*1000
        cv_countdownViewTest5.start(time5)


        //倒计时6
        cv_countdownViewTest6.tag="test6"
        var time6:Long=9 * 60 * 60 * 1000
        cv_countdownViewTest6.start(time6)

        //倒计时7
        cv_countdownViewTest7.tag="test7"
        var time7:Long=150 * 24 * 60 * 60 * 1000
        cv_countdownViewTest7.start(time7)

        //倒计时8
        cv_countdownViewTest8.tag="test8"
        var time8:Long=150 * 24 * 60 * 60 * 1000
        cv_countdownViewTest8.start(time8)

        //倒计时9
        cv_countdownViewTest9.tag="test9"
        val task = MyAsyncTask(this)
        task.execute()


        //倒计时10
        cv_countdownViewTest10.tag="test10"
        var time10:Long=2 * 60 * 60 * 1000
        cv_countdownViewTest10.start(time10)


        btn_toDynamicShowActivity.setOnClickListener(this)
        btn_toListViewActivity.setOnClickListener(this)
        btn_toRecyclerViewActivity.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        var intent= Intent()
        when(view?.id){
            R.id.btn_toDynamicShowActivity->{
                intent.setClass(this@CountDownViewMainActivity,DynamicShowActivity::class.java)
                startActivity(intent)
            }
        }
    }


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


}
