
import java.io.File;
import java.io.FileNotFoundException;





public class Config {
	public static String 
	ROOT_PATH = "/workspace",
	SETTINGS_PATH = "/Settings",
	ALLOWED_EXT[] = {"json","xml"},
	JSON_TASKS_PATH = "/tasks/json",
	XML_TASK_PATH = "/tasks/xml",
	LOGS_PATH = "/logs",
	DELETED_PATH = "/TrashBin/deleted",
	RESTORE_PATH = "/TrashBin/to_restore",
	REMINDER_PATH = "/Reminder",
	PATH_OF_IDS = "/Ids",
	DATABASE_PATH = "/tasks/database";

	// functions
	public static String getRootPath(){
		return getStartUpFolder() + ROOT_PATH;
	}
	public static String getSettingsPath(){
		return Config.getRootPath() + Config.SETTINGS_PATH;
	}
	public static String getRestorePath(){
		return Config.getRootPath() + Config.RESTORE_PATH;
	}
	public static String getDeletePath(){
		return Config.getRootPath() + Config.DELETED_PATH;
	}

	public static String getXmlPath(){
		return Config.getRootPath() + Config.XML_TASK_PATH;
	}
	public static String getJsonPath(){
		return Config.getRootPath() + Config.JSON_TASKS_PATH;
	}
	public static String getIdsPath(){
		return Config.getRootPath() + Config.PATH_OF_IDS;
	}
	public static String getReminderPath(){
		return Config.getRootPath() + Config.REMINDER_PATH;
	}
	public static String getDatabasePath(){
		return getRootPath() + Config.DATABASE_PATH;
	}

	// get user paths
	public static String getUserHomePath(){
		try {
			File file = new File(System.getProperty("user.home")); 
			return file.getAbsolutePath();
		}
		catch (Exception e) {
			System.out.println("=============================================== Error Path doesn't exists : dekstop path");
			return null;
		}
	}

	public static String getStartUpFolder(){
		return Config.getUserHomePath() + "/AppData/Roaming/Microsoft/Windows/Start Menu/Programs";
	}
	public static String getDesktopPath(){
		return Config.getUserHomePath() + "/Desktop";
	}

	///////// main function 
	public static void main(String[] args){
		Config.createWorkspaceProjectStructure();
	}

	// create files if not exists + save settings
	public static void createWorkspaceFolder(){
		createFolder(Config.getRootPath());
		System.out.println("[ INFO ] Workspace Folder created !");
	}
	public static void createWorkspaceProjectStructure(){
		// define the map of all 'paths'
		String[] map = new String[]{
			getRootPath(),
			getSettingsPath(),
			getRestorePath(),
			getXmlPath(),
			getJsonPath(),
			getDeletePath(),
			getIdsPath(),
			getReminderPath(),
			getDatabasePath()
		};
		for(String folderPath : map){
			Config.createFolder(folderPath);
		}
	}
	public static void createFolder(String path){
		try {
			new File(path).mkdirs();
			System.out.printf("[ INFO ] Folder %s created successfully \n",path);
		}catch(Exception e){
			System.out.printf("[ ERROR ] createFolder() can't create Folder in path : %s \n" , path);
		}
	}
}