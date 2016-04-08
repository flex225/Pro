package com.yantur.pro;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artur on 4/4/2016.
 */
public class MyView extends View {

    private Bitmap currentBitmap = null;
    private List<Bitmap> bitmaps;
    private float touchX = 0, touchY = 0;

    public MyView(Context context) {
        super(context);
        bitmaps = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // if (bitmaps != null) {
        for (Bitmap currentBitmap : bitmaps) {
            canvas.drawBitmap(currentBitmap, touchX, touchY, null);
        }
        //  }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = event.getX();
        touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (currentBitmap != null) {
                    bitmaps.add(currentBitmap);
                    invalidate();
                }
                break;
        }
        return false;
    }

    public Bitmap getCurrentBitmap() {
        return currentBitmap;
    }

    public void setCurrentBitmap(Bitmap currentBitmap) {
        this.currentBitmap = currentBitmap;
    }
}
