package com.mirkowu.olddriver.ui;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mirkowu.olddriver.R;

/**
 * @author by DELL
 * @date on 2017/11/15
 * @describe
 */

public class TestMultiItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {


    public TestMultiItemAdapter() {
        super(null);
        addItemType(1, R.layout.item_joke);
        addItemType(1, R.layout.item_joke);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (item.getItemType()) {
            case 1:
                break;
            case 2:
                break;

        }
    }
}
