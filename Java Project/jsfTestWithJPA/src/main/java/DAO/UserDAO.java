package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import DAOInterfaces.IUserDAO;
import Singleton.ConEntityManager;
import beans.UserBean;
import entities.User;

@Component
public class UserDAO implements IUserDAO {

	// change the entityManager (check teacher example);
	// class conEntityManager;
	ConEntityManager cem = new ConEntityManager();
	EntityManager entityManager;
	EntityTransaction transaction;

	// CONSTRUCTOR ----------------------------

	public UserDAO() {
		this.entityManager = cem.getEntityManagerFactory().createEntityManager();
	}

	// METHODS --------------------------------

	// TO LOAD INFO FROM THE CONSTRUCTOR, THE METHOD IS STATIC
	public List<UserBean> getListUserTabe() {
		try {
			TypedQuery<UserBean> query = entityManager.createQuery("select u from Users u", UserBean.class);
			return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getCause());
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public UserBean getUserByEmail(User user) {
		try {
			TypedQuery<UserBean> query = entityManager.createQuery(
					"select u from Users u WHERE u.email = :email and u.password = :password", UserBean.class);
			// .getSingleResult() is a JPA Query
			UserBean userBean = query.setParameter("email", user.getEmail())
					.setParameter("password", user.getPassword()).getSingleResult();
			user.setUserType(userBean.getUserType());
			return userBean;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			user.setErrorLogin(true);
			user.setErrorMessage("Error creating user. Please try again later!");
			return null;
		}
	}

	public UserBean checkIfUserExistsByEmail(User user) {
		try {
			TypedQuery<UserBean> query = entityManager.createQuery("select u from Users u WHERE u.email = :email",
					UserBean.class);
			UserBean userBean = query.setParameter("email", user.getEmail()).getSingleResult();
			return userBean;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public boolean createUser(User user) {
		try {

			// PROPERTIES FROM LIBRARY

			transaction = entityManager.getTransaction();
			transaction.begin();

			// CREATING NEW USER CORRESPONDING WITH PROPERTIES DEFINED AT USERBEAN

			UserBean userBean = new UserBean();
			userBean.setUserName(user.getUserName());
			userBean.setUserLastName(user.getUserLastName());
			userBean.setEmail(user.getEmail());
			userBean.setUserType(user.getUserType());
			userBean.setPassword(user.getPassword());

			entityManager.persist(userBean);
			transaction.commit();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			user.setErrorLogin(true);
			user.setErrorMessage("Error creating user. Please try again later!");
			return false;
		}
	}

}
