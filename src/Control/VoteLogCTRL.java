package Control;

import Entity.DbGetEmployeeList;
import Entity.Employee;

public class VoteLogCTRL {
	private int ballot ,EmployeeID;
	public VoteLogCTRL() {
		ballot = EmployeeID = 0;
	}
	public void logVote(boolean valid, String party) {
		System.out.println("ballot logged");
	}
	public void login(int employeeId, int ballot)
	{
		DbGetEmployeeList dbGetEmployeeList = new DbGetEmployeeList();
		if (dbGetEmployeeList.getEmployee(employeeId) != null)
		{
			
		}
		

	}
}
