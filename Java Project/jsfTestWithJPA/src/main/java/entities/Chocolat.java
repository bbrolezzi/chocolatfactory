package entities;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;

import DAO.ChocolatDAO;
import beans.ChocolatBean;

@ManagedBean(name = "chocolat", eager = true)
@Scope(value = "session")
public class Chocolat {

	// PROPERTIES -------------------------------------

	private Integer chocId;
	private String chocFlavor;
	private Integer chocStock;
	private Integer chocPrice;
	private Integer chocNewQuantity = 0;
	private Integer chocNewPrice = 0;
	private Integer chocOrderPrice;
	private boolean showStockAndPrice = false;
	private ChocolatDAO chocolatDAO = new ChocolatDAO();

	private List<ChocolatBean> data;

	// CONSTRUCTOR ------------------------------------

	public Chocolat() {
		loadData();
	}

	public void loadData() {
		this.data = chocolatDAO.getListChocolat();
	}

	// GETTERS/SETTERS --------------------------------

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

	public List<ChocolatBean> getData() {
		return data;
	}

	public Integer getChocNewQuantity() {
		return chocNewQuantity;
	}

	public void setChocNewQuantity(Integer chocNewQuantity) {
		this.chocNewQuantity = chocNewQuantity;
	}

	public Integer getChocNewPrice() {
		return chocNewPrice;
	}

	public void setChocNewPrice(Integer chocNewPrice) {
		this.chocNewPrice = chocNewPrice;
	}

	public Integer getChocOrderPrice() {
		return chocOrderPrice;
	}

	public void setChocOrderPrice(Integer chocOrderPrice) {
		this.chocOrderPrice = chocOrderPrice;
	}

	public boolean isShowStockAndPrice() {
		return showStockAndPrice;
	}

	public void setShowStockAndPrice(boolean showStockAndPrice) {
		this.showStockAndPrice = showStockAndPrice;
	}
}
