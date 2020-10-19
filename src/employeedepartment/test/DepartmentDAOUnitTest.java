package employeedepartment.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import employeedepartment.main.connections.ConnManagerWithProps;
import employeedepartment.main.daos.DepartmentDAO;
import employeedepartment.main.daos.DepartmentDAOImpl;
import employeedepartment.main.exceptions.DepartmentNotFoundException;
import employeedepartment.main.models.Department;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

class DepartmentTestDAOUnitTest {

	private DepartmentDAO deptDAO = new DepartmentDAOImpl();
	private Connection conn;

	@Before
	public void connectDB() {
		conn = ConnManagerWithProps.getConnection();
	}

	@Test
	public void getDepartmentByIdTest() {

		//assumes marketing is last department
		int deptId;
		Department dept = null;
	
		try(Statement stmt  = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT max(dept_id) FROM department");){
			rs.next();
			deptId = rs.getInt("max(dept_id)");
			dept = deptDAO.getDepartmentById(deptId);
			assertEquals("Marketing", dept.getName());

		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (DepartmentNotFoundException e) {
			e.printStackTrace();
		}
	}

		

	@Test
	public void addDeleteDepartmentByIdTest() {
		Department dept = new Department("Manufacturing", "3102264949", 1000000);
		assertEquals(true, deptDAO.addDepartment(dept));
		int deptId;
		try(Statement stmt  = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT max(dept_id) FROM department");){
			rs.next();
			deptId = rs.getInt("max(dept_id)");
			assertEquals(true, deptDAO.deleteDepartmentById(deptId));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	
	@Test
	public void deleteDepartmentTest() {
		Department dept = new Department("Manufacturing", "3102264949", 1000000);
		assertEquals(true, deptDAO.addDepartment(dept));
		String deptName = "Manufacturing";
		try(Statement stmt  = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT max(dept_id) FROM department");){
			rs.next();
			assertEquals(true, deptDAO.deleteDepartmentByName(deptName));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}


	@After

	public void closeConn() {

		try {

			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}