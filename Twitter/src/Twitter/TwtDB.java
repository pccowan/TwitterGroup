package Twitter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
	
	public boolean createNewUser(String username, String pwd){
		boolean isSuccess = false;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Twitteruser user = new Twitteruser();
		user.setPwd(pwd);
		user.setUsername(username);
		
		trans.begin();
		
		try{
			em.persist(user);
			trans.commit();
			isSuccess = true;
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}
		
		return isSuccess;
	}

	public ArrayList<Twitterfeed> PullProfile(String username) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Twitterfeed> fd = null;

		try {
			String sql = "select t from Twitterfeed t where t.username = :username";
			TypedQuery<Twitterfeed> results = em.createQuery(sql,
					Twitterfeed.class);
			results.setParameter("username", username);
			fd = results.getResultList();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return new ArrayList<Twitterfeed>(fd);
	}
	
	public boolean addFeed(String username, String post){
		boolean isSuccess = false;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Twitterfeed fd = new Twitterfeed();
		fd.setPost(post);
		fd.setUsername(username);
		fd.setPostDate(new Date());
		
		trans.begin();
		
		try{
			em.persist(fd);
			trans.commit();
			isSuccess = true;
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}
		
		return isSuccess;
	}
	
}

