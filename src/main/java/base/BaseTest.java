package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilities.WebEventListener;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public BaseTest() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/prop.properties");
		prop = new Properties();
		prop.load(file);
	}
	
	public void openbrowser() throws IOException {
		String browser = prop.getProperty("browser");
		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver = e_driver;
	}
	
	public void openwalmart() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	public void closebrowser() {
		driver.close();
	}
	
	
}
