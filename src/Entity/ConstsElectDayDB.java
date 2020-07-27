package Entity;

import java.net.URLDecoder;

public class ConstsElectDayDB {
	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	public static final String SQL_SEL_PARTY = "SELECT * FROM tblParty";
	public static final String SQL_SEL_BRANCHES = "SELECT * FROM tblBranch";
	public static final String SQL_SEL_EMPLOYEES = "SELECT * FROM tblEmployee";
	public static String SQL_SEL_EMPLOYEE_ID = "SELECT * FROM tblEmployee WHERE ID=";
	public static final String SQL_SEL_BALLOTS = "SELECT * FROM tblBallot";
	public static String SQL_SEL_BALLOTS_BALLOTNUM = "SELECT * FROM tblBallot WHERE BallotNum=";
	public static final String SQL_INS_VOTE =  "{ call QRYNEWVOTE(?,?,?,?) }";
	public static final String SQL_CLOSE_BALLOT =  "{ call QRY_CLOSE_BALLOT(?,?) }";
	public static String SQL_SEL_ELECTOR_BALLOT = "SELECT * FROM tblElector WHERE BallotNum=";
	public static String SQL_SEL_ELECTOR_ID = "SELECT * FROM tblElector WHERE ID=";
	public static String SQL_ELECTOR_VOTE = "{ call QRY_ELECTOR_VOTE(?,?) }";
	public ConstsElectDayDB() {
	}
	private static String getDBPath() {
		 try {
		String path = ConstsElectDayDB.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decoded = URLDecoder.decode(path, "UTF-8");
		if (decoded.contains(".jar")) {
		 decoded = decoded.substring(0, decoded.lastIndexOf('/'));
		return decoded + "/database/ElectDayDB.accdb";
		} else {
		 decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
		return decoded + "src/Entity/ElectDayDB.accdb";
		}
		} catch (Exception e) {
		 e.printStackTrace();
		 return null;
		}
	}

}
