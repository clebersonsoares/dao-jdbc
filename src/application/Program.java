package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			con = DB.getConnection();
			con.setAutoCommit(false);
			st = con.createStatement();
			st.executeUpdate("update seller set BaseSalary = 1090 where DepartmentId = 2");
			st.executeUpdate("update seller set BaseSalary = 9000 where DepartmentId = 1");
			con.commit();
			
		}catch(SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			};
		}finally {
			DB.closeStatement(st);
			DB.closeConnection(con);
		}

	}

}
