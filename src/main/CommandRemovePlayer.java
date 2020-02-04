package main;

import java.util.LinkedList;

public class CommandRemovePlayer extends Command {
	
	LinkedList<Role> roles;

	public CommandRemovePlayer(Application app, String command) {
		setName(command);
		setApplication(app);
		
		roles = new LinkedList<Role>();
		roles.add(new Sheriff());
		roles.add(new Investigator());
	}
	
	@Override
	public boolean execute() {
		String roleName = name.substring(7, (getName().indexOf("(")) - 1);
		
		
		for(int i = 0; i < getApplication().game.players.size(); i++) {
			boolean correctRole = getApplication().game.players.get(i).getRoleName().equals(roleName);
			String required;
			if(getApplication().game.players.get(i).getRequired()) {
				required = "required";
			} else {
				required = "not required";
			}
			boolean correctRequired = required.equals(getName().substring(getName().indexOf("(") + 1, getName().indexOf(")")));
			if(correctRole && correctRequired) {
				getApplication().game.players.remove(i);
				break;
			}
		}
		
		getApplication().commands.clear();
		
		for(int i = 0; i < getApplication().game.players.size(); i++) {
			roleName = getApplication().game.players.get(i).getRoleName();
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
		
		return false;
	}

}
