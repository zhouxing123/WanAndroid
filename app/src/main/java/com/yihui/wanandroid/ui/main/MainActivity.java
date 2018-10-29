package com.yihui.wanandroid.ui.main;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.yihui.wanandroid.R;
import com.yihui.wanandroid.databinding.ActivityMainBinding;
import com.yihui.wanandroid.ui.FirstPage.FirstFragment;
import com.yihui.wanandroid.ui.fragment.FourFragment;
import com.yihui.wanandroid.ui.fragment.ThreeFragment;
import com.yihui.wanandroid.ui.fragment.TwoFragment;

import java.lang.ref.WeakReference;
/**
 * 主页
 * @author: zhouxing
 * @version: [1.0, ${DATE}]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener ,
        FourFragment.OnFragmentInteractionListener,FirstFragment.OnFragmentInteractionListener,
ThreeFragment.OnFragmentInteractionListener,TwoFragment.OnFragmentInteractionListener{

    private ActivityMainBinding activityBinding;

    private Fragment currentFragment = new Fragment();
    private final MyHandler mHandler = new MyHandler(this);

    private FirstFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    private static boolean isExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }

    private void initView() {
        //标题
        activityBinding.rdGroup.setOnCheckedChangeListener(this);
        activityBinding.rdMenuFirst.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rd_menu_first:
                activityBinding.title.tvTitleName.setText("首页");
                showFragment(1);
                break;
            case R.id.rd_menu_two:
                activityBinding.title.tvTitleName.setText("知识体系");
                showFragment(2);
                break;
            case R.id.rd_menu_three:
                activityBinding.title.tvTitleName.setText("导航");
                showFragment(3);
                break;
            case R.id.rd_menu_four:
                activityBinding.title.tvTitleName.setText("项目");
                showFragment(4);
                break;
            default:
                break;
        }
    }

    private void showFragment(int i) {
        switch (i) {
            case 1:
                if (oneFragment == null) {
                    oneFragment = new FirstFragment();
                }
                switchFragment(oneFragment).commit();
                break;
            case 2:
                if (twoFragment == null) {
                    twoFragment = new TwoFragment();
                }
                switchFragment(twoFragment).commit();
                break;
            case 3:
                if (threeFragment == null) {
                    threeFragment = new ThreeFragment();
                }
                switchFragment(threeFragment).commit();
                break;
            case 4:
                if (fourFragment == null) {
                    fourFragment = new FourFragment();
                }
                switchFragment(fourFragment).commit();
                break;
            default:
                break;
        }
    }

    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.content, targetFragment, targetFragment.getClass().getName());

        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);


        }
        currentFragment = targetFragment;
        return transaction;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * Handler使用建议使用内部类，因为极其容易引起内存泄漏
     */
    private static  class MyHandler extends Handler {

        private final WeakReference<MainActivity> mActivity;

        private MyHandler(MainActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(android.os.Message msg) {
            MainActivity activity = mActivity.get();
            if (activity != null) {
                if (msg.what == 0) {
                    isExit = false;
                }
            }
        }
    }


//    /**
//     * 点击第二次时关闭应用
//     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//
//            if (!isExit) {
//                isExit = true;
//                // 利用handler延迟发送更改状态信息
//                Log.e("111","1111");
//                mHandler.sendEmptyMessageDelayed(0, 2000);
//            } else {
//                exitApp();
//            }
//            return false;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

//    private void exitApp() {
//
//    }

}
