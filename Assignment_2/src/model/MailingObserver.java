package model;

import java.sql.SQLException;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dataAccess.AdminDao;

public class MailingObserver implements Observer {

	@Override
	public void next(String title) throws ClassNotFoundException, SQLException {
		AdminDao d = new AdminDao();
		
		String email = d.getEmail(title);
		d.searchWaitingList(email);
		System.out.println(" "+email);
		//System.out.println("Am primit notificare: " + title + " " + status+" "+email);


	}
		
}


