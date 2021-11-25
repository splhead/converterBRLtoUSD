package com.splhead.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.splhead.conversor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.bConvert.setOnClickListener(view1 -> binding.tvDollar.setText(
                BRLToUSD(binding.etReal.getText().toString())
        ));
    }

    private String BRLToUSD(String BRL) {
        if (BRL.equals("")) {
            return BRL;
        }

        double dollars = Double.parseDouble(BRL) * 5.35;
        return String.valueOf(dollars);
    }
}