package com.gaigai.firstcode.webviewdetail;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public WebView mWebView;
    public Button mBackButton;
    public Button mRefreshButton;
    public TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webView);
        mBackButton = (Button) findViewById(R.id.backBtn);
        mRefreshButton = (Button) findViewById(R.id.refreshBtn);

        mBackButton.setOnClickListener(new WebViewListener());
        mRefreshButton.setOnClickListener(new WebViewListener());

        mTitle = (TextView) findViewById(R.id.title);
      mWebView.loadUrl("https://m.hupu.com/");
   //     mWebView.loadUrl("http://android.myapp.com/");

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                mTitle.setText(title);
                super.onReceivedTitle(view, title);
            }

        });

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {

                super.onReceivedError(view, request, error);
                //两种方式 一种加载本地错误界面 或者使用控件提示加载错误
                view.loadUrl("file:///android_asset/404.html");
            }
        });
        mWebView.setDownloadListener(new DownloadListener());

    }


    class DownloadListener implements android.webkit.DownloadListener{

        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            new DownloadThread(url).start();
        }
    }

    class WebViewListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.backBtn:
                    //如果可以返回 则进行界面返回 不能则直接完成
                    if (mWebView.canGoBack()){
                        mWebView.goBack();
                    }else{
                        finish();
                    }
                    break;
                case R.id.refreshBtn:
                    mWebView.reload();
                    break;
                default:

            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }else {
            showConfirm();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showConfirm(){
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("确认退出么？");
        dialog.setMessage("选择是或者否退出");
        dialog.setCancelable(false);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "是", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int buttonId) {
                dialog.dismiss();
                finish();
            }
        });
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int buttonId) {
                dialog.dismiss();
            }
        });
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        dialog.show();
    }

}
