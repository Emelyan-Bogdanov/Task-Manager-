# Architecture of the `Workspace`:
### its a folder that will store all informations : logs , task files ...

```markdown
/workspace :
	|__ Logs/ /* for every action happens : createNewTask , Error , Export,... */
		|_ log_1.txt
		|_ ..

	|__ TrashBin/     /* for deleted tasks */
		|_ deleted/   //  tâches supprimés(not restored)
		|_ to_restore // tâches qui peuvent être restaurés
	
	|__ Reminder/
		|_ reminder_*.json // * represents the id
		|_ ..

	|__ Ids/  /* contient les ids  to prevents duplication of same id*/
		|_ all_ids.json // contains last id used in tasks, reminders...
	|__ Settings // store all app settings (paths , logs ...)
		|_ app_settings.properties

```
# Fonctionnalité de l'utilisateur : 

```java

`TaskManager` :
	+ createTask()
	+ updateTask()
	+ deleteTask()
	+ restoreTask()
	+ setImportance()
	~ getHistory()
__________
`UserIterface`:
	+ addTask()
	+ deleteTask()
	+ editTask()
	+ viewHistory() -> _void_ // from TaskManager.getHistory() api
	+ setReminder() -> _void_ // edit the reminder
	+ importTasks() -> Task[] // list of tasks
	+ exportTasks()
__________
`Logger` :
	// the number of logger files should be equal to the number of levels (each level logs should be in its own  file)
	+ setLoggerPath() // to make debugging much easier
	+ setLevel(){"info","error","warning","history"}
	+ updateLogger() // 
__________
`ReminderBgService`: // reminder that always runs on background
	+ addReminder(Task task) -> _void_ // add new reminder to check for , as a background service
__________
`Tools` : // static tools for everyone
	~ TaskToJson(Task task)
```

# Structure of  classes : 

```java
`Task` : 
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
	+ subtasks : SubTask(obj)[] ; /* subTask is a list of subTask objects */
__________
`DeletedTask` (extends => Task) :
	+ DELETED : boolean (True)
	+ canBeRestored : boolean(True)
__________
`SubTask` :
	+ id
	+ text 
	+ checked : boolean(default=False)
__________
`Config` :
	~ SETTINGS_PATH : String // path where to save all these settings below , in a file .properties
	~ WORKSPACE_PATH : String (default="C:/users/../Programs/workspace_for_taskmanager")
	~ ALLOWED_EXT : String[]{"json","xml"}(default="json"); // json is the easiest to store
	~ JSON_TASKS_PATH : String 
	~ XML_TASK_PATH : String 
	~ LOGS_PATH : String 
	~ DELETED_PATH : String // path of tasks whose deleted permanently
	~ TO_RESTORE_PATH : String // path of deleted tasks , but can be restaured
	~ PATH_OF_IDS : String // path of json file where checkpoints of all entities id are stores
```