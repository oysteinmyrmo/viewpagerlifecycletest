package com.oysteinmyrmo.test.viewpagerlifecycletest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TestPagerAdapter extends FragmentPagerAdapter
{
	private TestActivity mTestActivity;

	public TestPagerAdapter(FragmentManager fragmentManager, TestActivity testActivity)
	{
		super(fragmentManager);
		mTestActivity = testActivity;
	}

	@Override
	public Fragment getItem(int position)
	{
		switch (position)
		{
			case 0:
				return new GreenTestFragment();

			case 1:
				return new YellowTestFragment();

			case 2:
				return new CyanTestFragment();

			default:
				throw new RuntimeException("Unknown position: " + position);
		}
	}

	@Override
	public int getCount()
	{
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		switch (position)
		{
			case 0:
				return "Page 0";

			case 1:
				return "Page 1";

			case 2:
				return "Page 2";

			default:
				throw new RuntimeException("Unknown position: " + position);
		}
	}
}
