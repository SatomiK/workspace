package jp.ac.utsunomiyau.android.received_activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReceivedActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_received, menu);
        return true;
    }
}