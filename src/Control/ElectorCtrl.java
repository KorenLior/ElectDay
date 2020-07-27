package Control;

import Entity.DbElectors;

public class ElectorCtrl {
	public void electorTurnout(int electorId) {
		new DbElectors().turnout(electorId);
	}
}
