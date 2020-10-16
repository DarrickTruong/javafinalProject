package employeedepartment;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Employee {
	
		private String firstName;
		private String lastName;
		private String phone;
		private String title;
		
		public Employee(String firstName, String lastName, String phone, String title, int salary, int deptId) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.title = title;
			this.salary = salary;
			this.deptId = deptId;
		}
		
		private int salary;
		private int deptId;

		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public int getDeptId() {
			return deptId;
		}
		public void setDeptId(int deptId) {
			this.deptId = deptId;
		}
		
		@Override
		public String toString() {
			return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", title="
					+ title + ", salary=" + salary + ", deptId=" + deptId + "]";
		}
		
		
		
	}
	
	
	
	
	
	
	

