package com.gaigai.firstcode.video_client.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gaigai.firstcode.video_client.R;
import com.gaigai.firstcode.video_client.view.fragment.BaseFragment;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 *
 */
public class MineFragment extends BaseFragment implements View.OnClickListener{

    private View mContentView;
    private RelativeLayout mLoginRelativeLayout;
    private CircleImageView mCircleImageView;
    private TextView mLoginInfoView;
    private TextView mLoginView;
    private RelativeLayout mLoginedLayout;
    private TextView mUserNameView;
    private TextView mTickView;
    private TextView mVideoPlayerView;
    private TextView mShareView;
    private TextView mQrcodeView;
    private TextView mUpdateView;

    public MineFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_mime_layout, null, false);
        initViews();
        return mContentView;
    }

    private void initViews() {
        mLoginedLayout = (RelativeLayout) mContentView.findViewById(R.id.logined_layout);
        mLoginRelativeLayout = (RelativeLayout) mContentView.findViewById(R.id.login_layout);
        mCircleImageView = (CircleImageView) mContentView.findViewById(R.id.user_photo_view);
        mLoginView = (TextView) mContentView.findViewById(R.id.login_view);
        mUserNameView = (TextView) mContentView.findViewById(R.id.username_view);
        mTickView = (TextView) mContentView.findViewById(R.id.tick_view);
        mVideoPlayerView = (TextView) mContentView.findViewById(R.id.video_setting_view);
        mShareView = (TextView) mContentView.findViewById(R.id.share_iooc_view);
        mQrcodeView = (TextView) mContentView.findViewById(R.id.my_qrcode_view);
        mUpdateView = (TextView) mContentView.findViewById(R.id.version_update_view);

    }

    @Override
    public void onClick(View v) {

    }
}
