

public class TaskToProperty {

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
			for (int i = 0 ; i < task.tags.length;i++){
				prop.setProperty("tag" + i , task.tags[i]);
			}
			prop.setProperty("color");
			prop.setProperty("subtask-count");
			String[] subtasks = null ; // get all subtasks

			for (int i = 0 ; i < subtasks.length;i++){
				prop.setProperty("subtask-"+ i + "-title",subtasks[i].title);
				prop.setProperty("subtask-" + i +"-text",subtasks[i].text);
			}

			// update file
			prop.store(new FileOutputStream(getSettingsFilePath()), null);
			// save action to log

		}
		catch(Exception a){
			System.out.println("Can't create settings.properties file ");
			a.printStackTrace();
		}

	}
}