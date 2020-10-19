package employeedepartment;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import employeedepartment.main.connections.ConnManagerWithProps;
import employeedepartment.main.daos.DepartmentDAO;
import employeedepartment.main.daos.DepartmentDAOImpl;
import employeedepartment.main.models.Department;

class DepartmentDAOUnitTest {
	private DepartmentDAO deptDAO = new DepartmentDAOImpl();
	private Connection conn = ConnManagerWithProps.getConnection();
	
	@Before
	public void connectDB() {
		conn = ConnManagerWithProps.getConnection();
	}

	@Test
	void addDepartmentTest() {
		Department dept = new Department("Cafeteria", "6501230978", 100000);
		deptDAO.addDepartment(dept);
		
		List<Department> departments = deptDAO.getAllDepartments();
		assertTrue(dept.getName().equals(departments.get(departments.size()-1).getName()));
	}
	
	@After
	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
