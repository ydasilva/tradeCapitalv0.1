package com.tradecapital.youssoufdasilva.tradecapitalv01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";

    private static final String FRAGMENT_HOME = "tag_frag_home";
    private static final String FRAGMENT_DISCOVERY = "tag_frag_discovery";
    private static final String FRAGMENT_DASHBOARD = "tag_frag_dashboard";
    private static final String FRAGMENT_PROFILE = "tag_frag_profile";

    /**
     * Maintains a list of Fragments for {@link BottomNavigationView}
     */
    private List<Fragment> fragments = new ArrayList<>(4);

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(0, FRAGMENT_HOME);
                    return true;
                case R.id.navigation_discovery:
                    switchFragment(1, FRAGMENT_DISCOVERY);
                    return true;
                case R.id.navigation_dashboard:
                    switchFragment(2, FRAGMENT_DASHBOARD);
                    return true;
                case R.id.navigation_profile:
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
        Log.d(TAG, "onCreate: started.");

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
        CardContentFragment homeFragment = buildCardContentFragment("Homez");
        DiscoveryFragment discoveryFragment = buildDiscoveryFragmentFragment("Discoveryz");
        DashboardFragment dashboardFragment = buildDashboardFragment("Dashboardz");
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

    /**
     * Creates a {@link DashboardFragment} with corresponding Item title.
     *
     * @param title
     * @return
     */
    private DashboardFragment buildDashboardFragment(String title) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DashboardFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * Creates a {@link CardContentFragment} with corresponding Item title.
     *
     * @param title
     * @return
     */
    private CardContentFragment buildCardContentFragment(String title) {
        CardContentFragment fragment = new CardContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CardContentFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }
    /**
     * Creates a {@link CardContentFragment} with corresponding Item title.
     *
     * @param title
     * @return
     */
    private DiscoveryFragment buildDiscoveryFragmentFragment(String title) {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DiscoveryFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

}
