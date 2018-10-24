package com.adnuntius.sdk.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import org.json.JSONObject;

public class AdView extends WebView {
    public static String adScript = "";
    public static String jsonConfig = "";
    public AdView(Context context) {
        super(context);
    }
    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.getSettings().setDomStorageEnabled(true);
        this.setWebChromeClient(new WebChromeClient());
        //this.getSettings().setLoadWithOverviewMode(true);
        //this.getSettings().setUseWideViewPort(true);
        WebView.setWebContentsDebuggingEnabled(true);
        Log.d("DEBUG_SDK", this.adScript);

        //HashMap<String, String> config = new HashMap<String, String>();
        //config.put("Color1","Red");
        if(this.jsonConfig.length() > 0) {
            try {
                JSONObject config = new JSONObject(this.jsonConfig);
                ApiService.getAds(config, context, new Callback(this) {
                    @Override
                    public void callback(String s) {
                        try {
                            JSONObject responseJson = new JSONObject(s);
                            JSONArray jArr = responseJson.getJSONArray("adUnits");
                            JSONObject ad = jArr.getJSONObject(0);
                            Log.d("debug app", ad.getString("html"));
                            this.viewContext.loadDataWithBaseURL("https://adnuntius.com/", ad.getString("html"), "text/html", "UTF-8", null);
                        }catch(JSONException e) {

                        }
                    }
                });
            } catch (JSONException e) {
                Log.d("debug app", e.getMessage());
            }
        } else {
            this.loadDataWithBaseURL("https://adnuntius.com/", this.adScript, "text/html", "UTF-8", null);
        }
    }
}
