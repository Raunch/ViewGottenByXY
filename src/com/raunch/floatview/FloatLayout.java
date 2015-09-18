package com.raunch.floatview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ruanch.getviewbyxy.R;

public class FloatLayout extends LinearLayout {
	private final String TAG = "FloatView";
	private Context mContext;
	private ImageView mFloatView;

	private int mLeft;
	private int mTop;
	private int mRight;
	private int mBottom;

	public FloatLayout(Context context) {
		super(context);
		mContext = context;
		mFloatView = (ImageView) LayoutInflater.from(mContext).inflate(
				R.layout.raunch_float_view, null);

		addView(mFloatView);

	}

	/*
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		
		printCoordinateInfo();
		int x = (int) ev.getX();
		int y = (int) ev.getY();
		Log.i(TAG, "X is " + x + " and Y is " + y);
		if (hasContained(x, y)) {
			return true;
		} else {
			return false;
		}
	}
	*/
	

	/*
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.i(TAG, "Touch here and do nothing");
		int x = (int) event.getX();
		int y = (int) event.getY();
		if (hasContained(x, y)) {
			return true;
		} else {
			return false;
		}
	}
	*/
	

	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();		
		printCoordinateInfo();  
	}
	
	private boolean hasContained(int x, int y) {
		if ((mLeft <= x && mRight >= x) && (mTop <= y && mBottom >= y)) {
			return true;
		} else {
			return false;
		}
	}
	
	private void printCoordinateInfo() {
		mLeft = mFloatView.getLeft();
		mTop = mFloatView.getTop();
		mRight = mFloatView.getRight();
		mBottom = mFloatView.getBottom();
		Log.i(TAG, "The Button left is " + mLeft + " top is " + mTop + " the right is " + mRight + " the bottom is " + mBottom);
	}

}
