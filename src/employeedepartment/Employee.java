package employeedepartment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Employee implements Comparable<Employee>{
	
	private static ArrayList<String> idList = new ArrayList<String>();
	private String id;
	private String name;
	private String phone;
	private int salary;
	private int yearsWorked;
	private String role;
	private boolean active;
	private Department department;
	
	public Employee(String id, String name, String phone, int salary, int yearsWorked, String role, boolean active, Department department) {
		super();
		Scanner sc = new Scanner(System.in);
		try {
			if (!idList.contains(id)) {
				this.id = id.toUpperCase();
				idList.add(this.id);
			} else {
				throw new UniqueIdException(id);
			}
			
		} catch (UniqueIdException e) {
			e.getMessage();
			while(idList.contains(id)) {
				id = sc.nextLine();
			}
			this.id = id.toUpperCase();
			idList.add(this.id);
		}
		
		
		
		
		this.name = name.toUpperCase();
		Pattern p = Pattern.compile("\\d{10}");
		Matcher m = p.matcher(phone);
		
//		Boolean match = m.matches(); 
		while(!m.matches()) {
			
			System.out.println("Invalid phone number. Please enter a new one");
			phone = sc.nextLine();
			m = p.matcher(phone);
			
		}
		
		
		this.phone = phone;
		this.salary = salary;
		this.yearsWorked = yearsWorked;
		this.role = role;
		this.active = active;
		this.department = department;
		
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		Scanner sc = new Scanner(System.in);
		Pattern p = Pattern.compile("\\d{10}");
		Matcher m = p.matcher(phone);
		
		while(!m.matches()) {
			
			System.out.println("Invalid phone number. Please enter a new one");
			phone = sc.nextLine();
			m = p.matcher(phone);
		}
		
		this.phone = phone;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getYearsWorked() {
		return yearsWorked;
	}

	public void setYearsWorked(int yearsWorked) {
		this.yearsWorked = yearsWorked;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		if (this.department!=null) {
			if (this.department.getManager() != null && role == "manager" && !this.department.getManager().equals(this)) {
				Scanner sc = new Scanner(System.in);
				while (role=="manager") {
					System.out.println("Enter a different role, Department already has an assigned manager.");
					role = sc.nextLine();
				}
			}
		}
		
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public int compareTo(Employee employee) {
		return this.name.compareTo(employee.getName());
		
	}
	
	
	public static void employeeList(ArrayList<Employee> list) {
		
		Stream<Employee> empStream = list.parallelStream();
		empStream.filter(employee -> employee.active)
					.forEach(System.out::println);
	}
	
	
	public static void employeeList(ArrayList<Employee> list, Department department) {
		Stream<Employee> empStream = list.parallelStream();
		empStream.filter(employee -> employee.department==department)
					.filter(employee -> employee.active)
					.forEach(System.out::println);
	}
	
	public static void employeeHistoryList(ArrayList<Employee> list) {
	
		Stream<Employee> empStream = list.parallelStream();
		empStream.forEach(System.out::println);
	}
	
	public static void employeeHistoryList(ArrayList<Employee> list, Department department) {
		Stream<Employee> empStream = list.parallelStream();
		empStream.filter(employee -> employee.department==department)
					.forEach(System.out::println);
	}
	
	public static Employee getEmployee(ArrayList<Employee> empList, String id) { 
		id = id.toUpperCase();
		if (!idList.contains(id)) {
			return null;
		}
		Employee e1 = null;
		for (Employee emp: empList) {
			if (emp.getId().equals(id)) {
				return emp;
			}
		}
		return e1;
	}
	
	public static void removeEmployee(Employee employee) {
		if (employee.getRole().equals("manager")) {
			employee.getDepartment().setManager(null);
			employee.setDepartment(null);
		}
		employee.setActive(false);
	}
	
	public void rehireEmployee(Employee employee) {
		employee.setActive(true);
	}
	
	
	public static void updateEmployee(Employee employee, String name, String phone, int salary, int yearsWorked, String role, boolean active, Department department) {
		
		employee.setName(name.toUpperCase());
		employee.setPhone(phone);
		employee.setSalary(salary);
		employee.setYearsWorked(yearsWorked);
		employee.setRole(role);
		employee.setActive(active);
		employee.setDepartment(department);
	}
	
	
	public String toFileStringManager() {
		return "" + id +"&"+ name +"&"+ phone +"&"+ salary +"&"+ yearsWorked +"&"+ role +"&"+ active;
	}
	public String toFileStringEmployee() {
		return "" + id +"&"+ name +"&"+ phone +"&"+ salary +"&"+ yearsWorked +"&"+ role +"&"+ active +"&"+ department;
	}

	@Override
	public String toString() {
		if (department != null) {
			return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", salary=" + salary + ", yearsWorked="
					+ yearsWorked + ", role=" + role + ", active=" + active + ", department=" + department + "]";
		} else {
			return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", salary=" + salary + ", yearsWorked="
					+ yearsWorked + ", role=" + role + ", active=" + active + ", department=no department]";
		}
		
		
	}
	
	
	
	
	
	
	
}
