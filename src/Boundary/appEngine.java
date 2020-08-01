package Boundary;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFrame;

import Control.ElectorCtrl;
import Control.EmployeeCtrl;
import Control.LoginCtrl;
import Control.SystemCtrl;
import Entity.DbElectors;
import Entity.Elector;
import Entity.Employee;
import Entity.MainBranch;
import Entity.SecondaryBranch;

public class appEngine {
	private static JFrame main;
	private static LoginCtrl loginCtrl;
	public static void main(String[] args) {
		main = new LoginFrame();
		main.setVisible(true);
	}

	public static int getEmployeeId() {
		if (loginCtrl == null) {
			return -1;
		}
		if (loginCtrl.getPermission()>=0) {
			return loginCtrl.getId();
		}
		return -1;
	}
	
	
	public static void electorBook() {
		if (loginCtrl.getPermission()>=0) {
			main.setVisible(false);
			main = new ElectorBook();
			main.setVisible(true);
		}
	}

	public static void logRides() {
		if (loginCtrl.getPermission()>=0) {
			main.setVisible(false);
			main = new TransportManagementFrame();
			main.setVisible(true);
		}
	}

	public static void electorReports() {
		if (loginCtrl.getPermission()>=2) {
			main.setVisible(false);
			main = new ElectorJReport();
			main.setVisible(true);
		}
	}

	public static void systemManage() {
		if (loginCtrl.getPermission()>=4) {
			main.setVisible(false);
			main = new SystemManagementFrame();
			main.setVisible(true);
		}
	}

	public static void countVotes() {
		if (loginCtrl.getPermission()>=0) {
			main.setVisible(false);
			main = new BallotVoteCountManagement();
			main.setVisible(true);
		}
	}
	
	
	
	
	
	
	
	
	
	public static Vector<Vector<Object>> getRiders() {
		Vector<Vector<Object>> result = (new ElectorCtrl()).getRiders(); 	
		return result;
	}

	public static void setRide(int elector, String pickUp, String returnTime) {
		if (loginCtrl.getPermission()>=0) {
			(new ElectorCtrl()).setRide(elector, loginCtrl.getId(), pickUp, returnTime);
		}
	}
	public static void login(int id) {
		loginCtrl = new LoginCtrl(id);
		if (loginCtrl.getPermission()>=0) {
			electorBook();
		}
	}

	public static void setElectorTurnoutTime(int electorId) {
		(new ElectorCtrl()).electorTurnout(electorId);
	}

	public static void newMain(int branch, int manager, int deputy1, int deputy2) {
		if (loginCtrl.getPermission()>=4)
		{
			(new SystemCtrl()).newMain(branch, manager , deputy1 , deputy2);
		}
	}

	public static ArrayList<Integer> getMainBranches() {
		ArrayList<Integer> results = new ArrayList<Integer>();
		ArrayList<MainBranch> branches = (new SystemCtrl()).getMainBranches();
		for (MainBranch branch:branches) {
			results.add(branch.getBranchNum());
		}
		return results;
	}

	public static ArrayList<Integer> getSecondaryBranches() {
		ArrayList<Integer> results = new ArrayList<Integer>();
		ArrayList<SecondaryBranch> branches = (new SystemCtrl()).getSecondaryBranches();
		for (SecondaryBranch branch:branches) {
			results.add(branch.getBranchNum());
		}
		return results;
	}

	public static void setSecondary(int main, int secondary) {
		(new SystemCtrl()).setSecondary(main, secondary);
	}

	public static Vector<Vector<Object>> getTblMainBranch() {
		/*tblMainBranchColumnNames.add("Branch");
		tblMainBranchColumnNames.add("Manager ID");
		tblMainBranchColumnNames.add("Manager Name");
		tblMainBranchColumnNames.add("Manager Phone");
		tblMainBranchColumnNames.add("Deputy1 ID");
		tblMainBranchColumnNames.add("Deputy2 ID");*/
		ArrayList<MainBranch> branches = (new SystemCtrl()).getMainBranches();
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		for (MainBranch branch:branches) {
			Vector<Object> result = new Vector<Object>();
			result.add(branch.getBranchNum());
			result.add(branch.getManagerId());
			Elector manager = (new DbElectors()).getElector(branch.getManagerId());
			result.add(manager.getLastName()+" "+manager.getFirstName());
			result.add(manager.getPhoneNumber());
			result.add(branch.getDeputy1());
			result.add(branch.getDeputy2());
			results.add(result);
		}
		return results;
	}
	public static Vector<Vector<Object>> getTblSecondaryBranch() {
		/*tblSecondaryBranchColumnNames.add("MainBranch");
		tblSecondaryBranchColumnNames.add("Branch");
		tblSecondaryBranchColumnNames.add("Manager ID");
		tblSecondaryBranchColumnNames.add("Manager Name");
		tblSecondaryBranchColumnNames.add("Manager Phone");*/
		ArrayList<SecondaryBranch> branches = (new SystemCtrl()).getSecondaryBranches();
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		for (SecondaryBranch branch:branches) {
			Vector<Object> result = new Vector<Object>();
			result.add(branch.getMainBranchNum());
			result.add(branch.getBranchNum());
			result.add(branch.getManagerId());
			Elector manager = (new DbElectors()).getElector(branch.getManagerId());
			result.add(manager.getLastName()+" "+manager.getFirstName());
			result.add(manager.getPhoneNumber());
			results.add(result);
		}
		return results;
	}
	public static Vector<Vector<Object>> getTblEmployees() {
		/*tblEmployeeColumnNames.add("Branch");
		tblEmployeeColumnNames.add("ID");
		tblEmployeeColumnNames.add("Name");
		tblEmployeeColumnNames.add("Phone");*/
		ArrayList<Employee> employees = (new EmployeeCtrl()).getEmployees();
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		for (Employee employee:employees) {
			Vector<Object> result = new Vector<Object>();
			result.add(employee.getBranchNum());
			result.add(employee.getId());
			result.add(employee.getLastName()+" "+employee.getFirstName());
			result.add(employee.getPhoneNum());
			results.add(result);
		}
		return results;
	}

	public static Vector<Vector<Object>> getElectorsTable(){
		Vector<Vector<Object>> results  = new Vector<Vector<Object>>();
		DbElectors dbElectors = new DbElectors();
		ArrayList<Elector> electors = dbElectors.getElectors();
		for (Elector elector:electors) {
			Vector<Object> result = new Vector<Object>();
			result.add(elector.getBallotNum());
			result.add(elector.getId());
			result.add(elector.getLastName());
			result.add(elector.getFirstName());
			result.add(elector.getAddress());
			result.add(elector.getPhoneNumber());
			result.add(elector.getVoteTime());
			results.add(result);
		}
		return results;
	}

	public static String getElector(int electorId) {
		String result = null;
		Elector res = (new ElectorCtrl()).getElector(electorId);
		if (res!=null) {
			result = res.getId() + ": " + res.getLastName()+ " "+res.getFirstName()+ ",    Ballot: " + res.getBallotNum() + ", Serial: " + res.getSerialNum();
		}
		return result;
	}
}
