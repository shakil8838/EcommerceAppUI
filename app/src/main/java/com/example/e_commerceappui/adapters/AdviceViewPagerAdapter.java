package com.example.e_commerceappui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdviceViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> tabTitleList;

    public AdviceViewPagerAdapter(FragmentManager fm) {
        super(fm);

        // Initializing List
        fragmentList = new ArrayList<>();
        tabTitleList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragmentsAndTitles(Fragment fragment, String title){

        this.fragmentList.add(fragment);
        this.tabTitleList.add(title);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleList.get(position);
    }
}
