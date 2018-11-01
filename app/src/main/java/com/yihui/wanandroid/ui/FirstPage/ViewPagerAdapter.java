package com.yihui.wanandroid.ui.FirstPage;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.yihui.wanandroid.R;
import com.yihui.wanandroid.utils.GotoActivity;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/30]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<ArticleBannerModel.DataBean> imgRes;
    private int COEFFICIENT = 20;
    private ViewPager viewPager;
    private OnPageItemClickListener listener;
    public ViewPagerAdapter(List<ArticleBannerModel.DataBean> imgRes, ViewPager viewPager) {
        this.imgRes = imgRes;
        this.viewPager = viewPager;
    }

    @Override
    public int getCount() {
        long realDataCount = imgRes.size();
        if (realDataCount > 1) {
            realDataCount = imgRes.size() * COEFFICIENT;
            realDataCount = realDataCount > Integer.MAX_VALUE ? Integer.MAX_VALUE : realDataCount;
        }
        return (int) realDataCount;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(container.getContext(), R.layout.gallery_view, null);
        ImageView iv = view.findViewById(R.id.iv_head);
        Glide.with(container.getContext()).load(imgRes.get(position % imgRes.size()).getImagePath()).into(iv);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //除以图片数量是为了拿到真实的点击ID
                Logger.d("----" + position % imgRes.size());
                listener.onItemClick(position % imgRes.size());
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public final void finishUpdate(ViewGroup container) {
        // 数量为1，不做position替换
        if (getCount() <= 1) {
            return;
        }

        int position = viewPager.getCurrentItem();
        // ViewPager的更新即将完成，替换position，以达到无限循环的效果
        if (position == 0) {
            position = imgRes.size();
            viewPager.setCurrentItem(position, false);
        } else if (position == getCount() - 1) {
            position = imgRes.size() - 1;
            viewPager.setCurrentItem(position, false);
        }
    }

    void setOnItemClick(OnPageItemClickListener listener ){
        this.listener = listener;
    }

    interface OnPageItemClickListener{
       void onItemClick(int i);
    }

}
