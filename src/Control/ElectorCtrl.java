package Control;

import java.util.Vector;

import Entity.DbElectors;
import Entity.Elector;

public class ElectorCtrl {
	public void electorTurnout(int electorId) {
		new DbElectors().turnout(electorId);
	}

	public Vector<Vector<Object>> getRiders() {
		Vector<Vector<Object>> results = (new DbElectors()).getRidersTable();
		return results;
	}

	public void setRide(int elector, int id, String pickUp, String returnTime) {
		(new DbElectors()).setRide(elector, id, pickUp, returnTime);
	}

	public Elector getElector(int electorId) {
		Elector result = (new DbElectors()).getElector(electorId);
		return result;
	}
}
