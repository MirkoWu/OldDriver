package com.mirkowu.olddriver.ui;

import com.mirkowu.olddriver.BR;
import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.bean.JokeBean;
import com.softgarden.baselibrary.base.BaseActivity;
import com.softgarden.baselibrary.base.databinding.DataBindingAdapter;
import com.softgarden.baselibrary.databinding.LayoutRecyclerviewBinding;
import com.softgarden.baselibrary.widget.CommonToolbar;

public class MainActivity extends BaseActivity<MainPresenter, LayoutRecyclerviewBinding> implements MainContract.Display {

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
        mAdapter = new DataBindingAdapter<>(R.layout.item_joke, BR.bean);
        binding.mRecyclerView.setAdapter(mAdapter);
        mPresenter.getJokeList();
    }

    @Override
    public void getJokeList(JokeBean data) {
        mAdapter.setData(data.getData());
    }
}
