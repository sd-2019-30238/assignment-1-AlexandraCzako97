package CQRS.WriteModel;

import CQRS.Handlers.AddBookHandler;
import CQRS.Handlers.AddUserHandler;
import CQRS.Handlers.IHandler;

import model.Mediator;
import model.User;

public class UserWriteModel {
private Mediator mediator;
	
	public UserWriteModel(Mediator mediator) {
		this.setMediator(mediator);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public String addUser(User user)
	{
		ICommand command = new AddUserCommand(user);
		IHandler handler = new AddUserHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}

}
