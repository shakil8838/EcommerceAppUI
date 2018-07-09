package com.example.e_commerceappui;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.e_commerceappui.adapters.RecyclerAdapter;
import com.example.e_commerceappui.adapters.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] imgs = {
                R.drawable.slide1,
                R.drawable.slide2,
                R.drawable.slide3
        };

        int[] productImages = {
                R.drawable.product_image1,
                R.drawable.product_image2,
                R.drawable.product_image3,
                R.drawable.product_image4
        };

        // Initializing widgets
        viewPager = findViewById(R.id.image_slider);
        recyclerView = findViewById(R.id.product_list);
        layoutManager = new GridLayoutManager(MainActivity.this, 2);

        // Setting up RecyclerView
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(MainActivity.this, productImages));

        // Setting ViewPager Adapter
        viewPager.setAdapter(new ViewPagerAdapter(imgs, MainActivity.this));

        // https://stackoverflow.com/questions/38472916/how-to-swipe-viewpager-images-automatically-using-timetask#
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == viewPager.getAdapter().getCount()) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
                           @Override
                           public void run() {
                               handler.post(Update);
                           }
                       },
                2000,
                4000
        );

        Button mainACtivityViewAll = findViewById(R.id.main_activity_view_all);
        mainACtivityViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdviceActivity.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflating ActionBar Menu
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
