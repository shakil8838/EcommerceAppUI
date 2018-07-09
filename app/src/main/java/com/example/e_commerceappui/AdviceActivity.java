package com.example.e_commerceappui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.e_commerceappui.adapters.AdviceViewPagerAdapter;
import com.example.e_commerceappui.fragments.AdviceAll;
import com.example.e_commerceappui.fragments.AdviceKids;
import com.example.e_commerceappui.fragments.AdviceMen;
import com.example.e_commerceappui.fragments.AdviceWomen;

public class AdviceActivity extends AppCompatActivity {

    private TabLayout adviceTabLayout;
    private ViewPager adviceViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

        // Initializing widgets
        adviceTabLayout = findViewById(R.id.advice_tab_layout);
        adviceViewPager = findViewById(R.id.advice_view_pager);

        // Setting up TabLayout with ViewPager
        adviceTabLayout.setupWithViewPager(adviceViewPager);

        // Setting up ViewPager
        setUpViewPager(adviceViewPager);
    }

    private void setUpViewPager(ViewPager viewPager){

        AdviceViewPagerAdapter adapter = new AdviceViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragmentsAndTitles(new AdviceAll(), "ALL");
        adapter.addFragmentsAndTitles(new AdviceMen(), "MEN");
        adapter.addFragmentsAndTitles(new AdviceWomen(), "WOMEN");
        adapter.addFragmentsAndTitles(new AdviceKids(), "KIDS");

        viewPager.setAdapter(adapter);

    }
}
