package com.barinov3dgmail.expensesandrevenues;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager(); //??? or getFragmentManager() ???
    }
    public void runSplash(){
        SplashFragment splashFragment = new SplashFragment();
        fragmentManager.beginTransaction()
        .replace(R.id.container, splashFragment).addToBackStack(null).commit() // в replace передаем идентификатор контейнера и отображаемый фрагмент
        ; //транзакция отображения SplashScreen на экране
    }
}

