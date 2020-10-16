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
                    int id = rs.getInt("id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String phone = rs.getString("phone");
                    String title = rs.getString("title");
                    int salary = rs.getInt("salary");
                    int deptId = rs.getInt("dept_id");
                    Employee emp = new Employee(firstName, lastName, phone, title, salary, deptId);
                    emp.setId(id);
                    empList.add(emp);
                }

            
        }catch(SQLException e){
            e.getStackTrace();
        }

        return empList;
    }

    @Override
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException{
        ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement("select * from employee where id = ?");
				) {
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
                int idFromDB = rs.getInt("id");
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
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        
        throw new EmployeeNotFoundException(id);
    }

     @Override
    public boolean addEmployee(Employee emp) {
    
        try(PreparedStatement pstmt = conn.prepareStatement("insert into employee(values(?,?,?,?,?,?)")) {
            
            pstmt.setString(1, emp.getFirstName());
            pstmt.setString(2, emp.getLastName());
            pstmt.setString(3, emp.getPhone());
            pstmt.setString(4, emp.getTitle());
            pstmt.setInt(5, emp.getSalary());
            pstmt.setInt(6, emp.getDeptId());


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
    public boolean deleteEmployeeById(int id) {
		try(PreparedStatement pstmt = conn.prepareStatement("delete employee where id = ?")) {
			
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
                                                                + "phone = ?, "
                                                                + "title = ?, "
                                                                + "salary = ?, "
                                                                + "dept_id = ? "
                                                                + "WHERE id = ?")) {
			
            pstmt.setString(1, emp.getFirstName());
            pstmt.setString(2, emp.getLastName());
            pstmt.setString(3, emp.getPhone());
            pstmt.setString(4, emp.getTitle());
            pstmt.setInt(5, emp.getSalary());
            pstmt.setInt(6, emp.getDeptId());
            pstmt.setInt(7, emp.getId());

			int count =  pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}

		}catch(SQLException e) {
//			e.printStackTrace();
		}
		
		return false;
    }

    



    
}