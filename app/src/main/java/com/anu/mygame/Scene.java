package com.anu.mygame;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by Anu on 6.5.2017.
 */

public interface Scene {
    public void update();
    public void draw(Canvas canvas);
    public void terminate();
    public void receiveTouch(MotionEvent event);
}
