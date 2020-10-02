package employeedepartment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DepartmentTest {

	@Test
	void comparable() {
		
		Department d1 = new Department("compsci", "3295 Fallen oak ct. CA 95148", "5641232132", 50000000, null);
		Department d2 = new Department("economics", "3295 economics ct. CA 95148", "1458971564", 50000000, null);
		
		assertEquals(d1.compareTo(d2)<0, true);
		
	}
	
	@Test
	void constructTest() {
		Department d1 = new Department("Biology", "3295 Fallen oak ct. CA 95148", "5641232132", 50000000, null);
		assertEquals(d1.getName(), "BIOLOGY");
	}
	
	@Test
	void updateTest() {
		Department d1 = new Department("Spanish", "3295 Fallen oak ct. CA 95148", "5641232132", 50000000, null);
		Department.updateDepartment(d1, "Spanish2", "3295 Fallen oak ct. CA 95148", "5641232132", 50000000, null);
		assertEquals(d1.getName(), "SPANISH2");
	}
	
	@Test
	void toFileStringTest() {
		Department d1 = new Department("Spanish3", "3295 Fallen oak ct. CA 95148", "5641232132", 50000000, null);
		String str = d1.toFileStringDepartment();
		String[] arr = str.split("&");
		assertEquals(arr.length, 5);
	}

}
