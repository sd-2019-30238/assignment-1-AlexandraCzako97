package model;

import java.sql.SQLException;

import CQRS.ReadModel.FindBook;

public class UnavailableDecorator extends Decorator{

	public UnavailableDecorator(ITarget target) {
		super(target);
	}
	
	@Override
	public void changeStatus(String title, String status) {
		changeBookStatus(title);
	}

	private void changeBookStatus(String title) {
		FindBook book=new FindBook();
		try {
			book.changeBookStatusToTaken(title);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
