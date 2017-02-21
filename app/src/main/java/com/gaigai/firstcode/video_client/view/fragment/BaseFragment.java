package com.gaigai.firstcode.video_client.view.fragment;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.gaigai.firstcode.video_client.constant.Constants;

/**
 * 抽象提取所有的Fragment的公共对象和方法
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class BaseFragment extends Fragment {
    protected Activity mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 申请指定的权限
     * android 6.0之后需要动态申请权限
     * @param code
     * @param permissions
     */
    public void requestPermission(int code, String... permissions){
        if (Build.VERSION.SDK_INT >= 23 ){
            requestPermission(code, permissions);
        }
    }

    /**
     * 判断是否声明指定权限
     * @param permissions
     * @return
     */
    public boolean hasPermission(String... permissions){
        for (String persmission : permissions){
            if (ContextCompat.checkSelfPermission(mContext, persmission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case Constants.WRITE_READ_EXTERNAL_CODE:
                if (grantResults.length > 0 && PackageManager.PERMISSION_GRANTED == grantResults[0]){
                    doWriteSDCard();
                }
                break;
            case Constants.HARDWEAR_CAMERA_CODE:
                if (grantResults.length > 0 && PackageManager.PERMISSION_GRANTED == grantResults[0]){
                    openCamera();
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void openCamera() {

    }

    public void doWriteSDCard() {
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
