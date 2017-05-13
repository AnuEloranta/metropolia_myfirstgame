package com.anu.mygame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by Anu on 3.5.2017.
 */

public class StartGameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       this.requestWindowFeature(Window.FEATURE_NO_TITLE);

       DisplayMetrics dm = new DisplayMetrics();
       getWindowManager().getDefaultDisplay().getMetrics(dm);
       Constants.SCREEN_HEIGHT=dm.heightPixels;
       Constants.SCREEN_WIDTH=dm.widthPixels;


       setContentView(new GamePanel(this));
    }
}
