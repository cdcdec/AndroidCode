# java枚举中的构造函数和函数

```
public enum MainTabs {

    HOME(0, "首页", R.drawable.select_main_tab_home, HomeFragment.class),
    SORT(1, "项目", R.drawable.select_main_tab_project, ProjectFragment.class),
    PROMOTION_PRE(2, "发现", R.drawable.select_main_tab_find, MessageMainFragment.class),
    ME(3, "我的",R.drawable.select_main_tab_mine, MineFragment.class);


    private int idx;
    private String tabName;
    private int drawRes;
    private Class clz;

    MainTabs() {
    }

    MainTabs(int idx, String tabName, int drawRes, Class clz) {
        this.idx = idx;
        this.tabName = tabName;
        this.drawRes = drawRes;
        this.clz = clz;
    }

    public int getIdByName(String tabNameTemp){
        if(tabNameTemp.equals(tabName)){
            return idx;
        }
        return 0;
    }

    public int getIdx() {
        return idx;
    }

    public String getTabName() {
        return tabName;
    }

    public int getDrawRes() {
        return drawRes;
    }

    public Class getClz() {
        return clz;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public void setDrawRes(int drawRes) {
        this.drawRes = drawRes;
    }

    public void setClz(Class clz) {
        this.clz = clz;
    }
}

```







