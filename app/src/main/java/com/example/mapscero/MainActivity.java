package com.example.mapscero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.mapscero.Fragments.Welcome;

public class MainActivity extends AppCompatActivity {
    Fragment currentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentFragment = new Welcome();



    }

    private void changeFragment(Fragment fragment){
    get


    }


























}
