package jp.ac.utsunomiyau.android.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("alarm_main", "ReceivedActivity���Ăяo����܂���");
	}
}

