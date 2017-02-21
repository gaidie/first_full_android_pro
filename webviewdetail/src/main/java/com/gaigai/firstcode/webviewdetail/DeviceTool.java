package com.gaigai.firstcode.webviewdetail;

import android.os.Environment;

/**
 * Created by ga on 2017/2/17.
 */

public class DeviceTool {

    public static boolean isHasSDCard(){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }
}
