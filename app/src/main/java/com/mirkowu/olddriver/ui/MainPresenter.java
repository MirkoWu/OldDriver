package com.mirkowu.olddriver.ui;

import com.mirkowu.olddriver.network.NetworkTransformerHelper;
import com.mirkowu.olddriver.network.RetrofitManager;
import com.softgarden.baselibrary.base.BasePresenter;

/**
 * Created by MirkoWu on 2017/9/22 0022.
 */

public class MainPresenter extends BasePresenter<MainContract.Display> implements MainContract.Presenter{
    @Override
    public void getJokeList() {
        RetrofitManager.getApiService()
                .getJokeList(-103,10,1,null,null,null)
                .compose(new NetworkTransformerHelper<>(mView))
                .subscribe(mView::getJokeList, mView::showError);
    }
}
