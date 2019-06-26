package com.t3h.buoi8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FaceAdapter.ItemClickListener {

    private RecyclerView lvFace;
    private ArrayList<Face> data;
    private FaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.beauty, "Beauty"));
        data.add(new Face(R.drawable.oh, "Oh"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.beauty, "Beauty"));
        data.add(new Face(R.drawable.oh, "Oh"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.beauty, "Beauty"));
        data.add(new Face(R.drawable.oh, "Oh"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.beauty, "Beauty"));
        data.add(new Face(R.drawable.oh, "Oh"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.beauty, "Beauty"));
        data.add(new Face(R.drawable.oh, "Oh"));
        data.add(new Face(R.drawable.what, "What"));

        adapter.setData(data);
    }

    private void initViews() {
        lvFace = findViewById(R.id.lv_face);
        adapter = new FaceAdapter(this);
        lvFace.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, data.get(position).getName(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClicked(int position) {
        data.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, data.size());
    }
}
