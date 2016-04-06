package com.yanyuanquan.android.jyh.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.yanyuanquan.android.autoindicator.AutoIndicator;
import com.yanyuanquan.android.jyh.R;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActivityIndicatorTest extends AppCompatActivity {

    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.indicator)
    AutoIndicator indicator;
    private List<String> titles = Arrays.asList("短信1","收藏1","推荐1","短信2","收藏2","推荐2","短3信","收3藏","推3荐");
    private List<Fragment> fragments= new ArrayList<>();
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_indicator2);
        ButterKnife.bind(this);
        initData();
        viewpager.setAdapter(adapter);
        indicator.setTabItemTitles(titles);
        indicator.setViewPager(viewpager,0);




    }

    private void initData() {
        for (String s:titles){
            fragments.add(SimpleFragment.newInstance(s));
        }
        adapter =new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return titles.size();
            }
        };
    }
}
