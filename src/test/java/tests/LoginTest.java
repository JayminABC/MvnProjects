package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import data.WalmartData;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	static LoginPage lp;
	static WalmartData dp;
	static WebDriverWait wait;
	
	public LoginTest() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	@BeforeMethod
	public void setup() throws IOException {
		openbrowser();
		openwalmart();
		lp = new LoginPage();
		dp = new WalmartData();
		
	}
	
	@AfterMethod
	public void tearDown() {
		closebrowser();
	}
	
	@Test
	public void WrongEmailTest() throws InterruptedException {
		lp.enteremail(dp.incorrectemail);
		lp.clickonsignin();
		Assert.assertEquals(dp.errmsg, lp.loginerr());
	}
	
	@Test
	public void wrongpasswordTest() throws InterruptedException {
		lp.enterpassword(dp.incorrectpassword);
		lp.clickonsignin();
		Assert.assertEquals(dp.errmsg, lp.loginerr());
	}
	
	@Test
	public void wrongEmailAndPasswordTest() throws InterruptedException {
		lp.enteremail(dp.incorrectemail);
		lp.enterpassword(dp.incorrectpassword);
		lp.clickonsignin();
		Assert.assertEquals(dp.errmsg, lp.loginerr());
	}
	
	@Test
	public static void rightEmailAndPassword() throws InterruptedException {
		lp.enteremail(dp.correctemail);
		lp.enterpassword(dp.correctpassword);
		lp.clickonsignin();
		wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'My account')]")));
		Assert.assertTrue(lp.deliverTO.isDisplayed());
		
	}
	
}
