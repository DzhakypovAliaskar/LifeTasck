package com.example.lifetasck.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifetasck.R;
import com.example.lifetasck.databinding.FragmentAuthBinding;

public class AuthFragment extends Fragment {

    FragmentAuthBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentAuthBinding.inflate(getLayoutInflater());
       return binding.getRoot();
    }
}