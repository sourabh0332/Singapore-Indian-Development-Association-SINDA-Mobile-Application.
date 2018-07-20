package com.sinda;

import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Reports extends Activity implements OnClickListener {
	Button dr,gr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reports);
		init();
		dr.setOnClickListener(this);
		gr.setOnClickListener(this);
		
	}

	
	
	
	private void init() {
		// TODO Auto-generated method stub
		dr = (Button) findViewById(R.id.dr);
		gr = (Button) findViewById(R.id.gr);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		

	
		int id = v.getId();
		switch (id) {
		case R.id.dr:
			Intent detrep = new Intent(this, Detailed_Report.class);
			startActivity(detrep);
			break;
		case R.id.gr:
			Intent grep = new Intent(this, Graphical_Report.class);
			startActivity(grep);
			break;
		
		}
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
