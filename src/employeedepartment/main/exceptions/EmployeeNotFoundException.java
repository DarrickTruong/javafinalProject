package employeedepartment.main.exceptions;

public class EmployeeNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3849529600352335363L;

	public EmployeeNotFoundException(int id) {
		super("Employee with id " + id + " was not found.");
	}
}
