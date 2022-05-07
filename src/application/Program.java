package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	Department b = new Department(1, "Books");
	Seller seller = new Seller(1,"Thomas","thomas@gmail.com",new Date(),5000.0, b);
	
	SellerDao sellerDao = DaoFactory.createSellerDao();
	System.out.println(seller);

	}

}
