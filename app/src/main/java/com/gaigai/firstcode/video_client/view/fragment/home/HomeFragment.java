package com.gaigai.firstcode.video_client.view.fragment.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gaigai.firstcode.commonlib.okhttp.listener.HttpCallBack;
import com.gaigai.firstcode.video_client.R;
import com.gaigai.firstcode.video_client.module.recommand.BaseRecommandModel;
import com.gaigai.firstcode.video_client.network.RequestCenter;
import com.gaigai.firstcode.video_client.view.fragment.BaseFragment;

/**
 *
 */
public class HomeFragment extends BaseFragment {

    private static final int REQUEST_CODE = 0x119;

    private View mContentView;
    private ListView mListView;
    private TextView qrcodeView;
    private TextView categoryView;
    private TextView searchView;
    private ImageView loadingView;


    private BaseRecommandModel mRecommandData;
    public HomeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_home_layout, container, false);
        initViews();
        return mContentView;
    }

    private void initViews() {
        qrcodeView = (TextView) mContentView.findViewById(R.id.qrcode_view);
        loadingView = (ImageView) mContentView.findViewById(R.id.loading_view);
        categoryView = (TextView) mContentView.findViewById(R.id.category_view);
        searchView = (TextView) mContentView.findViewById(R.id.search_view);
        mListView = (ListView) mContentView.findViewById(R.id.list_view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestCommandData();
    }

    private void requestCommandData() {
        RequestCenter.requestRecommandData(new HttpCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                mRecommandData = (BaseRecommandModel) responseObj;
                //更新UI
                showSuccessView();
            }

            @Override
            public void onError(Object responseObj) {
                showErrorView();
            }
        });
    }

    private void showErrorView() {
    }

    private void showSuccessView() {
    }
}
