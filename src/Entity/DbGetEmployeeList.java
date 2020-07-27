package Entity;
/*
 * @returns Employee List ArrayList<Employee>
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbGetEmployeeList {

	public DbGetEmployeeList() {
		// TODO Auto-generated constructor stub
	}

	
	public ArrayList<Employee> getEmployees() {
		 ArrayList<Employee> results = new ArrayList<Employee>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_EMPLOYEES);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
			 Employee res = readFromDb(rs);
			 results.add(res);
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
	public Employee getEmployee(int employeeId) {
		Employee result = null;
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 
		 try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR);
				 
		 PreparedStatement stmt = conn.prepareStatement(ConstsElectDayDB.SQL_SEL_EMPLOYEE_ID
				 + employeeId);

		 ResultSet rs = stmt.executeQuery()) {
			 while(rs.next()) {
				 result = readFromDb(rs);
			 }
			 } catch (SQLException e) {
				 System.out.println("Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}
		return result;
	}
	private Employee readFromDb(ResultSet rs) throws SQLException {
		 int i = 1;
		 int id;
		 int branchNum;
		 Employee result = null;
		 try {


		 id = rs.getInt(i++);
		 branchNum = rs.getInt(i++);
		 result = new Employee(id, branchNum);
		 }
		 catch (Exception e) {
			System.out.println("DbGetEmployee.readFromDd Failure");
		}
		 return result;
}
}
