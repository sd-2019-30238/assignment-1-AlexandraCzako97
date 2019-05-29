package CQRS.Handlers;

import CQRS.WriteModel.ICommand;

public interface IHandler {
	public String handler(ICommand command);
	public String getCommandType();

}
