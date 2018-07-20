package com.sinda;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;





import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText user, password;
	TextView web;
	Button login;
	String response;
	RelativeLayout panel,log;
	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		init();
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.login);
		Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.anim);
		img.startAnimation(anim1);
		panel.startAnimation(anim);
		log.startAnimation(anim);
		SharedPreferences session = getSharedPreferences("abc", 0);
		if (session.getString("username", "").toString().equals("active")) {
			Intent intent = new Intent(getApplicationContext(), MainMenu.class);
			intent.putExtra("user", user.getText());
			startActivity(intent);
		}
		web.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				web.setText("www.sinda.org.sg");
				web.setLinksClickable(true);
			}
		});
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String key = user.getText().toString();
				String value = password.getText().toString();
			if(key.length()>0 && value.length()>0){	
				try {
					// response = SimpleHttpClient
					// .executeHttpGet("http://69.195.129.153:8090/api/Android/ValidateUser?userName="+key+"&password="+value);

					response = SimpleHttpClient
							.executeHttpGet("http://69.195.129.153:8090/api/Android/ValidateUser?userName="+key+"&password="+value);
					System.out.println("================");
					System.out.println(response);
					System.out.println("--------------------");
					ObjectMapper ob=new ObjectMapper();
					//ob.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
					JSONObject log=new JSONObject(response);
					
					
					if (log.getBoolean("IsValid")) {
						SharedPreferences session = getSharedPreferences("abc", 0);
						Editor ed=session.edit();
						ed.putString("username", "active");
						ed.commit();
						NotificationManager nm= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
						String msg="Welcome "+key;
						Notification  not= new Notification(R.raw.sinda,msg,System.currentTimeMillis());
						Context c=MainActivity.this;
						CharSequence title="Welcome To Sinda";
						CharSequence det="Continue";
						Intent i= new Intent(c, MainActivity.class);
						PendingIntent pend= PendingIntent.getActivity(c, 0, i,0);
						not.setLatestEventInfo(c, title, det, pend);
						nm.notify(0, not);
						Constants.setUserName(key);
						Constants.setEmpId(log.getString("EmployeeId"));
						Constants.setEmpGroup(log.getString("Group"));
						Toast.makeText(getApplicationContext(), "Logged In",
								Toast.LENGTH_SHORT).show();
						Intent main = new Intent(getApplicationContext(),
								MainMenu.class);
						startActivity(main);

					}
					else
						Toast.makeText(getApplicationContext(), "InValid Data",
								Toast.LENGTH_SHORT).show();
						
						
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else
				Toast.makeText(getApplicationContext(), "Please Enter The Login Data", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void init() {
		// TODO Auto-generated method stub
		user = (EditText) findViewById(R.id.usern);
		password = (EditText) findViewById(R.id.password);
		login = (Button) findViewById(R.id.login);
		web = (TextView) findViewById(R.id.textView4);
		panel=(RelativeLayout) findViewById(R.id.relativeLayout1);
		log=(RelativeLayout) findViewById(R.id.relativeLayout2);
		img=(ImageView) findViewById(R.id.imageView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}


	

}
