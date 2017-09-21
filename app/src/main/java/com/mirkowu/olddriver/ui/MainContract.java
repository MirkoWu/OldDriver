package com.mirkowu.olddriver.ui;

import com.mirkowu.olddriver.bean.JokeBean;
import com.softgarden.baselibrary.base.IBaseDisplay;
import com.softgarden.baselibrary.base.IBasePresenter;

/**
 * Created by MirkoWu on 2017/9/22 0022.
 */

public interface MainContract {
    interface Display extends IBaseDisplay {
        void getJokeList(JokeBean list);
    }

    interface Presenter extends IBasePresenter<Display> {
        void getJokeList();
    }
}
