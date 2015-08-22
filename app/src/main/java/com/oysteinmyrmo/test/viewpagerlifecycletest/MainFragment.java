package com.oysteinmyrmo.test.viewpagerlifecycletest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment
{
	private TestActivity 	mTestActivity;
	private ViewPager 		mViewPager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		mTestActivity = (TestActivity) container.getContext();

		// Setup ViewPager.
		mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
		mViewPager.setAdapter(new TestPagerAdapter(this.getChildFragmentManager(), mTestActivity));
		mViewPager.setOffscreenPageLimit(2);
		mViewPager.setCurrentItem(0);

		// Setup TabLayout.
		TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
		tabLayout.setupWithViewPager(mViewPager);

		return view;
	}
}
