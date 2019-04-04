package com.cdc.androidcode.mine
import android.graphics.Point
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import com.blankj.utilcode.util.DeviceUtils
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_device.*



class DeviceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("我的设备")
        setContentView(R.layout.activity_device)
        init()
    }

    private fun init(){
        //android 版本号
        tvVersion.text=tvVersion.text.toString()+":"+ DeviceUtils.getSDKVersionName()
        //android api
        tvVersionSdk.text=tvVersionSdk.text.toString()+":"+ DeviceUtils.getSDKVersionCode()
        //android id
        tvAndroidId.text=tvAndroidId.text.toString()+":"+DeviceUtils.getAndroidID()


        //mac地址
        tvMacAds.text=tvMacAds.text.toString()+":"+DeviceUtils.getMacAddress()
        //制造商
        tvManufacturer.text=tvManufacturer.text.toString()+":"+DeviceUtils.getManufacturer()

        //model
        tvModel.text=tvModel.text.toString()+":"+DeviceUtils.getModel()
        //是否root
        tvRoot.text=tvRoot.text.toString()+":"+DeviceUtils.isDeviceRooted()

        val config = resources.configuration
        val smallestScreenWidth = config.smallestScreenWidthDp
        tvSmallWidth.text= "最小屏幕宽度:$smallestScreenWidth"
        tvDensity.text=String.format(resources.getString(R.string.logical_density),getDensity())
        tvWidthHeight.text=String.format(resources.getString(R.string.width_height), getWiAndHei()[0], getWiAndHei()[1])
        tvInch.text=String.format(resources.getString(R.string.inch_width_height),getInch()[0],getInch()[1],getInch()[2])
    }

    private fun getDensity():Float{
        val resources = this.resources
        val dm = resources.displayMetrics
        return dm.density
    }

    //获取宽度
    private fun getWidth():Int{
        val resources = this.resources
        val dm = resources.displayMetrics
        return dm.widthPixels
    }

    //获取高度
    private fun getHeight():Int{
        val resources = this.resources
        val dm = resources.displayMetrics
        return dm.heightPixels
    }

    private fun getWiAndHei():List<Int>{
        var lstInt=mutableListOf<Int>()
        var screenH=0
        var screenW=0
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1){
            var display = windowManager.defaultDisplay
            var point = Point()
            display.getRealSize(point)
            screenH = point.y
            screenW = point.x
            lstInt.add(0,screenW)
            lstInt.add(1,screenH)
        }else{
            var dm = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(dm)
            screenW = dm.widthPixels //得到宽度
            screenH = dm.heightPixels //得到高度
            lstInt.add(0,screenW)
            lstInt.add(1,screenH)
        }
        return lstInt
    }

    fun getInch():List<Double>{
        var lstDouble=mutableListOf<Double>()
       var dm:DisplayMetrics  = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        var x = Math.pow((dm.widthPixels/dm.xdpi).toDouble(),2.toDouble())
        var y = Math.pow((dm.heightPixels/dm.ydpi).toDouble(),2.toDouble())
        var screenInches = Math.sqrt(x+y)
        lstDouble.add(x)
        lstDouble.add(y)
        lstDouble.add(screenInches)
        return lstDouble
    }





}
