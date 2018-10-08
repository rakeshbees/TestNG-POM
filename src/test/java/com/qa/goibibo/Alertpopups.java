package com.qa.goibibo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alertpopups {
	WebDriver driver;
	@BeforeMethod
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rakesh/Downloads/chromedriver");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	@Test
	public void HandleAlertTest()
	{
		//driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input")).click();
		Alert alert=driver.switchTo().alert(); // switching to alert window 
		System.out.println(alert.getText());// get the text/error message 
		alert.accept();// to accept 
		alert.dismiss();//to cancel
        String text = alert.getText();
		
		if(text.equals("Please enter a valid user name")){
			System.out.println("correct alert messg");
		}
		else{
			System.out.println("in-correct alert messg");
		}

	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	

}
