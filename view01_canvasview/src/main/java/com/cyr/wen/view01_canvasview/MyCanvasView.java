package com.cyr.wen.view01_canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wen on 2018/1/7.
 * 绘制一个圆
 */

public class MyCanvasView extends View {

    private Paint mPaint;

  //这个构造在new的时候用到
    public MyCanvasView(Context context) {
        this(context, null);
    }

    //这个构造在布局中使用当前view的时候用到
    public MyCanvasView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //这个构造在布局中使用当前view的时候用到,并使用到了style属性
    public MyCanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPoint();
    }

    //初始化画笔
    private void initPoint() {
        mPaint = new Paint();
        //设置画笔颜色
        mPaint.setColor(Color.RED);
        //设置空心圆
        mPaint.setStyle(Paint.Style.STROKE);
        //抗锯齿
        mPaint.setAntiAlias(true);
    }

    //把x,y的坐标封装到这里
    private PointF pf=new PointF(240,400);
    private int PointRadius=200;//半径

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //参数一:  x轴坐标
        //参数二:  y轴坐标
        //参数三:  半径
        //参数四:  画笔对象
        canvas.drawCircle(pf.x, pf.y, PointRadius,mPaint);
    }
}
