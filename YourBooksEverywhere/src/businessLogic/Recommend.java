package businessLogic;

import java.sql.SQLException;

public interface Recommend {
	String returnRecommend() throws ClassNotFoundException, SQLException;

}
