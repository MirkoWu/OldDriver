package com.mirkowu.olddriver.ui.splash;


import android.animation.Animator;

import com.airbnb.lottie.LottieAnimationView;
import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.databinding.ActivitySplashBinding;
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
        LottieAnimationView animationView = findViewById(R.id.mLottieAnimationView);
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                openActivity(MainActivity.class);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animationView.setSpeed(2f);
    }

    @Override
    public void showError(Throwable throwable) {

    }

}
