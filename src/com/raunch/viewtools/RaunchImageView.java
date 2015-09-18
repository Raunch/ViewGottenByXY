package com.raunch.viewtools;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.Toast;

public class RaunchImageView extends ImageView implements RaunchHoverListener {


	public RaunchImageView(Context context) {
		super(context);
	}

	public RaunchImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public RaunchImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public void action(Context context) {
		Toast.makeText(context, "gagaga", Toast.LENGTH_SHORT).show();
	}

}
