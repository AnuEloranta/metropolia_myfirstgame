package com.anu.mygame;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Anu on 3.5.2017.
 *
 * Fragment that controls the difficulty level
 */

public class FragDiff extends Fragment{
    Button easyBtn, mediumBtn, hardBtn;
    TextView exp;


    public FragDiff(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View v = inflater.inflate(R.layout.frag_difficulty, container, false);

        easyBtn = (Button)v.findViewById(R.id.easy);
        mediumBtn = (Button)v.findViewById(R.id.medium);
        hardBtn = (Button)v.findViewById(R.id.hard);
        exp = (TextView)v.findViewById(R.id.diffExpl);

        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.OBSTACLEGAP = 1500;
                Constants.PLAYERGAP = 600;
                exp.setText(R.string.diff_easy_text);
            }
        });

        mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.OBSTACLEGAP = 700;
                Constants.PLAYERGAP = 400;
                exp.setText(R.string.diff_medium_text);

            }
        });

        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.OBSTACLEGAP = 350;
                Constants.PLAYERGAP = 200;
                exp.setText(R.string.diff_hard_text);
            }
        });


        return v;
    }

}
