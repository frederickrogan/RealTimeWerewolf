package main;

public class CommandRequiredFalse extends Command {

	public CommandRequiredFalse(Application app) {
		setName("False");
		setApplication(app);
	}
		
	@Override
	public boolean execute() {
		getApplication().game.players.getLast().setRequired(false);
		getApplication().commands.clear();
		
		getApplication().commands.add(new CommandAddPlayer(getApplication(), "Add Sheriff"));
		getApplication().commands.add(new CommandAddPlayer(getApplication(), "Add Investigator"));
		
		getApplication().commands.add(new CommandViewAddedRoles(getApplication()));
		getApplication().commands.add(new CommandMainMenu(getApplication()));
		
		return false;
	}

}
