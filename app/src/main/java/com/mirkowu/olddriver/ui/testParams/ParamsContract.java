package com.mirkowu.olddriver.ui.testParams;

import com.softgarden.baselibrary.base.IBaseDisplay;
import com.softgarden.baselibrary.base.IBasePresenter;

/**
 * Created by MirkoWu on 2017/9/22 0022.
 */

public interface ParamsContract {
    interface Display extends IBaseDisplay {
        void orderAdd(String orderId);
    }

    interface Presenter extends IBasePresenter<Display> {
        void orderAdd();
    }
}
