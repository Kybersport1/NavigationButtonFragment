package com.example.myapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment;
    private int x = 1;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
//                    x++;
//                    if(x==1){
//                        fragment = new FragmentOne();
//                        Change();
//                    }else if(x==2){
//                        fragment = new FragmentTwo();
//                        Change();
//                    }else if(x==3){
//                        fragment = new FragmentThree();
//                        Change();
//                        x=1;
//                    }
                    Change();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fragment = new FragmentOne();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void Change(){
        //fragment = new FragmentTwo();
        if(x==1){
            fragment = new FragmentTwo();
            x++;
        }else if (x==2){
            fragment = new FragmentThree();
            x++;
        }else if(x==3){
            fragment = new FragmentOne();
            x=1;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fr_place , fragment);
        fragmentTransaction.commit();
    }

}
