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

	 // return a list of current time
	 public static int[] geturrentDate(){
	 	return new int[]{ 22,22,20222};
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
	public void  saveAsJSON(String filename){
		String json = new JsonBuilder()
			  .add("ID", this.id)
			  .add("TITLE", this.title)
			  .add("DESCRIPTION",this.description)
			  .add("SHEDULE",this.this.sheduled)
			  .add("CREATED_AT",this.createAt)
			  .toJson();
	}
	public void saveAsHTML(String filename){

	}
	public void saveAsProperties(String filename){

	}
	public static
}
/*
use this method to write json object to a file : 
	- mapper.writeValue(new File("user.json"), userObject);
*/