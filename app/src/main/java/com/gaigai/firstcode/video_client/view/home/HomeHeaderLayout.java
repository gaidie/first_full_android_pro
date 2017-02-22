package com.gaigai.firstcode.video_client.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gaigai.firstcode.commonlib.imageloader.ImageLoaderUtil;
import com.gaigai.firstcode.video_client.R;
import com.gaigai.firstcode.video_client.adapter.PhotoPagerAdapter;
import com.gaigai.firstcode.video_client.module.recommand.RecommandFooterValue;
import com.gaigai.firstcode.video_client.module.recommand.RecommandHeadValue;
import com.gaigai.firstcode.video_client.view.viewpagerindictor.CirclePageIndicator;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by ga on 2017/2/21.
 */

public class HomeHeaderLayout extends RelativeLayout {

    private Context mContext;
    private RelativeLayout mRootView;
    private AutoScrollViewPager mViewPager;
    private CirclePageIndicator mPageIndicator;
    private TextView mHotView;
    private PhotoPagerAdapter mAdapter;
    private ImageView[] mImageViews = new ImageView[4];
    private LinearLayout mFootLayout;

    private RecommandHeadValue mHeadValue;
    private ImageLoaderUtil mLoaderUtil;

    public HomeHeaderLayout(Context context, RecommandHeadValue recommandHeadValue) {
        this(context, null, recommandHeadValue);
    }

    public HomeHeaderLayout(Context context, AttributeSet set, RecommandHeadValue recommandHeadValue){
        super(context, set);
        mContext = context;
        mHeadValue = recommandHeadValue;
        mLoaderUtil = ImageLoaderUtil.getInstance(mContext);
        initViews();
    }

    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mRootView = (RelativeLayout) inflater.inflate(R.layout.listview_home_head_layout, this);
        mViewPager = (AutoScrollViewPager) mRootView.findViewById(R.id.pager);
        mPageIndicator = (CirclePageIndicator) mRootView.findViewById(R.id.pageindictor_view);
        mHotView = (TextView) mRootView.findViewById(R.id.latest_view);
        mImageViews[0]= (ImageView) mRootView.findViewById(R.id.head_image_one);
        mImageViews[1] = (ImageView) mRootView.findViewById(R.id.head_image_two);
        mImageViews[2] = (ImageView) mRootView.findViewById(R.id.head_image_three);
        mImageViews[3] = (ImageView) mRootView.findViewById(R.id.head_image_four);
        mFootLayout = (LinearLayout) mRootView.findViewById(R.id.content_layout);

        mAdapter = new PhotoPagerAdapter(mContext, mHeadValue.ads, true);
        mViewPager.setAdapter(mAdapter);
        mViewPager.startAutoScroll(3000);
        mPageIndicator.setViewPager(mViewPager);

        for ( int i = 0, length = mImageViews.length; i < length; i++){
            mLoaderUtil.displayImage(mImageViews[i], mHeadValue.middle.get(i));
        }
        for(RecommandFooterValue value : mHeadValue.footer){
            mFootLayout.addView(createItem(value));
        }
        mHotView.setText("今日最新");
    }

    private View createItem(RecommandFooterValue value) {
        HomeBottomItem item = new HomeBottomItem(mContext, value);
        return item;
    }

}
