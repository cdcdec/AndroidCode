package com.cdc.agentweb

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.WebView
import android.widget.LinearLayout
import com.just.agentweb.*
import com.just.agentweb.download.DefaultDownloadImpl
import com.just.agentweb.download.DownloadListener
import com.just.agentweb.download.Extra
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mAgentWeb: AgentWeb? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAgentWeb = AgentWeb.with(this)
            .setAgentWebParent(container, LinearLayout.LayoutParams(-1, -1))//传入AgentWeb的父控件
            .useDefaultIndicator()//指示器 设置进度条颜色与高度，-1为默认值，高度为2，单位为dp。
            .setAgentWebWebSettings(settings)
            .setWebChromeClient(mWebChromeClient)
            .setPermissionInterceptor(mPermissionInterceptor) //权限拦截 2.0.0 加入。
            .setWebViewClient(mWebViewClient)
            .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
            .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
            //.setWebLayout(WebLayout(this))
            .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
            .interceptUnkownUrl() //拦截找不到相关页面的Scheme
            .createAgentWeb()
            .ready()
            .go(getUrl())


    }
    private var mWebViewClient:WebViewClient = object : WebViewClient() {

    }
    private var mWebChromeClient:WebChromeClient = object : WebChromeClient() {
        override fun onProgressChanged(view: WebView, newProgress: Int) {
            //do you work
            // Log.i("Info","onProgress:"+newProgress);
        }

        override fun onReceivedTitle(view: WebView, title: String) {
            super.onReceivedTitle(view, title)

        }
    }

    //下载文件
    private val downPath="http://android.myapp.com/"
    //京东
    private val jingDongPath="https://m.jd.com/"
    private fun getUrl(): String {
        return downPath
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {

        return if (mAgentWeb!!.handleKeyEvent(keyCode, event)) {
            true
        } else super.onKeyDown(keyCode, event)
    }

    override fun onPause() {
        mAgentWeb!!.webLifeCycle.onPause()
        super.onPause()

    }

    override fun onResume() {
        mAgentWeb!!.webLifeCycle.onResume()
        super.onResume()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("Info", "onResult:$requestCode onResult:$resultCode")
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroy() {
        super.onDestroy()
        //mAgentWeb.destroy();
        mAgentWeb!!.webLifeCycle.onDestroy()
    }
    private var mAgentWebTemp:AgentWeb?=null
    private var settings:AbsAgentWebSettings =object:AbsAgentWebSettings(){
        override fun bindAgentWebSupport(agentWeb: AgentWeb?) {
            mAgentWebTemp=agentWeb
        }

        override fun setDownloader(
            webView: WebView?,
            downloadListener: android.webkit.DownloadListener?
        ): WebListenerManager {
            return super.setDownloader(webView, DefaultDownloadImpl.create(webView!!.context as Activity,webView,mSimpleDownloadListener,mAgentWebTemp!!.permissionInterceptor))
        }
    }

    private var mSimpleDownloadListener:DownloadListener = object:DownloadListener(){
        /**
         *
         * @param url                下载链接
         * @param userAgent          UserAgent
         * @param contentDisposition ContentDisposition
         * @param mimetype           资源的媒体类型
         * @param contentLength      文件长度
         * @param extra              下载配置 ， 用户可以通过 Extra 修改下载icon ， 关闭进度条 ， 是否强制下载。
         * @return true 表示用户处理了该下载事件 ， false 交给 AgentWeb 下载
         */
        override fun onStart(
            url: String?,
            userAgent: String?,
            contentDisposition: String?,
            mimetype: String?,
            contentLength: Long,
            extra: Extra?
        ): Boolean {
            LogUtils.i("TAG", "onStart:$url")
            extra!!.setBreakPointDownload(true) // 是否开启断点续传
                .setConnectTimeOut(6000) // 连接最大时长
                .setBlockMaxTime(10 * 60 * 1000)  // 以8KB位单位，默认60s ，如果60s内无法从网络流中读满8KB数据，则抛出异常
                .setDownloadTimeOut(java.lang.Long.MAX_VALUE) // 下载最大时长
                .setParallelDownload(true)  // 串行下载更节省资源哦
                .setEnableIndicator(true)  // false 关闭进度通知
                .addHeader("Cookie", "xx") // 自定义请求头
                .setAutoOpen(true) // 下载完成自动打开
                .setForceDownload(true) // 强制下载，不管网络网络类型
            return super.onStart(url, userAgent, contentDisposition, mimetype, contentLength, extra)
        }
        /**
         *
         * @param url  下载链接
         * @param loaded  已经下载的长度
         * @param length    文件的总大小
         * @param usedTime   耗时 ，单位ms
         * 注意该方法回调在子线程 ，线程名 AsyncTask #XX 或者 AgentWeb # XX
         */
        override fun onProgress(url: String?, downloaded: Long, length: Long, usedTime: Long) {
            var mProgress =(downloaded/length.toFloat()*100).toInt()
            LogUtils.i("TAG", "onProgress:$mProgress")
            super.onProgress(url, downloaded, length, usedTime)
        }
        /**
         *
         * @param path 文件的绝对路径
         * @param url  下载地址
         * @param throwable    如果异常，返回给用户异常
         * @return true 表示用户处理了下载完成后续的事件 ，false 默认交给AgentWeb 处理
         */
        override fun onResult(throwable: Throwable?, path: Uri?, url: String?, extra: Extra?): Boolean {
            if (null == throwable) { //下载成功
                //do you work
            } else {//下载失败

            }
            return false // true  不会发出下载完成的通知 , 或者打开文件
        }
    }

    private var mPermissionInterceptor:PermissionInterceptor=object:PermissionInterceptor{
        /**
         * PermissionInterceptor 能达到 url1 允许授权， url2 拒绝授权的效果。
         * @param url
         * @param permissions
         * @param action
         * @return true 该Url对应页面请求权限进行拦截 ，false 表示不拦截。
         */
        override fun intercept(url: String?, permissions: Array<out String>?, action: String?): Boolean {
            return false
        }

    }
}
