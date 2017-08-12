package www.Bruteforce;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.err;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ofPattern;

public class Logger {

	private PrintWriter outLog;	
	private DateTimeFormatter dtf;

	public Logger() {
		printWriterInit();
		dateFormatterInit();
	}

	private void dateFormatterInit() {
		try {
			this.dtf = ofPattern("yyyy/MM/dd HH:mm:ss");
		} catch (Exception e) {
			err.println("I couldn't create a Calendar ... ");
			
			this.dtf = null;
		}
	}

	private void printWriterInit() {
		try {
			File f = new File("log.txt");
			f.createNewFile();
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			this.outLog = new PrintWriter(bw);
		} catch (IOException ioe) {
			err.println("Could not create a log file ... ");
			this.outLog = null;
		}
	}

	public void writeTheLogToFile(String logEntry) {		
		outLog.println(logEntry + " at " + dtf.format(now()));
		outLog.flush();
	}

}
