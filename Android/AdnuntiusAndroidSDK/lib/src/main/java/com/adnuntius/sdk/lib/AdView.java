package com.adnuntius.sdk.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class AdView extends WebView {
    public static String adScript = "";
    public AdView(Context context) {
        super(context);


    }
    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.getSettings().setDomStorageEnabled(true);
        this.setWebChromeClient(new WebChromeClient());
        WebView.setWebContentsDebuggingEnabled(true);
        Log.d("DEBUG_SDK", this.adScript);
        this.loadDataWithBaseURL("https://adnuntius.com/", this.adScript, "text/html", "UTF-8", null);
    }
}
