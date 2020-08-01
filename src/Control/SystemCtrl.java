package Control;

import java.util.ArrayList;

import Entity.Branch;
import Entity.DbBranches;
import Entity.DbEmployee;
import Entity.MainBranch;
import Entity.SecondaryBranch;

public class SystemCtrl {

	public void newMain(int branch, int manager, int deputy1, int deputy2) {
		if ((new DbBranches()).getBranch(branch) != null) {
			return;
		}
		if ( ((new DbEmployee()).getEmployee(manager) == null) || 
				((new DbEmployee()).getEmployee(deputy1) == null) || 
				((new DbEmployee()).getEmployee(deputy2) == null)) {
			return;
		}
		(new DbBranches()).addBranch(branch, manager);
		(new DbBranches()).setMain(branch, deputy1, deputy2);
	}
	
	public Branch getBranch(int branchNum) {
		Branch result = null;
		result = (new DbBranches()).getBranch(branchNum);
		return result;
	}
	public ArrayList<MainBranch> getMainBranches() {
		ArrayList<MainBranch> results = (new DbBranches()).getMains();
		return results;
	}

	public void setSecondary(int main, int secondary) {
		(new DbBranches()).setSecondary(main, secondary);
	}

	public ArrayList<SecondaryBranch> getSecondaryBranches() {
		ArrayList<SecondaryBranch> results = (new DbBranches()).getSecondary();
		return results;
	}
}
