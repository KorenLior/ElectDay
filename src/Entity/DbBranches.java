package Entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbBranches {
	
	
	public ArrayList<Branch> getBranches() {
		 ArrayList<Branch> results = new ArrayList<Branch>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_BRANCHES);

		 ResultSet rs = stmt.executeQuery()) {
			
		 while (rs.next()) {
			 int i = 1;
			 Branch result = null;
			 try
			 {
				 int branchNum = rs.getInt(i++);
				 int managerId = rs.getInt(i++);
				 result = new Branch(branchNum, managerId);
				 
			 }
			 catch (Exception e) {
				// TODO: handle exception
				 System.out.println("Branch readDb Failure");
			 }
			 results.add(result);
		 }
		 } catch (SQLException e) {
			 System.out.println("getBranches() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	public Branch getBranch(int branchNum) {
		ArrayList<Branch> branches = getBranches();
		for (Branch branch:branches) {
			if (branch.getBranchNum()==branchNum) {
				return branch;
			}
		}
		return null;
	}
	public void addBranch(int branchNum, int managerId) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
				 
			CallableStatement stmt = conn.prepareCall(ConstsElectDayDB.SQL_INS_BRANCH)) {	
			int i = 1;
			
			stmt.setInt(i++, branchNum);
			stmt.setInt(i++, managerId);
			stmt.executeUpdate();
			}
			catch (SQLException e) {
			System.out.println("insertBranch Failure2");
			e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("insertBranch ClassNotFound Failure2");
			e.printStackTrace();
		}
	}
	public void setMain(int branch, int deputy1, int deputy2) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
				 
			CallableStatement stmt = conn.prepareCall(ConstsElectDayDB.SQL_SET_MAIN)) {	
			int i = 1;
			
			stmt.setInt(i++, branch);
			stmt.setInt(i++, deputy1);
			stmt.setInt(i++, deputy2);
			stmt.executeUpdate();
			}
			catch (SQLException e) {
			System.out.println("insertBranch Failure2");
			e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("insertBranch ClassNotFound Failure2");
			e.printStackTrace();
		}
	}
	
	public ArrayList<MainBranch> getMains() {
		 ArrayList<MainBranch> results = new ArrayList<MainBranch>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_MAINBRANCHES);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;
		 MainBranch result = null;
		 try
		 {
			 result = new MainBranch(rs.getInt(i++), rs.getInt(i++), rs.getInt(i++));
		 }
		 catch (Exception e) {
			 System.out.println("MainBranch readDb Failure");
		 }
		 results.add(result);
		 }
		 } catch (SQLException e) {
			 System.out.println("getMainBranches() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	public ArrayList<SecondaryBranch> getSecondary() {
		 ArrayList<SecondaryBranch> results = new ArrayList<SecondaryBranch>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_SECONDARYBRANCHES);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;
		 SecondaryBranch result = null;
		 try
		 {
			 result = new SecondaryBranch(rs.getInt(i++), rs.getInt(i++));
			 
		 }
		 catch (Exception e) {
			 System.out.println("SecBranch readDb Failure");
		 }
		 results.add(result);
		 }
		 } catch (SQLException e) {
			 System.out.println("getSecBranches() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	public void setSecondary(int main, int secondary) {
		try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsElectDayDB.SQL_SET_SECONDARYBRANCH)) {
		int i = 1;

		stmt.setInt(i++, main);
		stmt.setInt(i++, secondary);

		 stmt.executeUpdate();
		 } catch (SQLException e) {
			 System.out.println("DbSetSecondary Failure");
		 e.printStackTrace();
		 }
		 } catch (ClassNotFoundException e) {
			 System.out.println("DbSetSecondary ClassNotFound Failure2");
		 e.printStackTrace();
		 }
	}
}
