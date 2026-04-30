

// start dependencies for logging functions
import java.util.logging.Level;
import java.util.logging.Logger;

// start dependencies for logging save/load to a file
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;




public class LoggerTest {
	public final Logger logger = Logger.getLogger(Config.class.getName());
	FileHandler fileHandler = null;
	public int maxLogFileSize = 200, nLogs = 5;
	public String filename = Config.getLogsPath();
	public LoggerTest(){
		setUpLogginFile();
	}
	public LoggerTest(String filename){
		this.setUpLogginFile();
		this.filename = Config.getLogsPath() + "/" + filename;
		System.out.println("logger saved at " + this.filename);
	}
	public void logInfo(String message){
		logger.log(Level.INFO, message);
	}
	public void logWarning(String message){
		logger.log(Level.WARNING, message);
	}
	public void logSever(String message){
		logger.log(Level.SEVERE, message);
	}

	// setup logger file handler
	public void setUpLogginFile(){
		// save to file
        try {
        		fileHandler = new FileHandler(this.filename, maxLogFileSize * 1024 * 1024,nLogs, true);
            /*
				NOTE : 
					- maxLogFileSize => the max size of a log
							if a log attempts the max size => create new log file and use it
					- nLogs => max log files to attempt before deleting old ones
            */
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.severe("Failed to set up file handler");
        }
        System.out.println("logger saved at " + this.filename);
	}
}