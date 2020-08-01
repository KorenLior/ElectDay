package Entity;


public class Branch {
	private int branchNum, managerId;
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
