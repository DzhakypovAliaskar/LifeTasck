package com.example.lifetasck.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifetasck.R;
import com.example.lifetasck.databinding.FragmentCreateTaskBinding;
import com.example.lifetasck.databinding.FragmentHomeBinding;
import com.example.lifetasck.utils.Constants;

public class CreateTaskFragment extends Fragment {
    FragmentCreateTaskBinding binding;
    String userTask;
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
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userTask = binding.taskEd.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.USER_TASK,userTask);
                Navigation.findNavController(requireView()).navigate(R.id.homeFragment,bundle);
                Log.e("ttt", "user");
            }
        });
    }
}