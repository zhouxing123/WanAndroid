package com.yihui.wanandroid.ui.ThirdPage;

import com.yihui.wanandroid.ui.FirstPage.ArticleBannerModel;
import com.yihui.wanandroid.ui.FirstPage.ArticleModel;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/31]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public interface ThirdPageView {
    void showProgress();

    void hideProgress();

    void setItems(List<StanavTypeModel.DataBean> items);

    void showMessage(String message);
}
