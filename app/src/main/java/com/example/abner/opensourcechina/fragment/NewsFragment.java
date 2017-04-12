package com.example.abner.opensourcechina.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abner.opensourcechina.R;
import com.example.abner.opensourcechina.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Abner on 2017/4/11.
 */

public class NewsFragment extends BaseFragment {

    @BindView(R.id.newsTabLayout)
    TabLayout newsTabLayout;
    @BindView(R.id.newsViewPager)
    ViewPager newsViewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.news_fragment;
    }

    @Override
    protected void initView(View view) {


    }

    @Override
    protected void initData() {


        newsTabLayout.addTab(newsTabLayout.newTab().setText("小明"));


        newsTabLayout.setupWithViewPager(newsViewPager);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setParams(Bundle bundle) {


    }


}
