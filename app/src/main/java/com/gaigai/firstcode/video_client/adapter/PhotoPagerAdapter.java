package com.gaigai.firstcode.video_client.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gaigai.firstcode.commonlib.imageloader.ImageLoaderUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ga on 2017/2/21.
 */

public class PhotoPagerAdapter extends PagerAdapter {

    private Context mContext;
    private boolean mIsMatch;
    private List<String> mData;
    private ImageLoaderUtil mLoaderUtil;

    public PhotoPagerAdapter(Context context, ArrayList<String> list, boolean isMatch){
        this.mContext = context;
        this.mData = list;
        this.mIsMatch = isMatch;
        mLoaderUtil = ImageLoaderUtil.getInstance(mContext);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView photoView;
        if (mIsMatch){
            photoView = new ImageView(mContext);
            photoView.setScaleType(ImageView.ScaleType.FIT_XY);
            photoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 2017/2/21 待实现处理
                }
            });
        }else {
 //           photoView = new PhotoView(mContext);
            // TODO: 2017/2/21  此处PhotoView待处理
            photoView = new ImageView(mContext);
        }
        mLoaderUtil.displayImage(photoView, mData.get(position));
        container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        return photoView;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
