package main;

public class CommandNewGameMenu extends Command {
	
	public CommandNewGameMenu(Application app) {
		setName("Add Roles");
		setApplication(app);
	}

	@Override
	public boolean execute() {
		getApplication().commands.clear();
		
		getApplication().commands.add(new CommandAddPlayer(getApplication(), "Add Sheriff"));
		getApplication().commands.add(new CommandAddPlayer(getApplication(), "Add Investigator"));
		
		getApplication().commands.add(new CommandViewAddedRoles(getApplication()));
		getApplication().commands.add(new CommandMainMenu(getApplication()));
		return true;
	}
}
