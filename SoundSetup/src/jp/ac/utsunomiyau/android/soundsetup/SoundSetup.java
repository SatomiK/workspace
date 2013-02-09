package jp.ac.utsunomiyau.android.soundsetup;

import java.io.IOException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import java.util.ArrayList;
import android.net.Uri;
import android.widget.LinearLayout;
import android.content.res.AssetFileDescriptor;

public class SoundSetup extends Activity {
	Button play_btn;
	MediaPlayer mp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sound_setup);

		// リソースファイルから再生
		mp = MediaPlayer.create(this, R.raw.sample2);
		mp.start();

		play_btn = (Button) findViewById(R.id.button1);
		play_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("alarm_main", "Music Stopがクリックされました");
				// 停止中
				play_btn.setText("Music Stop");
				mp.stop();
			}
		});
	}
}
