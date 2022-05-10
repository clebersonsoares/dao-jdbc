package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	private Connection con;
	public SellerDaoJDBC(Connection conn) {
		this.con = conn;
	}
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Seller findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE seller.Id = ?");
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("depName"));
				Seller seller = new Seller();
				seller.setId(rs.getInt("Id"));
				seller.setName(rs.getString("Name"));
				seller.setEmail(rs.getString("Email"));
				seller.setBirthDate(rs.getDate("BirthDate"));
				seller.setBaseSalary(rs.getDouble("BaseSalary"));
				seller.setDepartment(dep);
				return seller;
			}

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
		return null;
		
	}

}
