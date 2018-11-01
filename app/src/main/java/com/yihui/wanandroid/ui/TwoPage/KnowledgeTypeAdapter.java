package com.yihui.wanandroid.ui.TwoPage;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yihui.wanandroid.R;
import com.yihui.wanandroid.ui.ThirdPage.StanavTypeModel;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/31]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class KnowledgeTypeAdapter  extends BaseQuickAdapter<KnowledgeTypeModel.DataBean,BaseViewHolder> {

    public KnowledgeTypeAdapter() {
        super(R.layout.item_knowledge_type);
    }

    @Override
    protected void convert(BaseViewHolder helper, KnowledgeTypeModel.DataBean item) {

        helper.setText(R.id.tv_title_name, item.getName());

    }
}

