package CQRS.WriteModel;


import model.User;

public class AddUserCommand implements ICommand {
	private User userDetails;
	private String commandType;
	
	
	public AddUserCommand(User userDetails) {
		this.setUserDetails(userDetails);
		this.setCommandType("addUser");
		
	}
	public User getUserDetails() {
		return userDetails;
	}
	
	public void setUserDetails(User userDetails) {
		this.userDetails=userDetails;
	}

	@Override
	public String getCommandType() {
		
		return commandType;
	}
	public void setCommandType(String commandType) {
		this.commandType=commandType;
	}

}
