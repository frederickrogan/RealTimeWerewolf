package main;

import java.util.LinkedList;
import java.util.Random;

public class Game {
	
	String name;
	LinkedList<Role> players;
	
	public Game() {
		name = Integer.toString(new Random().nextInt(1000000));
		players = new LinkedList<Role>();
	}
}
