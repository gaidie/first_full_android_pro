package com.gaigai.firstcode.video_client.constant;

import android.Manifest;
import android.os.Environment;

/**
 * Created by ga on 2017/2/20.
 */

public class Constants {

    public static final int WRITE_READ_EXTERNAL_CODE = 0x01;
    public static final String[] WRITE_READ_EXTERNAL_PERMISSION = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
    Manifest.permission.READ_EXTERNAL_STORAGE};

    public static final int HARDWEAR_CAMERA_CODE = 0x02;

    public static final String[] HARDWEAR_CAMERA_PERMISSION = new String[]{Manifest.permission.CAMERA};

    /**
     * 应用的图片存放目录
     */
    public static String APP_PHOTO_DIR =  Environment.getExternalStorageDirectory().getAbsolutePath()
            .concat("/mvp_gai/videophoto");


}
