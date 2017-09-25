package com.mirkowu.olddriver.refresh;

import android.databinding.ViewDataBinding;

import com.mirkowu.library.BaseRVAdapter;
import com.mirkowu.library.listener.OnLoadMoreListener;
import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.constants.Constants;
import com.softgarden.baselibrary.base.BaseLazyFragment;
import com.softgarden.baselibrary.base.databinding.BaseDataBindingFragment;
import com.softgarden.baselibrary.base.IBasePresenter;
import com.softgarden.baselibrary.widget.RefreshDelegateLayout;

import java.util.List;

/**
 * Created by DELL on 2017/7/28.
 */

public abstract class RefreshFragment<T extends IBasePresenter, B extends ViewDataBinding> extends BaseLazyFragment<T, B> implements OnLoadMoreListener {

    RefreshDelegateLayout mRefreshLayout;
    protected int mPage = 1;

    /**
     * initialize 已被实现  需要调用super()
     */
    @Override
    protected void initialize() {
        mRefreshLayout = (RefreshDelegateLayout) mView.findViewById(R.id.mRefreshLayout);
        if (mRefreshLayout != null)
            mRefreshLayout.setOnRefreshDelegateListener(new RefreshDelegateLayout.OnRefreshDelegateListener() {
                @Override
                public void onRefresh() {
                    RefreshFragment.this.onRefresh();
                }
            });
    }

    public abstract void onRefresh();

    public void finishRefresh() {
        if (mRefreshLayout != null) mRefreshLayout.finishRefresh(0);
    }

    @Override
    public void showError(Throwable throwable) {
        super.showError(throwable);
        finishRefresh();
    }

    public void disableRefresh() {
        if (mRefreshLayout != null) mRefreshLayout.setEnableRefresh(false);
    }

    public void setLoadMore(BaseRVAdapter adapter, List<?> list) {
        finishRefresh();
        if (mPage == 1) adapter.setData(list);
        else adapter.addData(list);

        if (list == null || list.size() < Constants.PAGE_COUNT) {
            adapter.loadMoreEnd();
        } else {
            adapter.setOnLoadMoreListener(this);
            adapter.loadMoreComplete();
        }
    }

    @Override
    public void onLoadMore() {

    }
}
