package model;

public class notesBean {
	
	private String userName;
	private String noteTitle;
	private String noteClass;
	private String noteDate;
	private String noteContent;
	
	public notesBean(String userName, String noteTitle, String noteClass, String noteDate, String noteContent) {
		super();
		this.userName = userName;
		this.noteTitle = noteTitle;
		this.noteClass = noteClass;
		this.noteDate = noteDate;
		this.noteContent = noteContent;
	}
	
	public notesBean(){
		super();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteClass() {
		return noteClass;
	}
	public void setNoteClass(String noteClass) {
		this.noteClass = noteClass;
	}
	public String getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(String noteDate) {
		this.noteDate = noteDate;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	
	
}
