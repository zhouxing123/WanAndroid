package com.yihui.wanandroid.ui.ThirdPage;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yihui.wanandroid.R;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/31]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class StanavTypeAdapter extends BaseQuickAdapter<StanavTypeModel.DataBean,BaseViewHolder> {

    public StanavTypeAdapter() {
        super(R.layout.item_stanav_type);
    }

    @Override
    protected void convert(BaseViewHolder helper, StanavTypeModel.DataBean item) {

        if (item.isCheck()){
            ((TextView)helper.getView(R.id.tv_type_name)).setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
        }else {
            ((TextView)helper.getView(R.id.tv_type_name)).setTextColor(mContext.getResources().getColor(R.color.text_black));
        }
        helper.setText(R.id.tv_type_name, item.getName());

    }
}
