package com.yihui.wanandroid.ui.TwoPage;

import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yihui.wanandroid.ui.ThirdPage.StanavTypeModel;
import com.yihui.wanandroid.ui.ThirdPage.ThirdPageInteractor;
import com.yihui.wanandroid.utils.Urls;

import java.util.List;

/**
 * 功能详细描述
 *
 * @author: zhouxing
 * @version: [1.0, 2018/10/31]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class SecondPageInteractor {


    interface OnFinishedListener {
        void onFinished(List<KnowledgeTypeModel.DataBean> items);

    }
    private OnFinishedListener listener;
    public void findItems(OnFinishedListener listener) {
        this.listener = listener;
        createArrayList();
    }


    private void createArrayList() {

        OkGo.<String>get(Urls.URL_KNOWLEDGE_TYPE)//
                .tag(this)//
                .headers("header1", "headerValue1")//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //注意这里已经是在主线程了
                        String data = response.body();//这个就是返回来的结果
                        Gson gson = new Gson();
                        KnowledgeTypeModel articleModel = gson.fromJson(response.body(),KnowledgeTypeModel.class);
                        if (articleModel.getErrorCode() == 0){
                            listener.onFinished(articleModel.getData());
                        }

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }

}
