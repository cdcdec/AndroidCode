package com.cdc.androidcode.ui.countdownview
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_dynamic_show.*
import android.view.View
import android.widget.CompoundButton






class DynamicShowActivity : BaseActivity(), CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            R.id.cb_hasBackground->{
                hasBackgroundCountdownView = isChecked
                mLlBackgroundConfigContainer?.visibility = if (isChecked) View.VISIBLE else View.GONE
                cv_countdownViewTest?.visibility = if (!isChecked) View.VISIBLE else View.GONE
                cv_countdownViewTestHasBg?.visibility = if (isChecked) View.VISIBLE else View.GONE

                if (isChecked) {
                    cv_countdownViewTest.stop()
                    cv_countdownViewTestHasBg.start(time)
                    mLlConvertDaysToHoursContainer?.visibility = View.GONE
                } else {
                    cv_countdownViewTestHasBg.stop()
                    cv_countdownViewTest.start(time)
                    mLlConvertDaysToHoursContainer?.visibility = View.VISIBLE
                }
            }
        }
    }

    private val time:Long=8*24*60*60*1000

    private var hasBackgroundCountdownView:Boolean=false

    private val mLlBackgroundConfigContainer: View? = null
    private val mLlConvertDaysToHoursContainer: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("动态显示倒计时")
        setContentView(R.layout.activity_dynamic_show)

        cv_countdownViewTest.start(time)

        initView()
    }


    private fun initView(){
        //带背景的Countdown View
        cb_hasBackground.setOnCheckedChangeListener(this)
    }


}
