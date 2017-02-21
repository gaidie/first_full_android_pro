package com.gaigai.firstcode.video_client.application;

import android.app.Application;
import android.view.View;


/**
 * 1.他是程序的入口
 * 2.初始化工作
 * 3.为整个应用提供上下文
 * Created by ga on 2017/2/10.
 *
 */

public class ClientApplication extends Application{

    private static ClientApplication mClientApplication = null;
    @Override
    public void onCreate() {
        super.onCreate();
        mClientApplication = this;
    }

    public static ClientApplication getInstance(){
        return mClientApplication;
    }
}
