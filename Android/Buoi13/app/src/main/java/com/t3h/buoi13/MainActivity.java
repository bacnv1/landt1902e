package com.t3h.buoi13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.t3h.buoi13.databinding.ActivityMainBinding;
import com.t3h.buoi13.download.DownloadActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity implements FileAdapter.ItemFileClickListener {
    private ActivityMainBinding binding;
    private FileAdapter adapter;
    private FileManager manager = new FileManager();

    private String currentFolder;

    private final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        if (checkPermission() == true) {
            initViews();
        }else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(PERMISSIONS, 0);
            }
        }
    }

    private boolean checkPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : PERMISSIONS) {
                int check = checkSelfPermission(p);
                if (check != PackageManager.PERMISSION_GRANTED){
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()){
            initViews();
        }else {
            finish();
        }
    }

    private void initViews() {
        adapter = new FileAdapter(this);
        binding.lvFile.setAdapter(adapter);
        adapter.setListener(this);
        readFile(FileManager.PATH);
    }

    private void readFile(String path) {
        currentFolder = path;
        File [] files = manager.getFiles(path);
        adapter.setData(files);
    }

    @Override
    public void onItemFileClicked(File file) {
        if (file.isDirectory()) {
            readFile(file.getPath());
        }
    }

    @Override
    public void onBackPressed() {
        if (currentFolder.equals(FileManager.PATH)) {
            super.onBackPressed();
        }else {
            File f = new File(currentFolder);
            readFile(f.getParent());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_download:
                Intent intent = new Intent(this,
                        DownloadActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
