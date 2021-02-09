package beans;

//HAS THE PROPERTIES THAT CORRESPONDS TO DATA BASE COLUMNS/DATA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Transaction")
@Entity(name = "Transaction")
public class TransactionsBean {

	// COLUMM NAME -> PROPERTY NAME --------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Integer transactionId;
	@Column(name = "choc_flavor")
	private String chocFlavor;
	@Column(name = "choc_quantity")
	private Integer chocQuantity;
	@Column(name = "paid_price")
	private Integer paidPrice;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_lastname")
	private String userLastName;

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