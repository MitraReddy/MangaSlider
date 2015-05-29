package com.mreddy.mangaslider;

/**
 * Created by mreddy on 28-05-2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

public class ScreenSlidePagerActivity extends FragmentActivity {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    private int[] images = {
            R.drawable.naruto_1564773,
            R.drawable.naruto_1564774,
            R.drawable.naruto_1564775

    };
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new MangaImageAdapter(this,images);
        final int totalPages = images.length;
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private Toast pageNumberToast = null;
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                if(pageNumberToast!=null){
                    pageNumberToast.cancel();
                }
                int currentPage = i+1;
                pageNumberToast = Toast.makeText(ScreenSlidePagerActivity.this,"Page "+currentPage+ " of "+totalPages,Toast.LENGTH_SHORT);
                pageNumberToast.show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

}