package com.oysteinmyrmo.test.viewpagerlifecycletest;

import android.os.Bundle;
import com.github.machinarius.preferencefragment.PreferenceFragment;

/**
 * Use com.github.machinarius.preferencefragment.PreferenceFragment to be able to use
 * getSupportFragmentManager() in the Activity. Else, PreferenceFragment is not available
 * until API 15.
 * */
public class SettingsFragment extends PreferenceFragment
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}
}
