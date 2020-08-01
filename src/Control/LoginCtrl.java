package Control;

import java.util.ArrayList;

import Entity.DbBranches;
import Entity.DbEmployee;
import Entity.DbSystem;
import Entity.SecondaryBranch;
import Entity.SystemInfo;
import Entity.Employee;
import Entity.MainBranch;

public class LoginCtrl {
	private Employee me = null;
	private int permission = -1;
	public LoginCtrl(int id) {
		super();
		try {
			this.me = (new DbEmployee()).getEmployee(id);
			System.out.println(me.getLastName()+ me.getFirstName());
		}
		catch(Exception e) {
			System.out.println("Login Failed");
		}
		setPermission();
		System.out.println("Permission = "+getPermission());
	}
	private void setPermission() {
		if (me == null) {
			permission = -1;
			return;
		}
		if (me!=null) {
			permission = 0;
		}
		ArrayList<SecondaryBranch> secBranches = (new DbBranches()).getSecondary();
		for (SecondaryBranch branch:secBranches) {
			if (me.getId() == branch.getManagerId()) {
				permission = 1;
				break;
			}
		}
		ArrayList<MainBranch> mainBranches = (new DbBranches()).getMains();
		for (MainBranch branch:mainBranches) {
			if ((me.getId() == branch.getDeputy1()) || (me.getId() == branch.getDeputy2())) {
				permission = 2;
			}
			if (me.getId() == branch.getManagerId()) {
				permission = 3;
				break;
			}
		}
		SystemInfo systemInfo = (new DbSystem()).getSystem();
		if (me.getId() == systemInfo.getManagerId()) {
			permission = 4;
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
