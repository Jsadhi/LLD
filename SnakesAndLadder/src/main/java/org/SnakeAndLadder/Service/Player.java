package org.SnakeAndLadder.Service;

public class Player {
    String name;
    int CurrentPosition;

    public Player(String name) {
        this.name = name;
        CurrentPosition =1;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return CurrentPosition;
    }
}
