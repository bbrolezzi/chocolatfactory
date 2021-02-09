package controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import DAO.ChocolatDAO;
import entities.Chocolat;

@ManagedBean(name = "chocolatController", eager = true)
@RequestScoped
public class ChocolatController implements Serializable {

	private static final long serialVersionUID = 1L;
	ChocolatDAO chocolatDAO = new ChocolatDAO();

	public void checkChocStock(Chocolat chocolat) {
		chocolatDAO.checkChocStockAndPrice(chocolat);
	}

	public void editChocStock(Chocolat chocolat) throws IOException {
		chocolatDAO.updateStockAndPrice(chocolat);
		FacesContext.getCurrentInstance().getExternalContext().redirect("adminChocolatPage.xhtml");
	}

	public void chocOrderPrice(Chocolat chocolat) throws IOException {
		chocolat.setChocOrderPrice(chocolat.getChocNewQuantity() * chocolat.getChocPrice());
	}

	public void deleteChocolat(Chocolat chocolat) throws IOException {
		chocolatDAO.deleteChocolat(chocolat);
		FacesContext.getCurrentInstance().getExternalContext().redirect("adminChocolatPage.xhtml");
	}

	public void addChocolat(Chocolat chocolat) throws IOException {
		chocolatDAO.addChocolat(chocolat);
		FacesContext.getCurrentInstance().getExternalContext().redirect("adminChocolatPage.xhtml");
	}

	public void cleanVariables(Chocolat chocolat) {
		chocolat.setChocFlavor("");
		chocolat.setChocPrice(0);
		chocolat.setChocStock(0);
	}
}
