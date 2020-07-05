package Control;

import java.util.ArrayList;

import Entity.DbGetPartyList;
import Entity.Party;

public class PartiesCTRL {

	public ArrayList<String> getParties(){
		ArrayList<String> results = new ArrayList<String>();
		DbGetPartyList dbGetPartyList = new DbGetPartyList();
		ArrayList<Party> parties = dbGetPartyList.getParties();
		for (Party party : parties)
		{
			results.add(party.getNoteLetters());
		} 
		return results;
	}
}
