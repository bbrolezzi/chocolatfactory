package Singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConEntityManager {

	private static final ConEntityManager singleton = new ConEntityManager();
	protected EntityManagerFactory emf;

	public static ConEntityManager getInstance() {
		return singleton;
	}

	public ConEntityManager() {
	}

	public EntityManagerFactory getEntityManagerFactory() {
		if (emf == null)
			createEntityManagerFactory();
		return emf;
	}

	public void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}

	protected void createEntityManagerFactory() {
		this.emf = Persistence.createEntityManagerFactory("chocolatfactory");
	}
}