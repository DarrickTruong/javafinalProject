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
	
	public static void databaseSystem(Scanner sc)
	{
		boolean finished = false;
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		
		DepartmentDAO depDAO = new DepartmentDAOImpl();

		while(!finished) {
			try {
				System.out.println("Do you want to input a Department or Employee? \n(Enter 1:Employee, 2:Department, 3:End)");
				String str = sc.nextLine();
				if (str.equals("1")) {
					System.out.println("What function would you like? \n(Enter 1: Display Employees, "
							+ "2: Add Employee, 3: Edit Employee, 4: Remove Employee");
					switch (str = sc.nextLine()) {
					case "1":
							  for(Employee e: empDAO.getAllEmployees())
							  {
								  System.out.println(e);
							  }
							  break;
							  
					case "2": System.out.println("Enter Employee ID:");
							  int id = Integer.valueOf(sc.nextLine());
							  System.out.println("Enter Employee First Name:");
							  String firstName = sc.nextLine();
							  System.out.println("Enter Employee Last Name:");
							  String lastName = sc.nextLine();
							  System.out.println("Enter Employee Phone:");
							  String phone = sc.nextLine();
							  System.out.println("Enter Employee Salary");
							  int salary = Integer.valueOf(sc.nextLine());
							  System.out.println("Enter years worked:");
							  int yearsWorked = Integer.valueOf(sc.nextLine());
							  System.out.println("Enter Employee Title:");
							  String title = sc.nextLine();
							  System.out.println("Enter the Department id:");
							  int depID = Integer.valueOf(sc.nextLine());
							  Department dep = depDAO.getDepartmentById(depID);
							  if (dep == null) {
								  System.out.println("Department does not exist, Department will be set to null");
							  }
							  empDAO.addEmployee(new Employee(firstName, lastName, phone, title, salary, depID));
							  break;
					case "3": System.out.println("What is the Id of the employee?");
					          int id2 =Integer.valueOf(sc.nextLine());
					          boolean broke = false;
					          Employee emp = empDAO.getEmployeeById(id2);
					          
					          if (emp == null) {
					        	  System.out.println("Employee doesn't exist");
					        	  break;
					          } else {
					        	  System.out.println("What variable would you like to edit? \nEnter 1:Name, 2:Phone, "
					        	  		+ "3:Salary, 4: Role, 5: Department");
					        	  switch(str = sc.nextLine()) {
					        	  case "1": System.out.println("Enter new first name for Employee:");
					        	            String name2 = sc.nextLine();
					        	            emp.setFirstName(name2);
					        	            
					        	            System.out.println("Enter new last name for Employee:");
					        	            String name3 = sc.nextLine();
					        	            emp.setLastName(name3);
					        	            break;
					        	  case "2": System.out.println("Enter new phone for Employee:");
					        	            String phone2 = sc.nextLine();
					        	            emp.setPhone(phone2);
					        	            break;
					        	  case "3": System.out.println("Enter new salary for Employee:");
					        	            int salary2 = Integer.valueOf(sc.nextLine());
					        	            emp.setSalary(salary2);
					        	            break;
					        	  case "4": System.out.println("Enter new title for Employee:");
					        	            String title2 = sc.nextLine();
					        	            emp.setTitle(title2);
					        	            break;
					        	  case "5": System.out.println("Enter the Department id:");
 										    depID = Integer.valueOf(sc.nextLine());
										    dep = depDAO.getDepartmentById(depID);
										    if (dep == null) {
										  	  System.out.println("Department does not exist, Department will be set to null");
										  	  broke = true;
										    }
										    
										    emp.setDeptId(depID);
										    
					        	            break;
					        	  default: System.out.println("Invalid input, returning to main menu");
					        	  		   broke = true;
					        	  }
					        	  
					        	  if(!broke)
					        	  {
					        		  empDAO.updateEmployee(emp);  
					        	  }
					          }
					case "4": 
							  System.out.println("What is the Id of the employee?");
	                          int id3 = Integer.valueOf(sc.nextLine());
	                          Employee emp2 = empDAO.getEmployeeById(id3);
	                          
	                          if(emp2 == null)
	                          {
	                        	  System.out.println("Invalid id.");
	                          }
	                          else
	                          {
	                        	  empDAO.deleteEmployeeById(id3);
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
						     case "1": depDAO.getAllDepartments();
						     		   break;
						     case "2": for (Department dep : depDAO.getAllDepartments()) {
										System.out.println("\n" + dep.getName());
										
										for(Employee e: empDAO.getAllEmployees())
										{
											if(e.getDeptId() == dep.getId())
											{
												System.out.println(e);
											}
										}
									   }
						     		   break;
						     default: System.out.println("Invalid input, returning to main menu");
						     }
						     break;
					case "2": System.out.println("Enter Department Name:");
							  String name = sc.nextLine();
							  System.out.println("Enter Department Phone:");
							  String phone = sc.nextLine();
							  System.out.println("Enter Department Budget");
							  int budget = Integer.valueOf(sc.nextLine());
							
							  depDAO.addDepartment(new Department(name, address, phone, budget));
						      break;
					case "3": System.out.println("What is the ID of the Department?");
							  boolean broke = false;
					          int depID = Integer.valueOf(sc.nextLine());
					          Department dep = depDAO.getDepartmentById(depID);
					          if (dep == null) {
					        	  System.out.println("Department doesn't exist");
					        	  broke = true;
					        	  break;
					          } else {
					        	  System.out.println("What variable would you like to edit? \nEnter 1: Name, "
					        	  		+ "3:Phone, 3:Budget");
					        	  switch(str = sc.nextLine()) {
					        	  case "1": System.out.println("Enter new name for Department:");
					        	  			String name2 = sc.nextLine();
					        	  			dep.setName(name2);
					        	  case "2": System.out.println("Enter new phone for Department:");
					        	            String phone2 = sc.nextLine();
					        	            dep.setPhone(phone2);
					        	            break;
					        	  case "3": System.out.println("Enter new budget for Department:");
					        	            int budget2 = Integer.valueOf(sc.nextLine());
					        	            dep.setBudget(budget2);
					        	            break;
					        	  default: System.out.println("Invalid input, returning to main menu");
					        	  		   broke = true;
					        	  }
					        	  
					        	  if(!broke)
					        	  {
					        		  depDAO.updateDepartment(dep);
					        	  }
					          }
					          break;
					case "4": System.out.println("What is the ID of the Department to remove:");
							try {
							      depID = Integer.valueOf(sc.nextLine());
								  dep = depDAO.getDepartmentById(depID);
						          if (dep == null) {
						        	  System.out.println("Department doesn't exist");
						        	  broke = true;
						        	  break;
						          }
						          else
						          {
						        	  depDAO.deleteDepartmentById(depID);
						          }
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		databaseSystem(sc);
	}
}