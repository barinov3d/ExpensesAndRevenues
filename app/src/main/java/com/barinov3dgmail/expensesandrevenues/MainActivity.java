package com.barinov3dgmail.expensesandrevenues;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.app.FragmentManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.barinov3dgmail.expensesandrevenues.adapter.TabAdapter;

public class MainActivity extends AppCompatActivity
        //implements AllQuestionsFragment.OnFragmentInteractionListener
{

    FragmentManager fragmentManager;

    private int progress = 0;//
    private ProgressBar pbHorizontal;//
    private TextView tvProgressHorizontal;//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbHorizontal = (ProgressBar) findViewById(R.id.pb_horizontal);//
        tvProgressHorizontal = (TextView) findViewById(R.id.tv_progress_horizontal);//
                fragmentManager = getFragmentManager();

        setUI();


}
    public void onClick(View v) {//
        progress = progress + 10;
        postProgress(progress);
    }

    private void postProgress(int progress) {//
        String strProgress = String.valueOf(progress) + " %";
        pbHorizontal.setProgress(progress);

        if (progress == 0) {
            pbHorizontal.setSecondaryProgress(0);
        } else {
            pbHorizontal.setSecondaryProgress(progress + 5);
        }
        tvProgressHorizontal.setText(strProgress);

    }



    private void setUI() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolbar);
        }
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.current_cost));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.done_costs));

        final ViewPager viewPager = (ViewPager) findViewById(R.id .pager);
        TabAdapter tabAdapter = new TabAdapter(fragmentManager, 2);

        viewPager.setAdapter(tabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}

