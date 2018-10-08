package com.qa.goibibo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.util.testutil;

public class GoibiboTest extends testutil {
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rakesh/Downloads/chromedriver");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	@Test
	public void loginpageTest()
	{
		driver.findElement(By.id("get_sign_in")).click();
		//testutil.CaptureScreenshot(driver, null);
		driver.findElement(By.xpath("//input[@id='authMobile']")).sendKeys("9853836233");
		driver.findElement(By.id("mobileSubmitBtn")).click();
		
		
	}
	
    @AfterMethod 
    public void TearDown(ITestResult result)
    {
    	//Failed Screenshots 
    	if(ITestResult.FAILURE ==result.getStatus())
    	{
    		testutil.CaptureScreenshot(driver, result.getName());
    	}
    	
    	driver.quit();
    }
}
