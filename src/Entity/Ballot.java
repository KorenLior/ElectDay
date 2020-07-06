package Entity;

public class Ballot {
	private int ballotNum;
	private String cityName;
	private String countCloseTime;
	private int branchNum;
	public Ballot(int ballotNum, String cityName, int branchNum, String countCloseTime) {
		super();
		this.ballotNum = ballotNum;
		this.cityName = cityName;
		this.countCloseTime = countCloseTime;
		this.branchNum = branchNum;
	}
	public int getBallotNum() {
		return ballotNum;
	}
	public String getCityName() {
		return cityName;
	}
	public String getCountCloseTime() {
		return countCloseTime;
	}
	public int getBranchNum() {
		return branchNum;
	}
	
	
	public void setCountCloseTime(String countCloseTime) {
		this.countCloseTime = countCloseTime;
	}
	@Override
	public String toString() {
		return "Ballot [ballotNum=" + ballotNum + ", CityName=" + cityName + ", CountCloseTime=" + countCloseTime
				+ "]";
	}
	
}
