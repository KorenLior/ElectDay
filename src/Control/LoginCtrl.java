package Control;

import Entity.DbGetEmployeeList;
import Entity.Employee;

public class LoginCtrl {
	Employee me = null;
	int permission = -1;
	public LoginCtrl(int id) {
		super();
		try {
			this.me = (new DbGetEmployeeList()).getEmployee(id);
		}
		catch(Exception e) {
			System.out.println("Login Failed");
		}
		setPermission();
	}
	private void setPermission() {
		// TODO Auto-generated method stub
		if (me!=null) {
			permission = 0;
		}
	}
	public int getId() {
		if (me != null) {
			return me.getId();
		}
		return -1;
	}
	public int getPermission() {
		return permission;
	}

}
