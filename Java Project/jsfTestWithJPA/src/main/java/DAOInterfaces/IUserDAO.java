package DAOInterfaces;

import java.util.List;

import beans.UserBean;
import entities.User;

public interface IUserDAO {

	List<UserBean> getListUserTabe();

	UserBean getUserByEmail(User user);

	UserBean checkIfUserExistsByEmail(User user);

	boolean createUser(User user);

}
