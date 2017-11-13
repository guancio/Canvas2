package se.kth.roberto.canvas2;

/**
 * Created by guancio on 13/11/2017.
 */

public class GameController {
    GameModel gameInstance;

    public GameController() {
        gameInstance = new GameModel();
        gameInstance.playerPosX = 2;
    }

    public void moveRight() {
        gameInstance.playerPosX++;
    }
    public void moveLeft() {
        gameInstance.playerPosX--;
    }
}
