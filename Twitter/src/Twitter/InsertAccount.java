package Twitter;


import javax.persistence.*;

import model.Twitteruser;

 

public class InsertAccount {

public static void insertUN(Twitteruser tu) {
EntityManager em = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = em.getTransaction();

trans.begin(); 
try {
em.persist(tu);

trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
em.close();
}

}
}

/*public static void insertPwd(Twitteruser pwd) {
EntityManager em = DBUtil.getEmFactory().createEntityManager();
EntityTransaction trans = em.getTransaction();
trans.begin(); 
try {
em.persist(pwd);
trans.commit();
} catch (Exception e) {
System.out.println(e);
trans.rollback();
} finally {
em.close();
}
}
}
*/

