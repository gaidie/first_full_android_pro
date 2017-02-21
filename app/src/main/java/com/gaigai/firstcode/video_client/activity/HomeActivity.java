package com.gaigai.firstcode.video_client.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gaigai.firstcode.video_client.R;
import com.gaigai.firstcode.video_client.activity.base.BaseActivity;
import com.gaigai.firstcode.video_client.view.fragment.home.HomeFragment;
import com.gaigai.firstcode.video_client.view.fragment.home.MessageFragment;
import com.gaigai.firstcode.video_client.view.fragment.home.MineFragment;

import static android.R.attr.fragment;
import static com.gaigai.firstcode.video_client.R.*;

/**
 * 创建首页所有的Fragment
 *
 */
public class HomeActivity extends BaseActivity{

    private FragmentManager fm;
    private Fragment mCommonFragmentOne;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrent;

    private RelativeLayout mHomeLayout;
    private RelativeLayout mPondLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
    private TextView mHomeView;
    private TextView mPondView;
    private TextView mMessageView;
    private TextView mMineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home_layout);
        initViews();//实例化界面中的所有控件
    }

    private void hideFragment(Fragment fragment, FragmentTransaction ft){
        if (fragment != null){
            ft.hide(fragment);
        }
    }

    private void initViews() {
        mHomeLayout = (RelativeLayout) findViewById(id.home_layout_view);
        mPondLayout = (RelativeLayout) findViewById(id.pond_layout_view);
        mMessageLayout = (RelativeLayout) findViewById(id.message_layout_view);
        mMineLayout = (RelativeLayout) findViewById(id.mine_layout_view);
        mHomeView = (TextView) findViewById(id.home_image_view);
        mMessageView = (TextView) findViewById(id.message_image_view);
        mPondView = (TextView) findViewById(id.fish_image_view);
        mMineView = (TextView) findViewById(id.mine_image_view);
        mHomeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                changeStatusBarColor(color.color_fed952);
                mHomeView.setBackgroundResource(drawable.comui_tab_home_selected);
                mPondView.setBackgroundResource(drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(drawable.comui_tab_person);
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                hideFragment(mCommonFragmentOne, fragmentTransaction);

                if (mHomeFragment == null){
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(id.content_layout, mHomeFragment);
                }else{
                    mCurrent = mHomeFragment;
                    fragmentTransaction.show(mHomeFragment);
                }
                fragmentTransaction.commit();
            }
        });
        mPondLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mMessageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                changeStatusBarColor(color.color_e3e3e3);
                mHomeView.setBackgroundResource(drawable.comui_tab_home);
                mPondView.setBackgroundResource(drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(drawable.comui_tab_message_selected);
                mMineView.setBackgroundResource(drawable.comui_tab_person);
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                hideFragment(mCommonFragmentOne, fragmentTransaction);

                if (mMessageFragment == null){
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(id.content_layout, mMessageFragment);
                }else{
                    mCurrent = mMessageFragment;
                    fragmentTransaction.show(mMessageFragment);
                }
                fragmentTransaction.commit();
            }
        });
        mMineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                changeStatusBarColor(android.R.color.white);
                mHomeView.setBackgroundResource(drawable.comui_tab_home);
                mPondView.setBackgroundResource(drawable.comui_tab_pond);
                mMessageView.setBackgroundResource(drawable.comui_tab_message);
                mMineView.setBackgroundResource(drawable.comui_tab_person_selected);
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mCommonFragmentOne, fragmentTransaction);

                if (mMineFragment == null){
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(id.content_layout, mMineFragment);
                }else{
                    mCurrent = mMineFragment;
                    fragmentTransaction.show(mMineFragment);
                }
                fragmentTransaction.commit();
            }
        });
        mHomeFragment = new HomeFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(id.content_layout, mHomeFragment);
        transaction.commit();

    }


}
