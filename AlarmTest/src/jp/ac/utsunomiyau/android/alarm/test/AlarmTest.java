package jp.ac.utsunomiyau.android.alarm.test;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;  
import android.content.SharedPreferences;  
import android.os.Bundle;
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  

public class AlarmTest extends Activity {
	static final private String prefName = "MY_PREF";  
    	 private int mScreenId = R.layout.alarm_test;    
   
    @Override  
      public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
      
        SharedPreferences prefs = getSharedPreferences(prefName, Context.MODE_PRIVATE);  
        int screenId = prefs.getInt("screenId", R.layout.alarm_test);  
      
        setScreenContent(screenId);  
      }  
      
      @Override  
      public void onDestroy() {  
        super.onDestroy();  
     SharedPreferences prefs = getSharedPreferences(prefName, Context.MODE_PRIVATE);  
        SharedPreferences.Editor editor = prefs.edit();  
        editor.putInt("screenId", mScreenId);  
        editor.commit();  
      }  
      
      private void setScreenContent(int screenId) {  
        mScreenId = screenId;  
        setContentView(screenId);  
        
        switch (screenId) {  
        case R.layout.alarm_test: {  
          setFirstScreenContent();  
          break;  
        }  
        case R.layout.alarm_main: {  
         setSecondScreenContent();  
          break;  
        }  
        case R.layout.sound_setup: {  
          setMainScreenContent();  
          break;  
       }  
        }  
      }  
      
      private void setMainScreenContent() {  
       Button backButton = (Button) findViewById(R.id.button1);  
        backButton.setVisibility(View.INVISIBLE);  
      
        Button nextButton = (Button) findViewById(R.id.button1);  
        nextButton.setOnClickListener(new OnClickListener() {  
          public void onClick(View v) {  
            setScreenContent(R.layout.alarm_test);  
          }  
        });  
      }  
      
      private void setFirstScreenContent() {  
        Button backButton = (Button) findViewById(R.id.button2);  
        backButton.setOnClickListener(new OnClickListener() {  
          public void onClick(View v) {  
            setScreenContent(R.layout.sound_setup);  
          }  
        });  
      
        Button nextButton = (Button) findViewById(R.id.button2);  
        nextButton.setOnClickListener(new OnClickListener() {  
          public void onClick(View v) {  
            setScreenContent(R.layout.alarm_main);  
          }  
        });  
      }  
      
      private void setSecondScreenContent() {  
        Button backButton = (Button) findViewById(R.id.button1);  
        backButton.setOnClickListener(new OnClickListener() {  
          public void onClick(View v) {  
            setScreenContent(R.layout.alarm_test);  
          }  
        });  
      
        Button nextButton = (Button) findViewById(R.id.button1);  
       nextButton.setOnClickListener(new OnClickListener() {  
          public void onClick(View v) {  
            finish();  
          }  
        });  
      }  
    }  
