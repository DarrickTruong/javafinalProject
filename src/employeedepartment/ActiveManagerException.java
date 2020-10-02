package employeedepartment;

public class ActiveManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ActiveManagerException(Employee employee) {
		
		super(employee.getName() + " cannot be the manager as they are no longer employed.");
	}

}
