package com.wangwei.groupon.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;

import com.viewpagerindicator.CirclePageIndicator;
import com.wangwei.groupon.R;
import com.wangwei.groupon.adapter.MyFragmentPagerAdapter;
import com.wangwei.groupon.fragment.FirstFragment;
import com.wangwei.groupon.fragment.LastFragment;
import com.wangwei.groupon.fragment.SecondFragment;
import com.wangwei.groupon.fragment.ThirdFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends FragmentActivity {


    @BindView(R.id.viewPager_Guide)
    ViewPager viewPagerGuide;
   MyFragmentPagerAdapter adapter = null;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;
    LastFragment lastFragment;
    @BindView(R.id.indicator)
    CirclePageIndicator indicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initiaFragment();
    }

    private void initiaFragment() {
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        lastFragment = new LastFragment();
        viewPagerGuide.setAdapter(adapter);
        adapter.addFragment(firstFragment);
        adapter.addFragment(secondFragment);
        adapter.addFragment(thirdFragment);
        adapter.addFragment(lastFragment);
        viewPagerGuide.setCurrentItem(0,false);

        indicator.setViewPager(viewPagerGuide);
        //当前运行程序所使用的设备的屏幕密度
        //低密度 ldpi  120px/1inch(2.54cm)
        //中密度 mdpi  160px/1inch
        //高密度 hdpi  240px/1inch
        //很高密度 xhdpi 320px/1inch
        //非常高密度 xxhdpi 480px/1inch

        //dp绝对单位 160dp= 1inch
        //1dp 在低密度屏幕上 0.75px
        //1dp 在中密度屏幕上 1px
        //1dp 在高密度屏幕上 1.5px
        //1dp 在很高密度屏幕上 2px
        //1dp 在非常高密度屏幕上 3px

        //另外一种获得10dp在当前设备屏幕密度上的像素值的方式
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,getResources().getDisplayMetrics());

        final float density = getResources().getDisplayMetrics().density;
        //indicator.setBackgroundColor(0xFFCCCCCC);
        //10dp在当前设备上所对应的像素值(px)
        indicator.setRadius(10 * density);
        indicator.setPageColor(0xFFFFFFFF);
        indicator.setFillColor(0xFFFF6633);
        indicator.setStrokeColor(0xFFFF6633);
        indicator.setStrokeWidth(2 * density);

        viewPagerGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //NO_OP
            }

            @Override
            public void onPageSelected(int position) {
                if(position==3){
                    indicator.setVisibility(View.INVISIBLE);
                }else{
                    indicator.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //NO_OP
            }
        });
    }


}
