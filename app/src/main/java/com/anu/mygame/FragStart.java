package com.anu.mygame;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Anu on 3.5.2017.
 */

public class FragStart extends Fragment {

    private Button startBtn;

    public FragStart() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View v = inflater.inflate(R.layout.frag_start, container, false);

        startBtn = (Button)v.findViewById(R.id.startGame);
        startBtn.setOnClickListener(new View.OnClickListener(){
            //on button click moves to StartGame activity that starts the game.
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), StartGameActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

}