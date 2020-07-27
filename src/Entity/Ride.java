package Entity;

public class Ride {
	private int employeeId;
	private String time;
	public Ride(int employeeId, String time) {
		super();
		this.employeeId = employeeId;
		this.time = time;
	}
	public Ride() {
		employeeId = 0;
		time = null;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getTime() {
		return time;
	}
	
}
