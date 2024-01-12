package com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FirstTestNGClass {
	
	WebDriver d;
  @Test //default annotation is testng
  public void f() {
	  System.out.println("in test method");
  }
  @Parameters({"us","pw"})
  @BeforeMethod
  public void beforeMethod(String us, String pw) throws InterruptedException {
	 d.findElement(By.xpath("//input[@id='username']")).sendKeys(us);
	 d.findElement(By.xpath("//input[@id='password']")).sendKeys(pw);
	
	 if(us.equals("student") && pw.equals("Password123"))	 
	 {
		 d.findElement(By.xpath("//button[@id='submit']")).click();
     }
	 else
	 { 
		 Thread.sleep(2000);
		 d.findElement(By.xpath("//input[@id='username']")).clear();		 
	 	 d.findElement(By.xpath("//input[@id='password']")).clear();
	 	 Thread.sleep(2000);
	 	 d.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		 d.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		 d.findElement(By.xpath("//button[@id='submit']")).click();
	 }	 
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("in after method");
  }

  @BeforeClass
  public void beforeClass() {
	  ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("120");
		d = new ChromeDriver(co);
		d.manage().window().maximize();
		d.get("https://practicetestautomation.com/practice-test-login/");
		
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("in AFTER CLASS");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("in BEFORE TEST");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("in AFTER TEST");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\CDAC\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("in AFTER SUITE");
  }

}
