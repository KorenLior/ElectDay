package Entity;

public class Rider {
	private Elector elector;
	private int from, until;
	private String ballotAddress, callDate;
	private Ride ride;
	public Rider(Elector elector, int from, int until, String ballotAddress, String callDate, Ride ride) {
		super();
		this.elector = elector;
		this.from = from;
		this.until = until;
		this.ballotAddress = ballotAddress;
		this.callDate = callDate;
		this.ride = ride;
		
	}
	public Elector getElector() {
		return elector;
	}
	public int getFrom() {
		return from;
	}
	public int getUntil() {
		return until;
	}
	public String getBallotAddress() {
		return ballotAddress;
	}
	public String getCallDate() {
		return callDate;
	}
	public Ride getRide() {
		return ride;
	}
}
