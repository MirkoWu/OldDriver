package com.mirkowu.olddriver.widget.nineGridImageView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by DELL
 * @date on 2017/11/4
 * @describe
 */

public abstract class NineGridImageAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public static final String TAG = NineGridImageAdapter.class.getName();
    public static final int TYPE_SINGLE = 1;
    public static final int TYPE_MULTI = 2;
    private List<T> mData;
    private boolean isSingleAutoFit = true;//单张图时 是否自适应（宽度充满，长度自适应）否则为正方形

    public NineGridImageAdapter(List<T> list) {
        if (list == null) mData = new ArrayList<>();
        else mData = list;
    }

    public NineGridImageAdapter(List<T> list, boolean isSingleAutoFit) {
        if (list == null) mData = new ArrayList<>();
        else mData = list;
        this.isSingleAutoFit = isSingleAutoFit;
    }

    @Override
    public int getItemViewType(int position) {
        return getItemCount() <= 1 ? TYPE_SINGLE : TYPE_MULTI;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (isSingleAutoFit && viewType == TYPE_SINGLE) {
            return (VH) new ViewHolder(generateImageView(parent.getContext()));
        } else {
            return (VH) new ViewHolder(generateSquareImageView(parent.getContext()));
        }
    }


    @Override
    public void onBindViewHolder(VH holder, int position) {
        ImageView imageView = (ImageView) holder.itemView;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null)
                    onItemClickListener.onItemClick(v, position, mData.get(position));
            }
        });
        displayImage(getItemViewType(position) == TYPE_SINGLE, imageView, position, mData.get(position));
    }

    /**
     * @param isSingle  是否是单张图
     * @param imageView
     * @param position
     * @param data
     */
    public abstract void displayImage(boolean isSingle, ImageView imageView, int position, T data);

    protected ImageView generateImageView(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setAdjustViewBounds(true);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        return imageView;
    }

    protected ImageView generateSquareImageView(Context context) {
        SquareImageView imageView = new SquareImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        return imageView;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View v, int position, T data);
    }

    public OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
