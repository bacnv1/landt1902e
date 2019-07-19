package com.t3h.buoi13.download;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.t3h.buoi13.R;
import com.t3h.buoi13.databinding.ActivityDownloadBinding;

import java.io.File;

public class DownloadActivity extends AppCompatActivity implements DownloadListener, DownloadAsync.DownloadCallback {
    private ActivityDownloadBinding binding;
    private String path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_download);
        binding.setListener(this);
        binding.setSuccess(true);
    }

    @Override
    public void onDownloadClicked() {
        binding.setSuccess(false);
        String link = binding.edtLink.getText().toString();
        if (link.isEmpty()) {
            Toast.makeText(this, "Link is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        DownloadAsync async = new DownloadAsync(this);
        async.execute(link);
    }

    @Override
    public void onPreviewClicked() {
        binding.video.setVideoPath(path);
        binding.video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                binding.video.start();
            }
        });
    }

    @Override
    public void onDownloadUpdate(int percent) {
        Log.e(getClass().getSimpleName(), percent + "");
        binding.setPercent(percent);
    }

    @Override
    public void onDownloadSuccess(String path) {
        binding.setSuccess(true);
        this.path = path;
    }
}
