package com.yihui.wanandroid.ui.FirstPage;

import android.os.Handler;
import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yihui.wanandroid.utils.Urls;

import java.util.Arrays;
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

    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    public void findItems(final OnFinishedListener listener) {
        listener.onFinished(createArrayList());
    }

    private List<String> createArrayList() {
        Log.d("------------------","createArrayList");
        OkGo.<String>get(Urls.URL_ARTICLE)//
                .tag(this)//
                .headers("header1", "headerValue1")//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //注意这里已经是在主线程了
                        String data = response.body();//这个就是返回来的结果
                        Log.d("------------------","------");
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
        return null;
//                "Item 1",
//                "Item 2",
//                "Item 3",
//                "Item 4",
//                "Item 5",
//                "Item 6",
//                "Item 7",
//                "Item 8",
//                "Item 9",
//                "Item 10"
//        );
    }
}
