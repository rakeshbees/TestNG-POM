package com.qa.goibibo;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.util.testutil;

public class GoogleCaseTest extends testutil {
	

	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rakesh/Downloads/chromedriver");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	@Test()
	public void GoogleLogo()
	{
		boolean b=driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
	}
	@Test()
	public void GoogleTitle() {
		String Str= driver.getTitle();
		System.out.println(Str);
		Assert.assertEquals(Str, "Google");
	}
	@Test()
	public void MailLinkTest()
	{
		boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
		
	}
	
	@AfterMethod()
	public void TearDown(ITestResult result) 
	{
		if(ITestResult.FAILURE==result.getStatus());
		testutil.CaptureScreenshot(driver, result.getName());
		driver.quit();
		
	}
	

	

}
