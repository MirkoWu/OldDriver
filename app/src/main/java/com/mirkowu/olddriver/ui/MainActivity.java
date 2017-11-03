package com.mirkowu.olddriver.ui;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mirkowu.olddriver.BR;
import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.bean.JokeBean;
import com.mirkowu.olddriver.refresh.RefreshActivity;
import com.mirkowu.olddriver.widget.NinePalacesView;
import com.softgarden.baselibrary.base.databinding.DataBindingAdapter;
import com.softgarden.baselibrary.databinding.LayoutRecyclerviewBinding;
import com.softgarden.baselibrary.utils.EmptyUtil;
import com.softgarden.baselibrary.widget.CommonToolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends RefreshActivity<MainPresenter, LayoutRecyclerviewBinding> implements MainContract.Display {

    DataBindingAdapter<JokeBean.DataBean> mAdapter;

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
        MultiImageLoader multiImageLoader = new MultiImageLoader();
        mAdapter = new DataBindingAdapter<JokeBean.DataBean>(R.layout.item_joke, BR.bean) {
            @Override
            protected void convert(BaseViewHolder holder, JokeBean.DataBean data) {
                ((NinePalacesView) holder.getView(R.id.mMultiImageView)).setImagesLoader(multiImageLoader);
                ((NinePalacesView) holder.getView(R.id.mMultiImageView)).setOnItemClickListener(new NinePalacesView.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                    }
                });
                List<JokeBean.DataBean.GroupBean.LargeImageBean> list = new ArrayList<>();

                if (data.getGroup() != null) {
                    if (data.getGroup().getIs_multi_image() == 1) {
                        list.addAll(data.getGroup().getLarge_image_list());
                    } else {
                        if (data.getGroup().getLarge_image() != null && EmptyUtil.isNotEmpty(data.getGroup().getLarge_image().getUrl_list()))
                            list.add(data.getGroup().getLarge_image());
                    }
                }
                ((NinePalacesView) holder.getView(R.id.mMultiImageView)).setData(list);
                super.convert(holder, data);
            }
        };
        binding.mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
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
        mAdapter.setNewData(data.getData());
    }
}
