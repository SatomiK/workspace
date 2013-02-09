package jp.ac.utsunomiyau.android.music;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Music_main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_main);
    }
    
    //MainActivityを起動するメソッド
    public void switchTimeSetup (View v) {
	 Intent varIntent = new Intent (this, TimeSetup.class);
	 startActivity(varIntent);
	 }
}
    