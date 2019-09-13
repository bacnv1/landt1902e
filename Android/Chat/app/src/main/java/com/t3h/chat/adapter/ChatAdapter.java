package com.t3h.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.chat.databinding.ItemChatBinding;
import com.t3h.chat.model.Chat;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {
    private ArrayList<Chat> data = new ArrayList<>();
    private LayoutInflater inflater;

    public ChatAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<Chat> data) {
        for (int i = 0; i < data.size(); i++) {
            boolean existed = false;
            for (int j = 0; j < this.data.size(); j++) {
                if (data.get(i).getId() == this.data.get(j).getId()) {
                    existed = true;
                    break;
                }
            }
            if (!existed) {
                this.data.add(data.get(i));
                notifyItemRangeChanged(
                        this.data.size() -1 , 1
                );
            }
        }
    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChatBinding binding = ItemChatBinding.inflate(inflater,
                parent, false);
        return new ChatHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {
        holder.binding.setItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ChatHolder extends RecyclerView.ViewHolder {
        private ItemChatBinding binding;
        public ChatHolder(@NonNull ItemChatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
