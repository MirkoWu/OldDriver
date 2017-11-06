package com.mirkowu.olddriver.ui;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.mirkowu.olddriver.R;
import com.mirkowu.olddriver.bean.JokeBean;
import com.mirkowu.olddriver.utils.ImageUtil;
import com.mirkowu.olddriver.widget.nineGridImageView.NineGridImageAdapter;
import com.mirkowu.olddriver.widget.nineGridImageView.NineGridImageView;
import com.softgarden.baselibrary.base.databinding.DataBindingAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by DELL
 * @date on 2017/11/4
 * @describe
 */

public class JokeAdapter extends DataBindingAdapter<JokeBean.DataBean> {

    public static final String url = "http://f2.dn.anqu.com/down/NjFkNQ==/allimg/1308/54-130R1093137.jpg";
    public JokeAdapter(int mLayoutResId, int variable) {
        super(mLayoutResId, variable);
    }

    @Override
    protected void convert(BaseViewHolder helper, JokeBean.DataBean item) {
        super.convert(helper, item);
        NineGridImageView nineGridImageView = helper.getView(R.id.mNineGridImageView);
        List<JokeBean.DataBean.GroupBean.LargeImageBean> imageBeanList;
        if (item.getGroup().getIs_multi_image() == 1) {//多图
            imageBeanList = item.getGroup().getLarge_image_list();
        } else {
            imageBeanList = new ArrayList<>();
            imageBeanList.add(item.getGroup().getLarge_image());
        }
        GridAdapter adapter = new GridAdapter(imageBeanList);
        adapter.setOnItemClickListener(new NineGridImageAdapter.OnItemClickListener<JokeBean.DataBean.GroupBean.LargeImageBean>() {
            @Override
            public void onItemClick(View v, int position, JokeBean.DataBean.GroupBean.LargeImageBean data) {
                PreviewActivity.openActivity(mContext, data.getUrl_list().get(0).getUrl());
            }
        });
        nineGridImageView.setAdapter(adapter);

    }

    public class GridAdapter extends NineGridImageAdapter<JokeBean.DataBean.GroupBean.LargeImageBean, NineGridImageAdapter.ViewHolder> {

        public GridAdapter(List<JokeBean.DataBean.GroupBean.LargeImageBean> list) {
            super(list);
        }

        @Override
        public void displayImage(boolean isSingle, ImageView imageView, int position, JokeBean.DataBean.GroupBean.LargeImageBean data) {
            if (isSingle) ImageUtil.loadRectangle(imageView, data.getUrl_list().get(0).getUrl());
            else ImageUtil.load(imageView, data.getUrl_list().get(0).getUrl());
        }
    }

}


