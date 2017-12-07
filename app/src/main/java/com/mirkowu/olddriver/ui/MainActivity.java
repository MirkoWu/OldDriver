package com.mirkowu.olddriver.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mirkowu.olddriver.BR;
import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.bean.JokeBean;
import com.mirkowu.olddriver.databinding.ActivityMainBinding;
import com.mirkowu.olddriver.refresh.RefreshActivity;
import com.softgarden.baselibrary.widget.CommonToolbar;

public class MainActivity extends RefreshActivity<MainPresenter, ActivityMainBinding> implements MainContract.Display {

    JokeAdapter jokeAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected CommonToolbar setToolbar() {
        return new CommonToolbar
                .Builder()
                .setBackButton(0)
                .setTitle(R.string.app_name)
                .build(this);
    }

    @Override
    protected void initialize() {
        super.initialize();
        jokeAdapter = new JokeAdapter(this, R.layout.item_joke, BR.bean);
        binding.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.mRecyclerView.setAdapter(jokeAdapter);
        jokeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

        binding.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        binding.ivRefresh.setOnClickListener(v -> autoRefresh());
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
