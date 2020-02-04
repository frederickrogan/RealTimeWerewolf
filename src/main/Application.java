package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	
	public Scanner in;
	ArrayList<Command> commands;
	Game game;
	boolean inGame;
	
	private Application() {
		in = new Scanner(System.in);
		inGame = false;
		commands = new ArrayList<Command>();
		commands.add(new CommandLoadGame(this));
		commands.add(new CommandNewGame(this));
		commands.add(new CommandExit(this));
	}
	
	private void printCommands() {
		System.out.println("   Commands\n"
				+ "   --------");
		for(int i = 0; i < commands.size(); i++) {
			System.out.println("   " + i + ": " + commands.get(i).getName());
		}
		System.out.println();
	}
	
	private boolean getInput() {
		String input = in.next().strip();
		boolean validInput = true;
		
		// check input is an integer
		for(int i = 0; i < input.length(); i++) {
			if("0123456789".indexOf(input.charAt(i)) == -1) {
				validInput = false;
			}
		}
		
		// check input has a corresponding command
		if(validInput) {
			int commandNumber = Integer.parseInt(input);
			if(commandNumber < 0 || commandNumber >= commands.size()) {
				validInput = false;
			}
		}
		
		if(validInput) {
			commands.get(Integer.parseInt(input)).execute();
			return true;
		} else {
			System.out.println("Invalid input. Please enter a number between 0 and " + (commands.size() - 1));
			return false;
		}
	}
	
	public static void main (String args[]) {
		Application app = new Application();
		
		System.out.println("Welcome to Real Time Werewolf\n"
				+ "=============================\n");
		
		while(!app.inGame) {
			app.printCommands();
			boolean validInput = false;
			while(!validInput) {
				validInput = app.getInput();
			}
		}
	}
	
}
