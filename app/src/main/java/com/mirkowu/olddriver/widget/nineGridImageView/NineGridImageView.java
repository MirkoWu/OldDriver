package com.mirkowu.olddriver.widget.nineGridImageView;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.softgarden.baselibrary.utils.DisplayUtil;
import com.softgarden.baselibrary.widget.GridDividerItemDecoration;

/**
 * @author by DELL
 * @date on 2017/11/4
 * @describe
 */

public class NineGridImageView extends FrameLayout {
    private RecyclerView mRecyclerView;
    private NineGridImageAdapter mImageAdapter;
    private Context mContext;
    private int mSpanCount = 3;
    private int mSpace = 3;//默认5dp
    private GridDividerItemDecoration decoration;

    public NineGridImageView(@NonNull Context context) {
        this(context, null);
    }

    public NineGridImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NineGridImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mRecyclerView = new RecyclerView(context);
        mRecyclerView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        decoration = new GridDividerItemDecoration(DisplayUtil.dip2px(mContext, mSpace), Color.TRANSPARENT);
        mRecyclerView.addItemDecoration(decoration);
        addView(mRecyclerView);
    }

    public void setAdapter(NineGridImageAdapter adapter) {
        if (adapter == null) return;

        //  if (mSpanCount == 0) {
        if (adapter.getItemCount() == 1) mSpanCount = 1;

        else if (adapter.getItemCount() == 2 || adapter.getItemCount() == 4) mSpanCount = 2;

        else mSpanCount = 3;//默认等于3
        //   }
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, mSpanCount));
        mRecyclerView.removeItemDecoration(decoration);
        mRecyclerView.addItemDecoration(decoration);
        mImageAdapter = adapter;
        mRecyclerView.setAdapter(adapter);
    }

    public void setGridSpan(int spanCount) {
        this.mSpanCount = spanCount;
    }

    public void setSpace(int space) {
        this.mSpace = space;
    }


}
