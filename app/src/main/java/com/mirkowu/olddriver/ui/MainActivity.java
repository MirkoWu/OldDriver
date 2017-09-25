package com.mirkowu.olddriver.ui;

import android.view.View;

import com.mirkowu.library.BaseRVHolder;
import com.mirkowu.library.listener.OnItemClickListener;
import com.mirkowu.olddriver.BR;
import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.bean.JokeBean;
import com.mirkowu.olddriver.refresh.RefreshActivity;
import com.mirkowu.olddriver.widget.MultiImageView;
import com.softgarden.baselibrary.base.databinding.DataBindingAdapter;
import com.softgarden.baselibrary.databinding.LayoutRecyclerviewBinding;
import com.softgarden.baselibrary.utils.EmptyUtil;
import com.softgarden.baselibrary.widget.CommonToolbar;

public class MainActivity extends RefreshActivity<MainPresenter, LayoutRecyclerviewBinding> implements MainContract.Display {

    DataBindingAdapter<JokeBean.DataBean> mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_recyclerview;
    }

    @Override
    protected CommonToolbar setToolbar() {
        return new CommonToolbar.Builder().setTitle(R.string.app_name).build(this);
    }

    @Override
    protected void initialize() {
        super.initialize();
        MultiImageLoader multiImageLoader=new MultiImageLoader();
        mAdapter = new DataBindingAdapter<JokeBean.DataBean>(R.layout.item_joke, BR.bean) {
            @Override
            public void onBindVH(BaseRVHolder holder, JokeBean.DataBean data, int position) {
                ((MultiImageView) holder.getView(R.id.mMultiImageView))
                        .setImagesLoader(multiImageLoader);
                if (data.getGroup() != null && data.getGroup().getLarge_image() != null && EmptyUtil.isNotEmpty(data.getGroup().getLarge_image().getUrl_list())){
                    ((MultiImageView) holder.getView(R.id.mMultiImageView)).setList(data.getGroup().getLarge_image().getUrl_list());

                }
                super.onBindVH(holder, data, position);
            }
        };
        binding.mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new OnItemClickListener<JokeBean.DataBean>() {
            @Override
            public void onItemClickListener(View itemView, JokeBean.DataBean data, int position) {
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
        mAdapter.setData(data.getData());
    }
}
