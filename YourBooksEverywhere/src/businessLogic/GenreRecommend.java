package businessLogic;

import java.sql.SQLException;

import dao.BookDao;

public class GenreRecommend implements Recommend{

	@Override
	public String returnRecommend() throws ClassNotFoundException, SQLException {
		BookDao bdao= new BookDao();
		return bdao.getRecommendGender();
	}

}
