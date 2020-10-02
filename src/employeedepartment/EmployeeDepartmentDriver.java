package employeedepartment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeDepartmentDriver {
	

	
	public static boolean seed(ArrayList<Employee> empList, ArrayList<Department> depList) {
		
		Employee e1 = new Employee("12iu32iud", "darrick", "4124440865", 50000, 1, "junior", true, null);
		Employee e2 = new Employee("12ihfdd3d", "cody", "4083330865", 50000, 1, "junior", true, null);
		Employee e3 = new Employee("jkdjfasd9", "haroon", "9876540865", 50000, 1, "junior", true, null);
		Employee e4 = new Employee("12897hdjh", "charles", "4012345665", 50000, 1, "junior", true, null);
		Employee e5 = new Employee("dkjcmekuf", "lia", "1234568880", 50000, 1, "junior", true, null);
		
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		
		depList.add(new Department("economics", "395 economics ct. CA 95148", "1458971564", 500555000, e1));
		depList.add(new Department("compsci", "295 compsci ct. CA 95148", "1458971564", 50000000, e2));
		depList.add(new Department("math", "6329 math ct. CA 95148", "1458971564", 50000000, e3));
		depList.add(new Department("history", "123 history ct. CA 95148", "1458971564", 50000000, e4));
		depList.add(new Department("english", "234 english ct. CA 95148", "1458971564", 50000000, e5));
		
		return true;
	}
	
	public static void removeDepartment(ArrayList<Department>depList, ArrayList<Employee> empList, Department dep) {
		
		for (Employee emp : empList) {
			if (emp.getDepartment() == dep) {
				emp.setDepartment(null);
			}
		}
		
		Department.removeDepartment(dep);
		depList.remove(dep);
		dep = null;
	}
	
	public static void removeEmployee(ArrayList<Employee> empList, Employee emp) {
		Employee.removeEmployee(emp);
		empList.remove(emp);
		emp = null; 
	}
	
	public static void employeeSystem(ArrayList<Employee> empList, ArrayList<Department> depList) {
		boolean finished = false;
		Scanner sc = new Scanner(System.in);
		
		while(!finished) {
			try {
				System.out.println("Do you want to input a Department or Employee? \n(Enter 1:Employee, 2:Department, 3:End)");
				String str = sc.nextLine();
				if (str.equals("1")) {
					System.out.println("What function would you like? \n(Enter 1: Display Employees, "
							+ "2: Add Employee, 3: Edit Employee, 4: Remove Employee");
					switch (str = sc.nextLine()) {
					case "1": System.out.println("Would you like to view all employees or current employees? \n Enter 1: All, 2:Current");
							  switch(str = sc.nextLine()) {
							  case "1": Employee.employeeHistoryList(empList);
							  		    break;
							  case "2": Employee.employeeList(empList);
							  			break;
							  default: System.out.println("Invalid input, returning to main menu");
							  }
							  break;
					case "2": System.out.println("Enter Employee ID:");
							  String id = sc.nextLine();
							  System.out.println("Enter Employee Name:");
							  String name = sc.nextLine();
							  System.out.println("Enter Employee Phone:");
							  String phone = sc.nextLine();
							  System.out.println("Enter Employee Salary");
							  int salary = Integer.valueOf(sc.nextLine());
							  System.out.println("Enter years worked:");
							  int yearsWorked = Integer.valueOf(sc.nextLine());
							  System.out.println("Enter Employee Role:");
							  String role = sc.nextLine();
							  System.out.println("Enter the Department:");
							  Department dep = Department.getDepartment(depList, sc.nextLine().toUpperCase());
							  if (dep == null) {
								  System.out.println("Department does not exist, Department will be set to null");
							  }
							  empList.add(new Employee(id, name, phone, salary, yearsWorked, role, true, dep));
							  break;
					case "3": System.out.println("What is the Id of the employee?");
					          String id2 = sc.nextLine();
					          Employee emp = Employee.getEmployee(empList, id2);
					          if (emp == null) {
					        	  System.out.println("Employee doesn't exist");
					        	  break;
					          } else {
					        	  System.out.println("What variable would you like to edit? \nEnter 1:Name, 2:Phone, "
					        	  		+ "3:Salary, 4:Years Worked, 5: Role, 6: Department");
					        	  switch(str = sc.nextLine()) {
					        	  case "1": System.out.println("Enter new name for Employee:");
					        	            String name2 = sc.nextLine();
					        	            emp.setName(name2);
					        	            break;
					        	  case "2": System.out.println("Enter new phone for Employee:");
					        	            String phone2 = sc.nextLine();
					        	            emp.setPhone(phone2);
					        	            break;
					        	  case "3": System.out.println("Enter new salary for Employee:");
					        	            int salary2 = Integer.valueOf(sc.nextLine());
					        	            emp.setSalary(salary2);
					        	            break;
					        	  case "4": System.out.println("Enter new years worked for Employee:");
					        	            int year2 = Integer.valueOf(sc.nextLine());
					        	            emp.setYearsWorked(year2);
					        	            break;
					        	  case "5": System.out.println("Enter new role for Employee:");
					        	            String role2 = sc.nextLine();
					        	            emp.setRole(role2);
					        	            break;
					        	  case "6": System.out.println("Enter new department for Employee:");
					        	            Department dep2 = Department.getDepartment(depList, sc.nextLine().toUpperCase());
					        	            emp.setDepartment(dep2);
					        	             break;
					        	  default: System.out.println("Invalid input, returning to main menu");
					        	  }
					          }
					case "4": System.out.println("Would you like to remove or permanently remove employee? \nEnter 1:remove, 2: remove permanently");
							  switch (str = sc.nextLine()) {
							  case "1": System.out.println("What is the Id of the employee?");
					                    String id3 = sc.nextLine().toUpperCase();
					                    Employee emp2 = Employee.getEmployee(empList, id3);
					                    Employee.removeEmployee(emp2);
					                    break;
							  case "2": try {
											  System.out.println("What is the Id of the employee?");
				                              String id4 = sc.nextLine();
				                              Employee emp3 = Employee.getEmployee(empList, id4);
				                              removeEmployee(empList, emp3);
								  
										  } catch (NullPointerException e) {
											  System.out.println("This Employee doesn't exist");
										  } 
							  	          break;
								  
								  
			                            
							  default: System.out.println("Invalid input, returning to main menu");
							  }
							  break;
	                default: System.out.println("Invalid input, returning to main menu");
	               
					}
				} else if (str.equals("2")) {
					System.out.println("What function would you like? \n(Enter 1: Display Departments, "
							+ "2: Add Department, 3: Edit Department, 4: Remove Department");
					switch (str = sc.nextLine()) {
					case "1": System.out.println("Would you like to see a list of Departments or Employees by Departments?"
							+"\nEnter 1:List of Departments, 2:Employees by Department");
						     switch(str = sc.nextLine()) {
						     case "1": Department.departmentList(depList);
						     		   break;
						     case "2": for (Department dep : depList) {
										System.out.println("\n" + dep.getName());
										Employee.employeeList(empList, dep);
									    }
						     		   break;
						     default: System.out.println("Invalid input, returning to main menu");
						     }
						     break;
					case "2": System.out.println("Enter Department Name:");
							  String name = sc.nextLine();
							  System.out.println("Enter Department Address:");
							  String address = sc.nextLine();
							  System.out.println("Enter Department Phone:");
							  String phone = sc.nextLine();
							  System.out.println("Enter Department Budget");
							  int budget = Integer.valueOf(sc.nextLine());
							  System.out.println("Enter Employee Id:");
							  Employee emp = Employee.getEmployee(empList, sc.nextLine().toUpperCase());
							  if (emp == null) {
								  System.out.println("Employee does not exist, manager will be set to null");
							  } 
							  depList.add(new Department(name, address, phone, budget, emp));
							 break;
					case "3": System.out.println("What is the Name of the Department?");
					          String name2 = sc.nextLine();
					          Department dep = Department.getDepartment(depList, name2);
					          if (dep == null) {
					        	  System.out.println("Department doesn't exist");
					        	  break;
					          } else {
					        	  System.out.println("What variable would you like to edit? \nEnter 1:Address, "
					        	  		+ "2:Phone, 3:Budget, 4:Manager");
					        	  switch(str = sc.nextLine()) {
					        	  case "1": System.out.println("Enter new address for Department:");
					        	            String address2 = sc.nextLine();
					        	            dep.setAddress(address2);
					        	            break;
					        	  case "2": System.out.println("Enter new phone for Department:");
					        	            String phone2 = sc.nextLine();
					        	            dep.setAddress(phone2);
					        	            break;
					        	  case "3": System.out.println("Enter new budget for Department:");
					        	            int budget2 = Integer.valueOf(sc.nextLine());
					        	            dep.setBudget(budget2);
					        	            break;
					        	  case "4": System.out.println("Enter Employee Id for Manager:");
					        	  			Employee emp4 = Employee.getEmployee(empList, sc.nextLine().toUpperCase());
					        	            dep.setManager(emp4);
					        	            break;
					        	  default: System.out.println("Invalid input, returning to main menu");
					        	  }
					          }
					          break;
					case "4": System.out.println("What is the name of the Department to remove:");
							try {
								removeDepartment(depList, empList, Department.getDepartment(depList, sc.nextLine().toUpperCase()));								
							} catch(NullPointerException e) {
								System.out.println("This Department does not exist.");
							}
							break;
					default: System.out.println("Invalid input, returning to main menu");
					}
				} else if (str.equals("3")) {
					finished = true;
				} else {
					System.out.println("Invalid output, try again.");
				}
				
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid input entered.");
			}
		}
		sc.close();
	}
	
	public static void driver(ArrayList<Employee> empList, ArrayList<Department> depList) {
		System.out.println("Starting Department List");
		Department.departmentList(depList);
		
		
		System.out.println("\nStarting Employee List");
		Employee.employeeList(empList);
		
		System.out.println("\nAdding Employees");
		empList.add(new Employee("nckdh32kd", "Rodger", "1236540987", 60000, 4, "assistant", true, Department.getDepartment(depList, "compsci")));
		empList.add(new Employee("fdfh32kd", "Lisa", "6549871234", 80000, 2, "teacher", true, Department.getDepartment(depList, "history")));
		empList.add(new Employee("12dfg432", "Vivian", "3641426767", 110000, 5, "administrator", true, Department.getDepartment(depList, "english")));
		
		System.out.println("\nAdding Departments");
		depList.add(new Department("psychology", "444 psychology st. CA 98764", "8796786543", 26565655, null));
		
		System.out.println("\nEmployee List Updated with New Employees");
		Employee.employeeList(empList);
		
		System.out.println("\n Department List updated with new Departments");
		Department.departmentList(depList);
		
		System.out.println("\n Updating Employee");
		Employee.updateEmployee(Employee.getEmployee(empList, "12dfg432"), "vivian", "1234567890", 110000, 5, "administrator", true, Department.getDepartment(depList, "english"));
		
		System.out.println("\n Updating Department");
		Department.updateDepartment(Department.getDepartment(depList, "psychology"), "psychology", "444 psychology st. CA 98764", "8796786543", 26565655, Employee.getEmployee(empList, "nckdh32kd"));
		
		System.out.println("\nEmployee list after updating Vivian");
		Employee.employeeList(empList);
		
		System.out.println("\nDepartment list after updating psychology");
		Department.departmentList(depList);
		
		System.out.println("\n Remove Employee");
		Employee.removeEmployee(Employee.getEmployee(empList, "dkjcmekuf"));
		
		System.out.println("\n Remove Department");
		removeDepartment(depList, empList, Department.getDepartment(depList, "english"));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		
		boolean seeded = false;
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<Department> departments = new ArrayList<Department>();
		
//		seeded = seed(employees, departments);
		
		File file = new File("resources/departmentManagers.txt");
		
		
		if (!seeded) {
			try (FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
				){
				
				String sb = new String("");
				
				
				while((sb = br.readLine()) != null){
					String[] details = sb.split("&");
					
					employees.add(new Employee(details[0], details[1], details[2], Integer.valueOf(details[3]), 
							Integer.valueOf(details[4]), details[5], Boolean.valueOf(details[6]), null));
//					System.out.println(employees.get(0));
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e7) {
				// TODO Auto-generated catch block
				e7.printStackTrace();
			}
			
			file = new File("resources/departments.txt");

			
			try (FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
				){
				
				String sb = new String("");
				
				while((sb = br.readLine()) != null){
					String[] details = sb.split("&");
					
					if (!details[4].equals("null")) {
						departments.add(new Department(details[0], details[1], details[2], Integer.valueOf(details[3]), 
								Employee.getEmployee(employees, details[4])));
					} else {
						departments.add(new Department(details[0], details[1], details[2], Integer.valueOf(details[3]), null));
					}
					
//					System.out.println(departments.get(0));
			}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e7) {
				// TODO Auto-generated catch block
				e7.printStackTrace();
			}
			
			
			file = new File("resources/employees.txt");
			try (FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
				){
				
				String sb = new String("");
				
				while((sb = br.readLine()) != null){
					String[] details = sb.split("&");
					
					if (!details[7].equals("null")) {
						employees.add(new Employee(details[0], details[1], details[2], Integer.valueOf(details[3]), 
								Integer.valueOf(details[4]), details[5], Boolean.valueOf(details[6]), Department.getDepartment(departments, details[7])));
					} else {
						employees.add(new Employee(details[0], details[1], details[2], Integer.valueOf(details[3]), 
								Integer.valueOf(details[4]), details[5], Boolean.valueOf(details[6]), null));
					}
					
			}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e7) {
				// TODO Auto-generated catch block
				e7.printStackTrace();
			}
		}
		
		
		
//		driver(employees, departments);
		employeeSystem(employees, departments);
		
		
		System.out.println("Final Employee List");
		Employee.employeeList(employees);
		
		System.out.println("Final Department List");
		Department.departmentList(departments);
		
		ArrayList<Employee> depHead = new ArrayList<Employee>();
		for (Department dep : departments) {
			if (dep.getManager() != null) {
				depHead.add(dep.getManager());
			}	
		}
		
		System.out.println("Employees by Departments");
		for (Department dep : departments) {
			System.out.println("\n" + dep.getName());
			Employee.employeeList(employees, dep);
		}
		
		
	
		
		file = new File("resources/departmentManagers.txt");
		
		try (FileWriter fr = new FileWriter(file);
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter pr = new PrintWriter(br); 
				){
			
			if (!file.exists()) {
				file.createNewFile();				
			}
			for (Employee employee: depHead) {
				pr.println(employee.toFileStringManager());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		file = new File("resources/departments.txt");
		
		try (FileWriter fr = new FileWriter(file);
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter pr = new PrintWriter(br); 
				){
			
			if (!file.exists()) {
				file.createNewFile();				
			}
			for (Department department: departments) {
				pr.println(department.toFileStringDepartment());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		file = new File("resources/employees.txt");
		for (Employee manager:depHead) {
			employees.remove(manager);
		}
		
		try (FileWriter fr = new FileWriter(file);
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter pr = new PrintWriter(br); 
				){
			
			if (!file.exists()) {
				file.createNewFile();				
			}
			for (Employee employee: employees) {
				pr.println(employee.toFileStringEmployee());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}
}
