package employeedepartment;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Department implements Comparable<Department>{
	
	private static ArrayList<String> nameList = new ArrayList<String>();
	private static ArrayList<Employee> managerList = new ArrayList<Employee>();
	private String name;
	private String address;
	private String phone;
	private int budget;
	private Employee manager;
	
	public Department(String name, String address, String phone, int budget, Employee manager) {
		super();
		Scanner sc = new Scanner(System.in);
		name = name.toUpperCase();
		
		if (!nameList.contains(name)) {
			this.name = name;
			nameList.add(name);
		} else {
			while(nameList.contains(name)) {
				System.out.println("Department name already exists, please enter a unique name.");
				name = sc.nextLine();
			}
			this.name = name;
			nameList.add(name);
		}
		
		this.name = name;
		
		Pattern p = Pattern.compile("[0-9]* ([A-Z]?[a-z]*\\s*){1,3} ([a-z]){2}\\. [A-Z]{2} [0-9]{5}");
		Matcher m = p.matcher(address);
		
		while(!m.matches()) {
			
			System.out.println("Invalid address. Please enter a new one");
			address = sc.nextLine();
			m = p.matcher(address);
		}
		
		this.address = address;
		
		Pattern p2 = Pattern.compile("\\d{10}");
		Matcher m2 = p2.matcher(phone);
		
		while(!m2.matches()) {
			
			System.out.println("Invalid phone number. Please enter a new one");
			phone = sc.nextLine();
			m = p.matcher(phone);
		}
		
		this.phone = phone;
		this.budget = budget;
		
		try {
			if (manager != null) {
				if (!manager.isActive()) {
					throw new ActiveManagerException(manager);
				}
				if (!managerList.contains(manager)) {
					this.manager = manager;
					this.manager.setDepartment(this);
					managerList.add(this.manager);
					this.manager.setRole("manager");
				}
			
			} else {
				this.manager = null;			
			}		
		} catch (ActiveManagerException e){
			System.out.println(e.getMessage());
		} 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		Scanner sc = new Scanner(System.in);
		Pattern p = Pattern.compile("[0-9]* ([A-Z]?[a-z]*\\s*){1,3} ([a-z]){2}\\. [A-Z]{2} [0-9]{5}");
		Matcher m = p.matcher(address);
		
		while(!m.matches()) {	
			
			System.out.println("Invalid address. Please enter a new one");
			address = sc.nextLine();
			m = p.matcher(address);
		}
		
		this.address = address;
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

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		
		
		if (manager == null) {
			this.manager = null;
			return;
		}
		
		try {
			if (!manager.isActive()) {
				throw new ActiveManagerException(manager);
			}
			if (!managerList.contains(manager)) {
				this.manager = manager;
				this.manager.setDepartment(this);
				managerList.add(this.manager);
			} else {
				this.manager = null;
				System.out.println("Employee can only be manager for one department"); // custom exception
			}
		} catch (ActiveManagerException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public int compareTo(Department department) {
		
		return this.name.compareTo(department.getName());
	}

	
	public static void departmentList(ArrayList<Department> list) {
		Stream<Department> depStream = list.parallelStream();
		depStream.forEach(System.out::println);
	}
	
	public static Department getDepartment(ArrayList<Department> depList, String name) {
		name = name.toUpperCase();
		if (!nameList.contains(name)) {
			return null;
		}
		Department d1 = null;
		for (Department dep: depList) {
			if (dep.getName().equals(name)) {
				return dep;
			}
		}
		return d1;
	}
	
	public static void updateDepartment(Department department, String name, String address, String phone, int budget, Employee manager) {
		Scanner sc = new Scanner(System.in);
		nameList.remove(department.getName());
		
		
		if (!nameList.contains(name)) {
			department.setName(name.toUpperCase());
			nameList.add(department.name);
		} else {
			while(nameList.contains(name.toUpperCase())) {
				System.out.println("Department name already exists, please enter a unique name.");
				name = sc.nextLine();
			}
			department.setName(name.toUpperCase());
			nameList.add(department.name);
		}
		
		
//		Pattern p = Pattern.compile("[0-9]* ([A-Z]?[a-z]*\\s*){1,3} ([a-z]){2}\\. [A-Z]{2} [0-9]{5}");
//		Matcher m = p.matcher(address);
//		
//		while(!m.matches()) {
//			
//			System.out.println("Invalid address. Please enter a new one");
//			address = EmployeeDepartmentDriver.sc.nextLine();
//			m = p.matcher(address);
//		}
		
		department.setAddress(address);
		
//		Pattern p2 = Pattern.compile("\\d{10}");
//		Matcher m2 = p2.matcher(phone);
//		
//		while(!m2.matches()) {
//			
//			System.out.println("Invalid phone number. Please enter a new one");
//			phone = EmployeeDepartmentDriver.sc.nextLine();
//			
//		}
		
		department.setPhone(phone);
		department.setBudget(budget);
		
		if (manager != null) {
			try {
				if (!manager.isActive()) {
					throw new ActiveManagerException(manager);
				}
				department.setManager(manager);
				manager.setDepartment(department);
				manager.setRole("manager");
				
			} catch (ActiveManagerException e){
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public static void removeDepartment(Department department) {
		
		nameList.remove(department.getName());
		
		if (department.getManager() != null) {
			department.getManager().setRole("reassign");
		}
		
		
	}
	
	
//	private void changeManager() {
//		
//		boolean replace = true;
//		do {
//			
//		} while(replace);
//	}
	
	public String toFileStringDepartment() {
		if (manager != null) {
			return "" + name +"&"+ address +"&"+ phone + "&" + budget +"&"+ manager.getId();
		} else {
			return "" + name +"&"+ address +"&"+ phone + "&" + budget +"&"+ "null";
		}
		
	}
	
	
	
	
	@Override
	public String toString() {
		if (manager != null)  {
			return "Department [name=" + name + ", address=" + address + ", phone=" + phone + ", budget=" + budget
					+ ", manager=" + manager.getName() + "]";
		} else {
			return "Department [name=" + name + ", address=" + address + ", phone=" + phone + ", budget=" + budget
					+ ", manager= no manager]";
		}
		
	}
	
	
	
	

}
