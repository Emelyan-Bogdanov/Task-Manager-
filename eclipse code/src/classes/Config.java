
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
	SETTINGS_FILE = "/settings.properties";

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
	public static void saveSettingsAtFile(){
		Properties prop = new Properties();
		try {
   			
   			InputStream propertiesInputStream =  Config.class.getClassLoader().getResourceAsStream("/Constants.properties");
            prop.load(propertiesInputStream);
			// set variables
			prop.setProperty("SETTINGS_PATH",getSettingsPath());
			prop.setProperty("ALLOWED_EXT",ALLOWED_EXT[0] + "," + ALLOWED_EXT[1]);
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
		///////// main function 
	public static void main(String[] args){
		Config.createWorkspaceProjectStructure();
	}
}