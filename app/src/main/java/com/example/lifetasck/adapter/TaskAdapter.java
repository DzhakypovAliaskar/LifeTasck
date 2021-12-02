package com.example.lifetasck.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifetasck.OnItemClick;
import com.example.lifetasck.databinding.ItemTaskBinding;
import com.example.lifetasck.model.TaskModel;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    ArrayList<TaskModel> list;
    ItemTaskBinding binding;
    public OnItemClick onItemClick;

    public void setOnLongClickListener(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public TaskAdapter(ArrayList<TaskModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TaskViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.onFill(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        public TaskViewHolder(@NonNull ItemTaskBinding binding) {
            super(binding.getRoot());
        }

        public void onFill(TaskModel model) {
            binding.taskTv.setText(model.getTask());
            binding.deadlineTv.setText(model.getDeadline());
            binding.repeatTv.setText(model.getDeadline());
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onItemClick.onLongClick(model);
                    return false;
                }
            });
        }
    }
}
