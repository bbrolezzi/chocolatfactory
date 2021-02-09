package DAOInterfaces;

import java.util.List;

import beans.MoneyBean;
import entities.Money;

public interface IMoneyDAO {

	List<MoneyBean> getListMoneyTabe();

	void checkMoneyAvailable(Money money);

	void editMoneyAmount(Money money);

	List<MoneyBean> getListMoneyDesc();

	void incrementEuroAmount(Float euro, Integer amount);

	void updateEuroAmount(Integer euro, Integer amount);

	boolean deleteMoney(Money money);

}
