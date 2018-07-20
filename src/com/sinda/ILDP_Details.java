package com.sinda;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ILDP_Details extends Activity {

	private TextView tvName1;
	private TextView tvName2;
	private TextView tvName3;
	private TextView tvName4;
	private TextView tvName5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ildp__details);
		
		tvName1 = (TextView) findViewById(R.id.idlp_ename);
		String username = getIntent().getExtras().getString("name");		
		tvName1.setText(username);
		
		tvName2 = (TextView) findViewById(R.id.idlp_eid);
		String userId = getIntent().getExtras().getString("eid");		
		tvName2.setText(userId);
		
		tvName3 = (TextView) findViewById(R.id.idlp_email);
		String userEmail = getIntent().getExtras().getString("email");		
		tvName3.setText(userEmail);
		
		/*tvName4 = (TextView) findViewById(R.id.tvEndDate);
		String userEndDate = getIntent().getExtras().getString("detailEndDateIdlp");		
		tvName4.setText(userEndDate); 
		
		tvName5 = (TextView) findViewById(R.id.tvStartDate);
		String userStartDate = getIntent().getExtras().getString("detailStartDateIdlp");		
		tvName5.setText(userStartDate);*/
		
		Button button = (Button) findViewById(R.id.buttonpublish);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String response;
				try{
					
					response = SimpleHttpClient
							.executeHttpGet("http://69.195.129.153:8090/api/Android/PublishILDP?ildpId=1");		
			System.out.println("================");
			System.out.println(response);
			System.out.println("--------------------");

	/*		ObjectMapper mapper = new ObjectMapper();
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

			System.out.println("=================================");
			System.out.println("Output:  -->>" + list);
			System.out.println("==================================");*/
			
		//	employee=list;
			if(response.equals("true"))
				Toast.makeText(getApplicationContext(),"Published", Toast.LENGTH_SHORT).show();
				}catch(Exception e){
					
					e.printStackTrace();
					System.out.println("cannot publish");
				}
				
			}
		}); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ildp__details, menu);
		return true;
	}

}
