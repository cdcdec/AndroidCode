package com.yzx.adapter;

import java.util.List;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mapapi.search.core.PoiInfo;
import com.yzx.im_demo.R;

/**
 * @Title BaiduPoiAdapter
 * @Description 周围热点地址适配器
 * @Company yunzhixun
 * @author zhuqian
 * @date 2015-11-18 下午3:27:48
 */
public class BaiduPoiAdapter extends CommonAdapter<PoiInfo> {

	private int selectionPosition;

	public BaiduPoiAdapter(Context context, List<PoiInfo> datas, int layoutId) {
		super(context, datas, layoutId);
	}

	@Override
	public void convert(ViewHolder viewHolder, PoiInfo t, int position) {
		TextView name = viewHolder.getView(R.id.adapter_baidumap_location_name);
		TextView address = viewHolder
				.getView(R.id.adapter_baidumap_location_address);
		ImageView checked = viewHolder
				.getView(R.id.adapter_baidumap_location_checked);
		if (position == selectionPosition) {
			checked.setVisibility(View.VISIBLE);
		} else {
			checked.setVisibility(View.GONE);
		}
		if (position == 0) {
			name.setText(t.address);
			address.setVisibility(View.GONE);
		}else{
			name.setText(t.name);
			address.setText(t.address);
		}
	}

	public void setSelection(int position) {
		this.selectionPosition = position;
	}
}
