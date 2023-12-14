package com.example.findthediffrence;



import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.findthediffrence.databinding.FragmentSoloPlayBinding;


public class Solo_play extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Solo_play() {

    }

    private FragmentSoloPlayBinding binding;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Drawable dr = binding.imageView.getBackground();
        binding.imageView.setImageBitmap(ImageHelper.getRoundedCornerBitmap(ImageHelper.drawableToBitmap(dr),10));

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentSoloPlayBinding.inflate(inflater, container, false);
        return inflater.inflate(R.layout.fragment_solo_play, container, false);
    }


}