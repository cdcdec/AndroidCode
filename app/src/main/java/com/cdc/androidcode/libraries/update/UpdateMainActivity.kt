package com.cdc.androidcode.libraries.update
import android.view.View
import com.cdc.androidcode.R
import sskj.lee.appupdatelibrary.BaseVersion
import sskj.lee.appupdatelibrary.BaseUpdateDialogFragment
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import kotlinx.android.synthetic.main.activity_update_main.*
import sskj.lee.appupdatelibrary.SimpleUpdateFragment
class UpdateMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("App更新")
        setContentView(R.layout.activity_update_main)

        dialog.setOnClickListener(this)
        notifycation.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        super.onClick(v)
        if (v != null) {
            when(v.id){
                R.id.dialog->{
                    val updateFragment = SimpleUpdateFragment()
                    val bundle = Bundle()
                    bundle.putSerializable(BaseUpdateDialogFragment.INTENT_KEY, initData(BaseVersion.DEFAULT_STYLE))
                    updateFragment.arguments = bundle
                    val transition = fragmentManager
                    updateFragment.show(transition, "tag")
                }
                R.id.notifycation->{
                    val updateFragment = SimpleUpdateFragment()
                    val bundle = Bundle()
                    bundle.putSerializable(
                        BaseUpdateDialogFragment.INTENT_KEY,
                        initData(BaseVersion.NOTIFYCATION_STYLE)
                    )
                    updateFragment.arguments = bundle
                    val transition = fragmentManager
                    updateFragment.show(transition, "tag")
                }
            }
        }
    }

    private fun initData(dialogStyle: Int): VersionInfo {
        val versionInfo = VersionInfo()
        versionInfo.content = "版本更新内容\n1.aaaaaaaaaa\n2.bbbbbbbbb"
        versionInfo.title = "版本更新"
        versionInfo.setMustup(false)
        versionInfo.url =
            "https://www.ff.songcaijubao.com/uploads/app/android/20180709/7b05c7c6948e09db2908d32f318a824d.apk"
        versionInfo.viewStyle = dialogStyle
        return versionInfo
    }


}
