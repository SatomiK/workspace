package jp.ac.utsunomiyau.android.alarm_main;

import android.app.Activity;
import android.content.Intent; 
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Alarmmain extends Activity {  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_main);
    }
//MainActivity���N�����郁�\�b�h
 public void switchMainActivity (View v) {
	 Intent varIntent = new Intent (this, MainActivity.class);
	 startActivity(varIntent);
	 }
}
 
 

		