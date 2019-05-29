package model;

import java.util.ArrayList;
import java.util.List;

import CQRS.Handlers.IHandler;
import CQRS.WriteModel.ICommand;

public class Mediator {
	public List<IHandler> handlers;
	
	public Mediator() {
		handlers=new ArrayList<IHandler>();
	}
	
	public void registerHandler(IHandler handler) {
		handlers.add(handler); 
	}
	
	public String handle(ICommand command) {
		String type=command.getCommandType();
		String result = null;
		for(IHandler h:handlers) {
			if(h.getCommandType().equals(type)) {
				result=h.handler(command);
			}
		}
		return result;
	}

}
