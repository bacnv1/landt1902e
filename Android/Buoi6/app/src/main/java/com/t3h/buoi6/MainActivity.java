package com.t3h.buoi6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvInfo;
    private EditText edtData;
    private Button btnCall;
    private Button btnOpen;
    private Button btnGallery;
    private ImageView imGallery;

    private final int REQUEST_GALLERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        Intent intent = getIntent();
        String userName = intent.getStringExtra(Const.EXTRA_USER_NAME);
        String password = intent.getStringExtra(Const.EXTRA_PASSWORD);
        tvInfo = findViewById(R.id.tv_info);
        tvInfo.setText(userName +" - " + password);

        edtData = findViewById(R.id.edt_data);
        btnCall = findViewById(R.id.btn_call);
        btnGallery = findViewById(R.id.btn_gallery);
        btnOpen = findViewById(R.id.btn_open);
        imGallery = findViewById(R.id.im_gallery);

        btnOpen.setOnClickListener(this);
        btnGallery.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String data = edtData.getText().toString();

        switch (v.getId()){
            case R.id.btn_call:
                Intent call = new Intent(Intent.ACTION_CALL);
                Uri uri = Uri.parse("tel:" + data);
                call.setData(uri);
                startActivity(call);
                break;
            case R.id.btn_gallery:
                Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
                gallery.setType("image/*");
                Intent choose = Intent.createChooser(gallery,
                        "Choose image");
                startActivityForResult(choose, REQUEST_GALLERY);

                break;
            case R.id.btn_open:
                Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse(data));
                startActivity(browser);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK){
            try {
                Bitmap b = MediaStore.Images.Media.getBitmap(getContentResolver(),
                        data.getData());
                imGallery.setImageBitmap(b);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
