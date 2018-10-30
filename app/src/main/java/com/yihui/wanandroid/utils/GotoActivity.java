package com.yihui.wanandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


/**
 * 功能详细描述
 * @author: zhouxing
 * @version: [1.0, {2018/93}]
 * @see: [相关类/方法]
 * @describe: [产品/模块版本]
 */
public class GotoActivity {

    public static void gotoActiviy(Context activity, Class c){
        gotoActiviy(activity,c,false);
    }

    public static void gotoActiviy(Context context, Class target, boolean finish){
        Intent intent = new Intent(context,target);
        context.startActivity(intent);
        if (finish){
            Activity activity = (Activity)context;
            activity.finish();
        }
    }

    public static void gotoActiviy(Context context, Class target, Bundle params){
        gotoActiviy(context,target,params,false);
    }

    public static void gotoActiviy(Context context, Class target,Bundle params, boolean finish){
        Intent intent = new Intent(context,target);
        if (params != null){
            intent.putExtras(params);
        }
        context.startActivity(intent);
        if (finish){
            Activity activity = (Activity)context;
            activity.finish();
        }
    }

    public static void gotoActivityForResults(Activity context, Class target, int requestCode){
        gotoActivityForResults(context, target, requestCode);
    }

    public static void gotoActivityForResults(Activity context, Class target, Bundle params, int requestCode){
        Intent intent = new Intent(context,target);
        if (params != null){
            intent.putExtras(params);
        }
        context.startActivityForResult(intent, requestCode);
    }
}
