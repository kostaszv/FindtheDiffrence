package com.example.findthediffrence;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioTrack;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.findthediffrence.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //music button

        ColorStateList original_color_music = binding.switch2.getTrackTintList();
        binding.switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.switch2.getTrackTintList() == ColorStateList.valueOf(Color.argb(255, 0, 255, 0))){
                    binding.switch2.setTrackTintList(original_color_music);
                }else{
                    binding.switch2.setTrackTintList(ColorStateList.valueOf(Color.argb(255, 0, 255, 0)));
                }
            }
        });


        // Sfx button
        ColorStateList original_color_sfx = binding.switch1.getTrackTintList();
        binding.switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.switch1.getTrackTintList() == ColorStateList.valueOf(Color.argb(255, 0, 255, 0))){
                    binding.switch1.setTrackTintList(original_color_music);
                }else{
                    binding.switch1.setTrackTintList(ColorStateList.valueOf(Color.argb(255, 0, 255, 0)));
                }
            }

        });
        //Go back button
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}