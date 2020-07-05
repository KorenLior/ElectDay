package Entity;
import java.net.URLDecoder;
public class ConstsDbParty {
	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	public static final String SQL_SEL_PARTY = "SELECT * FROM tblParty";
	public ConstsDbParty() {
		// TODO Auto-generated constructor stub
	}
	private static String getDBPath() {
		 try {
		String path = ConstsDbParty.class.getProtectionDomain().getCodeSource().getLocation().getPath();
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
