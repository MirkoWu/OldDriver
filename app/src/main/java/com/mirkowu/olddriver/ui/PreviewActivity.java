package com.mirkowu.olddriver.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.app.Constants;
import com.mirkowu.olddriver.databinding.ActivityPreviewBinding;
import com.mirkowu.olddriver.utils.ImageUtil;
import com.softgarden.baselibrary.base.databinding.DataBindingActivity;
import com.softgarden.baselibrary.widget.CommonToolbar;

public class PreviewActivity extends DataBindingActivity<ActivityPreviewBinding> {
    public static final String url = "http://f2.dn.anqu.com/down/NjFkNQ==/allimg/1308/54-130R1093137.jpg";
    public static final String url2 = "http://img01.bjx.com.cn/news/UploadFile/201605/2016050310502911.png";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_preview;
    }

    @Override
    protected CommonToolbar setToolbar() {
        return null;
    }

    @Override
    protected void initialize() {
        String url = getIntent().getStringExtra(Constants.DATA);
        ImageUtil.load(binding.mImageView, url, new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        supportStartPostponedEnterTransition();
                    }
                });
                return false;
            }
        });
        supportPostponeEnterTransition();
        ViewCompat.setTransitionName(binding.mImageView, "image");
    }

    @Override
    public void showError(Throwable throwable) {

    }

    public static void openActivity(Context context, String url) {
        Intent intent = new Intent(context, PreviewActivity.class);
        intent.putExtra(Constants.DATA, url);
        context.startActivity(intent);
    }

    public static void startOptionsActivity(Activity activity, View view, String url) {
        Intent starter = new Intent(activity, PreviewActivity.class);
        starter.putExtra(Constants.DATA, url);
        ActivityOptionsCompat optionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, "image");
        ActivityCompat.startActivity(activity, starter, optionsCompat.toBundle());
    }
}
