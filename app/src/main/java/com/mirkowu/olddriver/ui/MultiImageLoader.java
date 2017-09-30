package com.mirkowu.olddriver.ui;

import android.widget.ImageView;

import com.mirkowu.olddriver.bean.JokeBean;
import com.mirkowu.olddriver.utils.ImageUtil;
import com.mirkowu.olddriver.widget.MultiImageView;

/**
 * @author by DELL
 * @date on 2017/9/24
 * @describe
 */

public class MultiImageLoader implements MultiImageView.ImagesLoader<JokeBean.DataBean.GroupBean.LargeImageBean> {
    @Override
    public void loadImage(ImageView imageView, JokeBean.DataBean.GroupBean.LargeImageBean imageBean, int size) {
        ImageUtil.load(imageView, imageBean.getUrl_list().get(0).getUrl());
    }
}
