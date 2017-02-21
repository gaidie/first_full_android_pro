package com.gaigai.firstcode.video_client.activity.base;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.gaigai.firstcode.video_client.util.StatusBarUtil;

public class BaseActivity extends AppCompatActivity {

    public String TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();

    }

    /**
     * 隐藏状态栏
     */
    public void hideStatusBar(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void changeStatusBarColor(@ColorRes int color){
        StatusBarUtil.setStatusBarColor(this, color);

    }

    public void reverseStatusColor(){
        StatusBarUtil.statusBarLightMode(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
