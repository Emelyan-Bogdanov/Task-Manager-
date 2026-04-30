

public class SubTask {
	public int id;
	public String title;
	public boolean checked = False;
	public SubTask(String title){
		this.title = title;
	}
	public void setDone(){
		this.checked = True;
	}
	public void delete(){
		this.title = ""; // erase title
		this.checked = True; // set checked
	}
}