package com.modapinhan.fdurmus.modapinhan;

import android.content.pm.ShortcutManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;
    private String webSite = "https://download.yoncabt.com.tr/yonca2.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);

        initWebView();

Display display = getWindowManager().getDefaultDisplay();
int width = display.getWidth();
String data = "<html><head><title>Example</title><meta name=\"viewport\"\"content=\"width="+width+", initial-scale=0.65 \" /></head>";
data = data + "<body><center><img width=\""+width+"\" src=\""+webSite+"\" /></center></body></html>";
myWebView.loadData(data, "text/html", null);



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
