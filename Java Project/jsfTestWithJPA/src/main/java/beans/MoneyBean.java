package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Money")
@Entity(name = "Money")
public class MoneyBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "moneyId")
	private Integer moneyId;
	@Column(name = "euro")
	private Float euro;
	@Column(name = "amount")
	private Integer euroAmount;

	public Integer getMoneyId() {
		return moneyId;
	}

	public void setMoneyId(Integer moneyId) {
		this.moneyId = moneyId;
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

}
