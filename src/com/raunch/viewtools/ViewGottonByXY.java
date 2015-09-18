package com.raunch.viewtools;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class ViewGottonByXY {
	public final static String TAG = ViewGottonByXY.class.getSimpleName();

	/**
	 * 根据传入的坐标点，已经对应的Activity获取对应的控件
	 * 
	 * @param x坐标点
	 * @param y坐标点
	 * @param 要显示View的activity
	 * @return 目标View
	 */
	public View getViewAtActivity(int x, int y, Activity activity) {
		// 从Activity里获取容器
		View root = activity.getWindow().getDecorView();
		if (root == null) {
			Log.i(TAG, "get deccorview is null");
		}
		return findViewByXY(root, x, y);
	}

	private View findViewByXY(View view, int x, int y) {
		View targetView = null;
		if (view instanceof ViewGroup) {
			// 父容器,遍历子控件
			Log.i(TAG, "get target view from view group");
			ViewGroup v = (ViewGroup) view;
			for (int i = 0; i < v.getChildCount(); i++) {
				targetView = findViewByXY(v.getChildAt(i), x, y);
				if (targetView != null) {
					break;
				}
			}
		} else {
			Log.i(TAG, "get target view from view singel");
			targetView = getTouchTarget(view, x, y);
		}
		return targetView;

	}

	private View getTouchTarget(View view, int x, int y) {
		Log.i(TAG, "go here find touch target");
		View targetView = null;
		// 判断view是否可以聚焦
		/*
		 * ArrayList<View> TouchableViews = view.getTouchables(); for (View
		 * child : TouchableViews) { if (isTouchPointInView(child, x, y)) {
		 * targetView = child; break; } }
		 */
		if (isTouchPointInView(view, x, y)) {
			targetView = view;
		}

		return targetView;
	}

	private boolean isTouchPointInView(View view, int x, int y) {
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		int left = location[0];
		int top = location[1];
		int right = left + view.getMeasuredWidth();
		int bottom = top + view.getMeasuredHeight();
		Log.i(TAG, "the location is left " + left + " top " + top + " right "
				+ right + " botton " + bottom);
		if (view.isClickable() && y >= top && y <= bottom && x >= left
				&& x <= right) {
			return true;
		}
		return false;
	}
}
