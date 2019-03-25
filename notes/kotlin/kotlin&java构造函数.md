# kotlin&java构造函数

1. kotlin
```
class LoveValueRecordAdapter2(data: List<LoveValueRecordBean>?) : BaseQuickAdapter<LoveValueRecordBean, BaseViewHolder>(R.layout.item_love_value_record, data) {

    override fun convert(helper: BaseViewHolder, item: LoveValueRecordBean) {

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


```




