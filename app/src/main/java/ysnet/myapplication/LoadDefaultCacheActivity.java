package ysnet.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoadDefaultCacheActivity extends AppCompatActivity {
    public static final String CLICK_TIME_WITHOUT_SONIC_CACHE = "clickTimeCache";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_default_cache);
        WebView webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();

        // init webview settings
        webSettings.setAllowContentAccess(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d("LOADTIME", "本地本地缓存耗费时间" + String.valueOf((System.currentTimeMillis() - getIntent().getLongExtra(CLICK_TIME_WITHOUT_SONIC_CACHE, 0))) + "毫秒");
            }
        });
        webView.loadUrl(Config.LOCATION_URL);
    }
}
