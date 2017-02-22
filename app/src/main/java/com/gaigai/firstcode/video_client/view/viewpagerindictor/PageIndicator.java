package com.gaigai.firstcode.video_client.view.viewpagerindictor;

import android.support.v4.view.ViewPager;

/**
 * Created by ga on 2017/2/21.
 */

public interface PageIndicator extends ViewPager.OnPageChangeListener{

    void setViewPager(ViewPager viewPager);

    void setViewPager(ViewPager viewPager, int initialPosition);

    void setCurrentItem(int item);

    void setOnPageChangeListener(ViewPager.OnPageChangeListener listener);

    void notifyDataSetChanged();

}
