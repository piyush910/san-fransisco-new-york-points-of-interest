package com.chandra.piyush.project3c.android.project3cfin;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class Activity3 extends AppCompatActivity implements PointsOfInterestFragment.ListSelectionListener {

    public static String[] pointsOfInterestArray;
    public static String[] webPageArray;

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT; // defined programatically
    int mShownIndex = -1;
    static String OLD_ITEM = "old_item";

    private final WebPageFragment webPageFragment = new WebPageFragment();
    private FragmentManager fragmentManager;
    private FrameLayout pointsFrameLayout, webPageFrameLayout; // layout containers

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        pointsOfInterestArray = getResources().getStringArray(R.array.pt_of_interest);
        webPageArray = getResources().getStringArray(R.array.websites);

        pointsFrameLayout = findViewById(R.id.points_frame);
        webPageFrameLayout = findViewById(R.id.webpage_frame);

        fragmentManager = getSupportFragmentManager(); // fragment manager to perform operations
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.points_frame, new PointsOfInterestFragment());
        fragmentTransaction.commit();
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                setLayout();
            }
        });

    }

    /**
     * To set the layout based on the configuration of phone
     */
    private void setLayout() {
        // Determine whether the QuoteFragment has been added
        int orientation = getResources().getConfiguration().orientation;

        if (!webPageFragment.isAdded()) {

            // Make the TitleFragment occupy the entire layout
            pointsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    MATCH_PARENT, MATCH_PARENT));
            webPageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT));
        } else {
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                // Make the TitleLayout take 1/3 of the layout's width
                pointsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 1f));

                // Make the QuoteLayout take 2/3's of the layout's width
                webPageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 2f));
            } else {
                pointsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 0f));

                // Make the QuoteLayout take 2/3's of the layout's width
                webPageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT));
            }
        }
    }


    @Override
    public void onListSelection(int index) {
        // If the QuoteFragment has not been added, add it now
        if (!webPageFragment.isAdded()) {

            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = fragmentManager
                    .beginTransaction();

            // Add the QuoteFragment to the layout
            fragmentTransaction.add(R.id.webpage_frame,
                    webPageFragment);

            // Add this FragmentTransaction to the backstack
            fragmentTransaction.addToBackStack(null);

            // Commit the FragmentTransaction
            fragmentTransaction.commit();

            // Force Android to execute the committed FragmentTransaction
            fragmentManager.executePendingTransactions();
        }

        if (webPageFragment.getShownIndex() != index) {

            // Tell the QuoteFragment to show the quote string at position index
            webPageFragment.showWebPageAtIndex(index);

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if (mShownIndex >= 0) {
            outState.putInt(OLD_ITEM, mShownIndex);
        }
    }
}
