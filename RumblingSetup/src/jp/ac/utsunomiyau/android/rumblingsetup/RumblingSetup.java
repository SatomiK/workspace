package jp.ac.utsunomiyau.android.rumblingsetup;


import java.nio.charset.Charset;
import java.util.Calendar;
import android.os.Bundle;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class RumblingSetup extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    public void onResume() {
    	super.onResume();
    	//カレンダーを生成
    	Calendar _calendar = Calendar.getInstance();
    	TimePickerDialog _timePickerDialog = new TimePickerDialog (
    			this, 
    			new TimePickerDialog.OnTimeSetListener() {
    				@Override
    				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    				}
    			},
    			_calendar.get(Calendar.HOUR_OF_DAY),
    			_calendar.get(Calendar.MINUTE),
    			true //午後・午前ボタンなし（ありはfalse）
    			);
    	_timePickerDialog.show();
    }
}
