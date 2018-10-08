package com.qa.goibibo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandle {
	WebDriver driver;
	@BeforeMethod
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rakesh/Downloads/chromedriver");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void HandlePoupWindowTest()
	{
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		// Handling multiple windows
		Set<String> handles=driver.getWindowHandles();
		// Store in an iterator
		Iterator<String> it=handles.iterator();
		// move to next window parent
		String ParentWindow=it.next();
		System.out.println("parent window id" +ParentWindow);
		//move to next window child
		String ChildWindow=it.next();
		System.out.println("child window id" +ChildWindow);
		// switching window
		driver.switchTo().window(ChildWindow);
		System.out.println("child window popup tile" +driver.getTitle());
		driver.close();
		driver.switchTo().window(ParentWindow);
		System.out.println("parents window popup" +driver.getTitle());
	}
	@BeforeMethod
	public void TearDown()
	{
		driver.quit();
	}

}
