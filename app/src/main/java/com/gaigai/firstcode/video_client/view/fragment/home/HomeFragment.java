package com.gaigai.firstcode.video_client.view.fragment.home;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gaigai.firstcode.commonlib.okhttp.listener.HttpCallBack;
import com.gaigai.firstcode.video_client.R;
import com.gaigai.firstcode.video_client.adapter.CourseAdapter;
import com.gaigai.firstcode.video_client.module.recommand.BaseRecommandModel;
import com.gaigai.firstcode.video_client.network.RequestCenter;
import com.gaigai.firstcode.video_client.view.fragment.BaseFragment;
import com.gaigai.firstcode.video_client.view.home.HomeHeaderLayout;

/**
 *
 */
public class HomeFragment extends BaseFragment {


    private static final int REQUEST_CODE = 0x119;
    private static final String TAG = "HomeFragment";

    private View mContentView;
    private ListView mListView;
    private TextView qrcodeView;
    private TextView categoryView;
    private TextView searchView;
    private ImageView loadingView;



    private CourseAdapter mCourseAdapter;
    private BaseRecommandModel mRecommandData;
    public HomeFragment(){

    }

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
        AnimationDrawable anim = (AnimationDrawable) loadingView.getDrawable();
        anim.start();//进度条
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestCommandData();
    }

    private void requestCommandData() {
        Log.i(TAG, "requestCommandData: " + "执行几次呢");
        RequestCenter.requestRecommandData(new HttpCallBack() {
            @Override
            public void onSuccess(Object responseObj) {
                mRecommandData = (BaseRecommandModel) responseObj;
                //更新UI
                showSuccessView();
            }

            @Override
            public void onError(Object responseObj) {
                Log.e(TAG, "onError: "+ responseObj );
                showErrorView();
            }
        });
    }

    private void showErrorView() {

    }

    private void showSuccessView() {
        if(mRecommandData.data.list != null && mRecommandData.data.list.size() != 0 ){
            loadingView.setVisibility(View.GONE);//隐藏进度条
            mListView.setVisibility(View.VISIBLE);
            mListView.addHeaderView(new HomeHeaderLayout(mContext, mRecommandData.data.head));
            mCourseAdapter = new CourseAdapter(mContext, mRecommandData.data.list);
            mListView.setAdapter(mCourseAdapter);
           /* mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {

                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    //mAdapter.updateAdInScrollView();
                    // TODO: 2017/2/22  待完成此项目
                }
            });*/
        }else {
            showErrorView();
        }
    }
}
