package employeedepartment.main.daos;

import java.util.List;

<<<<<<< HEAD:src/employeedepartment/EmployeeDAO.java
=======
import employeedepartment.main.exceptions.EmployeeNotFoundException;
import employeedepartment.main.models.Employee;
>>>>>>> origin/DAOIMPL:src/employeedepartment/main/daos/EmployeeDAO.java

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException;
		
	public boolean addEmployee(Employee emp);
	
	public boolean deleteEmployeeById(int id);
	
	public boolean updateEmployee(Employee emp);
	
<<<<<<< HEAD:src/employeedepartment/EmployeeDAO.java
	
}
=======

}
>>>>>>> origin/DAOIMPL:src/employeedepartment/main/daos/EmployeeDAO.java
