package com.cdc.agentweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.FragmentManager

class CommonActivity : AppCompatActivity() {

    val TYPE_KEY = "type_key"
    private var mFragmentManager: FragmentManager? = null
    private var mAgentWebFragment: AgentWebFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)
        val key = intent.getIntExtra(TYPE_KEY, -1)
        mFragmentManager = this.supportFragmentManager

        openFragment(key)


    }

    private fun openFragment(key:Int){
        var ft = mFragmentManager!!.beginTransaction()
        var mBundle: Bundle= Bundle()
        mAgentWebFragment=SmartRefreshWebFragment.getInstance(mBundle)
        when(key){
            -1->{//SmartRefreshWebFragment::class.java.name
                ft.add(R.id.container_framelayout, mAgentWebFragment as SmartRefreshWebFragment,SmartRefreshWebFragment::class.java.name)
                //mBundle.putString(AgentWebFragment.URL_KEY, "http://www.163.com/")
                mBundle.putString(AgentWebFragment.URL_KEY, "http://m.mogujie.com/?f=mgjlm&ptp=_qd._cps______3069826.152.1.0")
            }
        }
        ft.commit()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val mAgentWebFragment = this.mAgentWebFragment
        if (mAgentWebFragment != null) {
            val mFragmentKeyDown = mAgentWebFragment
            return if (mFragmentKeyDown.onFragmentKeyDown(keyCode, event)) {
                true
            } else {
                super.onKeyDown(keyCode, event)
            }
        }

        return super.onKeyDown(keyCode, event)
    }
}
