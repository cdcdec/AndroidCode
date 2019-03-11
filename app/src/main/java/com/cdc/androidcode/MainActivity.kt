package com.cdc.androidcode
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cdc.androidcode.component.ComponentFragment
import com.cdc.androidcode.document.DocumentFragment
import com.cdc.androidcode.libraries.LibrariesFragment
import com.cdc.androidcode.mine.MineFragment
import com.cdc.androidcode.ui.UserInterfaceFragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), OnTabSelectListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.hasToolBar=false
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTab()
        mainTabLayout.setTabData(mTabEntities.toList() as java.util.ArrayList<CustomTabEntity>, this, R.id.tab_content, mTabFragments.toList() as java.util.ArrayList<Fragment>)
        mainTabLayout.setOnTabSelectListener(this)
        mainTabLayout.currentTab=0

    }




    override fun onTabReselect(position: Int) {

    }

    override fun onTabSelect(position: Int) {
        mainTabLayout.currentTab = position
    }

    private lateinit var mTabEntities:MutableList<TabEntity>
    private lateinit var mTabFragments:MutableList<Fragment>

    private fun initTab(){
        mTabEntities= ArrayList()
        mTabFragments=ArrayList()
        val tabComponent = TabEntity("组件", R.mipmap.icon_component_check, R.mipmap.icon_component)
        val tabUserInterface = TabEntity("视图", R.mipmap.icon_user_interface_check, R.mipmap.icon_user_interface)
        val tabDocument= TabEntity("文档", R.mipmap.icon_document_check, R.mipmap.icon_document)
        val tabLibraries = TabEntity("库", R.mipmap.icon_libraries_check, R.mipmap.icon_libraries)
        val tabMine=TabEntity("我的",R.mipmap.icon_programmer_check,R.mipmap.icon_programmer)

        mTabEntities.add(0,tabComponent)
        mTabEntities.add(1,tabUserInterface)
        mTabEntities.add(2,tabDocument)
        mTabEntities.add(3,tabLibraries)
        mTabEntities.add(4,tabMine)

        mTabFragments.add(0,ComponentFragment())
        mTabFragments.add(1,UserInterfaceFragment())
        mTabFragments.add(2,DocumentFragment())
        mTabFragments.add(3,LibrariesFragment())
        mTabFragments.add(4,MineFragment())
    }
}
