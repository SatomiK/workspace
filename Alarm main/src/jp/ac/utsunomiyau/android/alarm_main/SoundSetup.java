package jp.ac.utsunomiyau.android.alarm_main;

import java.io.IOException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.util.Log;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SoundSetup extends Activity {
	Button play_btn;
	MediaPlayer mp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sound_setup);
	}

		// ���\�[�X�t�@�C������Đ�
		@Override
		public void onStart() {
			super.onStart();
			if(mp == null)
				mp = MediaPlayer.create(this, R.raw.sample3);
			mp.start();
			Log.d("alarm_main", "�������Đ�����܂���");
		}
	@Override
	public void onDestroy() {
		super.onDestroy();
		stopAndRelease();
	}
		private void stopAndRelease() {
			if(mp!=null) {
		play_btn = (Button) findViewById(R.id.button1);
		play_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("alarm_main", "Music Stop���N���b�N����܂���");
				// ��~��
				play_btn.setText("Music Stop");
				mp.stop();
				mp.release();
			}
		});
			}
		}
}