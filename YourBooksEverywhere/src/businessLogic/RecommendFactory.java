package businessLogic;

public class RecommendFactory {
	public Recommend getOneRecommend(String reco){
		switch(reco) {
		case "Trends":
			return new RatingRecommend();
		case "Genre":
			return new GenreRecommend();
		}
		return null;
		
	}

}
