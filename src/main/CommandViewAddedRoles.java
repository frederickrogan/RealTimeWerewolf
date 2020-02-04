package main;

public class CommandViewAddedRoles extends Command {

	public CommandViewAddedRoles(Application app) {
		setName("View added roles");
		setApplication(app);
	}
	
	@Override
	public boolean execute() {
		getApplication().commands.clear();
		
		for(int i = 0; i < getApplication().game.players.size(); i++) {
			String roleName = getApplication().game.players.get(i).getRoleName();
			String required = ""; 
			if(getApplication().game.players.get(i).getRequired()) {
				required = "required";
			} else {
				required = "not required";
			}
			getApplication().commands.add(new CommandRemovePlayer(getApplication(), "Remove " + roleName + " (" + required + ")"));
		}
		
		getApplication().commands.add(new CommandNewGameMenu(getApplication()));
		getApplication().commands.add(new CommandStartGame(getApplication()));
		return true;
	}
	
}
