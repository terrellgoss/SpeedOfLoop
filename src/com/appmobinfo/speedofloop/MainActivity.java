package com.appmobinfo.speedofloop;
import java.util.Calendar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;



public class MainActivity extends Activity implements OnClickListener {
	TextView tvOut;

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
    	
		int size = 5_000_000;
		
		int[] arrNums = new int[size];

		for(int i=0; i < size; i++)
        {
			arrNums[i] = i;
        }


		s = 0;
		timeStart = Calendar.getInstance().getTimeInMillis();
		for(int i : arrNums) s+=arrNums[i];
		timeEnd = Calendar.getInstance().getTimeInMillis();
		strOut = strOut + "For short: " + (long)(timeEnd - timeStart) + " ms (s=" + s + ")\n";


		s = 0;
		timeStart = Calendar.getInstance().getTimeInMillis();
		for(int i=0; i < size; i++) s+=arrNums[i];
		timeEnd = Calendar.getInstance().getTimeInMillis();
		strOut = strOut + "For standart: " + (long)(timeEnd - timeStart) + " ms (s=" + s + ")\n";


		s = 0;
		timeStart = Calendar.getInstance().getTimeInMillis();
		int i = 0;
		do {
			s+=arrNums[i];
		    i++;
		} while (i < size);
		timeEnd = Calendar.getInstance().getTimeInMillis();
		strOut = strOut + "Do While: " + (long)(timeEnd - timeStart) + " ms (s=" + s + ")\n";


		s = 0;
		timeStart = Calendar.getInstance().getTimeInMillis();
		i=0;
		while (i < size) {
			s+=arrNums[i];
		    i++;
		}
		timeEnd = Calendar.getInstance().getTimeInMillis();
		strOut = strOut + "While: " + (long)(timeEnd - timeStart) + " ms (s=" + s + ")\n";


		tvOut.setText(strOut);	
    }

}
