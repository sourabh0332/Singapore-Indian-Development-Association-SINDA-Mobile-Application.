package com.sinda;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends Activity {
	MediaPlayer spl;
	ImageView logo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		// spl=spl.create(Splash.this, R.raw.splash);
		// spl.start();
		logo = (ImageView) findViewById(R.id.imageView1);
		Animation anim = AnimationUtils.loadAnimation(Splash.this, R.anim.anim);
		logo.startAnimation(anim);
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(2000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				} finally {
					Intent main = new Intent(Splash.this,MainActivity.class);
					startActivity(main);
				}
			}
		};
		timer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
