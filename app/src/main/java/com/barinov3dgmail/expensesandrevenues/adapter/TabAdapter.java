package com.barinov3dgmail.expensesandrevenues.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.barinov3dgmail.expensesandrevenues.fragment.CurrentCostFragment;
import com.barinov3dgmail.expensesandrevenues.fragment.DoneCostFragment;

/**
 * Created by User on 26.05.2017.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public TabAdapter(FragmentManager fragmentManager, int numberOfTubs) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
       switch (position){
            case 0:
                return new CurrentCostFragment();
            case 1:
                return new DoneCostFragment();
            default:
            return null;
        }
    }

    @Override
    public int getCount() {

        return numberOfTabs;
    }
}
