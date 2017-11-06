package com.mirkowu.olddriver.ui.splash;


import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.databinding.ActivitySplashBinding;
import com.softgarden.baselibrary.base.databinding.DataBindingActivity;
import com.softgarden.baselibrary.widget.CommonToolbar;

public class SplashActivity extends DataBindingActivity<ActivitySplashBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected CommonToolbar setToolbar() {
        return null;
    }

    @Override
    protected void initialize() {

    }

    @Override
    public void showError(Throwable throwable) {

    }

}
