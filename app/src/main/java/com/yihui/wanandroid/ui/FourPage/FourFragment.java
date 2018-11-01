package com.yihui.wanandroid.ui.FourPage;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yihui.wanandroid.R;
import com.yihui.wanandroid.databinding.FragmentFourBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目
 * @author: zhouxing
 * @version: [1.0, ${DATE}]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class FourFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private FragmentFourBinding mainBinding;

    private List<Fragment> list = new ArrayList<>();

    public FourFragment() {
    }

    public static FourFragment newInstance(String param1, String param2) {
        FourFragment fragment = new FourFragment();
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
        mainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_four, container, false);
        initView();
        return mainBinding.getRoot();
    }

    private void initView() {
//        MyAdapter adapter = new MyAdapter(getFragmentManager());
//        mainBinding.viewpagerProduce.setAdapter(adapter);
//        mainBinding.viewpagerProduce.setCurrentItem(0);
//        //绑定
//        mainBinding.tablayout.setupWithViewPager(mainBinding.viewpagerProduce);
//        mainBinding.tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        mainBinding.viewpagerProduce.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
////                mToolbarTitle.setText(titles[position]);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });


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
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

//    class MyAdapter extends PagerAdapter {


//        private MyAdapter(android.support.v4.app.FragmentManager fragmentManager) {
//            super();
//        }
//
//        @Override
//        public int getCount() {
//            return list.size();
//        }
//
//        @Override
//        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//            return false;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return titles[position];
//        }
//    }
}
