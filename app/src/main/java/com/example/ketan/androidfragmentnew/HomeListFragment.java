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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class HomeListFragment extends Fragment {

	View view;
	ListView listView;
	private ListAdapter adapter;
	private MyListFragmentListener listener;
	private FragmentManager fragmentManager;

	private ResultListFragment resultListFragment;
	public interface MyListFragmentListener {
		public void onItemClickedListener(String valueClicked);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.home_fragment, null);
		fragmentManager = getActivity().getSupportFragmentManager();
		initViews();

		return view;
	}

	public void registerForListener(MyListFragmentListener listener) {
		this.listener = listener;
	}

	private void initViews() {
		listView = (ListView) view.findViewById(R.id.listView1);

		adapter = listView.getAdapter();

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				

					FragmentTransaction ft = fragmentManager.beginTransaction();

					resultListFragment = new ResultListFragment();
				ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
					ft.add(R.id.container, resultListFragment);
					TextClass.fragmentStack.lastElement().onPause();
					ft.hide(TextClass.fragmentStack.lastElement());
					TextClass.fragmentStack.push(resultListFragment);
					ft.commit();

			}
		});
	}

}
