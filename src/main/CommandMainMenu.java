package main;

public class CommandMainMenu extends Command {
	
	public CommandMainMenu(Application app) {
		setName("Main Menu");
		setApplication(app);
	}
	
	@Override
	public boolean execute() {
		getApplication().commands.clear();
		getApplication().commands.add(new CommandLoadGame(getApplication()));
		getApplication().commands.add(new CommandNewGame(getApplication()));
		getApplication().commands.add(new CommandExit(getApplication()));
		return false;
	}

}
