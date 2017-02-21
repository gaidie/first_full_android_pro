package com.gaigai.firstcode.video_client.view.fragment.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gaigai.firstcode.video_client.R;
import com.gaigai.firstcode.video_client.view.fragment.BaseFragment;

/**
 * create an instance of this fragment.
 */
public class MessageFragment extends BaseFragment {

    private View mContentView;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mZanLayout;
    private RelativeLayout mIoocLayout;
    private TextView mTipView;
    private TextView mTipZanView;
    private TextView mTipMsgView;

    // TODO: 2017/2/20  待处理mina逻辑

    
    public MessageFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        // TODO: 2017/2/20  待处理 mina逻辑
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_message_layout, null, false);
        initViews();
        return mContentView;
    }

    private void initViews() {
        mMessageLayout = (RelativeLayout) mContentView.findViewById(R.id.content_layout);
        mIoocLayout = (RelativeLayout) mContentView.findViewById(R.id.iooc_layout);
        mZanLayout = (RelativeLayout) mContentView.findViewById(R.id.zan_layout);

        mTipView = (TextView) mContentView.findViewById(R.id.tip_view);
        mTipMsgView = (TextView) mContentView.findViewById(R.id.unread_tip_view);
        mTipZanView = (TextView) mContentView.findViewById(R.id.zan_tip_view);
    }
}
