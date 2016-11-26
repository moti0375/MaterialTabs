package com.bartovapps.materialtabs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.bartovapps.materialtabs.adapters.ViewPagerAdapter;
import com.bartovapps.materialtabs.fragments.ImagePageFragment;
import com.bartovapps.materialtabs.fragments.TextPageFragment;
import com.bartovapps.materialtabs.model.BasePage;
import com.bartovapps.materialtabs.model.ImagePage;
import com.bartovapps.materialtabs.model.TextPage;
import com.bartovapps.materialtabs.utils.Utils;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String JSON_CONTENT_FILENAME = "content.json";
    private static final String TAG = MainActivity.class.getSimpleName();

    Toolbar mToolbar;
    ViewPager mPager;

    private int [] tabIcons = {
            R.drawable.ic_favorite,
            R.drawable.ic_call,
            R.drawable.ic_contacts
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notabs_main);
        setViews();

        LoadContentTask loadContentTask = new LoadContentTask();
        loadContentTask.execute(JSON_CONTENT_FILENAME);

    }

    private void setViews() {
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mPager = (ViewPager)findViewById(R.id.pager);
//        setTabsIcons();

    }

//    private void setTabsIcons() {
//        TextView tab1 = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_layout, null);
////        tab1.setText("ONE"); //tab label txt
//        tab1.setCompoundDrawablesWithIntrinsicBounds(tabIcons[0], 0, 0, 0);
//        mTabLayout.getTabAt(0).setIcon(tabIcons[0]);
//
//
//        TextView tab2 = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_layout, null);
////        tab2.setText("TWO"); //tab label txt
//        tab2.setCompoundDrawablesWithIntrinsicBounds(tabIcons[1], 0, 0, 0);
//        mTabLayout.getTabAt(1).setIcon(tabIcons[1]);
//
//        TextView tab3 = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_layout, null);
////        tab3.setText("THREE"); //tab label txt
//        tab3.setCompoundDrawablesWithIntrinsicBounds(tabIcons[2], 0, 0, 0);
////        mTabLayout.getTabAt(2).setCustomView(tab3);
//        mTabLayout.getTabAt(2).setIcon(tabIcons[2]);
//    }

    private void setViewPager(List<BasePage> pages) {
        CirclePageIndicator lineIndicator = (CirclePageIndicator)findViewById(R.id.titles);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        for(BasePage page: pages){
            if(page instanceof TextPage){
                TextPageFragment textPageFragment = new TextPageFragment();
                Bundle b = new Bundle();
                b.putString(Utils.JSON_TITLE, page.getTitle());
                b.putString(Utils.JSON_SUBTITLE, page.getSubtitle());
                b.putString(Utils.JSON_CONTENT, ((TextPage) page).getContent());
                textPageFragment.setArguments(b);
                adapter.addFragment(textPageFragment);
            }

            if(page instanceof ImagePage){
                ImagePageFragment imagePageFragment = new ImagePageFragment();
                Bundle b = new Bundle();
                b.putString(Utils.JSON_TITLE, page.getTitle());
                b.putString(Utils.JSON_SUBTITLE, page.getSubtitle());
                b.putString(Utils.JSON_CONTENT_URL, ((ImagePage) page).getContentUrl());
                imagePageFragment.setArguments(b);
                adapter.addFragment(imagePageFragment);
            }
        }
        mPager.setAdapter(adapter);
        lineIndicator.setViewPager(mPager);
    }


    class LoadContentTask extends AsyncTask<String, Void, List<BasePage>>{

        @Override
        protected List<BasePage> doInBackground(String... strings) {

            String fileName = strings[0];

            List<BasePage> pages = Utils.loadJSONFromAsset(MainActivity.this, fileName);

            return pages;
        }

        @Override
        protected void onPostExecute(List<BasePage> basePages) {
            Log.i(TAG, basePages.size() + " Loaded...");
            setViewPager(basePages);
        }
    }
}
