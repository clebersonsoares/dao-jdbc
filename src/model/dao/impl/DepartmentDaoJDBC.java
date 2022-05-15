package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	private Connection con;
	public DepartmentDaoJDBC(Connection conn) {
		this.con = conn;
	}
	private Department instaciateDepartment(ResultSet rs) throws SQLException{
		Department dep = new Department();
		dep.setId(rs.getInt(1));
		dep.setName(rs.getString(2));	
		return dep;
	}

	@Override
	public void insert(Department obj){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement("INSERT INTO department(Name) VALUES(?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getName());
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {	
				rs = ps.getGeneratedKeys();
				con.commit();
				while(rs.next()) {
					obj.setId(rs.getInt(1));
				
				}
				
				System.out.println("Sucesso! Foi inserido novo department com Id = "+ obj.getId());
			}else {
				con.rollback();
				System.out.println("Erro ao inserir novo department :(");
			}
		}catch(SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		}finally {
			DB.closeStatement(ps);
		}
		
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getName());
			ps.setInt(2, obj.getId());
			int rowAffect = ps.executeUpdate();
			if(rowAffect > 0) {
				con.commit();	
				System.out.println("Registro atualizado com sucesso!");
				
			}else {
				con.rollback();
				throw new DbException("Que pena! n�o foi poss�vel atualizar o registro :(");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Department findById(int id) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM department WHERE Id = "+id);
			if(rs.next()) {
				Department dep = instaciateDepartment(rs);
				return dep;	
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
	}

}
