package com.qa.goibibo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.util.testutil;



public class GmailTest extends testutil {

	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rakesh/Downloads/chromedriver");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/intl/en-GB/gmail/about/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	

	
	@Test
	public void GmailTest()
	{
	driver.findElement(By.xpath("html/body/nav/div/a[2]")).click();
	driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("rakeshlenka111@gmail.com");
	driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
	driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("9853273107@");
	driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
	}
	@Test
	public void GmailFailTest()
	{driver.findElement(By.xpath("html/body/nav/div/a[2]")).click();
	driver.findElement(By.xpath(".//*[@id='identifierId']"));
	driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
	//For Checking The Error Message 
	String Actual =driver.findElement(By.xpath(".//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]/div[2]")).getText();
	String Expected ="Enter an email or phone number";
	//Verify Using Assert Type-1 By getTEst
	//Assert.assertEquals(Actual, Expected);
	//Verify Using Assert Type-2 by GetATTribute
	Assert.assertTrue(Actual.contains("Enter an email or phone number"));
	System.out.println("Test Complited");
	//driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));
	//driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
	}
	@AfterMethod
	public void TearDown(ITestResult result)
	{
		if(ITestResult.FAILURE ==result.getStatus())
    	{
    		testutil.CaptureScreenshot(driver, result.getName());
    	}
    	
		driver.quit();
	}
}
