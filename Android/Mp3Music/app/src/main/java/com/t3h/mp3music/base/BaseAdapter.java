package com.t3h.mp3music.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.t3h.mp3music.BR;
import com.t3h.mp3music.model.BaseModel;

import java.util.ArrayList;

public class BaseAdapter<T extends BaseModel> extends RecyclerView.Adapter<BaseAdapter.BaseHolder> implements Filterable {

    private ArrayList<T> data;
    private ArrayList<T> dataAll;
    private LayoutInflater inflater;
    private int layoutId;
    private BaseItemListener listener;

    public BaseAdapter(Context context, @LayoutRes int layoutId) {
        inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
        this.dataAll = data;
        notifyDataSetChanged();
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setListener(BaseItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BaseHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater,
                layoutId, viewGroup, false);
        return new BaseHolder(binding);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.BaseHolder baseHolder, int i) {
        T item = data.get(i);
        baseHolder.binding.setVariable(BR.item, item);
        baseHolder.binding.setVariable(BR.listener, listener);
        baseHolder.binding.executePendingBindings();
    }

    @Override
    public Filter getFilter() {
        return new FilterAdapter();
    }

    public class BaseHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public BaseHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface BaseItemListener{ }

    public class FilterAdapter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence key) {
            ArrayList<T> result = new ArrayList<>();
            for (T t: dataAll) {
                if (t.checkFilter(key.toString())){
                    result.add(t);
                }
            }
            FilterResults filter = new FilterResults();
            filter.values = result;
            filter.count = result.size();
            return filter;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            data = (ArrayList<T>) results.values;
            notifyDataSetChanged();
        }
    }
}
