package model;

import java.sql.SQLException;

import CQRS.ReadModel.FindBook;

public class OwnedDecorator extends Decorator{

	public OwnedDecorator(ITarget target) {
		super(target);
	}
	
	@Override
	public void changeStatus(String title, String status) {
		changeBookStatus(title);
	}

	private void changeBookStatus(String title) {
		FindBook book=new FindBook();
		try {
			book.changeBookStatusToFree(title);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
