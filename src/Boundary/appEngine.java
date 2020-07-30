package Boundary;

import java.util.Vector;

import Control.ElectorCtrl;
import Control.LoginCtrl;

public class appEngine {

	private static LoginCtrl loginCtrl;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Vector<Vector<Object>> getRiders() {
		Vector<Vector<Object>> result = (new ElectorCtrl()).getRiders(); 	
		return null;
	}

	public static void setRide(int elector, String pickUp, String returnTime) {
		if (loginCtrl.getPermission()>=0) {
			ElectorCtrl.setRide(elector, loginCtrl.getId(), pickUp, returnTime);
		}
	}
	public static void login(int id) {
		loginCtrl = new LoginCtrl(id);
	}

}
