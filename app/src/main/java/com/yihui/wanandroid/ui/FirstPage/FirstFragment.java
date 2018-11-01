package com.yihui.wanandroid.ui.FirstPage;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.yihui.wanandroid.databinding.FragmentFirstBinding;

import com.yihui.wanandroid.R;
import com.yihui.wanandroid.ui.WebviewActivity;
import com.yihui.wanandroid.utils.GotoActivity;
import com.yihui.wanandroid.widget.CustomDecoration;
import com.yihui.wanandroid.widget.ViewPagerTransform;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 * @author: zhouxing
 * @version: [1.0, ${DATE}]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class FirstFragment extends Fragment implements FirstPageView {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private FragmentFirstBinding mainBinding;
    public FirstPresenter presenter;
    private FirstPageAdapter1 firstPageAdapter1;

    private List<ArticleBannerModel.DataBean> imgRes = new ArrayList();
    private LinearLayout.LayoutParams mDotParams;
    //指示器容器列表
    private List<ImageView> dots = new ArrayList<ImageView>();
    //当前索引
    private int currPageIndex;
    private View headview;

    public FirstFragment() {
    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        initView();
        return mainBinding.getRoot();
    }


    public void initView() {


        CustomDecoration customDecoration = new CustomDecoration(getActivity(), DividerItemDecoration.VERTICAL, R.drawable.graydivider, 5);
        mainBinding.list.addItemDecoration(customDecoration);

        firstPageAdapter1 = new FirstPageAdapter1();
        mainBinding.list.setAdapter(firstPageAdapter1);
        headview = getActivity().getLayoutInflater().inflate(R.layout.article_list_head, (ViewGroup) mainBinding.list.getParent(), false);

        firstPageAdapter1.addHeaderView(headview);

        presenter = new FirstPresenter(this, new FirstPageInteractor());
        presenter.onResume();
    }



    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setItems(List<ArticleModel.DataBean.DatasBean> items) {
//        FirstPageAdapter firstPageAdapter = new FirstPageAdapter(items);
//        mainBinding.list.setAdapter(firstPageAdapter);
//        firstPageAdapter.setOnItemClickListener(new FirstPageAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClicked(ArticleModel.DataBean.DatasBean item) {
//                com.orhanobut.logger.Logger.d(item.getTitle()+"---"+item.getApkLink());
//                Bundle bundle = new Bundle();
//                bundle.putString("url",item.getLink());
//                bundle.putString("title",item.getAuthor());
//                GotoActivity.gotoActiviy(getActivity(),WebviewActivity.class,bundle);
//            }
//
//            @Override
//            public void onItemChecked(ArticleModel.DataBean.DatasBean item) {
//                Log.d("2","2");
//            }
//        });
        firstPageAdapter1.setNewData(items);
        firstPageAdapter1.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.d("2","2");
            }
        });
        firstPageAdapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("url",items.get(position).getLink());
                bundle.putString("title",items.get(position).getAuthor());
                GotoActivity.gotoActiviy(getActivity(),WebviewActivity.class,bundle);
            }
        });
    }

    @Override
    public void setBanner(List<ArticleBannerModel.DataBean> items) {
        Logger.d("--"+items.get(1).getImagePath());

        imgRes = items;
        initViewPage(headview);
    }

    @Override
    public void showMessage(String message) {

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void initViewPage(View headview) {
        ViewPagerTransform  viewPager = headview.findViewById(R.id.vp_article_head);
        TextView pageTitle = headview.findViewById(R.id.tv_pager_title);
        LinearLayout llDot = headview.findViewById(R.id.lineLayout_dot);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(imgRes,viewPager);
        viewPager.setAdapter(viewPagerAdapter);
        // 设置轮播时间
        viewPager.setTimeOut(3);
        // 设置已经有数据了，可以进行轮播，一般轮播的图片等数据是来源于网络，网络数据来了后才设置此值，此处因为是demo，所以直接赋值了
        viewPager.setHasData(true);
        // 开启轮播
        viewPager.startTimer();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d("vivi", "onPageScrolled:  position    " + position + "   positionOffset   " + positionOffset + "  positionOffsetPixels " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {

                //旧点不亮
                dots.get(currPageIndex % imgRes.size()).setSelected(false);
                //设置新的点
                currPageIndex = position;
                //新点亮起来
                dots.get(currPageIndex % imgRes.size()).setSelected(true);

                pageTitle.setText(imgRes.get(currPageIndex % imgRes.size()).getTitle());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

//                Log.d("vivi", "onPageScrollStateChanged: " + state);
            }
        });
        //默认显示第一条
        pageTitle.setText(imgRes.get(0).getTitle());

        viewPagerAdapter.setOnItemClick(new ViewPagerAdapter.OnPageItemClickListener() {
            @Override
            public void onItemClick(int i) {
                Bundle bundle = new Bundle();
                bundle.putString("url",imgRes.get(i).getUrl());
                GotoActivity.gotoActiviy(getActivity(),WebviewActivity.class,bundle);
            }
        });

        mDotParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        mDotParams.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());

        //根据viewpager 的数据去添加指示器
        for (int i = 0; i < imgRes.size(); i++) {

            ImageView imageView = new ImageView(getActivity());

            //添加背景 选择器
            //imageView.setBackgroundResource(R.drawable.dot_selector);
            //添加图片选择器
            imageView.setImageResource(R.drawable.dot_selector);

            //默认为不选择灰色

            imageView.setSelected(false);

            //添加到dot容器
            llDot.addView(imageView, mDotParams);

            dots.add(imageView);
        }

        //设置第一个为选择状态
        dots.get(0).setSelected(true);

    }

}
