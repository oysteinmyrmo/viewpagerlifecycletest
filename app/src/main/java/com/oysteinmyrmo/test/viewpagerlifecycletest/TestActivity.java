package com.oysteinmyrmo.test.viewpagerlifecycletest;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class TestActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Setup Toolbar.
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setIcon(R.drawable.abc_btn_radio_material); // Just a random image.
		getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

		// Setup drawer.
		ListView drawerList = (ListView) this.findViewById(R.id.drawer_listview);
		drawerList.setAdapter(new DrawerAdapter(this));
		drawerList.setOnItemClickListener(new DrawerOnItemClickListener());

		// Insert Main Fragment.
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, new MainFragment())
				.commit();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			showSettingsFragment();
		}

		return super.onOptionsItemSelected(item);
	}

	public void showSettingsFragment()
	{
		SettingsFragment settingsFragment = (SettingsFragment)
				getSupportFragmentManager().findFragmentByTag("SETTINGS_FRAGMENT");

		if (settingsFragment != null && settingsFragment.isVisible())
		{
			return;
		}

		getSupportActionBar().setTitle("Settings");
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, new SettingsFragment(), "SETTINGS_FRAGMENT")
				.addToBackStack(null)
				.commit();

	}
}
