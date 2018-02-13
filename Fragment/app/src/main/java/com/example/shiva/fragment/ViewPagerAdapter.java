package com.example.shiva.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;


class ViewPagerAdapter extends FragmentStatePagerAdapter {
    FragmentManager fm;
    int tabount;

    public ViewPagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        tabount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FirstFragment();
                break;
            case 1:
                fragment = new SecondFragment();
                break;
            case 2:
                fragment = new ThirdFragment();
                break;
            case 3:
                fragment = new FourthFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabount;
    }
}
