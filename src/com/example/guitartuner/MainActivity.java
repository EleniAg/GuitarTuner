package com.example.guitartuner;



import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	
	MediaPlayer mpAudio5;
	private static final int REQUEST_CODE_RECORD = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mpAudio5 = MediaPlayer.create(this, R.raw.echord);
		mpAudio5.start();
		

		if (savedInstanceState == null) {
		getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
	}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	public void tunerButton(View view) 
	{
		Intent intent = new Intent(this, TunerActivity.class);
		//intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
	
	public void recorderButton(View view) 
	{
		
		Button startRecording = (Button) findViewById(R.id.playBtn);
		startRecording.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent recordIntent = new Intent(
						MediaStore.Audio.Media.RECORD_SOUND_ACTION);
				startActivityForResult(recordIntent, REQUEST_CODE_RECORD);
			}
		});
		//Intent intent1 = new Intent(this, GalleryActivity.class);
		//intent.putExtra(EXTRA_MESSAGE, message);
		//startActivity(intent1);
	}
	
//	public void galleryButton(View view) 
//	{
//		Intent intent2 = new Intent(this, RecorderActivity.class);
//		//intent.putExtra(EXTRA_MESSAGE, message);
//		startActivity(intent2);
//	}
	

}
