package com.cdc.androidcode.component.foregroundService
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_foreground_service_main.*

class ForegroundServiceMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("前台服务")
        setContentView(R.layout.activity_foreground_service_main)

        init()
    }

    private fun init(){
        fService1Start.setOnClickListener(this)
        fService1Stop.setOnClickListener(this)

        fService2Start.setOnClickListener(this)
        fService2Stop.setOnClickListener(this)

        fService3Start.setOnClickListener(this)
        fService3Stop.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        var intent1= Intent(this@ForegroundServiceMainActivity,
            ForService1::class.java)
        var intent2= Intent(this@ForegroundServiceMainActivity,ForService2::class.java)
        when(view!!.id){
            R.id.fService1Start->{
                intent1.action = ForServivce1Constants.ACTION.START_ACTION
                startService(intent1)
            }
            R.id.fService1Stop->{
                intent1.action = ForServivce1Constants.ACTION.STOP_ACTION
                startService(intent1)
            }
            R.id.fService2Start->{
                PollingTool.newInstance().startPollingService(this,ForService2::class.java,ForService2.ACTION)

            }
            R.id.fService2Stop->{
                PollingTool.newInstance().stopPollingService(this,ForService2::class.java,ForService2.ACTION)
            }

            R.id.fService3Start->{
                ForService3.trigger(this)

            }
            R.id.fService3Stop->{
               var boolean= ForService3.trigger(this)
                Toast.makeText(this, "开启了吗?$boolean",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
