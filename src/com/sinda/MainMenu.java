package com.sinda;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends Activity implements OnClickListener {
	TextView un;
	Button tm, r;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		init();
		tm.setOnClickListener(this);
		r.setOnClickListener(this);
		un.setText(Constants.getUserName());
		/*if (Constants.getEmpGroup().equals("Manager") || Constants.getEmpGroup().equals("Employee")) {
			// r.setVisibility(1);
			r.setVisibility(View.INVISIBLE);

		} else
			r.setVisibility(View.VISIBLE);
	*/ }

	private void init() {
		// TODO Auto-generated method stub
		un = (TextView) findViewById(R.id.username);
		tm = (Button) findViewById(R.id.tm);
		r = (Button) findViewById(R.id.report);
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
		if (id == R.id.tm) {
			Intent tm = new Intent(this, TrainingManagement.class);
			startActivity(tm);
		} else {
			Intent report = new Intent(this, Reports.class);
			startActivity(report);
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		System.out.println("close");
		AlertDialog.Builder build= new AlertDialog.Builder(MainMenu.this);
		build.setMessage("Do You Want To Log Out !!!");
		build.setCancelable(false);
		build.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
			 MainMenu.this.finish();	
			}
		});
		build.setNegativeButton("Nope",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				arg0.cancel();
			}
		});
		AlertDialog alert=build.create();
		alert.show();
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
