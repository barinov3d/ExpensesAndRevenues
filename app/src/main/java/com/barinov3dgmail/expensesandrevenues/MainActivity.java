package com.barinov3dgmail.expensesandrevenues;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.app.FragmentManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.barinov3dgmail.expensesandrevenues.adapter.TabAdapter;
import com.barinov3dgmail.expensesandrevenues.dialog.AddingTaskDialogFragment;


public class MainActivity extends AppCompatActivity
{
    FragmentManager fragmentManager;

    private int progress = 0;
    private int maxProgress = 0;
    private ProgressBar pbHorizontal;
    private TextView tvProgressHorizontal;
    private TextView tvProgressMaxHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbHorizontal = (ProgressBar) findViewById(R.id.pb_horizontal);//
        tvProgressHorizontal = (TextView) findViewById(R.id.tv_progress_horizontal);//
        tvProgressMaxHorizontal = (TextView) findViewById(R.id.tv_max_progress_horizontal);
        maxProgress(maxProgress);
        fragmentManager = getFragmentManager();

        setUI();

}
    public void onClick(View v, int number) {
        if (number>0) progress = progress + number;
        else maxProgress = maxProgress - number;
        postProgress(progress);
        maxProgress(maxProgress);
    }
    public void onClick10(View v) {
        onClick(findViewById(R.id.btn_10), 10);
    }
    public void onClick100(View v) {
        onClick(findViewById(R.id.btn_100), 100);
    }
    public void onClick1000(View v) {
        onClick(findViewById(R.id.btn_1000), 1000);
    }
    public void onClickPlus100(View v) {
        onClick(findViewById(R.id.btn_plus100), -100);
    }
    public void onClickPlus1000(View v) {
        onClick(findViewById(R.id.btn_plus1000), -1000);
    }
    public void onClickPlus5000(View v) {
        onClick(findViewById(R.id.btn_plus5000), -5000);
    }

    private void postProgress(int progress) {
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
    private void maxProgress(int maxProgress) {
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
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                AddingTaskDialogFragment dialog = new AddingTaskDialogFragment();
                dialog.show(fragmentManager, "custom");
            }
        });
    }


}

