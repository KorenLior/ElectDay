package Entity;

public class SystemInfo {

	private String partyName;
	private int managerId;
	public SystemInfo(String partyName, int managerId) {
		this.partyName = partyName;
		this.managerId = managerId;
	}
	public String getPartyName() {
		return partyName;
	}
	public int getManagerId() {
		return managerId;
	}
}
