package com.t3h.buoi7;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart;
    private ImageView imAnim;
    private AnimationDrawable anim;
    private ImageView imLevel;
    private LevelListDrawable level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnStart = findViewById(R.id.btn_start);
        imAnim = findViewById(R.id.im_anim);
        btnStart.setOnClickListener(this);

        anim = (AnimationDrawable) imAnim.getDrawable();

        imLevel = findViewById(R.id.im_level);
        level = (LevelListDrawable) imLevel.getDrawable();

    }

    @Override
    public void onClick(View v) {
//        if (anim.isRunning()) {
//            anim.stop();
//        }else {
//            anim.start();
//        }
        boolean changed = level.setLevel(level.getLevel() + 1);
        if (changed == false){
            level.setLevel(0);
        }
    }
}
