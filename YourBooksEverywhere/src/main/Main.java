package main;

import java.sql.SQLException;

import dao.DBconnector;

public class Main {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		DBconnector connect = new DBconnector();
		connect.getConnection();
	}

}
