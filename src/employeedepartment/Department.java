package employeedepartment;


public class Department {
	
	private int id;
	private String name;
	private String address;
	private String phone;
	private int budget;
	
	public Department(String name, String address, String phone, int budget) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.budget = budget;
		
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
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getBudget() {
		return budget;
	}


	public void setBudget(int budget) {
		this.budget = budget;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Department [name=" + name + ", address=" + address + ", phone=" + phone + ", budget=" + budget + "]";
	}

	
	
	
}