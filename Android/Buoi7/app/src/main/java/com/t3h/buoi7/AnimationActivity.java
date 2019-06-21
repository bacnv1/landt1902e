package com.t3h.buoi7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    private ImageView imLauncher;
    private Button btnAlpha;
    private Button btnRotate;
    private Button btnScale;
    private Button btnTranslate;
    private Button btnSet;

    private Animation alpha;
    private Animation rotate;
    private Animation translate;
    private Animation scale;
    private Animation set;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initViews();
    }

    private void initViews() {
        imLauncher = findViewById(R.id.im_launcher);
        btnAlpha = findViewById(R.id.btn_alpha);
        btnRotate = findViewById(R.id.btn_rotate);
        btnScale = findViewById(R.id.btn_scale);
        btnTranslate = findViewById(R.id.btn_translate);
        btnSet = findViewById(R.id.btn_set);

        btnSet.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);

        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        scale = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        translate = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        set = AnimationUtils.loadAnimation(this, R.anim.set_anim);

        alpha.setAnimationListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alpha:
                imLauncher.startAnimation(alpha);
                break;
            case R.id.btn_rotate:
                imLauncher.startAnimation(rotate);
                break;
            case R.id.btn_scale:
                imLauncher.startAnimation(scale);
                break;
            case R.id.btn_set:
                imLauncher.startAnimation(set);
                break;
            case R.id.btn_translate:
                imLauncher.startAnimation(translate);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
