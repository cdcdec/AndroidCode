package com.cdc.androidcode.libraries.okhttp
import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.cdc.okhttp3.BottomDialog
import kotlinx.android.synthetic.main.activity_okhttp_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class OkHttpMainActivity : BaseActivity() {

    private val personalInfo="https://api.github.com/users/cdcdec"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("OkHttp3")
        setContentView(R.layout.activity_okhttp_main)
        init()
    }

    private fun init(){
        btnOkHttpGet.setOnClickListener(this)
        btnOkHttpPost.setOnClickListener(this)
        btnOkHttpFile.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when(view!!.id){
            R.id.btnOkHttpGet->{
                requestGet()
            }
            R.id.btnOkHttpPost->{

            }
            R.id.btnOkHttpFile->{

            }
        }
    }

    private fun requestGet(){
        Thread(Runnable {
            try {
                val client = OkHttpClient()//创建OkHttpClient对象
                val request = Request.Builder()
                    .url(personalInfo)//请求接口。如果需要传参拼接到接口后面。
                    .build()//创建Request 对象
                var response: Response? = null
                response = client.newCall(request).execute()//得到Response 对象

                if (response!!.isSuccessful) {
                    var backStr = response!!.body()!!.string()
                    //此时的代码执行在子线程，修改UI的操作请使用handler跳转到UI线程。
                    runOnUiThread {
                        var bo= BottomDialog(this)
                        bo.setTitle(response.request().url().toString())
                        bo.setContent("$backStr===$backStr")
                        bo.show()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }).start()
    }
}
