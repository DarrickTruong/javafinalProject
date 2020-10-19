package employeedepartment;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	private Connection conn = ConnManagerWithProps.getConnection();
	
	@Override
	public List<Department> getAllDepartments() {
		
		List<Department> deptList = new ArrayList<>();
		
		try (PreparedStatement pstmt = conn.prepareStatement("select * from department");
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				
				int deptId = rs.getInt("dept_id");
				String name = rs.getString("dept_name");
				String phone = rs.getString("dept_phone");
				int budget = rs.getInt("budget");
				
				Department dept = new Department(name, phone, budget);
				dept.setId(deptId);
				deptList.add(dept);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptList;
	}

	ResultSet rs = null;

	@Override
	public Department getDepartmentById(int deptId) {
		try (PreparedStatement pstmt = conn.prepareStatement("select * from department where dept_id=?")) {
			pstmt.setInt(1, deptId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int deptId1 = rs.getInt("dept_id");
				String name = rs.getString("dept_name");
				String phone = rs.getString("dept_phone");
				int budget = rs.getInt("budget");

				Department dept = new Department(name, phone, budget);
				dept.setId(deptId1);
				return dept;

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}


	@Override
	public boolean addDepartment(Department dept) {

		try(PreparedStatement pstmt = conn.prepareStatement("insert into department values(null,?,?,?))")) {
			
			pstmt.setString(1, dept.getName());
			pstmt.setString(2, dept.getPhone());
			pstmt.setInt(3,  dept.getBudget());
			
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDepartmentById(int deptId) {
		try(PreparedStatement pstmt = conn.prepareStatement("delete from department where dept_id=?")) {
			
			pstmt.setInt(1, deptId);
						
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
			
	}

    @Override
    public boolean updateDepartment(Department dep) {
        try(PreparedStatement pstmt = conn.prepareStatement("update department "
                                                               +  "set name = ?, "
                                                                + "phone = ?, "
                                                                + "budget = ? "
                                                                + "WHERE id = ?")) {
			
            pstmt.setString(1, dep.getName());
            pstmt.setString(2, dep.getPhone());
            pstmt.setInt(3, dep.getBudget());
            pstmt.setInt(4, dep.getId());

			int count =  pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}

		}catch(SQLException e) {
//			e.printStackTrace();
		}
		
		return false;
    }
    
    public void closeConnection() throws SQLException {
		
		conn.close();
		
	}
}

