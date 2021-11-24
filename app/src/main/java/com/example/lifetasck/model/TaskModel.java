package com.example.lifetasck.model;

import org.intellij.lang.annotations.PrintFormat;

import java.io.Serializable;

public class TaskModel implements Serializable {
    public long id;
    String task;
    String deadline;
    String repeatCount;

    public TaskModel(String task, String deadline, String repeatCount) {
        this.task = task;
        this.deadline = deadline;
        this.repeatCount = repeatCount;
    }
    public String getTask() {
        return task;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getRepeatCount() {
        return repeatCount;
    }
}
