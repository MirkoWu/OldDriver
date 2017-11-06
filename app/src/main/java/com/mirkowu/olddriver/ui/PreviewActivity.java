package com.mirkowu.olddriver.ui;

import android.content.Context;
import android.content.Intent;

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
        ImageUtil.load(binding.mImageView, url);
    }

    @Override
    public void showError(Throwable throwable) {

    }

    public static void openActivity(Context context, String url) {
        Intent intent = new Intent(context, PreviewActivity.class);
        intent.putExtra(Constants.DATA, url);
        context.startActivity(intent);
    }
}
