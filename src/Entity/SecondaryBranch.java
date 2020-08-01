package Entity;


public class SecondaryBranch{
	private int mainBranch;
	private Branch me;
	public SecondaryBranch(int branchNum, int  mainBranch) {
		this.me = (new DbBranches()).getBranch(branchNum);
		this.mainBranch = mainBranch;
	}
	public int getBranchNum() {
		return me.getBranchNum();
	}
	public int getManagerId() {
		return me.getManagerId();
	}
	public int getMainBranchNum() {
		return mainBranch;
	}
}
