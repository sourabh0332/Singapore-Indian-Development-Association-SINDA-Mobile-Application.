package com.sinda;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;


import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
//import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
//import android.widget.Toast;
import android.widget.Toast;

public class TrainingL  extends Activity {
	SearchView search;
	ListView list;
	MyArrayAdapter dataAdapter = null;

	List<ApprovalDetails> detail = new ArrayList<ApprovalDetails>();
	List<ApprovalDetails> details_sort = new ArrayList<ApprovalDetails>();
	
	List<ApprovalDetails> approvalDetails = new ArrayList<ApprovalDetails>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_training_l);
		search=(SearchView) findViewById(R.id.searchView1);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 

		NetTask netTask = new NetTask();
		netTask.execute();
			
			
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater infl=getMenuInflater();
		infl.inflate(R.menu.lot, menu);
	}
	
	
	class MyArrayAdapter extends ArrayAdapter<ApprovalDetails>{

		public MyArrayAdapter(Context context, int resource,
				List<ApprovalDetails> objects) {
			super(context, resource, objects);
			// TODO Auto-generated constructor stub
			
			empList=(ArrayList<ApprovalDetails>) objects;
		}





		private ArrayList<ApprovalDetails> empList;
		Context context;
		
		



		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			// Get the data item for this position
			
			 ApprovalDetails trainings = empList.get(position);

			 LayoutInflater inf=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
				View row=inf.inflate(R.layout.lot, parent, false);
				
				
				TextView courseview=(TextView) row.findViewById(R.id.ename);
				TextView id=(TextView) row.findViewById(R.id.eid);
				TextView training=(TextView) row.findViewById(R.id.ta);
				courseview.setText(trainings.getEmployeeRegistration().getEmployee().getEmpName());	
				id.setText(trainings.getEmployeeRegistration().getEmployee().getEmpId());
				training.setText(trainings.getEmployeeRegistration().getScheduledTraining().getTraining().getTrainingName());

				
				
				return row;

			}
	}
	class NetTask extends AsyncTask<Void,Void,List<ApprovalDetails>>{

		@Override
		protected List<ApprovalDetails> doInBackground(Void... params) {
			// TODO Auto-generated method stub
			

			String response;
			try {
				response = SimpleHttpClient
						.executeHttpGet("http://69.195.129.153:8090/api/Android/GetPendingRequestForApprovalOFEmployee?userName="+Constants.getUserName()+"&status=true");
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

				List<ApprovalDetails> list = mapper.readValue(
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
				
				approvalDetails = list;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return approvalDetails;
		}

	
		protected void onPostExecute(List<ApprovalDetails> result) {
			// TODO Auto-generated method stub
		
			//Detail adapter = new Detail(getBaseContext(), result);
			//ListView listView = (ListView) findViewById(R.id.lvTrainees);
			//listView.setAdapter(adapter);
			
			System.out.println("===================");
			list=(ListView)findViewById(R.id.listt);
			MyArrayAdapter adapter=new MyArrayAdapter(getBaseContext(),R.layout.lot, result);
			list.setAdapter(adapter);
			System.out.println("post");
			list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					System.out.println("clicked");
					Toast.makeText(getApplicationContext(), "...", Toast.LENGTH_SHORT).show();
					Intent next=new Intent(getApplicationContext(), Details.class);
					next.putExtra("name",approvalDetails.get(arg2).getEmployeeRegistration().getEmployee().getEmpName());
					next.putExtra("id", approvalDetails.get(arg2).getEmployeeRegistration().getEmployee().getEmpId());
					next.putExtra("training",approvalDetails.get(arg2).getEmployeeRegistration().getScheduledTraining().getTraining().getTrainingName());
					next.putExtra("aid",approvalDetails.get(arg2).getApprovalDetailId());
					next.putExtra("email",approvalDetails.get(arg2).getEmployeeRegistration().getEmployee().getEmail());
					next.putExtra("cost",approvalDetails.get(arg2).getEmployeeRegistration().getScheduledTraining().getTrainingFees());
					
					startActivity(next);
				}
			});
			
						search.setOnQueryTextListener(new OnQueryTextListener() {
				
				@Override
				public boolean onQueryTextSubmit(String arg0) {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public boolean onQueryTextChange(String searchText) {
					// TODO Auto-generated method stub
					Log.i("TESTING", "inside queryText");
					
					 if (!searchText.isEmpty()){
				            //displayResults(newText + "*");
					 } 
					 else {   
						 int textlength = searchText.length();
						 details_sort.clear();

						 for (int i = 0; i < detail.size(); i++) {
				    	
							 	String empName = detail.get(i).getEmployeeRegistration().getEmployee().getEmpName();
							 	if (textlength <= empName.length()) {
							 		if (searchText.toString().equalsIgnoreCase((String) empName.subSequence(0,textlength))) {
							 			details_sort.add(detail.get(i));
							 		}
							 	}
							 	Log.i("TEST", "inside for loop");
						 }
						 Log.i("TEST", "calling adapter");
						//list.setAdapter(new CustomListAdapter(this,details_sort, R.layout.list_row_item));

					 }
					 return false;
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
	

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	//	getMenuInflater().inflate(R.menu.list, menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	}

