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
	// �J�����_�[���猻�݂� '��' ���擾
	int mHour = calendar.get(Calendar.HOUR_OF_DAY);
	// �J�����_�[���猻�݂� '��' ���擾
	int mMinute = calendar.get(Calendar.MINUTE);

	// ���@�ǉ��@=========================== ��
	// �A���[���}�l�[�W��
	private AlarmManager alarmManager;

	// ���Ԑݒ�
	private Calendar calendar_alarm;

	// �����ݒ�N���X
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
				// TimePickerDialog �̕\��
				Log.d("alarm_clock", "�ݒ�_�C�A���O��\��");
				timePickerDialog.show();
			}
		});
		/** Called when the activity is first created. */
		// TimePickerDialog �̎������ύX���ꂽ���ɌĂяo�����R�[���o�b�N��o�^
		TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				mHour = hourOfDay; // '��' ���擾
				mMinute = minute; // '��' ���擾
				Log.d("alarm_clock", "OnTimeSetListener�ݒ莞����" + mHour + ":"
						+ mMinute);
				setAlarm();
			}
		};

		// TimePickerDialog �̍쐬
		timePickerDialog = new TimePickerDialog(this, // ��1���� : Context
				listener, // ��2���� : TimePickerDialog.OnTimeSetListener
				mHour, // ��3���� : ��
				mMinute, // ��4���� : ��
				false // ��5���� : 24���ԕ\��(true)��AM/PM�\��(false)��
		);
	}

	// �A���[���̐ݒ�
	public void setAlarm() {
		Log.d("Test_alarmActivity", "setAlarm()");

		alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		
		// ���Ԃ�ݒ�
		calendar_alarm = Calendar.getInstance();

		// ���ݓ��t�̐ݒ�
		calendar_alarm.setTimeInMillis(System.currentTimeMillis());

		// �ݒ肵���������擾
		calendar_alarm.set(Calendar.HOUR_OF_DAY, mHour);
		calendar_alarm.set(Calendar.MINUTE, mMinute);
		calendar_alarm.set(Calendar.SECOND, 0);
		calendar_alarm.set(Calendar.MILLISECOND, 0);
		
		// �A���[���}�l�[�W���̐ݒ�
		alarmManager.set(AlarmManager.RTC_WAKEUP,
				calendar_alarm.getTimeInMillis(), getPendingIntent());
	}

	// �A���[���̉���
	public void cancelAlarm() {
		Log.d("Test_alarmActivity", "cancelAlarm()");

		// �A���[���}�l�[�W���̉���
		alarmManager.cancel(getPendingIntent());
		stopService(null);
	}
	// �C���e���g�̍쐬
		private PendingIntent getPendingIntent() {
			// �T�[�r�X�̐ݒ�
			Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
			PendingIntent pendingIntent = PendingIntent.getService(this, 0,
					intent, 0);
			return pendingIntent;
		}
}