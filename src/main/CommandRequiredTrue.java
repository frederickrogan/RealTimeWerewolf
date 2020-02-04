package main;

public class CommandRequiredTrue extends Command {
	
	public CommandRequiredTrue(Application app) {
		setName("True");
		setApplication(app);
	}
		
	@Override
	public boolean execute() {
		getApplication().game.players.getLast().setRequired(true);
		getApplication().commands.clear();
		
		getApplication().commands.add(new CommandAddPlayer(getApplication(), "Add Sheriff"));
		getApplication().commands.add(new CommandAddPlayer(getApplication(), "Add Investigator"));
		
		getApplication().commands.add(new CommandViewAddedRoles(getApplication()));
		getApplication().commands.add(new CommandMainMenu(getApplication()));
		
		return false;
	}

}
