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
	
	
	public Twitteruser getProfile(String username){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Twitteruser usr = null;
		
		try {
			String sql = "select u from Twitteruser u where u.username = :username";
			TypedQuery<Twitteruser> q = em.createQuery(sql, Twitteruser.class);
			q.setParameter("username", username);
			
			usr = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return usr;
	}
	
	public Twitteruser getProfile(String username, String pwd){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Twitteruser usr = null;
		
		try {
			String sql = "select u from Twitteruser u where u.username = :username and u.pwd = :pwd";
			TypedQuery<Twitteruser> q = em.createQuery(sql, Twitteruser.class);
			q.setParameter("username", username);
			q.setParameter("pwd", pwd);
			
			usr = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return usr;
	}
}
