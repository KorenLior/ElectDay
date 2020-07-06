package Entity;

public class Ballot {
	private int ballotNum;
	private String CityName;
	private String CountCloseTime;
	private int branchNum;
	public Ballot(int ballotNum, String cityName, int branchNum, String countCloseTime) {
		super();
		this.ballotNum = ballotNum;
		CityName = cityName;
		CountCloseTime = countCloseTime;
		this.branchNum = branchNum;
	}
	public int getBallotNum() {
		return ballotNum;
	}
	public String getCityName() {
		return CityName;
	}
	public String getCountCloseTime() {
		return CountCloseTime;
	}
	public int getBranchNum() {
		return branchNum;
	}
}
