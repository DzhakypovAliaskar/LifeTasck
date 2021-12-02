package com.example.lifetasck.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lifetasck.OnItemClick;
import com.example.lifetasck.adapter.TaskAdapter;
import com.example.lifetasck.databinding.FragmentHomeBinding;
import com.example.lifetasck.model.TaskModel;
import com.example.lifetasck.utils.App;
import com.example.lifetasck.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    String userTask;
    TaskAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            userTask = (String) getArguments().getSerializable(Constants.USER_TASK);
        }
        binding.addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateTaskFragment createTaskFragment = new CreateTaskFragment();
                createTaskFragment.show(requireActivity().getSupportFragmentManager(), "ttt");
            }
        });
        initRecycler();

    }

    private void initRecycler() {
        App.getInstance().getDatabase().taskDao().getAll().observe(getViewLifecycleOwner(), taskModels -> {
            adapter = new TaskAdapter((ArrayList<TaskModel>) taskModels);
            binding.taskRecycler.setAdapter(adapter);

            adapter.setOnLongClickListener(new OnItemClick() {
                @Override
                public void onLongClick(TaskModel model) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Уведомление!")
                            .setMessage("Подтвердить удаление?")
                            .setNegativeButton("Нет", null)
                            .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    App.getInstance().getDatabase().taskDao().delete(model);

                                }
                            });
                    builder.show();
                }
            });
        });
    }
}
