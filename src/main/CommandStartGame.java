package main;

public class CommandStartGame extends Command {
	
	public CommandStartGame(Application app) {
		setName("Start Game");
		setApplication(app);
	}
	
	@Override
	public boolean execute() {
		getApplication().commands.clear();
		getApplication().inGame = true;
		return false;
	}

}
