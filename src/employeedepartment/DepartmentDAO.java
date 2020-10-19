package employeedepartment;

import java.util.List;

public interface DepartmentDAO {

	public List<Department> getAllDepartments();
	
<<<<<<< HEAD
	public Department getDepartmentById(int id) throws DepartmentNotFoundException;
=======
	public Department getDepartmentById(int id);
>>>>>>> origin/cody-branch
	
	public boolean addDepartment(Department dep);
	
	public boolean deleteDepartmentById(int id);
	
	public boolean updateDepartment(Department dep);
<<<<<<< HEAD
	
}
=======
}
>>>>>>> origin/cody-branch
