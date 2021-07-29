package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;
import data.WalmartData;

public class LoginPage extends BaseTest{
	WalmartData dp;
	
	//object repository or Page factory
	@FindBy(id = "username")
	public static WebElement email;
	@FindBy(id = "password")
	public static WebElement password;
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	public static WebElement signin;
	@FindBy(xpath="//span[contains(text(),'Please enter a valid email address or phone number')]")
	public static WebElement loginerr;
	@FindBy(xpath = "//span[contains(text(),'My account')]")
	public static WebElement deliverTO;

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);  //How will u initialize your Page Factory 
	}

	public void enteremail(String a){
		email.sendKeys(a);
	}
	
	public void enterpassword(String b) {
		password.sendKeys(b);
	}
	
	public void clickonsignin() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", signin);
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		signin.click();
	}
	
	public String loginerr() {
		String Actualerr = loginerr.getText();
		return Actualerr;
	}
			
}
