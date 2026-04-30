public class Task {
	// id unique pour chaque task
	public static ID = 0;
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
	 public void setShedule(Date sheduleDate){
	 	// this.shedule = sheduleDate

	 }

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
	 		System.out.println("ERROR : le titre et la description vide !!!")
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
	 			this.saveAsProperties(filename);
	 			break;
	 	}
	 }
	 // les fonctions de sauvegarde

	// from Task object to File
	public void  saveAsJSON(String filename){
		json.add("ID", this.id);
			  json.add("TITLE", this.title);
			  json.add("DESCRIPTION",this.description);
			  json.add("SHEDULE",this.this.sheduled);
			  json.add("CREATED_AT",this.createAt);
			  json.add("STATUS",this.status);
			  json.add("IMPORTANCE",this.importance);
			  json.addLast();
			  json.toJson();

			// save to file
		try (FileWriter file = new FileWriter(filename)) {
			file.write(json.toJson());
			System.out.printf("[SUCCESS] : Fichier %s sauvegardé avec succés" , filename);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.printf("ERROR : Impossible de sauvegarder : %s ",filename);
		}

	}
	public void saveAsHTML(String filename){
		// il est mieu de sauvegarder le lien vers tous les tâches dans un serveur flask et templates en html

	}

	/* ====================   SAVE/LOAD  TASK AS/FROM .properties ============================ */
	public static void TaskToProperties(Task task){
		Properties prop = new Properties();
		try {

			// set variables
			prop.setProperty("id",task.id);
			prop.setProperty("title",task.title);
			prop.setProperty("text",task.text);
			prop.setProperty("description",task.description);
			prop.setProperty("status",task.status);
			prop.setProperty("importance",task.importance + "");
			prop.setProperty("createdAt",task.createdAt);
			prop.setProperty("hasDeadLine",task.hasDeadLine?"true":"false");
			prop.setProperty("deleted",task.DELETED?"true":"false");
			prop.setProperty("canBeRestored",task.canBeRestored ? "true":"false");
			prop.setProperty("taskDeadLine",task.taskDeadLine);
			prop.setProperty("tag-count",task.tags.length + "");

			// loop over tags to create property key : tag-*=Sport where * is the index of that tag
			for (int i = 0 ; i < task.tags.length;i++){
				prop.setProperty("tag-" + i , task.tags[i]);
			}
			prop.setProperty("color");
			prop.setProperty("subtask-count");
			String[] subtasks = null ; // get all subtasks

			// loop over tags to create property key : subtask-*-title or subtask-*-text , where * is the index of that tag
			for (int i = 0 ; i < subtasks.length;i++){
				prop.setProperty("subtask-"+ i + "-title",subtasks[i].title);
				prop.setProperty("subtask-" + i +"-text",subtasks[i].text);
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