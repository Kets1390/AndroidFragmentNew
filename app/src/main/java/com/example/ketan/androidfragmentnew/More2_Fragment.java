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
public class More2_Fragment extends Fragment {
    View view;

    ListView listView;

    private ListAdapter adapter;
    private FragmentManager fragmentManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.more2_fragment, null);

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


            }
        });
    }

}
