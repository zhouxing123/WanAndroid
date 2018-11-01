package com.yihui.wanandroid.ui.ThirdPage;

import com.yihui.wanandroid.ui.FirstPage.ArticleBannerModel;
import com.yihui.wanandroid.ui.FirstPage.ArticleModel;
import com.yihui.wanandroid.ui.FirstPage.FirstPageInteractor;
import com.yihui.wanandroid.ui.FirstPage.FirstPageView;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/31]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class ThirdPagePresenter {

    private ThirdPageView firstPageView;
    private ThirdPageInteractor firstPageInteractor;

    ThirdPagePresenter(ThirdPageView firstFragment, ThirdPageInteractor fisrtPageInteractor) {
        this.firstPageView = firstFragment;
        this.firstPageInteractor = fisrtPageInteractor;
    }

    void onResume() {
        if (firstPageView != null) {
            firstPageView.showProgress();
        }

        firstPageInteractor.findItems(this::onFinished);

    }




    void onFailed(String item) {
        if (firstPageView != null) {
            firstPageView.showMessage(String.format("%s clicked", item));
        }
    }

    void onFinished(List<StanavTypeModel.DataBean> items) {
        if (firstPageView != null) {
            firstPageView.setItems(items);
            firstPageView.hideProgress();
        }
    }
}
