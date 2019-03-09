package com.cdc.androidcode.libraries.camera

import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_camera1.*
import com.cdc.camera_orc.CameraActivity
import android.content.Intent
import com.cdc.camera_orc.util.FileUtil
import android.graphics.Bitmap
import com.cdc.camera_orc.util.PictureUtil
import android.text.TextUtils
import android.app.Activity
import android.util.Log
import android.widget.Toast
import java.io.File


class Camera1Activity : BaseActivity() {

    private val requestCameraA = 1000
    private val requestCameraB = 1001
    private val requestCameraC = 1002
    private val requestCameraD = 1003
    private val nameA = "photo_a.jpg"
    private val nameB = "photo_b.jpg"
    private val nameC = "photo_c.jpg"
    private val nameD = "photo_d.jpg"
    private var mCurrFileName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Camera1 ORC")
        setTitleRight("Camera Library")
        setContentView(R.layout.activity_camera1)
        init()
    }

    private fun init() {
        btn_general.setOnClickListener(this)
        btn_card_front.setOnClickListener(this)
        btn_card_back.setOnClickListener(this)
        btn_bank_card.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        if (view != null) {
            when (view.id) {
                R.id.btn_general -> {
                    mCurrFileName = nameA
                    val intent = Intent(this, CameraActivity::class.java)
                    intent.putExtra(
                        CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(application, nameA).absolutePath
                    )
                    intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_GENERAL)
                    startActivityForResult(intent, requestCameraA)
                }
                R.id.btn_card_front -> {
                    mCurrFileName = nameB
                    intent = Intent(this, CameraActivity::class.java)
                    intent.putExtra(
                        CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(application, nameB).absolutePath
                    )
                    intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT)
                    startActivityForResult(intent, requestCameraB)
                }
                R.id.btn_card_back -> {
                    mCurrFileName = nameC
                    intent = Intent(this, CameraActivity::class.java)
                    intent.putExtra(
                        CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(application, nameC).absolutePath
                    )
                    intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_BACK)
                    startActivityForResult(intent, requestCameraC)
                }
                R.id.btn_bank_card -> {
                    mCurrFileName = nameD
                    intent = Intent(this, CameraActivity::class.java)
                    intent.putExtra(
                        CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(application, nameD).absolutePath
                    )
                    intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_BANK_CARD)
                    startActivityForResult(intent, requestCameraD)
                }
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var filePath: String? = null
            when (requestCode) {
                requestCameraA//人证合一
                -> filePath = File(filesDir, nameA).absolutePath
                requestCameraB//身份证正面
                -> filePath = File(filesDir, nameB).absolutePath
                requestCameraC //身份证背面
                -> filePath = File(filesDir, nameC).absolutePath
                requestCameraD //银行卡
                -> filePath = File(filesDir, nameC).absolutePath
            }
            if (TextUtils.isEmpty(filePath)) {
                Toast.makeText(this, "照片获取失败,请重新拍摄", Toast.LENGTH_SHORT).show()
                return
            }

            val smallBitmap = PictureUtil.getSmallBitmap(filePath)
            PictureUtil.saveBitmap(smallBitmap!!, 70, filePath, Bitmap.CompressFormat.JPEG)
            val file = File(filePath)
            if (file != null && smallBitmap != null) {
                setFilePath(smallBitmap, filePath, file)
            }
        }

    }

    private fun setFilePath(smallBitmap: Bitmap, filePath: String?, file: File) {
        when {
            nameA == mCurrFileName -> {
                image_a.setImageBitmap(smallBitmap)
                Log.i("codeA", filePath)
            }
            nameB == mCurrFileName -> {
                image_b.setImageBitmap(smallBitmap)
                Log.i("codeB", filePath)
            }
            nameC == mCurrFileName -> //身份证背面
            {
                image_c.setImageBitmap(smallBitmap)
                Log.i("codeC", filePath)
            }
            nameD == mCurrFileName -> //身份证背面
            {
                image_d.setImageBitmap(smallBitmap)
                Log.i("codeD", filePath)
            }
        }
    }
}
