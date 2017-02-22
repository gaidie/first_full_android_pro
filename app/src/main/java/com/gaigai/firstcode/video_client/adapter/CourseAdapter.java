package com.gaigai.firstcode.video_client.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gaigai.firstcode.commonlib.imageloader.ImageLoaderUtil;
import com.gaigai.firstcode.video_client.R;
import com.gaigai.firstcode.video_client.module.recommand.RecommandBodyValue;
import com.gaigai.firstcode.video_client.util.Util;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ga on 2017/2/22.
 */

public class CourseAdapter extends BaseAdapter {

    private static final int CARD_COUNT = 4;
    private static final int VIDEO_TYPE = 0x00;
    private static final int CARD_TYPE_ONE = 0x01;
    private static final int CARD_TYPE_TWO = 0x02;
    private static final int CARD_TYPE_THREE = 0x03;

    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<RecommandBodyValue> mData;
    private ViewHolder mViewHolder;
    // TODO: 2017/2/22  VideoAdContext 还待实现
    private ImageLoaderUtil mImageLoader;

    public CourseAdapter(Context context, ArrayList<RecommandBodyValue> data){
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mData = data;
        mImageLoader = ImageLoaderUtil.getInstance(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        RecommandBodyValue itemValue = (RecommandBodyValue) getItem(position);
        return itemValue.getType();
    }

    @Override
    public int getViewTypeCount() {
        return CARD_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        final RecommandBodyValue value = (RecommandBodyValue) getItem(position);
        if (convertView == null){
            switch (type){
                case VIDEO_TYPE:
                    //显示video卡片
                    mViewHolder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.item_video_layout, parent, false);
                    mViewHolder.mVieoContentLayout = (RelativeLayout)
                            convertView.findViewById(R.id.video_ad_layout);
                    mViewHolder.mLogoView = (CircleImageView) convertView.findViewById(R.id.item_logo_view);
                    mViewHolder.mTitleView = (TextView) convertView.findViewById(R.id.item_title_view);
                    mViewHolder.mInfoView = (TextView) convertView.findViewById(R.id.item_info_view);
                    mViewHolder.mFooterView = (TextView) convertView.findViewById(R.id.item_footer_view);
                    mViewHolder.mShareView = (ImageView) convertView.findViewById(R.id.item_share_view);

                    break;
                case CARD_TYPE_ONE:
                    mViewHolder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.item_product_card_one_layout, parent, false);
                    mViewHolder.mLogoView = (CircleImageView) convertView.findViewById(R.id.item_logo_view);
                    mViewHolder.mTitleView = (TextView) convertView.findViewById(R.id.item_title_view);
                    mViewHolder.mInfoView = (TextView) convertView.findViewById(R.id.item_info_view);
                    mViewHolder.mFooterView = (TextView) convertView.findViewById(R.id.item_footer_view);
                    mViewHolder.mPriceView = (TextView) convertView.findViewById(R.id.item_price_view);
                    mViewHolder.mFromView = (TextView) convertView.findViewById(R.id.item_from_view);
                    mViewHolder.mZanView = (TextView) convertView.findViewById(R.id.item_zan_view);
                    mViewHolder.mProductLayout = (LinearLayout) convertView.findViewById(R.id.product_photo_layout);
                    break;
                case CARD_TYPE_TWO:
                    mViewHolder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.item_product_card_two_layout, parent, false);
                    mViewHolder.mLogoView = (CircleImageView) convertView.findViewById(R.id.item_logo_view);
                    mViewHolder.mTitleView = (TextView) convertView.findViewById(R.id.item_title_view);
                    mViewHolder.mInfoView = (TextView) convertView.findViewById(R.id.item_info_view);
                    mViewHolder.mFooterView = (TextView) convertView.findViewById(R.id.item_footer_view);
                    mViewHolder.mProductView = (ImageView) convertView.findViewById(R.id.product_photo_view);
                    mViewHolder.mPriceView = (TextView) convertView.findViewById(R.id.item_price_view);
                    mViewHolder.mFromView = (TextView) convertView.findViewById(R.id.item_from_view);
                    mViewHolder.mZanView = (TextView) convertView.findViewById(R.id.item_zan_view);
                    break;
                case CARD_TYPE_THREE:
                    mViewHolder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.item_product_card_three_layout, parent, false);
                    mViewHolder.mViewPager = (ViewPager) convertView.findViewById(R.id.pager);
                    //add data
                    ArrayList<RecommandBodyValue> recommandList = Util.handleData(value);
                    mViewHolder.mViewPager.setPageMargin(Util.dip2px(mContext, 12));
                    mViewHolder.mViewPager.setAdapter(new HotSalePagerAdapter(mContext, recommandList));
                    mViewHolder.mViewPager.setCurrentItem(recommandList.size() * 100);
                    break;
            }
            convertView.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        //填充item的数据
        switch (type) {
            case VIDEO_TYPE:
                mImageLoader.displayImage(mViewHolder.mLogoView, value.logo);
                mViewHolder.mTitleView.setText(value.title);
                mViewHolder.mInfoView.setText(value.info.concat("天前"));
                mViewHolder.mFooterView.setText(value.text);
                mViewHolder.mShareView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*ShareDialog dialog = new ShareDialog(mContext, false);
                        dialog.setShareType(Platform.SHARE_VIDEO);
                        dialog.setShareTitle(value.title);
                        dialog.setShareTitleUrl(value.site);
                        dialog.setShareText(value.text);
                        dialog.setShareSite(value.title);
                        dialog.setShareTitle(value.site);
                        dialog.setUrl(value.resource);
                        dialog.show();*/
                    }
                });
                break;
            case CARD_TYPE_ONE:
                mImageLoader.displayImage(mViewHolder.mLogoView, value.logo);
                mViewHolder.mTitleView.setText(value.title);
                mViewHolder.mInfoView.setText(value.info.concat("天前"));
                mViewHolder.mFooterView.setText(value.text);
                mViewHolder.mPriceView.setText(value.price);
                mViewHolder.mFromView.setText(value.from);
                mViewHolder.mZanView.setText("点赞".concat(value.zan));
                mViewHolder.mProductLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 2017/2/22
/*                        Intent intent = new Intent(mContext, PhotoViewActivity.class);
                        intent.putStringArrayListExtra(PhotoViewActivity.PHOTO_LIST, value.url);
                        mContext.startActivity(intent);*/
                    }
                });
                mViewHolder.mProductLayout.removeAllViews();
                //动态添加多个imageview
                for (String url : value.url) {
                    mViewHolder.mProductLayout.addView(createImageView(url));
                }
                break;

            case CARD_TYPE_TWO:
                mImageLoader.displayImage(mViewHolder.mLogoView, value.logo);
                mViewHolder.mTitleView.setText(value.title);
                mViewHolder.mInfoView.setText(value.info.concat("天前"));
                mViewHolder.mFooterView.setText(value.text);
                mViewHolder.mPriceView.setText(value.price);
                mViewHolder.mFromView.setText(value.from);
                mViewHolder.mZanView.setText("点赞"+value.zan);
                //为单个ImageView加载远程图片
                mImageLoader.displayImage(mViewHolder.mProductView, value.url.get(0));
                break;
            case CARD_TYPE_THREE:
                break;
        }

        return convertView;
    }



    //动态添加ImageView
    private ImageView createImageView(String url) {
        ImageView photoView = new ImageView(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.
                LayoutParams(Util.dip2px(mContext, 100),
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.leftMargin = Util.dip2px(mContext, 5);
        photoView.setLayoutParams(params);
        mImageLoader.displayImage(photoView, url);
        return photoView;
    }


    private static class ViewHolder {
        //所有Card共有属性
        private CircleImageView mLogoView;
        private TextView mTitleView;
        private TextView mInfoView;
        private TextView mFooterView;
        //Video Card特有属性
        private RelativeLayout mVieoContentLayout;
        private ImageView mShareView;

        //Video Card外所有Card具有属性
        private TextView mPriceView;
        private TextView mFromView;
        private TextView mZanView;
        //Card One特有属性
        private LinearLayout mProductLayout;
        //Card Two特有属性
        private ImageView mProductView;
        //Card Three特有属性
        private ViewPager mViewPager;
    }
}
