package com.tradecapital.youssoufdasilva.tradecapitalv01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String FRAGMENT_HOME = "tag_frag_home";
    private static final String FRAGMENT_DISCOVERY = "tag_frag_discovery";
    private static final String FRAGMENT_DASHBOARD = "tag_frag_dashboard";
    private static final String FRAGMENT_PROFILE = "tag_frag_profile";

    /**
     * Maintains a list of Fragments for {@link BottomNavigationView}
     */
    private List<HomeFragment> fragments = new ArrayList<>(4);

//    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    switchFragment(0, FRAGMENT_HOME);
                    return true;
                case R.id.navigation_discovery:
//                    mTextMessage.setText(R.string.title_discovery);
                    switchFragment(1, FRAGMENT_DISCOVERY);
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    switchFragment(2, FRAGMENT_DASHBOARD);
                    return true;
                case R.id.navigation_profile:
//                    mTextMessage.setText(R.string.title_profile);
                    switchFragment(3, FRAGMENT_PROFILE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        buildFragmentsList();

        // Set the 0th Fragment to be displayed by default.
        switchFragment(0, FRAGMENT_HOME);
    }


    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragment_holder, fragments.get(pos), tag)
                .commit();
    }

    private void buildFragmentsList() {
        HomeFragment homeFragment = buildFragment("Homez");
        HomeFragment discoveryFragment = buildFragment("Discoveryz");
        HomeFragment dashboardFragment = buildFragment("Dashboardz");
        HomeFragment profileFragment = buildFragment("Profilez");

        fragments.add(homeFragment);
        fragments.add(discoveryFragment);
        fragments.add(dashboardFragment);
        fragments.add(profileFragment);
    }

    /**
     * Creates a {@link HomeFragment} with corresponding Item title.
     *
     * @param title
     * @return
     */
    private HomeFragment buildFragment(String title) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(HomeFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

}
