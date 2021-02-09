package controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import DAO.ChocolatDAO;
import DAO.MoneyDAO;
import DAO.UserDAO;

@ManagedBean(name = "transactionsController", eager = true)
@RequestScoped
public class TransactionsController implements Serializable {

	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAO();
	ChocolatDAO chocolatDAO = new ChocolatDAO();
	MoneyDAO moneyDAO = new MoneyDAO();

}