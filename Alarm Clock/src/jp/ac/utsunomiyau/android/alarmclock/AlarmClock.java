package jp.ac.utsunomiyau.android.alarmclock;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;
public class AlarmClock extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ImageView imageView  = new ImageView(this);
		imageView.setImageResource(R.drawable.watch2);
		setContentView(imageView);
	}
	
}

