
// dependencies for Date & Time 
import java.time.LocalDate; // for date
import java.time.LocalTime; // for time



// start dependencies for properties file
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Task {
	// id unique pour chaque task
	public static int ID = 0;
	// path a sauvegarder les tâches
	public static String SAVE_PATH = "";
	// 
	public long id;
	public int importance = 5; // importance = 1..5 (default=5)
	public String 
		title , 
		description,
		status;
	/*
		!!! IMPORTANT !!!
		public Date sheduled , // data de rendez-vous 
	 	createAt; // date de création
	*/
	 public Task(String title, String description , String status , int importance){
	 	// increment Task.ID and generate the id
	 	Task.ID++;
	 	this.id = Task.ID;
	 	this.title = title;
	 	this.description = description;
	 	this.status = status;
	 	this.importance = importance;
	 }
	// mettre l'indice d'importance à 5
	 public Task(String title, String description , String status){
	 	Task.ID++;
	 	this.id = Task.ID;
	 	this.title = title;
	 	this.description = description;
	 	this.status = status;
	 	this.importance = 5; // default
	 }
	 // ajouter d'autres infos
	 /*public void setShedule(Date sheduleDate){
	 	// this.shedule = sheduleDate

	 }*/

	 // return a list of current time
	 public static int[] geturrentDate(){
	 	return new int[]{ 22,22,20222};
	 }
	//  pour avoir l'historique de tâches
	public static Task[] getTasksHistory(){
		return null;
	}

	 // sauvegarder la tâche
	 public void saveTask(String exportType , String filename){
	 	// verify that the task title or the description not empty
	 	if (this.title.equals("") || this.description.equals("")){
	 		System.out.println("ERROR : le titre et la description vide !!!");
	 	}

	 	// save as the type
	 	System.out.printf("[SAVE_TASK] : \n\t -'%s' \n\t- filetype : '%s'" , this.title, this.description);
	 	switch(exportType) {
	 		case "json":
	 			this.saveAsJSON(filename);
	 			break;
	 		case "html":
	 			this.saveAsHTML(filename);
	 			break;
	 		default :
	 			this.ToPropertiesFile();
	 			break;
	 	}
	 }
	 // les fonctions de sauvegarde

	// from Task object to File
	public void  saveAsJSON(String filename){
	}
	public void saveAsHTML(String filename){
		// il est mieu de sauvegarder le lien vers tous les tâches dans un serveur flask et templates en html

	}

	/* ====================   SAVE/LOAD  TASK AS/FROM .properties ============================ */
	public void ToPropertiesFile(){
		Properties prop = new Properties();
		try {

			// set variables
			prop.setProperty("id",this.id + "");
			prop.setProperty("title",this.title);
			prop.setProperty("description",this.description);
			prop.setProperty("status",this.status);
			prop.setProperty("importance",this.importance + "");
			prop.setProperty("createdAt",this.createdAt);
			prop.setProperty("hasDeadLine",this.hasDeadLine?"true":"false");
			prop.setProperty("deleted",this.DELETED?"true":"false");
			prop.setProperty("canBeRestored",this.canBeRestored ? "true":"false");
			prop.setProperty("taskDeadLine",this.taskDeadLine);
			prop.setProperty("tag-count",this.tags.length + "");

			// loop over tags to create property key : tag-*=Sport where * is the index of that tag
			for (int i = 0 ; i < this.tags.length;i++){
				prop.setProperty("tag-" + i , this.tags[i]);
			}
			prop.setProperty("color");
			prop.setProperty("subtask-count");
			String[] subtasks = null ; // get all subtasks

			// loop over tags to create property key : subtask-*-title or subtask-*-text , where * is the index of that tag
			for (int i = 0 ; i < this.subtasks.length;i++){
				prop.setProperty("subtask-"+ i + "-title", this.subtasks[i].title);
				prop.setProperty("subtask-" + i +"-text", this.subtasks[i].text);
			}

			// update file
			prop.store(new FileOutputStream(getSettingsFilePath()), null);
			/////// !! Save this action to log
		}
		catch(Exception a){
			System.out.println("Can't create settings.properties file ");
			a.printStackTrace();
		}
	}

}

/*
	use this method to write json object to a file : 
		- mapper.writeValue(new File("user.json"), userObject);
*/