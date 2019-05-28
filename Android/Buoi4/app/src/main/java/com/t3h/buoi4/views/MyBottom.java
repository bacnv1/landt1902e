package com.t3h.buoi4.views;

import android.app.ActionBar;
import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MyBottom extends AppCompatButton implements View.OnTouchListener {
    public MyBottom(Context context) {
        super(context);
        init();
    }

    public MyBottom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyBottom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnTouchListener(this);
    }

    private float x;
    private float y;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:

                float x = event.getX();
                float y = event.getY();
                float xV = this.x - x;
                float yV = this.y - y;

                setX(getX() - xV);
                setY(getY() - yV);

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }
}
