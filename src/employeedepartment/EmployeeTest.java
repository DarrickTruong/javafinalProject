package employeedepartment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	
	@Test
	void constructTest() {
		OldEmployee e1 = new OldEmployee("ds324dfd","darrick", "4084440865", 50000, 1, "junior", true, null);
		assertEquals(e1.getName(),("DARRICK"));
	}
	
	@Test 
	void updateTest() {
		OldEmployee e1 = new OldEmployee("ds324dfd","darrick", "4084440865", 50000, 1, "junior", true, null);
		OldEmployee.updateEmployee(e1, "Darrick", "1234564545", 50000, 1, "junior", true, null);
	
		assertEquals(e1.getPhone(),"1234564545");
	}
	
	@Test
	void removeTest() {
		OldEmployee e1 = new OldEmployee("ds324dfd","darrick", "4084440865", 50000, 1, "junior", true, null);
		OldEmployee.removeEmployee(e1);
		assert !e1.isActive();
	}
	
	@Test
	void getTest() {
		assertEquals(OldEmployee.getEmployee(null, "weujwerwfd"), null);
	}
	
	
	@Test
	void comparableTest() {
		
		
		OldEmployee e1 = new OldEmployee("ds324dfd","darrick", "4084440865", 50000, 1, "junior", true, null);
		OldEmployee e2 = new OldEmployee("23fdsa34", "cody", "4893343889", 50000, 1, "junior", true, null);
		
		assertEquals((e1.compareTo(e2))<0, false);
		
		
	}

}
