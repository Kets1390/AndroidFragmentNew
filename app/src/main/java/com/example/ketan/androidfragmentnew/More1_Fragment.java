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
import android.widget.Toast;

/**
 * Created by Ketan on 4/5/2016.
 */
public class More1_Fragment extends Fragment {
    View view;

    ListView listView;

    private ListAdapter adapter;
    private FragmentManager fragmentManager;

    private More2_Fragment resultListFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.more1_fragment, null);
        fragmentManager = getActivity().getSupportFragmentManager();
        initViews();

        return view;
    }

    private void initViews() {
        listView = (ListView) view.findViewById(R.id.listView1);

        adapter = listView.getAdapter();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(),
                        adapter.getItem(position).toString(), Toast.LENGTH_LONG)
                        .show();
                FragmentTransaction ft = fragmentManager.beginTransaction();

                resultListFragment = new More2_Fragment();
                ft.add(R.id.container, resultListFragment);
                TextClass.fragmentStack.lastElement().onPause();
                ft.hide(TextClass.fragmentStack.lastElement());
                TextClass.fragmentStack.push(resultListFragment);
                ft.commit();

            }
        });
    }

}
