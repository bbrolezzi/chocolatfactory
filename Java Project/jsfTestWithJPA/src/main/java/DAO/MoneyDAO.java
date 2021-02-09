package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import DAOInterfaces.IMoneyDAO;
import Singleton.ConEntityManager;
import beans.MoneyBean;
import entities.Money;

public class MoneyDAO implements IMoneyDAO {

	ConEntityManager cem = new ConEntityManager();
	EntityManager entityManager;

	public MoneyDAO() {
		this.entityManager = cem.getEntityManagerFactory().createEntityManager();
	}

	public List<MoneyBean> getListMoneyTabe() {
		try {
			TypedQuery<MoneyBean> query = entityManager.createQuery("select m from Money m order by m.euro",
					MoneyBean.class);
			return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public void checkMoneyAvailable(Money money) {
		try {
			TypedQuery<MoneyBean> query = entityManager.createQuery("select m from Money m WHERE m.moneyId = :moneyId",
					MoneyBean.class);
			MoneyBean moneyBean = query.setParameter("moneyId", money.getMoneyId()).getSingleResult();
			money.setEuro(moneyBean.getEuro());
			money.setEuroAmount(moneyBean.getEuroAmount());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void editMoneyAmount(Money money) {
		try {
			MoneyBean moneyBean = entityManager.find(MoneyBean.class, money.getMoneyId());
			entityManager.getTransaction().begin();
			moneyBean.setEuroAmount(moneyBean.getEuroAmount() + money.getNewEuroAmount());
			entityManager.getTransaction().commit();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public List<MoneyBean> getListMoneyDesc() {
		try {
			TypedQuery<MoneyBean> query = entityManager.createQuery("select m from Money m order by m.euro desc",
					MoneyBean.class);
			return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public void incrementEuroAmount(Float euro, Integer amount) {
		try {
			TypedQuery<MoneyBean> query = entityManager.createQuery("select m from Money m WHERE m.euro = :euro",
					MoneyBean.class);
			MoneyBean moneyBean = query.setParameter("euro", euro).getSingleResult();
			entityManager.getTransaction().begin();
			moneyBean.setEuroAmount(moneyBean.getEuroAmount() + amount);
			entityManager.getTransaction().commit();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void updateEuroAmount(Integer moneyId, Integer amount) {
		try {
			MoneyBean moneyBean = entityManager.find(MoneyBean.class, moneyId);
			entityManager.getTransaction().begin();
			moneyBean.setEuroAmount(amount);
			entityManager.getTransaction().commit();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public boolean deleteMoney(Money money) {
		try {
			MoneyBean moneyBean = entityManager.find(MoneyBean.class, money.getMoneyId());

			entityManager.getTransaction().begin();
			entityManager.remove(moneyBean);
			entityManager.getTransaction().commit();

			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	@Transactional
	public boolean addMoney(Money money) {
		try {
			entityManager.getTransaction().begin();
			;

			MoneyBean moneyBean = new MoneyBean();
			moneyBean.setEuro(money.getEuro());
			moneyBean.setEuroAmount(money.getEuroAmount());

			System.out.println(moneyBean.getEuro());

			entityManager.persist(moneyBean);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

}