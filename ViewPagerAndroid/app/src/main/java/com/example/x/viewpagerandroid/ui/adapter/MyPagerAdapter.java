package com.example.x.viewpagerandroid.ui.adapter;

/* Created by X on 12/4/2017.
* */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.x.viewpagerandroid.ui.fragment.ContentFragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 3;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return ContentFragment.newInstance("1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return ContentFragment.newInstance("2");
            case 2: // Fragment # 1 - This will show SecondFragment
                return ContentFragment.newInstance("3");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return "Page " + position;
//    }
}
