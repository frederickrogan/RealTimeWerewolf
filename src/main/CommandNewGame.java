package main;

public class CommandNewGame extends Command {
	
	public CommandNewGame(Application app) {
		setName("New Game");
		setApplication(app);
	}

	@Override
	public boolean execute() {
		System.out.println("New Game\n");
		
		getApplication().game = new Game();
		getApplication().commands.clear();
		
		getApplication().commands.add(new CommandAddPlayer(getApplication(), "Add Sheriff"));
		getApplication().commands.add(new CommandAddPlayer(getApplication(), "Add Investigator"));
		
		getApplication().commands.add(new CommandViewAddedRoles(getApplication()));
		getApplication().commands.add(new CommandMainMenu(getApplication()));
		return true;
	}

}
