package com.adnuntius.sdk.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AdView extends WebView {
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
        this.loadDataWithBaseURL("https://adnuntius.com/", "<html>\n" +
                "        <head />\n" +
                "        <body>\n" +
                "        <div id=\"adn-0000000000000fe6\" style=\"display:none\"></div>\n" +
                "        <script type=\"text/javascript\">(function(d, s, e, t) { e = d.createElement(s); e.type = 'text/java' + s; e.async = 'async'; e.src = 'http' + ('https:' === location.protocol ? 's' : '') + '://cdn.adnuntius.com/adn.js'; t = d.getElementsByTagName(s)[0]; t.parentNode.insertBefore(e, t); })(document, 'script');window.adn = window.adn || {}; adn.calls = adn.calls || []; adn.calls.push(function() { adn.request({ adUnits: [ {auId: '0000000000000fe6', auW: 320, auH: 480 } ]}); });</script>\n" +
                "        </body>\n" +
                "        </html>", "text/html", "UTF-8", null);
    }
}
