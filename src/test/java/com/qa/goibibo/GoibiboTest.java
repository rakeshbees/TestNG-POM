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
		
		System.setProperty("webdriver.chrome.driver", "⁨/Users/rakesh/eclipse-workspace/jumbo/Goibibo/src/main/java/chromedriver⁩");
		driver =new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void loginpageTest()
	{
		driver.findElement(By.id("get_sign_in")).click();
		testutil.CaptureScreenshot(driver, null);
		driver.findElement(By.id("authMobile")).sendKeys("9853836233");
		driver.findElement(By.id("mobileSubmitBtn")).click();
		
		
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
