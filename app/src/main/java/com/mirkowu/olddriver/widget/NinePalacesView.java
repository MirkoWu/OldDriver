package com.mirkowu.olddriver.widget;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.softgarden.baselibrary.utils.DisplayUtil;

import java.util.List;

/**
 * Created by DELL on 2017/7/6.
 */

public class NinePalacesView extends LinearLayout {
    public static final int COLUMN_COUNT = 3;//每行item个数

    List<?> imgList;//图片地址集合
    int childCount;//格子数量
    int maxWidth;//view的最大宽度
    int eachWidth;//每个item宽度
    int imgPadding;
    LayoutParams firstItemParams, itemParams;

    public OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }


    public NinePalacesView(Context context) {
        this(context, null);
    }

    public NinePalacesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @BindingAdapter("bindImages")
    public static void bindData(NinePalacesView ninePalacesView, List<?> list) {
        ninePalacesView.setData(list);
    }

    public void setData(List<?> list) {
        if (list == null || list.isEmpty()) return;
        childCount = list.size();
        imgList = list;
        initView();
    }

    private void initView() {
        this.setOrientation(VERTICAL);
        this.removeAllViews();
        if (maxWidth == 0) {
            //为了触发onMeasure()来测量MultiImageView的最大宽度，MultiImageView的宽设置为match_parent
            addView(new View(getContext()));
            return;
        }
        imgPadding = DisplayUtil.dip2px(getContext(), 10);
        //
        LayoutParams rowParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);//每行的
        eachWidth = (maxWidth - imgPadding * 2) / COLUMN_COUNT;//
        firstItemParams = new LayoutParams(eachWidth, eachWidth);//每行的第一个
        itemParams = new LayoutParams(eachWidth, eachWidth);//每行的非第一个image
        itemParams.setMargins(imgPadding, 0, 0, 0);

        int column = childCount % COLUMN_COUNT;
        int rowCount = childCount / COLUMN_COUNT
                + (column > 0 ? 1 : 0);// 行数
        for (int rowCursor = 0; rowCursor < rowCount; rowCursor++) {//添加行的容器
            LinearLayout rowLayout = new LinearLayout(getContext());
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);
            rowLayout.setLayoutParams(rowParams);
            if (rowCursor != 0) {
                rowLayout.setPadding(0, imgPadding, 0, 0);
            }
            addView(rowLayout);
            int columnCount = COLUMN_COUNT;
            //最后一行时
            if (rowCursor == rowCount - 1)
                columnCount = column == 0 ? COLUMN_COUNT : column;

            for (int columnCursor = 0; columnCursor < columnCount; columnCursor++) {//每行里再添加item
                int position = columnCursor + rowCursor * COLUMN_COUNT;
                rowLayout.addView(createImageView(position));
            }
        }
    }

    private View createImageView(int position) {
        ImageView iv = new ImageView(getContext());
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setLayoutParams(position % COLUMN_COUNT == 0 ? firstItemParams : itemParams);
        iv.setOnClickListener(new OnClickListener() {//添加点击监听事件
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null)
                    onItemClickListener.onItemClick(iv, position);
            }
        });

        if (imagesLoader != null)
            imagesLoader.loadImage(iv, imgList.get(position));
        else throw new IllegalStateException("imagesLoader ==null ,请设置ImageLoader");
        //  ImageUtil.load(iv, imgList.get(position));//加载图片

        return iv;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (maxWidth == 0) {
            int width = measureWidth(widthMeasureSpec);
            if (width > 0) {
                maxWidth = width;//获取最大宽度
                if (imgList != null && !imgList.isEmpty()) {
                    setData(imgList);
                }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 测量宽度
     *
     * @param measureSpec
     * @return
     */
    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else {
            // Measure the text
            // result = (int) mTextPaint.measureText(mText) + getimgPaddingLeft()
            // + getimgPaddingRight();
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by
                // measureSpec
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    public void setImagesLoader(ImagesLoader imagesLoader) {
        this.imagesLoader = imagesLoader;
    }

    public ImagesLoader imagesLoader;

    public interface ImagesLoader<T> {
        void loadImage(ImageView imageView, T imageBean);
    }

}
