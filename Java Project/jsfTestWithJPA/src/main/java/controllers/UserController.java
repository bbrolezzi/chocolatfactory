package controllers;

//CONTROLLER DEALS WITH LOGICS AND METHODS IN THE WEBPAGE
//IT UNYFIES DAO WITH BEAN

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;

import DAO.UserDAO;
import beans.UserBean;
import entities.User;

@ManagedBean(name = "userController", eager = true)
@RequestScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAO();

	// THIS METHOD CONTAINS ANOTHER ONE FROM ANOTHER CLASS
	public void processLogin(User user) {
		// THIS IS THE WAY TO ACCESS THE METHOD FROM THE DAO
		UserBean userBean = userDAO.getUserByEmail(user);
		try {
			if (userBean == null) {
				user.setErrorLogin(true);
				user.setErrorMessage("Invalid email or password. Please try again!");
			} else {
				user.setErrorLogin(false);
				if (userBean.getUserType() == 1) {
					FacesContext.getCurrentInstance().getExternalContext().redirect("adminPage.xhtml");
				} else {
					FacesContext.getCurrentInstance().getExternalContext().redirect("clientPage.xhtml");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// User -> Entity | user -> Variable
	public void createUser(User user) throws IOException {
		if (userDAO.checkIfUserExistsByEmail(user) == null) {
			boolean userCreated = userDAO.createUser(user);
			if (userCreated) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
			}
		} else {
			user.setErrorLogin(true);
			user.setErrorMessage("Error creating user. Please try again later!");
		}
	}

	public void showCreate() {
		System.out.println("showCreate");
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "You rated the book with ", null);
		PrimeFaces.current().dialog().showMessageDynamic(message);
		// PrimeFaces.current().dialog().openDynamic("createUserDialog.xhtml",
		// getDialogOptions(), null);
	}

	public Map<String, Object> getDialogOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", false);
		options.put("draggable", true);
		options.put("modal", true);
		options.put("height", 400);
		options.put("contentHeight", "100%");
		return options;
	}

	/*
	 * public void save() { //business logic System.out.println("save");
	 * PrimeFaces.current().dialog().showMessageDynamic(new
	 * FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life",
	 * "Echoes in eternity.")); }
	 */

	public void checkPage(User user) throws IOException {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String pageName = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1);
		if (pageName.contains("admin") && user.getUserType() != 1) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("clientPage.xhtml");
		}
	}

	public void logout() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
	}
}
