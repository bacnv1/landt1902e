package com.t3h.buoi14.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.buoi14.databinding.ItemMusicBinding;
import com.t3h.buoi14.model.Song;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder>{

    private ArrayList<Song> data;
    private LayoutInflater inflater;
    private SongItemClickListener listener;
    private SimpleDateFormat format =
            new SimpleDateFormat("mm:ss");

    public SongAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void setListener(SongItemClickListener listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<Song> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMusicBinding binding = ItemMusicBinding.inflate(inflater,
                parent, false);
        return new SongHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, final int position) {
        holder.bindData(data.get(position));
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemSongClicked(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder{
        private ItemMusicBinding binding;
        public SongHolder(@NonNull ItemMusicBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(Song item) {
            binding.tvTitle.setText(item.getTitle());
            binding.tvArtist.setText(item.getArtist());
            String time = format.format(item.getDuration());
            binding.tvDuration.setText(time);
            binding.tvSize.setText(readableFileSize(item.getSize()));

        }

        public String readableFileSize(long size) {
            if(size <= 0) return "0";
            final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
            int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
            return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
        }

    }

    public interface SongItemClickListener {
        void onItemSongClicked(int position);
    }
}
