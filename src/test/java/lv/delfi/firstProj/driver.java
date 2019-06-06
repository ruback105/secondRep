package lv.delfi.firstProj;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class driver {
	public static WebDriver driver = null;
	public static int exit = 0;	
	
	public static void driverChoose() {
		if(exit == 0) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\apusko.la\\Desktop\\testing\\geckodriver.exe");
			driver = new FirefoxDriver();
		} /*else if(exit == 1) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\apusko.la\\Desktop\\testing\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}*/ else if (exit == 1) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\apusko.la\\Desktop\\testing\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}
	
	public static void exit() throws InterruptedException, MalformedURLException {
		driver.close();
		exit++;
		if(exit<2) {
			AppTest.Test();
		} else {
			return;
		}
	}
}
