package com.yihui.wanandroid.ui.FirstPage;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.yihui.wanandroid.databinding.FragmentFirstBinding;

import com.yihui.wanandroid.R;
import com.yihui.wanandroid.ui.WebviewActivity;
import com.yihui.wanandroid.utils.GotoActivity;
import com.yihui.wanandroid.widget.CustomDecoration;

import java.util.List;


public class FirstFragment extends Fragment implements FirstPageView {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private FragmentFirstBinding mainBinding;
    public FirstPresenter presenter;

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
        FirstPageAdapter firstPageAdapter = new FirstPageAdapter(items);
        mainBinding.list.setAdapter(firstPageAdapter);
        firstPageAdapter.setOnItemClickListener(new FirstPageAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(ArticleModel.DataBean.DatasBean item) {
                com.orhanobut.logger.Logger.d(item.getTitle()+"---"+item.getApkLink());
                Bundle bundle = new Bundle();
                bundle.putString("url",item.getLink());
                bundle.putString("title",item.getAuthor());
                GotoActivity.gotoActiviy(getActivity(),WebviewActivity.class,bundle);
            }

            @Override
            public void onItemChecked(ArticleModel.DataBean.DatasBean item) {
                Log.d("2","2");
            }
        });
    }

    @Override
    public void showMessage(String message) {

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
