package Control;

import java.util.Vector;

import Entity.DbElectors;

public class ElectorCtrl {
	public void electorTurnout(int electorId) {
		new DbElectors().turnout(electorId);
	}

	public Vector<Vector<Object>> getRiders() {
		Vector<Vector<Object>> result = (new DbElectors()).getRidersTable();
		return result;
	}

	public static void setRide(int elector, int id, String pickUp, String returnTime) {
		(new DbElectors()).setRide(elector, id, pickUp, returnTime);
	}
}
