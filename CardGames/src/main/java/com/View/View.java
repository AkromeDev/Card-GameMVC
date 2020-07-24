package com.View;

import java.util.Scanner;

import com.Controller.GameController;

public class View {
	
	GameController controller;
	Scanner keyboard = new Scanner(System.in);
	
	public void setController(GameController gc) {
		controller = gc;
	}
	
	public void promptForPlayerName() {
		System.out.println("Enter the name of the player:");
		String name = keyboard.nextLine();
		
		if(name.isEmpty()) {
			controller.startGame(); 
		} else {
			controller.addPlayer(name);
			System.out.println("(Press enter a second time to begin the game)");
		}
	}
	
	public void promtForFlip() {
		System.out.println("Press enter to see the cards.");
		keyboard.nextLine();
		controller.flipCards();
	}
	
	public void promptForNewGame() {
		System.out.println("Press enter to begin a new game.");
		keyboard.hasNextLine();
		controller.startGame();
	}
	public void showPlayerName(int index, String playerName) {
		System.out.println("Player " + index + ": " + playerName );
		
	}
	public void showFaceDownCardForPlayer(int index, String name) {
		System.out.println("Player " + index + ": " + name + " [][]");
		
	}
	public void showCardForPlayer(int index, String name, String rank, String suit) {
		System.out.println("Player " + index + ": " + name + " [" + rank + "]" + "[" + suit + "]");
		
	}
	public void showWinner(String name) {
		System.out.println("And the winner is...... " + name + "!!!!");
	}
}
