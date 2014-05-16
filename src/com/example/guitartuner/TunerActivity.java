package com.example.guitartuner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.media.MediaPlayer;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class TunerActivity extends ActionBarActivity implements GestureDetector.OnGestureListener , GestureDetector.OnDoubleTapListener 
{
	
	private GestureDetector gDetector;
	MediaPlayer mpAudio;
	MediaPlayer mpAudio1;
	MediaPlayer mpAudio2;
	MediaPlayer mpAudio3;
	MediaPlayer mpAudio4;
	
	
	private TextView gestureText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tuner);
		Intent intent = getIntent();
		
		 mpAudio = MediaPlayer.create(this, R.raw.sixth);
	     mpAudio1 = MediaPlayer.create(this, R.raw.fifth);
	     mpAudio2 = MediaPlayer.create(this, R.raw.fourth);
	     mpAudio3 = MediaPlayer.create(this, R.raw.third);
	        
	        gestureText = (TextView)findViewById(R.id.gestureStatusText);
	        this.gDetector = new GestureDetector(this,this);
			gDetector.setOnDoubleTapListener(this);

		
		
	}

	
	@Override
    public boolean onTouchEvent(MotionEvent me) {
    	this.gDetector.onTouchEvent(me);
        return super.onTouchEvent(me);
    }
    
    
	@Override
	public boolean onFling(MotionEvent start, MotionEvent finish, float xVelocity, float yVelocity) {
		float diffY = start.getRawY() - finish.getRawY();
		float diffX = start.getRawX() - finish.getRawX();
		
		if (Math.abs(diffX) > Math.abs(diffY) )
			
		{ 
			
			if (diffX > 0) {
				
				gestureText.setText("String G");
				mpAudio2.start();
				
				((ImageView)findViewById(R.id.image)).setImageResource(R.drawable.dow2);
			}
			
			
			else if (diffX <= 0){
				gestureText.setText("String E(low)");
				mpAudio.start();
				
			((ImageView)findViewById(R.id.image)).setImageResource(R.drawable.dow);
			}
			
			return true;
			
			
			
		}
		//((ImageView)findViewById(R.id.image_place_holder)).setImageResource(R.drawable.dow3);
			
		
		if (start.getRawY() < finish.getRawY()) {
			gestureText.setText("String A");
			mpAudio1.start();
			
			((ImageView)findViewById(R.id.image)).setImageResource(R.drawable.dow1);
			
		} else if(start.getRawY() > finish.getRawY()) {
			gestureText.setText("String D");
			mpAudio3.start();
			((ImageView)findViewById(R.id.image)).setImageResource(R.drawable.dow3); 
			
		}
		
		
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean onDoubleTap(MotionEvent me) {
		// TODO Auto-generated method stub
		gestureText.setText("onDoubleTap");
		
		return true;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent me) {
		// TODO Auto-generated method stub
		gestureText.setText("To hear string E(low), Swipe from top to bottom.");
		return true;
	}
	
	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tuner, menu);
		return true;
	}



}
