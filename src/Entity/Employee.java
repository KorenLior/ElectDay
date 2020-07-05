package Entity;

public class Employee {
	private int id;
	private String name;
	private int branch;
	public Employee(int id, String name, int branch) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getBranch() {
		return branch;
	}
}
