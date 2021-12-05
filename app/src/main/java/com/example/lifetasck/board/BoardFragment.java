package com.example.lifetasck.board;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lifetasck.databinding.FragmentBoardBinding;
import com.example.lifetasck.utils.Constants;

public class BoardFragment extends Fragment {
    FragmentBoardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPositionFromAdapter();
    }

    private void getPositionFromAdapter() {
        if (getArguments() != null) {
            int position = getArguments().getInt(Constants.FRAGMENT_POSITION);
            switch (position) {
                case 0:
                    binding.description.setText("Экономьте время и будьте продуктивны, создавая ежедневные задачи");
                    binding.boardImage.setAnimation("user.json");
                    break;
                case 1:
                    binding.description.setText("Получить это удовлетворение, отмечая их как выполненные");
                    binding.boardImage.setAnimation("task.json");
                    break;
                case 2:
                    binding.description.setText("Быстрее достигайте своих целей с помощью Lifetrack");
                    binding.boardImage.setAnimation("woman.json");
                    break;
            }
        }
    }
}