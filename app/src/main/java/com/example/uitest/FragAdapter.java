package com.example.uitest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/7/19 0019.
 */

public class FragAdapter extends FragmentPagerAdapter {


    private List<Fragment> mFragments;

    public FragAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
        super(fragmentManager);
        // TODO Auto-generated constructor stub
        mFragments=fragments;
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return mFragments.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Integer.MAX_VALUE;
    }

}