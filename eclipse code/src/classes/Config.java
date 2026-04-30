
public class Config {
	public static String 
	ROOT_PATH = Config.getRootPath(),
	SETTINGS_PATH = "/Settings";
	WORKSPACE_PATH = "", // user/appData/...
	ALLOWED_EXT[] = {"json","xml"},
	JSON_TASKS_PATH = "/tasks/json",
	XML_TASK_PATH = "/tasks/xml",
	LOGS_PATH = "/logs",
	DELETED_PATH = "/TrashBin/deleted",
	RESTORE_PATH = "/TrashBin/to_restore",
	PATH_OF_IDS = "/Ids";

	// functions
	public static String getRootPath(){
		return ".../workspace";
	}
	public static String getSettingsPath(){
		return getRootPath() + Config.SETTINGS_PATH;
	}
	public static String getRestorePath(){
		return getRootPath() + Config.RESTORE_PATH;
	}
	public static String getXmlPath(){
		return getRootPath() + Config.XML_TASK_PATH;
	}
	public static String getJsonPath(){
		return getRootPath() + Config.JSON_TASKS_PATH;
	}
	public static String getDeletePath(){
		return return getRootPath() + Config.DELETED_PATH;
	}

}