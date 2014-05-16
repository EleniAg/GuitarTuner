package com.example.guitartuner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

/**
 * This class shows how to run Sound Recorder activity
 * @author The Developer's Info
 */
public class RecorderActivity extends Activity {
	private static final int REQUEST_CODE_RECORD = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recorder);
		Button startRecording = (Button) findViewById(R.id.startBtn);
		startRecording.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent recordIntent = new Intent(
						MediaStore.Audio.Media.RECORD_SOUND_ACTION);
				startActivityForResult(recordIntent, REQUEST_CODE_RECORD);
			}
		});
	}
}
