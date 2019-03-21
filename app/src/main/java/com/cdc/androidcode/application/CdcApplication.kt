package com.cdc.androidcode.application
import androidx.multidex.MultiDexApplication
import cn.jpush.android.api.JPushInterface
import com.cdc.androidcode.utils.LogUtils
import com.cdc.androidcode.utils.PathUtils
import com.chad.baserecyclerviewadapterhelper.util.Utils
import java.io.File

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)13:30
 * updateDesc:(修改内容)
 */
class CdcApplication: MultiDexApplication() {
    //static 代码段可以防止内存泄露
    init {

    }

    companion object {
        var appContext: CdcApplication? = null

        fun getInstance(): CdcApplication? {
            return appContext
        }
    }



    override fun onCreate() {
        super.onCreate()
        appContext = this
        Utils.init(this)
        com.cdc.androidcode.utils.Utils.init(this)
        var config= LogUtils.getConfig()
        config.globalTag="code"
        config.filePrefix="code"
        config.dir = PathUtils.getExternalStoragePath()+ File.separator+"code"

        AutoSizeUtil().init(this)
        //RudenessScreenHelper(this, 750f).activate() //初始化百分比布局
        JPushInterface.setDebugMode(true)    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this)            // 初始化 JPush
    }


}