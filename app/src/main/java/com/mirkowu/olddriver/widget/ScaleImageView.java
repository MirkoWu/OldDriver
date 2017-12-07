package com.mirkowu.olddriver.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.softgarden.baselibrary.utils.L;
import com.softgarden.baselibrary.utils.ScreenUtil;

/**
 * Created by MirkoWu on 2017/12/8 0008.
 * http://www.jianshu.com/p/297e6af61ee6
 */

public class ScaleImageView extends AppCompatImageView {
    public static final String TAG = ScaleImageView.class.getSimpleName();
    public static final int STATUS_BACK = -1;//缩小退出状态
    public static final int STATUS_NORMAL = 0;//正常状态
    public static final int STATUS_MOVING = 1;//拖动状态
    public static final int STATUS_SCALE = 2;//放大缩小状态
    public static final int DRAG_HEIGHT = 20;//向下拖拽距离 超出就判定为 STATUS_BACK
    private static final float MIN_SCALE_WEIGHT = 0.4f;
    private static final long BACK_DURATION = 500;
    private int curStatus = STATUS_NORMAL;//状态
    private float mDownX, mDownY;
    private int screenHeight;

    public ScaleImageView(Context context) {
        this(context, null);
    }

    public ScaleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        screenHeight = ScreenUtil.getScreenHeight(context);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = event.getRawX();
                mDownY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int disX = (int) (event.getRawX() - mDownX);
                int disY = (int) (event.getRawY() - mDownY);

                if ((disY >= DRAG_HEIGHT && curStatus != STATUS_MOVING) || curStatus == STATUS_MOVING) {
                    L.d(TAG, "disX=" + disX + "  disY=" + disY);
                    handleMoving(disX, disY);
                    return true;
                }

                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                int finalY = (int) (event.getRawY() - mDownY);
                handleBack(event.getRawX(), event.getRawY());
                if (finalY < DRAG_HEIGHT && curStatus == STATUS_NORMAL) {
                    curStatus = STATUS_NORMAL;//小于这个范围都认为是重置为默认状态 图片归位

                } else {//超出下方范围说明已经是应该back
                    curStatus = STATUS_BACK;

                }
                break;

        }
        return super.onTouchEvent(event);
    }

    private void handleMoving(float disX, float disY) {
        curStatus = STATUS_MOVING;
        float scale = 1f;
        float alphaPercent = 1f;
        if (disY > 0) {
            scale = 1 - Math.abs(disY) / screenHeight;
            alphaPercent = 1 - Math.abs(disY) / (screenHeight / 2);
        }
        //平移缩放 背景变化
        setTranslationX(disX);
        setTranslationY(disY);

        scale = Math.min(Math.max(scale, MIN_SCALE_WEIGHT), 1);
        setScaleX(scale);
        setScaleY(scale);

        //  setupBackground(alphaPercent);

    }

    private void handleBack(float mUpX, float mUpY) {
        if (mUpY != mDownY) {
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(mUpY, mDownY);
            valueAnimator.setDuration(BACK_DURATION);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float mY = (float) animation.getAnimatedValue();
                    float percent = (mY - mDownY) / (mUpY - mDownY);
                    float mX = percent * (mUpX - mDownX);
                    handleMoving(mX, mY - mDownY);
                    if (mY == mDownY) {
                        mDownY = 0;
                        mDownX = 0;
                        curStatus = STATUS_NORMAL;
                    }
                }
            });
            valueAnimator.start();
        } else if (mUpX != mDownX) {
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(mUpX, mDownX);
            valueAnimator.setDuration(BACK_DURATION);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float mX = (float) animation.getAnimatedValue();
                    float percent = (mX - mDownX) / (mUpX - mDownX);
                    float mY = percent * (mUpY - mDownY);
                    handleMoving(mX - mDownX, mY);
                    if (mX == mDownX) {
                        mDownY = 0;
                        mDownX = 0;
                        curStatus = STATUS_NORMAL;
                    }
                }
            });
            valueAnimator.start();
        }

    }
}
