package employeedepartment.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import employeedepartment.main.connections.ConnManagerWithProps;
import employeedepartment.main.daos.EmployeeDAO;
import employeedepartment.main.daos.EmployeeDAOImpl;
import employeedepartment.main.exceptions.EmployeeNotFoundException;
import employeedepartment.main.models.Employee;

public class EmployeeDAOUnitTest {
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
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

	@Test
	public void updateEmployee() {
		Employee emp;
		try {
			emp = employeeDAO.getEmployeeById(1);
			String oldLastName = emp.getLastName();
			emp.setLastName("Truong");
			assertFalse(emp.getLastName().equals(oldLastName));
			
		} catch (EmployeeNotFoundException e) {
			e.getMessage();
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
