package employeedepartment;

import employeedepartment.main.models.Employee;

public class ActiveManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ActiveManagerException(Employee employee) {
		
		super(employee.getFirstName() + " " + employee.getLastName() + " cannot be the manager as they are no longer employed.");
	}

}
