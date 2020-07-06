package Entity;

public class Employee {
	private int id, branchNum, phoneNum;
	private String firstName, lastName;

	public int getId() {
		return id;
	}

	public int getBranchNum() {
		return branchNum;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Employee(int id, String firstName, String lastName, int phoneNum, int branchNum) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branchNum = branchNum;
		this.phoneNum  = phoneNum;
	}

	@Override
	public String toString() {
		return "Employee [" + id + ", " + firstName
				+ lastName + "]";
	}
	
}
