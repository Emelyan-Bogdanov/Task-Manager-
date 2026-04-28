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
		String json = new JsonBuilder()
			// create the JSON form 
			  .add("ID", this.id)
			  .add("TITLE", this.title)
			  .add("DESCRIPTION",this.description)
			  .add("SHEDULE",this.this.sheduled)
			  .add("CREATED_AT",this.createAt)
			  .add("STATUS",this.status)
			  .add("IMPORTANCE",this.importance)
			  .toJson();
			// convert json object to file
		try (FileWriter file = new FileWriter(filename)) {
			file.write(json);
			System.out.printf("[SUCCESS] : Fichier %s sauvegardé avec succés" , filename);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.printf("ERROR : Impossible de sauvegarder : %s ",filename);
		}

	}
	public void saveAsHTML(String filename){
		// il est mieu de sauvegarder le lien vers tous les tâches dans un serveur flask et templates en html

	}
	public void saveAsProperties(String filename){

	}
	// from File to Task object
	public Task readTaskFile(String filename){ // we dont took the path because its defined as PATH
        Properties prop = new Properties();
        InputStream input = null;
		
        try {

            input = new FileInputStream(self.path); // incase of errror => try split filename and path

            // load a properties file
			// String title, String description , String status , int importance 
			Task loadedTask = new Task(
					prop.getProperty("TITLE"),
					prop.getProperty("DESCRIPTION"),
					prop.getProperty("STATUS"),
					prop.getProperty("IMPORTANCE"));
			loadedTask.sheduled = prop.getProperty("SHEDULE");
			loadedTask.createAt = prop.getProperty("CREATED_AT");
			loadedTask.id = prop.getProperty("ID");

            return loadedTask;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
/*
use this method to write json object to a file : 
	- mapper.writeValue(new File("user.json"), userObject);
*/