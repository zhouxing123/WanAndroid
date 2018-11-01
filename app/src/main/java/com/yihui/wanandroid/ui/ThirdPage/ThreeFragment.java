package com.yihui.wanandroid.ui.ThirdPage;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yihui.wanandroid.R;
import com.yihui.wanandroid.databinding.FragmentThreeBinding;
import com.yihui.wanandroid.ui.FirstPage.ArticleModel;
import com.yihui.wanandroid.ui.FirstPage.FirstPageInteractor;
import com.yihui.wanandroid.ui.FirstPage.FirstPresenter;
import com.yihui.wanandroid.ui.WebviewActivity;
import com.yihui.wanandroid.utils.GotoActivity;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * 导航
 * @author: zhouxing
 * @version: [1.0, ${DATE}]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class ThreeFragment extends Fragment implements ThirdPageView{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private FragmentThreeBinding mainBinding;
    private StanavTypeAdapter stanavTypeAdapter;
    private ThirdPagePresenter presenter;
    private List<StanavTypeModel.DataBean> items;

    private int currentPos = 0;

    private int[] colors = new int[]{
            R.color.text1,
            R.color.text2,
            R.color.text3,
            R.color.text4,
            R.color.text5,
            R.color.text6,
            R.color.text7
    };
    public ThreeFragment() {
    }

    public static ThreeFragment newInstance(String param1, String param2) {
        ThreeFragment fragment = new ThreeFragment();
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
        mainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_three, container, false);
        initView();
        return mainBinding.getRoot();
    }

    private void initView() {
        stanavTypeAdapter = new StanavTypeAdapter();
        mainBinding.rlvSatnavType.setAdapter(stanavTypeAdapter);
        stanavTypeAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (position!=currentPos){
                items.get(currentPos).setCheck(false);
                items.get(position).setCheck(true);
                //改变字体颜色
                currentPos = position;
                stanavTypeAdapter.notifyDataSetChanged();
                //刷新右边
                refreshContent(items.get(position).getArticles());
            }

        });
        presenter = new ThirdPagePresenter(this, new ThirdPageInteractor());
        presenter.onResume();
    }

    private void refreshContent(List<StanavTypeModel.DataBean.ArticlesBean> articles) {

        mainBinding.flowlayout.removeAllViews();
        for (int i = 0; i < articles.size(); i++) {
            final TextView tv = (TextView) LayoutInflater.from(getActivity()).inflate(
                    R.layout.item_flowlayout_tv, mainBinding.flowlayout, false);

            tv.setTextSize(16f);
            Random rand = new Random();
            int num = rand.nextInt(6);
            tv.setTextColor(getResources().getColor(colors[num]));
            tv.setText(articles.get(i).getTitle());

            int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    com.orhanobut.logger.Logger.d("11111"+articles.get(finalI).getTitle());
                    Bundle bundle = new Bundle();
                    bundle.putString("url",articles.get(finalI).getLink());
                    GotoActivity.gotoActiviy(getActivity(),WebviewActivity.class,bundle);
                }
            });

            mainBinding.flowlayout.addView(tv);
        }
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
    public void setItems(List<StanavTypeModel.DataBean> items) {
        this.items = items;
        items.get(0).setCheck(true);
        stanavTypeAdapter.setNewData(items);
        refreshContent(items.get(0).getArticles());
    }

    @Override
    public void showMessage(String message) {

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
