package com.browserling.glass.browsen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * Created by muhammadharis on 3/25/18.
 */

public class Browsen {

    private static WeakReference<Activity> contextReference;

    private static Bundle bundle;

    private static boolean mIsTopBar;

    private static int mTopBgColorResId;

    private static int mTextColorResId;

    private static String mTitle;

    private static String mUrl;


    /**
     * Constructor
     *
     * @param activity pass activity to constructor
     */
    private Browsen(Activity activity) {

        contextReference = new WeakReference<>(activity);

    }


    /**
     * Create Browsen with activity reference
     *
     * @param activity pass activity reference to create the Browsen
     */
    public static Browsen with(Activity activity) {

        Browsen browsen = new Browsen(activity);
        bundle = new Bundle();

        setDefaults();

        return browsen;
    }


    /**
     * Sets the default values to the Browsen
     */
    private static void setDefaults() {
        mIsTopBar = true;
        mTopBgColorResId = R.color.def_top_bar_color;
        mTextColorResId = R.color.def_text_color;
        mTitle = "";
        mUrl = "";


    }


    /**
     * Shows the Browsen
     */
    public void show() {
        Intent intent = new Intent(contextReference.get(), BrowsenActivity.class);

        if (mTitle.isEmpty()) {
            mTitle = mUrl;
        }

        bundle.putString("url", mUrl);
        bundle.putBoolean("isTopBar", mIsTopBar);
        bundle.putInt("colorResId", mTopBgColorResId);

        bundle.putInt("textColorResId", mTextColorResId);

        bundle.putString("title", mTitle);


        intent.putExtras(bundle);

        contextReference.get().startActivity(intent);

    }


    /**
     * To show the top bar or not
     *
     * @param isShowTopBar boolean to show/hide top bar
     * @return
     */
    public Browsen showTopBar(boolean isShowTopBar) {
        mIsTopBar = isShowTopBar;
        return this;

    }

    /**
     * @param colorResId customize the color of top bar background
     * @return
     */
    public Browsen setTopBarColor(int colorResId) {
        mTopBgColorResId = colorResId;
        return this;

    }

    /**
     * @param colorResId customize the color of cross icon, separator and title/url
     * @return
     */
    public Browsen setTextColor(int colorResId) {
        mTextColorResId = colorResId;
        return this;

    }


    /**
     * @param title set the custom title
     * @return
     */
    public Browsen setTitle(String title) {
        mTitle = title;
        return this;

    }


    /**
     * @param url Set the url to load
     * @return
     */
    public Browsen setUrl(String url) {
        mUrl = url;
        return this;

    }


}
