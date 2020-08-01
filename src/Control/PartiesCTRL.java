package Control;

import java.util.ArrayList;

import Entity.DbParties;
import Entity.Party;

public class PartiesCTRL {

	public ArrayList<String> getParties(){
		ArrayList<String> results = new ArrayList<String>();
		DbParties dbGetPartyList = new DbParties();
		ArrayList<Party> parties = dbGetPartyList.getParties();
		for (Party party : parties)
		{
			results.add(party.getNoteLetters());
		} 
		return results;
	}
}
