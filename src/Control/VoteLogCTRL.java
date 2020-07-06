package Control;

import java.time.LocalTime;
import java.util.ArrayList;

import Entity.Ballot;
import Entity.Branch;
import Entity.DbGetBallotList;
import Entity.DbGetBranchList;
import Entity.DbGetEmployeeList;
import Entity.DbNewVoteEntry;
import Entity.Employee;

public class VoteLogCTRL {
	private Employee employee = null;
	private Ballot ballot = null;
	
	public boolean login(int employeeId, int ballotNum)
	{
		DbGetEmployeeList dbGetEmployeeList = new DbGetEmployeeList();
		DbGetBallotList dbGetBallotList = new DbGetBallotList();
		Ballot ballot = dbGetBallotList.getBallot(ballotNum);
		Employee employee = dbGetEmployeeList.getEmployee(employeeId);
		if ((employee!=null)&&(ballot!=null))
		{
			this.ballot = ballot;
			this.employee = employee;
			return true;
		}
		this.ballot = null;
		this.employee = null;
		return false;
	}
	public void logVote(String isValid, String votedFor)
	{
		if (this.isLogged() && (!ballotCountClosed()))
		{
			DbNewVoteEntry dbNewVoteEntry = new DbNewVoteEntry(ballot.getBallotNum(), votedFor, isValid, employee.getId());
			dbNewVoteEntry.SetEntry();
		}
	}
	public void closeBallot()
	{
		if (this.isLogged() && (!ballotCountClosed()))
		{
			ballot.setCountCloseTime(LocalTime.now().toString());
			DbGetBallotList dbGetBallotList = new DbGetBallotList();
			dbGetBallotList.closeBallot(ballot.getBallotNum(), ballot.getCountCloseTime());
		}
		login(employee.getId(),ballot.getBallotNum());
	}
	public String getEmployee() {
		return employee.toString();
	}
	public String getBallot() {
		return ballot.toString();
	}
	public boolean isLogged() {
		if ((employee!=null)&&(ballot!=null))
		{
			return true;
		}
		return false;
	}
	public boolean ballotCountClosed()
	{
		if (ballot==null)
		{
			return false;
		}
		if (ballot.getCountCloseTime()!=null)
		{
			return true;
		}
		return false;
	}
	public boolean isManager() {
		DbGetBranchList dbGetBranchList = new DbGetBranchList();
		ArrayList<Branch> branches = dbGetBranchList.getBranches();
		for(Branch branch:branches)
		{
			if(branch.getManagerId()==v)
		}
		return false;
	}
}
