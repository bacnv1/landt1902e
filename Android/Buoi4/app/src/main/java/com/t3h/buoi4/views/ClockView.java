package com.t3h.buoi4.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.t3h.buoi4.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockView extends View implements Runnable{
    private Paint paint;
    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    private String currentTime;

    public ClockView(Context context) {
        super(context);
        init(null);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        paint.setTextSize(80);

        Thread t = new Thread(this);
        t.start();

        if (attrs != null){
            TypedArray arr = getContext().getResources()
                    .obtainAttributes(attrs, R.styleable.ClockView);
            int color = arr.getColor(R.styleable.ClockView_color, Color.BLACK);
            float size = arr.getDimension(R.styleable.ClockView_size, 20F);

            paint.setColor(color);
            paint.setTextSize(size);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(currentTime, 100, 100, paint);
    }

    @Override
    public void run() {
        while (true){
            Calendar calendar = Calendar.getInstance();
            currentTime = format.format(calendar.getTime());
            postInvalidate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, width);
    }
}
