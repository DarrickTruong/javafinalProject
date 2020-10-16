//package employeedepartment;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.List;
//
//import org.junit.Test;
//
//public class EmployeeDAOUnitTest {
//	private EmployeeDAO employeeDAO;
//	
//	@Test
//	void addEmployee() {
//		Employee emp = new Employee("10001", "Darrick", "Troung", "4081230865", 50000, 2, "Professor", true, null);
//		employeeDAO.addEmployee(emp);
//		
//		List<Employee> employees = employeeDAO.getAllEmployees();
//		assertEquals(emp.getFirstName(), employees.get(0).getFirstName());
//	}
//	
//	@Test
//	void updateEmployee() {
//		Employee emp = employeeDAO.getEmployeeById(1);
//		String oldLastName = emp.getLastName();
//		emp.setLastName("Truong");
//		assertEquals(emp.getLastName().equals(oldLastName), false);
//		
//		
//	}
//}
