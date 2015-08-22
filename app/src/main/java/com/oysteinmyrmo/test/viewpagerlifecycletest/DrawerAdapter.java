package com.oysteinmyrmo.test.viewpagerlifecycletest;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerAdapter extends ArrayAdapter
{
	private Context mContext;

	public DrawerAdapter(Context context)
	{
		super(context, R.layout.drawer_item);
		mContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row;

		if(convertView == null)
		{
			LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
			row = inflater.inflate(R.layout.drawer_item, parent, false);
		}
		else
		{
			row = convertView;
		}

		ImageView imageView = (ImageView) row.findViewById(R.id.drawer_item_icon);
		TextView textView = (TextView) row.findViewById(R.id.drawer_item_text);

		// Just a random drawable
		imageView.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.abc_btn_radio_material));
		textView.setText("Settings");

		return row;
	}

	@Override
	public int getCount()
	{
		return 1;
	}

}
