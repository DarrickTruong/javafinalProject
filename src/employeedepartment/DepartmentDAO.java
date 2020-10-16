package employeedepartment;

import java.util.List;

public interface DepartmentDAO {

	public List<Department> getAllDepartments();
	
	public Department getDepartmentById(int id) throws DepartmentNotFoundException;
	
	public boolean addDepartment(Department dep);
	
	public boolean deleteDepartmentById(int id);
	
	public boolean updateDepartment(Department dep);
	
}
