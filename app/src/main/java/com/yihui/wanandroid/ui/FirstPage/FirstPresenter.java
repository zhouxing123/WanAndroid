package com.yihui.wanandroid.ui.FirstPage;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/29]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
 public class FirstPresenter {

    private FirstPageView firstPageView;
    private FirstPageInteractor firstPageInteractor;

    FirstPresenter(FirstPageView firstFragment, FirstPageInteractor fisrtPageInteractor) {
        this.firstPageView = firstFragment;
        this.firstPageInteractor = fisrtPageInteractor;
    }

    void onResume() {
        if (firstPageView != null) {
            firstPageView.showProgress();
        }

        firstPageInteractor.findItems(this::onFinished);
    }

     void onItemClicked(String item) {
        if (firstPageView != null) {
            firstPageView.showMessage(String.format("%s clicked", item));
        }
    }

     void onFinished(List<String> items) {
        if (firstPageView != null) {
            firstPageView.setItems(items);
            firstPageView.hideProgress();
        }
    }

    public FirstPageView getMainView() {
        return firstPageView;
    }
}