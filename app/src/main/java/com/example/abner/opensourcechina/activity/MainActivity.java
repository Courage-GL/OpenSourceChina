package com.example.abner.opensourcechina.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.abner.opensourcechina.R;
import com.example.abner.opensourcechina.base.BaseActivity;
import com.example.abner.opensourcechina.fragment.AddFragment;
import com.example.abner.opensourcechina.fragment.DiscoverFragment;
import com.example.abner.opensourcechina.fragment.DongDanFragment;
import com.example.abner.opensourcechina.fragment.MineFragment;
import com.example.abner.opensourcechina.fragment.NewsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.TitleView)
    TextView TitleView;
    @BindView(R.id.mFrameGroup)
    FrameLayout mFrameGroup;
    @BindView(R.id.zongHeBtn)
    RadioButton zongHeBtn;
    @BindView(R.id.dongTanBtn)
    RadioButton dongTanBtn;
    @BindView(R.id.addBtn)
    ImageView addBtn;
    @BindView(R.id.discoverBtn)
    RadioButton discoverBtn;
    @BindView(R.id.mineBtn)
    RadioButton mineBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initListener() {
        zongHeBtn.setOnClickListener(this);
        dongTanBtn.setOnClickListener(this);
        discoverBtn.setOnClickListener(this);
        mineBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

        startFragment(new NewsFragment(),null,false);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.zongHeBtn:
                startFragment(new NewsFragment(),null,false);
                break;
            case R.id.dongTanBtn:
                startFragment(new DongDanFragment(),null,false);
                break;
            case R.id.discoverBtn:
                startFragment(new DiscoverFragment(),null,false);
                break;
            case R.id.mineBtn:
                startFragment(new MineFragment(),null,false);
                break;
            case R.id.addBtn:
                startFragment(new AddFragment(),null,false);
                break;

        }
    }
}
