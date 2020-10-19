package employeedepartment.main.daos;

import java.util.List;

import employeedepartment.main.exceptions.EmployeeNotFoundException;
import employeedepartment.main.models.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException;
		
	public boolean addEmployee(Employee emp);
	
	public boolean deleteEmployeeById(int id);
	
	public boolean updateEmployee(Employee emp);
	

}
