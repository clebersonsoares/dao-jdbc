package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	System.out.println("====  TEST FINDBYID  ====");
	SellerDao sellerDao = DaoFactory.createSellerDao();
	Seller se = sellerDao.findById(1);
	System.out.println(se);
	
	

	}

}
