package main;

import java.util.LinkedList;

public class CommandAddPlayer extends Command {
	
	LinkedList<Role> roles;
	
	public CommandAddPlayer(Application app, String command) {
		setName(command);
		setApplication(app);
		
		roles = new LinkedList<Role>();
		roles.add(new Sheriff());
		roles.add(new Investigator());
	}
	
	@Override
	public boolean execute() {
		String roleName = "";
		for(int i = 0; i < roles.size(); i++) {
			if(roles.get(i).getRoleName().equals(getName().substring(4))) {
				roleName = roles.get(i).getRoleName();
				getApplication().game.players.add(roles.get(i));
				break;
			}
		}
		
		System.out.println("Is " + roleName + " required?");
		
		getApplication().commands.clear();
		getApplication().commands.add(new CommandRequiredTrue(getApplication()));
		getApplication().commands.add(new CommandRequiredFalse(getApplication()));
		
		return true;
	}

}
