package com.oysteinmyrmo.test.viewpagerlifecycletest;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import junit.framework.Test;

public class DrawerOnItemClickListener implements ListView.OnItemClickListener
{
	@Override
	public void onItemClick(AdapterView parent, View view, int position, long id)
	{
		selectItem((TestActivity)view.getContext(), position);
	}

	private void selectItem(TestActivity testActivity, int position)
	{

		switch(position)
		{
			case 0:
				showSettingsFragment(testActivity, position);
				break;

			default:
				throw new RuntimeException("Unknown drawer position: " + position);
		}
	}

	private void showSettingsFragment(TestActivity testActivity, int position)
	{
		testActivity.showSettingsFragment();

		ListView listView = (ListView) testActivity.findViewById(R.id.drawer_listview);
		listView.setItemChecked(position, true);
		DrawerLayout drawerLayout = (DrawerLayout) testActivity.findViewById(R.id.mm_drawer_layout);
		drawerLayout.closeDrawer(listView);
	}
}
