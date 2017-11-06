package com.mirkowu.olddriver.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mirkowu.olddriver.BR;
import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.bean.JokeBean;
import com.mirkowu.olddriver.refresh.RefreshActivity;
import com.mirkowu.olddriver.ui.splash.SplashActivity;
import com.softgarden.baselibrary.databinding.LayoutRecyclerviewBinding;
import com.softgarden.baselibrary.widget.CommonToolbar;

public class MainActivity extends RefreshActivity<MainPresenter, LayoutRecyclerviewBinding> implements MainContract.Display {

    JokeAdapter jokeAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_recyclerview;
    }

    @Override
    protected CommonToolbar setToolbar() {
        return new CommonToolbar.Builder().setBackButton(0).setTitle(R.string.app_name).build(this);
    }

    @Override
    protected void initialize() {
        super.initialize();
        jokeAdapter = new JokeAdapter(R.layout.item_joke, BR.bean);
        binding.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.mRecyclerView.setAdapter(jokeAdapter);

        jokeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                openActivity(SplashActivity.class);
            }
        });

        onRefresh();
    }

    @Override
    public void onRefresh() {
        mPresenter.getJokeList();

    }

    @Override
    public void getJokeList(JokeBean data) {
        finishRefresh();
        jokeAdapter.setNewData(data.getData());
    }
}
