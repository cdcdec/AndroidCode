package com.cdc.androidcode.libraries.retrofit
import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.cdc.androidcode.libraries.okhttp.BottomDialogScroll
import kotlinx.android.synthetic.main.activity_retrofit_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Retrofit")
        setContentView(R.layout.activity_retrofit_main)
        initView()
    }

    private fun initView(){
        btnRetrofit1.setOnClickListener(this)
        btnRetrofit2.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when(view?.id){
            R.id.btnRetrofit1->{
                requestGet()
            }
            R.id.btnRetrofit2->{
                requestPost()
            }
        }
    }

    private fun requestGet(){
        //创建Retrofit对象
        var retrofit=Retrofit.Builder()
            .baseUrl("http://fy.iciba.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //创建 网络请求接口 的实例
        var request=retrofit.create(RetrofitApi::class.java)
        //对 发送请求 进行封装
        var call=request.call
        //发送异步请求
        call.enqueue(object:Callback<Translation>{
            //请求失败时回调
            override fun onFailure(call: Call<Translation>, t: Throwable) {

            }
            //请求成功时回调
            override fun onResponse(call: Call<Translation>, response: Response<Translation>) {
                var a= BottomDialogScroll(this@RetrofitMainActivity)
                a.title=call.request().url().toString()
                a.content=response.body().toString()
                a.show()
            }

        })
    }


    private fun requestPost(){
        //创建Retrofit对象
        var retrofit=Retrofit.Builder()
            .baseUrl("http://fanyi.youdao.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //创建 网络请求接口 的实例
        var request=retrofit.create(RetrofitApi::class.java)
        //对 发送请求 进行封装
        var call=request.getCall("hello China")
        //发送异步请求
        call.enqueue(object:Callback<YouDaoTranslation>{
            //请求失败时回调
            override fun onFailure(call: Call<YouDaoTranslation>, t: Throwable) {

            }
            //请求成功时回调
            override fun onResponse(call: Call<YouDaoTranslation>, response: Response<YouDaoTranslation>) {
                var a= BottomDialogScroll(this@RetrofitMainActivity)
                a.title=call.request().url().toString()
                a.content=response.body().toString()
                a.show()
            }

        })
    }

//Retrofit支持多种数据解析方式

}
