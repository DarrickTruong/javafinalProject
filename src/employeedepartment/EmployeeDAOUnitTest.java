package employeedepartment;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeDAOUnitTest {
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	private static DepartmentDAO deptDAO = new DepartmentDAOImpl();
	private Connection conn = ConnManagerWithProps.getConnection();

	@Before
	public void connectDB() {
		conn = ConnManagerWithProps.getConnection();
	}

	@Test
	public void addEmployeeTest() {
		
		Employee emp = new Employee("Darrick", "Troung", "4081230965", "Professor", 50000, 1);
		employeeDAO.addEmployee(emp);

		List<Employee> employees = employeeDAO.getAllEmployees();
		System.out.println(employees.get(employees.size() - 1));
		assertTrue(emp.getFirstName().equals(employees.get(employees.size() - 1).getFirstName()));

	}

//	@Test
//	public void updateEmployee() {
//		Employee emp;
//		try {
//			emp = employeeDAO.getEmployeeById(1);
//			String oldLastName = emp.getLastName();
//			emp.setLastName("Truong");
//			assertEquals(emp.getLastName().equals(oldLastName), false);
//			
//		} catch (EmployeeNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
//	}

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
