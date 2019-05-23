package model;

import java.sql.SQLException;

public interface Observer {
	void next(String title) throws ClassNotFoundException, SQLException;
}
