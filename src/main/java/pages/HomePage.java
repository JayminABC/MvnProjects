package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import data.WalmartData;

public class HomePage extends BaseTest {
	WalmartData dp;
	//@FindBy(xpath="//input[@placeholder='What are you looking for?']")
	@FindBy(xpath ="//div[@class='css-1kxonj9 e1xoeh2i0']//input[@type='text']")
	public static WebElement searching;
	
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void Searching(String c) {
		searching.sendKeys(c);
	}

}
