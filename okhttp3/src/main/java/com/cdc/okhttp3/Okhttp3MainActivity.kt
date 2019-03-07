package com.cdc.okhttp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_okhttp3_main.*
import android.util.Log
import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


class Okhttp3MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.bt1 -> {
                    getDatasync()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp3_main)

        init()
    }

    fun init() {
        bt1.setOnClickListener(this)
    }


    private fun getDatasync() {

        BottomDialog(this).show()
       Thread(Runnable {
            try {
                val client = OkHttpClient()//创建OkHttpClient对象
                val request = Request.Builder()
                    .url(Api.personalInfo)//请求接口。如果需要传参拼接到接口后面。
                    .build()//创建Request 对象
                var response: Response? = null
                response = client.newCall(request).execute()//得到Response 对象
                Log.e("123", response.code().toString())
                if (response!!.isSuccessful) {
                    Log.e("123", "response.code()==" + response!!.code())
                    Log.e("123", "response.message()==" + response!!.message())
                    var backStr = response!!.body()!!.string()
                    Log.e("123", "res==$backStr")
                    //此时的代码执行在子线程，修改UI的操作请使用handler跳转到UI线程。
                    runOnUiThread {
                        var bo=BottomDialog(this)
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
