package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class JasperReportEntities {
	public JFrame compileElectorBallotReport() {
		{
			try {
				
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR)) {
	            	
	            	JasperPrint print = JasperFillManager.fillReport(
	            			getClass().getResourceAsStream("../Boundary/ManageElectorsBallot.jasper"),
	                        new HashMap<String, Object>(), conn);
	                JFrame frame = new JFrame("Elector Turnout By Ballot");
	                frame.getContentPane().add(new JRViewer(print));
	                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                frame.pack();
	                return frame;
	            } catch (SQLException | JRException | NullPointerException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			return null;
		}
	}
	public JFrame compileElectorCityReport() {
		{
			try {
				
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR)) {
	            	
	            	JasperPrint print = JasperFillManager.fillReport(
	            			getClass().getResourceAsStream("../Boundary/ManageElectorsCity.jasper"),
	                        new HashMap<String, Object>(), conn);
	                JFrame frame = new JFrame("Elector Turnout By City");
	                frame.getContentPane().add(new JRViewer(print));
	                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                frame.pack();
	                return frame;
	            } catch (SQLException | JRException | NullPointerException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			return null;
		}
	}
	public JFrame compileElectorNationalReport() {
		{
			try {
				
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR)) {
	            	
	            	JasperPrint print = JasperFillManager.fillReport(
	            			getClass().getResourceAsStream("../Boundary/ManageElectorsTotal.jasper"),
	                        new HashMap<String, Object>(), conn);
	                JFrame frame = new JFrame("National Elector Turnout");
	                frame.getContentPane().add(new JRViewer(print));
	                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                frame.pack();
	                return frame;
	            } catch (SQLException | JRException | NullPointerException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			return null;
		}
	}
	public JFrame compileVotesBallot() {
		{
			try {
				
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR)) {
	            	
	            	JasperPrint print = JasperFillManager.fillReport(
	            			getClass().getResourceAsStream("../Boundary/ManageVoteCount.jasper"),
	                        new HashMap<String, Object>(), conn);
	                JFrame frame = new JFrame("Vote Count by Ballot");
	                frame.getContentPane().add(new JRViewer(print));
	                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                frame.pack();
	                return frame;
	            } catch (SQLException | JRException | NullPointerException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			return null;
		}
	}
	public JFrame compileVotesCity() {
		{
			try {
				
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR)) {
	            	
	            	JasperPrint print = JasperFillManager.fillReport(
	            			getClass().getResourceAsStream("../Boundary/ManageVoteCountByCity.jasper"),
	                        new HashMap<String, Object>(), conn);
	                JFrame frame = new JFrame("Vote Count by City");
	                frame.getContentPane().add(new JRViewer(print));
	                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                frame.pack();
	                return frame;
	            } catch (SQLException | JRException | NullPointerException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			return null;
		}
	}
	public JFrame compileVotesNational() {
		{
			try {
				
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            try (Connection conn = DriverManager.getConnection(ConstsElectDayDB.CONN_STR)) {
	            	
	            	JasperPrint print = JasperFillManager.fillReport(
	            			getClass().getResourceAsStream("../Boundary/ManageVoteCountTotal.jasper"),
	                        new HashMap<String, Object>(), conn);
	                JFrame frame = new JFrame("National Vote Count");
	                frame.getContentPane().add(new JRViewer(print));
	                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                frame.pack();
	                return frame;
	            } catch (SQLException | JRException | NullPointerException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			return null;
		}
	}
}
