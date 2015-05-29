package com.mreddy.mangaslider;

/**
 * Created by mreddy on 29-05-2015.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MangaImageAdapter extends PagerAdapter {

    private Activity _activity;
    private int[] _imagePaths;
    private LayoutInflater inflater;

    // constructor
    public MangaImageAdapter(Activity activity,
                                  int[] imagePaths) {
        this._activity = activity;
        this._imagePaths = imagePaths;
    }

    @Override
    public int getCount() {
        return this._imagePaths.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((FrameLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final ImageView imgDisplay;
        final ProgressBar progressBar;

        inflater = (LayoutInflater) _activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.fragment_screen_slide_page, container,
                false);
          imgDisplay = (ImageView) viewLayout.findViewById(R.id.narutoImage);
          progressBar = (ProgressBar) viewLayout.findViewById(R.id.progressBar);

          Picasso.with(_activity).load(_imagePaths[position]).fit().into(imgDisplay, new Callback() {

            @Override
            public void onSuccess() {
                imgDisplay.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {

            }
        });

                ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((FrameLayout) object);

    }
}