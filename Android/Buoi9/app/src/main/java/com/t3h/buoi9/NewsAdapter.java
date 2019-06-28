package com.t3h.buoi9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private ArrayList<News> data;
    private LayoutInflater inflater;

    public NewsAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<News> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_news, parent, false);
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{

        private ImageView imNews;
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvPubDate;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imNews = itemView.findViewById(R.id.im_news);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvPubDate = itemView.findViewById(R.id.tv_date);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }

        public void bindData(News item){
            tvTitle.setText(item.getTitle());
            tvPubDate.setText(item.getPubDate());
            tvDesc.setText(item.getDesc());

            Glide.with(imNews)
                    .load(item.getImg())
                    .into(imNews);
        }
    }
}
