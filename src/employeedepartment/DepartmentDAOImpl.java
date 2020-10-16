package employeedepartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDAOImpl implements DepartmentDAO {


    private Connection conn = ConnManagerWithProps.getConnection();

        
    // private int id;
	// private String name;
	// private String address;
	// private String phone;
    // private int budget;

    @Override
    public List<Department> getAllDepartments() {
        List<Department> deptList = new ArrayList<>();
        try(
            PreparedStatement pstmt = conn.prepareStatement("select * from department");
            ResultSet rs = pstmt.executeQuery();){

                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("first_name");
                    String address = rs.getString("last_name");
                    String phone = rs.getString("phone");
                    int budget = rs.getInt("budget");
                    Department dept = new Department(name, address, phone, budget);
                    dept.setId(id);
                    deptList.add(dept);
                }

            
        }catch(SQLException e){
            e.getStackTrace();
        }

        return deptList;

    }

    @Override
    public Department getDepartmentById(int id) throws DepartmentNotFoundException {
        ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement("select * from department where id = ?");
				) {
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
                int idFromDB = rs.getInt("id");
                String name = rs.getString("first_name");
                String address = rs.getString("last_name");
                String phone = rs.getString("phone");
                int budget = rs.getInt("budget");
                Department dept = new Department(name, address, phone, budget);
                dept.setId(idFromDB);
                return dept;

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
        
        throw new DepartmentNotFoundException(id);
    }

    @Override
    public boolean addDepartment(Department dep) {
        try(PreparedStatement pstmt = conn.prepareStatement("insert into department(values(?,?,?,?)")) {
            
            pstmt.setString(1, dep.getName());
            pstmt.setString(2, dep.getAddress());
            pstmt.setString(3, dep.getPhone());
            pstmt.setInt(4, dep.getBudget());


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
    public boolean deleteDepartmentById(int id) {
		try(PreparedStatement pstmt = conn.prepareStatement("delete department where id = ?")) {
			
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
    public boolean updateDepartment(Department dep) {
        try(PreparedStatement pstmt = conn.prepareStatement("update department "
                                                               +  "set name = ?, "
                                                                + "address = ?, "
                                                                + "phone = ?, "
                                                                + "budget = ? "
                                                                + "WHERE id = ?")) {
			
            pstmt.setString(1, dep.getName());
            pstmt.setString(2, dep.getAddress());
            pstmt.setString(3, dep.getPhone());
            pstmt.setInt(4, dep.getBudget());
            pstmt.setInt(5, dep.getId());

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
