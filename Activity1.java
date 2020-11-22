package testngactivities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity1 {
	
	WebDriver driver;
	
	
  @Test
  public void CopyrightText() {
	 
	  //Activity3 - Print the first copyright text in the footer to the console
	  
	  WebElement Footer1 = driver.findElement(By.id("admin_options"));
	  System.out.println("The First copyright test from footer is " + Footer1.getText());
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
	  driver.get("http://alchemy.hguy.co/crm");
	  
  
  }
  
  @Test
  public void GetTitle() {
	  
	  //Activity1 - Read the title of the website and verify the text
	  
	  String title = driver.getTitle();
	  System.out.println("The title of the page is  " +  title);
	  Assert.assertEquals("SuiteCRM", title);
	 
  }

  @Test
  public void GetimageURL() {
	  
	  //Activity2 - Print the url of the header image to the console
	  
	  WebElement getimageurl = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
	  System.out.println("URL on the image is " + getimageurl.getAttribute("src"));
	  
	  
  }
  
  
  
      
  @Test
  public void login() {
	  //Activity 4 - Login to site
	  
	  WebElement username = driver.findElement(By.id("user_name"));
	  
	  WebElement password =  driver.findElement(By.id("username_password"));
	  username.sendKeys("admin");
	  password.sendKeys("pa$$w0rd");
	  driver.findElement(By.id("bigbutton")).click();
  }
  
   
  
  @AfterMethod
  public void afterMethod() {
	
	  driver.quit();
	
  }

}
