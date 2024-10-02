package com.example.oving4;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.ListFragment;

public class ColorListFragment extends androidx.fragment.app.ListFragment {

    private TeleListListener listener;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.listener = (TeleListListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listener != null){
            listener.itemClicked(id);
        }
        super.onListItemClick(l, v, position, id);
    }

    public ColorListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] colors = getResources().getStringArray(R.array.Colors);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, colors);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    static interface TeleListListener{
        void itemClicked(long id);
    }
}