package com.example.abner.opensourcechina.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abner.opensourcechina.R;
import com.example.abner.opensourcechina.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Abner on 2017/4/11.
 */

public class AddFragment extends BaseFragment {


    @BindView(R.id.addTextView)
    TextView addTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.add_fragment;
    }

    @Override
    protected void initView(View view) {


    }

    @Override
    protected void initData() {

        String title="添加";
        addTextView.setText(title);

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
