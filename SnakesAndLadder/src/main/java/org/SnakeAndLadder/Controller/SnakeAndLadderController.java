package org.SnakeAndLadder.Controller;

import org.SnakeAndLadder.Service.SnakeAndLadderGame;
import org.SnakeAndLadder.Service.SnakeAndLadderService;

public class SnakeAndLadderController {

    private SnakeAndLadderGame Game;
    public SnakeAndLadderController() {
      Game = new SnakeAndLadderGame();
    }
    public void StartSnakeAndLadder() {
        Game.Start();
    }


}
