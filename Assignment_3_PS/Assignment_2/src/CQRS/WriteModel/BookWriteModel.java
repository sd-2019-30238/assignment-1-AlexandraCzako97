package CQRS.WriteModel;

import CQRS.Handlers.AddBookHandler;
import CQRS.Handlers.IHandler;
import model.Book;
import model.Mediator;

public class BookWriteModel {
	private Mediator mediator;
	
	public BookWriteModel(Mediator mediator) {
		this.setMediator(mediator);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public String addBook(Book book)
	{
		ICommand command = new AddBookCommand(book);
		IHandler handler = new AddBookHandler();
		mediator.registerHandler(handler);
		return mediator.handle(command);
	}

}
