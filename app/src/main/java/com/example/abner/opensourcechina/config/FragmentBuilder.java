package com.example.abner.opensourcechina.config;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.abner.opensourcechina.R;
import com.example.abner.opensourcechina.app.App;
import com.example.abner.opensourcechina.base.BaseActivity;
import com.example.abner.opensourcechina.base.BaseFragment;

/**
 * Created by Abner on 2017/4/12.
 */

public class FragmentBuilder {

    private FragmentManager manager;
    private  FragmentTransaction transaction;
    private static FragmentBuilder fragmentBuilder;
    private BaseFragment lastFragment;

    private Fragment fragment;
    private FragmentBuilder(){


    }

    public static synchronized FragmentBuilder getInstance(){

        if(fragmentBuilder==null){

            return  fragmentBuilder=new FragmentBuilder();
        }else {

            return fragmentBuilder;
        }
    }

    public FragmentBuilder init(BaseActivity activity){
         manager= activity.getSupportFragmentManager();
         transaction= manager.beginTransaction();
        return this;

    }

    public FragmentBuilder start(Class<? extends BaseFragment> fragmentClass){

        //使用fragment类名作为标识
        String simpleName = fragmentClass.getSimpleName();
        fragment =(BaseFragment) manager.findFragmentByTag(simpleName);

        //隐藏上一个fragment
        if(fragment!=null){

            try {
                //java的动态代理
                fragment=fragmentClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        if(lastFragment!=null){

            transaction.hide(lastFragment);

        }
        //判断是否已经添加 如果没有添加过就添加
        if(!fragment.isAdded()){
            transaction.add(R.id.mFrameGroup,fragment,simpleName);

        }else {
            //已经能够添加了就显示
            transaction.show(fragment);
        }

        return this;

    }

    public FragmentBuilder params(Bundle params){
        if(params!=null){

            fragment.setParams
        }

        return this;

    }

    public FragmentBuilder isBack(){


        return this;
    }

    public BaseFragment build(){

        lastFragment= (BaseFragment) fragment;
        transaction.commit();
       return null;
    }

}
