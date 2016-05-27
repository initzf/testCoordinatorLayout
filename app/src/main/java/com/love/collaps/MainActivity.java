package com.love.collaps;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.main_vp_container)
    ViewPager viewPager;

    @Bind(R.id.toolbar_tl_tab)
    TabLayout tabLayout;

    @Bind(R.id.toolbar)
    Toolbar toolbar;


    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;

    private List<Fragment> fragments;
    private List<String> titles;

    private int[] imgs = {R.mipmap.meizi2, R.mipmap.meizi7, R.mipmap.meizi3, R.mipmap.meizi4, R.mipmap.meizi9, R.mipmap.meizi9, R.mipmap.meizi9, R.mipmap.meizi9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragments = new ArrayList<>();
        titles = new ArrayList<>();


        List<Users> list1 = new ArrayList<>();
        List<Users> list2 = new ArrayList<>();

        for (int i = 0; i < imgs.length; i++) {
            /*final char c = (char) (97 + i);
            list1.add(String.valueOf(c));*/

            Users users = new Users(imgs[i], "meizi" + i);
            list1.add(users);
            list2.add(users);
        }

        for (int i = imgs.length; i > 0; i--) {
            /*list2.add(String.valueOf(i));*/
        }

        fragments.add(new fragment_a("one", list1));
        fragments.add(new fragment_a("two", list2));

        titles.add("one");
        titles.add("two");

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), fragments, titles));
        tabLayout.setupWithViewPager(viewPager);

        setTitle("Girls' Generation");
    }


}
