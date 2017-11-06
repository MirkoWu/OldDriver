package com.softgarden.baselibrary.base;

/**
 * Created by MirkoWu on 2017/9/22 0022.
 */

public class SimpleContract {
    interface Display extends IBaseDisplay {
    }

    interface Presenter extends IBasePresenter<Display> {
    }
}
