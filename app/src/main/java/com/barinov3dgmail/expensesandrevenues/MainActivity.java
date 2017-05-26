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
    private int maxProgress = 0;
    private ProgressBar pbHorizontal;//
    private TextView tvProgressHorizontal;//
    private TextView tvProgressMaxHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbHorizontal = (ProgressBar) findViewById(R.id.pb_horizontal);//
        tvProgressHorizontal = (TextView) findViewById(R.id.tv_progress_horizontal);//
        tvProgressMaxHorizontal = (TextView) findViewById(R.id.tv_max_progress_horizontal);
        fragmentManager = getFragmentManager();

        setUI();

//onClickPlus100
}
    public void onClick10(View v) {//
        progress = progress + 10;
        postProgress(progress);
        maxProgress(maxProgress);
    }
    public void onClick100(View v) {//
        progress = progress + 100;
        postProgress(progress);
        maxProgress(maxProgress);
    }
    public void onClick1000(View v) {//
        progress = progress + 1000;
        postProgress(progress);
        maxProgress(maxProgress);
    }
    public void onClickPlus100(View v) {//
        maxProgress = maxProgress + 100;
        postProgress(progress);
        maxProgress(maxProgress);
    }
    public void onClickPlus1000(View v) {//
        maxProgress = maxProgress + 1000;
        postProgress(progress);
        maxProgress(maxProgress);
    }
    public void onClickPlus5000(View v) {//
        maxProgress = maxProgress + 5000;
        postProgress(progress);
        maxProgress(maxProgress);
    }

    private void postProgress(int progress) {//
        String strProgress = String.valueOf(progress) + " руб.";
        String strNegProgress = String.valueOf(progress-maxProgress) + " руб.";
        pbHorizontal.setProgress(progress);

        if (progress == 0) {
            pbHorizontal.setSecondaryProgress(0);
        } else {
            pbHorizontal.setSecondaryProgress(progress + 5);
        }

        if (progress<=maxProgress)
        tvProgressMaxHorizontal.setText(strProgress);
        else tvProgressMaxHorizontal.setText("уходим в минус "+"-"+strNegProgress);
    }
    private void maxProgress(int maxProgress) {//
        String strProgress = String.valueOf(maxProgress) + " руб.";
        tvProgressHorizontal.setText(strProgress);
        pbHorizontal.setMax(maxProgress);
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

