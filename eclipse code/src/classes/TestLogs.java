public class TestLogs {
	public static void main (String[] args){
		final LoggerTest log = new LoggerTest();

		// logInfo
		// logWarning
		// logSever
		
		log.maxLogFileSize = 1;
		// try to make a lot of logs
		for(int i = 0 ; i < 12000 ; i++){
			log.logInfo(i + " this is a log test");
		}
	}
}