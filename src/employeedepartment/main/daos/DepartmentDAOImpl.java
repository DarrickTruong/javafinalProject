package employeedepartment.main.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD:src/employeedepartment/DepartmentDAOImpl.java
=======
import employeedepartment.main.connections.ConnManagerWithProps;
import employeedepartment.main.models.Department;


>>>>>>> origin/DAOIMPL:src/employeedepartment/main/daos/DepartmentDAOImpl.java
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

<<<<<<< HEAD:src/employeedepartment/DepartmentDAOImpl.java
	@Override
	public Department getDepartmentById(int deptId) {
		try (PreparedStatement pstmt = conn.prepareStatement("select * from department where dept_id=?")) {
			pstmt.setInt(1, deptId);
			rs = pstmt.executeQuery();
=======
    @Override
    public List<Department> getAllDepartments() {
        List<Department> deptList = new ArrayList<>();
        try(
            PreparedStatement pstmt = conn.prepareStatement("select * from department");
            ResultSet rs = pstmt.executeQuery();){

                while(rs.next()){
                    int id = rs.getInt("dept_id");
                    String name = rs.getString("dept_name");
                    String address = rs.getString("dept_address");
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
>>>>>>> origin/DAOIMPL:src/employeedepartment/main/daos/DepartmentDAOImpl.java

			if (rs.next()) {
				int deptId1 = rs.getInt("dept_id");
				String name = rs.getString("dept_name");
				String phone = rs.getString("dept_phone");
				int budget = rs.getInt("budget");

<<<<<<< HEAD:src/employeedepartment/DepartmentDAOImpl.java
				Department dept = new Department(name, phone, budget);
				dept.setId(deptId1);
				return dept;
=======
    @Override
    public Department getDepartmentById(int id) {
        ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement("select * from department where dept_id = ?");
				) {
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
                int idFromDB = rs.getInt("dept_id");
                String name = rs.getString("dept_name");
                String address = rs.getString("dept_address");
                String phone = rs.getString("phone");
                int budget = rs.getInt("budget");
                Department dept = new Department(name, address, phone, budget);
                dept.setId(idFromDB);
                return dept;
>>>>>>> origin/DAOIMPL:src/employeedepartment/main/daos/DepartmentDAOImpl.java

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
<<<<<<< HEAD:src/employeedepartment/DepartmentDAOImpl.java
		}
=======
        }
        
        return null;
    }
>>>>>>> origin/DAOIMPL:src/employeedepartment/main/daos/DepartmentDAOImpl.java

		return null;
	}


	@Override
	public boolean addDepartment(Department dept) {

<<<<<<< HEAD:src/employeedepartment/DepartmentDAOImpl.java
		try(PreparedStatement pstmt = conn.prepareStatement("insert into department values(null,?,?,?))")) {
=======
        }catch(SQLException e) {
//			e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean deleteDepartmentById(int id) {
		try(PreparedStatement pstmt = conn.prepareStatement("delete department where dept_id = ?")) {
>>>>>>> origin/DAOIMPL:src/employeedepartment/main/daos/DepartmentDAOImpl.java
			
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
    public boolean deleteDepartmentByName(String name) {
		try(PreparedStatement pstmt = conn.prepareStatement("delete department where dept_name = ?")) {
			
			pstmt.setString(1, name);

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

