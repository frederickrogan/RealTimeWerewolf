package main;

public class CommandExit extends Command {
	
	public CommandExit(Application app) {
		setName("Exit");
		setApplication(app);
	}
	
	@Override
	public boolean execute() {
		System.out.println("Exitting");
		System.exit(0);
		return true;
	}

}
