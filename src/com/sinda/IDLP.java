package com.sinda;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;

public class IDLP extends Activity {
	ListView idlp;
	String[] val;
	SearchView search;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_idlp);
		idlp = (ListView) findViewById(R.id.listdetail);
		val = new String[] { "Communicaton", "Java", "C", "Android" };
		search = (SearchView) findViewById(R.id.searchView1);
		search.setOnQueryTextListener(new OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), arg0,
						Toast.LENGTH_SHORT).show();
				for (int i = 0; i < val.length; i++)
					if (arg0.equals(val[i])) {
						Toast.makeText(getApplicationContext(), "Found",
								Toast.LENGTH_SHORT).show();
						idlp.setItemChecked(i, true);
						break;
					}
				return false;
			}

			@Override
			public boolean onQueryTextChange(String arg0) {
				// TODO Auto-generated method stub

				return false;
			}
		});
		My adapt = new My(this, android.R.layout.simple_list_item_1,
				R.id.subject, val);
		idlp.setAdapter(adapt);
	}

	class My extends ArrayAdapter<String> {

		public My(Context context, int resource, int textViewResourceId,
				String[] val) {
			super(context, resource, textViewResourceId, val);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater infl = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = infl.inflate(R.layout.idlp, parent, false);
			TextView subject = (TextView) row.findViewById(R.id.subject);
			subject.setText(val[position]);
			Button pub = (Button) row.findViewById(R.id.publish_button);
			pub.setText("Publish");

			return row;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.idl, menu);
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
