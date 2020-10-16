package employeedepartment;

import java.util.List;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException;
		
	public boolean addEmployee(Employee emp);
	
	public boolean deleteEmployeeById(int id);
	
	public boolean updateEmployee(Employee emp);
	
	

}
