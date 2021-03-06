package com.example.testwidget;

import android.content.ComponentName;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/*
 * A composite class that represents an item in the
 * application list.
 */
public class ApplicationListItem {
	private Drawable mIconDrawable;
	private Bitmap mIconBitmap;
	private String mLabel;
	private ComponentName mComponentName;
	// mLaunchCount is the number of times this application has
	// been launched
	private int mLaunchCount;
	private long mLaunchTimeSeconds;
	// The simplified label is a concatenation of the
	// string properties of the list item with the following
	// transformations:
	// - all uppercase letters transformed to lowercase
	// - all whitespace removed
	private String mSimplifiedLabel;
	
	public ApplicationListItem(String label, ComponentName componentName) {
		this(null, null, label, componentName);
	}
	
	public ApplicationListItem(Drawable iconDrawable,
			Bitmap iconBitmap, String label, ComponentName componentName) {
		mIconDrawable = iconDrawable;
		mIconBitmap = iconBitmap;
		mLabel = label;
		mComponentName = componentName;
		mSimplifiedLabel = extractAlphanumerics(label);
	}
	
	private String extractAlphanumerics(String str) {
		String lowcaseStr = str.toLowerCase();
		StringBuffer result = new StringBuffer();
		char ch;
		int strOffset;
		
		for (strOffset = 0; strOffset < str.length(); strOffset++) {
			ch = lowcaseStr.charAt(strOffset);
			
			if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
				result.append(ch);
			}
		}
		
		return result.toString();
	}
	
	public Drawable getIconDrawable() {
		return mIconDrawable;
	}
	
	public Bitmap getIconBitmap() {
		return mIconBitmap;
	}
	
	public String getApplicationLabel() {
		return mLabel;
	}
	
	public String getSimplifiedApplicationLabel() {
		return mSimplifiedLabel;
	}
	
	public String toString() {
		return mLabel;
	}
	
	public ComponentName getComponentName() {
		return mComponentName;
	}
	
	public void setLaunchCount(int launchCount) {
		mLaunchCount = launchCount;
	}
	
	public void incrementLaunchCount() {
		mLaunchCount++;
	}
	
	public int getLaunchCount() {
		return mLaunchCount;
	}
	
	public void setLaunchTimeSeconds(long launchTimeSeconds) {
		mLaunchTimeSeconds = launchTimeSeconds;
	}
	
	/*
	 * Returns the last launch time in seconds
	 */
	public long getLaunchTime() {
		return mLaunchTimeSeconds;
	}
}
