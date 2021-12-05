package com.example.lifetasck.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioButton;
import com.example.lifetasck.R;
import com.example.lifetasck.databinding.FragmentCreateTaskBinding;
import com.example.lifetasck.model.TaskModel;
import com.example.lifetasck.utils.App;
import com.example.lifetasck.utils.Constants;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;
import java.util.concurrent.ConcurrentNavigableMap;

public class CreateTaskFragment extends BottomSheetDialogFragment implements DatePickerDialog.OnDateSetListener {
    FragmentCreateTaskBinding binding;
    String userTask;
    String deadline;
    String repeatCount;
    private int startYear;
    private int startMonth;
    private int startDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        initClickers();
        fillDialog();
    }

    private void fillDialog() {
        if (getTag().equals(Constants.UPDATE)) {
            TaskModel taskModel = (TaskModel) getArguments().getSerializable(Constants.UPDATE_MODEL);

            deadline = taskModel.getDeadline();
            userTask = taskModel.getTask();
            repeatCount = taskModel.getRepeatCount();

            binding.taskEd.setText(userTask);
            binding.dateTv.setText(deadline);
            binding.repeatTv.setText(repeatCount);
        }
    }

    private void initClickers() {
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getTag().equals(Constants.UPDATE)) {
                    updateTask();
                } else {
                    insertTask();
                }
            }
        });
        binding.dateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        binding.repeatTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRepeatDialog();
            }
        });
    }

    private void updateTask() {
        TaskModel taskModel = (TaskModel) getArguments().getSerializable(Constants.UPDATE_MODEL);
        deadline = binding.dateTv.getText().toString();
        userTask = binding.taskEd.getText().toString();
        repeatCount =  binding.repeatTv.getText().toString();
        TaskModel updateModel = new TaskModel(userTask, deadline,repeatCount);
        updateModel.setId(taskModel.getId());
        App.getInstance().getDatabase().taskDao().update(updateModel);
        dismiss();
    }

    private void showRepeatDialog() {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.repeat_dialog, null);
        Dialog alertDialog = new Dialog(requireContext());
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(view);
        alertDialog.show();
        RadioButton neverBtn = alertDialog.findViewById(R.id.never);
        neverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.repeatTv.setText(neverBtn.getText().toString());
                repeatCount = neverBtn.getText().toString();
                alertDialog.dismiss();
            }
        });
        RadioButton everyDay = alertDialog.findViewById(R.id.every_day);
        everyDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.repeatTv.setText(everyDay.getText().toString());
                repeatCount = everyDay.getText().toString();
                alertDialog.dismiss();
            }
        });
        RadioButton everyWeek = alertDialog.findViewById(R.id.every_week);
        everyWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.repeatTv.setText(everyWeek.getText().toString());
                repeatCount = everyWeek.getText().toString();
                alertDialog.dismiss();
            }
        });
        RadioButton everyMouth = alertDialog.findViewById(R.id.every_month);
        everyMouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.repeatTv.setText(everyMouth.getText().toString());
                repeatCount = everyMouth.getText().toString();
                alertDialog.dismiss();
            }
        });
        RadioButton everyYear = alertDialog.findViewById(R.id.every_year);
        everyYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.repeatTv.setText(everyYear.getText().toString());
                repeatCount = everyYear.getText().toString();
                alertDialog.dismiss();
            }
        });
    }

    private void showDialog() {
        Calendar calendar = Calendar.getInstance();
        startYear = calendar.get(Calendar.YEAR);
        startMonth = calendar.get(Calendar.MONTH);
        startDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(), this::onDateSet, startYear, startMonth, startDay);
        datePickerDialog.show();
    }

    private void insertTask() {
        userTask = binding.taskEd.getText().toString();
        TaskModel taskModel = new TaskModel(userTask, deadline, repeatCount);
        App.getInstance().getDatabase().taskDao().insert(taskModel);
        dismiss();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        deadline = year + "." + month + "." + day;
        binding.dateTv.setText(deadline);
    }

}