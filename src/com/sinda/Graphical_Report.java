package com.sinda;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sinda.MainActivity;
import com.sinda.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class Graphical_Report extends Activity {
	WebView web;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graphical__report);
		web=(WebView) findViewById(R.id.webView1);
		web.loadUrl("file:///android_asset/www/bar-chart1.html");

		web.getSettings().setJavaScriptEnabled(true);
		web.addJavascriptInterface(new JavaScriptInterface(this),
				"AndroidNativeCode");
	}

	public class JavaScriptInterface {	Context mContext;

	JavaScriptInterface(Context c) {
		mContext = c;
	}

	@JavascriptInterface
	public void getValueJson() throws JSONException {
		final JSONArray jArray = new JSONArray();

		JSONObject jObject = new JSONObject();

		jObject.put("Month", "May");
		jObject.put("Budget", "240");
		jArray.put(jObject);

		jObject = new JSONObject();
		jObject.put("Month", "June");
		jObject.put("Budget", "400");
		jArray.put(jObject);

		jObject = new JSONObject();
		jObject.put("Month", "Feb");
		jObject.put("Budget", "280");
		jArray.put(jObject);

		runOnUiThread(new Runnable() {
			public void run() {

				web.loadUrl("javascript:setJson(" + jArray + ")");

			}
		});

	}}}





