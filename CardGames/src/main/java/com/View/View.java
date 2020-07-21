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
		String name = keyboard.nextLine();
		
		if(name.isEmpty()) {
			controller.startGame(); 
		} else {
			controller.addPlayer(name);
		}
	}
	
	public void promtForFlip() {
		// TODO Auto-generated method stub
		
	}
	public void promptForNewGame() {
		// TODO Auto-generated method stub
		
	}
	public void showPlayerName(int size, String playerName) {
		// TODO Auto-generated method stub
		
	}
	public void showFaceDownCardForPlayer(int i, String name) {
		// TODO Auto-generated method stub
		
	}
	public void showCardForPlayer(int i, String name, String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	public void showWinner(String name) {
		// TODO Auto-generated method stub
		
	}
}
