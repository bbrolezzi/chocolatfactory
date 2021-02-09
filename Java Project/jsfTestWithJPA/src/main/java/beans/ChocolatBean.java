package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Chocolat")
@Entity(name = "Chocolat")
public class ChocolatBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "choc_id")
	private Integer chocId;
	@Column(name = "choc_flavor")
	private String chocFlavor;
	@Column(name = "choc_stock")
	private Integer chocStock;
	@Column(name = "choc_price")
	private Integer chocPrice;

	public Integer getChocId() {
		return chocId;
	}

	public void setChocId(Integer chocId) {
		this.chocId = chocId;
	}

	public String getChocFlavor() {
		return chocFlavor;
	}

	public void setChocFlavor(String chocFlavor) {
		this.chocFlavor = chocFlavor;
	}

	public Integer getChocStock() {
		return chocStock;
	}

	public void setChocStock(Integer chocStock) {
		this.chocStock = chocStock;
	}

	public Integer getChocPrice() {
		return chocPrice;
	}

	public void setChocPrice(Integer chocPrice) {
		this.chocPrice = chocPrice;
	}

}
