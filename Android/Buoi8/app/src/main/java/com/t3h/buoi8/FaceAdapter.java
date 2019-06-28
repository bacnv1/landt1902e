package com.t3h.buoi8;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.FaceHolder>{

    private ArrayList<Face> data;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;

    public FaceAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(ArrayList<Face> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FaceHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.item_face,
                viewGroup, false);
        Log.e(getClass().getSimpleName(), "onCreateViewHolder");
        return new FaceHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceHolder faceHolder, final int i) {
        final Face item = data.get(i);
        faceHolder.bindData(item);
        Log.e(getClass().getSimpleName(), "onBindViewHolder - " + i);
        if (itemClickListener != null) {
            faceHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClicked(i);
                }
            });
            faceHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemClickListener.onItemLongClicked(i);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class FaceHolder extends RecyclerView.ViewHolder {
        private ImageView imAvatar;
        private TextView tvName;

        public FaceHolder(@NonNull View itemView) {
            super(itemView);
            imAvatar = itemView.findViewById(R.id.im_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void bindData(Face item){
            imAvatar.setImageResource(item.getAvatar());
            tvName.setText(item.getName());
        }
    }

    public interface ItemClickListener {
        void onItemClicked(int position);
        void onItemLongClicked(int position);
    }
}
