package com.example.lifetasck;

import com.example.lifetasck.model.TaskModel;

public interface OnItemClick {

    void onLongClick(TaskModel model);
    void onClick(TaskModel model);
}
