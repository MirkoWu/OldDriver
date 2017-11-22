package com.mirkowu.olddriver.ui.splash;


import android.animation.Animator;

import com.airbnb.lottie.LottieAnimationView;
import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.databinding.ActivitySplashBinding;
import com.mirkowu.olddriver.listener.SampleAnimatorListener;
import com.mirkowu.olddriver.ui.MainActivity;
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
        binding.mLottieAnimationView.setSpeed(2f);
        binding.mLottieAnimationView.addAnimatorListener(new SampleAnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animation) {
                openActivity(MainActivity.class);
                finish();
            }
        });
    }

    @Override
    public void showError(Throwable throwable) {

    }

}
