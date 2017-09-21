package com.softgarden.baselibrary.base;

import android.databinding.ViewDataBinding;

import com.softgarden.baselibrary.BuildConfig;
import com.softgarden.baselibrary.base.databinding.DataBindingActivity;
import com.softgarden.baselibrary.utils.InstanceUtil;
import com.softgarden.baselibrary.utils.ToastUtil;

import java.lang.reflect.ParameterizedType;

/**
 * 可以使用DataBinding的 Activity的基类
 */

public abstract class BaseActivity<T extends IBasePresenter, B extends ViewDataBinding> extends DataBindingActivity<B> {
    protected T mPresenter;

//    @Override
//    protected void initContentView() {
//        commonToolbar = setToolbar();
//        if (commonToolbar != null) {
//            //添加标题栏
//            LinearLayout view = new LinearLayout(this);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            view.setLayoutParams(params);
//            view.setOrientation(LinearLayout.VERTICAL);
//            view.setFitsSystemWindows(true);
//            view.addView(commonToolbar);
//            view.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//            view.setDividerDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_line));
//
//            View contentView = getLayoutInflater().inflate(getLayoutId(), view, false);
//
//            view.addView(contentView);
//            setContentView(view);
//            setSupportActionBar(commonToolbar);//这里将toolbar设置为actionbar
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//        } else {
//            setContentView(getLayoutId());
//        }
//    }

    @Override
    protected void initPresenter() {
        if (this instanceof IBaseDisplay &&
                this.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            Class mPresenterClass = (Class) ((ParameterizedType) (this.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];//获取Presenter的class
            mPresenter = InstanceUtil.getInstance(mPresenterClass);
            if (mPresenter != null) mPresenter.attachView(this);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }

    @Override
    public void showError(Throwable throwable) {
        ToastUtil.s(throwable.getMessage());
        if (BuildConfig.DEBUG) throwable.printStackTrace();
    }

}
