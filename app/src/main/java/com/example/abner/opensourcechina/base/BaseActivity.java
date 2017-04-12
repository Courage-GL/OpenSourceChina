package com.example.abner.opensourcechina.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.abner.opensourcechina.R;
import com.example.abner.opensourcechina.app.App;

import butterknife.ButterKnife;

/**
 * Created by Abner on 2017/4/11.
 */

public abstract class BaseActivity extends AppCompatActivity {

    //记录上一个Fragment  记录要隐藏的Fragment
    private BaseFragment lastFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        init();
        initListener();
        loadData();
        App.activity=BaseActivity.this;
    }

    //加载布局
    protected abstract int getLayoutId();

    //初始化
    protected abstract void init();

    //初始化监听
    protected  abstract void initListener();

    //加载数据
    protected  abstract void loadData();

    /**
     * 用于fragment切换
     * @param targetFragment 要跳转的fragment
     * @param params 携带的 参数
     * @param isBack  是否通过back键返回
     */
    public void startFragment(BaseFragment targetFragment,Bundle params,boolean isBack){


        //传递参数
        if(params!=null){

            targetFragment.setParams(params);

        }
        //隐藏上一个fragment
        if(lastFragment!=null){

            transaction.hide(lastFragment);
        }
        //判断是否已经添加 如果没有添加过就添加
        if(!targetFragment.isAdded()){
            transaction.add(R.id.mFrameGroup,targetFragment,targetFragment.getClass().getName());

        }else {
            //已经能够添加了就显示
            transaction.show(targetFragment);
        }

        //添加到回退zhan
        if(isBack){

            transaction.addToBackStack(targetFragment.getClass().getName());

        }
        transaction.commit();
        //记录上一个fragment
        lastFragment=targetFragment;

    }


}
