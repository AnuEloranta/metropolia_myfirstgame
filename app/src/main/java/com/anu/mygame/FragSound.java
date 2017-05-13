package com.anu.mygame;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Anu on 3.5.2017.
 *
 * BG sound control
 */

public class FragSound extends Fragment {
    private MediaPlayer bgsound;
    private TextView tv;

    public FragSound() {
    }

    Switch soundSwitch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_sound, container, false);
        soundSwitch = (Switch)v.findViewById(R.id.soundToggle);
        tv=(TextView)v.findViewById(R.id.helpText);
        bgsound = MediaPlayer.create(getActivity(), R.raw.heavensings);
        //bgsound.setVolume((float) 0.1, (float)0.1);
        bgsound.setLooping(true);
        //bgsound.start();

        soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(soundSwitch.isChecked()){
                    bgsound.start();
                    tv.setText("is checked");

                }
                else {
                    //bgsound.release();
                    bgsound.pause();
                    tv.setText("is off");
                }
            }

        });

        return v;
    }
}




