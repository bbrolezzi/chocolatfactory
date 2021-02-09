package entities;

//RESPONSABLE FOR THE XTHML VALUES

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.UserDAO;
import beans.UserBean;

//THE "user" AT THE @ManagedBean IT'S THE "user" AT THE value FIELD
@ManagedBean(name = "user", eager = true)
@SessionScoped
//@Scope(value = "session")
public class User implements Serializable {

	// CONSTANT --------------------------------------

	private static final long serialVersionUID = 1L;

	// PROPERTIES -------------------------------------

	private Integer userId;
	private Integer userType;
	private String email;
	private String userName;
	private String userLastName;
	private String password;
	private boolean errorLogin = false;
	private String errorMessage;
	private List<UserBean> data;
	private UserDAO userDAO = new UserDAO();

	// CONSTRUCTOR -----------------------------------

	public User() {
	}

	public void loadData() {
		this.setData(userDAO.getListUserTabe());
	}

	// GETTERS/SETTERS -------------------------------

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isErrorLogin() {
		return errorLogin;
	}

	public void setErrorLogin(boolean errorLogin) {
		this.errorLogin = errorLogin;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<UserBean> getData() {
		return data;
	}

	public void setData(List<UserBean> data) {
		this.data = data;
	}

}
