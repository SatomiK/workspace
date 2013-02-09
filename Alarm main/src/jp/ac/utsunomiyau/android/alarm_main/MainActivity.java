package jp.ac.utsunomiyau.android.alarm_main;

import java.util.Calendar;
import java.util.Date;
import java.lang.Object;
import android.app.Dialog;
import android.app.AlertDialog;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.util.Log;
import android.app.AlarmManager;

public class MainActivity extends Activity {
	final Calendar calendar = Calendar.getInstance();
	// カレンダーから現在の '時' を取得
	int mHour = calendar.get(Calendar.HOUR_OF_DAY);
	// カレンダーから現在の '分' を取得
	int mMinute = calendar.get(Calendar.MINUTE);

	// ▼　追加　=========================== ▼
	// アラームマネージャ
	private AlarmManager alarmManager;

	// 時間設定
	private Calendar calendar_alarm;

	// 時刻設定クラス
	TimePickerDialog timePickerDialog;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn = (Button) findViewById(R.id.button2);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		Button btn2 = (Button) findViewById(R.id.button1);
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TimePickerDialog の表示
				Log.d("alarm_clock", "設定ダイアログを表示");
				timePickerDialog.show();
			}
		});
		/** Called when the activity is first created. */
		// TimePickerDialog の時刻が変更された時に呼び出されるコールバックを登録
		TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				mHour = hourOfDay; // '時' を取得
				mMinute = minute; // '分' を取得
				Log.d("alarm_clock", "OnTimeSetListener設定時刻は" + mHour + ":"
						+ mMinute);
				setAlarm();
			}
		};

		// TimePickerDialog の作成
		timePickerDialog = new TimePickerDialog(this, // 第1引数 : Context
				listener, // 第2引数 : TimePickerDialog.OnTimeSetListener
				mHour, // 第3引数 : 時
				mMinute, // 第4引数 : 分
				false // 第5引数 : 24時間表示(true)かAM/PM表示(false)か
		);
	}

	// アラームの設定
	public void setAlarm() {
		Log.d("Test_alarmActivity", "setAlarm()");

		alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		
		// 時間を設定
		calendar_alarm = Calendar.getInstance();

		// 現在日付の設定
		calendar_alarm.setTimeInMillis(System.currentTimeMillis());

		// 設定した時刻を取得
		calendar_alarm.set(Calendar.HOUR_OF_DAY, mHour);
		calendar_alarm.set(Calendar.MINUTE, mMinute);
		calendar_alarm.set(Calendar.SECOND, 0);
		calendar_alarm.set(Calendar.MILLISECOND, 0);
		
		// アラームマネージャの設定
		alarmManager.set(AlarmManager.RTC_WAKEUP,
				calendar_alarm.getTimeInMillis(), getPendingIntent());
	}

	// アラームの解除
	public void cancelAlarm() {
		Log.d("Test_alarmActivity", "cancelAlarm()");

		// アラームマネージャの解除
		alarmManager.cancel(getPendingIntent());
		stopService(null);
	}
	// インテントの作成
		private PendingIntent getPendingIntent() {
			// サービスの設定
			Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
			PendingIntent pendingIntent = PendingIntent.getService(this, 0,
					intent, 0);
			return pendingIntent;
		}
}