package com.sinda;

import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Detailed_Report extends Activity {
	ListView dlist;
	ArrayList<Report> listd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detailed__report);
		dlist=(ListView) findViewById(R.id.listdetail);
				String response;
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		try {
			// response = SimpleHttpClient
			// .executeHttpGet("http://69.195.129.153:8090/api/Android/ValidateUser?userName="+key+"&password="+value);

			response = SimpleHttpClient
					.executeHttpGet("http://69.195.129.153:8090/api/Android/GetReportDataForPeriod?startDate=08-01-2014&endDate=08-31-2014");
			System.out.println("================");
			System.out.println(response);
			System.out.println("--------------------");
			//ReportJSON rj=new ObjectMapper().readValue(response,ReportJSON.class);
			ObjectMapper ob=new ObjectMapper();
			listd = ob.readValue(response, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class,Report.class));
			
			System.out.println(listd.get(0));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyArrayAdapter adapt=new MyArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,listd);
		dlist.setAdapter(adapt);	
		//Toast.makeText(getApplicationContext(), "h",Toast.LENGTH_SHORT).show();
	}
	class MyArrayAdapter extends ArrayAdapter<Report>{

		public MyArrayAdapter(Context context, int resource,
				ArrayList<Report> listd) {
			super(context, resource, listd);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inf=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			View row=inf.inflate(R.layout.cdetail,parent,false);
			
			TextView tname=(TextView) row.findViewById(R.id.tname);
			TextView tprovider=(TextView) row.findViewById(R.id.tprovider);
			TextView tday=(TextView) row.findViewById(R.id.tday);
			tname.setText(listd.get(position).getTrainingName());
			tprovider.setText(listd.get(position).getTrainingProvider());
			tday.setText(listd.get(position).getTotalDays()+" ");
			
			
			
			
			return row;
		
		
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detailed__report, menu);
		return true;
	}

}
