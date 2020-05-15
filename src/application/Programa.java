package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Programa {

	public static void main(String[] args) {
		Connection com = null;
		PreparedStatement st = null;
		try {
			com = DB.getConnection();
			st = com.prepareStatement("update seller set BaseSalary= BaseSalary + ? where DepartmentId=?;");
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			int linhaUpdate = st.executeUpdate();
			System.out.println("Linha atualizadas ->"+linhaUpdate);
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
