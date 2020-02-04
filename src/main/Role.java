package main;

public abstract class Role {
	
	private String roleName;
	private boolean required;
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public boolean getRequired() {
		return required;
	}
}
