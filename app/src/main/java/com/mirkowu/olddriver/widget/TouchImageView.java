package com.mirkowu.olddriver.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * Created by MirkoWu on 2017/12/8 0008.
 */

public class TouchImageView extends AppCompatImageView {

    private Matrix curMatrix = new Matrix();
    private Matrix downMatrix = new Matrix();

    /*** 多触点中心 */
    private PointF midPoint = new PointF();
    private PointF downPoint = new PointF();
    /*** 模式 */
    private int mode;
    public static final int NONE = 0;
    public static final int DRAG = 1;
    public static final int ZOOM = 2;


    /*** 手指落下的距离 */
    private float oldDistance;
    /*** 手指落下的角度 */
    private float oldRotation;

    public TouchImageView(Context context) {
        this(context, null);
    }

    public TouchImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()& MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                mode = DRAG;
                downMatrix.set(curMatrix);
                downPoint.set(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                mode = ZOOM;
                oldDistance = calDis(event);
                oldRotation = calRotation(event);
                if (oldDistance > 10F) {
                    downMatrix.set(curMatrix);
                    midPoint = calMidPoint(event);
                    mode = ZOOM;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG) {
                    curMatrix.set(downMatrix);
                    float dx = event.getX() - downPoint.x;
                    float dy = event.getY() - downPoint.y;
                    curMatrix.postTranslate(dx, dy);
                } else if (mode == ZOOM&& event.getPointerCount() >= 2) {
                    curMatrix.set(downMatrix);
                    float newDis = calDis(event);
                    float rotate = calRotation(event);
                    //指尖移动距离大于10F缩放
                    if (newDis > 10F) {
                        float scace = newDis / oldDistance;
                        curMatrix.postScale(scace, scace, midPoint.x, midPoint.y);
                    }
                    //当旋转的角度大于5F才进行旋转
                    if (Math.abs(rotate - oldRotation) > 5F) {
                        curMatrix.postRotate(rotate - oldRotation,
                                getMeasuredWidth() / 2, getMeasuredHeight() / 2);
                    }
                }

                break;
            case MotionEvent.ACTION_UP:
                mode = NONE;
                break;
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                downMatrix.set(curMatrix);
                if (event.getActionIndex() == 0)
                    downPoint.set(event.getX(1), event.getY(1));
                else if (event.getActionIndex() == 1)
                    downPoint.set(event.getX(0), event.getY(0));
                break;
        }
        setImageMatrix(curMatrix);
        return true;
    }

    // 计算两个触摸点之间的距离
    private float calDis(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    // 计算两个触摸点的中点
    private PointF calMidPoint(MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        return new PointF(x / 2, y / 2);
    }

    //计算角度
    private float calRotation(MotionEvent event) {
        double deltaX = (event.getX(0) - event.getX(1));
        double deltaY = (event.getY(0) - event.getY(1));
        double radius = Math.atan2(deltaY, deltaX);
        return (float) Math.toDegrees(radius);
    }
}
