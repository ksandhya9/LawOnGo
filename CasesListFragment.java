package com.example.myprojectui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CasesListFragment extends Fragment {
    TypesOfCases activity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (TypesOfCases) getActivity();
    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.case_list1,container,false);
        Button button = (Button)rootView.findViewById(R.id.imageButton);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onImageClick(0);
            }
        });
        Button button2 = (Button)rootView.findViewById(R.id.imageButton2);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onImageClick(1);
            }
        });
        Button button3 = (Button)rootView.findViewById(R.id.imageButton3);
        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onImageClick(2);
            }
        });
        Button button4 = (Button)rootView.findViewById(R.id.imageButton4);
        button4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onImageClick(3);
            }
        });

        return rootView;
    }
}
