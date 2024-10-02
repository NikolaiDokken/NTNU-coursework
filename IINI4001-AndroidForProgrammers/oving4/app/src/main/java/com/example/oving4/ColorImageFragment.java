package com.example.oving4;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorImageFragment extends Fragment {

    private long id;

    public void setID(long id){
        this.id = id;
    }

    public long getID(){
        return id;
    }

    public ColorImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null){
            id = savedInstanceState.getLong("id");
        }

        return inflater.inflate(R.layout.fragment_tele_image, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View v = getView();
        if (v != null){
            ImageView im = (ImageView) getView().findViewById(R.id.imageView);
            TextView teleText = (TextView) getView().findViewById(R.id.textView);
            String[] colors = getResources().getStringArray(R.array.Colors);
            switch ((int)id) {
                case 0:
                    im.setImageResource(R.drawable.red);
                    break;
                case 1:
                    im.setImageResource(R.drawable.blue);
                    break;
                case 2:
                    im.setImageResource(R.drawable.green);
                    break;
                default:
                    im.setImageResource(R.drawable.colors);
                    break;
            }
            teleText.setText(colors[(int)id]);
        }
    }
}