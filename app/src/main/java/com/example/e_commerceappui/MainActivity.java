package com.example.e_commerceappui;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
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

        int[] imgs = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};

        viewPager = findViewById(R.id.image_slider);
        recyclerView = findViewById(R.id.product_list);

        layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(MainActivity.this));

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(imgs, MainActivity.this);
        viewPager.setAdapter(viewPagerAdapter);

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
