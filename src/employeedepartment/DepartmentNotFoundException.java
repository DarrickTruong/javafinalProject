package employeedepartment;

public class DepartmentNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -8241050928172373758L;
    
    public DepartmentNotFoundException(int id) {
        super("Department with id " + id + " was not found.");
    }
}
