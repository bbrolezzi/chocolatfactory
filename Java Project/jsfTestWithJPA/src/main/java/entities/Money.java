package entities;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;

import DAO.MoneyDAO;
import beans.MoneyBean;

@ManagedBean(name = "money", eager = true)
@Scope(value = "session")
public class Money {

	// PROPERTIES -------------------------------------

	private Integer moneyId;
	private Float euro;
	private Integer euroAmount;
	private List<MoneyBean> data;
	private Integer newEuroAmount;
	private Float clientInsertMoney = (float) 0;
	private Float clientEuro = (float) 0;
	private Float clientExchange;
	private String message;
	private MoneyDAO moneyDAO = new MoneyDAO();

	// PROPERTIES: COINS/BILLS ------------------------

	private Integer euro020 = 0;
	private Integer euro050 = 0;
	private Integer euro1 = 0;
	private Integer euro2 = 0;
	private Integer euro5 = 0;
	private Integer euro10 = 0;
	private Integer euro20 = 0;

	// CONSTRUCTOR ------------------------------------

	public Money() {
		loadData();
		// select the first item in the list
		/*
		 * MoneyBean money = data.get(0); this.setEuro(money.getEuro());
		 * this.setEuroAmount(money.getEuroAmount());
		 */
	}

	// GETTERS/SETTERS --------------------------------

	private void loadData() {
		this.data = moneyDAO.getListMoneyTabe();
	}

	public Float getEuro() {
		return euro;
	}

	public void setEuro(Float euro) {
		this.euro = euro;
	}

	public Integer getEuroAmount() {
		return euroAmount;
	}

	public void setEuroAmount(Integer euroAmount) {
		this.euroAmount = euroAmount;
	}

	public List<MoneyBean> getData() {
		return data;
	}

	public void setData(List<MoneyBean> data) {
		this.data = data;
	}

	public Integer getNewEuroAmount() {
		return newEuroAmount;
	}

	public void setNewEuroAmount(Integer newEuroAmount) {
		this.newEuroAmount = newEuroAmount;
	}

	public Float getClientInsertMoney() {
		return clientInsertMoney;
	}

	public void setClientInsertMoney(Float clientInsertMoney) {
		this.clientInsertMoney = clientInsertMoney;
	}

	public Float getClientEuro() {
		return clientEuro;
	}

	public void setClientEuro(Float clientEuro) {
		this.clientEuro = clientEuro;
	}

	public Float getClientExchange() {
		return clientExchange;
	}

	public void setClientExchange(Float clientExchange) {
		this.clientExchange = clientExchange;
	}

	// COINS AND BILLS GETTERS/SETTERS ---------------------------
	public Integer getEuro020() {
		return euro020;
	}

	public void setEuro020(Integer euro020) {
		this.euro020 = euro020;
	}

	public Integer getEuro050() {
		return euro050;
	}

	public void setEuro050(Integer euro050) {
		this.euro050 = euro050;
	}

	public Integer getEuro1() {
		return euro1;
	}

	public void setEuro1(Integer euro1) {
		this.euro1 = euro1;
	}

	public Integer getEuro2() {
		return euro2;
	}

	public void setEuro2(Integer euro2) {
		this.euro2 = euro2;
	}

	public Integer getEuro5() {
		return euro5;
	}

	public void setEuro5(Integer euro5) {
		this.euro5 = euro5;
	}

	public Integer getEuro10() {
		return euro10;
	}

	public void setEuro10(Integer euro10) {
		this.euro10 = euro10;
	}

	public Integer getEuro20() {
		return euro20;
	}

	public void setEuro20(Integer euro20) {
		this.euro20 = euro20;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMoneyId() {
		return moneyId;
	}

	public void setMoneyId(Integer moneyId) {
		this.moneyId = moneyId;
	}

}
