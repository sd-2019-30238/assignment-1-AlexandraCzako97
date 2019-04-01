package businessLogic;

import java.sql.SQLException;


import dao.BookDao;

public class RatingRecommend implements Recommend{

	@Override
	public String returnRecommend() throws ClassNotFoundException, SQLException {
		BookDao bdao= new BookDao();
		return bdao.getRecommendRating();
		
		
	}
	

}
