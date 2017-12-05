package com.application.ahmad.berobat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView view; //membuat variabel view agar bisa akses method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String type;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                type = null;

            } else {
                type = extras.getString("type");

            }
        } else {
            type = (String) savedInstanceState.getSerializable("type");

        }

        setContentView(R.layout.activity_main);

        view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setUseWideViewPort(true);
        view.getSettings().setLoadsImagesAutomatically(true);
        view.getSettings().setDatabaseEnabled(true);
        view.getSettings().setDomStorageEnabled(true);
        view.getSettings().setSupportZoom(false);
        view.getSettings().setSupportMultipleWindows(false);
        view.getSettings().setAppCacheEnabled(true);
        view.getSettings().setAppCachePath("");
        view.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        view.getSettings().setUserAgentString("Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en)AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3");
        view.setWebChromeClient(new WebChromeClient());
//        view.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(final WebView view, String url) {
//                super.onPageFinished(view, url);
//                Log.d("aaaaaaaaaaaaaaaaaaaa", type);
//                  view.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            view.loadUrl("javascript:(function(){document.getElementById('iframe-login').click();})()");
//                         }
//                    });
//
//                    if (type.equals("login")) {
//
//                    } else if (type.equals("register")) {
//                    view.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            view.loadUrl("javascript:(function(){document.getElementById('iframe-register').click();})()");
//                        }
//                    });
//
//                } else {
//                    view.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            view.loadUrl("http://berobat.co.id/");
//                        }
//                    });
//
//                }
//            }
//        });

        view.loadUrl("http://berobat.co.id/");


    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()) {
            view.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

}
