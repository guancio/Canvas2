package se.kth.roberto.canvas2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by guancio on 13/11/2017.
 */

public class BoardView extends View {
    int markerPosX = 0;
    int markerPosY = 0;
    private OnBoardListener onBoardClickListener = null;

    public BoardView(Context context) {
        super(context);
    }

    public void setMarkerPos(int x, int y) {
        this.markerPosX = x;
        this.markerPosY = y;
    }

    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        Paint blackPaint = new Paint();
        Paint whitePaint = new Paint();
        whitePaint.setARGB(255, 255, 255, 255);
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                RectF rect = new RectF(width/8*i, height/8*j, width/8*(i+1), height/8*(j+1));
                if ((i+j)%2 == 0)
                    canvas.drawRect(rect, blackPaint);
                else
                    canvas.drawRect(rect, whitePaint);
            }
        }

        Paint redPaint = new Paint();
        redPaint.setARGB(255, 255, 0, 0);
        RectF rect = new RectF(
                width/8*markerPosX,
                height/8*markerPosY,
                width/8*(markerPosX+1),
                height/8*(markerPosY+1));
        canvas.drawRect(rect, redPaint);

    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            this.onBoardClickListener.onClick(
                    (int)(event.getX() / this.getWidth() * 8),
                    (int)(event.getY() / this.getHeight() * 8)
            );
            this.invalidate();
            return true;
        }
        return true;
    }

    public void setOnBoardClickListener(OnBoardListener listner) {
        this.onBoardClickListener = listner;
    }
}
