package DAOInterfaces;

import java.util.List;

import beans.ChocolatBean;
import entities.Chocolat;

public interface IChocolatDAO {

	List<ChocolatBean> getListChocolat();

	void checkChocStockAndPrice(Chocolat chocolat);

	void updateStockAndPrice(Chocolat chocolat);

	void updateStock(Chocolat chocolat);

	boolean deleteChocolat(Chocolat chocolat);

	boolean addChocolat(Chocolat chocolat);

}
