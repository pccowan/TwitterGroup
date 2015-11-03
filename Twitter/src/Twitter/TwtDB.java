package Twitter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Twitterfeed;
import model.Twitteruser;


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
	
	public ArrayList<Twitteruser> getUserInfo(String username, String pwd){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Twitteruser> usr = null;
		
		try {
			String sql = "select u from Twitteruser u where u.username = :username and u.pwd = :pwd";
			TypedQuery<Twitteruser> q = em.createQuery(sql, Twitteruser.class);
			q.setParameter("username", username);
			q.setParameter("pwd", pwd);
			
			usr = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Twitteruser>(usr);
	}
}
