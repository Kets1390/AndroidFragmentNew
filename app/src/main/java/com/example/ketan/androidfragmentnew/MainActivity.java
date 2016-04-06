/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ketan.androidfragmentnew;

import java.util.Stack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ketan.androidfragmentnew.HomeListFragment.MyListFragmentListener;

public class MainActivity extends AppCompatActivity
		 {


	private FragmentManager fragmentManager;
	private HomeListFragment homeListFragment;
	private ResultListFragment resultListFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextClass.fragmentStack.clear();

		homeListFragment = new HomeListFragment();
		//homeListFragment.registerForListener(this);

		fragmentManager = getSupportFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.add(R.id.container, homeListFragment);
		TextClass.fragmentStack.push(homeListFragment);
		ft.commit();
	}

	/*@Override
	public void onItemClickedListener(String valueClicked) {
		Toast.makeText(this, valueClicked, Toast.LENGTH_LONG).show();

		FragmentTransaction ft = fragmentManager.beginTransaction();

		resultListFragment = new ResultListFragment();
		ft.add(R.id.container, resultListFragment);
		TextClass.fragmentStack.lastElement().onPause();
		ft.hide(TextClass.fragmentStack.lastElement());
		TextClass.fragmentStack.push(resultListFragment);
		ft.commit();
	}*/

	@Override
	public void onBackPressed() {

		if (TextClass.fragmentStack.size() !=1) {
			FragmentTransaction ft = fragmentManager.beginTransaction();
			ft.setCustomAnimations(R.anim.back_exit, R.anim.back_enter,R.anim.back_pop_exit , R.anim.back_pop_enter);
			TextClass.fragmentStack.lastElement().onPause();
			ft.remove(TextClass.fragmentStack.pop());
			TextClass.fragmentStack.lastElement().onResume();
			ft.show(TextClass.fragmentStack.lastElement());
			ft.commit();
		} else {
			super.onBackPressed();
		}
	}

			 @Override
			 public boolean onCreateOptionsMenu(Menu menu) {
				 getMenuInflater().inflate(R.menu.main_menu,menu);
				 return super.onCreateOptionsMenu(menu);
			 }

			 @Override
			 public boolean onOptionsItemSelected(MenuItem item) {

				 FragmentTransaction ft = fragmentManager.beginTransaction();

				 Add_Data_Fragment resultListFragment = new Add_Data_Fragment();
				 ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
				 ft.add(R.id.container, resultListFragment);
				 TextClass.fragmentStack.lastElement().onPause();
				 ft.hide(TextClass.fragmentStack.lastElement());
				 TextClass.fragmentStack.push(resultListFragment);
				 ft.commit();
				 return true;
			 }
		 }
