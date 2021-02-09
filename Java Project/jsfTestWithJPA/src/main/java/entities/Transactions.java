package entities;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;

@ManagedBean(name = "transactions", eager = true)
@Scope(value = "session")

public class Transactions {

	// PROPERTIES -------------------------------------

	private Integer transactionId;
	private String chocFlavor;
	private Integer chocQuantity;
	private Integer paidPrice;
	private String userName;
	private String userLastName;

	// CONSTRUCTOR ------------------------------------

	public Transactions() {

	}

	// GETTERS/SETTERS --------------------------------

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getChocFlavor() {
		return chocFlavor;
	}

	public void setChocFlavor(String chocFlavor) {
		this.chocFlavor = chocFlavor;
	}

	public Integer getChocQuantity() {
		return chocQuantity;
	}

	public void setChocQuantity(Integer chocQuantity) {
		this.chocQuantity = chocQuantity;
	}

	public Integer getPaidPrice() {
		return paidPrice;
	}

	public void setPaidPrice(Integer paidPrice) {
		this.paidPrice = paidPrice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
}