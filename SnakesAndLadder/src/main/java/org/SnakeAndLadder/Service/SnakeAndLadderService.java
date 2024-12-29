package org.SnakeAndLadder.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderService {
    private final HashMap<Integer,Integer> Snake;
    private final HashMap<Integer,Integer> Ladder;
    private final Queue<Player> Players;
    public SnakeAndLadderService() {
            Snake=new HashMap<>();
            Ladder=new HashMap<>();
            Players=new LinkedList<>();
    }
    public void AddSnake(int x,int y){
        Snake.put(x,y);
    }
    public void AddLadder(int x,int y){
        Ladder.put(x,y);
    }
    public HashMap<Integer, Integer> getSnake() {
        return Snake;
    }
    public HashMap<Integer, Integer> getLadder() {
        return Ladder;
    }
    public Player getCurrentPlayer() {
        return Players.poll();
    }
    public void AddPlayer(String playerName){
        Player player=new Player(playerName);
        Players.add(player);
    }
    public boolean hasGameOver(Player player){
        return player.getCurrentPosition() >= 100;
    }

    public boolean hasLadder(int currentValue, Player currentPlayer) {
        if(Ladder.containsKey(currentValue+currentPlayer.CurrentPosition)){
            currentPlayer.CurrentPosition=Ladder.get(currentValue+currentPlayer.CurrentPosition);
            return true;
        }
        return false;
    }

    public boolean hasSnake(int currentValue, Player currentPlayer) {
        if(Snake.containsKey(currentValue+currentPlayer.CurrentPosition)){
            currentPlayer.CurrentPosition=Snake.get(currentValue+currentPlayer.CurrentPosition);
            return true;
        }
        return false;
    }

    public void AddExistingPlayer(Player currentPlayer) {
        Players.add(currentPlayer);
    }

    public void Print(int CurrentValue, Player CurrentPlayer, int OldPosition,String str) {
        System.out.println(CurrentValue+"  "+OldPosition);
        System.out.println("Player "+CurrentPlayer.getName()+" is Playing Dice value: "+
                CurrentValue+" currentPosition "+(OldPosition+CurrentValue)+" To new Position "
                +CurrentPlayer.getCurrentPosition()+str);
    }
}
