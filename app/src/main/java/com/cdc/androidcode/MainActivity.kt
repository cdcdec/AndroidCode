package com.cdc.androidcode
import androidx.fragment.app.Fragment
import com.cdc.androidcode.component.ComponentFragment
import com.cdc.androidcode.document.DocumentFragment
import com.cdc.androidcode.libraries.LibrariesFragment
import com.cdc.androidcode.programmer.ProgrammerFragment
import com.cdc.androidcode.ui.UserInterfaceFragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), OnTabSelectListener {
    override fun initView() {
        initTab()
        mainTabLayout.setTabData(mTabEntities.toList() as java.util.ArrayList<CustomTabEntity>, this, R.id.tab_content, mTabFragments.toList() as java.util.ArrayList<Fragment>)
        mainTabLayout.setOnTabSelectListener(this)
        mainTabLayout.currentTab=0
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun onTabReselect(position: Int) {

    }

    override fun onTabSelect(position: Int) {

        mainTabLayout.currentTab = position
        when(position){
            0,2,3,4->{
                ImmersionBar.with(this)
                    .reset()
                    //设置状态栏颜色
                    .statusBarColor(R.color.colorPrimary)
                    .keyboardEnable(false)
                    .init()
            }
            1->{
                ImmersionBar.with(this)
                    .reset()
                    //设置状态栏颜色
                    .statusBarColor(R.color.colorPrimary)
                    //.hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                    .keyboardEnable(false)
                    .init()
            }
        }
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
        val tabProgrammer=TabEntity("我的",R.mipmap.icon_programmer_check,R.mipmap.icon_programmer)

        mTabEntities.add(tabComponent)
        mTabEntities.add(tabUserInterface)
        mTabEntities.add(tabDocument)
        mTabEntities.add(tabLibraries)
        mTabEntities.add(tabProgrammer)

        mTabFragments.add(ComponentFragment())
        mTabFragments.add(UserInterfaceFragment())
        mTabFragments.add(DocumentFragment())
        mTabFragments.add(LibrariesFragment())
        mTabFragments.add(ProgrammerFragment())
    }


    //必须先在宿主Activity初始化
    override fun isImmersionBarEnabled(): Boolean {
        return true
    }
}
