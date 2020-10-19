package employeedepartment.main.models;


public class Department {
	
	private int id;
	private String name;
	private String phone;
	private int budget;
	

	public Department(String name, String phone, int budget) {
		super();
		this.name = name;
		this.phone = phone;
		this.budget = budget;
		
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
		return "Department [id=" + id + ", name=" + name + ", phone=" + phone + ", budget="
				+ budget + "]";
	}

	
	
	
}