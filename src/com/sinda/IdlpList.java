package com.sinda;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

//import com.example.idlplist.Employee;
//import com.example.idlplist.SimpleHttpClient;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class IdlpList extends Activity {
	
	ListView idlpList;
	MyAdapter adapter=null;

	List<Employee> empDetails=new ArrayList<Employee>();
	//EmpDetailsJASON empDetailsJASON;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_idlp);
	/*	String[] courses=new String[]{"Communication","Java",".Net"};
		
		
		MyAdapter adapter=new MyAdapter(this, android.R.layout.simple_list_item_1, R.id.course, courses);
		
		idlpList.setAdapter(adapter);
		*/
		idlpList=(ListView)findViewById(R.id.listidlp);
		
		NetTask netTask=new NetTask();
		netTask.execute();		
	}

	class MyAdapter extends ArrayAdapter<Employee>{

		private ArrayList<Employee> empList;
		Context context;
		public MyAdapter(Context context, int resource,
				List<Employee> objects) {
			super(context, resource, objects);
			empList=(ArrayList<Employee>) objects;
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			final Employee employee=empList.get(position);
			LayoutInflater inf=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			View row=inf.inflate(R.layout.idlp, parent, false);
			
			
			TextView courseview=(TextView) row.findViewById(R.id.subject);
			courseview.setText(employee.getEmpName());
			Button details=(Button) row.findViewById(R.id.publish_button);
			details.setText("Details");
			details.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					System.out.println("Inside");
					Intent idlp_detail=new Intent(getApplicationContext(), ILDP_Details.class);
					idlp_detail.putExtra("name", employee.getEmpName());
					idlp_detail.putExtra("eid",employee.getEmpId());
					idlp_detail.putExtra("email",employee.getEmail());
					
				startActivity(idlp_detail);
				}
			});
			
			 return row;
		}

		
	}


	class NetTask extends AsyncTask<Void,Void,List<Employee>>{

		@Override
		protected List<Employee> doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String response;
			try{
				/*response=SimpleHttpClient.executeHttpGet("http://demo9448389.mockable.io");
				System.out.println("===================");
				System.out.println(response);
				System.out.println("===================");
				EmpDetailsJASON empDetailsJASON=new ObjectMapper().readValue(response,EmpDetailsJASON.class);
				
				System.out.println("status"+empDetailsJASON.status);
				System.out.println("===================");
				empDetails=empDetailsJASON.getDetailList();
				System.out.println(empDetails);
				System.out.println("===================");*/
				
				response = SimpleHttpClient
						.executeHttpGet("http://69.195.129.153:8090/api/Android/GetAllManagerReportees?userName="+Constants.getUserName()+"");
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
				List<Employee> list = mapper.readValue(
								response,
								TypeFactory.defaultInstance().constructCollectionType(
			
										List.class, Employee.class));
                 empDetails = list;
                 System.out.println("--------------------");
                 System.out.println("employee"+empDetails.get(0).getEmpName());
                 
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return empDetails;
		}

		@Override
		protected void onPostExecute(final List<Employee> result) {
			// TODO Auto-generated method stub
			System.out.println("===================");
			idlpList=(ListView)findViewById(R.id.listidlp);
			MyAdapter adapter=new MyAdapter(getBaseContext(),R.layout.idlp, result);
			idlpList.setAdapter(adapter);
			idlpList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					System.out.println("Inside click");
					Intent idlp_detail=new Intent(getApplicationContext(), ILDP_Details.class);
					idlp_detail.putExtra("name", result.get(arg2).getEmpName());
					idlp_detail.putExtra("eid",result.get(arg2).getEmpId());
					idlp_detail.putExtra("email",result.get(arg2).getEmail());
				startActivity(idlp_detail);
				}
			});
		
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}


}


