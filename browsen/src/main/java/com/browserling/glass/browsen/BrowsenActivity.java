package com.browserling.glass.browsen;


import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

public class BrowsenActivity extends AppCompatActivity {


    private TextView mWebUrl;
    private ImageView mClose;
    private View mTopBar;
    private View mSeparator;
    private WebView mWebView;
    private ProgressBar mProgressBar;
    private ShimmerFrameLayout mShimmerLayout;
    private View mParentContainer;


    private String url;
    private String title;
    private boolean isTopBar;
    private int topBarColorResId;
    private int textColorResId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsen);


        initActivity();

        getBundle();
        setView();
        initListeners();
        setBundleValues();


    }


    private void initListeners() {


        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();


            }
        });


    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initActivity() {


        mProgressBar = findViewById(R.id.progressBar);
        mWebUrl = findViewById(R.id.webUrl);

        mClose = findViewById(R.id.imgClose);
        mTopBar = findViewById(R.id.topBar);
        mWebView = findViewById(R.id.webView);
        mParentContainer = findViewById(R.id.parentContainer);
        mSeparator = findViewById(R.id.viewSeperator);


        mShimmerLayout =
                findViewById(R.id.shimmer_view_container);


        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);


    }


    private void setView() {


        mWebUrl.setText(title);

        getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        mWebView.setWebViewClient(new AppWebViewClients(mProgressBar, mShimmerLayout));


    }

    private void setBundleValues() {

        mWebView.loadUrl(url);
        if (!isTopBar) {

            mTopBar.setVisibility(View.GONE);
        }


        mParentContainer.setBackgroundColor(getResources().getColor(topBarColorResId));

        mWebUrl.setTextColor(getResources().getColor(textColorResId));

        mClose.setColorFilter(getResources().getColor(textColorResId));

        mSeparator.setBackgroundColor(getResources().getColor(textColorResId));


        mProgressBar.getIndeterminateDrawable().setColorFilter(getResources()
                .getColor(topBarColorResId), PorterDuff.Mode.SRC_IN);


    }


    private void getBundle() {


        Bundle bundle = getIntent().getExtras();


        assert bundle != null;
        if (bundle.containsKey("url")) {

            this.url = bundle.getString("url");


        }


        if (bundle.containsKey("isTopBar")) {

            this.isTopBar = bundle.getBoolean("isTopBar", true);


        }


        if (bundle.containsKey("colorResId")) {

            this.topBarColorResId = bundle.getInt("colorResId");


        }


        if (bundle.containsKey("textColorResId")) {

            this.textColorResId = bundle.getInt("textColorResId");


        }

        if (bundle.containsKey("title")) {

            this.title = bundle.getString("title");


        }


    }


    public class AppWebViewClients extends WebViewClient {
        private ProgressBar progressBar;
        private ShimmerFrameLayout shimmerFrameLayout;

        public AppWebViewClients(ProgressBar progressBar, ShimmerFrameLayout shimmerFrameLayout) {
            this.progressBar = progressBar;
            this.shimmerFrameLayout = shimmerFrameLayout;
            progressBar.setVisibility(View.VISIBLE);
            shimmerFrameLayout.startShimmerAnimation();

        }


        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            shimmerFrameLayout.stopShimmerAnimation();
        }
    }
}
