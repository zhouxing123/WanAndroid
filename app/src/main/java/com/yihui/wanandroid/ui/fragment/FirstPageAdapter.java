package com.yihui.wanandroid.ui.fragment;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yihui.wanandroid.databinding.ItemAticleBinding;
import com.yihui.wanandroid.R;
import com.yihui.wanandroid.ui.FirstPage.ArticleModel;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/29]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class FirstPageAdapter extends RecyclerView.Adapter<FirstPageAdapter.MainViewHolder> {

    public FirstPageAdapter(List<ArticleModel.DataBean.DatasBean> items) {
        this.items = items;
    }


    private List<ArticleModel.DataBean.DatasBean> items;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAticleBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_aticle, parent, false);
        return new MainViewHolder(inflate.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ItemAticleBinding binding = DataBindingUtil.getBinding(holder.itemView);
        binding.setModel(this.items.get(position));
        binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {


        MainViewHolder(View itemView) {
            super(itemView);
        }
    }
}

