package main;

public abstract class Command {
	
	String name;
	Application app;
	
	public void setName(String command) {
		this.name = command;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setApplication(Application app) {
		this.app = app;
	}
	
	public Application getApplication() {
		return this.app;
	}
	
	public abstract boolean execute();
	
}
