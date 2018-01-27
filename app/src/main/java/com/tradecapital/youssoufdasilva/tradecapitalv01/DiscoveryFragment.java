package com.tradecapital.youssoufdasilva.tradecapitalv01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

/**
 * Created by youssoufdasilva on 25/01/2018.
 */

public class DiscoveryFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private static final String TAG = "DashboardFragment";

    public static final String ARG_TITLE = "arg_title";

    private TextView textView;

    public DiscoveryFragment() {
        // Apparently required constructor
    }

    private SliderLayout mDemoSlider;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discovery,
                container, false);

        Log.d(TAG, "onCreate: started.");

        mDemoSlider = (SliderLayout)rootView.findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

//        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
//        file_maps.put("Hannibal",R.drawable.hannibal);
//        file_maps.put("Big Bang Theory",R.drawable.bigbang);
//        file_maps.put("House of Cards",R.drawable.house);
//        file_maps.put("Game of Thrones", R.drawable.game_of_thrones);

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this.getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        ListView l = (ListView) rootView.findViewById(R.id.transformers);
        l.setAdapter(new TransformerAdapter(this.getContext()));
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
                Toast.makeText(view.getContext(), ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        textView = rootView.findViewById(R.id.fragment_discovery_text);

        String title = getArguments().getString(ARG_TITLE, "");
        textView.setText(title + " Tab!");

        return rootView;
    }

//    @Override
//    protected void onStop() {
//        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
//        mDemoSlider.stopAutoCycle();
//        super.onStop();
//    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this.getContext(),slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.main,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_custom_indicator:
//                mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
//                break;
//            case R.id.action_custom_child_animation:
//                mDemoSlider.setCustomAnimation(new ChildAnimationExample());
//                break;
//            case R.id.action_restore_default:
//                mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//                mDemoSlider.setCustomAnimation(new DescriptionAnimation());
//                break;
//            case R.id.action_github:
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/daimajia/AndroidImageSlider"));
//                startActivity(browserIntent);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}


}
