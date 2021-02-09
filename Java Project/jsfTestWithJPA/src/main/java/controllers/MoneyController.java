package controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import DAO.ChocolatDAO;
import DAO.MoneyDAO;
import beans.MoneyBean;
import entities.Chocolat;
import entities.Money;

@ManagedBean(name = "moneyController", eager = true)
@RequestScoped
public class MoneyController implements Serializable {

	private static final long serialVersionUID = 1L;
	MoneyDAO moneyDAO = new MoneyDAO();
	ChocolatDAO chocolatDAO = new ChocolatDAO();

	public void checkMoneyAvailable(Money money) {
		moneyDAO.checkMoneyAvailable(money);
	}

	public void editMoneyAmount(Money money) throws IOException {
		moneyDAO.editMoneyAmount(money);
		FacesContext.getCurrentInstance().getExternalContext().redirect("adminMoneyPage.xhtml");
	}

	public void clientEuro(Money money) {
		money.setClientEuro((float) 0);
		money.setClientEuro(money.getClientEuro() + (money.getEuro020() * 1));
		money.setClientEuro(money.getClientEuro() + (money.getEuro050() * 1));
		money.setClientEuro(money.getClientEuro() + (money.getEuro1() * 1));
		money.setClientEuro(money.getClientEuro() + (money.getEuro2() * 2));
		money.setClientEuro(money.getClientEuro() + (money.getEuro5() * 5));
		money.setClientEuro(money.getClientEuro() + (money.getEuro10() * 10));
		money.setClientEuro(money.getClientEuro() + (money.getEuro20() * 20));
	}

	public void calculateClientExchange(Money money, Chocolat chocolat) {
		money.setClientExchange(money.getClientEuro() - chocolat.getChocOrderPrice());
	}

	public void submitOrder(Money money, Chocolat chocolat) {
		// result from methods above
		clientEuro(money);
		calculateClientExchange(money, chocolat);
		// list to get money table from database
		List<MoneyBean> moneyList = moneyDAO.getListMoneyDesc();
		Float exchange = money.getClientExchange();
		// loop to iterate to confirm if there's exchange beforehand
		for (MoneyBean moneyBean : moneyList) {
			Integer euroAmount = moneyBean.getEuroAmount();
			while (moneyBean.getEuro() <= exchange && euroAmount > 0) {
				euroAmount = euroAmount - 1;
				exchange = exchange - moneyBean.getEuro();
			}
			if (exchange == 0) {
				break;
			}
		}
		if (exchange > 0) {
			money.setMessage("Impossible to complete the transaction. Please try again!");
		} else {
			money.setMessage("Order Complete!");
			chocolatDAO.updateStock(chocolat);
			updateMoney(money);
			// user.getUserName();
			// user.getUserLastName();
			exchange = money.getClientExchange();
			// loop to iterate to iterate and add/subtract coins/bills from database
			for (MoneyBean moneyBean : moneyList) {
				Integer euroAmount = moneyBean.getEuroAmount();
				while (moneyBean.getEuro() <= exchange && euroAmount > 0) {
					euroAmount = euroAmount - 1;
					exchange = exchange - moneyBean.getEuro();
				}
				// to acknowledge wich coin/bill should be altered at data table
				if (euroAmount != moneyBean.getEuroAmount()) {
					moneyDAO.updateEuroAmount(moneyBean.getMoneyId(), euroAmount);
				}
				if (exchange == 0) {
					break;
				}
			}
		}
	}

	private void updateMoney(Money money) {
		if (money.getEuro020() > 0) {
			moneyDAO.incrementEuroAmount((float) 0.20, money.getEuro020());
		}
		if (money.getEuro050() > 0) {
			moneyDAO.incrementEuroAmount((float) 0.50, money.getEuro050());
		}
		if (money.getEuro1() > 0) {
			moneyDAO.incrementEuroAmount((float) 1, money.getEuro1());
		}
		if (money.getEuro2() > 0) {
			moneyDAO.incrementEuroAmount((float) 2, money.getEuro2());
		}
		if (money.getEuro5() > 0) {
			moneyDAO.incrementEuroAmount((float) 5, money.getEuro5());
		}
		if (money.getEuro10() > 0) {
			moneyDAO.incrementEuroAmount((float) 10, money.getEuro10());
		}
		if (money.getEuro20() > 0) {
			moneyDAO.incrementEuroAmount((float) 20, money.getEuro20());
		}
	}

	public void cleanVariables(Money money) {
		money.setEuro((float) 0);
		money.setEuroAmount(0);
	}

	public void addMoney(Money money) throws IOException {
		System.out.println("cria " + money.getEuro());
		moneyDAO.addMoney(money);
		FacesContext.getCurrentInstance().getExternalContext().redirect("adminMoneyPage.xhtml");
	}

	public void deleteMoney(Money money) throws IOException {
		System.out.println("apaga " + money.getEuro());
		moneyDAO.deleteMoney(money);
		FacesContext.getCurrentInstance().getExternalContext().redirect("adminMoneyPage.xhtml");
	}
}
