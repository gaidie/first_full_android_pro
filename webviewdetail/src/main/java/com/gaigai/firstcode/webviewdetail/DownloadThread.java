package com.gaigai.firstcode.webviewdetail;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.ContentValues.TAG;

/**
 * Created by ga on 2017/2/17.
 */

public class DownloadThread extends Thread {

    public static final int READ_TIME_OUT = 8 * 1000;
    public static final int CONNECTION_TIME_OUT = 8 * 1000;

    private String mUrl;//指定的URL下载地址

    public DownloadThread(String url){
        this.mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(mUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(CONNECTION_TIME_OUT);
            httpURLConnection.setReadTimeout(READ_TIME_OUT);
            InputStream is = httpURLConnection.getInputStream();//获取输入流
            File downloadFile;
            File sdFile;
            FileOutputStream outputStream = null;
            if(DeviceTool.isHasSDCard()){
                downloadFile = Environment.getExternalStorageDirectory();//SD卡存储路径
                sdFile = new File(downloadFile, "/webviewdownload/test.apk");
                outputStream = new FileOutputStream(sdFile);//定义输出流文件
                byte[] buffer = new byte[10 * 1024];//缓冲区
                int length;
                while ((length = is.read(buffer)) != -1){
                    outputStream.write(buffer, 0, length);
                }
            }
            if (outputStream != null){
                outputStream.close();
            }
            if (is != null){
                is.close();
            }
            Log.i(TAG, "run: download 成功");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
