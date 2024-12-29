package org.SnakeAndLadder.Service;

import java.util.Scanner;

public class SnakeAndLadderGame {
    private final SnakeAndLadderService snakeAndLadderService;
    private final Dice dice;
    public SnakeAndLadderGame() {
        snakeAndLadderService = new SnakeAndLadderService();
        dice= new Dice();
    }
    public void Start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snake and Ladder Game!");
        System.out.print("Enter the number of Snakes: ");
        int numberOfSnakes = scanner.nextInt();
        for (int i = 1; i <=numberOfSnakes; i++) {
            System.out.print("Enter the Starting point of " + "Snake " + i + ": ");
            int startingPoint = scanner.nextInt();
            System.out.print("Enter the Ending point of " + "Snake " + i + ": ");
            int endingPoint = scanner.nextInt();
            snakeAndLadderService.AddSnake(startingPoint, endingPoint);
        }
        System.out.print("Enter the number of Ladders: ");
        int numberOfLadders = scanner.nextInt();
        for (int i = 1; i <=numberOfLadders; i++) {
            System.out.print("Enter the Starting point of " + "Ladder " + i + ": ");
            int startingPoint = scanner.nextInt();
            System.out.print("Enter the Ending point of " + "Ladder " + i + ": ");
            int endingPoint = scanner.nextInt();
            snakeAndLadderService.AddLadder(startingPoint, endingPoint);
        }
        scanner.nextLine();
        System.out.println("Please enter the number of players you would like to play: ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();
        for (int Player = 1; Player <=numberOfPlayers; Player++) {
            System.out.println("Please Enter the Name of the Player: "+Player);
            String playerName = scanner.nextLine();
            snakeAndLadderService.AddPlayer(playerName);
        }
        System.out.println("Let's play!");
        while (true) {
            Player CurrentPlayer = snakeAndLadderService.getCurrentPlayer();
            int OldPosition=CurrentPlayer.getCurrentPosition();
            int CurrentValue=dice.roll();
            String str="";
            if (snakeAndLadderService.hasLadder(CurrentValue,CurrentPlayer)) {
                str=" Got Ladder";
            }
            else if (snakeAndLadderService.hasSnake(CurrentValue,CurrentPlayer)) {
               str=" Got Snake";
            }
            else
            {
                CurrentPlayer.CurrentPosition+=CurrentValue;
            }
            if(snakeAndLadderService.hasGameOver(CurrentPlayer))
            {
                System.out.println("Player "+CurrentPlayer.getName()+" won the game!");
                break;
            }
            else
            {
                snakeAndLadderService.AddExistingPlayer(CurrentPlayer);
            }
            snakeAndLadderService.Print(CurrentValue,CurrentPlayer,OldPosition,str);



        }
        System.out.println("Game Over!");
    }

}
