

public class Tools {
	public static void TaskToJson(Task task){
		// get informations to save
			/*
				+ id : long
				+ title : String
				+ text : String
				+ status : String{"new"..."completed"}(default="new")
				+ importance : int{1..5}(default=3)
				+ createdAt : Date.now()
				+ hasDeadLine : boolean(default=True)
				+ DELETED = False
				+ canBeRestored = True; // even if not delete , just to be fine
				+ taskDeadLine : Date // will be value input <select>
				+ tags : String[] // category of this Task
				+ color : String // this variable should be used in css
				+ subtasks : SubTask(obj)[] ; /* subTask is a list of subTask objects 
			*/

			long id = task.id;
			int importance = task.importance;
			String title = task.title;
			String text = task.text;
			String status = task.status;
			String[] tags = task.tags;
			String color = task.color;
			Date taskDeadLine = task.taskDeadLine;
			Date createdAt = task.createdAt;
			boolean hasDeadLine = task.hasDeadLine;
			boolean DELETED = task.DELETED;
			boolean canBeRestored = task.canBeRestored;
			subTask subtasks = task.subtasks;

		// save the task object to a file

	}
}