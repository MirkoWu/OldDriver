package com.mirkowu.olddriver.widget;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import com.softgarden.baselibrary.utils.DisplayUtil;

import java.util.List;

/**
 * @author shoyu
 * @ClassName MultiImageView.java
 * @Description: 显示1~N张图片的View
 */

public class MultiImageView extends LinearLayout {
    public int MAX_WIDTH = 0;

    // 照片的Url列表
    private List<?> imagesList;
    private List<ImageView> imageViewList;
    private int childCount;

    /**
     * 长度 单位为Pixel
     **/
    private int pxOneMaxWandH;  // 单张图最大允许宽高
    private int pxMoreWandH = 0;// 多张图的宽高
    private int pxImagePadding = DisplayUtil.dip2px(getContext(), 3);// 图片间的间距

    private int MAX_PER_ROW_COUNT = 3;// 每行显示最大数

    private LayoutParams onePicPara;
    private LayoutParams morePara, moreParaColumnFirst;
    private LayoutParams rowPara;

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public MultiImageView(Context context) {
        this(context, null);
    }

    public MultiImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @BindingAdapter("bindImages")
    public static void setData(MultiImageView multiImageView, List<?> lists) {
        multiImageView.setData(lists);
    }

    public void setData(List<?> lists) throws IllegalArgumentException {
        if (lists == null) {
            return;
        }
        imagesList = lists;
        childCount = imagesList.size();
        if (MAX_WIDTH > 0) {
            switch (childCount) {
                case 0:
                case 1:
                    pxOneMaxWandH = MAX_WIDTH;
                    break;
                case 2:
                case 4:
                    pxMoreWandH = (MAX_WIDTH - pxImagePadding) / 2;
                    break;
                default:
                    pxMoreWandH = (MAX_WIDTH - pxImagePadding * 2) / 3;
                    break;
            }
            initImageLayoutParams();
        }
//        if (imageViewList == null) {
//            imageViewList = new ArrayList<>();
            initView();
//        } else {
//            for (int i = 0; i < childCount; i++) {
//                loadImageView(imageViewList.get(i), i);
//            }
//        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (MAX_WIDTH == 0) {
            int width = measureWidth(widthMeasureSpec);
            if (width > 0) {
                MAX_WIDTH = width;
                if (imagesList != null && imagesList.size() > 0) {
                    setData(imagesList);
                }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * Determines the width of this view
     *
     * @param measureSpec A measureSpec packed into an int
     * @return The width of the view, honoring constraints from measureSpec
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
            // result = (int) mTextPaint.measureText(mText) + getPaddingLeft()
            // + getPaddingRight();
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by
                // measureSpec
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private void initImageLayoutParams() {
        int wrap = LayoutParams.WRAP_CONTENT;
        int match = LayoutParams.MATCH_PARENT;

        // onePicPara = new LayoutParams(wrap, wrap);
        onePicPara = new LayoutParams(pxOneMaxWandH, pxOneMaxWandH);

        moreParaColumnFirst = new LayoutParams(pxMoreWandH, pxMoreWandH);
        morePara = new LayoutParams(pxMoreWandH, pxMoreWandH);
        morePara.setMargins(pxImagePadding, 0, 0, 0);

        rowPara = new LayoutParams(match, wrap);
    }

    // 根据imageView的数量初始化不同的View布局,还要为每一个View作点击效果
    private void initView() {


        this.setOrientation(VERTICAL);
        this.removeAllViews();
        if (MAX_WIDTH == 0) {
            //为了触发onMeasure()来测量MultiImageView的最大宽度，MultiImageView的宽设置为match_parent
            addView(new View(getContext()));
            return;
        }

        if (imagesList == null || childCount == 0) {
            return;
        }
        switch (childCount) {
            case 1:
                addView(createImageView(0, false));
                return;
            case 2:
            case 4:
                MAX_PER_ROW_COUNT = 2;
                break;
            default:
                MAX_PER_ROW_COUNT = 3;
                break;
        }
        int rowCount = childCount / MAX_PER_ROW_COUNT
                + (childCount % MAX_PER_ROW_COUNT > 0 ? 1 : 0);// 行数
        for (int rowCursor = 0; rowCursor < rowCount; rowCursor++) {
            LinearLayout rowLayout = new LinearLayout(getContext());
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);

            rowLayout.setLayoutParams(rowPara);
            if (rowCursor != 0) {
                rowLayout.setPadding(0, pxImagePadding, 0, 0);
            }

            int columnCount = childCount % MAX_PER_ROW_COUNT == 0 ? MAX_PER_ROW_COUNT
                    : childCount % MAX_PER_ROW_COUNT;//每行的列数
            if (rowCursor != rowCount - 1) {
                columnCount = MAX_PER_ROW_COUNT;
            }

            addView(rowLayout);
            int rowOffset = rowCursor * MAX_PER_ROW_COUNT;// 行偏移

            //特殊处理 5个时
            if (childCount == 5) {
                if (rowCursor == 0) {
                    columnCount = 2;
                    rowOffset = rowCursor * 2;// 数量为5时第一行2张图片
                    pxMoreWandH = (MAX_WIDTH - pxImagePadding) / 2;
                } else {
                    columnCount = 3;
                    rowOffset = rowCursor * 2;//
                    pxMoreWandH = (MAX_WIDTH - pxImagePadding * 2) / 3;
                }
                initImageLayoutParams();
            }

            for (int columnCursor = 0; columnCursor < columnCount; columnCursor++) {
                int position = columnCursor + rowOffset;
                rowLayout.addView(createImageView(position, true));
            }
        }
    }

    private ImageView createImageView(int position, final boolean isMultiImage) {
        // ImageView imageView = new ColorFilterImageView(getContext());//实现图像根据按下抬起动作变化颜色
        ImageView imageView = new ImageView(getContext());
        if (isMultiImage) {
            imageView.setScaleType(ScaleType.CENTER_CROP);
            if (childCount == 5) {
                imageView.setLayoutParams((position == 0 || position == 2) ? moreParaColumnFirst : morePara);
            } else {
                imageView.setLayoutParams(position % MAX_PER_ROW_COUNT == 0 ? moreParaColumnFirst : morePara);
            }
        } else {
            // imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ScaleType.CENTER_CROP);
            imageView.setLayoutParams(onePicPara);
        }

        // imageView.setOnClickListener(new ImageOnClickListener(position));
        // imageView.setBackgroundColor(getResources().getColor(R.color.color_press));
        imageViewList.add(imageView);
        loadImageView(imageView, position);

        return imageView;
    }

    private void loadImageView(ImageView imageView, int position) {
        if (imagesLoader != null)
            imagesLoader.loadImage(imageView, imagesList.get(position), position);
        else throw new IllegalStateException("imagesLoader ==null ,请设置ImageLoader");
    }

    private class ImageOnClickListener implements OnClickListener {

        private int position;

        public ImageOnClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, position);
            }
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void setImagesLoader(ImagesLoader imagesLoader) {
        this.imagesLoader = imagesLoader;
    }

    public ImagesLoader imagesLoader;

    public interface ImagesLoader<T> {
        void loadImage(ImageView imageView, T imageBean, int position);
    }
}