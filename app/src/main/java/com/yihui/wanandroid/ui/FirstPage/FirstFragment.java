package com.yihui.wanandroid.ui.FirstPage;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yihui.wanandroid.databinding.FragmentFirstBinding;

import com.yihui.wanandroid.R;
import com.yihui.wanandroid.ui.fragment.FirstPageAdapter;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment implements FirstPageView{
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
        initView();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        return mainBinding.getRoot();
    }


    public void initView() {
        presenter = new FirstPresenter(this, new FirstPageInteractor());
//        ArticleModel.DataBean.DatasBean datasBean = new ArticleModel.DataBean.DatasBean();
//        List list = new ArrayList();
//        list.add(datasBean);
//        mainBinding.list.setAdapter(new FirstPageAdapter(list));
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
    public void setItems(List<String> items) {

    }

    @Override
    public void showMessage(String message) {

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
