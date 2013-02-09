package jp.ac.utsunomiyau.android.alarm_main;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SoundService extends Service {
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	//NotificationManager notificationManager;
	@Override
	public void onCreate() {
		//通知領域を使用する
		//notificationManager = (NotificationManager)
				//this.getSystemService(Context.NOTIFICATION_SERVICE);
		Thread thr = new Thread(null, mTask, "SoundServiceThread");
		thr.start();
		
	}
	
	//アラームサービス
	Runnable mTask = new Runnable() {
	public void run() {
		
		Intent alarmBroadcast = new Intent();
		
        sendBroadcast(alarmBroadcast);
       
        SoundService.this.stopSelf();//サービスを止める
        Log.v("MyAlarmServiceログ","サービス停止");
    }
    };
	/*public void onStart(Intent it, int id) {
		Intent intent = new Intent (this, SoundSetup.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent ,0);
	}
		public void onDestroy() {
			//notificationManager.cancel(0);
		}*/

	
}