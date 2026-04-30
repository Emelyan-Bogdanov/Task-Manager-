
import java.io.File;
import java.io.FileNotFoundException;


public class Config {
	public static String 
	ROOT_PATH = Config.getRootPath(),
	SETTINGS_PATH = "/Settings",
	ALLOWED_EXT[] = {"json","xml"},
	JSON_TASKS_PATH = "/tasks/json",
	XML_TASK_PATH = "/tasks/xml",
	LOGS_PATH = "/logs",
	DELETED_PATH = "/TrashBin/deleted",
	RESTORE_PATH = "/TrashBin/to_restore",
	PATH_OF_IDS = "/Ids";

	// functions
	public static String getRootPath(){
		return getStartUpFolder();
	}
	public static String getSettingsPath(){
		return Config.getRootPath() + Config.SETTINGS_PATH;
	}
	public static String getRestorePath(){
		return Config.getRootPath() + Config.RESTORE_PATH;
	}
	public static String getXmlPath(){
		return Config.getRootPath() + Config.XML_TASK_PATH;
	}
	public static String getJsonPath(){
		return Config.getRootPath() + Config.JSON_TASKS_PATH;
	}
	public static String getDeletePath(){
		return Config.getRootPath() + Config.DELETED_PATH;
	}
	public static String getStartUpFolder(){
		return Config.getUserHomePath() + "/AppData/Roaming/Microsoft/Windows/Start Menu/Programs";
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
	public static String getDesktopPath(){
		return Config.getUserHomePath() + "/Desktop";
	}
	public static void main(String[] args){
		System.out.println(Config.getDeletePath());
	}
}