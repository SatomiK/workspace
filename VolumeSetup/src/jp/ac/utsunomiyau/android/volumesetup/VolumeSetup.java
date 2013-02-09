package jp.ac.utsunomiyau.android.volumesetup;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.media.AudioManager;
import android.content.Context;
import android.widget.Toast;

public class VolumeSetup extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_setup);
        
       	
		AudioManager audio = (AudioManager) 
				getSystemService(Context.AUDIO_SERVICE);
        int ringVol = audio.getStreamVolume(AudioManager.STREAM_ALARM);
        Toast.makeText(this, "ÉAÉâÅ[ÉÄâπó ÇÕ"+String.valueOf(ringVol) ,
        		Toast.LENGTH_SHORT).show();
        audio.setStreamVolume(AudioManager.STREAM_RING, 5, 
        		AudioManager.FLAG_SHOW_UI);
    
    }
}
