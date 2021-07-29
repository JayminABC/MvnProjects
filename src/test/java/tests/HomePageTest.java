package tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import data.WalmartData;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {
	static WalmartData dp;
	static HomePage hp;
	static LoginTest lt;
	public HomePageTest() throws IOException {
		super();
		//PageFactory.initElements(driver, this);
	}
	
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		lt = new LoginTest();
		
		lt.setup();
		lt.rightEmailAndPassword();
	}
	
	@AfterMethod
	public void teardown() {
		closebrowser();
		
	}
	
	@Test
	public void Searchofcooker() throws InterruptedException, IOException {
		Thread.sleep(1000);
		hp = new HomePage();
		dp = new WalmartData();
		
		hp.Searching(dp.search);
		Thread.sleep(1000);
	}
}
