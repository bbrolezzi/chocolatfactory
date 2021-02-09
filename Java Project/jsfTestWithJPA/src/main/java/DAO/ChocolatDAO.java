package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import DAOInterfaces.IChocolatDAO;
import Singleton.ConEntityManager;
import beans.ChocolatBean;
import entities.Chocolat;

public class ChocolatDAO implements IChocolatDAO {

	// EntityManagerFactory emf;
	ConEntityManager cem = new ConEntityManager();
	EntityManager entityManager;
	EntityTransaction transaction;

	public ChocolatDAO() {
		this.entityManager = cem.getEntityManagerFactory().createEntityManager();
	}

	public List<ChocolatBean> getListChocolat() {
		try {
			TypedQuery<ChocolatBean> query = entityManager.createQuery("select c from Chocolat c where c.chocStock > 0",
					ChocolatBean.class);
			return query.getResultList();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public void checkChocStockAndPrice(Chocolat chocolat) {
		try {
			TypedQuery<ChocolatBean> query = entityManager
					.createQuery("select c from Chocolat c WHERE c.chocId = :chocId", ChocolatBean.class);
			ChocolatBean chocolatBean = query.setParameter("chocId", chocolat.getChocId()).getSingleResult();
			chocolat.setChocPrice(chocolatBean.getChocPrice());
			chocolat.setChocStock(chocolatBean.getChocStock());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void updateStockAndPrice(Chocolat chocolat) {
		try {
			ChocolatBean chocolatBean = entityManager.find(ChocolatBean.class, chocolat.getChocId());
			if (chocolat.getChocNewPrice() > 0) {
				entityManager.getTransaction().begin();
				chocolatBean.setChocStock(chocolatBean.getChocStock() + chocolat.getChocNewQuantity());
				chocolatBean.setChocPrice(chocolat.getChocNewPrice());
				entityManager.getTransaction().commit();
			} else {
				entityManager.getTransaction().begin();
				chocolatBean.setChocStock(chocolatBean.getChocStock() + chocolat.getChocNewQuantity());
				entityManager.getTransaction().commit();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void updateStock(Chocolat chocolat) {
		try {
			ChocolatBean chocolatBean = entityManager.find(ChocolatBean.class, chocolat.getChocId());
			entityManager.getTransaction().begin();
			chocolatBean.setChocStock(chocolatBean.getChocStock() - chocolat.getChocNewQuantity());
			entityManager.getTransaction().commit();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public boolean deleteChocolat(Chocolat chocolat) {
		try {
			ChocolatBean chocolatBean = entityManager.find(ChocolatBean.class, chocolat.getChocId());

			entityManager.getTransaction().begin();
			entityManager.remove(chocolatBean);
			entityManager.getTransaction().commit();

			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean addChocolat(Chocolat chocolat) {
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();

			ChocolatBean chocolatBean = new ChocolatBean();
			chocolatBean.setChocFlavor(chocolat.getChocFlavor());
			chocolatBean.setChocPrice(chocolat.getChocPrice());
			chocolatBean.setChocStock(chocolat.getChocStock());

			entityManager.persist(chocolatBean);
			transaction.commit();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

}