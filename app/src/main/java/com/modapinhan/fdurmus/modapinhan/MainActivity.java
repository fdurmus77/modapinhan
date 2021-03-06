package com.modapinhan.fdurmus.modapinhan;

import android.content.pm.ShortcutManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;
    private String webSite = "http://www.modapinhan.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        myWebView = (WebView) findViewById(R.id.webview);

        initWebView();
        myWebView.loadUrl(webSite);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);




        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {
            ShortcutManager shortcutManager = (ShortcutManager) getSystemService(ShortcutManager.class);
            /* UZUN DOKUNMA MENÜSÜ
            ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "id1")
                    .setShortLabel("Web site")
                    .setLongLabel("Web siteyi aç.")
                    .setIcon(Icon.createWithResource(this.getBaseContext(), R.drawable.add))
                    .setIntent(new Intent(Intent.ACTION_VIEW,
                            Uri.parse(webSite)))
                    .build();
            shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
            */
        }



    }

    private void initWebView() {
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = myWebView.getSettings();
        settings.setSavePassword(true);
        settings.setSaveFormData(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(false);

    }


}
