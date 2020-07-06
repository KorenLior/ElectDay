package Entity;


public class Branch {
	private int branchNum, managerId, transportRepId;
	public Branch(int branchNum, int managerId) {
		this.branchNum = branchNum;
		this.managerId = managerId;
	}
	public int getBranchNum() {
		return branchNum;
	}
	public int getManagerId() {
		return managerId;
	}
	

}
