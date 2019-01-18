package com.chandra.piyush.project3c.android.project3cfin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class WebPageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String WEB__FRAGMENT_TAG = "WebPageFragment";
    private int mCurrIdx = -1;
    private WebView webSiteView = null;
    private int mWebPageArrayLen;


    int getShownIndex() {
        return mCurrIdx;
    }

    void showWebPageAtIndex(int newIndex) {
        if (newIndex < 0 || newIndex >= mWebPageArrayLen) {
            return;
        }
        mCurrIdx = newIndex;
        webSiteView.loadUrl(Activity3.webPageArray[mCurrIdx]);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_page, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webSiteView = (WebView) getActivity().findViewById(R.id.webPageView);
        WebSettings settings = webSiteView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebPageArrayLen = Activity3.webPageArray.length;
        if (savedInstanceState != null) {
            mCurrIdx = savedInstanceState.getInt("currentSelection", 0);
        }
        showWebPageAtIndex(mCurrIdx);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentSelection", mCurrIdx);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
