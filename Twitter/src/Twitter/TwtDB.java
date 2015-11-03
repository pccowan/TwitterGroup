package Twitter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Twitterfeed;


public class TwtDB {
	
	public ArrayList<Twitterfeed> getAllFeeds(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Twitterfeed> fd = null;
		
		try {
			String sql = "select t from Twitterfeed t";
			TypedQuery<Twitterfeed> results = em.createQuery(sql, Twitterfeed.class);
			
			fd = results.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Twitterfeed>(fd);
	}

}
