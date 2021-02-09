package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import DAOInterfaces.ITransactionsDAO;

public class TransactionsDAO implements ITransactionsDAO {

	EntityManagerFactory emf;
	EntityManager entityManager;
	EntityTransaction transaction;

}