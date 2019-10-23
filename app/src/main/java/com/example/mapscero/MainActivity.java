package com.example.mapscero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mapscero.Fragments.Map;
import com.example.mapscero.Fragments.Welcome;

public class MainActivity extends AppCompatActivity {
    Fragment currentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentFragment = new Welcome();
        changeFragment(currentFragment);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_welcome:
                currentFragment = new Welcome();
                break;

            case R.id.menu_map:
                currentFragment = new Map();
                break;
        }
        changeFragment(currentFragment);
        return super.onOptionsItemSelected(item);
    }

    private void changeFragment(Fragment fragment){
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();


    }


























}
