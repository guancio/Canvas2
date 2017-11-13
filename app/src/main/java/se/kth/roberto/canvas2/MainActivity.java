package se.kth.roberto.canvas2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements OnBoardListener {

    private GameController gameController;
    private BoardView bw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mLinearLayout = new LinearLayout(this);

        // Instantiate our custom View and define its properties
        bw = new BoardView(this);
        bw.setOnBoardClickListener(this);
        gameController = new GameController();

        bw.setMarkerPos(gameController.gameInstance.playerPosX, 0);

        // Add the View to the layout and set the layout as the content view
        mLinearLayout.addView(bw);
        setContentView(mLinearLayout);
    }

    @Override
    public void onClick(int cellX, int cellY) {
        if (cellX == this.gameController.gameInstance.playerPosX)
            return;

        if (cellX < this.gameController.gameInstance.playerPosX)
            this.gameController.moveLeft();
        else
            this.gameController.moveRight();

        this.bw.setMarkerPos(
                this.gameController.gameInstance.playerPosX,
                0);
        this.bw.invalidate();
    }
}
