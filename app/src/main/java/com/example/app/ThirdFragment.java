package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ThirdFragment extends Fragment {
    private TextView textView;
    private Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.text_3);
        button = view.findViewById(R.id.btn_3);

        textView.setText(getArguments().getString("second"));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textView.getText().toString();
                FourFragment fragment = new FourFragment();
                Bundle bundle = new Bundle();
                bundle.putString("third", text);
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
    }
}