package com.sinda;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TrainingManagement extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_training_management);
		TabHost tb = getTabHost();
		Intent l = new Intent(this, TrainingL.class);
		Intent idlp = new Intent(this,IdlpList.class);
		TabSpec ts = tb.newTabSpec("lot1").setIndicator("List of Training")
				.setContent(l);
		TabSpec ts1 = tb.newTabSpec("idlp").setIndicator("IDLP's")
				.setContent(idlp);
		tb.addTab(ts);
		tb.addTab(ts1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		// TODO Auto-generated method stub
		// System.out.println("close");
		if (item.getItemId() == R.id.logout)

		{
			SharedPreferences session = getSharedPreferences("abc", 0);
			SharedPreferences.Editor edit = session.edit();
			edit.remove("username");

			edit.commit();
			Intent i = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(i);

		}
		return super.onOptionsItemSelected(item);
	}

}
