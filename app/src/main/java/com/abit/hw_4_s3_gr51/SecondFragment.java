package com.abit.hw_4_s3_gr51;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abit.hw_4_s3_gr51.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments()!= null){
            Film filmList = (Film) getArguments().getSerializable("list");
            binding.tvName.setText(filmList.getName());
            binding.tvOpisanie.setText(filmList.getOpisan());
            binding.tvRating.setText(filmList.getRating());
            binding.ivImg.setImageResource(filmList.getImg());
        }
    }
}