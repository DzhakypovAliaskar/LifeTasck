package com.example.lifetasck.board;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifetasck.R;
import com.example.lifetasck.databinding.FragmentOnBoardBinding;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class OnBoardFragment extends Fragment {
FragmentOnBoardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewPager();
    }

    private void setupViewPager() {
        binding.viewpager.setAdapter(new BoardAdapter(requireActivity().getSupportFragmentManager()));
        binding.dotsIndicator.setViewPager(binding.viewpager);
    }
}