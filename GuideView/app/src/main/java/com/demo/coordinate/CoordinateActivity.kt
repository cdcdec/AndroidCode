package com.demo.coordinate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.ViewGroup
import com.demo.guide.R
import kotlinx.android.synthetic.main.activity_coordinate.*
import android.graphics.Rect
class CoordinateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinate)

        var height = 0
        val resourceId = applicationContext.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            height = applicationContext.resources.getDimensionPixelSize(resourceId)
        }
        Log.e("123","状态栏高度=$height")
        val position1 = IntArray(2)

        var dm:DisplayMetrics=DisplayMetrics()

        windowManager.defaultDisplay.getMetrics(dm)

        Log.e("123","densit=" +dm.density)//3.0
        Log.e("123","densityDpi=" +dm.densityDpi)//480
        Log.e("123","widthPixels=" +dm.widthPixels)//1080
        Log.e("123","heightPixels=" +dm.heightPixels)//1920

        val content = this.findViewById(android.R.id.content) as ViewGroup

        val position3 = IntArray(2)

        content.post {
            content.getLocationInWindow(position3)
            Log.e("123","getLocationInWindow3:" + position3[0] + "," + position3[1])//0,72
        }
        val viewRect = Rect()
        view1.post{
            view1.getLocalVisibleRect(viewRect)
            Log.e("123","getLocationInWindow1:" + viewRect.height() + "," + viewRect.width()+",top="+viewRect.top)//0,72
            Log.e("123","view1.height=:" + view1.height+",view1.width="+view1.width)//180,1080
        }

        val position2 = IntArray(2)

        view2.post{
            view2.getLocationInWindow(position2)
            Log.e("123","getLocationInWindow2:" + position2[0] + "," + position2[1])//0,252
            Log.e("123","view2.height=:" + view2.height+",view2.width="+view2.width)//180,1080
        }



    }
}
