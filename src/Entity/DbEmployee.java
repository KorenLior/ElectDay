package Entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbEmployee {


	public ArrayList<Employee> getEmployees(int branchNum) {
		 ArrayList<Employee> results = new ArrayList<Employee>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_EMPLOYEES_BRANCH+branchNum);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;

		 results.add(new Employee(rs.getInt(i++), rs.getInt(i++)));
		 }
		 } catch (SQLException e) {
			 System.out.print("Employee Read Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			 System.out.print("Employee Class Not Found");
		 e.printStackTrace();
		}

		return results;
	}
	
	public ArrayList<Employee> getEmployees() {
		 ArrayList<Employee> results = new ArrayList<Employee>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_EMPLOYEES);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;

		 results.add(new Employee(rs.getInt(i++), rs.getInt(i++)));
		 }
		 } catch (SQLException e) {
			 System.out.print("Employee Read Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			 System.out.print("Employee Class Not Found");
		 e.printStackTrace();
		}

		return results;
	}
	
	
	public Employee getEmployee(int id) {
		 Employee result = null;
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_EMPLOYEE_ID+id);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;

		 result = new Employee(rs.getInt(i++), rs.getInt(i++));
		 }
		 } catch (SQLException e) {
			 System.out.print("Employee Read Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			 System.out.print("Employee Class Not Found");
		 e.printStackTrace();
		}

		return result;
	}
	
}
