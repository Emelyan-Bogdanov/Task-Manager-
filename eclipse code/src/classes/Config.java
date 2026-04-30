
import java.io.File;
import java.io.FileNotFoundException;




// start dependencies for properties file
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


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
	DATABASE_PATH = "/tasks/database",
	SETTINGS_FILE = "/settings.properties",
	LOG_FILE = "/logs.log";

	// functions
	public static String getRootPath(){
		return getStartUpFolder() + ROOT_PATH;
	}
	public static String getSettingsPath(){
		return Config.getRootPath() + Config.SETTINGS_PATH;
	}
	public static String getSettingsFilePath(){
		return getSettingsPath() + Config.SETTINGS_FILE;
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
	public static String getLogsPath(){
		return getRootPath() + Config.LOGS_PATH;
	}

	/* ========================== TO UPDATE SETTINGS ========================= */
	public static void updateRootPath(String newRootPath) {
        ROOT_PATH = newRootPath;
    }

    // Method to update SETTINGS_PATH
    public static void updateSettingsPath(String newSettingsPath) {
        SETTINGS_PATH = newSettingsPath;
    }

    // Method to update ALLOWED_EXT array
    public static void updateAllowedExt(String[] newAllowedExt) {
        ALLOWED_EXT = newAllowedExt;
    }

    // Method to update JSON_TASKS_PATH
    public static void updateJsonTasksPath(String newJsonTasksPath) {
        JSON_TASKS_PATH = newJsonTasksPath;
    }

    // Method to update XML_TASK_PATH
    public static void updateXmlTaskPath(String newXmlTaskPath) {
        XML_TASK_PATH = newXmlTaskPath;
    }

    // Method to update LOGS_PATH
    public static void updateLogsPath(String newLogsPath) {
        LOGS_PATH = newLogsPath;
    }

    // Method to update DELETED_PATH
    public static void updateDeletedPath(String newDeletedPath) {
        DELETED_PATH = newDeletedPath;
    }

    // Method to update RESTORE_PATH
    public static void updateRestorePath(String newRestorePath) {
        RESTORE_PATH = newRestorePath;
    }

    // Method to update REMINDER_PATH
    public static void updateReminderPath(String newReminderPath) {
        REMINDER_PATH = newReminderPath;
    }

    // Method to update PATH_OF_IDS
    public static void updatePathOfIds(String newPathOfIds) {
        PATH_OF_IDS = newPathOfIds;
    }

    // Method to update DATABASE_PATH
    public static void updateDatabasePath(String newDatabasePath) {
        DATABASE_PATH = newDatabasePath;
    }

    // Method to update SETTINGS_FILE
    public static void updateSettingsFile(String newSettingsFile) {
        SETTINGS_FILE = newSettingsFile;
    }
    /* ================================= GET USER PATHS ================================= */

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


	 /* ========================= CREATE ALL FOLDERS FOR THE PROJECT  ======================= */
	// create files if not exists + save settings
	public static void createWorkspaceFolder(){
		createFolder(Config.getRootPath());
		System.out.println("[ INFO ] Workspace Folder created !");
	}

	public static void createWorkspaceProjectStructure(){
		// define the map of all 'paths'
		String[] map = new String[]{
			getRootPath(),
			getSettingsPath(), // settings
			getRestorePath(), // restore
			getXmlPath(), // xml
			getJsonPath(), // json
			getDeletePath(), // deleted
			getIdsPath(), // ids
			getReminderPath(), // reminders
			getDatabasePath(), // database
			getLogsPath(), // wich logs are stored in
		};
		for(String folderPath : map){
			Config.createFolder(folderPath);
		}
		saveSettingsAtFile();
	}
	public static void createFolder(String path){
		try {
			new File(path).mkdirs();
			System.out.printf("[ INFO ] Folder %s created successfully \n",path);
		}catch(Exception e){
			System.out.printf("[ ERROR ] createFolder() can't create Folder in path : %s \n" , path);
		}
	}

	/* =============================== SAVE/LOAD SETTINGS FILE ============================ */
	// save settings at .properties file
	public static void saveSettingsAtFile(){
		Properties prop = new Properties();
		try {
   			
			// set variables
			prop.setProperty("SETTINGS_PATH",getSettingsPath());
			prop.setProperty("ALLOWED_EXT",ALLOWED_EXT[0] + "," + ALLOWED_EXT[1]); // use split(',') when loaded
			prop.setProperty("RESTORE_PATH",getRootPath());
			prop.setProperty("DELETED_PATH",getDeletePath());
			prop.setProperty("XML_TASK_PATH",getXmlPath());
			prop.setProperty("LOGS_PATH",getLogsPath());
			prop.setProperty("REMINDER_PATH",getReminderPath());
			prop.setProperty("DATABASE_PATH",getDatabasePath());
			prop.setProperty("SETTINGS_FILE",getSettingsPath());

			// update file
			prop.store(new FileOutputStream(getSettingsFilePath()), null);
			System.out.printf("Settings saved at %s",getSettingsFilePath());

		}
		catch(Exception a){
			System.out.println("Can't create settings.properties file ");
			a.printStackTrace();
		}

	}
	// load settings from .properties file
	public static void loadSettingsFromFile(){
		Properties prop = new Properties();
		try (FileInputStream inputStream = new FileInputStream(getSettingsFilePath())) {
	        prop.load(inputStream);
			// set variables
			Config.SETTINGS_PATH = prop.getProperty("SETTINGS_PATH");
			Config.ALLOWED_EXT = prop.getProperty("ALLOWED_EXT").split(","); // by default stored to : "ext1,ext2,..."
			Config.RESTORE_PATH = prop.getProperty("RESTORE_PATH");
			Config.DELETED_PATH = prop.getProperty("DELETED_PATH");
			Config.XML_TASK_PATH = prop.getProperty("XML_TASK_PATH");
			Config.LOGS_PATH = prop.getProperty("LOGS_PATH");
			Config.REMINDER_PATH = prop.getProperty("REMINDER_PATH");
			Config.DATABASE_PATH = prop.getProperty("DATABASE_PATH");
			Config.SETTINGS_FILE = prop.getProperty("SETTINGS_FILE");

			// update file
			prop.store(new FileOutputStream(getSettingsFilePath()), null);
			System.out.printf("Settings saved at %s",getSettingsFilePath());

		}
		catch(Exception a){
			System.out.println("Can't create settings.properties file ");
			a.printStackTrace();
		}
	}

	/* =============================== MANAGE LOGS ======================== */





	// main function 
	public static void main(String[] args){
		Config.createWorkspaceProjectStructure();

		// start test logs

	}
}
