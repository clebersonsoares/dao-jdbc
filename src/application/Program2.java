package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao dd = DaoFactory.createDepartmentDao();
//		Department dep = new Department();
//		dep.setName("Jogos");
//		dd.insert(dep);
		Department dep = dd.findById(4);
		System.out.println(dep);
		dep.setName("Books");
		dd.update(dep);

	}

}
