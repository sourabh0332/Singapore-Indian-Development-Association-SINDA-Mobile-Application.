package com.sinda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends Activity {
	TextView name, id, training,approvalid, email, contact, cost;
	Button app, rej;
	String userApproval;
	HttpClient httpclient = new DefaultHttpClient();

	HttpPost httpPost = new HttpPost("");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		init();
		Intent det = getIntent();
		//int pos = det.getExtras().getInt("id");
			
		name.setText(det.getExtras().getString("name"));
		id.setText(det.getExtras().getString("id"));
		training.setText(det.getExtras().getString("training"));
		approvalid.setText(det.getExtras().getString("aid"));
		email.setText(det.getExtras().getString("email"));
		cost.setText(det.getExtras().getString("cost"));
		rej.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(100);
			}
		});
		app.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				InputStream inputStream = null;
				ApprovalDetails approvalDetails = new ApprovalDetails();

				approvalDetails.setApprovalDetailId(userApproval);

				ApprovalStatus approvalStatus = new ApprovalStatus();
				approvalStatus.setApprovalStatusId("4");

				approvalDetails.setApprovalStatus(approvalStatus);
				Gson gson = new Gson();

				System.out.println(gson.toJson(approvalDetails));

				String request = gson.toJson(approvalDetails);

				String response = null;
				Toast.makeText(getApplicationContext(), "Approved!!!!", Toast.LENGTH_SHORT).show();
				/*try {

					StringEntity se = new StringEntity(request);

					// set httpPost Entity
					httpPost.setEntity(se);

					// Set some headers to inform server about the type of the
					// content
					httpPost.setHeader("Accept", "application/json");
					httpPost.setHeader("Content-type", "application/json");

					// Execute POST request to the given URL
					HttpResponse httpResponse = httpclient.execute(httpPost);

					// receive response as inputStream
					inputStream = httpResponse.getEntity().getContent();

					// convert inputstream to string
					if (inputStream != null)
						response = convertInputStreamToString(inputStream);
					else
						response = "Did not work!";

					System.out.println("=========================");
					System.out.println(response);
					System.out.println("=========================");

					/*
					 * Intnet intent = new Intent(); startActivity(intent);
					 

				} catch (Exception e) {
					e.printStackTrace();
				}*/	
			}
		});
	}
	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;

	}
	private void init() {
		// TODO Auto-generated method stub
		name = (TextView) findViewById(R.id.ename);
		id = (TextView) findViewById(R.id.id);
		training = (TextView) findViewById(R.id.training);
		approvalid = (TextView) findViewById(R.id.approvalid);
		email = (TextView) findViewById(R.id.email);
		
		cost = (TextView) findViewById(R.id.cost);
		app = (Button) findViewById(R.id.approve);
		rej = (Button) findViewById(R.id.reject);
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
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		Dialog dlg = null;
		if (id == 100) {
			AlertDialog.Builder alert = new AlertDialog.Builder(this);
			alert.setTitle("Rejecting Training Application");
			alert.setMessage("Reason");
			// Create TextView
			final EditText input = new EditText(this);
			alert.setView(input);

			alert.setPositiveButton("Ok",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// Do something with value!
							String inputValue = input.getText().toString();

							System.out.println("Value :  --->>" + inputValue);
							InputStream inputStream = null;
							ApprovalDetails approvalDetails = new ApprovalDetails();

							approvalDetails.setApprovalDetailId(userApproval);
							approvalDetails.setRemarks(inputValue);
							ApprovalStatus approvalStatus = new ApprovalStatus();
							approvalStatus.setApprovalStatusId("5");

							approvalDetails.setApprovalStatus(approvalStatus);
							Gson gson = new Gson();

							System.out.println(gson.toJson(approvalDetails));

							String request = gson.toJson(approvalDetails);

							System.out.println("==================");
							System.out.println(request);
							System.out.println("===================");

							String response = null;
							try {

								StringEntity se = new StringEntity(request);

								// set httpPost Entity
								httpPost.setEntity(se);

								// Set some headers to inform server about the
								// type of the
								// content
								httpPost.setHeader("Accept", "application/json");
								httpPost.setHeader("Content-type",
										"application/json");

								// Execute POST request to the given URL
								HttpResponse httpResponse = httpclient
										.execute(httpPost);

								// receive response as inputStream
								inputStream = httpResponse.getEntity()
										.getContent();

								// convert inputstream to string
								if (inputStream != null)
									response = convertInputStreamToString(inputStream);
								else
									response = "Did not work!";

								System.out.println("=========================");
								System.out.println(response);
								System.out.println("=========================");

							} catch (Exception e) {
								e.printStackTrace();
							}

						}
					});

			alert.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// Canceled.
						}
					});
			alert.show();

		}

		return dlg;
	}

}
