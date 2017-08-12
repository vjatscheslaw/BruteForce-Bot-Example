package www.Bruteforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WebDriverTest {

	WebDriver chromeDriver = null;
	WebDriver geckoDriver = null;

	/*
	 * Download Chromedriver from here
	 * https://chromedriver.storage.googleapis.com/114.0.5735.90/
	 * chromedriver_linux64.zip or this folder
	 * https://chromedriver.storage.googleapis.com/114.0.5735.90 may contain package
	 * for your OS
	 * 
	 * Download Geckodriver from here
	 * https://github.com/mozilla/geckodriver/releases/download/v0.33.0/geckodriver-
	 * v0.33.0-linux64.tar.gz or search for a newer version/suitable binaries for
	 * your OS here https://github.com/mozilla/geckodriver/releases
	 */

	@BeforeClass
	public static void setUpClass() {
//        System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
//        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		chromeDriver = new ChromeDriver();
		geckoDriver = new FirefoxDriver();
	}

	@After
	public void tearDown() {
		try {
			if (chromeDriver != null)
				chromeDriver.quit();
		} catch (Exception e) {
			fail("не удалось выйти из Chrome драйвера");
		} finally {
			try {
				if (chromeDriver != null)
					chromeDriver.quit();
			} catch (Exception e) {
				fail("не удалось выйти из Chrome драйвера");
			}
		}

		try {
			if (geckoDriver != null)
				geckoDriver.quit();
		} catch (Exception e) {
			fail("не удалось закрыть ресурс Firefox драйвера");
		} finally {
			try {
				if (geckoDriver != null)
					geckoDriver.quit();
			} catch (Exception e) {
				e.printStackTrace();
				fail("не удалось выйти из Chrome драйвера");
			}
		}
	}

	@Test
	public void testGoogleSearchBoxFindWithChromeDriver() {

		CompletableFuture<WebDriver> cfwd = CompletableFuture.<WebDriver>completedFuture(chromeDriver);
		CompletableFuture<WebElement> googleSearchBoxCF = cfwd.thenApply(drv -> {
			drv.get("http://www.google.com/xhtml");
			return drv;
		}).thenApply(drv -> drv.findElement(By.name("q")));

		WebElement googleSearchBox = null;
		try {
			googleSearchBox = googleSearchBoxCF.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		assertNotNull(googleSearchBox);
		assertEquals(googleSearchBox.isDisplayed(), true);

	}

	@Test
	public void testGoogleSearchBoxFindWithFirefoxDriver() {

		CompletableFuture<WebDriver> cfwd = CompletableFuture.<WebDriver>completedFuture(geckoDriver);
		CompletableFuture<WebElement> googleSearchBoxCF = cfwd.thenApply(drv -> {
			drv.get("http://www.google.com/xhtml");
			return drv;
		}).thenApply(drv -> drv.findElement(By.name("q")));

		WebElement googleSearchBox = null;
		try {
			googleSearchBox = googleSearchBoxCF.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		assertNotNull(googleSearchBox);
		assertEquals(googleSearchBox.isDisplayed(), true);

	}

	@Ignore
	@Test
	public void testRollshopTestPageUpWithFirefoxDriver() throws InterruptedException {
//		geckoDriver.navigate().to("http://www.rollshop.co.il/test.php");
//		Thread.sleep(2000); // Let the user actually see something!
//		WebElement searchBox = geckoDriver.findElement(By.name("code"));
//		assertEquals(searchBox.isDisplayed(), true);

	}

}
