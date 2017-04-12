package com.example.abner.opensourcechina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Abner on 2017/4/11.
 */

public abstract class BaseFragment extends Fragment {

    protected Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        initListener();
        initData();
        loadData();
    }

    //加载布局
    protected abstract  int getLayoutId();

    //初始化View对象
    protected abstract void initView(View view);

    //初始化数据对象
    protected abstract void initData();

    //初始化监听
    protected  abstract void initListener();

    //加载数据
    protected  abstract  void  loadData();
    //页面切换传值
    public void setParams(Bundle bundle){


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
