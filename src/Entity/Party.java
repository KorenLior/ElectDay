package Entity;

public class Party {
	private String NoteLetters;
	private String PartyName;
	private String NotePicture;
	public Party(String noteLetters, String partyName, String notePicture) {
		super();
		NoteLetters = noteLetters;
		PartyName = partyName;
		NotePicture = notePicture;
	}
	public String getNoteLetters() {
		return NoteLetters;
	}
	public String getPartyName() {
		return PartyName;
	}
	public String getNotePicture() {
		return NotePicture;
	}
}
