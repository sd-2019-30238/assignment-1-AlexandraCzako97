package CQRS.WriteModel;

import model.Book;

public class AddBookCommand implements ICommand{
	private Book bookDetails;
	private String commandType;
	
	
	public AddBookCommand(Book bookDetails) {
		this.setBookDetails(bookDetails);
		this.setCommandType("addBook");
		
	}
	public Book getBookDetails() {
		return bookDetails;
	}
	
	public void setBookDetails(Book bookDetails) {
		this.bookDetails=bookDetails;
	}

	@Override
	public String getCommandType() {
		
		return commandType;
	}
	public void setCommandType(String commandType) {
		this.commandType=commandType;
	}

}
