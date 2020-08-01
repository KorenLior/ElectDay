package Entity;


public class MainBranch{
	private int deputy1, deputy2;
	private Branch me;
	public MainBranch(int branchNum, int  deputy1, int deputy2) {
		this.me = (new DbBranches()).getBranch(branchNum);
		this.deputy1 = deputy1;
		this.deputy2 = deputy2;
	}
	public int getBranchNum() {
		return me.getBranchNum();
	}
	public int getManagerId() {
		return me.getManagerId();
	}
	public int getDeputy1() {
		return deputy1;
	}
	public int getDeputy2() {
		return deputy2;
	}
}
