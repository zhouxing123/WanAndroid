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
public interface FirstPageView {

    void showProgress();

    void hideProgress();

    void setItems(List<ArticleModel.DataBean.DatasBean> items);

    void showMessage(String message);
}
