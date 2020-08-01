package Entity;

import java.sql.Date;
import java.sql.Time;

public class Elector {

	int id, ballotNum, serialNum;
	private Time voteTime;
	private String firstName, lastName, address;
	private String phoneNumber;
	private String status, gender;
	private Date birthDate;
	int assDriverId;
	String assRideTime;
	String preferenceParty;
	public Elector(int id, int ballotNum, int serialNum, String firstName, 
			String lastName, String address, String phoneNumber, String status, String gender, Time votingTime, Date birthDate, int assDriverId, String assRideTime, String preferenceParty) {
		super();
		this.id = id;
		this.ballotNum = ballotNum;
		this.serialNum = serialNum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.gender = gender;
		this.birthDate = birthDate;
		this.voteTime = votingTime;
		this.assDriverId = assDriverId;
		this.assRideTime = assRideTime;
		this.preferenceParty = preferenceParty;
	}
	

	public int getAssDriverId() {
		return assDriverId;
	}


	public String getAssRideTime() {
		return assRideTime;
	}


	public String getPreferenceParty() {
		return preferenceParty;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return id;
	}
	public int getBallotNum() {
		return ballotNum;
	}
	public int getSerialNum() {
		return serialNum;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "Elector [id=" + id + ", ballotNum=" + ballotNum + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]/n/r[Address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	public String getGender() {
		return gender;
	}
	public String getStatus() {
		return status;
	}
	public String getBirthDate() {
		return birthDate.toString();
	}

	public Time getVoteTime() {
		return voteTime;
	}
	

}
