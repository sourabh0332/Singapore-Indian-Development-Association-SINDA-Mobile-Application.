package com.sinda;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;


import com.sinda.R;

import com.sinda.ApprovalDetails;
import com.sinda.SimpleHttpClient;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TrainingList extends Activity {
	ListView lot;
	List<ApprovalDetails> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lot=(ListView) findViewById(R.id.listdetail);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 

		String response;
		try {
			response = SimpleHttpClient
					.executeHttpGet("http://69.195.129.153:8090/api/Android/GetPendingRequestForApprovalOFEmployee?userName=Raj&status=true");
			System.out.println("================");
			System.out.println(response);
			System.out.println("--------------------");

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(
					DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
					true);
			mapper.configure(
					DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			/*
			 * List<ApprovalDetailsJSON> publisheDataList =
			 * mapper.convertValue(response, mapper.getTypeFactory()
			 * .constructCollectionType(List.class, ApprovalDetailsJSON.class));
			 */

			list = mapper.readValue(
					response,
					TypeFactory.defaultInstance().constructCollectionType(
							List.class, ApprovalDetails.class));

			/*
			 * ApprovalDetailsJSON approvalDetailsJSON = new ObjectMapper()
			 * .readValue(response, ApprovalDetailsJSON.class);
			 */
			System.out.println("=================================");
			System.out.println("Output:  -->>" + list);
			System.out.println("==================================");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lot.setAdapter(new My(getBaseContext(),R.layout.lot,list));
	}
	class My extends ArrayAdapter<ApprovalDetails>{

		public My(Context context, int resource, List<ApprovalDetails> list) {
			super(context, resource, list);
			// TODO Auto-generated constructor stub
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater infl=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			View Row=infl.inflate(R.layout.lot, parent,false);
			TextView tv=(TextView) Row.findViewById(R.id.ename);
			tv.setText(list.get(position).getEmployeeRegistration().getEmployee().getEmpName());
			return Row;
		}
		
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
