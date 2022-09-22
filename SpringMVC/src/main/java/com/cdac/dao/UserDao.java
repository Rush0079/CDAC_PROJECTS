package com.cdac.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdac.entity.Funds;
import com.cdac.entity.User;
import java.sql.CallableStatement;

@Component
public class UserDao {
	
	@Autowired
	private DataSource dataSource;
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void add(User user) {
		em.persist(user);
	}
	
	public boolean isUserPresent(String aadharno) {
		Query query = (Query) em.createQuery("select count(u) from User u where u.aadharno = :aan");
		 query.setParameter("aan",aadharno);
		 Long count = (Long)query.getSingleResult();
		 if(count == 1)
			 return true;
		 return false;
	}
	
	
	public boolean isUserPresent(String username, String password) {
		Query query = (Query) em.createQuery("select count(u) from User u where u.username = :un and u.password = :pd");
		 query.setParameter("un",username);
		 query.setParameter("pd",password);
		 Long count = (Long)query.getSingleResult();
		 if(count == 1)
			 return true;
		 return false;
	}
	
	public User fetch(String username,String password) {
		Query query = (Query) em.createQuery("select u from User u where u.username = :un and u.password = :pd");
		 query.setParameter("un",username);
		 query.setParameter("pd",password);
		 User user = (User)query.getSingleResult();
		 return user;
	}
	
	public boolean isAdminPresent(String username, String password) {
		Query query = (Query) em.createQuery("select count(a) from Admin a where a.username = :un and a.password = :pd");
		 query.setParameter("un",username);
		 query.setParameter("pd",password);
		 Long count = (Long)query.getSingleResult();
		 if(count == 1)
			 return true;
		 return false;
	}
	
	public boolean isUserPresent2(String username) {
		Query query = (Query) em.createQuery("select count(u) from User u where u.username = :un");
		 query.setParameter("un",username);
		 Long count = (Long)query.getSingleResult();
		 if(count == 1)
			 return true;
		 return false;
	}
	
	
	@Transactional
	public boolean remove(String username) {
		Query query = (Query) em.createQuery("select u from User u where u.username = :un");
		 query.setParameter("un",username);
		User user = (User)query.getSingleResult();
		em.remove(user);
		return true;
	}
	
	public boolean isUserPresent3(String mobno) {
		Query query = (Query) em.createQuery("select count(f) from Funds f where f.mobno = :mn");
		 query.setParameter("mn",mobno);
		// em.find(Funds.class, mobno);
		 Long count = (Long)query.getSingleResult();
		 if(count == 1) {
			 return true;
	}
		 return false;
	}
	
	public boolean isUserPresent4(String aadharno) {
		Query query = (Query) em.createQuery("select count(u) from User u where u.aadharno = :an");
		 query.setParameter("an",aadharno);
		 Long count = (Long)query.getSingleResult();
		 if(count == 1)
			 return true;
		 return false;
	}
	
	public void balupdate(String mobno, int amount) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			CallableStatement st = conn.prepareCall("{ call recharge(?, ?) }");
			st.setString(1, mobno);
			st.setInt(2, amount);
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}				
	}
	
	@Transactional
	public boolean update(User newuser) {
		
		em.merge(newuser);
		return true;
	}
	
	public boolean isWalletPresent(String mobno) {
		Query query = (Query) em.createQuery("select count(w) from Wallet w where w.mobno = :mn");
		 query.setParameter("mn",mobno);
		// em.find(Funds.class, mobno);
		 Long count = (Long)query.getSingleResult();
		 if(count == 1) {
			 return true;
	}
		 return false;
	}
	
	
	public void walupdate(String mobno, int amount) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			CallableStatement st = conn.prepareCall("{ call addInWallet(?, ?) }");
			st.setString(1, mobno);
			st.setInt(2, amount);
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}				
	}
	
	public boolean transfer(String mobno1, String mobno2, int amount) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			CallableStatement st = conn.prepareCall("{ call upiUpdate(?, ?, ?) }");
			st.setString(1, mobno1);
			st.setString(2, mobno2);
			st.setInt(3, amount);
			
			st.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}				
		
	}
	
	public List<User> fetchAll(){
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	
	
}
