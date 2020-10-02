package employeedepartment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	
	@Test
	void constructTest() {
		Employee e1 = new Employee("ds324dfd","darrick", "4084440865", 50000, 1, "junior", true, null);
		assertEquals(e1.getName(),("DARRICK"));
	}
	
	@Test 
	void updateTest() {
		Employee e1 = new Employee("ds324dfd","darrick", "4084440865", 50000, 1, "junior", true, null);
		Employee.updateEmployee(e1, "Darrick", "1234564545", 50000, 1, "junior", true, null);
	
		assertEquals(e1.getPhone(),"1234564545");
	}
	
	@Test
	void removeTest() {
		Employee e1 = new Employee("ds324dfd","darrick", "4084440865", 50000, 1, "junior", true, null);
		Employee.removeEmployee(e1);
		assert !e1.isActive();
	}
	
	@Test
	void getTest() {
		assertEquals(Employee.getEmployee(null, "weujwerwfd"), null);
	}
	
	
	@Test
	void comparableTest() {
		
		
		Employee e1 = new Employee("ds324dfd","darrick", "4084440865", 50000, 1, "junior", true, null);
		Employee e2 = new Employee("23fdsa34", "cody", "4893343889", 50000, 1, "junior", true, null);
		
		assertEquals((e1.compareTo(e2))<0, false);
		
		
	}

}
