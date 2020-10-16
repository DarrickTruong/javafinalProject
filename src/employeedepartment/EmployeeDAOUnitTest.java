package employeedepartment;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EmployeeDAOUnitTest {
	private EmployeeDAO employeeDAO;
	
	@Test
	void addEmployee() {
		Employee emp = new Employee("Darrick", "Truong", "4084440865", "Professor", 50000, 1);
		employeeDAO.addEmployee(emp);
		
		List<Employee> employees = employeeDAO.getAllEmployees();
		assertEquals(emp.getFirstName(), employees.get(0).getFirstName());
	}
	
	@Test
	void updateEmployee() {
		Employee emp = employeeDAO.getEmployeeById(1);
		String oldLastName = emp.getLastName();
		emp.setLastName("Truong");
		assertEquals(emp.getLastName().equals(oldLastName), false);
	}
	
	@Test 
	void deleteEmployee() {
		List<Employee> employees = employeeDAO.getAllEmployees();
		int length = employees.size();
		
		employeeDAO.deleteEmployeeById(1);
		assert(employeeDAO.getAllEmployees().size() < length);
	}
	
	
	
}
