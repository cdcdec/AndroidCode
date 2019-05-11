# kotlin&java构造函数

1. kotlin
```
//1
class LoveValueRecordAdapter2(data: List<LoveValueRecordBean>?) : BaseQuickAdapter<LoveValueRecordBean, BaseViewHolder>(R.layout.item_love_value_record, data) {

    override fun convert(helper: BaseViewHolder, item: LoveValueRecordBean) {

    }
}
//2
class TabEntity(var title: String, var selectedIcon: Int, var unSelectedIcon: Int):CustomTabEntity{
    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }
}
//3  与2的写法效果一样
class TabEntity : CustomTabEntity {
    var title:String=""
    private var selectedIcon: Int=0
    private var unSelectedIcon: Int=0

    constructor( title: String,  selectedIcon: Int,  unSelectedIcon: Int){
        this.title=title
        this.selectedIcon=selectedIcon
        this.unSelectedIcon=unSelectedIcon
    }

    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }
}
```
2. java
```
public class LoveValueRecordAdapter2 extends BaseQuickAdapter<LoveValueRecordBean, BaseViewHolder> {
    public LoveValueRecordAdapter2(@Nullable List<LoveValueRecordBean> data) {
        super(R.layout.item_love_value_record,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LoveValueRecordBean item) {

    }
}


public class TabEntity implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
```




