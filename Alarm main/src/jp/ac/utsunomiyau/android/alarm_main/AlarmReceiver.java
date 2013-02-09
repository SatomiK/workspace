package jp.ac.utsunomiyau.android.alarm_main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
	//MediaPlayer mp;
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("alarm_main", "ReceivedActivityÇ™åƒÇ—èoÇ≥ÇÍÇ‹ÇµÇΩ");
		Intent notification = new Intent(context,
				SoundSetup.class);
		
		notification.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(notification);
		
		//mp = MediaPlayer.create(context, R.raw.sample2);
		//mp.start();
		//Intent varIntent = new Intent (context, SoundSetup.class);
		 //context.startActivity(varIntent);
	}
}


