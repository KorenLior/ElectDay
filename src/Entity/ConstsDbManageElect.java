package Entity;

import java.net.URLDecoder;

public class ConstsDbManageElect {
	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	public static final String SQL_SEL_BRANCHES = "SELECT * FROM TblBranch";
	public static String SQL_SEL_ELECTOR = "SELECT * FROM TblElector";
	public static String SQL_SEL_ELECTOR_BALLOT = "SELECT * FROM TblElector WHERE BallotNum=";
	public static String SQL_SEL_ELECTOR_ID = "SELECT * FROM TblElector WHERE ID=";
	public static final String SQL_SEL_EMPLOYEES = "SELECT * FROM TblEmployee";
	public static final String SQL_SEL_EMPLOYEES_BRANCH = "SELECT * FROM TblEmployee WHERE BranchNum=";
	public static final String SQL_INS_ELECTORINFO =  "{ call QRYNEWELECTORINFO(?,?,?,?,?,?,?,?,?,?) }";
	public static final String SQL_SEL_SYSTEM = "SELECT * FROM TblSystem";
	public static final String SQL_UPDATE_ELECTOR_PHONE =  "{ call QryUpdateElectorPhone(?,?) }";
	public static final String SQL_UPDATE_ELECTOR_RIDE =  "{ call QryUpdateElectorRide(?,?,?) }";
	public static final String SQL_SEL_DAYPOSITIONS_BRANCH1 = "SELECT TblElectionDayPosition.JobID, TblElectionDayPosition.StartHour, TblElectionDayPosition.EndHour, TblElectionDayPosition.Role, TblElectionDayPosition.BallotNum, TblElectionDayPosition.EmpID1, TblElectionDayPosition.EmpID2\r\n" + 
			"FROM TblEmployee RIGHT JOIN TblElectionDayPosition ON TblEmployee.ID = TblElectionDayPosition.EmpID1\r\n" + 
			"WHERE (((TblEmployee.BranchNum)=";
	public static final String SQL_SEL_DAYPOSITIONS_BRANCH2 = "))\r\n" + 
			"GROUP BY TblElectionDayPosition.JobID, TblElectionDayPosition.StartHour, TblElectionDayPosition.EndHour, TblElectionDayPosition.Role, TblElectionDayPosition.BallotNum, TblElectionDayPosition.EmpID1, TblElectionDayPosition.EmpID2;";
	public static final String SQL_SEL_DAYPOSITIONS = "SELECT * FROM TblElectionDayPosition";
	public static final String SQL_INS_DAYPOSITION =  "{ call QryNewElectionDayPosition(?,?,?,?,?,?) }";
	public static final String SQL_INS_EMPLOYEE =  "{ call QryNewEmployee(?,?,?,?,?,?,?,?) }";
	public static final String SQL_SEL_DAYPOSITIONS_EMPLOYEE1 = "SELECT * FROM TblElectionDayPosition WHERE EmpID1=";
	public static final String SQL_SEL_DAYPOSITIONS_EMPLOYEE2 = "SELECT * FROM TblElectionDayPosition WHERE EmpID2=";
	public static final String SQL_SEL_EMPLOYEE = "SELECT * FROM TblEmployee WHERE ID=";
	public static final String SQL_SEL_DRIVERS_BRANCH = "{ call QryDrivers_ByBranch(?) }";
	public static final String SQL_SEL_DRIVERS = "{ call QryDrivers }";
	public static final String SQL_SEL_UNASSRIDERS = "SELECT TblElector.ID, TblElector.FirstName, TblElector.LastName, TblElector.PhoneNum, TblElectorInfo.CallDate, TblElectorInfo.PickupFrom, TblElectorInfo.PickupTo, TblElector.Address, TblBallot.Address, TblElector.BallotNum\r\n" + 
			"FROM (TblBallot INNER JOIN TblElector ON TblBallot.BallotNum = TblElector.BallotNum) INNER JOIN TblElectorInfo ON TblElector.ID = TblElectorInfo.ElectorID\r\n" + 
			"WHERE (((TblElector.RideIDAssigned)=0 Or (TblElector.RideIDAssigned) Is Null) AND ((TblElectorInfo.NeedRide)=Yes))\r\n" + 
			"GROUP BY TblElector.ID, TblElector.FirstName, TblElector.LastName, TblElector.PhoneNum, TblElectorInfo.CallDate, TblElectorInfo.PickupFrom, TblElectorInfo.PickupTo, TblElector.Address, TblBallot.Address, TblElector.BallotNum, TblBallot.BranchNum;\r\n" + 
			"";
	public static final String SQL_SEL_UNASSRIDERS_BRANCH1 ="SELECT TblElector.ID, TblElector.FirstName, TblElector.LastName, TblElector.PhoneNum, TblElectorInfo.CallDate, TblElectorInfo.PickupFrom, TblElectorInfo.PickupTo, TblElector.Address, TblBallot.Address, TblElector.BallotNum\r\n" + 
			"FROM (TblElector INNER JOIN TblBallot ON TblElector.BallotNum = TblBallot.BallotNum) INNER JOIN TblElectorInfo ON TblElector.ID = TblElectorInfo.ElectorID\r\n" + 
			"WHERE (((TblElector.RideIDAssigned)=0 Or (TblElector.RideIDAssigned) Is Null) AND ((TblElectorInfo.NeedRide)=Yes) AND ((TblBallot.BranchNum)=";
	public static final String SQL_SEL_UNASSRIDERS_BRANCH2 ="))\r\n" + 
			"GROUP BY TblElector.ID, TblElector.FirstName, TblElector.LastName, TblElector.PhoneNum, TblElectorInfo.CallDate, TblElectorInfo.PickupFrom, TblElectorInfo.PickupTo, TblElector.Address, TblBallot.Address, TblElector.BallotNum;";
	public static final String SQL_SEL_ASSRIDERS_BRANCH1 ="SELECT TblElector.RideIDAssigned, TblElector.RideHour, TblElector.ID, TblElector.LastName, TblElector.FirstName, TblElector.PhoneNum, TblElector.Address, TblBallot.Address, TblElector.BallotNum, TblElectionDayPosition.EmpID1\r\n" + 
			"FROM TblElectionDayPosition RIGHT JOIN (TblBallot INNER JOIN TblElector ON TblBallot.BallotNum = TblElector.BallotNum) ON TblElectionDayPosition.JobID = TblElector.RideIDAssigned\r\n" + 
			"WHERE (((TblElector.RideIDAssigned) Is Not Null Or (TblElector.RideIDAssigned)<>0) AND ((TblBallot.BranchNum)=";
	public static final String SQL_SEL_ASSRIDERS_BRANCH2 ="))\r\n" + 
			"GROUP BY TblElector.RideIDAssigned, TblElector.RideHour, TblElector.ID, TblElector.LastName, TblElector.FirstName, TblElector.PhoneNum, TblElector.Address, TblBallot.Address, TblElector.BallotNum, TblElectionDayPosition.EmpID1;";
	public static final String SQL_SEL_ASSRIDERS = "SELECT TblElector.RideIDAssigned, TblElector.RideHour, TblElector.ID, TblElector.LastName, TblElector.FirstName, TblElector.PhoneNum, TblElector.Address, TblBallot.Address, TblElector.BallotNum, TblElectionDayPosition.EmpID1, TblBallot.BranchNum\r\n" + 
			"FROM TblElectionDayPosition RIGHT JOIN (TblBallot INNER JOIN TblElector ON TblBallot.BallotNum = TblElector.BallotNum) ON TblElectionDayPosition.JobID = TblElector.RideIDAssigned\r\n" + 
			"WHERE (((TblElector.RideIDAssigned) Is Not Null Or (TblElector.RideIDAssigned)<>0))\r\n" + 
			"GROUP BY TblElector.RideIDAssigned, TblElector.RideHour, TblElector.ID, TblElector.LastName, TblElector.FirstName, TblElector.PhoneNum, TblElector.Address, TblBallot.Address, TblElector.BallotNum, TblElectionDayPosition.EmpID1, TblBallot.BranchNum;\r\n" + 
			"";
	public static final String SQL_SEL_BALLOTS = "SELECT * FROM TblBallot";
	public static final String SQL_INS_BRANCH = "{ call QryNewBranch(?,?,?) }";
	public static final String SQL_UPDATE_BALLOT =  "{ call QryUpdateBallot(?,?) }";
	private static String getDBPath() {
		 try {
		String path = ConstsDbManageElect.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decoded = URLDecoder.decode(path, "UTF-8");
		if (decoded.contains(".jar")) {
		 decoded = decoded.substring(0, decoded.lastIndexOf('/'));
		return decoded + "/database/DbManageElect.accdb";
		} else {
		 decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
		return decoded + "src/entity/DbManageElect.accdb";
		}
		} catch (Exception e) {
		 e.printStackTrace();
		 return null;
		}
	}
}
