package com.yihui.wanandroid.ui.TwoPage;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yihui.wanandroid.R;
import com.yihui.wanandroid.databinding.FragmentTwoBinding;
import com.yihui.wanandroid.ui.ThirdPage.StanavTypeAdapter;
import com.yihui.wanandroid.ui.ThirdPage.StanavTypeModel;
import com.yihui.wanandroid.ui.ThirdPage.ThirdPageInteractor;
import com.yihui.wanandroid.ui.ThirdPage.ThirdPagePresenter;
import com.yihui.wanandroid.widget.CustomDecoration;

import java.util.List;

/**
 * 知识体系
 * @author: zhouxing
 * @version: [1.0, ${DATE}]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class TwoFragment extends Fragment implements SecondPageView {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private FragmentTwoBinding mainBinding;
    private SecondPagePresenter presenter;
    private KnowledgeTypeAdapter knowledgeTypeAdapter;
    public TwoFragment() {
    }

    public static TwoFragment newInstance(String param1, String param2) {
        TwoFragment fragment = new TwoFragment();
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
        mainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_two, container, false);
        initView();
        return mainBinding.getRoot();
    }

    private void initView() {
        CustomDecoration customDecoration = new CustomDecoration(getActivity(), DividerItemDecoration.VERTICAL, R.drawable.graydivider, 5);
        mainBinding.rlvKnowledgeType.addItemDecoration(customDecoration);
         knowledgeTypeAdapter = new KnowledgeTypeAdapter();
        mainBinding.rlvKnowledgeType.setAdapter(knowledgeTypeAdapter);
         knowledgeTypeAdapter.setOnItemClickListener((adapter, view, position) -> {

        });

        presenter = new SecondPagePresenter(this, new SecondPageInteractor());
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
    public void setItems(List<KnowledgeTypeModel.DataBean> items) {
        knowledgeTypeAdapter.setNewData(items);
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
