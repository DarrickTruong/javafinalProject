package employeedepartment;

public class UniqueIdException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UniqueIdException(String id) {
		super(id + " is already used. Please input a unique id.");
	}
	
	
}
