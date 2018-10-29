package com.yihui.wanandroid.app;

import com.yihui.wanandroid.ui.FirstPage.ArticleModel;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/29]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class BaseModel {

    private ArticleModel.DataBean data;
    private int errorCode;
    private String errorMsg;

    public ArticleModel.DataBean getData() {
        return data;
    }

    public void setData(ArticleModel.DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
