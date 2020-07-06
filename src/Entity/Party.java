package Entity;

public class Party {
	private String noteLetters;
	private String partyName;
	private String notePicture;
	
	public Party(String noteLetters, String partyName, String notePicture) {
		super();
		this.noteLetters = noteLetters;
		this.partyName = partyName;
		this.notePicture = notePicture;
	}

	public String getNoteLetters() {
		return noteLetters;
	}

	public String getPartyName() {
		return partyName;
	}

	public String getNotePicture() {
		return notePicture;
	}
	
}
