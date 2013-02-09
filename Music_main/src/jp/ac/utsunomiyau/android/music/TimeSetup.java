package jp.ac.utsunomiyau.android.music;
 
import java.util.Calendar;
import java.util.Date;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class TimeSetup extends Activity implements SharedPreferences.OnSharedPreferenceChangeListener { 
	private AlarmManager alarmManager; 
	private Calendar calendar;   
	private TimePicker timePicker;   
	private SharedPreferences prefs; 
	private int cal_hour;    
	private int cal_minute;    
/** Called when the activity is first created. */ 
@Override
public void onCreate(Bundle savedInstanceState) { 
	super.onCreate(savedInstanceState);     
	setContentView(R.layout.time_setup);      
	
	// ���ݎ����̎擾   
	calendar = Calendar.getInstance();
	calendar.setTimeInMillis(System.currentTimeMillis());     
	Date date = calendar.getTime();  
	cal_hour = date.getHours();    
	cal_minute = date.getMinutes();
	final Button alarmYesBtn = (Button)findViewById(R.id.button2);    
	final Button alarmNo_Btn = (Button)findViewById(R.id.button1);      
	
	// �ۑ����ꂽ�������擾   
	prefs = PreferenceManager.getDefaultSharedPreferences(this);     
	prefs.registerOnSharedPreferenceChangeListener(this);      
	getSharedPreferences();      
	
	// TimePicker �ɔ��f  
	timePicker = (TimePicker)findViewById(R.id.timePicker1);     
	timePicker.setIs24HourView(true);     
	timePicker.setCurrentHour(cal_hour);     
	timePicker.setCurrentMinute(cal_minute);      
	alarmYesBtn.setOnClickListener( new Button.OnClickListener() {     
		public void onClick(View arg0) {       
			// TODO �����������ꂽ���\�b�h�E�X�^�u     
			alarmYesBtn.setEnabled(false);      
			alarmNo_Btn.setEnabled(true);    
			// �A���[���̐ݒ�      
			startAlarm();     
			}
		});     
	alarmNo_Btn.setOnClickListener( new Button.OnClickListener() {     
		public void onClick(View v) {    
			// TODO �����������ꂽ���\�b�h�E�X�^�u    
			alarmYesBtn.setEnabled(true);      
			alarmNo_Btn.setEnabled(false);    
			// �A���[���̉���
			stopAlarm();       
			}     
		});
	}
public void startAlarm() {      
	Log.d("AlarmTestActivity", "startAlarm()");      
	alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);   
	
	// �O�̂��ߌ��݂̔N�����Ǝ擾���Ă��鎞�����J�����_�[�ɐݒ�   
	calendar = Calendar.getInstance();    
	calendar.setTimeInMillis(System.currentTimeMillis());     
	Date date = calendar.getTime();   
	date.setHours(cal_hour);     
	date.setMinutes(cal_minute);     
	calendar.setTimeInMillis(System.currentTimeMillis());     
	
	// TimePicker �őI�����ꂽ�������擾     
	timePicker = (TimePicker)findViewById(R.id.timePicker1);      
	cal_hour = timePicker.getCurrentHour();     
	cal_minute = timePicker.getCurrentMinute();    
	// �擾�����������J�����_�[�ɐݒ�    
	calendar.set(Calendar.HOUR_OF_DAY, cal_hour);    
	calendar.set(Calendar.MINUTE, cal_minute );       
	calendar.set(Calendar.SECOND, 0);    
	calendar.set(Calendar.MILLISECOND, 0);     
	
	// �A���[���ɓo�^    
	alarmManager.set(AlarmManager.RTC_WAKEUP,  
			calendar.getTimeInMillis(),    
			getPendingIntent());      
	
	// ������ۑ�     
	SharedPreferences.Editor editor = prefs.edit();  
	editor.putInt( "cal_hour", cal_hour );   
	editor.putInt( "cal_minute", cal_minute );     
	editor.commit();
	}

public void stopAlarm() {  
	Log.d("AlarmTestActivity", "stopAlarm()");
	// �o�^���Ă���A���[�������� 
	alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);  
	alarmManager.cancel(getPendingIntent());
	}
private PendingIntent getPendingIntent() {  
	// �N������A�v���P�[�V������o�^    
	Intent intent = new Intent( getApplicationContext(), TimeSetup.class );    
	PendingIntent pendingIntent = PendingIntent.getActivity
			(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT );    
	return pendingIntent;
	}
public void onSharedPreferenceChanged(SharedPreferences arg0, String arg1) { 
	// TODO �����������ꂽ���\�b�h�E�X�^�u
	getSharedPreferences();
	}
private void getSharedPreferences() { 
	// �ۑ�����Ă����������擾    
	cal_hour = prefs.getInt("cal_hour", cal_hour);   
	cal_minute = prefs.getInt("cal_minute", cal_minute); 
}
}