package com.yihui.wanandroid.ui.FirstPage;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yihui.wanandroid.utils.Urls;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/29]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class FirstPageInteractor {
    OnFinishedListener listener;
    interface OnFinishedListener {
        void onFinished(List<ArticleModel.DataBean.DatasBean> items);

        void onArticleBanner(List<ArticleBannerModel.DataBean> datas);
    }

    public void findItems() {
        createArrayList();
        getBannerList();
    }


    private void createArrayList() {

        OkGo.<String>get(Urls.URL_ARTICLE)//
                .tag(this)//
                .headers("header1", "headerValue1")//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //注意这里已经是在主线程了
                        String data = response.body();//这个就是返回来的结果
                        Log.d("------------------","------");
                        Gson gson = new Gson();
                        ArticleModel articleModel = gson.fromJson(response.body(),ArticleModel.class);
                        List<ArticleModel.DataBean.DatasBean> datas = articleModel.getData().getDatas();
                        listener.onFinished(datas);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }

    private void getBannerList() {

        OkGo.<String>get(Urls.URL_ARTICLE_BANNER)//
                .tag(this)//
                .headers("header1", "headerValue1")//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //注意这里已经是在主线程了
                        String data = response.body();//这个就是返回来的结果
                        Log.d("------------------","------");
                        Gson gson = new Gson();
                        ArticleBannerModel articleModel = gson.fromJson(response.body(),ArticleBannerModel.class);
                        List<ArticleBannerModel.DataBean> datas = articleModel.getData();
                        listener.onArticleBanner(datas);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }


    public void setListener(OnFinishedListener listener) {
        this.listener = listener;
    }
}
