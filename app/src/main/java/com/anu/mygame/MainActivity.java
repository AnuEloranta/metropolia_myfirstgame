package com.anu.mygame;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FragDiff fDiff;
    private FragLeader fLead;
    private FragStart fStart;
    private FragSound fSound;
    private ImageButton btnStart, btnLeader, btnSound, btnDiff;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDb = new DatabaseHelper(this);
        myDb.getAllData();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.main_activity);

        if(null==fDiff)
            fDiff= new FragDiff();
        if(null==fLead)
            fLead= new FragLeader();
        if(null==fStart)
            fStart= new FragStart();
        if (null==fSound)
            fSound= new FragSound();

        if (savedInstanceState==null){
            getFragmentManager().beginTransaction().add(R.id.fragContainer, fStart).commit();
        }

        btnStart = (ImageButton) findViewById(R.id.startGameV);
        btnDiff = (ImageButton) findViewById(R.id.difficultyLevelV);
        btnLeader = (ImageButton) findViewById(R.id.leaderBoardV);
        btnSound = (ImageButton) findViewById(R.id.soundOnOffV);

        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getFragmentManager().beginTransaction().replace(R.id.fragContainer, fStart).commit();
            }
        });

        btnLeader.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //getFragmentManager().beginTransaction().replace(R.id.fragContainer, fLead).commit();
                Cursor res = myDb.getAllData();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "ERROR: Nothing found!", Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name: " + res.getString(0) + " ");
                    buffer.append("Score: " + res.getString(1) + "\n");
                }
                showMessage("Data", buffer.toString());


            }
        });

        btnDiff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getFragmentManager().beginTransaction().replace(R.id.fragContainer, fDiff).commit();
            }
        });

        btnSound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getFragmentManager().beginTransaction().replace(R.id.fragContainer, fSound).commit();
            }
        });

    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
