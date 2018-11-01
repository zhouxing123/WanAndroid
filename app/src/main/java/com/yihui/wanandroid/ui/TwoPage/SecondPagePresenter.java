package com.yihui.wanandroid.ui.TwoPage;

import com.yihui.wanandroid.ui.ThirdPage.StanavTypeModel;
import com.yihui.wanandroid.ui.ThirdPage.ThirdPageInteractor;
import com.yihui.wanandroid.ui.ThirdPage.ThirdPageView;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/31]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class SecondPagePresenter {


    private SecondPageView firstPageView;
    private SecondPageInteractor firstPageInteractor;

    SecondPagePresenter(SecondPageView firstFragment, SecondPageInteractor fisrtPageInteractor) {
        this.firstPageView = firstFragment;
        this.firstPageInteractor = fisrtPageInteractor;
    }

    void onResume() {
        if (firstPageView != null) {
            firstPageView.showProgress();
        }

        firstPageInteractor.findItems(this::onFinished);

    }



    void onFinished(List<KnowledgeTypeModel.DataBean> items) {
        if (firstPageView != null) {
            firstPageView.setItems(items);
            firstPageView.hideProgress();
        }
    }
}
