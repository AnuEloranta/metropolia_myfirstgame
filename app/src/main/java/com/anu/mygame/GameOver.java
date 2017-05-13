package com.anu.mygame;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Anu on 8.5.2017.
 */

public class GameOver extends Activity {

    EditText addName;
    TextView labelScore, score, labelName;
    Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.game_over_window);


        addName = (EditText)findViewById(R.id.nameTag);
        labelScore = (TextView)findViewById(R.id.labelScoreTag);
        score=(TextView)findViewById(R.id.ScoreTag);
        labelName=(TextView)findViewById(R.id.labelNameTag);
        okBtn=(Button)findViewById(R.id.addDataBtn);
    }
}
