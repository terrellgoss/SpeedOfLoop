package com.appmobinfo.speedofloop;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;



public class MainActivity extends Activity implements OnClickListener {
	TextView tvOut;
	private static final String TAG = "ResLogs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        Button button1 = (Button)findViewById(R.id.button1);        
        button1.setOnClickListener(this);		



		tvOut = (TextView) findViewById(R.id.textView1);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
    	long timeStart;
    	long timeEnd;
    	long s;
    	String strOut = "";
    	
		int size = 300_000;
		
		int[] arrNums = new int[size];

		for(int i=0; i < size; i++)
        {
			arrNums[i] = 1;
        }

		for(int r=0; r < 2500; r++)
        {

        strOut = "id="+r + "\n";;


		s = 0;
		timeStart = Calendar.getInstance().getTimeInMillis();
		int iw=0;
		while (iw < size) {
			s+=arrNums[iw];
		    iw++;
		}
		timeEnd = Calendar.getInstance().getTimeInMillis();
		strOut = strOut + "While: " + (long)(timeEnd - timeStart) + " ms (s=" + s + ")\n";

		
		s = 0;
		timeStart = Calendar.getInstance().getTimeInMillis();
		for(int i_fa : arrNums) s+=arrNums[i_fa];
		timeEnd = Calendar.getInstance().getTimeInMillis();
		strOut = strOut + "For_array: " + (long)(timeEnd - timeStart) + " ms (s=" + s + ")\n";


		s = 0;
		timeStart = Calendar.getInstance().getTimeInMillis();
		for(int i_f=0; i_f < size; i_f++) s+=arrNums[i_f];
		timeEnd = Calendar.getInstance().getTimeInMillis();
		strOut = strOut + "For_standart: " + (long)(timeEnd - timeStart) + " ms (s=" + s + ")\n";


		s = 0;
		timeStart = Calendar.getInstance().getTimeInMillis();
		int idw = 0;
		do {
			s+=arrNums[idw];
			idw++;
		} while (idw < size);
		timeEnd = Calendar.getInstance().getTimeInMillis();
		strOut = strOut + "Do_While: " + (long)(timeEnd - timeStart) + " ms (s=" + s + ")\n";


		tvOut.setText(strOut);
		// Log.e(TAG, strOut);
        }
		
		// tvOut.setText("+");


    }

}
