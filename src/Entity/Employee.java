package Entity;

public class Employee {
	private int id, branchNum;
	Elector me;

	public int getId() {
		return id;
	}

	public int getBranchNum() {
		return branchNum;
	}

	public String getPhoneNum() {
		return me.getPhoneNumber();
	}

	public String getFirstName() {
		return me.getFirstName();
	}

	public String getLastName() {
		return me.getLastName();
	}

	public Employee(int id, int jobBranch) {
		super();
		this.id = id;
		this.branchNum = jobBranch;
		this.me = new DbElectors().getElector(id);
	}

	@Override
	public String toString() {
		return "Employee [" + id  + ": " +getLastName() +" "+getFirstName() +"]/n/r+"+"[Call me: "+getPhoneNum();
	}
	
}
