package com.yihui.wanandroid.ui.FirstPage;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yihui.wanandroid.databinding.ItemAticleBinding;
import com.yihui.wanandroid.R;
import com.yihui.wanandroid.utils.TimeUtils;

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
    private OnItemClickListener listener;
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAticleBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_aticle, parent, false);
        return new MainViewHolder(inflate.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ItemAticleBinding binding = DataBindingUtil.getBinding(holder.itemView);
        long publishTime = items.get(position).getPublishTime();
        binding.tvAticleTime.setText(TimeUtils.millis2String(publishTime));
        binding.setModel(this.items.get(position));
        binding.ivCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemChecked(items.get(position));
            }
        });

        binding.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(items.get(position));
            }
        });
        binding.executePendingBindings();

    }

    @BindingAdapter({"imageUrl"})
    public static void loadimage(ImageView imageView, String url){

        if (!TextUtils.isEmpty(url)){
            Glide.with(imageView.getContext()).load(url).into(imageView);
        }else {
            imageView.setVisibility(View.GONE);
        }
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

    public interface OnItemClickListener {
        /**
         * 点击条目
         */
        void onItemClicked(ArticleModel.DataBean.DatasBean item);
        /**
         * 收藏
         */
        void onItemChecked(ArticleModel.DataBean.DatasBean item);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}

