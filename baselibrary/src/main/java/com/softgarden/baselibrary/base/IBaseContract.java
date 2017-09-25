package com.softgarden.baselibrary.base;

/**
 * Created by DELL on 2017/8/11.
 */

public interface IBaseContract {
    interface Display extends IBaseDisplay {

    }

   interface Presenter extends IBasePresenter<Display> {
    }
}
