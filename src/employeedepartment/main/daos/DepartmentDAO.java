package employeedepartment.main.daos;

import java.util.List;

import employeedepartment.main.exceptions.DepartmentNotFoundException;
import employeedepartment.main.models.Department;

public interface DepartmentDAO {

	public List<Department> getAllDepartments();
	

	public Department getDepartmentById(int id) throws DepartmentNotFoundException;

	
	public boolean addDepartment(Department dep);
	
	public boolean deleteDepartmentById(int id);

	public boolean deleteDepartmentByName(String name);
	
	public boolean updateDepartment(Department dep);
}

