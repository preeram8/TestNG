package testngactivities;

import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class ClassActivity1 {
	
    WebDriver driver;
	
    
  @Test
  public void exampleTestCase() {
	  
      // Check the title of the page
		
      String title = driver.getTitle();
	
          
	
      //Print the title of the page
	
      System.out.println("Page title is: " + title);
	
          
	
          //Assertion for page title
	
      Assert.assertEquals("Training Support", title);
	
                  
	
      //Find the clickable link on the page and click it
	
      driver.findElement(By.tagName("a")).click();
	
                  
	
      //Print title of new page
	
      System.out.println("New page title is: " + driver.getTitle());
	
      
	
      Assert.assertEquals(driver.getTitle(), "About Training Support");
  }
  @BeforeMethod
  public void beforeMethod() {
      //Create a new instance of the Firefox driver
		
      driver = new FirefoxDriver();
	
      
	
      //Open browser
	
      driver.get("https://www.training-support.net");
	    
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
	  
  }

}
