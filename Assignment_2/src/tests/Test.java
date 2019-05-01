package tests;

import java.sql.SQLException;

import dataAccess.DBconnector;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(DBconnector.getConnection());
	}

}
