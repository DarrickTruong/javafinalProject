package employeedepartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private Connection conn = ConnManagerWithProps.getConnection();
    @Override
    public List<Employee> getAllEmployees() {
       
        // private int id;
		// private String firstName;
		// private String lastName;
		// private String phone;
		// private String title;
		// private int salary;
		// private int deptId;
        List<Employee> empList = new ArrayList<>();
        
        try(
            PreparedStatement pstmt = conn.prepareStatement("select * from employee");
            ResultSet rs = pstmt.executeQuery();){

                while(rs.next()){
<<<<<<< HEAD
                    int empId = rs.getInt("emp_id");
=======
                    int id = rs.getInt("id");
>>>>>>> origin/cody-branch
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String phone = rs.getString("phone");
                    String title = rs.getString("title");
                    int salary = rs.getInt("salary");
                    int deptId = rs.getInt("dept_id");
                    Employee emp = new Employee(firstName, lastName, phone, title, salary, deptId);
<<<<<<< HEAD
                    emp.setId(empId);
=======
                    emp.setId(id);
>>>>>>> origin/cody-branch
                    empList.add(emp);
                }

            
        }catch(SQLException e){
            e.getStackTrace();
        }

        return empList;
    }

    @Override
<<<<<<< HEAD
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException{
        ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement("select * from employee where emp_id = ?");
=======
    public Employee getEmployeeById(int id) {
        ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement("select * from employee where id = ?");
>>>>>>> origin/cody-branch
				) {
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
<<<<<<< HEAD
                int idFromDB = rs.getInt("emp_id");
=======
                int idFromDB = rs.getInt("id");
>>>>>>> origin/cody-branch
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                String title = rs.getString("title");
                int salary = rs.getInt("salary");
                int deptId = rs.getInt("dept_id");
                Employee emp = new Employee(firstName, lastName, phone, title, salary, deptId);
                emp.setId(idFromDB);
                return emp;

			}
			
<<<<<<< HEAD
=======

>>>>>>> origin/cody-branch
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        
<<<<<<< HEAD
        throw new EmployeeNotFoundException(id);
=======
        return null;
>>>>>>> origin/cody-branch
    }

     @Override
    public boolean addEmployee(Employee emp) {
    
<<<<<<< HEAD
        try(PreparedStatement pstmt = conn.prepareStatement("insert into employee(emp_id, first_name, last_name, dept_id, salary, phone, title) \n" + 
        		"	value(null, ?, ?, ?, ?, ?, ?)")) {
            
            pstmt.setString(1, emp.getFirstName());
            pstmt.setString(2, emp.getLastName());
            pstmt.setInt(3, emp.getDeptId());
            pstmt.setInt(4, emp.getSalary());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getTitle());
            
=======
        try(PreparedStatement pstmt = conn.prepareStatement("insert into employee(values(?,?,?,?,?,?)")) {
            
            pstmt.setString(1, emp.getFirstName());
            pstmt.setString(2, emp.getLastName());
            pstmt.setString(3, emp.getPhone());
            pstmt.setString(4, emp.getTitle());
            pstmt.setInt(5, emp.getSalary());
            pstmt.setInt(6, emp.getDeptId());
>>>>>>> origin/cody-branch


            int count =  pstmt.executeUpdate();
            if(count > 0) {
                return true;
            }

        }catch(SQLException e) {
<<<<<<< HEAD
			e.printStackTrace();
=======
//			e.printStackTrace();
>>>>>>> origin/cody-branch
        }
        
        return false;
    }

    @Override
    public boolean deleteEmployeeById(int id) {
<<<<<<< HEAD
		try(PreparedStatement pstmt = conn.prepareStatement("delete employee where emp_id = ?")) {
=======
		try(PreparedStatement pstmt = conn.prepareStatement("delete employee where id = ?")) {
>>>>>>> origin/cody-branch
			
			pstmt.setInt(1, id);

			int count =  pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}

		}catch(SQLException e) {
//			e.printStackTrace();
		}
		
        return false;
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        try(PreparedStatement pstmt = conn.prepareStatement("update employee "
                                                               +  "set first_name = ?, "
                                                                + "last_name = ?, "
<<<<<<< HEAD
                                                                + "dept_id = ? "
                                                                + "salary = ?, "
                                                                + "phone = ?, "
                                                                + "title = ?, "
=======
                                                                + "phone = ?, "
                                                                + "title = ?, "
                                                                + "salary = ?, "
                                                                + "dept_id = ? "
>>>>>>> origin/cody-branch
                                                                + "WHERE id = ?")) {
			
            pstmt.setString(1, emp.getFirstName());
            pstmt.setString(2, emp.getLastName());
<<<<<<< HEAD
            pstmt.setInt(3, emp.getDeptId());
            pstmt.setInt(4, emp.getSalary());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getTitle());
            pstmt.setInt(7, emp.getId());
            
            
=======
            pstmt.setString(3, emp.getPhone());
            pstmt.setString(4, emp.getTitle());
            pstmt.setInt(5, emp.getSalary());
            pstmt.setInt(6, emp.getDeptId());
            pstmt.setInt(7, emp.getId());
>>>>>>> origin/cody-branch

			int count =  pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}

		}catch(SQLException e) {
//			e.printStackTrace();
		}
		
		return false;
    }

<<<<<<< HEAD
=======
    @Override
    public Employee getEmployeeByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }


>>>>>>> origin/cody-branch

    
}