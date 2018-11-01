package com.yihui.wanandroid.ui.FirstPage;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yihui.wanandroid.R;
import com.yihui.wanandroid.utils.TimeUtils;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/30]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class FirstPageAdapter1 extends BaseQuickAdapter<ArticleModel.DataBean.DatasBean, BaseViewHolder> {

    public FirstPageAdapter1() {
        super(R.layout.item_aticle1);
    }


    @Override
    protected void convert(BaseViewHolder helper, ArticleModel.DataBean.DatasBean item) {

        helper.setText(R.id.tv_aticle_author, item.getAuthor());
        long publishTime = item.getPublishTime();
        helper.setText(R.id.tv_aticle_time, TimeUtils.millis2String(publishTime));
        helper.setText(R.id.tv_aticle_title, item.getTitle());
        helper.setText(R.id.tv_aticle_type, item.getChapterName());
        helper.addOnClickListener(R.id.iv_collect);
        if (!TextUtils.isEmpty(item.getEnvelopePic())) {
            Glide.with(mContext).load(item.getEnvelopePic()).into((ImageView) helper.getView(R.id.iv_article));
        } else {
            helper.getView(R.id.iv_article).setVisibility(View.GONE);
        }

    }

}
