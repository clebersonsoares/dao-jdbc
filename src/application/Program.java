package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		System.out.println("====  TEST 1 FINDBYID  ====");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller se = sellerDao.findById(3);
		System.out.println(se);
//		System.out.println("\n====  TEST 2 FINDBYDEPARTMENT  ====");
//		Department department = new Department(2, null);
//		List<Seller> list = sellerDao.findByDepartment(department);
//		for (Seller obj : list) {
//			System.out.println(obj);
//		}
//		System.out.println("\n====  TEST 3 FINDALL  ====");
//		list = sellerDao.findAll();
//		for(Seller obj : list) {
//			System.out.println(obj);
//		}
//		System.out.println("\n====  TEST 4 INSERT  ====");
//		Seller ins = new Seller( null,"Davi Lafaiete","davi@gmail.com",new Date(),15000.0, department);
//		sellerDao.insert(ins);
		
		System.out.println("\n====  TEST 5 UPDATE  ====");
		Seller up = sellerDao.findById(9);
		up.setName("Binho");
		sellerDao.update(up);
	}

}
